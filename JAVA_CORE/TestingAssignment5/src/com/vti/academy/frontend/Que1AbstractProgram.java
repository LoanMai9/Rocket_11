package com.vti.academy.frontend;

import java.util.Scanner;

import com.vti.academy.backend.Abstraction.MyNews;



public class Que1AbstractProgram {
	public static void main(String[] args) {
//		c) Tạo chương trình demo có tên là MyNews và tạo một menu 
//	lựa chọn gồm các mục sau:
//	 Insert news
//	 View list news
//	 Average rate
//	 Exit
//	Nếu người dùng chọn 1 từ bàn phím thì tạo một object của 
//	class News và nhập giá trị cho các thuộc tính Title, 
//	PublishDate, Author, Content sau đó yêu cầu người dùng 
//	nhập vào 3 đánh giá để lưu vào Rates.
//	Nếu người dùng chọn 2 từ bàn phím thì thực thi method
//	Display().
//	Nếu người dùng chọn 3 từ bàn phím thì thực hiện method
//	Calculate() để tính đánh giá trung bình, sau đó thực thi 
//	method Display().
//	Trường hợp người dùng chọn 4 thì sẽ thoát khỏi chương 
//	trình.
		MyNews myNew = new MyNews();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Mời bạn nhâp: 1.Insert "+
										"2.View"+
										"3.AverageRate"+
										"4.Exit.");
		int choose= scanner.nextInt();
		while(true) {
			switch (choose) {
			case 1:
				System.out.println("Insert news: ");
				myNew.insertNews();
				break;
			case 2:
				System.out.println("View list news: ");
				myNew.viewNews();
				break;
			case 3:
				System.out.println("Average News");
				myNew.averageRate();
				break;
			case 4:
				System.out.println("Exit.");
				break;
			default:
				System.out.println("Nhâp sai! Vui lòng nhập lại!");
				break;
			}
		}
	}
}
