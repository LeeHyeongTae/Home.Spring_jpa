package com.review.web.user;

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
@RequestMapping("/user")
public class UserController {
	@Autowired UserService userService;
	
	@PostMapping("/join")
	public Messenger join(User user) {
		userService.add(user);
		return Messenger.SUCCESS;
	}
	
	@GetMapping("/list")
	public List<User> list(){
		return userService.findAll();
	}
	
	@GetMapping("{userid}")
	public User detail(@PathVariable String userid) {
		return userService.findOne(userid);
	}
	
	@PutMapping("{userid}")
	public Messenger put(@RequestBody User user) {
		userService.modify(user);
		return Messenger.SUCCESS;
	}
	
	@DeleteMapping("[userid}")
	public Messenger remove(@RequestBody User user) {
		userService.remove(user);
		return Messenger.SUCCESS;
	}
}