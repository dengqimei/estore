package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.ShoppingCar;
import com.briup.estore.common.exception.CustomerException;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.service.impl.CustomerServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private ICustomerService customerService = new CustomerServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	} 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("userid");
		String password = req.getParameter("password");
		if(name!=null&&password!=null){
			try {
				Customer customer = customerService.login(name, password);
				ShoppingCar car = new ShoppingCar();
				req.getSession().setAttribute("car", car);
				req.getSession().setAttribute("customer", customer);
				req.setAttribute("msg", "登录成功！");
				resp.sendRedirect("index.jsp");
			} catch (CustomerException e) {
				req.setAttribute("msg", e.getMessage());
				resp.sendRedirect("login.jsp");
			}
		}else{
			resp.sendRedirect("index.jsp");
		}
	}

}
