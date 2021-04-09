import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormat3 {
	public static void main(String[] args) {
		Exam exam1 = new Exam();
		exam1.id = 1;
		exam1.code = "VTIQ001";
		exam1.createDate = new Date("2021/03/19");
		exam1.tittle = "thi Java";

		Exam exam2 = new Exam();
		exam2.id = 2;
		exam2.code = "VTIQ002";
		exam2.createDate = new Date("2021/03/16");
		exam2.tittle = "thi PHP";

		Exam exam3 = new Exam();
		exam3.id = 2;
		exam3.code = "VTIQ003";
		exam3.createDate = new Date("2021/03/12 ");
		exam3.tittle = "thi .Net";
		// Question 1: In ra thông tin Exam thứ 1 và property create date sẽ được format
		// theo định
		// dạng vietnamese
		System.out.println("Question 1:");
		System.out.println("Thông tin exam thứ 1:");
		System.out.println("ID: " + exam1.id);
		System.out.println("Code: " + exam1.code);
		System.out.println("Tittle: " + exam1.tittle);
		Locale locale = new Locale("vi","VN");
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		String date = dateFormat.format(exam1.createDate);
		System.out.println(date);
		
		//Question 2: In ra thông tin: Exam đã tạo ngày nào theo định dạng 
		//Năm – tháng – ngày – giờ – phút – giây
		System.out.println("Question 2:");
		System.out.println("Thông tin exam thứ 2:");
		System.out.println("ID: " + exam2.id);
		System.out.println("Code: " + exam2.code);
		System.out.println("Tittle: " + exam2.tittle);
		String pattern = "dd-MM-yyyy HH:mm:ss";
		SimpleDateFormat dateFormat2 = new SimpleDateFormat(pattern);
		String date2 = dateFormat2.format(exam2.createDate);
		System.out.println(date2);
		
		//Question 3: Chỉ in ra năm của create date property trong Question 2
		System.out.println("Question 3:");
		System.out.println("Thông tin exam thứ 1:");
		String pattern3 = "yyyy";
		SimpleDateFormat dateFormat3 = new SimpleDateFormat(pattern3);
		String date3 = dateFormat3.format(exam1.createDate);
		System.out.println(date3);
		
		// Question 4: Chỉ in ra tháng và năm của create date property trong Question 2
		System.out.println("Question 4:");
		System.out.println("Thông tin exam thứ 1:");
		String pattern4 = "MM-yyyy";
		SimpleDateFormat dateFormat4 = new SimpleDateFormat(pattern4);
		String date4 = dateFormat4.format(exam1.createDate);
		System.out.println(date4);
		
		//Question 5: Chỉ in ra "MM-DD" của create date trong Question 2
		System.out.println("Question 5:");
		System.out.println("Thông tin exam thứ 1:");
		String pattern5 = "MM-dd";
		SimpleDateFormat dateFormat5 = new SimpleDateFormat(pattern5);
		String date5 = dateFormat5.format(exam1.createDate);
		System.out.println(date5);
		
	}
}
