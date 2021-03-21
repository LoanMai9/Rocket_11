import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class SystemOutPrintf {
	public static void main(String[] args) {
//		Question 1: Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số 
//			nguyên đó
		int i=5;
		System.out.printf("%d %n",i);
		
//		Question 2: Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in 
//			ra số nguyên đó thành định dạng như sau: 100,000,000
		int x=100000000;
		System.out.printf(Locale.US,"%,d %n",x);
		System.out.printf(Locale.ITALY,"%,d %n",x);
		
//		Question 3: Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số 
//				thực đó chỉ bao gồm 4 số đằng sau
		float y= 5.567098f;			// khai báo kiểu số thực 
		System.out.printf("%f %n",y);		// khai báo số thực đó
		System.out.printf("%.4f %n",y);	// lấy 4 số sau dấu phẩy, tt vs 2 số
		
//		Question 4: Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó 
		String string= "Nguyễn Văn A";
		//c1: System.out.println("Tên tôi là "+string +" và tôi độc thân.");
		
		System.out.printf("Tên tôi là %s và tôi độc thân.%n" ,string);
		
//		Question 5:Lấy thời gian bây giờ và in ra theo định dạng sau:
//			24/04/2020 11h:16p:20s 
		String pattern = "dd-MM-yyyy HH:mm:ss";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		String date = dateFormat.format(new Date());
		System.out.println(date);
		

	}
}
