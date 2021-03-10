package model;

public class EmpJob {

	private int EJId;
	private int employeeId;
	private int jobId;
	private String recruited;
	
	//default constructor method
	public EmpJob() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//parameterized constructor method will all fields
	public EmpJob(int eJId, int employeeId, int jobId, String recruited) {
		super();
		EJId = eJId;
		this.employeeId = employeeId;
		this.jobId = jobId;
		this.recruited = recruited;
	}
	
	//parameterized constructor method without EJId
	public EmpJob(int employeeId, int jobId, String recruited) {
		super();
		this.employeeId = employeeId;
		this.jobId = jobId;
		this.recruited = recruited;
	}
	
	//getter and setter methods
	public int getEJId() {
		return EJId;
	}

	public void setEJId(int eJId) {
		EJId = eJId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getRecruited() {
		return recruited;
	}

	public void setRecruited(String recruited) {
		this.recruited = recruited;
	}
	
	//generate toString()
	@Override
	public String toString() {
		return "EmpJob [EJId=" + EJId + ", employeeId=" + employeeId + ", jobId=" + jobId + ", recruited=" + recruited
				+ "]";
	}
		
}
