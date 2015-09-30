package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BasicDAO;
import bean1.User;

public class login extends HttpServlet {
	public void destroy() {
		super.destroy(); 
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String name =request.getParameter("name");
		String password=request.getParameter("password");
		
		BasicDAO table=new BasicDAO();
		List<User> userList=table.findAllUser();
		for(User user: userList){
			if(user.getUserName().equals(name)){
				if(user.getUserPassword().equals(password)){
					HttpSession session=request.getSession(true); 
					session.setAttribute("user", user);
				}
			}
		}
		request.getRequestDispatcher("/servlet/guoke").forward(request, response);
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
	}

}
