-- tao database TestingSystem1
DROP DATABASE IF EXISTS TestingSystem1;
CREATE DATABASE TestingSystem1;
USE TestingSystem1;

-- tao bang Department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	DepartmentID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName 			NVARCHAR(30) NOT NULL UNIQUE KEY
);

-- tao bang Position

DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position`(
	PositionID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	PositionName 			ENUM('Dev','Test','Scrum Master','PM') NOT NULL UNIQUE KEY
    );

-- tao bang Account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email 					VARCHAR(30) NOT NULL UNIQUE KEY,
	Username 				VARCHAR(30) NOT NULL UNIQUE KEY,
	FullName				NVARCHAR(30) NOT NULL,
	DepartmentID			TINYINT UNSIGNED NOT NULL,
	PositionID				TINYINT UNSIGNED NOT NULL,
	CreateDate				DATETIME DEFAULT NOW(),
	FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID),
	FOREIGN KEY(PositionID) REFERENCES `Position`(PositionID)     
);

-- tao bang Group
DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
	GroupID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	GroupName 				VARCHAR(50) NOT NULL UNIQUE KEY,
    CreatorID   			TINYINT UNSIGNED,
    CreateDate  			DATETIME DEFAULT NOW(),
    FOREIGN KEY(CreatorID) REFERENCES `Account`(AccountID)
    );
    
    -- tao bang GroupAccount
DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount(
	GroupID					TINYINT UNSIGNED NOT NULL,
    AccountID				TINYINT UNSIGNED NOT NULL,
    JoinDate				DATETIME DEFAULT NOW(),
    PRIMARY KEY (GroupID,AccountID),
    FOREIGN KEY(GroupID) 		REFERENCES `Group`(GroupID) 
);

-- tao bang TypeQuestion
DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE TypeQuestion(
	TypeID 					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	TypeName 				ENUM('Essay','Multiple-Choice') NOT NULL UNIQUE KEY
    );  
    
    -- tao bang CategoryQuestion
DROP TABLE IF EXISTS CategoryQuestion;
CREATE TABLE CategoryQuestion(
	CategoryID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	CategoryName 			NVARCHAR(50) NOT NULL UNIQUE KEY
    );  
    
    -- tao bang Question
DROP TABLE IF EXISTS Question;
CREATE TABLE Question(
	QuestionID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Content 				VARCHAR(100) NOT NULL ,
    CategoryID   			TINYINT UNSIGNED NOT NULL,
    TypeID  				TINYINT UNSIGNED NOT NULL,
	CreatorID   			TINYINT UNSIGNED NOT NULL,
    CreateDate  			DATETIME DEFAULT NOW(),
    FOREIGN KEY(CategoryID) REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY(TypeID) 	REFERENCES TypeQuestion(TypeID),
    FOREIGN KEY(CreatorID) 	REFERENCES `Account`(AccountID)
    );
    
    -- tao bang Answer
DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer(
    AnswerID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content					NVARCHAR(100) NOT NULL,
    QuestionID				TINYINT UNSIGNED NOT NULL,
    isCorrect				BIT DEFAULT 1,
    FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID)
);

-- tao bang Exam
DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam(
	ExamID 					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code` 					CHAR(10) NOT NULL,
	Title 					NVARCHAR(50) NOT NULL,
	CategoryID				TINYINT UNSIGNED NOT NULL,
	Duration				TINYINT UNSIGNED NOT NULL,
	CreatorID				TINYINT UNSIGNED NOT NULL,
	CreateDate				DATETIME DEFAULT NOW(),
	FOREIGN KEY(CategoryID) REFERENCES CategoryQuestion(CategoryID),
	FOREIGN KEY(CreatorID) REFERENCES `Account`(AccountID)     
);

-- tao bang ExamQuestion
DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion(
	ExamID 					TINYINT UNSIGNED NOT NULL,
	QuestionID 				TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY(ExamID) REFERENCES Exam(ExamID),
    FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID),
    PRIMARY KEY(ExamID,QuestionID)
    );
    -- Insert  vao Department
INSERT INTO 	Department(DepartmentName)
VALUES 			(N'Director room'),
				(N'Marketing'),
				(N'Sale'),
				(N'Security office'),
				(N'Finance bureau');
			
           -- Insert  vao Position
INSERT INTO     `Position`(PositionName)
VALUES			('Dev'),
				('Test'),
                ('Scrum Master'),
                ('PM');
                
			-- Insert  vao Account
INSERT INTO     `Account`(Email,	 		Username,		 FullName, 				DepartmentID, 	PositionID, 		CreateDate)
VALUES			('account1@gmail.com',		'tuananh', 		'Mai Tuấn Anh', 			'1',			'2', 			'2021-03-02' ),
				('account2@gmail.com',	    'anhtuan', 		'Mai Anh Tuấn', 			'2',			'3', 			'2021-03-03'),
                ('account3@gmail.com',		'trunganh', 	'Nguyễn Trung Anh', 		'3',			'4', 			'2021-03-02'),
                ('account4@gmail.com', 		'ducthanh',		 'Trần Đức Thành', 			'4',			'3', 			'2021-03-04'),
                ('account5@gmail.com',		'dinhthang', 	 'Hoàng Đình Thắng', 		'5',			'1', 			'2021-03-05');
                
			-- Insert  vao Group
INSERT INTO     `Group`(GroupName,      CreatorID,           CreateDate)
VALUES					(N'Development',	2,				 '2019-03-05'),
						(N'Sale',			4,				 '2020-03-07'),
                        (N'Creator',		3,				 '2020-03-09'),
                        (N'Management',		5,				 '2020-03-10'),
                        (N'Testing System',	1,				 '2020-03-28');
                        
			-- Insert  vao GroupAccount
                        
INSERT INTO `GroupAccount`	(  GroupID	, AccountID	, JoinDate	 )
VALUES 						(	1		,    1		,'2020-03-05'),
							(	1		,    2		,'2020-03-07'),
							(	3		,    3		,'2020-03-09'),
							(	3		,    4		,'2020-03-10'),
							(	5		,    5		,'2020-03-28');
						
		-- Insert  vao TypeQuestion
INSERT INTO TypeQuestion	(TypeName			) 
VALUES 						('Essay'			), 
							('Multiple-Choice'	); 
		
        -- Insert  vao CategoryQuestion
                            
INSERT INTO CategoryQuestion		(CategoryName	)
VALUES 								('Java'			),
									('ASP.NET'		),
									('SQL'			),
									('Postman'		),
									('Ruby'			),
									('Python'		),
									('C++'			),
									('PHP'			);
                                    
		-- Insert  vao Question

INSERT INTO Question(Content			, 	CategoryID, 	TypeID		, CreatorID	, CreateDate )
VALUES				(N'Câu hỏi về Java', 		1,			'1',				'2',	'2020-04-05'),
					(N'Câu hỏi về Ruby',    	5,			'2',				'3',	'2020-04-06'),
                    (N'Câu hỏi về C++',    		7,			'2',				'1',	'2020-04-06'),
                    (N'Câu hỏi về ASP.NET',    	2,			'2',				'3',	'2020-04-06'),
                    (N'Câu hỏi về Postman',    	4,			'1',				'1',	'2020-04-06'),
                    (N'Câu hỏi về SQL',    		3,			'1',				'2',	'2020-04-06'),
                    (N'Câu hỏi về PHP',    		8,			'2',				'4',	'2020-04-07'),
                    (N'Câu hỏi về Python',      6,			'1',				'5',	'2020-04-07');
	
    -- Insert  vao Answer
INSERT INTO Answer	(  Content		, QuestionID	, isCorrect	)
VALUES 				(N'Trả lời 01'	,   1			,	0		),
					(N'Trả lời 02'	,   5			,	1		),
                    (N'Trả lời 03'	,   6			,	0		),
                    (N'Trả lời 04'	,   7   		,	1		),
                    (N'Trả lời 05'	,   2			,	1		),
                    (N'Trả lời 06'	,   3			,	1		),
                    (N'Trả lời 07'	,   4			,	0		),
                    (N'Trả lời 08'	,   8			,	0		);
-- Insert  vao Exam
                    
INSERT INTO Exam	(`Code`			, Title					, CategoryID	, Duration	, CreatorID		, CreateDate )
VALUES 				('VTIQ001'		, N'Đề thi ASP.NET'		,	2			,	60		,   '5'			,'2021-04-05'),
					('VTIQ002'		, N'Đề thi PHP'			,	8			,	60		,   '2'			,'2021-04-05'),
                    ('VTIQ003'		, N'Đề thi C++'			,	7			,	120		,   '2'			,'2021-04-07'),
                    ('VTIQ004'		, N'Đề thi Java'		,	1			,	60		,   '3'			,'2021-04-08'),
                    ('VTIQ005'		, N'Đề thi Ruby'		,	5			,	120		,   '4'			,'2021-04-10'),
                    ('VTIQ006'		, N'Đề thi Postman'		,	4			,	60		,   '2'			,'2021-04-05'),
                    ('VTIQ007'		, N'Đề thi SQL'			,	3			,	60		,   '1'			,'2021-04-05'),
                    ('VTIQ008'		, N'Đề thi Python'		,	6			,	60		,   '3'			,'2021-04-07');
	
    -- Insert  vao ExamQuestion
INSERT INTO ExamQuestion(ExamID	, QuestionID	) 
VALUES 					(	1	,		5		),
						(	2	,		1		), 
						(	3	,		8		), 
						(	4	,		3		), 
						(	5	,		7		), 
						(	6	,		4		), 
						(	7	,		2		), 
						(	8	,		6		); 
                        
                        
-- Question 1: lấy ra tất cả các phòng ban
SELECT * 
FROM Department;

-- Question 2: lấy ra id của phòng ban có tên là "Sale"
SELECT * 
FROM Department
WHERE DepartmentName ="Sale";

-- Question 3: lấy ra thông tin account có full name dài nhất

SELECT FullName, CHAR_LENGTH(FullName) 
FROM `Account`
WHERE CHAR_LENGTH(FullName) = (SELECT MAX(CHAR_LENGTH(FullName))
							FROM `Account`) ;

-- Question 4: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT GroupName
FROM `Group`
WHERE CreateDate < "2019-12-20";

-- Question 5: Lấy ra ID của question có >= 4 câu trả lời
SELECT QuestionID, count(QuestionID) 
FROM Answer
GROUP BY QuestionID
HAVING count(QuestionID) >=3;

-- Question 6: Lấy ra 5 group được tạo gần đây nhất
SELECT GroupName
FROM `group`
ORDER BY CreateDate
LIMIT 5;

-- Question 8: Xóa tất cả các exam được tạo trước ngày 20/12/2019
SELECT ExamID
FROM exam
WHERE CreateDate < '2021-04-07';

DELETE 
FROM examquestion
WHERE ExamID IN (SELECT ExamID
				FROM exam
				WHERE CreateDate < '2021-04-07');

commit;

-- Question 9: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
UPDATE `Account`
SET FullName= "Nguyễn Bá Lộc", Email ="loc.nguyenba@vti.com.vn"
WHERE AccountID ='5';

UPDATE `Account`
SET FullName= "Hà Văn Hanh", Email ="hanh.havan@vti.com.vn"
WHERE AccountID =1;

-- Question 10: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT *
FROM `Account` a 
JOIN department d ON a.DepartmentID = d.DepartmentID;

-- Question 11: Viết lệnh để lấy ra tất cả các developer
SELECT *
FROM `Account` a 
JOIN Position p On a.PositionID= p.PositionID
WHERE p.PositionName = 'Dev' ; 

-- Question 12: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT 		d.DepartmentID, DepartmentName, COUNT(a.DepartmentID) AS 'SO LUONG'
FROM 		`Account` a 
INNER JOIN Department  d ON			d.DepartmentID = d.DepartmentID
GROUP BY 	a.DepartmentID
HAVING 		COUNT(a.DepartmentID)>3;


 -- Question 13: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
 SELECT 		Q.QuestionID, Q.Content, Q.CategoryID, Q.TypeID, Q.CreatorID, Q.CreateDate, Count(Q.Content) AS 'SO LUONG'
FROM		Question Q INNER JOIN ExamQuestion EQ
ON			Q.QuestionID = EQ.QuestionID
GROUP BY	Q.Content
HAVING		COUNT(Q.Content) = (SELECT		MAX(CountQ)
								FROM		
										(SELECT 		COUNT(Q.QuestionID) AS CountQ
										FROM			ExamQuestion EQ INNER JOIN Question Q
										ON				EQ.QuestionID = Q.QuestionID
										GROUP BY		Q.QuestionID) AS MaxContent);

-- Question 14: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT		CQ.CategoryID, CQ.CategoryName, COUNT(Q.CategoryID)
FROM		CategoryQuestion CQ LEFT JOIN Question Q
ON			CQ.CategoryID = Q.CategoryID
GROUP BY	CQ.CategoryID
ORDER BY	CQ.CategoryID ASC;

-- Question 15: Lấy ra Question có nhiều câu trả lời nhất
/* SELECT a.Content, MAX(a.QuestionID)
FROM answer a
JOIN question q ON a.QuestionID = q.QuestionID
GROUP BY an.QuestionID
HAVING ( SELECT MAX(QuestionID)
		FROM answer);*/
        
SELECT 		Q.QuestionID, Q.Content, COUNT(A.QuestionID) AS 'SO LUONG'
FROM		Question Q INNER JOIN Answer A 
ON			Q.QuestionID = A.QuestionID
GROUP BY	A.QuestionID
HAVING		COUNT(A.QuestionID) =	(SELECT 	MAX(CountQ)
									FROM		(SELECT 		COUNT(A.QuestionID) AS CountQ
												FROM			Answer A RIGHT JOIN  Question Q 
												ON				A.QuestionID = Q.QuestionID 
												GROUP BY		A.QuestionID) AS MaxCountQ);

-- Question 16: Tìm chức vụ có ít người nhất

-- Question 17: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
-- Question 18: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, …
-- Question 19: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm

SELECT tq.TypeID, COUNT(QuestionID)
FROM Question q 
JOIN typequestion tq ON q.TypeID = tq.TypeID
GROUP BY TypeName;

                    


                        
	