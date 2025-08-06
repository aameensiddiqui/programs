package com.aminsiddiqui.calculator.service;

import org.springframework.stereotype.Service;

import com.aminsiddiqui.calculator.model.ResultResponce;
import com.aminsiddiqui.calculator.model.TwoNumbers;

@Service
public class MultiplicationService {
	public ResultResponce mul(TwoNumbers nums) {
		long ans = nums.getX() * nums.getY();
		return new ResultResponce(ans);
	}
}
