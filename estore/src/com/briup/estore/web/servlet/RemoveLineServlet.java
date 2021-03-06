package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.ShoppingCar;

@WebServlet("/RemoveLineServlet")
public class RemoveLineServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Long id = Long.parseLong(req.getParameter("id"));
		Object attribute = session.getAttribute("car");
		if(attribute!=null){
			ShoppingCar car = (ShoppingCar) attribute;
			car.delete(id);
			resp.sendRedirect("ShowCarServlet");
		}else{
			resp.sendRedirect("ShowCarServlet");
		}
	}

}
