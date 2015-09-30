package bean1;

public class Follow {
	private int followId;
	private int followed;
	private int following;

	public int getFollowId(){
		return followId;
	}
	public void setFollowId(int followId){
		this.followId=followId;
	}

	public int getFollowed(){
		return followed;
	}
	public void setFollowed(int followed){
		this.followed=followed;
	}

	public int getFollowing(){
		return following;
	}
	public void setFollowing(int following){
		this.following=following;
	}

}
