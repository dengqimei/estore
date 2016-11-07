package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.common.exception.OrderException;
import com.briup.estore.service.IOrderService;
import com.briup.estore.service.impl.OrderServiceImpl;

@WebServlet("/RemoveOrderServlet")
public class RemoveOrderServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private IOrderService orderService = new OrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Long orderid = Long.parseLong(req.getParameter("orderid"));
		try {
			orderService.deleteOrder(orderid);
		} catch (OrderException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("ShowOrderServlet");
		
	}

}
