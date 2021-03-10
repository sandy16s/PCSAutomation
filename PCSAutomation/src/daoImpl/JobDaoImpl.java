package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.IJobDao;
import model.Job;

public class JobDaoImpl implements IJobDao {
	
Connection conn=null;
	
	public JobDaoImpl() {
		conn=JDBCConnection.getDBConnection();
	}

	@Override
	public List<Job> getAllJobs() {
		List<Job> jbList=new ArrayList<Job>();
		try {
			String query="select * from Job";
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery(query);
			if(rst!=null) {
				while(rst.next()) {
					Job jb=new Job();
					jb.setJobId(rst.getInt(1));
					jb.setJobTitle(rst.getString(2));
					jb.setJobDescription(rst.getString(3));
					jb.setCompanyName(rst.getString(4));
					jb.setLocation(rst.getString(5));
					jb.setKeySkill(rst.getString(6));
					jb.setSalary(rst.getString(7));
					jb.setExperience(rst.getString(8));
					jb.setActive(rst.getString(9));
					jbList.add(jb);
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex);
		}
		return jbList;
	}

	@Override
	public void addJob(Job jb) {
		try {
			String query="insert into Job(JobTitle, JobDescription, CompanyName, Location, KeySkill, Salary, Experience, Active) values(?,?,?,?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setString(1,jb.getJobTitle());
			pst.setString(2,jb.getJobDescription());
			pst.setString(3,jb.getCompanyName());
			pst.setString(4,jb.getLocation());
			pst.setString(5,jb.getKeySkill());
			pst.setString(6,jb.getSalary());
			pst.setString(7,jb.getExperience());
			pst.setString(8,jb.getActive());
			int i=pst.executeUpdate();
			if(i==1) {
				System.out.println("1 record inserted...");
			}
			else {
				System.out.println("Insertion failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex);
		}
		
	}

	@Override
	public Job getJobById(int id) {
		Job jb=new Job();
		try {
			String query="select * from Job where JobId=?";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1,id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				while(rst.next()) {
					jb.setJobId(rst.getInt(1));
					jb.setJobTitle(rst.getString(2));
					jb.setJobDescription(rst.getString(3));
					jb.setCompanyName(rst.getString(4));
					jb.setLocation(rst.getString(5));
					jb.setKeySkill(rst.getString(6));
					jb.setSalary(rst.getString(7));
					jb.setExperience(rst.getString(8));
					jb.setActive(rst.getString(9));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex);
		}
		return jb;
	}

	@Override
	public void updateJob(Job jb) {
		try {
			String query = "UPDATE Job SET jobtitle=?, jobdescription=?, companyname=?, location=?, keyskill=?, salary=?, experience=? WHERE JobId=?";
		
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, jb.getJobTitle());
			statement.setString(2, jb.getJobDescription());
			statement.setString(3, jb.getCompanyName());
			statement.setString(4, jb.getLocation());
			statement.setString(5, jb.getKeySkill());
			statement.setString(6, jb.getSalary());
			statement.setString(7, jb.getExperience());
			statement.setInt(8,jb.getJobId());		 
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing user was updated successfully!");
			}
			else {
				System.out.println("updation failed...");
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
	}

	@Override
	public void deactivateJob(Job jb) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Job set Active=? where JobId=?");
			pst.setString(1, "Deactive");
			pst.setInt(2, jb.getJobId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Job deactivated...");
			}
			else {
				System.out.println("updation failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

	@Override
	public void activateJob(Job jb) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Job set Active=? where JobId=?");
			pst.setString(1, "Active");
			pst.setInt(2, jb.getJobId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Job Activated...");
			}
			else {
				System.out.println("updation failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

	@Override
	public void deleteJob(int id) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("delete from Job where JobId=?");
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Job deleted...");
			}
			else {
				System.out.println("deletion failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
}
