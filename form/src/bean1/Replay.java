package bean1;

public class Replay {
	private int replayId;
	private String content;
	private int answerId;
	private int userId;

	public int getReplayId(){
		return replayId;
	}
	public void setReplayId(int replayId){
		this.replayId=replayId;
	}

	public String getContent(){
		return content;
	}
	public void setContent(String content){
		this.content=content;
	}

	public int getAnswerId(){
		return answerId;
	}
	public void setAnswerId(int answerId){
		this.answerId=answerId;
	}

	public int getUserId(){
		return userId;
	}
	public void setUserId(int userId){
		this.userId=userId;
	}

}
