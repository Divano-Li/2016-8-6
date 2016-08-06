package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import dao.impl.CustomerDaoImpl;
import entity.Customer;

public class LoginServlet extends HttpServlet {

	
	private static final long serialVersionUID = -154176561953216931L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		Customer customer = new Customer();
		CustomerDaoImpl cd  =  new CustomerDaoImpl();
		String userName = req.getParameter("uname");
		System.out.println("用户名："+userName);
		String forward = null;
		System.out.println(customer.getName());
		System.out.println(cd.query(customer));
		if(cd.query(customer)){
			forward = "/success.jsp";
			RequestDispatcher rd  = req.getRequestDispatcher(forward);
				rd.forward(req, resp);
		}else {
				forward ="/error.jsp";
				RequestDispatcher rd = req.getRequestDispatcher(forward);
				rd.forward(req, resp);
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	
}
