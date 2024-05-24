package Model;

public class MLecture {

	private int code;
	private String lName;
	private String professor;
	private int credit;
	private String time;
	
	//constructor to initialize all fields
	public MLecture(int code,String lName, String professor, int credit,String time) {
		this.code = code;
		this.lName = lName;
		this.professor = professor;
		this.credit = credit;
		this.time = time;
	}
	
	
	
	//getters and setters
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	

}
