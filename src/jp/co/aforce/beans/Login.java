package jp.co.aforce.beans;

public class Login implements java.io.Serializable {

	private int num;
	private String id;
	private String password;

	public int getNum() {
		return num;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
