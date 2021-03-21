import java.util.Date;

public class FlowControl {
	public static void main(String[] args) {
		Department department1 = new Department();
		department1.id = 1;
		department1.name = "Sale";

		Department department2 = new Department();
		department2.id = 2;
		department2.name = "Makerting";

		Department department3 = new Department();
		department3.id = 3;
		department3.name = "Security";

		Position position1 = new Position();
		position1.id = 1;
		position1.name = PositionName.DEV;

		Position position2 = new Position();
		position2.id = 2;
		position2.name = PositionName.PM;

		Position position3 = new Position();
		position3.id = 3;
		position3.name = PositionName.SCRUMMASTER;

		Account account1 = new Account();
		account1.id = 1;
		account1.email = "nguyentrunganh@gmail.com";
		account1.fullName = "Nguyễn Trung Anh";
		account1.userName = "trunganh";
		account1.createDate = new Date("1997/08/01");
		account1.department = department2;
		account1.position = position1;

		Account account2 = new Account();
		account2.id = 2;
		account2.email = "hoangdinhthang@gmail.com";
		account2.fullName = "Hoàng Đình Thắng";
		account2.userName = "dinhthang";
		account2.createDate = new Date("1999/06/05");
		account2.department = department3;
		account2.position = position3;

		Account account3 = new Account();
		account3.id = 3;
		account3.email = "maianhtuan@gmail.com";
		account3.fullName = "Mai Anh Tuấn";
		account3.userName = "anhtuan";
		account3.createDate = new Date("1998/09/08");
		account3.department = department1;

		// TestingSystemAsssignment2
		// question1
		System.out.println("Question 1: ");
		if (account2.department == null) {
			System.out.println("Nhân viên này chưa có phòng ban");

		} else
			System.out.println("Phòng ban của nhân viên này là :" + account2.department.name);

		// question2
		System.out.println("Question 2: ");
		if (account2.groups == null) {
			System.out.println("Nhân viên này chưa có group");
			// .length là lấy độ dài mảng
		} else if (account2.groups.length == 1 || account2.groups.length == 2) {
			System.out.println("Group của nhân viên này là Java Fresher, C# fresher");
		} else if (account2.groups.length == 3) {
			System.out.println("Nhân viên này là người quan trọng");
		} else {
			System.out.println("Nhân viên này là người hóng chuyện.");
		}

		// question 3
		System.out.println("Question 3: ");
		System.out.println(
				account2.department == null ? "Nvien chưa có pban" : "pban nhan vien la : " + account2.department.name);

		// question 4
		System.out.println("Question 4: ");
		System.out.println(account1.position == position1 ? "Đây là Deverloper" : "kphai");

		// switch case
		// question 5
		/*
		 * Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau: Nếu số
		 * lượng account = 1 thì in ra "Nhóm có một thành viên" Nếu số lượng account = 2
		 * thì in ra "Nhóm có hai thành viên" Nếu số lượng account = 3 thì in ra
		 * "Nhóm có ba thành viên" Còn lại in ra "Nhóm có nhiều thành viên"
		 */
		System.out.println("Question 5: ");
//		switch (account1.groups.length) {
//		case 1:
//			System.out.println("Nhóm có 1 thành viên");
//			break;
//		case 2:
//			System.out.println("Nhóm có 2 thành viên");
//			break;
//		case 3:
//			System.out.println("Nhóm có 3 thành viên");
//			break;
//		case 4:
//			System.out.println("Nhóm có nhiều thành viên");
//			break;
//		default:
//			break;
//		}
		Account[] account = { account1, account2, account3 };
		// question 8
		System.out.println("Question 8: ");
		for (Account accounts : account) {
			System.out.println("Email: " + accounts.email);
			System.out.println("fullname: " + accounts.fullName);
			System.out.println("phong ban: " + accounts.department.name);
			System.out.println("\n");
		}
		// question 9
		System.out.println("Question 9: ");
		Department[] departments = { department1, department2 };
		for (Department department : departments) {
			System.out.println("Id: " + department.id);
			System.out.println("Name: " + department.name);
		}
		// question 10

		System.out.println("Question 10: ");
		for (int i = 0; i < account.length; i++) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là: \n");
			System.out.println("Email: " + account[i].email);
			System.out.println("Full name: " + account[i].fullName);
			System.out.println("Phòng ban: " + account[i].department.name);
			System.out.println("\n");
		}
		// question 11

		System.out.println("Question 11: ");
		for (int i = 0; i < departments.length; i++) {
			System.out.println("Thông tin phòng ban thứ " + (i + 1) + " là: \n");
			System.out.println("id: " + departments[i].id);
			System.out.println("name: " + departments[i].name);
			System.out.println("\n");
		}
		// Question 12
		System.out.println("12,");
		for (int i = 0; i < 2; i++) {
			System.out.println("Thông tin phòng ban thứ " + (i + 1) + " là :");
			System.out.println("Id: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
			System.out.println("\n");
		}
		// Question 13
		System.out.println("13,");
		for (int i = 0; i < account.length; i++) {
			if (i == 1) {
				continue;
			}
			System.out.println("Thông tin account thứ " + (i + 1) + " là: \n");
			System.out.println("Email: " + account[i].email);
			System.out.println("Full name: " + account[i].fullName);
			System.out.println("Phòng ban: " + account[i].department.name);
			System.out.println("\n");
		}
		// Question 14
		System.out.println("14,");
		for (int i = 0; i < account.length; i++) {
			if (account[i].id < 4) {
				System.out.println("Thông tin account thứ " + (i + 1) + " là: \n");
				System.out.println("Email: " + account[i].email);
				System.out.println("Full name: " + account[i].fullName);
				System.out.println("Phòng ban: " + account[i].department.name);
				System.out.println("\n");
			}
		}
		// Question 15
		System.out.println("15,");
		for (int i = 0; i <= 20; i = i + 2) {
			System.out.println(i);
		}
		// Lệnh While
		System.out.println("Question 10 bằng while: ");
		int i = 0;
		while (i < account.length) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là: \n");
			System.out.println("Email: " + account[i].email);
			System.out.println("Full name: " + account[i].fullName);
			System.out.println("Phòng ban: " + account[i].department.name);
			System.out.println("\n");
			i++;
		}
		System.out.println("Question 11 bằng while: ");
		i=0;
		while (i < departments.length) {
			System.out.println("Thông tin phòng ban thứ " + (i + 1) + " là: \n");
			System.out.println("id: " + departments[i].id);
			System.out.println("name: " + departments[i].name);
			System.out.println("\n");
			i++;
			
		}
		
		System.out.println("Question 12 bằng while: ");
		i=0;
		while (i <2) {
			System.out.println("Thông tin phòng ban thứ " + (i + 1) + " là: \n");
			System.out.println("id: " + departments[i].id);
			System.out.println("name: " + departments[i].name);
			System.out.println("\n");
			i++;
		}
		
		System.out.println("Question 13 bằng while: ");
		i=0;
		while (i < account.length) {
			if (i == 1) {
				continue;
			}
			System.out.println("Thông tin account thứ " + (i + 1) + " là: \n");
			System.out.println("Email: " + account[i].email);
			System.out.println("Full name: " + account[i].fullName);
			System.out.println("Phòng ban: " + account[i].department.name);
			System.out.println("\n");
			i++;
		}
		// Question 15 bằng while
				i=0;
				while (i <= 20) {
					if (i % 2 == 0) {
						System.out.println(i);
					}
					i++;
				}
		// do while
				// question 10 
				i = 0;
				do {
					System.out.println("thông tin account thứ " + (i + 1) + " là:");
					System.out.println("Email: " + account[i].email);
					System.out.println("Full Name: " + account[i].fullName);
					System.out.println("Phòng ban: " + account[i].department.name);
					System.out.println("\n");
					i++;
				} while (i < account.length);

				// Question 11
				i = 0;
				do {
					System.out.println("Thông tin phòn ban thứ " + (i + 1) + " là :");
					System.out.println("Id: " + departments[i].id);
					System.out.println("Name: " + departments[i].name);
					System.out.println("\n");
					i++;
				} while (i < departments.length);

				// Question 12
				i = 0;
				do {
					System.out.println("Thông tin pban thứ " + (i + 1) + " là :");
					System.out.println("Id: " + departments[i].id);
					System.out.println("Name: " + departments[i].name);
					System.out.println("\n");
					i++;
				} while (i < 2);

				// Question 13
				i = 0;
				do {
					if (i == 1) {
						i++;
						continue;
					}
					System.out.println("Thông tin account thứ " + (i + 1) + " là :");
					System.out.println("Email: " + account[i].email);
					System.out.println("Full Name: " + account[i].fullName);
					System.out.println("Phòng ban: " + account[i].department.name);
					System.out.println("\n");
					i++;
				} while (i < account.length);

				// Question 14
				i = 0;
				do {
					if (account[i].id >= 4) {
						break;
					}
					System.out.println("Thông tin pban thứ " + (i + 1) + " là :");
					System.out.println("Email: " + account[i].email);
					System.out.println("Full Name: " + account[i].fullName);
					System.out.println("Phòng ban: " + account[i].department.name);
					System.out.println("\n");
					i++;
				} while (i < account.length);

				// Question 15
				i = 0;
				do {
					if (i % 2 == 0) {
						System.out.println(i);
					}
					i++;
				} while (i <= 20);
				System.out.println("\n");
				
		//Exercise 2
//				Question 6:In ra thông tin account (như Question 8 phần FOREACH) theo định dạng 
//				table (giống trong Database)
				System.out.println("Question 6: ");
				System.out.printf("%10s", "Email");
				System.out.printf("%30s", "Full Name");
				System.out.printf("%25s", "Department");
				System.out.println();
				for (Account accounts : account) {
					System.out.printf("%10s", accounts.email);
					System.out.printf("%23s", accounts.fullName);
					System.out.printf("%18s", accounts.department.name);
					System.out.println();
				}
	

	}

}
