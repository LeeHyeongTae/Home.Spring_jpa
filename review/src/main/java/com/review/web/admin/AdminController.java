package com.review.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	public Messenger add(@RequestBody Admin member) {
		int current = memberService.count();
		String s = "";
		memberService.add(member);
		return (memberService.count() == (current+1))? Messenger.SUCCESS : Messenger.FAIL;
	}
	@PostMapping("/login")
	public Messenger login(@RequestBody Admin member) {
		return (memberService.login(member))? Messenger.SUCCESS : Messenger.FAIL;
	}
	@GetMapping("/list")
	public Admin[] list() {
		Admin[] members = new Admin[5];
		return members;
	}
	
	@GetMapping("/detail")
	public Admin detail(@RequestBody Admin member) {
		Admin returnMember = new Admin();
		return returnMember;
	}
	@GetMapping("/count")
	public int count() {
		int count = 0;
		return count;
	}
	@PutMapping("/update")
	public Admin update(@RequestBody Admin member) {
		Admin returnMember = new Admin();
		return returnMember;
	}
	@DeleteMapping("/delete")
	public Admin delete(@RequestBody Admin member) {
		Admin returnMember = new Admin();
		return returnMember;
	}
}
