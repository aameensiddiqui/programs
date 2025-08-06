package com.aminsiddiqui.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aminsiddiqui.calculator.model.ResultResponce;
import com.aminsiddiqui.calculator.model.TwoNumbers;
import com.aminsiddiqui.calculator.service.SubtractionService;

@RestController
public class SubtractionController {
	
	@Autowired
	SubtractionService subService;
	
	@PostMapping("/sub")
	public ResultResponce sub(@RequestBody TwoNumbers nums) {
		return subService.sub(nums);
	}
}
