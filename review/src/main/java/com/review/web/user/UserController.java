package com.review.web.user;

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
@RequestMapping("/user")
public class UserController {
	@Autowired UserService userService;
	
	@PostMapping("/join")
	public Messenger join(@RequestBody User user) {
		int count = userService.count();
		return (userService.count()==count+1)?Messenger.SUCCESS:Messenger.FAIL;
	}
	
	@GetMapping("/list")
	public List<User> list(){
		return userService.list();
	}
	
	
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody User user) {
		Map<String, Object> returnMap = new HashMap<>();
		User signinedUser = userService.login(user);
		if(signinedUser != null) {
				returnMap.put("user", signinedUser);
				returnMap.put("messenger", Messenger.SUCCESS);
				
		}else {
				returnMap.put("messenger", Messenger.FAIL);
		}
		return returnMap;
	}
	
	@GetMapping("/detail/{userid}")
	public User detail(@PathVariable String userid) {
		return userService.detail(userid);
	}
	
	@PutMapping("/update")
	public Messenger update(@RequestBody User user) {
		return (userService.update(user)) ? Messenger.SUCCESS:Messenger.FAIL;
	}
	
	@DeleteMapping("/remove/{userid}")
	public Messenger remove(@PathVariable String userid) {
		return (userService.remove(userid)) ? Messenger.SUCCESS:Messenger.FAIL;
	}
	
}