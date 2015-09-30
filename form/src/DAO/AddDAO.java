package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean1.*;
import util.DBConnection1;

public class AddDAO {
	public AddDAO(){
	}
	
	public boolean addUser(User user){
		Connection conn = DBConnection1.getConnection();	//获得连接对象
		String addSQL = "insert into user(userName,userPassword) values(?,?)";
		PreparedStatement statement=null;
		try{
			statement=conn.prepareStatement(addSQL);
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getUserPassword());
			statement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		} finally{
			DBConnection1.close(statement);
			DBConnection1.close(conn);							//关闭连接对象
		}
		return true;
	}
	
	public boolean addTopic(Topic topic){
		Connection conn = DBConnection1.getConnection();	//获得连接对象
		String addSQL = "insert into topic(topicName) values(?)";
		PreparedStatement statement=null;
		try{
			statement=conn.prepareStatement(addSQL);
			statement.setString(1,topic.getTopicName());
			statement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		} finally{
			DBConnection1.close(statement);
			DBConnection1.close(conn);							//关闭连接对象
		}
		return true;
	}
	
	public boolean addQuestion(Question question){
		Connection conn = DBConnection1.getConnection();	//获得连接对象
		String addSQL = "insert into question(questionName,discribe,topicId,userId) values(?,?,?,?)";
		PreparedStatement statement=null;
		try{
			statement=conn.prepareStatement(addSQL);
			statement.setString(1,question.getQuestionName());
			statement.setString(2, question.getDescribe());
			statement.setInt(3,question.getTopicId());
			statement.setInt(4, question.getUserId());
			statement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		} finally{
			DBConnection1.close(statement);
			DBConnection1.close(conn);							//关闭连接对象
		}
		return true;
	}
	
	public boolean addAnswer(Answer answer){
		Connection conn = DBConnection1.getConnection();	//获得连接对象
		String addSQL = "insert into answer(content,questionId,userId) values(?,?,?)";
		PreparedStatement statement=null;
		try{
			statement=conn.prepareStatement(addSQL);
			statement.setString(1,answer.getContent());
			statement.setInt(2, answer.getQuestionId());
			statement.setInt(3, answer.getUserId());
			statement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		} finally{
			DBConnection1.close(statement);
			DBConnection1.close(conn);							//关闭连接对象
		}
		return true;
	}
	
	public boolean addReplay(Replay replay){
		Connection conn = DBConnection1.getConnection();	//获得连接对象
		String addSQL = "insert into topic(topicName) values(?)";
		PreparedStatement statement=null;
		try{
			statement=conn.prepareStatement(addSQL);
			statement.setString(1,replay.getContent());
			statement.setInt(2, replay.getAnswerId());
			statement.setInt(3, replay.getUserId());
			statement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		} finally{
			DBConnection1.close(statement);
			DBConnection1.close(conn);							//关闭连接对象
		}
		return true;
	}
	
	public boolean addUser_info(User_info user_info){
		Connection conn = DBConnection1.getConnection();	//获得连接对象
		String addSQL = "insert into user_info(userId,email,sex,signature,home,education) values(?,?,?,?,?,?)";
		PreparedStatement statement=null;
		try{
			statement=conn.prepareStatement(addSQL);
			statement.setInt(1, user_info.getUserId());
			statement.setString(2, user_info.getEmail());
			statement.setString(3, user_info.getSex());
			statement.setString(4, user_info.getSignature());
			statement.setString(5, user_info.getHome());
			statement.setString(6, user_info.getEducation());
			statement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		} finally{
			DBConnection1.close(statement);
			DBConnection1.close(conn);							//关闭连接对象
		}
		return true;
	}
	
	public boolean addLike_topic(Like_topic like_topic){
		Connection conn = DBConnection1.getConnection();	//获得连接对象
		String addSQL = "insert into like_topic(topicId,userId) values(?,?)";
		PreparedStatement statement=null;
		try{
			statement=conn.prepareStatement(addSQL);
			statement.setInt(1, like_topic.getTopicId());
			statement.setInt(2, like_topic.getUserId());
			statement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		} finally{
			DBConnection1.close(statement);
			DBConnection1.close(conn);							//关闭连接对象
		}
		return true;
	}
	
	public boolean addLike_question(Like_question like_question){
		Connection conn = DBConnection1.getConnection();	//获得连接对象
		String addSQL = "insert into like_question(questionId,userId) values(?,?)";
		PreparedStatement statement=null;
		try{
			statement=conn.prepareStatement(addSQL);
			statement.setInt(1, like_question.getQuestionId());
			statement.setInt(2, like_question.getUserId());
			statement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		} finally{
			DBConnection1.close(statement);
			DBConnection1.close(conn);							//关闭连接对象
		}
		return true;
	}
	
	
	
	public boolean addLike_answer(Like_Answer like_Answer){
		Connection conn = DBConnection1.getConnection();	//获得连接对象
		String addSQL = "insert into like_answer(questionId,userId) values(?,?)";
		PreparedStatement statement=null;
		try{
			statement=conn.prepareStatement(addSQL);
			statement.setInt(1, like_Answer.getAnswerId());
			statement.setInt(2, like_Answer.getUserId());
			statement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		} finally{
			DBConnection1.close(statement);
			DBConnection1.close(conn);							//关闭连接对象
		}
		return true;
	}
	
	public boolean addLike_replay(Like_replay like_replay){
		Connection conn = DBConnection1.getConnection();	//获得连接对象
		String addSQL = "insert into like_replay(replayId,userId) values(?,?)";
		PreparedStatement statement=null;
		try{
			statement=conn.prepareStatement(addSQL);
			statement.setInt(1, like_replay.getReplayId());
			statement.setInt(2, like_replay.getUserId());
			statement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		} finally{
			DBConnection1.close(statement);
			DBConnection1.close(conn);							//关闭连接对象
		}
		return true;
	}

}
