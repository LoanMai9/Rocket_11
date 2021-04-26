package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.User;
import com.vti.utils.JdbcUtils;

public class UserResponsitory implements IUserResponsitory {

	private List<User> users;

	public UserResponsitory() {
		users = new ArrayList<User>();
	}
	// in ra tất cả user
	public List<User> getListUser() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		JdbcUtils jdbcUtils = new JdbcUtils();
		Connection connection = jdbcUtils.connect();

		String sql = "Select * from UserManager ";
		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			User user = new User();
			user.setId(resultSet.getInt("id"));
			user.setFullName("fullName");
			user.setEmail(resultSet.getString("email"));

			users.add(user);

		}

		jdbcUtils.disconnect();
		return users;
	}
	//Viết function để user nhập vào id project, sau đó in ra tất cả các employee,Manager trong project đó
	public void findUserById(int id) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {

		JdbcUtils jdbcUtils = new JdbcUtils();
		Connection connection = jdbcUtils.connect();
		String sql = "Select * from UserManager WHERE projectid = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);

		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			System.out.println("Các User đang tham gia dự án");
			System.out.println("ID: " + resultSet.getInt("id"));
			System.out.println("FullName: " + resultSet.getString("fullName"));
			System.out.println("Email: " + resultSet.getString("email"));
		} else {
			System.out.println("Khong tim thay dự án có id: " + id);
		}

		jdbcUtils.disconnect();
	}
//	Viết function để user có thể lấy ra tất cả Manager của các project (in ra dạng
//			table)
	
	public void getManagerProject() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		JdbcUtils jdbcUtils = new JdbcUtils();
		Connection connection = jdbcUtils.connect();

		String sql = "SELECT * from UserManager LEFT JOIN project On UserManager.projectid = Project.projectId WHERE UserManager.`role` = 'MANAGER'";
		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery(sql);
		
		if (resultSet.next()) {
			System.out.println("Các Manager trong project: ");
			System.out.println("ID: " + resultSet.getInt("id"));
			System.out.println("FullName: " + resultSet.getString("fullName"));
			System.out.println("Email: " + resultSet.getString("email"));
		}

		jdbcUtils.disconnect();
		

	}

	
	private void menuManager() {
		System.out.println("1. Hiển thị User có sẵn.");
		System.out.println("2. Hiện thị những User đang trong dự án có id ");
		System.out.println("3. Hiển thị Manager của các project");
		System.out.println("4. Đăng xuất");
		System.out.println("5. Thêm User mới");
		System.out.println("0. Thoát chương trình");
	}
	
	private void menuEmployee()
	{
		System.out.println("Program is being completed!!!");
		
	}

	public int login(String role, String email, String password)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		JdbcUtils jdbcUtils = new JdbcUtils();
		Connection connection = jdbcUtils.connect();

		String sql = "SELECT * FROM UserManager WHERE email = ? AND `password` = ? AND `role` = ? ";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		preparedStatement.setString(3, role);

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {

			System.out.println("Xin chao: " + resultSet.getString("fullName"));
			if (role.equalsIgnoreCase("Manager")) {
				menuManager();
				return 1;
			} else {
				menuEmployee();
				return 2;

			}

		} else {
			System.out.println("Sai ten tai khoan hoac mat khau");
			return 0;
		}

	}
	public void addUser(String fullname, String email, String role, int expInYear)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		JdbcUtils jdbcUtils = new JdbcUtils();
		Connection connection = jdbcUtils.connect();

		String sql = "INSERT	INTO		UserManager	(	fullName			,	 email				,	`password`		,	`role`			,	expInYear		,	proSkill	) \r\n"
				+ "VALUE						(		?				, 		?				, 	'123456A'		, 		?			, 		?			,		null	)	";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setString(1, fullname); 
		preparedStatement.setString(2, email); 
		preparedStatement.setString(3, role); 
		preparedStatement.setInt(4, expInYear);

		int effectedRecordAmount = preparedStatement.executeUpdate(); 

		System.out.println("Effected Record Amount: " + effectedRecordAmount);
		jdbcUtils.disconnect();

	}

	public void addUserr(String fullname, String email, String role,int projectId, String proSkill)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		JdbcUtils jdbcUtils = new JdbcUtils();
		Connection connection = jdbcUtils.connect();

		String sql = "INSERT	INTO		UserManager	(	fullName			,	 email				,	`password`		,	`role`			,	expInYear		,	proSkill	) \r\n"
				+ "VALUE						(		?				, 		?				, 	'123456A'		, 		?			, 		null		,		?		)	";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setString(1, fullname);
		preparedStatement.setString(2, email);
		preparedStatement.setString(3, role);
		preparedStatement.setInt(4, projectId);
		preparedStatement.setString(5, proSkill);
		
		int effectedRecordAmount = preparedStatement.executeUpdate();
		
		System.out.println("Effected Record Amount: " + effectedRecordAmount);
		jdbcUtils.disconnect();

	}
	public void deleteUserById(int id) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		if (checkIDUser(id) == false) {
			System.out.println("Khong ton tai user");
		} else {
			JdbcUtils jdbcUtils = new JdbcUtils();
			Connection connection = jdbcUtils.connect();
			String sql = "DELETE from `user` WHERE id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			int effectedRecordAmount = preparedStatement.executeUpdate();

			System.out.println("Effected Record Amount: " + effectedRecordAmount);
			jdbcUtils.disconnect();

		}
	}

	public boolean checkIDUser(int id) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		JdbcUtils jdbcUtils = new JdbcUtils();
		Connection connection = jdbcUtils.connect();
		String sql = "SELECT * FROM UserManager WHERE id = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {

			jdbcUtils.disconnect();
			return true;
		} else {
			jdbcUtils.disconnect();
			return false;
		}

	}
}
