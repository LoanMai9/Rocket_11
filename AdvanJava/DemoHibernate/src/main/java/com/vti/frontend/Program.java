package com.vti.frontend;

import java.util.List;

import com.vti.entity.Exam;
import com.vti.entity.Group;
import com.vti.entity.Image;
import com.vti.entity.Question;
import com.vti.entity.RegistrationUserToken;
import com.vti.entity.ResetPasswordToken;
import com.vti.entity.TestingCategory;
import com.vti.entity.User;
import com.vti.repository.Repository;

public class Program {
	public static void main(String[] args) {

		Repository repository = new Repository();
		System.out.println("*****GET ALL TESTINGCATEGORY*****");
		List<TestingCategory> categories = repository.getAllCategories();
		for (TestingCategory category : categories) {
			System.out.println(category);
		}
		
		System.out.println("*****GET ALL USER***** ");
		
		List<User> users = repository.getAllUsers();
		for (User user : users) {
			System.out.println(user);
		}

		System.out.println("*****GET ALL GROUP*****");
		List<Group> Groups = repository.getAllGroups();
		for (Group Group : Groups) {
			System.out.println(Group);
		}
		
		System.out.println("*******GET ALL EXAM******");
		List<Exam> Exams = repository.getAllExams();
		for (Exam Exam : Exams) {
			System.out.println(Exam);
		}
		
		System.out.println("*****GET ALL IMAGE*****");
		List<Image> Images = repository.getAllImages();
		for (Image Image : Images) {
			System.out.println(Image);
		}
		
		System.out.println("*****GET ALL QUESTION*****");
		List<Question> Questions = repository.getAllQuestions();
		for (Question Question : Questions) {
			System.out.println(Question);
		}
		
		System.out.println("*****GET ALL RESET PASSWORD TOKEN*****");
		List<ResetPasswordToken> ResetPasswordTokens = repository.getAllResetPasswordTokens();
		for (ResetPasswordToken ResetPasswordToken : ResetPasswordTokens) {
			System.out.println(ResetPasswordToken);
		}
		
		System.out.println("*****GET ALL REGISTRATION USER TOKEN*****");
		List<RegistrationUserToken> RegistrationUserTokens = repository.getAllRegistrationUserTokens();
		for (RegistrationUserToken RegistrationUserToken : RegistrationUserTokens) {
			System.out.println(RegistrationUserToken);
		}
	}
}
