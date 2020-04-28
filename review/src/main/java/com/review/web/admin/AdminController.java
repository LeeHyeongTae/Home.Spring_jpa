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
@RequestMapping("/admin")
public class AdminController {
	@Autowired AdminService adminService;
	
	@PostMapping("/join")
	public Messenger join(@RequestBody Admin admin) {
		int count = adminService.count();
		adminService.join(admin);
		return (adminService.count()==count+1)? Messenger.SUCCESS:Messenger.FAIL;
	}
	
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody Admin admin) {
		Map<String, Object> returnMap = new HashMap<>();
		Admin joinedadmin = adminService.login(admin);
		if(joinedadmin!=null) {
			returnMap.put("admin", joinedadmin);
			returnMap.put("messenger", Messenger.SUCCESS);
		}else {
			returnMap.put("messenger", Messenger.FAIL);
		}
		return returnMap;
	}
	
	@GetMapping("/adminList")
	public List<Admin> adminList(){
		return adminService.readFile();
	}
	
	@GetMapping("/detail/{userid}")
	public Admin detail(@PathVariable String userid) {
		return adminService.detail(userid);
	}
	
	@PostMapping("/idchek")
	public Messenger idchek(@RequestBody String userid) {
		return (adminService.check(userid))? Messenger.FAIL:Messenger.SUCCESS ;
	}
	
	@PutMapping("/update")
	public Messenger update(@RequestBody Admin admin) {
		return (adminService.update(admin))? Messenger.SUCCESS:Messenger.FAIL;
	}
	
	@DeleteMapping("/delete")
	public Messenger delete(@RequestBody Admin admin) {
		return (adminService.delete(admin)) ? Messenger.SUCCESS:Messenger.FAIL;
	}
	 
}
