package jdbc.entity;

public class Member {
	private int id;
	private String pwd;
	private String nickName;
	public Member() {
		this(0,null,null);
	}
	public Member(int id, String pwd, String nickName) {
		this.id = id;
		this.pwd = pwd;
		this.nickName = nickName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
}
