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
SELECT  GROUP_CONCAT(Full_Name),MONTH(Birth_Date)
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



