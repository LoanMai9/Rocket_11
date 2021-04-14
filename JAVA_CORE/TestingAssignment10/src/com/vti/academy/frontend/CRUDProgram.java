package com.vti.academy.frontend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.vti.academy.backend.DepartmentDao;
import com.vti.academy.entity.Department;

public class CRUDProgram {
	 static Scanner scanner = new Scanner(System.in);
	 public static void main(String[] args) throws ClassNotFoundException, SQLException {
		question1();
		question2_3();
		question5();
			
	}
	 public static void question1() throws ClassNotFoundException, SQLException {
		 List<Department> departments = new DepartmentDao().getDepartments();
		 for (Department department : departments) {
			System.out.println(department);
		}
		 
	 }
	 public static void question2_3() throws ClassNotFoundException, SQLException {
		System.out.println("Nhập vào id của department: ");
		
		int n = scanner.nextInt();
		Department department = new DepartmentDao().getDepartmentByID(n);
		System.out.println(department);
		scanner.close();
	}
	 public static void question5() throws ClassNotFoundException, SQLException {
		 System.out.println("Input department Name: ");
			String name = scanner.nextLine();

			new DepartmentDao().createDepartment(name);
			System.out.println("create success!");
		
	}
	 
//	 public static void updateData() throws SQLException {
//		// update
//					String sqlS = "UPDATE `User` "+"SET firstName = ? "+" WHERE id= ? ";
//					String firstName = "haha";
//					short id = 2;
//					PreparedStatement preparedStatement = connection.prepareStatement(sqlS);
//					
//					preparedStatement.setString(1, firstName);
//					preparedStatement.setShort(2, id);
//					
//					int effectedd = preparedStatement.executeUpdate();
//					System.out.println("thêm: "+effectedd);
//					connection.close();
//	}
}
