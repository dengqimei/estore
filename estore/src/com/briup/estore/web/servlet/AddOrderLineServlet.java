package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Line;
import com.briup.estore.bean.ShoppingCar;
import com.briup.estore.common.exception.BookException;
import com.briup.estore.service.IBookService;
import com.briup.estore.service.impl.BookServiceImpl;

@WebServlet("/AddOrderLineServlet")
public class AddOrderLineServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private IBookService bookService = new BookServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Object attribute2 = session.getAttribute("car");
		if(session.getAttribute("customer")!=null){
			ShoppingCar car = null;
			Line line = new Line();
			Long id = Long.parseLong(req.getParameter("bookid"));
			line.setId(id);
			try {
				Book book = bookService.findById(id);
				line.setBook(book);
			} catch (BookException e) {
				e.printStackTrace();
			}
			if(attribute2!=null){
				car = (ShoppingCar) attribute2;
			}else{
				car = new ShoppingCar();
			}
			if((req.getParameter("num"))!=null){
				int num = Integer.parseInt(req.getParameter("num"));
				line.setNum(num);
			}else{
				line.setNum(1);
			}
			car.add(line);
			session.setAttribute("car", car);
			resp.sendRedirect("ShowCarServlet");
		}else{
			resp.sendRedirect("login.jsp");
		}
		
	}
	
}
