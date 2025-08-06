package com.aminsiddiqui.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aminsiddiqui.calculator.model.ResultResponce;
import com.aminsiddiqui.calculator.model.TwoNumbers;
import com.aminsiddiqui.calculator.service.MultiplicationService;

@RestController
public class MultiplicationController {
	
	@Autowired
	MultiplicationService mulService;
	
	@PostMapping("/mul")
	public ResultResponce mul(@RequestBody TwoNumbers nums) {
		return mulService.mul(nums);
	}
}
