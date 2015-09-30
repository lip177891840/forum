package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javassist.bytecode.Descriptor.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import bean1.*;
import DAO.*;

public class userNameCheck extends HttpServlet {

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
		response.setHeader("text/xml","no-cache");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String name=request.getParameter("name");
		
		BasicDAO basicDAO =new BasicDAO();
		List<User> userList=basicDAO.findAllUser();
		boolean flag=false;
		for(User user: userList){
			if(user.getUserName().equals(name)){
				flag=true;
				break;
			}
		}
		
		if(flag){
			out.println("该用户名已被注册");
		}else{
			out.println("ok");
		}
		
		out.flush();
		out.close();
		
		
		
				
	}
	public void init() throws ServletException {
	}

}
