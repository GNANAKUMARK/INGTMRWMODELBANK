/**
 * 
 */
package com.ing.modelbank.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for Account details
 * @author ING Dev Team
 *
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")
public class CustomerDetailsController {
	private static final Logger LOGGER = LogManager.getLogger(CustomerDetailsController.class);
	

}
