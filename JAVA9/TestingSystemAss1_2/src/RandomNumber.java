import java.time.LocalDate;
import java.util.Random;

public class RandomNumber {
	public static void main(String[] args) {
		Random rd = new Random();
		// question 1: In ra 1 số ngẫu nhiên
		System.out.print("Question1: ");
		int i = rd.nextInt();
		System.out.println(i);
//		Question 2: In ngẫu nhiên ra 1 số thực 
		System.out.print("Question2: ");
		float f = rd.nextFloat();
		System.out.println(f);

		double d = rd.nextDouble();
		System.out.println(d);

//		Question 3: Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên 
//			ra tên của 1 bạn
		System.out.print("Question3: ");
		String[] studentList = { "A", "B", "C", "C", "D" };
		int s = rd.nextInt(studentList.length);
		System.out.println(studentList[s]);

//		Question 4:Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12-1995
		System.out.print("Question4: ");
		int minday = (int) LocalDate.of(1995, 07, 24).toEpochDay();
		int maxday = (int) LocalDate.of(1995, 12, 20).toEpochDay();
		long randomlong = rd.nextInt(maxday - minday) + minday;
		LocalDate randomday = LocalDate.ofEpochDay(randomlong);
		System.out.println(randomday);

//		Question 5:Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây
		System.out.print("Question5: ");
		int today = (int) LocalDate.now().toEpochDay();
		randomlong = today - (int) (Math.random() * (365 - 1 + 1)) + 1;
		randomday = LocalDate.ofEpochDay(randomlong);
		System.out.println(randomday);

//		Question 6:Lấy ngẫu nhiên 1 ngày trong quá khứ
		System.out.println("Question 6: ");
		

//		Question 7:Lấy ngẫu nhiên 1 số có 3 chữ số
		System.out.print("Question 7: ");
		int a = rd.nextInt(1000);
		System.out.println(String.format("%03d", a));
	}
}
