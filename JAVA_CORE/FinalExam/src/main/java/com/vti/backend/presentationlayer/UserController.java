
package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.IUserService;
import com.vti.backend.businesslayer.UserService;
import com.vti.entity.User;

public class UserController {

	private IUserService iUserService;
	
	public UserController()
	{
		iUserService = new UserService();
	}
	
	public List<User> getListUser() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException
	{
		return iUserService.getListUser();
	}
	
	public void findUserById(int id) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException
	{
		iUserService.findUserById(id);
	}
	
	public int login(String role, String email, String password) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException
	{
		return iUserService.login(role, email, password);
	}
	public void getManagerProject() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException{
		iUserService.getManagerProject();
	}
	
	public void deleteUserById(int id) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException
	{
		iUserService.deleteUserById(id);
	}
	
	public void addUser(String fullname, String email, String role, int expInYear) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException
	{
		iUserService.addUser(fullname, email, role, expInYear);
	}
	
	public void addUserr(String fullname, String email, String role,int projectId, String proSkill) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException
	{
		iUserService.addUserr(fullname, email, role, projectId, proSkill);
	}
}
