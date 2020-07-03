package com.nagp.msa.aggregator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagp.msa.aggregator.dto.OrdersDto;
import com.nagp.msa.aggregator.dto.UserDto;
import com.nagp.msa.aggregator.dto.UserOrdersDto;

@Service
public class UserOrdersServiceImpl implements UserOrdersService {
	
	private final static Logger LOG = LoggerFactory.getLogger(UserOrdersServiceImpl.class);
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public UserOrdersDto getUserOrders(Integer userId) {
		LOG.debug("inside UserOrdersServiceImpl.getUserOrders method");
		UserDto user = restTemplate.getForObject("http://user-service:8050/user/"+userId,UserDto.class);
		OrdersDto orders = restTemplate.getForObject("http://order-service:8060/order/"+userId,OrdersDto.class);
		UserOrdersDto result=new UserOrdersDto();
		result.setUserDetails(user);
		result.setOrders(orders.getOrders());
		return result;
	}

}
