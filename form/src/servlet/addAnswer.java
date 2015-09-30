package servlet;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean1.*;
import DAO.*;

public class addAnswer extends HttpServlet {
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
		
		String content=request.getParameter("answer_content");
		int questionId=Integer.parseInt(request.getParameter("questionId"));
		
		
		//两个测试条件,test1为内容长度,test2为用户是否登录
		int test1=0;
		if(content.length()>0){
			test1=1;
		}
		int test2=0;
		int userId=0;
		try{
			HttpSession session=request.getSession(true);
			User user=(User) session.getAttribute("user");
			userId=user.getUserId();
			test2=1;
		}catch(Exception e){
			System.out.println("please login");
		}
		
		if(test1 ==1 && test2==1){
			//组装成一个Answer
			Answer answer=new Answer();
			answer.setContent(content);
			answer.setQuestionId(questionId);
			answer.setUserId(userId);
		
			System.out.println(content+questionId+userId);
			AddDAO addDAO=new AddDAO();
			System.out.println("ok");
			addDAO.addAnswer(answer);
		
		
			request.getRequestDispatcher("/servlet/guoke").forward(request, response);
			out.flush();
			out.close();
		}
		else{
			request.getRequestDispatcher("/servlet/guoke").forward(request, response);
			out.flush();
			out.close();
		}
	}
	public void init() throws ServletException {
	}

}
