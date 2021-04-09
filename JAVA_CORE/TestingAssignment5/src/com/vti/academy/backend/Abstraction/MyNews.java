package com.vti.academy.backend.Abstraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.academy.entity.Abstraction.Question1.New;


public class MyNews {

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
	private List<New> news;

	public MyNews() {
		news = new ArrayList<>();
	}

	public void insertNews() {
		New newss = new New();
		int[] rates = new int[3];
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Title: ");
		newss.setTitle(scanner.nextLine());
		System.out.println("PublishDate: ");
		newss.setTitle(scanner.nextLine());
		System.out.println("Author: ");
		newss.setTitle(scanner.nextLine());
		System.out.println("Content: ");
		newss.setTitle(scanner.nextLine());
		
		System.out.println("Nhập vào 3 đánh giá: ");
		for(int i=0; i<3; i++) {
			System.out.println("Đánh giá thứ: "+(i+1));
			rates[i] = scanner.nextInt();
		}
		newss.setRates(rates);
		news.add(newss);
	}
	public void viewNews() {
		for (New newss : news) {
			newss.Display();
		}
	}
	public void averageRate() {
		for (New newss : news) {
			System.out.println("Title: "+ newss.getAverageRate()+"AverageRate: "+newss.Calculate());
		}
	}
}
