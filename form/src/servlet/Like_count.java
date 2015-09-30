package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import DAO.*;
import bean1.*;

//这个类是根据type的值来判断请求的类型,然后通过BasicDAO得到这个表,
public class Like_count extends HttpServlet {
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
		
		//type 类型有topic, question,	 answer, replay
		String type=request.getParameter("type");
		String useage=request.getParameter("useage");
		
		AddDAO addDAO=new AddDAO();
		BasicDAO basicDAO =new BasicDAO();
		if(type.equals("topic")){
			if(useage.equals("insert")){	
				HttpSession session=request.getSession(true);
				User user=(User) session.getAttribute("user");
				int userId=user.getUserId();
				
				int topicId=Integer.parseInt(request.getParameter("topicId"));
				//组装like_question
				Like_topic like_topic =new Like_topic();
				like_topic.setTopicId(topicId);
				like_topic.setUserId(userId);
				addDAO.addLike_topic(like_topic);
			}
			int topicId=Integer.parseInt(request.getParameter("topicId"));
			int num_topic=0;
			List<Like_topic> like_topicList=basicDAO.findAllLike_topic();
			for(Like_topic like_topic: like_topicList){
				if(like_topic.getTopicId()==topicId)
					num_topic++;
			}
			out.println(num_topic);
		}
		else if(type.equals("question")){
			int questionId=Integer.parseInt(request.getParameter("questionId"));
			if(useage.equals("insert")){	//如果是点赞,则添加相应的记录
				HttpSession session=request.getSession(true);
				User user=(User) session.getAttribute("user");
				int userId=user.getUserId();
				
				//组装like_question
				Like_question like_question =new Like_question();
				like_question.setQuestionId(questionId);
				like_question.setUserId(userId);
				Has_likeDAO has_likeDAO=new Has_likeDAO();
				if(has_likeDAO.has_like_question(like_question)){ //如果该用户没赞过这篇文章,则点赞
					addDAO.addLike_question(like_question);
				}
				else{   //如果已经点了赞,就取消点赞
					DeleteDAO deleteDAO =new DeleteDAO();
					deleteDAO.deleteQuestion(like_question);
				}
			}
			int num_question=0;  //查询返回的question数量
			List<Like_question> like_questionList=basicDAO.findAllLike_question();
			for(Like_question like_question: like_questionList){
				if(like_question.getQuestionId()==questionId)
					num_question++;
			}
			out.println(num_question);
		}
		else if(type.equals("answer")){
			int answerId=Integer.parseInt(request.getParameter("answerId"));
			if(useage.equals("insert")){	
				HttpSession session=request.getSession(true);
				User user=(User) session.getAttribute("user");
				int userId=user.getUserId();
				
				//组装like_answer
				Like_Answer like_Answer =new Like_Answer();
				like_Answer.setAnswerId(answerId);
				like_Answer.setUserId(userId);
				addDAO.addLike_answer(like_Answer);
			}
			
			int num_answer=0;
			List<Like_Answer> like_answerList=basicDAO.findAllLike_Answer();
			for(Like_Answer like_answer: like_answerList){
				if(like_answer.getAnswerId()==answerId)
					num_answer++;
			}
			out.println(num_answer);
		}
		else if(type.equals("replay")){
			int replayId=Integer.parseInt(request.getParameter("replayId"));
			int num_replay=0;
			List<Like_replay> like_replayList=basicDAO.findAllLike_replay();
			for(Like_replay like_replay: like_replayList){
				if(like_replay.getReplayId()==replayId)
					num_replay++;
			}
			out.println(num_replay);
		}
			
		out.flush();
		out.close();
		
	}
	public void init() throws ServletException {
	}
}
