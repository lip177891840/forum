package bean1;

public class Answer{
	private int answerId;
	private String content;
	private int questionId;
	private int userId;

	public int getAnswerId(){
		return answerId;
	}
	public void setAnswerId(int answerId){
		this.answerId=answerId;
	}

	public String getContent(){
		return content;
	}
	public void setContent(String content){
		this.content=content;
	}

	public int getQuestionId(){
		return questionId;
	}
	public void setQuestionId(int questionId){
		this.questionId=questionId;
	}

	public int getUserId(){
		return userId;
	}
	public void setUserId(int userId){
		this.userId=userId;
	}
}