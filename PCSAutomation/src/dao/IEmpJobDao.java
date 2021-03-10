package dao;

import java.util.List;

import model.EmpJob;

public interface IEmpJobDao {
	
	List<EmpJob> getAllEmpjob(); 
	void addEmpJob(EmpJob empj);
	EmpJob getEmpJobById(int id);
	void updateEmpJob(EmpJob empj);
	void deactiveEmpJob(EmpJob empj);
	void active(EmpJob empj);
	void deleteEmpJob(int id);
}
