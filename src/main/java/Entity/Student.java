package Entity;

public class Student {
	
	private int stdid;
	private String stdname;
	private String stdemail;
	private int stdrollno;
	private String stdPassword;
	public int getStdid() {
		return stdid;
	}
	
	

	public void setStdid(int stdid) {
		this.stdid = stdid;
	}
	public String getStdname() {
		return stdname;
	}
	public void setStdname(String stdname) {
		this.stdname = stdname;
	}
	public String getStdemail() {
		return stdemail;
	}
	public void setStdemail(String stdemail) {
		this.stdemail = stdemail;
	}
	public int getStdrollno() {
		return stdrollno;
	}
	public void setStdrollno(int stdrollno) {
		this.stdrollno = stdrollno;
	}
	
	public String getStdPassword() {
		return stdPassword;
	}

	public void setStdPassword(String stdPassword) {
		this.stdPassword = stdPassword;
	}



	@Override
	public String toString() // to print the object in console 
	{
		return "Student [stdid=" + stdid + ", stdname=" + stdname + ", stdemail=" + stdemail + ", stdrollno="
				+ stdrollno + ",stdPassword= " + stdPassword +"]";
	}
	
	
	
	
	
}
