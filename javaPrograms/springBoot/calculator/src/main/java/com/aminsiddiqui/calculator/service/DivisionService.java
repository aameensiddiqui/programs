package com.aminsiddiqui.calculator.service;

import org.springframework.stereotype.Service;

import com.aminsiddiqui.calculator.model.ResultResponce;
import com.aminsiddiqui.calculator.model.TwoNumbers;

@Service
public class DivisionService {
	public ResultResponce div(TwoNumbers nums) {
		long ans = nums.getX() / nums.getY();
		return new ResultResponce(ans);
	}
}
