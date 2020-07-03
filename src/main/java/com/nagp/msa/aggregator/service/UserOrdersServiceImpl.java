package com.nagp.msa.aggregator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagp.msa.aggregator.dto.OrdersDto;
import com.nagp.msa.aggregator.dto.UserDto;
import com.nagp.msa.aggregator.dto.UserOrdersDto;

@Service
public class UserOrdersServiceImpl implements UserOrdersService {

	private final static Logger LOG = LoggerFactory.getLogger(UserOrdersServiceImpl.class);

	@Value("${order.service.base.url}")
	private String orderServiceBaseUrl;

	@Value("${user.service.base.url}")
	private String userServiceBaseUrl;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public UserOrdersDto getUserOrders(Integer userId) {
		LOG.debug("inside UserOrdersServiceImpl.getUserOrders method");
		UserOrdersDto result = null;
		try {
			UserDto user = restTemplate.getForObject(userServiceBaseUrl + "/user/" + userId, UserDto.class);
			OrdersDto orders = restTemplate.getForObject(orderServiceBaseUrl + "/orders/" + userId, OrdersDto.class);
			result = new UserOrdersDto();
			result.setUserDetails(user);
			result.setOrders(orders.getOrders());
		} catch (Exception e) {
			LOG.error("Could not find orders for provided user :"+userId +",  "+ e.getMessage());
		}
		return result;
	}

}
