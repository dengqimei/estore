package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.Order;

public interface OrderMapper{
	
	public void saveOrder(Order order);
	
	public List<Order> queryAll(Long id);
	
	public Order findOrderById(Long id);
	
	public void deleteOrder(Long id);
	
}
