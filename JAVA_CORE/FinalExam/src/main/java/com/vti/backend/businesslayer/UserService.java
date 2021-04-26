
package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.IUserResponsitory;
import com.vti.backend.datalayer.UserResponsitory;
import com.vti.entity.User;

public class UserService implements IUserService{
	
	private IUserResponsitory iUserResponsitory;
	
	public UserService()
	{
		iUserResponsitory = new UserResponsitory();
	}
	
	
	public List<User> getListUser() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		return iUserResponsitory.getListUser();
	}

	public void findUserById(int id) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		iUserResponsitory.findUserById(id);
		
	}

	public int login(String role, String email, String password)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		return iUserResponsitory.login(role, email, password);
		
	}
	public void getManagerProject() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException{
		iUserResponsitory.getManagerProject();
	}

	
	public void deleteUserById(int id) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		iUserResponsitory.deleteUserById(id);
		
	}

	public void addUser(String fullname, String email, String role, int expInYear)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		iUserResponsitory.addUser(fullname, email, role, expInYear);
		
	}

	public void addUserr(String fullname, String email, String role,int projectId, String proSkill)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		iUserResponsitory.addUserr(fullname, email, role, projectId, proSkill);
		
	}
}
