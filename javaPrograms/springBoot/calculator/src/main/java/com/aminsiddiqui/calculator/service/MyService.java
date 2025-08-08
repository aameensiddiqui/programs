package com.aminsiddiqui.calculator.service;

import org.springframework.stereotype.Component;
/* without @Component or @Service bean will not be created in the container 
 * import org springframework stereotype Service
 * and the build will fail: 
 * Consider defining a bean of type 'com.aminsiddiqui.calculator.service.MyService' in your configuration.
*/

@Component
public class MyService {
	public String myMethod() {
		return "myMethod ka return string";
	}
}
