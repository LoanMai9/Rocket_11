-- tao database Fresher_management
DROP DATABASE IF EXISTS Fresher_management;
CREATE DATABASE Fresher_management;
USE Fresher_management;

-- Khai báo thực tập sinh
DROP TABLE IF EXISTS Trainee;
CREATE TABLE Trainee(
	TraineeID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Full_Name 				NVARCHAR(50) NOT NULL,
    Birth_Date				DATETIME CHECK(Birth_Date >= '1990-01-01'),
    Gender					ENUM('Male','Female','Unknown') NOT NULL,
    ET_IQ					FLOAT UNSIGNED CHECK(ET_IQ<=20) NOT NULL, 
    ET_Gmath				FLOAT UNSIGNED CHECK(ET_Gmath<=20) NOT NULL,
    ET_English				FLOAT UNSIGNED CHECK(ET_English<=50) NOT NULL,
    Training_Class			CHAR(6) NOT NULL UNIQUE KEY,
    Evaluation_Notes		NVARCHAR(50) NOT NULL
);
ALTER TABLE Trainee ADD COLUMN VTI_Account VARCHAR(30) NOT NULL UNIQUE KEY;

-- Excercise 2

DROP TABLE IF EXISTS Exercise2;
CREATE TABLE Exercise2(
	ID				MEDIUMINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name`			VARCHAR(50) NOT NULL,
    `Code`			CHAR(5) NOT NULL,
    ModifiedDate	TIMESTAMP      -- or DATETIME DEFAULT NOW()
);

-- Exercise3
DROP TABLE IF EXISTS Exercise3;
CREATE TABLE Exercise3(
	ID 				MEDIUMINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name`			VARCHAR(50) NOT NULL,
    BirthDate		DATE NOT NULL,
    Gender			BIT, 		-- 0: Male, 1: Female, 2:Unknown
    IsDeletedFlag	BIT NOT NULL 	-- 0: Active,	1: Deleted
);

-- Truy vấn dữ liệu--
-- Question 1: Thêm ít nhất 10 bản ghi vào table

INSERT INTO Trainee (   Full_Name		,   Birth_Date	, Gender	, ET_IQ	, ET_Gmath	, ET_English	, Training_Class	, Evaluation_Notes	, VTI_Account		)
VALUE 				('Nguyễn Hải Đăng'	,  '2000-04-29'	, 'male'	,	20	,	20		,	20			,		'VTI001'	,		'Very good'	,	'dangdang'		),
					('Nguyễn Văn Bảo'	,  '2000-05-09'	, 'male'	,	18	,	16		,	16			,		'VTI002'	,		'Normal'	,	'baobao'		),
                    ('Hoàng Thị Thường'	,  '2000-06-22'	, 'female'	,	11	,	17		,	10			,		'VTI003'	,		'Good'		,	'thuongthuong'  ),
                    ('Lê Tuấn Anh'		,  '2000-07-24'	, 'male'	,	20	,	12		,	20			,		'VTI004'	,		'Good'		,	'tuananh'		),
                    ('Ngô Vân Anh'		,  '2000-08-05'	, 'female'	,	16	,	20		,	16			,		'VTI005'	,		'Normal'	,	'ngovananh'		),
                    ('Nguyễn Văn Dũng'	,  '2000-09-08'	, 'female'	,	19	,	10		,	19			,		'VTI006'	,		'Good'		,	'dungtroc'		),
                    ('Nguyễn Hải Hậu'	,  '2000-10-11'	, 'male'	,	20	,	19		,	18			,		'VTI007'	,		'Normal'	,	'haihau'		),
                    ('Tống Quang Anh'	,  '2000-11-12'	, 'female'	,	15	,	20		,	17			,		'VTI008'	,		'Good'		,	'antondev'		),
                    ('Nguyễn Xuân Chiến',  '2000-11-13'	, 'unknown'	,	20	,	19		,	20			,		'VTI009'	,		'Normal'	,	'xuanchien'	),
					('Nguyễn Thị Hảo'	,  '2000-11-13'	, 'female'	,	20	,	19		,	15			,		'VTI010'	,		'Good'		,	'haohao'	);
-- Question 2: Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào,nhóm chúng thành các tháng sinh khác nhau
SELECT  GROUP_CONCAT(Full_Name) AS ` NHóm tên `,MONTH(Birth_Date) AS ` Nhóm Tháng`
FROM Trainee
GROUP BY MONTH(Birth_Date);

-- Question 3: Viết lệnh để lấy ra thực tập sinh có tên dài nhất, lấy ra các thông tin sau:tên, tuổi, các thông tin cơ bản (như đã được định nghĩa trong table)
SELECT Full_Name, Birth_Date, char_length(Full_Name)
FROM Trainee
WHERE char_length(Full_Name) = (SELECT MAX(char_length(Full_Name))
								FROM Trainee);
                                
/* Question 4: Viết lệnh để lấy ra tất cả các thực tập sinh là ET, 1 ET thực tập sinh là
những người đã vượt qua bài test đầu vào và thỏa mãn số điểm như sau:
 ET_IQ + ET_Gmath>=20
 ET_IQ>=8
 ET_Gmath>=8
 ET_English>=18 */

SELECT *
FROM Trainee
WHERE ET_IQ + ET_Gmath>=20 AND ET_IQ>=8 AND ET_Gmath>=8 AND ET_English>=18;

-- Question 5: xóa thực tập sinh có TraineeID = 3
DELETE 
FROM Trainee
WHERE TraineeID =3;

-- Question 6: Thực tập sinh có TraineeID = 5 được chuyển sang lớp "2". Hãy cập nhật thông tin vào database
UPDATE Trainee 
SET Training_Class =2
WHERE TraineeID=5;

-- Create table Department
DROP TABLE IF EXISTS Department;
CREATE TABLE IF NOT EXISTS Department
( Department_Number  		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
 Department_Name 			NVARCHAR(50) NOT NULL UNIQUE KEY
 );
 -- Create table Employee
DROP TABLE IF EXISTS Employee_Table;
CREATE TABLE IF NOT EXISTS Employee_Table
( Employee_Number  			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
 Employee_Name 				NVARCHAR(50) NOT NULL,
 Department_Number			TINYINT UNSIGNED NOT NULL,
 FOREIGN KEY(Department_Number) REFERENCES Department(Department_Number)
 );
  -- Create table Employee_Skill_Table

DROP TABLE IF EXISTS Employee_Skill_Table;
CREATE TABLE IF NOT EXISTS Employee_Skill_Table
( Employee_Number  			TINYINT UNSIGNED AUTO_INCREMENT,
 Skill_Code 				NVARCHAR(50) NOT NULL,
 Date_Registered 			DATETIME DEFAULT NOW(),
 FOREIGN KEY(Employee_Number) REFERENCES Employee_Table(Employee_Number)
 );
 -- Truy vấn dữ liệu
 -- question 2 Thêm ít nhất 10 bản ghi vào table

			-- table Department
	INSERT INTO Department	(Department_Name) 
VALUES 					(N'Marketing'	),
						(N'Sale'		),
						(N'Bảo vệ'		),
						(N'Nhân sự'		),
						(N'Kỹ thuật'	),
						(N'Tài chính'	),
						(N'Phó giám đốc'),
						(N'Giám đốc'	),
						(N'Thư kí'		),
						(N'Bán hàng'	);

    -- table  Employee_Table
 INSERT INTO Employee_Table (Employee_Name,				Department_Number)
 VALUES 						('Trần Xuân Hiếu'	,				4			),
								 ('Nguyễn Văn Bảo'	,				4			),
								 ('Hoàng Thị Thường',				2			),
								 ('Lê Tuấn Anh'		,				3			),
								 ('Ngô Vân Anh'		,				1			),
								 ('Nguyễn Văn Dũng'	,				4			),
								 ('Nguyễn Hải Hậu'	,				10			),
								 ('Tống Quang Anh'	,				7			),
								 ('Nguyễn Xuân Chiến',				6			),
								 ('Nguyễn Thị Hảo'	,               1			);
                                 
	--  table Employee_Skill_Table
    INSERT INTO Employee_Skill_Table 	(Employee_Number, Skill_Code	, Date_Registered	)
VALUES								( 	1,				'Java'		, '2020-03-15'		),
									( 	2,				'Android'	, '2020-03-16'		),
									( 	3,				'C#'		, '2020-03-17'		),
									( 	1,				'SQL'		, '2020-03-20'		),
									( 	1,				'Postman'	, '2020-03-21'		),
									( 	4,				'Ruby'		, '2020-04-22'		),
									( 	5,				'Java'		, '2020-04-24'		),
									( 	6,				'C++'		, '2020-04-27'		),
									( 	7,				'C Sharp'	, '2020-04-04'		),
									( 	10,				'PHP'		, '2020-04-10'		);
                                    
-- Question 3: Viết lệnh để lấy ra danh sách nhân viên (name) có skill Java
SELECT e.Employee_Name, ek.Skill_Code
FROM Employee_Table e
JOIN Employee_Skill_Table ek On e.Employee_Number = ek.Employee_Number
WHERE ek.Skill_Code = 'Java';
-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT d.Department_Name, COUNT(e.Department_Number)
FROM  Department d
JOIN Employee_Table e On d.Department_Number = e.Department_Number
GROUP BY e.Department_Number
HAVING COUNT(e.Department_Number)>=3;
-- Question 5: Viết lệnh để lấy ra danh sách nhân viên của mỗi văn phòng ban. 
SELECT		 E.Employee_Number, GROUP_CONCAT(E.Employee_Name), D.Department_Number
FROM		Department D
JOIN Employee_Table E ON D.Department_Number = E.Department_Number
GROUP BY	E.Department_Number
ORDER BY	E.Department_Number ASC;

-- Question 6: Viết lệnh để lấy ra danh sách nhân viên có > 1 skills.
SELECT 		ET.*, COUNT(EST.Employee_Number)
FROM		Employee_Table ET RIGHT JOIN Employee_Skill_Table EST
ON			ET.Employee_Number = EST.Employee_Number
GROUP BY	ET.Employee_Number
HAVING 		COUNT(EST.Employee_Number)>1;


    
                                 