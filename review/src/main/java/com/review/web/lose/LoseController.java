package com.review.web.lose;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/losts")
public class LoseController {
	@Autowired LoseService lostService;
	
	@GetMapping("")
	public List<Lose> list(){
		return lostService.findAll();
	}
	
	@GetMapping("/{lostId}")
	public Lose detail(@PathVariable String lostId) {
		return lostService.findOne(lostId);
	}

}
