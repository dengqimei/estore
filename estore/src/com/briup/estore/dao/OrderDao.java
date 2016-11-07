package com.briup.estore.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.briup.estore.bean.Order;

public class OrderDao {

	public void saveOrder(Order order){
		SqlSessionFactory sqlSessionFactory = BaseDao.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		mapper.saveOrder(order);
		sqlSession.commit();
	}
	
	public List<Order> queryAll(Long id){
		SqlSessionFactory sqlSessionFactory = BaseDao.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		List<Order> list = mapper.queryAll(id);
		return list;
	}
	
	public Order findOrderById(Long id){
		SqlSessionFactory sqlSessionFactory = BaseDao.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		Order order = mapper.findOrderById(id);
		return order;
	}
	
	public void deleteOrder(Long id){
		SqlSessionFactory sqlSessionFactory = BaseDao.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		mapper.deleteOrder(id);
		sqlSession.commit();
	}
	
//	public static void main(String[] args) {
//		
//		OrderDao dao = new OrderDao();
//		Customer customer = new Customer();
//		customer.setId(1L);
//		Order order = new Order(System.currentTimeMillis(), 50.0, new java.util.Date(), customer);
//		dao.saveOrder(order);
//	}
	
}
