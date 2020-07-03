package com.nagp.msa.aggregator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.msa.aggregator.dto.UserOrdersDto;
import com.nagp.msa.aggregator.service.UserOrdersService;

@RestController
@RequestMapping("/orderDetails")
public class UserOrdersController {
	
	private final static Logger LOG = LoggerFactory.getLogger(UserOrdersController.class);

	@Autowired UserOrdersService userOrdersService;
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserOrdersDto> getUserOrders(@PathVariable Integer userId) {
		LOG.debug("inside UserOrdersController.getUserOrders method");
		return new ResponseEntity<>(userOrdersService.getUserOrders(userId), HttpStatus.OK);
	}

}