package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean1.Answer;
import bean1.Question;
import DAO.BasicDAO;

public class showQuestion extends HttpServlet {

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
		int id = Integer.parseInt(request.getParameter("questionId"));
		
		
		BasicDAO table=new BasicDAO();
		
		Question question =table.findQuestion(id);
		if(question.getDescribe()==null)
			question.setDescribe("  该问题还没有描述");
		
		request.setAttribute("question", question);
		request.setAttribute("questionId", question.getQuestionId());
		
		List<Answer> answerList=table.findAllAnswer();
		request.setAttribute("answerList", answerList);
		request.getRequestDispatcher("/showQuestion.jsp").forward(request, response);
		
		out.flush();
		out.close();
	}
	public void init() throws ServletException {
	}

}
