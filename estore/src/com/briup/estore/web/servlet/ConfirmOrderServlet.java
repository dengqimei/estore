package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.Line;
import com.briup.estore.bean.ShoppingCar;

@WebServlet("/ConfirmOrderServlet")
public class ConfirmOrderServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Object attribute2 = session.getAttribute("customer");
		Object attribute = session.getAttribute("car");
		Customer customer = new Customer();
		ShoppingCar car = new ShoppingCar();
		if(attribute2!=null){
			customer = (Customer) attribute2;
			if(attribute!=null){
				car = (ShoppingCar) attribute;
				Map<Long,Line> map = car.getLines();
				Set<Long> keySet = map.keySet();
				Iterator<Long> iterator = keySet.iterator();
				List<Line> list = new ArrayList<Line>();
				while(iterator.hasNext()){
					Long key = iterator.next();
					Line line = map.get(key);
					list.add(line);
				}
				session.setAttribute("cost", car.getCost());
				session.setAttribute("lineList", list);
				session.setAttribute("customer", customer);
				resp.sendRedirect("user/confirmOrder.jsp");
			}
		}else{
			resp.sendRedirect("login.jsp");
		}
		
	}

}
