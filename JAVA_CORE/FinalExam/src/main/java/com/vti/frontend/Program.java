
package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presentationlayer.UserController;
import com.vti.entity.User;
import com.vti.utils.ScannerUtils;


public class Program {
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		UserController userController = new UserController();
		List<User> users = userController.getListUser();
		System.out.println("Đăng nhập!");
		checkLogin(userController, users);
		
	}
	
	private static void xuLiLogic(UserController userController, List<User> users)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		while (true) {
			
			System.out.println("Mời bạn chọn số từ 0 -> 5: ");
			int choose = ScannerUtils.inputInt("Bạn phải nhập số, mời nhập lại!");
			switch (choose) {
			case 1:
				System.out.println("Hiển thị User đã có. ");
				for (User user : users) {
					user.getInfor();
					System.out.println("*****");
				}
				break;
			case 2:
				System.out.println("Nhap id của project: ");
				int id = ScannerUtils.inputInt("Ban phai nhap so, moi nhap lai!");
				userController.findUserById(id);
				break;
				
			case 3: 
				System.out.println("Lấy ra các manager của project");
				userController.getManagerProject();

				break;
			case 4:
				System.out.println("Dang xuat thanh cong");
				while (true) {
					System.out.println("Ban co muon tiep tuc khong(1-co/ 2- khong): ");
					int n = ScannerUtils.inputInt("Ban phai nhap so, moi nhap lai!");
					switch (n) {
					case 1:
						checkLogin(userController, users);
						return;
					case 2:
						System.out.println("==================");
						System.out.println("Thoát chương trình");
						return;
					default:
						System.out.println("Ban da chon sai, moi chon lai!");
						break;
					}
				}

			case 5:
				System.out.println("Tạo thêm User mới");
				System.out.println("Ban muon them Manager hay Employee: ");
				String role = ScannerUtils.inputRole();

				System.out.println("Nhap fullName: ");
				String fullName = ScannerUtils.inputFullName();

				System.out.println("Nhap email: ");
				String email2 = ScannerUtils.inputEmail("Email k đúng định dạng");

				if (role.equalsIgnoreCase("Manager")) {
					System.out.println("Nhap so nam kinh nghiem: ");
					int expInYear = ScannerUtils.inputInt("Ban phai nhap so");
					userController.addUser(role, fullName, email2, expInYear);
				} else {
					System.out.println("Nhập projectId: ");
					int projectId = ScannerUtils.inputId();
					System.out.println("Nhap proSkill: ");
					String proSkill = ScannerUtils.inputString("ProSkill khong duoc de trong, moi nhap lai!");
					userController.addUserr(fullName, email2, role, projectId, proSkill);
				}
				System.out.println("Thêm thành công!");
				break;

			case 0:
				System.out.println("==================");
				System.out.println("Thoát chương trình");
				return;

			default:
				System.out.println("Bạn đã chọn sai, mời nhập lại!");
				break;
			}
		}
	}

	private static void checkLogin(UserController userController, List<User> users)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
	
		while (true) {
			if (login(userController) == 1) {
				xuLiLogic(userController, users);		
				return;
			}
		}
	}

	private static int login(UserController userController)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		System.out.println("Ban muon dang nhap theo tu cach Manager hay Employee: ");
		String role = ScannerUtils.inputRole();

		System.out.println("Nhap email: ");
		String email = ScannerUtils.inputEmail("Email k đúng định dạng");

		System.out.println("Nhap Password: ");
		String password = ScannerUtils.inputPassword("Pass gồm 6 kí tự, 1 in hoa");
		return userController.login(role, email, password);
		

	}
}
