package com.briup.estore.dao;

import com.briup.estore.bean.Address;
import com.briup.estore.bean.Customer;
import com.briup.estore.bean.Telephone;

public interface CustomerMapper {
	
	public Customer findByName(String name);
	
	public void saveAddress(Address address);
	
	public void saveTelephone(Telephone telephone);
	
	public void saveCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);
	
	public void updateAddress(Address address);
	
	public void updateTelephone(Telephone telephone);
	
}
