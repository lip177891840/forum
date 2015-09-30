package DAO;
import java.util.List;

import bean1.*;
public class Has_likeDAO {
	public Has_likeDAO(){
	}
	public boolean has_like_question(Like_topic like_topic){
		//还未实现该方法
		return true;
	}
	
	public boolean has_like_question(Like_question like_question1){  //这里的所有传进来的参数都为 参数+1
		BasicDAO basicDAO =new BasicDAO();
		List<Like_question> like_questionList=basicDAO.findAllLike_question();
		for(Like_question like_question:like_questionList){
			if(like_question.getQuestionId()==like_question1.getQuestionId()){
				if(like_question.getUserId()==like_question1.getUserId())
					return false;  //false代表存在,不可以执行添加的操作
			}
		}
		return true;  //true代表可以执行添加的操作
	}
	public boolean has_like_Answer(Like_Answer like_Answer1){
		BasicDAO basicDAO =new BasicDAO();
		List<Like_Answer> like_AnswerList=basicDAO.findAllLike_Answer();
		for(Like_Answer like_Answer:like_AnswerList){
			if(like_Answer.getAnswerId()==like_Answer1.getAnswerId()){
				if(like_Answer.getUserId()==like_Answer1.getUserId())
					return false;  //false代表存在,不可以执行添加的操作
			}
		}
		return true;  //true代表可以执行添加的操作
	}
	public boolean has_like_replay(Like_replay like_replay1){
		BasicDAO basicDAO =new BasicDAO();
		List<Like_replay> like_replayList=basicDAO.findAllLike_replay();
		for(Like_replay like_replay:like_replayList){
			if(like_replay.getReplayId()==like_replay1.getReplayId()){
				if(like_replay.getUserId()==like_replay1.getUserId())
					return false;  //false代表存在,不可以执行添加的操作
			}
		}
		return true;  //true代表可以执行添加的操作
	}

}
