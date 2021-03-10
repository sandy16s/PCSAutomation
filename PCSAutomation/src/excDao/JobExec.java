package excDao;

import java.util.Iterator;
import java.util.List;
import java.io.*;
import controller.JobController;
import model.Job;

public class JobExec {

	JobController jbController=null;
	
	public JobExec() {
		jbController=new JobController();
	}
	
	public void getAllJobs() {
		List<Job> jbList=jbController.getAllJobs();
		for(Job jb:jbList) {
			System.out.println(jb);
		}
	}
	
	public void getJobById() {
		int id=0;
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter job id whose record you want to view:");
			id=Integer.parseInt(reader.readLine());
		}
		catch(IOException ex){
			System.out.println(ex);
		}
		Job jb=jbController.getJobById(id);
		System.out.println(jb);
	}
	
	public void addJob() {
		Job jb=new Job();
	
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Job Detail:");
			System.out.println("Job Title:");
			jb.setJobTitle(reader.readLine());
			System.out.println("Job Description:");
			jb.setJobDescription(reader.readLine());
			System.out.println("Company Name:");
			jb.setCompanyName(reader.readLine());
			System.out.println("Location:");
			jb.setLocation(reader.readLine());
			System.out.println("Key Skill:");
			jb.setKeySkill(reader.readLine());
			System.out.println("Salary:");
			jb.setSalary(reader.readLine());
			System.out.println("Experience:");
			jb.setExperience(reader.readLine());
			System.out.println("Active:");
			jb.setActive(reader.readLine());
		}catch(IOException ex){
			System.out.println(ex);
		}
		jbController.addJob(jb);
	}
	
	public void updateJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			String salary, experience, confirmexperience;
			System.out.println("Enter JobId whose record you want to update:");
			id=Integer.parseInt(reader.readLine());
			Job jb=jbController.getJobById(id);
			System.out.println("Enter your new salary:");
			salary=reader.readLine();
			System.out.println("Enter your new experience:");
			experience=reader.readLine();
			System.out.println("Re-enter same experience to confirm:");
			confirmexperience=reader.readLine();
			if(experience.equals(confirmexperience)) {
				jb.setExperience(experience);
				jb.setSalary(salary);
				jbController.updateJob(jb);
			}
			else {
				System.out.println("Sorry! you have entered different experience!");
			}
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deactiveJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter JobId whose record you want to deactivate:");
			id=Integer.parseInt(reader.readLine());
			Job jb=jbController.getJobById(id);
			jbController.deactivateJob(jb);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void activeJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter JobId whose record you want to activate:");
			id=Integer.parseInt(reader.readLine());
			Job jb=jbController.getJobById(id);
			jbController.activateJob(jb);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deleteJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter JobId whose record you want to delete:");
			id=Integer.parseInt(reader.readLine());
			jbController.deleteJob(id);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
}