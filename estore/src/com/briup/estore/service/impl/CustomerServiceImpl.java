package com.briup.estore.service.impl;

import com.briup.estore.bean.Customer;
import com.briup.estore.common.exception.CustomerException;
import com.briup.estore.dao.CustomerDao;
import com.briup.estore.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService {

	private CustomerDao customerDao = new CustomerDao();
	
	@Override
	public Customer registerCheck(String name) throws CustomerException {
		return customerDao.findByName(name);
	}
	
	@Override
	public void register(Customer customer) throws CustomerException {
		customerDao.saveAddress(customer.getAddress());
		customerDao.saveTelephone(customer.getTelephone());
		customerDao.saveCustomer(customer);
	}

	@Override
	public Customer login(String name, String password) throws CustomerException {
		Customer customer = customerDao.findByName(name);
		if(customer!=null&&password.equals(customer.getPassword())){
			return customer;
		}else{
			throw new CustomerException("用户名或密码不正确");
		}
	}

	@Override
	public void updateCustomer(Customer customer) throws CustomerException {
		customerDao.updateAddress(customer.getAddress());
		customerDao.updateTelephone(customer.getTelephone());
		customerDao.updateCustomer(customer);
	}

}
