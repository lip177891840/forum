package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BasicDAO;
import bean1.*;

public class guoke extends HttpServlet {
	public void destroy() {
		super.destroy(); 
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		this.doPost(request, response);
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		BasicDAO table=new BasicDAO();
		
		List<User> userList=table.findAllUser();
		request.setAttribute("userList", userList);
		
		List<Topic> topicList=table.findAllTopic();
		request.setAttribute("topicList", topicList);
		
		List<Question> questionList =table.findAllQuestion();
		
		request.setAttribute("questionList", questionList);
		
		List<Answer> answerList=table.findAllAnswer();
		//判断每个answer里的content的长度,限制在223之内
		List<Answer> new_answerList=new ArrayList<Answer>();
		
		Map<Integer,Integer> hasMap=new HashMap<Integer,Integer>();
		for(Answer answer: answerList){
			if(hasMap.containsKey(answer.getQuestionId()))
				break;
			else
				hasMap.put(answer.getAnswerId(), answer.getQuestionId());
			
			String str=answer.getContent();
			if(str.length()>223){
				String tmpStr=str.substring(0, 223);
				String newStr=tmpStr+"......";
				answer.setContent(newStr);
				new_answerList.add(answer);
			}
			else
				new_answerList.add(answer);
		}
		request.setAttribute("answerList", new_answerList);
		
		List<Replay> replayList=table.findAllReplay();
		request.setAttribute("replayList", replayList);
		
		List<Like_question> like_question=table.findAllLike_question();
		
		
		
		request.getRequestDispatcher("/guoke.jsp").forward(request, response);
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
	}

}
