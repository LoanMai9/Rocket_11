package com.vti.academy.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.academy.entity.Inheritance.Question1_2.CanBo;
import com.vti.academy.entity.Inheritance.Question1_2.CongNhan;
import com.vti.academy.entity.Inheritance.Question1_2.KySu;
import com.vti.academy.entity.Inheritance.Question1_2.NhanVien;
import com.vti.academy.entity.Inheritance.Question4.TaiLieu;



public class QLCB {
	private List<CanBo>  canbos ;
	private Scanner scanner;
	
	public QLCB() {
		canbos = new ArrayList<>();
		scanner = new Scanner(System.in);
	}
	public void addCanbo() {
		System.out.println("Bạn muốn thêm mới cán bộ nào (1.Công nhân 2.Kỹ sư 3.Nhân viên");
		int choose = scanner.nextInt();
		scanner.nextLine();
		switch(choose) {
		case 1:
			CongNhan cn = new CongNhan();
			canbos.add(cn);
			System.out.println("Thêm thành công!");
			break;
		case 2:
			KySu ks = new KySu();
			canbos.add(ks);
			System.out.println("Thêm thành công!");
			break;
		case 3:
			NhanVien c = new NhanVien();
			canbos.add(c);
			System.out.println("Thêm thành công!");
			break;
		default:
			break;
		}
	}
	
	public void findCanBo() {
		System.out.println("Tìm kiếm theo họ tên");
	}
	
	public void printCanBo() {
		System.out.println("Hiển thị thông tin về danh sách cán bộ");
		for (CanBo canBo : canbos) {
			canBo.inputInfor();
		}
	}
	public void deleteCanBo() {
		System.out.println("Nhập vào tên cán bộ cần xóa: ");
		scanner = new Scanner(System.in);
		String ten = scanner.nextLine();
		for (CanBo canBo : canbos) {
			if(ten == canBo.getTen()) {
				canbos.remove(ten);
			}
		}
	}
}
