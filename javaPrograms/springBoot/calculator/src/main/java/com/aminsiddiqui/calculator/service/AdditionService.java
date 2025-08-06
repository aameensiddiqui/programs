package com.aminsiddiqui.calculator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.aminsiddiqui.calculator.model.ResultResponce;
import com.aminsiddiqui.calculator.model.TwoNumbers;

@Service
public class AdditionService {
	
	private static final Logger logger = LoggerFactory.getLogger(AdditionService.class);
	
	public ResultResponce add(TwoNumbers nums) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
				+nums.getX()+" "+nums.getY());
		logger.info("Received these two numbers x={} y={}: ",nums.getX(), nums.getY());
		long ans = nums.getX() + nums.getY();
		logger.info("Adding numbers: {} & {}",nums.getX(), nums.getY());
		logger.info("Computed result: {}",ans);
		return new ResultResponce(ans);
	}
}

//	public int add(int a, int b) {
//		return a+b;
//	}