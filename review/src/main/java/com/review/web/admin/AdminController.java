package com.review.web.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.review.web.util.Messenger;

@RestController
@RequestMapping("/member")
public class AdminController {
	@Autowired AdminService memberService;
	
	@PostMapping("/join")
	public Messenger join(@RequestBody Admin member) {
		int count = memberService.count();
		memberService.join(member);
		return (memberService.count()==count+1)? Messenger.SUCCESS:Messenger.FAIL;
	}
	
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody Admin member) {
		Map<String, Object> returnMap = new HashMap<>();
		Admin joinedMember = memberService.login(member);
		if(joinedMember!=null) {
			returnMap.put("member", joinedMember);
			returnMap.put("messenger", Messenger.SUCCESS);
		}else {
			returnMap.put("messenger", Messenger.FAIL);
		}
		return returnMap;
	}
	
	@GetMapping("/memberList")
	public List<Admin> memberList(){
		return memberService.readFile();
	}
	
	@GetMapping("/detail/{userid}")
	public Admin detail(@PathVariable String userid) {
		return memberService.detail(userid);
	}
	
	@PostMapping("/idchek")
	public Messenger idchek(@RequestBody String userid) {
		return (memberService.check(userid))? Messenger.FAIL:Messenger.SUCCESS ;
	}
	
	@PutMapping("/update")
	public Messenger update(@RequestBody Admin member) {
		return (memberService.update(member))? Messenger.SUCCESS:Messenger.FAIL;
	}
	
	@DeleteMapping("/delete")
	public Messenger delete(@RequestBody Admin member) {
		return (memberService.delete(member)) ? Messenger.SUCCESS:Messenger.FAIL;
	}
	 
}
