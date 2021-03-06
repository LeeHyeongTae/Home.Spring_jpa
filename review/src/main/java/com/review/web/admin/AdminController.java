package com.review.web.admin;

import java.util.List;

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
//di commit
@RestController
@RequestMapping("/admins")
public class AdminController {
	@Autowired AdminService adminService;
	@Autowired AdminDao adminDao;
	
	@PostMapping("/register")
	public Messenger register(@RequestBody Admin admin) {
		adminService.register(admin);
		return Messenger.SUCCESS;
	}
	
	@PostMapping("/login")
	public Messenger login(@RequestBody Admin admin) {
		adminService.login(admin);
		return Messenger.SUCCESS;
	}
	@GetMapping("")
	public List<Admin> list(){
		return adminService.findAll();
	}
	
	@GetMapping("{employNumber}")
	public Admin detail(@PathVariable String admin) {	
		return adminService.findOne(admin);
	}
	
	@PutMapping("{employNumber}")
	public Messenger update(@RequestBody Admin admin) {
		adminService.modify(admin);
		return Messenger.SUCCESS;
	}
	
	@DeleteMapping("{employNumber}")
	public Messenger remove(@PathVariable Admin admin) {
		adminService.remove(admin);
		return Messenger.SUCCESS;
	}
	
}
