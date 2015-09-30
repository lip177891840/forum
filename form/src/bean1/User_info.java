package bean1;

public class User_info {
	private int userId;
	private String email;
	private String sex;
	private String signature;
	private String home;
	private String education;

	public int getUserId(){
		return userId;
	}
	public void setUserId(int userId){
		this.userId=userId;
	}
	
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email=email;
	}

	public String getSex(){
		return sex;
	}
	public void setSex(String sex){
		this.sex=sex;
	}

	public String getSignature(){
		return signature;
	}
	public void setSignature(String signature){
		this.signature=signature;
	}

	public String getHome(){
		return home;
	}
	public void setHome(String home){
		this.home=home;
	}

	public String getEducation(){
		return education;
	}
	public void setEducation(String education){
		this.education=education;
	}

}
