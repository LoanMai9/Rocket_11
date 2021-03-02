DROP DATABASE IF EXISTS TestingSystem1;
CREATE DATABASE TestingSystem1;
USE TestingSystem1;

DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	DepartmentID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName 			NVARCHAR(30) NOT NULL UNIQUE KEY
);
DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position`(
	PositionID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	PositionName 			ENUM('Dev','Test','Scrum Master','PM') NOT NULL UNIQUE KEY
    );

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

DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
	GroupID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	GroupName 				VARCHAR(50) NOT NULL UNIQUE KEY,
    CreatorID   			TINYINT UNSIGNED,
    CreateDate  			DATETIME DEFAULT NOW(),
    FOREIGN KEY(CreatorID) REFERENCES `Account`(AccountID)
    );
    
DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount(
	GroupID					TINYINT UNSIGNED NOT NULL,
    AccountID				TINYINT UNSIGNED NOT NULL,
    JoinDate				DATETIME DEFAULT NOW(),
    PRIMARY KEY (GroupID,AccountID),
    FOREIGN KEY(GroupID) 		REFERENCES `Group`(GroupID) 
);

DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE TypeQuestion(
	TypeID 					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	TypeName 				ENUM('Essay','Multiple-Choice') NOT NULL UNIQUE KEY
    );  
DROP TABLE IF EXISTS CategoryQuestion;
CREATE TABLE CategoryQuestion(
	CategoryID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	CategoryName 			NVARCHAR(50) NOT NULL UNIQUE KEY
    );  
    
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
    
DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer(
    AnswerID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content					NVARCHAR(100) NOT NULL,
    QuestionID				TINYINT UNSIGNED NOT NULL,
    isCorrect				BIT DEFAULT 1,
    FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID)
);

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

DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion(
	ExamID 					TINYINT UNSIGNED NOT NULL,
	QuestionID 				TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY(ExamID) REFERENCES Exam(ExamID),
    FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID),
    PRIMARY KEY(ExamID,QuestionID)
    );
    -- Insert 
INSERT INTO 	Department(DepartmentName)
VALUES 			(N'Director room'),
				(N'Marketing'),
				(N'Sale'),
				(N'Security office'),
				(N'Finance bureau');
			
INSERT INTO     `Position`(PositionName)
VALUES			('Dev'),
				('Test'),
                ('Scrum Master'),
                ('PM');
                
INSERT INTO     `Account`(Email,	 		Username,		 FullName, 				DepartmentID, 	PositionID, 		CreateDate)
VALUES			('account1@gmail.com',		'tuananh', 		'Mai Tuấn Anh', 			'1',			'2', 			'2021-03-02' ),
				('account2@gmail.com',	    'anhtuan', 		'Mai Anh Tuấn', 			'2',			'3', 			'2021-03-03'),
                ('account3@gmail.com',		'trunganh', 	'Nguyễn Trung Anh', 		'3',			'4', 			'2021-03-02'),
                ('account4@gmail.com', 		'ducthanh',		 'Trần Đức Thành', 			'4',			'3', 			'2021-03-04'),
                ('account5@gmail.com',		'dinhthang', 	 'Hoàng Đình Thắng', 		'5',			'1', 			'2021-03-05');
                
INSERT INTO     `Group`(GroupName,      CreatorID,           CreateDate)
VALUES					(N'Development',	2,				 '2019-03-05'),
						(N'Sale',			4,				 '2020-03-07'),
                        (N'Creator',		3,				 '2020-03-09'),
                        (N'Management',		5,				 '2020-03-10'),
                        (N'Testing System',	1,				 '2020-03-28');
                        
INSERT INTO `GroupAccount`	(  GroupID	, AccountID	, JoinDate	 )
VALUES 						(	1		,    1		,'2020-03-05'),
							(	1		,    2		,'2020-03-07'),
							(	3		,    3		,'2020-03-09'),
							(	3		,    4		,'2020-03-10'),
							(	5		,    5		,'2020-03-28');
                            
INSERT INTO TypeQuestion	(TypeName			) 
VALUES 						('Essay'			), 
							('Multiple-Choice'	); 
                            
INSERT INTO CategoryQuestion		(CategoryName	)
VALUES 								('Java'			),
									('ASP.NET'		),
									('SQL'			),
									('Postman'		),
									('Ruby'			),
									('Python'		),
									('C++'			),
									('PHP'			);

INSERT INTO Question(Content			, 	CategoryID, 	TypeID		, CreatorID	, CreateDate )
VALUES				(N'Câu hỏi về Java', 		1,			'1',				'2',	'2020-04-05'),
					(N'Câu hỏi về Ruby',    	5,			'2',				'3',	'2020-04-06'),
                    (N'Câu hỏi về C++',    		7,			'2',				'1',	'2020-04-06'),
                    (N'Câu hỏi về ASP.NET',    	2,			'2',				'3',	'2020-04-06'),
                    (N'Câu hỏi về Postman',    	4,			'1',				'1',	'2020-04-06'),
                    (N'Câu hỏi về SQL',    		3,			'1',				'2',	'2020-04-06'),
                    (N'Câu hỏi về PHP',    		8,			'2',				'4',	'2020-04-07'),
                    (N'Câu hỏi về Python',      6,			'1',				'5',	'2020-04-07');
                    
INSERT INTO Answer	(  Content		, QuestionID	, isCorrect	)
VALUES 				(N'Trả lời 01'	,   1			,	0		),
					(N'Trả lời 02'	,   5			,	1		),
                    (N'Trả lời 03'	,   6			,	0		),
                    (N'Trả lời 04'	,   7   		,	1		),
                    (N'Trả lời 05'	,   2			,	1		),
                    (N'Trả lời 06'	,   3			,	1		),
                    (N'Trả lời 07'	,   4			,	0		),
                    (N'Trả lời 08'	,   8			,	0		);
                    
INSERT INTO Exam	(`Code`			, Title					, CategoryID	, Duration	, CreatorID		, CreateDate )
VALUES 				('VTIQ001'		, N'Đề thi ASP.NET'		,	2			,	60		,   '5'			,'2021-04-05'),
					('VTIQ002'		, N'Đề thi PHP'			,	8			,	60		,   '2'			,'2021-04-05'),
                    ('VTIQ003'		, N'Đề thi C++'			,	7			,	120		,   '2'			,'2021-04-07'),
                    ('VTIQ004'		, N'Đề thi Java'		,	1			,	60		,   '3'			,'2021-04-08'),
                    ('VTIQ005'		, N'Đề thi Ruby'		,	5			,	120		,   '4'			,'2021-04-10'),
                    ('VTIQ006'		, N'Đề thi Postman'		,	4			,	60		,   '2'			,'2021-04-05'),
                    ('VTIQ007'		, N'Đề thi SQL'			,	3			,	60		,   '1'			,'2021-04-05'),
                    ('VTIQ008'		, N'Đề thi Python'		,	6			,	60		,   '3'			,'2021-04-07');
                    
INSERT INTO ExamQuestion(ExamID	, QuestionID	) 
VALUES 					(	1	,		5		),
						(	2	,		1		), 
						(	3	,		8		), 
						(	4	,		3		), 
						(	5	,		7		), 
						(	6	,		4		), 
						(	7	,		2		), 
						(	8	,		6		); 

                    


                        
	