package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HraHomeFrame extends JFrame{

	Container container;
	
	JButton bLogout, bActivate, bViewAllEmployee, bAddSkill;
	public HraHomeFrame() {
		container=getContentPane();
		
		bLogout=new JButton("LOGOUT");
		bLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				callDispose();
				new LoginFrame();
			}
			
		});
		
		bActivate=new JButton("ACTIVATE USERS");
		
		bActivate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				callDispose();
				new ActivateFrame();
				
			}
			
		});
		
		bViewAllEmployee=new JButton("VIEW ALL EMPLOYESS");
		
		bViewAllEmployee.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				callDispose();
				new ViewAllEmployeeFrame();
			}
			
		});
		
		bAddSkill=new JButton("ADD SKILL");
		
		bViewAllEmployee.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				callDispose();
				new AddSkillFrame();
			}
			
		});
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("HRA HOME");
		this.setVisible(true);
		this.setBounds(10, 10, 500, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); // fixed size frame
	}
	
	public void setLayoutManager() {
		container.setLayout(null);
	}
	
	public void setLocationAndSize() {
		bLogout.setBounds(100, 250, 300, 30);
		bActivate.setBounds(100, 150, 300, 30);
		bViewAllEmployee.setBounds(100, 200, 300, 30);
		bAddSkill.setBounds(100, 100, 300, 30);
	}
	
	public void addComponentsToContainer() {
		container.add(bLogout);
		container.add(bActivate);
		container.add(bViewAllEmployee);
		container.add(bAddSkill);
	}
	
	public void callDispose() {
		this.dispose();
	}
}