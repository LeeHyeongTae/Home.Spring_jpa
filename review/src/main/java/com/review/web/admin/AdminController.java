package com.review.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		adminService.saveFile(admin);
		return Messenger.SUCCESS;
	}
	
	@GetMapping("/idCheck/{userid}")
	public Messenger idCheck(@PathVariable String userid) {
		return (adminService.idCheck(userid))?Messenger.중복_ID_없음:Messenger.ID_중복;
	}
}
