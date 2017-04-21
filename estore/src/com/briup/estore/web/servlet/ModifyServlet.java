package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Address;
import com.briup.estore.bean.Customer;
import com.briup.estore.bean.Telephone;
import com.briup.estore.common.exception.CustomerException;
import com.briup.estore.common.util.MD5;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.service.impl.CustomerServiceImpl;

@WebServlet("/ModifyServlet")
public class ModifyServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private ICustomerService customerService = new CustomerServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Long id = Long.parseLong(req.getParameter("userid"));
		String name = req.getParameter("username");
		String password = MD5.getInstance().getMD5ofStr(req.getParameter("password"));
		Long addrId = Long.parseLong(req.getParameter("addrid"));
		String country = req.getParameter("country");
		String province = req.getParameter("province");
		String city = req.getParameter("city");
		String street1 = req.getParameter("street1");
		String street2 = req.getParameter("street2");
		String zip = req.getParameter("zip");
		Long telId = Long.parseLong(req.getParameter("telid"));
		String homeTel = req.getParameter("homephone");
		String officeTel = req.getParameter("officephone");
		String mobile = req.getParameter("cellphone");
		String email = req.getParameter("email");
		
		Address address = new Address(addrId,country, province, city, street1, street2);
		Telephone telephone = new Telephone(telId,homeTel, officeTel, mobile);
		Customer customer = new Customer(id,name, password, zip, address, telephone, email);
		try {
			customerService.updateCustomer(customer);
			req.getSession().setAttribute("customer", customer);
			resp.sendRedirect("index.jsp");
		} catch (CustomerException e) {
			e.printStackTrace();
		}
		
	}

}
