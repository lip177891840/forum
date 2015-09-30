package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean1.*;
import util.DBConnection1;

public class DeleteDAO {
	public DeleteDAO(){
	}
	public void deleteQuestion(Like_question like_question){
		Connection conn=DBConnection1.getConnection();
		String deleteSQL ="delete from like_question where questionId=? and userId=?";
		PreparedStatement statement=null;
		try{
			statement=conn.prepareStatement(deleteSQL);
			statement.setInt(1, like_question.getQuestionId());
			statement.setInt(2, like_question.getUserId());
			statement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection1.close(statement);
			DBConnection1.close(conn);
		}
	}
}
