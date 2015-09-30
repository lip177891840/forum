package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean1.*;
import DAO.BasicDAO;

import java.util.*;

public class personalPage extends HttpServlet {

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
		
		HttpSession session=request.getSession(true);
		User userOfSession=(User) session.getAttribute("user");
		int userId=userOfSession.getUserId();
		
		
		BasicDAO table=new BasicDAO();
		
		List<User> userList=new ArrayList<User>();
		userList=table.findAllUser();
		List<User_info> user_infoList =new ArrayList<User_info>();
		user_infoList =table.findAllUser_info();
		for(User user: userList){
			if(user.getUserId() == userId)
				request.setAttribute("user", user);
		}
		for(User_info user_info:user_infoList){
			if(user_info.getUserId() == userId)
				request.setAttribute("user_info", user_info);
		}
		request.getRequestDispatcher("/personalPage.jsp").forward(request, response);
		out.flush();
		out.close();
	}
	public void init() throws ServletException {
	}

}
