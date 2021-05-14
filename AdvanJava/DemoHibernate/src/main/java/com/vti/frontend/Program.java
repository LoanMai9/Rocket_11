package com.vti.frontend;

import java.util.List;
import java.util.Scanner;

import com.vti.entity.Exam;
import com.vti.entity.Group;
import com.vti.entity.Image;
import com.vti.entity.Question;
import com.vti.entity.RegistrationUserToken;
import com.vti.entity.ResetPasswordToken;
import com.vti.entity.TestingCategory;
import com.vti.entity.User;
import com.vti.entity.UserGroup;
import com.vti.repository.Repository;

public class Program {
	public static void main(String[] args) {

		Repository repository = new Repository();
		Scanner scanner = new Scanner(System.in);
		int choose;
		do {
			menu();
			choose = scanner.nextInt();
			System.out.print("Mời bạn chọn chức năng:");
			switch (choose) {
			case 1:
				System.out.println("***********GET ALL TESTING CATEGORY***********");
				List<TestingCategory> TestingCategorys = repository.getAllCategories();
				for (TestingCategory TestingCategory : TestingCategorys) {
					System.out.println(TestingCategory);
				}
				break;
			case 2:
				System.out.println("***********GET ALL GROUP***********");
				List<Group> Groups = repository.getAllGroups();
				for (Group Group : Groups) {
					System.out.println(Group);
				}
				break;
			case 3:
				System.out.println("***********GET ALL USER***********");
				List<User> Users = repository.getAllUsers();
				for (User User : Users) {
					System.out.println(User);
				}
				break;
			case 4:
				System.out.println("***********GET ALL REGISTRATION USER TOKEN***********");
				List<RegistrationUserToken> RegistrationUserTokens = repository.getAllRegistrationUserTokens();
				for (RegistrationUserToken RegistrationUserToken : RegistrationUserTokens) {
					System.out.println(RegistrationUserToken);
				}
				break;
			case 5:
				
				System.out.println("***********GET ALL EXAM***********");
				List<Exam> Exams = repository.getAllExams();
				for (Exam Exam : Exams) {
					System.out.println(Exam);
				}
				break;
			case 6:
				System.out.println("***********GET ALL IMAGE***********");
				List<Image> Images = repository.getAllImages();
				for (Image Image : Images) {
					System.out.println(Image);
				}
				break;
			case 7:
				System.out.println("***********GET ALL QUESTION***********");
				List<Question> Questions = repository.getAllQuestions();
				for (Question Question : Questions) {
					System.out.println(Question);
				}
				break;
			case 8:
				System.out.println("***********GET ALL RESET PASSWORD TOKEN***********");
				List<ResetPasswordToken> ResetPasswordTokens = repository.getAllResetPasswordTokens();
				for (ResetPasswordToken ResetPasswordToken : ResetPasswordTokens) {
					System.out.println(ResetPasswordToken);
				}
				break;
			case 9:
				System.out.println("***********GET ALL USER GROUP***********");
				List<UserGroup> UserGroups = repository.getAllUserGroups();
				for (UserGroup UserGroup : UserGroups) {
					System.out.println(UserGroup);
				}
				break;
			case 0:
				System.out.println("Thoát!");
				return;
			default:
				break;
			}
		} while(choose != 0);
	}
	
	public static void menu() {
		System.out.println("------MENU------");
		System.out.println("1. TestingCategory");
		System.out.println("2. Group");
		System.out.println("3. User");
		System.out.println("4. RegistrationUserToken");
		System.out.println("5. Exam");
		System.out.println("6. Image");
		System.out.println("7. Question");
		System.out.println("8. ResetPasswordToken");
		System.out.println("9. Group User");
		System.out.println("0. Thoát");
	}
}
