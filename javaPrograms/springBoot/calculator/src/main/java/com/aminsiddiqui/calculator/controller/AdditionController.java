package com.aminsiddiqui.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aminsiddiqui.calculator.model.ResultResponce;
import com.aminsiddiqui.calculator.model.TwoNumbers;
import com.aminsiddiqui.calculator.service.AdditionService;

@RestController
public class AdditionController {
	
	@Autowired
	AdditionService addService;
	
	
	@PostMapping("/add")
	public ResultResponce add(@RequestBody TwoNumbers nums) {
		return addService.add(nums);
	}
}

//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.GetMapping;
//	@GetMapping("/add")
//	public int add(@RequestParam int a, @RequestParam int b) {
//		return addService.add(a, b);
//	}