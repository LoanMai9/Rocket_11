package com.vti;

import java.util.List;

import com.vti.entity.TestingCategory;
import com.vti.entity.User;
import com.vti.repository.Repository;
import com.vti.repository.TestingCategoryRepository;

public class CategoryProgram {
	public static void main(String[] args) {
		TestingCategoryRepository repository = new TestingCategoryRepository();

		System.out.println("***********GET ALL CATEGORY***********");

		List<TestingCategory> categories = repository.getAllCategories();

		for (TestingCategory category : categories) {
			System.out.println(category);
		}
		
		Repository reposito = new Repository();
		System.out.println("-----Get User----- ");
		
		List<User> users = reposito.getAllUsers();
		
		for (User user : users) {
			System.out.println(user);
		}

//		System.out.println("\n\n***********GET CATEGORY BY ID***********");
//
//		TestingCategory categoryByid = repository.getCategoryByID((short) 2);
//		System.out.println(categoryByid);
//
//		System.out.println("\n\n***********GET CATEGORY BY NAME***********");
//
//		TestingCategory categoryByName = repository.getCategoryByName("C#");
//		System.out.println(categoryByName);
//
//		System.out.println("\n\n***********CREATE CATEGORY***********");
//
//		TestingCategory categoryCreate = new TestingCategory();
//		categoryCreate.setName("waiting");
//		repository.createCategory(categoryCreate);
//
//		System.out.println("\n\n***********UPDATE CATEGORY 1***********");
//
//		repository.updateCategory((short) 3, "C#");
//
//		System.out.println("\n\n***********UPDATE CATEGORY 2***********");
//
//		TestingCategory categoryUpdate = new TestingCategory();
//		categoryUpdate.setId((short) 2);
//		categoryUpdate.setName("SQL");
//		repository.updateCategory(categoryUpdate);
//
//		System.out.println("\n\n***********DELETE CATEGORY***********");
//		repository.deleteCategory((short) 2);
//
//		System.out.println("***********CHECK CATEGORY EXISTS BY ID***********");
//		System.out.println(repository.isCategoryExistsByID((short) 1));
//
//		System.out.println("***********CHECK CATEGORY EXISTS BY NAME***********");
//		System.out.println(repository.isCategoryExistsByName("SQL"));

	}
}
