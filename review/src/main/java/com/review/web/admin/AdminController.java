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

@RestController
@RequestMapping("/admins")
public class AdminController {
	@Autowired AdminService adminService;
	
	@PostMapping("")
	public Messenger post(@RequestBody Admin admin) {
		
		return (adminService.register(admin)) ? Messenger.SUCCESS:Messenger.FAIL;
	}
	
	@GetMapping("")
	public List<Admin> list(){
		return adminService.findAll();
	}
	
	@GetMapping("/{employNumber}")
	public Admin detail(@PathVariable String employNumber) {
		return adminService.findOne(employNumber);
	}
	
	@PutMapping("/{employNumber}")
	public Messenger put(@RequestBody Admin admin) {
		
		return (adminService.modify(admin)) ? Messenger.SUCCESS:Messenger.FAIL;
	}
	
	@DeleteMapping("/{employNumber}")
	public Messenger delete(@RequestBody Admin admin) {
			
		return (adminService.remove(admin)) ? Messenger.SUCCESS:Messenger.FAIL;
	}
}
