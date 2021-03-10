package entry;

import java.sql.SQLException;
import java.util.Scanner;

import config.JDBCConnection;
import excDao.SkillExec;

public class TestAppSkill {

	public void testConnection() {
	
			try {
				if(JDBCConnection.getDBConnection().isClosed()) {
					System.out.println("Connection is closed");
				}
				else {
					System.out.println("Connection is Opened");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
	}
	public void processMenu() {
		SkillExec obj=new SkillExec();
		Scanner sc=new Scanner(System.in);
		int option=0;
		char ch='y';
		do {
			System.out.println("----------CRUD Operation-----------");
			System.out.println("1. View all Skills");
			System.out.println("2. View single Skill");
			System.out.println("3. Add Skill");
			System.out.println("4. Update Skill");
			System.out.println("5. Delete Skill");
			System.out.println("6. Deactivate Skill");
			System.out.println("7. Activate Skill");
			System.out.println("8. Quit");
			System.out.println("___________________");
			System.out.println("Enter your choice:");
			option=sc.nextInt();
			switch(option) {
				case 1:
					obj.getAllSkills();
					break;
				case 2:
					obj.getSkillById();
					break;
				case 3:
					obj.addSkill();
					break;
				case 4:
					obj.updateSkill();
					break;
				case 5:
					obj.deleteSkill();
					break;
				case 6:
					obj.deactiveSkill();
					break;
				case 7:
					obj.activeSkill();
					break;
				case 8:
					System.exit(0);
					break;
				default:
					System.out.println("Wrong input!");
					break;
			}
			System.out.println("Do you want to continue(y/n)?");	
			ch=sc.next().charAt(0);
		}while(ch=='y' || ch=='Y');
		
	}
	public static void main(String[] args) {
		TestAppSkill test=new TestAppSkill();
		//test.testConnection();
		test.processMenu();
		
	}

}