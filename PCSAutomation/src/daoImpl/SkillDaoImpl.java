package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import config.JDBCConnection;
import dao.ISkillDao;
import model.Skill;

public class SkillDaoImpl implements ISkillDao {
	Connection conn=null;
	
	public SkillDaoImpl() {
		conn=JDBCConnection.getDBConnection();
	}

	@Override
	public List<Skill> getAllSkills() {
		List<Skill> skList=new ArrayList<Skill>();
		try {
			String query="select * from Skill";
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery(query);
			if(rst!=null) {
				while(rst.next()) {
					Skill sk=new Skill();
					sk.setSkillId(rst.getInt(1));
					sk.setSkillName(rst.getString(2));
					sk.setSkillDescription(rst.getString(3));
					sk.setActive(rst.getString(4));
					skList.add(sk);
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex);
		}
		return skList;
	}

	@Override
	public void addSkill(Skill sk) {
		try {
			String query="insert into Skill(SkillName, SkillDescription, Active) values(?,?,?)";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setString(1,sk.getSkillName());
			pst.setString(2,sk.getSkillDescription());
			pst.setString(3,sk.getActive());
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
	public Skill getSkillById(int id) {
		Skill sk=new Skill();
		try {
			String query="select * from Skill where SkillId=?";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1,id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				while(rst.next()) {
					sk.setSkillId(rst.getInt(1));
					sk.setSkillName(rst.getString(2));
					sk.setSkillDescription(rst.getString(3));
					sk.setActive(rst.getString(4));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex);
		}
		return sk;
	}

	@Override
	public void updateSkill(Skill sk) {
		try {
			String query = "UPDATE Skill SET skillname=?, skilldescription=? WHERE SkillId=?";
		
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, sk.getSkillName());
			statement.setString(2, sk.getSkillDescription());
			statement.setInt(3,sk.getSkillId());		 
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
	public void deactivateSkill(Skill sk) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Skill set Active=? where SkillId=?");
			pst.setString(1, "Deactive");
			pst.setInt(2, sk.getSkillId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Skill deactivated...");
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
	public void activateSkill(Skill sk) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Skill set Active=? where SkillId=?");
			pst.setString(1, "Active");
			pst.setInt(2, sk.getSkillId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Skill Activated...");
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
	public void deleteSkill(int id) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("delete from Skill where SkillId=?");
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Skill deleted...");
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
