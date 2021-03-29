package com.vti.academy.frontend;

import java.util.Scanner;

import com.vti.academy.backend.Exercise1Contructor;
import com.vti.academy.backend.QLCB;
import com.vti.academy.backend.QLTV;
import com.vti.academy.backend.Question1Encapsulation;

public class InherianceProgram {
	public static void main(String[] args) {
		//Exercise1Contructor exercise1 = new Exercise1Contructor();
//		
//		Question1Encapsulation question1 = new Question1Encapsulation();
//		question1.quesStudent();
		Question1_2();
		Question4();
	}
		
		public static void Question1_2() {
			QLCB qlcb = new QLCB();
			Scanner sc = new Scanner(System.in);
			System.out.println("Mời bạn nhập vào chức năng muốn nhập : \n"+
								"1. Thêm mới cán bộ \n" +
								"2. Tìm kiếm theo họ tên \n" +
								"3.Hiển thị thông tin vè ds\n" +
								"4. Nhập vào tên cán bộ và delete cán bộ đó\n"+
								"5.Thoát.");
			while(true) {
				System.out.print("Mời bạn nhập chức năng: ");
				int choose = sc.nextInt();
				switch(choose) {
				case 1:
					qlcb.addCanbo();
					break;
				case 2:
					qlcb.findCanBo();
					break;
				case 3:
					qlcb.printCanBo();
					break;
				case 4:
					qlcb.deleteCanBo();
					break;
				case 5:
					System.out.println("Thoát");
					sc.close();
					return;
				default:
					break;
				}
			}
		}
		
		public static void Question4() {
			QLTV qltv = new QLTV();
			Scanner sc = new Scanner(System.in);
			System.out.println("Mời bạn nhập vào chức năng muốn nhập : \n"+
								"1. Thêm mới tài liệu \n" +
								"2. Xóa tài liệu theo mã \n" +
								"3. Hiển thị thông tin về tài liệu \n" +
								"4. Tìm kiếm tài liệu thoe loại\n"+
								"5. Thoát.");
			while(true) {
				System.out.print("Mời bạn nhập chức năng: ");
				int choose = sc.nextInt();
				switch(choose) {
				case 1:
					qltv.addTaiLieu();
					break;
				case 2:
					qltv.deleteTaiLieu();;
					break;
				case 3:
					qltv.printTaiLieu();
					break;
				case 4:
					qltv.findTaiLieu();;
					break;
				case 5:
					System.out.println("Thoát");
					sc.close();
					return;
				default:
					break;
				}
			}
		}
	
}


