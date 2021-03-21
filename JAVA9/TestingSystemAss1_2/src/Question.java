import java.util.Date;

public class Question {
	byte id;
	String content;
	CategoryQuestion category;
	TypeQuestion type;
	Account creator;
	Date createDate;
	Exam[] exams;
}
