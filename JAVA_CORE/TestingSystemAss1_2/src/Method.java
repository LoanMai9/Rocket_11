import java.util.Date;

public class Method {
	public static void main(String[] args) {
		System.out.println("Question 1: ");
		inSochan();				// question1
		printInfor();			//question2
		printSoNgDuong();		//question3
	
	}
	//Question 1:Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10
	public static void inSochan() {
		for(int i=0; i<=10; i=i+2) {
			System.out.print(i+" ");
		}
	}
	//Question 2:Tạo method để in thông tin các account
	public static void printInfor() {
		Account[] accounts = inputAccount();
		for (int i = 0; i < accounts.length; i++) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là: \n");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Full name: " + accounts[i].fullName);
			System.out.println("Create Date: "+accounts[i].createDate);
			System.out.println("\n");
		}
	}
	public static Account[] inputAccount() {
		Account account1 = new Account();
		account1.id = 1;
		account1.email = "nguyentrunganh@gmail.com";
		account1.fullName = "Nguyễn Trung Anh";
		account1.userName = "trunganh";
		account1.createDate = new Date("1997/08/01");
		

		Account account2 = new Account();
		account2.id = 2;
		account2.email = "hoangdinhthang@gmail.com";
		account2.fullName = "Hoàng Đình Thắng";
		account2.userName = "dinhthang";
		account2.createDate = new Date("1999/06/05");
		

		Account account3 = new Account();
		account3.id = 3;
		account3.email = "maianhtuan@gmail.com";
		account3.fullName = "Mai Anh Tuấn";
		account3.userName = "anhtuan";
		account3.createDate = new Date("1998/09/08");
		
		Account[] accounts = {account1,account2, account3};
		return accounts;
		
	}
	//Question 3:Tạo method để in ra các số nguyên dương nhỏ hơn 10
	public static void printSoNgDuong() {
		for(int i = 0; i<10; i++) {
			System.out.println(i);
		}
//		 int i =1;
//		 while(i <10){
//				System.out.println(i);
//		      i++;
//		 }
//		int i=1;
//		do {
//			System.out.println(i);
//			i++;
//		} while (i<10);
	}
}
