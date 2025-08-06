package com.aminsiddiqui.calculator.service;

import org.springframework.stereotype.Service;

import com.aminsiddiqui.calculator.model.ResultResponce;
import com.aminsiddiqui.calculator.model.TwoNumbers;

@Service
public class SubtractionService {
	public ResultResponce sub(TwoNumbers nums) {
		long ans = nums.getX() - nums.getY();
		return new ResultResponce(ans);
	}
}
