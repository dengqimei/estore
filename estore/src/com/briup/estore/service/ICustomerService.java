package com.briup.estore.service;

import com.briup.estore.bean.Customer;
import com.briup.estore.common.exception.CustomerException;

public interface ICustomerService {
	
	Customer registerCheck(String name) throws CustomerException;
	
	void register(Customer customer) throws CustomerException;
	
	Customer login(String name,String password) throws CustomerException;
	
	void updateCustomer(Customer customer) throws CustomerException;
	
}
