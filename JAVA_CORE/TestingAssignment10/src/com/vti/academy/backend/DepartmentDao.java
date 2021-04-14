package com.vti.academy.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.academy.entity.Department;

public class DepartmentDao {
	
	
	public DepartmentDao() {

	}
	// read data – get list departments
	// Tạo method để lấy ra danh sách tất cả các Department
	// Viết method getDepartments() và return ra
	// List<Department>, Nếu có lỗi sẽ throw Exception lên frontend để in ra

	public List<Department> getDepartments() throws SQLException, ClassNotFoundException {
		List<Department> departments = new ArrayList<>();
		// get connection
		String url = "jdbc:mysql://localhost:3306/TestingSystem1?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, username, password);
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 4: Excute Query
		Statement statement = connection.createStatement();
		// Step 4: execute query
		String sql = "SELECT * FROM Department";
		ResultSet resultSet = statement.executeQuery(sql);

		// Step 5: handling result set
		while (resultSet.next()) {
			Department department = new Department();
			department.setId(resultSet.getInt("DepartmentId"));
			department.setName(resultSet.getString("DepartmentName"));

			departments.add(department);
		}

		// disconnect
		connection.close();

		return departments;

	}

//	Trên backend sẽ viết method getDepartmentById(int id) và 
//	return ra Department
//	Nếu tìm thấy department có id = parameter thì sẽ return 
//	về department đó
//	Nếu không tìm thấy thì sẽ throw ra với message 
//	"Cannot find department which has id = " + id
//	Nếu có lỗi sẽ throw Exception lên front-end để in ra
	public Department getDepartmentByID(int id) throws SQLException, ClassNotFoundException {
		// get connection
		String url = "jdbc:mysql://localhost:3306/TestingSystem1?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, username, password);
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 4: Excute Query
		Statement statement = connection.createStatement();
		// Create a statement object
		String sql = "SELECT * FROM Department WHERE DepartmentId = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setInt(1, id);

		// Step 4: execute query
		ResultSet resultSet = preparedStatement.executeQuery();
		Department department = new Department();
		// Step 5: handling result set
		if (resultSet.next()) {
			department.setId(resultSet.getInt("DepartmentId"));
			department.setName(resultSet.getString("DepartmentName"));
		} else {
			System.err.println("Không thể tìm thấy id!");
		}
		return department;
	}
	// ktra xem tên có tồn tại chưa
	public boolean isDepartmentNameExists(String name) throws SQLException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/TestingSystem1?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, username, password);
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Create a statement object
		String sql = "SELECT 1 FROM Department WHERE DepartmentName = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setString(1, name);

		// Step 4: execute query
		ResultSet resultSet = preparedStatement.executeQuery();

		// Step 5: handling result set
		if (resultSet.next()) {
			connection.close();
			return true;

		} else {
			connection.close();
			return false;
		}
	}

	public void createDepartment(String name) throws SQLException, ClassNotFoundException {
		// check name exist
				if (isDepartmentNameExists(name)) {
					System.err.println("DepartmentName đã tồn tại");
				}

				// get connection
				String url = "jdbc:mysql://localhost:3306/TestingSystem1?autoReconnect=true&useSSL=false&characterEncoding=latin1";
				String username = "root";
				String password = "root";
				Connection connection = DriverManager.getConnection(url, username, password);
				Class.forName("com.mysql.cj.jdbc.Driver");

				// if not exist
				// Create a statement object
				String sql = "	INSERT INTO Department (DepartmentName)" + "	VALUE				(   ?	)";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				// set parameter
				preparedStatement.setString(1, name);

				// Step 4: execute query
				preparedStatement.executeUpdate();

				// disconnect
				connection.close();

	}
}
