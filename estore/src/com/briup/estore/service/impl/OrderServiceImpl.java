package com.briup.estore.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.Line;
import com.briup.estore.bean.Order;
import com.briup.estore.common.exception.OrderException;
import com.briup.estore.dao.LineDao;
import com.briup.estore.dao.OrderDao;
import com.briup.estore.service.IOrderService;

public class OrderServiceImpl implements IOrderService{
	
	private OrderDao orderDao = new OrderDao();
	private LineDao lineDao = new LineDao(); 
	
	@Override
	public void confirmOrder(Customer customer, Order order, Collection<Line> lines) throws OrderException {
		order.setCustomer(customer);
		orderDao.saveOrder(order);
		for(Line line : lines){
			lineDao.saveLine(line);
		}
	}

	@Override
	public void deleteOrder(Long id) throws OrderException {
		lineDao.deleteLine(id);
		orderDao.deleteOrder(id);
	}

	@Override
	public Order findById(Long id) throws OrderException {
		Order order = orderDao.findOrderById(id);
		List<Line> list = lineDao.findLineByOrderId(id);
		Set<Line> set = new HashSet<Line>();
		set.addAll(list);
		order.setLines(set);
		return order;
	}

	@Override
	public List<Order> findAllOrder(Long id) throws OrderException {
		List<Order> list = orderDao.queryAll(id);
		return list;
	}
	
}
