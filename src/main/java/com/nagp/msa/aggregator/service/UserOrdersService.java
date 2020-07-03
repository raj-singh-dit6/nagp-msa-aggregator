package com.nagp.msa.aggregator.service;

import com.nagp.msa.aggregator.dto.UserOrdersDto;

public interface UserOrdersService {

	public UserOrdersDto getUserOrders(Integer userId);

}
