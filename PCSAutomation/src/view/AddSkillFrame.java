package view;

import java.awt.Container;

import javax.swing.*;

public class AddSkillFrame extends JFrame {

	Container container;
	public AddSkillFrame() {
		container=getContentPane();
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("ADD SKILL");
		this.setVisible(true);
		this.setBounds(10, 10, 500, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	private void addComponentsToContainer() {
		// TODO Auto-generated method stub
		
	}
	private void setLocationAndSize() {
		// TODO Auto-generated method stub
		
	}
	private void setLayoutManager() {
		// TODO Auto-generated method stub
		
}
}
