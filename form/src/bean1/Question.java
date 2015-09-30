package bean1;

public class Question {
	private int questionId;
	private String questionName;
	private String describe;
	private int topicId;
	private int userId;
	
	public int getQuestionId(){
		return questionId;
	}
	public void setQuestionId(int questionId){
		this.questionId=questionId;
	}
	
	public String getQuestionName(){
		return questionName;
	}
	public void setQuestionName(String questionName){
		this.questionName=questionName;
	}
	
	public String getDescribe(){
		return describe;
	}
	public void setDescribe(String describe){
		this.describe=describe;
	}
	
	public int getTopicId(){
		return topicId;
	}
	public void setTopicId(int topicId){
		this.topicId=topicId;
	}
	
	public int getUserId(){
		return userId;
	}
	public void setUserId(int userId){
		this.userId=userId;
	}
}
