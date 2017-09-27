package model;

public class User {
	private int userid;
	private String username;
	private String password;
	private boolean admin;

	public User(String u, String p, boolean admin) {
		username = u;
		password = p;
		this.admin = admin;
	}

	public User() {
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof User))
			return false;
		User user = (User) obj;
		return user.getUsername().equals(this.username) 
				&& user.getPassword().equals(this.password);
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result += 31 * this.username.hashCode();
		result += 31 * this.password.hashCode();
		return result;
	}

}
