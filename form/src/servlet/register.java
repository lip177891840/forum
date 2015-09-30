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

public class register extends HttpServlet {

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
		
		//创建两个DAO
		AddDAO addDAO=new AddDAO();
		BasicDAO basicDAO =new BasicDAO();
		
		//参数检查在jsp页面用js验证,	这里再验证参数长度
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String sex=request.getParameter("sex");
		String signature=request.getParameter("signature");
		String home=request.getParameter("home");
		String education=request.getParameter("education");	
		
		System.out.println(" ="+name+"=");
		List<User> userList=basicDAO.findAllUser();
		
		int test1=0;   //长度为零
		if(name.length()>3 && password.length()>3 && email.length() >6){  //判断参数的长度
			test1=1;
		}
		
		int test2=0;
		for(User item: userList){
			if(item.getUserName().equals(name))
				test2=1;
		}
		
		//这里注册失败不跳转到出错页,以后用ajax实现
		if(test1==1 && test2==0 ){
			System.out.println("have not");
			
			//把参数包装成一个User
			User user=new User();
			user.setUserName(name);
			user.setUserPassword(password);
		
			//先插入到表user,再通过name 查找userId,然后传递给user_info,插入到表user_info
			addDAO.addUser(user);  
			User oneUser=basicDAO.findUser(name);
			int userId=oneUser.getUserId();
			//int userId=1;
			
			//把参数包装成一个User_info
			User_info user_info =new User_info();
			user_info.setUserId(userId);
			user_info.setEmail(email);
			user_info.setSex(sex);
			user_info.setSignature(signature);
			user_info.setHome(home);
			user_info.setEducation(education);
		
			addDAO.addUser_info(user_info);
			
			HttpSession session=request.getSession(true);
			session.setAttribute("user", user);
			session.setAttribute("user_info", user_info);
			
			request.getRequestDispatcher("/servlet/guoke").forward(request, response);
			out.flush();
			out.close();
		}
		else{
			request.getRequestDispatcher("/servlet/guoke").forward(request, response);
		}
				
	}
	public void init() throws ServletException {
	}

}
