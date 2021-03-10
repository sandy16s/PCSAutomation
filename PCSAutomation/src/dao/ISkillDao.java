package dao;

import java.util.List;
import model.Skill;

public interface ISkillDao {

	List<Skill> getAllSkills();
	void addSkill(Skill sk);
	Skill getSkillById(int id);
	void updateSkill(Skill sk);
	void deactivateSkill(Skill sk);
	void activateSkill(Skill sk);
	void deleteSkill(int id);
}
