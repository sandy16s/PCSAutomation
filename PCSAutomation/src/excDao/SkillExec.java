package excDao;

import java.util.Iterator;
import java.util.List;
import java.io.*;
import controller.SkillController;
import model.Skill;

public class SkillExec {

	SkillController skController=null;
	
	public SkillExec() {
		skController=new SkillController();
	}
	
	public void getAllSkills() {
		List<Skill> skList=skController.getAllSkills();
		for(Skill sk:skList) {
			System.out.println(sk);
		}
	}
	
	public void getSkillById() {
		int id=0;
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter skill id whose record you want to view:");
			id=Integer.parseInt(reader.readLine());
		}
		catch(IOException ex){
			System.out.println(ex);
		}
		Skill sk=skController.getSkillById(id);
		System.out.println(sk);
	}
	
	public void addSkill() {
		Skill sk=new Skill();
	
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Skill Detail:");
			System.out.println("Skill Name:");
			sk.setSkillName(reader.readLine());
			System.out.println("Skill Description:");
			sk.setSkillDescription(reader.readLine());
			System.out.println("Skill Active or Deactive:");
			sk.setActive(reader.readLine());
			
		}catch(IOException ex){
			System.out.println(ex);
		}
		skController.addSkill(sk);
	}
	
	public void updateSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter SkillId whose record you want to update:");
			id=Integer.parseInt(reader.readLine());
			Skill sk=skController.getSkillById(id);
				skController.updateSkill(sk);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deactiveSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter SkillId whose record you want to deactivate:");
			id=Integer.parseInt(reader.readLine());
			Skill sk=skController.getSkillById(id);
			skController.deactivateSkill(sk);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void activeSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter SkillId whose record you want to activate:");
			id=Integer.parseInt(reader.readLine());
			Skill sk=skController.getSkillById(id);
			skController.activateSkill(sk);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deleteSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter SkillId whose record you want to delete:");
			id=Integer.parseInt(reader.readLine());
			skController.deleteSkill(id);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
}