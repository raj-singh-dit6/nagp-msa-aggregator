package com.nagp.msa.aggregator.dto;

import java.util.List;

public class OrdersDto {
	
	private List<OrderDto> orders;

	public List<OrderDto> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDto> orders) {
		this.orders = orders;
	}

}
