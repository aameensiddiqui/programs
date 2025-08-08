package com.aminsiddiqui.calculator.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aminsiddiqui.calculator.model.TwoNumbers;
import com.aminsiddiqui.calculator.service.AdditionService;
import com.aminsiddiqui.calculator.service.MyService;

@RestController
public class AdditionController {
	
	private static final Logger log = LoggerFactory.getLogger(AdditionController.class);
	
//	@Autowired
	AdditionService addService;
	
//	@Autowired
	MyService ms; // NullPointerException ayega. Use @Autowired
	
	ApplicationContext applicationContext;
	
	public AdditionController(MyService ms, AdditionService addService, ApplicationContext applicationContext) {
		log.info("AdditionController initialized!!!!");
		this.ms = ms;
		this.addService = addService;
		
		
		this.applicationContext = applicationContext;
	}
	
	@PostMapping("/add")
	public String add(@RequestBody TwoNumbers nums) {
		return ms.myMethod();
	}
	
//	@PostMapping("/add")
//	public ResultResponce add(@RequestBody TwoNumbers nums) {
//		return addService.add(nums);
//	}
}

//---------------------------------
//	@PostMapping("/add")
//	public String add(@RequestBody TwoNumbers nums) {
//		return ms.myMethod();
//	}
//---------------------------------
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.GetMapping;
//	@GetMapping("/add")
//	public int add(@RequestParam int a, @RequestParam int b) {
//		return addService.add(a, b);
//	}
//---------------------------------
