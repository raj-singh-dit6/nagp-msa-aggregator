package com.nagp.msa.aggregator.dto;

import java.util.List;

public class UserOrdersDto {
	
	private UserDto userDetails;
	private List<OrderDto> orders;
	
	public UserDto getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDto userDetails) {
		this.userDetails = userDetails;
	}
	public List<OrderDto> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderDto> orders) {
		this.orders = orders;
	}
	
	

}
