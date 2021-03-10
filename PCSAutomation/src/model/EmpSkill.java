package model;

public class EmpSkill {
	private int esId;
	private int employeeId;
	private int skillId;
	private String experience;
	
	//Default Constructor
	public EmpSkill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//parameterized constructor method will all fields
	public EmpSkill(int esId, int employeeId, int skillId, String experience) {
		super();
		this.esId = esId;
		this.employeeId = employeeId;
		this.skillId = skillId;
		this.experience = experience;
	}
	
	//parameterized constructor method without skillId
	public EmpSkill(int employeeId, int skillId, String experience) {
		super();
		this.employeeId = employeeId;
		this.skillId = skillId;
		this.experience = experience;
	}
	
	//Generate getter and setter
	public int getEsId() {
		return esId;
	}

	public void setEsId(int esId) {
		this.esId = esId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	
}
