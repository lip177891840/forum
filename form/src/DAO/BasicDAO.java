package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean1.*;
import util.DBConnection1;


/**
 * 
 * 最基本的DAO,即查询返回一个表的所有记录
 *
 */
public class BasicDAO {
	public BasicDAO(){
	}
	
	public List<User> findAllUser(){
		Connection conn = DBConnection1.getConnection();	//获得连接对象
		String findSQL="select * from user";
		PreparedStatement statement=null;
		List<User> userList= new ArrayList<User>();
		try{
			statement=conn.prepareStatement(findSQL);
			ResultSet rs =statement.executeQuery();
			
			while(rs.next()){
				User user=new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				userList.add(user);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection1.close(statement);
			DBConnection1.close(conn);
		}
		return userList;
	}
	
	public List<Topic> findAllTopic(){
		Connection conn = DBConnection1.getConnection();	//获得连接对象
		String findSQL="select * from topic";
		PreparedStatement statement=null;
		List<Topic> topicList=new ArrayList<Topic>();
		try{
			statement=conn.prepareStatement(findSQL);
			ResultSet rs =statement.executeQuery();
			
			while(rs.next()){
				Topic topic=new Topic();
				topic.setTopicId(rs.getInt(1));
				topic.setTopicName(rs.getString(2));
				topicList.add(topic);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection1.close(statement);
			DBConnection1.close(conn);
		}
		return topicList;
	}
	
	
	public List<Question> findAllQuestion(){
		Connection conn = DBConnection1.getConnection();	//获得连接对象
		String findSQL="select * from question";
		PreparedStatement statement=null;
		List<Question> questionList=new ArrayList<Question>();
		try{
			statement=conn.prepareStatement(findSQL);
			ResultSet rs =statement.executeQuery();
			
			while(rs.next()){
				Question question=new Question();
				question.setQuestionId(rs.getInt(1));
				question.setQuestionName(rs.getString(2));
				question.setDescribe(rs.getString(3));
				question.setTopicId(rs.getInt(4));
				question.setUserId(rs.getInt(5));
				questionList.add(question);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection1.close(statement);
			DBConnection1.close(conn);
		}
		return questionList;
	}
	
	public List<Answer> findAllAnswer(){
		Connection conn = DBConnection1.getConnection();	//获得连接对象
		String findSQL="select * from answer";
		PreparedStatement statement=null;
		List<Answer> answerList=new ArrayList<Answer>();
		try{
			statement=conn.prepareStatement(findSQL);
			ResultSet rs =statement.executeQuery();
			
			while(rs.next()){
				Answer answer=new Answer();
				answer.setAnswerId(rs.getInt(1));
				answer.setContent(rs.getString(2));
				answer.setQuestionId(rs.getInt(3));
				answer.setUserId(rs.getInt(4));
				answerList.add(answer);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection1.close(statement);
			DBConnection1.close(conn);
		}
		return answerList;
	}
	
	
	public List<Replay> findAllReplay(){
		Connection conn = DBConnection1.getConnection();	//获得连接对象
		String findSQL="select * from replay";
		PreparedStatement statement=null;
		List<Replay> replayList= new ArrayList<Replay>();
		try{
			statement=conn.prepareStatement(findSQL);
			ResultSet rs =statement.executeQuery();
			
			while(rs.next()){
				Replay replay=new Replay();
				replay.setReplayId(rs.getInt(1));
				replay.setContent(rs.getString(2));
				replay.setAnswerId(rs.getInt(3));
				replay.setUserId(rs.getInt(4));
				replayList.add(replay);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection1.close(statement);
			DBConnection1.close(conn);
		}
		return replayList;
	}
	
	//--------------------------------------------------------------------------------
	//查找某个特定的user
	public User findUser(String name){
		Connection conn = DBConnection1.getConnection();	//获得连接对象
		String findSQL="select * from user where userName='"+name+"'";
		PreparedStatement statement=null;
		User user=new User();
		try{
			statement=conn.prepareStatement(findSQL);
			ResultSet rs =statement.executeQuery();
				
			while(rs.next()){
					
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection1.close(statement);
			DBConnection1.close(conn);
		}
		return user;
	}
	
		
	//查找某个特定的question
	public Question findQuestion(int id){
		Connection conn = DBConnection1.getConnection();	//获得连接对象
		String findSQL="select * from question where questionId="+id;
		PreparedStatement statement=null;
		Question question=new Question();
		try{
			statement=conn.prepareStatement(findSQL);
			ResultSet rs =statement.executeQuery();
			
			
			while(rs.next()){
				
				question.setQuestionId(rs.getInt(1));
				question.setQuestionName(rs.getString(2));
				question.setDescribe(rs.getString(3));
				question.setTopicId(rs.getInt(4));
				question.setUserId(rs.getInt(5));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection1.close(statement);
			DBConnection1.close(conn);
		}
		return question;
	}
	//-------------------------------------------------------------------------------------
	
	
	public List<User_info> findAllUser_info(){
		Connection conn = DBConnection1.getConnection();	//获得连接对象
		String findSQL="select * from user_info";
		PreparedStatement statement=null;
		List<User_info> user_infoList= new ArrayList<User_info>();
		try{
			statement=conn.prepareStatement(findSQL);
			ResultSet rs =statement.executeQuery();
			
			while(rs.next()){
				User_info user_info=new User_info();
				user_info.setUserId(rs.getInt(1));
				user_info.setEmail(rs.getString(2));
				user_info.setSex(rs.getString(3));
				user_info.setSignature(rs.getString(4));
				user_info.setHome(rs.getString(5));
				user_info.setEducation(rs.getString(6));
				user_infoList.add(user_info);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection1.close(statement);
			DBConnection1.close(conn);
		}
		return user_infoList;
	}
	
	public List<Like_topic> findAllLike_topic(){
		Connection conn = DBConnection1.getConnection();	//获得连接对象
		String findSQL="select * from like_topic";
		PreparedStatement statement=null;
		List<Like_topic> like_topicList= new ArrayList<Like_topic>();
		try{
			statement=conn.prepareStatement(findSQL);
			ResultSet rs =statement.executeQuery();
			
			while(rs.next()){
				Like_topic like_topic=new Like_topic();
				like_topic.setId(rs.getInt(1));
				like_topic.setTopicId(rs.getInt(2));
				like_topic.setUserId(rs.getInt(3));
				like_topicList.add(like_topic);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection1.close(statement);
			DBConnection1.close(conn);
		}
		return like_topicList;
	}
	
	public List<Like_question> findAllLike_question(){
		Connection conn = DBConnection1.getConnection();	//获得连接对象
		String findSQL="select * from like_question";
		PreparedStatement statement=null;
		List<Like_question> like_questionList= new ArrayList<Like_question>();
		try{
			statement=conn.prepareStatement(findSQL);
			ResultSet rs =statement.executeQuery();
			
			while(rs.next()){
				Like_question like_question=new Like_question();
				like_question.setId(rs.getInt(1));
				like_question.setQuestionId(rs.getInt(2));
				like_question.setUserId(rs.getInt(3));
				like_questionList.add(like_question);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection1.close(statement);
			DBConnection1.close(conn);
		}
		return like_questionList;
	}
	
	public List<Like_Answer> findAllLike_Answer(){
		Connection conn = DBConnection1.getConnection();	//获得连接对象
		String findSQL="select * from like_answer";
		PreparedStatement statement=null;
		List<Like_Answer> like_answerList= new ArrayList<Like_Answer>();
		try{
			statement=conn.prepareStatement(findSQL);
			ResultSet rs =statement.executeQuery();
			
			while(rs.next()){
				Like_Answer like_answer =new Like_Answer();
				like_answer.setId(rs.getInt(1));
				like_answer.setAnswerId(rs.getInt(2));
				like_answer.setUserId(rs.getInt(3));
				like_answerList.add(like_answer);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection1.close(statement);
			DBConnection1.close(conn);
		}
		return like_answerList;
	}
	
	
	public List<Like_replay> findAllLike_replay(){
		Connection conn = DBConnection1.getConnection();	//获得连接对象
		String findSQL="select * from like_replay";
		PreparedStatement statement=null;
		List<Like_replay> like_replayList= new ArrayList<Like_replay>();
		try{
			statement=conn.prepareStatement(findSQL);
			ResultSet rs =statement.executeQuery();
			
			while(rs.next()){
				Like_replay like_replay=new Like_replay();
				like_replay.setId(rs.getInt(1));
				like_replay.setReplayId(rs.getInt(1));
				like_replay.setUserId(rs.getInt(2));
				like_replayList.add(like_replay);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection1.close(statement);
			DBConnection1.close(conn);
		}
		return like_replayList;
	}

}
