package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Line;
import com.briup.estore.bean.Order;
import com.briup.estore.common.exception.OrderException;
import com.briup.estore.service.IOrderService;
import com.briup.estore.service.impl.OrderServiceImpl;

@WebServlet("/OrderDetailServlet")
public class OrderDetailServlet  extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private IOrderService orderService = new OrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long orderid = Long.parseLong(req.getParameter("orderid"));
		HttpSession session = req.getSession();
		try {
			Order order = orderService.findById(orderid);
			Set<Line> lines = order.getLines();
			Iterator<Line> iterator = lines.iterator();
			List<Line> list = new ArrayList<Line>();
			while(iterator.hasNext()){
				Line line = iterator.next();
				list.add(line);
			}
			session.setAttribute("lineList", list);
			String payway = order.getPayway();
			session.setAttribute("payway", payway);
		} catch (OrderException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("user/orderinfo.jsp");
		
	}

}
