package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.Order;
import com.briup.estore.common.exception.OrderException;
import com.briup.estore.service.IOrderService;
import com.briup.estore.service.impl.OrderServiceImpl;

@WebServlet("/ShowOrderServlet")
public class ShowOrderServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private IOrderService orderService = new OrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Object attribute = session.getAttribute("customer");
		if(attribute!=null){
			Customer customer = (Customer) attribute;
			try {
				List<Order> list = orderService.findAllOrder(customer.getId());
				session.setAttribute("orderList", list);
			} catch (OrderException e) {
				e.printStackTrace();
			}
			resp.sendRedirect("user/order.jsp");
		}else{
			resp.sendRedirect("login.jsp");
		}
		
	}

}
