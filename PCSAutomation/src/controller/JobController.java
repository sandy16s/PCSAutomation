package controller;

import java.util.List;

import dao.IJobDao;
import daoImpl.JobDaoImpl;
import model.Job;

public class JobController {
	
IJobDao jbDao=null;
	
	public JobController() {
		jbDao=new JobDaoImpl();
	}
	
	public List<Job> getAllJobs(){
		List<Job> jbList=jbDao.getAllJobs();
		return jbList;
	}
	
	public void addJob(Job jb) {
		jbDao.addJob(jb);
	}
	public Job getJobById(int id) {
		Job jb=jbDao.getJobById(id);
		return jb;
	}
	public void updateJob(Job jb) {
		jbDao.updateJob(jb);
	}
	public void deleteJob(int id) {
		jbDao.deleteJob(id);
	}
	public void deactivateJob(Job jb) {
		jbDao.deactivateJob(jb);
	}
	public void activateJob(Job jb) {
		jbDao.activateJob(jb);
	}

}
