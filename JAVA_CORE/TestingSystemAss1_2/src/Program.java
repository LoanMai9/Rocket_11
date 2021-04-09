import java.util.Date;

public class Program {

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
		position1.name=PositionName.DEV;
		
		Position position2 = new Position();
		position2.id = 2;
		position2.name=PositionName.PM;
		
		Position position3 = new Position();
		position3.id = 3;
		position3.name=PositionName.SCRUMMASTER;
		
		Position position4 = new Position();
		position4.id = 4;
		position4.name=PositionName.TEST;
		
		Account account1 = new Account();
		account1.id =1;
		account1.email = "nguyentrunganh@gmail.com";
		account1.fullName ="Nguyễn Trung Anh";
		account1.userName ="trunganh";
		account1.createDate = new Date("1997/08/01");
		account1.department = department2;
		
		Account account2 = new Account();
		account2.id =2;
		account2.email = "hoangdinhthang@gmail.com";
		account2.fullName ="Hoàng Đình Thắng";
		account2.userName ="dinhthang";
		account2.createDate = new Date("1999/06/05");
		account2.department = department3;
		
		Account account3 = new Account();
		account3.id =3;
		account3.email = "maianhtuan@gmail.com";
		account3.fullName ="Mai Anh Tuấn";
		account3.userName ="anhtuan";
		account3.createDate = new Date("1998/09/08");
		account3.department = department1;
		
		Group group1 = new Group();
		group1.id =1;
		group1.groupName= "";
		group1.createDate = new Date("2021/03/15");
		group1.creator = account1;
		
		Group group2 = new Group();
		group2.id =2;
		group2.groupName= "";
		group2.createDate = new Date("2021/03/15");
		group2.creator = account3;
		
		TypeQuestion type1 = new TypeQuestion();
		type1.id=1;
		type1.name = TypeName.ESSAY;
		
		TypeQuestion type2 = new TypeQuestion();
		type2.id= 1;
		type2.name = TypeName.MULTIPLECHOICE;
		
		TypeQuestion type3 = new TypeQuestion();
		type3.id= 3;
		type3.name = TypeName.MULTIPLECHOICE;
		
		CategoryQuestion catque1 = new CategoryQuestion();
		catque1.id = 1;
		catque1.categoryName = CategoryName.JAVA;
		
		CategoryQuestion catque2 = new CategoryQuestion();
		catque2.id = 2;
		catque2.categoryName = CategoryName.SQL;
		
		CategoryQuestion catque3 = new CategoryQuestion();
		catque3.id = 2;
		catque3.categoryName = CategoryName.DOTNET;
		
		Question question1 = new Question();
		question1.id =1;
		question1.content ="Câu hỏi về Java";
		question1.category=catque1;
		question1.type = type1;
		question1.creator= account1;
		question1.createDate= new Date("2020/02/31");
		
		Question question2 = new Question();
		question2.id =2;
		question2.content ="Câu hỏi về SQL";
		question2.category = catque2;
		question2.type= type2;
		question2.creator= account3;
		question2.createDate= new Date("2020/03/05");
		
		Question question3 = new Question();
		question3.id =3;
		question3.content ="Câu hỏi về C#";
		question3.category=catque3;
		question3.type=type3;
		question3.creator= account2;
		question3.createDate= new Date("2020/03/01");
		
		Answer answer1 = new Answer();
		answer1.id = 1;
		answer1.question =question2 ;
		
		Answer answer2 = new Answer();
		answer2.id = 2;
		answer2.question =question1 ;
		
		Answer answer3 = new Answer();
		answer3.id = 3;
		answer3.question =question3 ;
		
		GroupAccount ga1 = new GroupAccount();
		ga1.account = account1;
		ga1.group = group2;
		ga1.joinDate = new Date("2020/12/09");
		
		GroupAccount ga2 = new GroupAccount();
		ga2.account = account1;
		ga2.group = group1;
		ga1.joinDate = new Date("2020/12/27");
		
		GroupAccount[] groupaccounts = {ga1,ga2};
		account1.groups = groupaccounts;
		
		Exam exam1 = new Exam();
		exam1.id =1;
		exam1.tittle = "thi Java";
		
		Exam exam2 = new Exam();
		exam2.id =2;
		exam2.tittle = "thi PHP";
		
		Exam exam3 = new Exam();
		exam3.id =2;
		exam3.tittle = "thi .Net";
		
		Question[] questions= {question1,question2};
		exam1.questions =questions;
		
		System.out.println("Thông tin phòng ban 1: ");
		System.out.println("name: "+department1.name);
		System.out.println("id: "+department1.id);
		System.out.println("\n");
		
		System.out.println("Thông tin phòng ban 2: ");
		System.out.println("name: "+department2.name);
		System.out.println("id: "+department2.id);
		System.out.println("\n");
		
		System.out.println("Thông tin tài khoản 1: ");
		System.out.println("id: "+account1.id);
		System.out.println("username: "+account1.userName);
		System.out.println("fullname: "+account1.fullName);
		System.out.println("email: "+account1.email);
		System.out.println("phòng ban: "+account1.department.name);
		System.out.println("\n");
		
		System.out.println("Thông tin tài khoản 2: ");
		System.out.println("id: "+account2.id);
		System.out.println("username: "+account2.userName);
		System.out.println("fullname: "+account2.fullName);
		System.out.println("email: "+account2.email);
		System.out.println("phòng ban: "+account2.department.name);
		System.out.println("\n");
		
	}

}
