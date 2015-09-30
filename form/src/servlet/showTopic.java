package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.*;

import java.util.*;

import bean1.*;

//showTopic 这个servlet用来处理两种请求,一种显示所有topic(话题广场),另一种显示某个话题(里面是这个话题的提问)
public class showTopic extends HttpServlet {  
	public void destroy() {
		super.destroy();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	@SuppressWarnings("null")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		BasicDAO basicDAO=new BasicDAO();
		List<Topic> topicList=basicDAO.findAllTopic();
		String topicType=request.getParameter("topicType");
		System.out.println(topicType);
		if(topicType.equals("all")){
				
			request.setAttribute("topicList", topicList);
			
			request.getRequestDispatcher("/showAllTopic.jsp").forward(request, response);
			out.flush();
			out.close();
		}
		else{
			int topicId=Integer.parseInt(request.getParameter("topicId"));
			for(Topic topic: topicList){
				if(topic.getTopicId()==topicId){
					request.setAttribute("topic", topic);
					List<Question> questionList=basicDAO.findAllQuestion();
					List<Question> questionList_OneTopic=new ArrayList<Question>();
					for(Question question:questionList){
						if(question.getTopicId()==topicId)
							questionList_OneTopic.add(question);
					}
					request.setAttribute("questionList_OneTopic", questionList_OneTopic);
					
				}
			}
			
			request.getRequestDispatcher("/showOneTopic.jsp").forward(request, response);
			out.flush();
			out.close();
		}
	}

	public void init() throws ServletException {
	}

}
