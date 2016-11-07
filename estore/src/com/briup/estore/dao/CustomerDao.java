package com.briup.estore.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.briup.estore.bean.Address;
import com.briup.estore.bean.Customer;
import com.briup.estore.bean.Telephone;

public class CustomerDao{

	public Customer findByName(String name) {
		SqlSessionFactory sqlSessionFactory = BaseDao.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		Customer customer = mapper.findByName(name);
		return customer;
	}

	public void saveCustomer(Customer customer) {
		SqlSessionFactory sqlSessionFactory = BaseDao.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		mapper.saveCustomer(customer);
		sqlSession.commit();
	}

	public void saveAddress(Address address) {
		SqlSessionFactory sqlSessionFactory = BaseDao.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		mapper.saveAddress(address);
		sqlSession.commit();
	}

	public void saveTelephone(Telephone telephone) {
		SqlSessionFactory sqlSessionFactory = BaseDao.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		mapper.saveTelephone(telephone);
		sqlSession.commit();
	}

	public void updateCustomer(Customer customer) {
		SqlSessionFactory sqlSessionFactory = BaseDao.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		mapper.updateCustomer(customer);
		sqlSession.commit();
	}
	
	public void updateAddress(Address address) {
		SqlSessionFactory sqlSessionFactory = BaseDao.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		mapper.updateAddress(address);
		sqlSession.commit();
	}

	public void updateTelephone(Telephone telephone) {
		SqlSessionFactory sqlSessionFactory = BaseDao.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		mapper.updateTelephone(telephone);
		sqlSession.commit();
	}
	
}
