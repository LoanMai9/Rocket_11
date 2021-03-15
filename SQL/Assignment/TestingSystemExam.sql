-- Create Database Project
DROP DATABASE IF EXISTS Project;
CREATE DATABASE IF NOT EXISTS Project;
-- Use Database
USE Project;

-- Create Table CUSTOMER
DROP TABLE IF EXISTS CUSTOMER;
CREATE TABLE 	CUSTOMER ( 
	CustomerID 					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`Name`						VARCHAR(30) NOT NULL,
	Phone 						CHAR(13) NOT NULL,
	Email 						VARCHAR(50) UNIQUE KEY NOT NULL,
	Address 					VARCHAR(100) NOT NULL,
    Note						VARCHAR(500) NOT NULL
);

-- Create Table CAR
DROP TABLE IF EXISTS CAR;
CREATE TABLE 	CAR (
	CarID 						TINYINT  UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Maker						ENUM('HONDA','TOYOTA','NISSAN') NOT NULL ,
	Model 						CHAR(13) NOT NULL,
	`Year` 						SMALLINT UNIQUE KEY NOT NULL,
	Color 						VARCHAR(50) NOT NULL,
    Note						VARCHAR(500) NOT NULL
);

-- Create Table CAR_ORDER
DROP TABLE IF EXISTS CAR_ORDER;
CREATE TABLE 	CAR_ORDER ( 
	OrderID 					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	CustomerID					TINYINT UNSIGNED NOT NULL ,
	CarID 						TINYINT UNSIGNED NOT NULL,
	Amount						SMALLINT DEFAULT 1 NOT NULL,
	SalePrice 					DOUBLE NOT NULL,
	OrderDate 					DATE NOT NULL,
	DeliveryDate 				DATE NOT NULL,
	DeliveryAddress 			VARCHAR(100) NOT NULL,
	Staus 						TINYINT(2) DEFAULT 0 NOT NULL,
    Note						VARCHAR(500) NOT NULL,
    FOREIGN KEY (CarID) REFERENCES  CAR(CarID) ON DELETE CASCADE,
    FOREIGN KEY (CustomerID) REFERENCES  CUSTOMER(CustomerID) ON DELETE CASCADE
);
--  Insert at least 5 record to table 
INSERT INTO	CUSTOMER
	(`Name`,				Phone,				Email,					Address,						Note	)
	VALUES
	('A',					'123456',			'acb@gmail.com',		'HN',							'1'		),
	('A1',					'1234562',			'acb1@gmail.com',		'H1N',							'21'	),
	('A2',					'1234564',			'acb2@gmail.com',		'HN2',							'12'	);
	
 INSERT INTO	CAR
	(Maker,					 Model,				`Year`,					Color,							Note)
	VALUES
	('HONDA',				'HONDA1',			1990,					'YEALLOW',						'1'		),
	('TOYOTA',				'TOYOTA1',			1992,					'BLUE',							'12'	),
	('NISSAN',				'NISSAN1',			1994,					'RED',							'111'	);
	
INSERT INTO		CAR_ORDER 											-- ngày bán			ngày giao 
	(CustomerID,	CarID,			Amount,		SalePrice, 			OrderDate, 			DeliveryDate, 		DeliveryAddress,	Staus,	Note)
	VALUES
	(1,				2,				2,			 5.000000,			'2000-03-01',		'2000-03-21',		 	'HN' ,			0,		'123'	),
	(2,				2,				2,			 6.000000,			'2000-03-04',		'2021-03-10',			'HN1',			1,		'1234'	),
	(3,				2,				2,			 8.000000,			'2000-03-08',		'2021-03-15',			'HN2',			1,		'1235'	),
	(3,				1,				7,			 8.000000,			'2000-03-08',		'2021-03-15',			'HN2',			1,		'1235'	),
    (2,				1,				1,			 9.000000,			'2000-03-08',		'2021-03-15',			'HN3',			2,		'1456'	);


-- 2. Viết lệnh lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã mua và sắp sếp tăng dần theo số lượng oto đã mua.

SELECT		C.`Name`, t.NumberCars
		FROM		CUSTOMER	c		
		JOIN		(
						SELECT		co.CustomerID ,SUM(co.Amount) AS NumberCars
						FROM		CAR_ORDER	co
						WHERE		co.Staus = 1 -- đã mua hàng 1
						GROUP BY	co.CustomerID
						HAVING		SUM(co.Amount) > 0
					)	AS	t	ON c.CustomerID = t.CustomerID
		ORDER BY t.NumberCars ASC;
        
-- 3. Viết hàm(function) (không có parameter) trả về tên hãng sản xuất đã bán được nhiều oto nhất trong năm nay.
SET GLOBAL log_bin_trust_function_creators = 1;
DROP FUNCTION IF EXISTS Makerboughtmostcaryear;
DELIMITER $$
CREATE FUNCTION Makerboughtmostcaryear() RETURNS NVARCHAR(50)
BEGIN
	DECLARE 	out_maker_name NVARCHAR(50);
    
	WITH CTE_otoboughtmaxyear AS(
		SELECT		 CarID, SUM(Amount)  AS MaxAmount
					FROM		CAR_ORDER 
					WHERE		YEAR(now()) = YEAR(DeliveryDate) AND Staus = 1
					GROUP BY	CustomerID
					ORDER BY	MaxAmount DESC
		)
	SELECT c.Maker INTO out_maker_name
	FROM CTE_otoboughtmaxyear cte
	JOIN Car c ON cte.CarID = c.CarID
	WHERE MaxAmount =(SELECT MAX(MaxAmount)
						FROM CTE_otoboughtmaxyear);
		
    RETURN 	out_maker_name;
END$$
DELIMITER ;

-- 4. Viết 1 thủ tục (không có parameter) để xóa các đơn hàng đã bị hủy của những năm trước. In ra số lượng bản ghi đã bị xóa.
DROP PROCEDURE IF EXISTS Ordercanceledinyearsbefore;
DELIMITER $$
CREATE PROCEDURE Ordercanceledinyearsbefore()
BEGIN
			DELETE 
			FROM	CAR_ORDER
			WHERE	Staus = 2 AND YEAR(OrderDate) < YEAR(NOW());
			SELECT row_count() as delete_row;
END$$
DELIMITER ;
Call Ordercanceledinyearsbefore();


-- 5. Viết 1 thủ tục (có CustomerID parameter) để in ra thông tin của các đơn hàng đã đặt hàng bao gồm: tên của khách hàng, mã đơn hàng, 
				-- số lượng oto và tên hãng sản xuất.
DROP PROCEDURE IF EXISTS Informationcarporder;
DELIMITER $$
CREATE PROCEDURE Informationcarporder(IN in_CustomerID TINYINT UNSIGNED)
BEGIN
	SELECT c.Name,ca.Maker,co.OrderID, co.Amount
	FROM Car_Order co
	JOIN Customer c ON co.CustomerID= c.CustomerID
	JOIN Car ca ON co.CarID = ca.CarID
    WHERE c.CustomerID=in_CustomerID;
END$$
DELIMITER ;

Call Informationcarporder('');
-- View

CREATE OR REPLACE VIEW acctgianhieugroup AS (
     SELECT AccountID, COUNT(GroupID) as sluong
        FROM groupaccount
        GROUP BY AccountID
        HAVING sluong=(	SELECT COUNT(GroupID) as sluong
						FROM groupaccount
						GROUP BY AccountID
						ORDER BY sluong DESC
						LIMIT 1)
                        );

-- 6. Viết trigger để tránh trường hợp người dụng nhập thông tin không hợp lệ vào database (DeliveryDate < OrderDate + 15)
INSERT INTO		CAR_ORDER 											-- ngày bán			ngày giao 
	(CustomerID,	CarID,			Amount,		SalePrice, 			OrderDate, 			DeliveryDate, 		DeliveryAddress,	Staus,	Note)
	VALUES
	(2,				1,				3,			 9.000000,			'2021-03-01',		'2021-03-20',		 	'HN9' ,			0,		'đang vận chuyển'	);
DROP TRIGGER IF EXISTS trigger_in_information_illegal;
DELIMITER $$
CREATE TRIGGER trigger_in_information_illegal
BEFORE INSERT ON Car_Order
FOR EACH ROW
	BEGIN
	DECLARE		delivery_declare	TINYINT;
		
		SELECT DATEDIFF(New.DeliveryDate, New.OrderDate) INTO delivery_declare;
		if delivery_declare >15 then
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT ='không hợp lệ';
			end if;
    
	END $$
DELIMITER ;
-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
-- admin@gmail.com (đây là tài khoản admin, không cho phép user xóa), còn lại các tài
-- khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông tin liên quan tới user đó
DROP TRIGGER IF EXISTS trigger_delete_account;
DELIMITER $$
CREATE TRIGGER trigger_delete_account
BEFORE DELETE ON `Account`
FOR EACH ROW
BEGIN
	IF OLD.Email = 'admin@gmail.com' 
    THEN 
		SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT = 'Cannot delete data';
	END IF;
    
END $$
DELIMITER ; 
INSERT INTO `Account`(Email				, Username			, FullName				, DepartmentID	, PositionID, CreateDate)
VALUE 				('admin@gmail.com'	, 'dangblacky'		,'Nguyen Hai Dang'		,   '5'			,   '1'		,'2020-03-05');

DELETE
FROM `Account`
WHERE Email = 'admin@gmail.com';
-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table
-- Account, hãy tạo trigger cho phép người dùng khi tạo account không điền vào
-- departmentID thì sẽ được phân vào phòng ban "Phòng chờ"
DROP TRIGGER IF EXISTS trigger_create_account;
DELIMITER $$
	CREATE TRIGGER trigger_create_account
    BEFORE INSERT ON `Account`
    FOR EACH ROW
    BEGIN
		DECLARE WaitingDepartment_ID TINYINT UNSIGNED;
			SELECT DepartmentID INTO WaitingDepartment_ID
            FROM Department
            WHERE DepartmentName = 'Phòng chờ';
		IF NEW.DepartmentID IS NULL
        THEN SET NEW.DepartmentID = WaitingDepartment_ID;
		END IF;
	END $$
    DELIMITER ;
    
    DROP TRIGGER IF EXISTS trigger_create_answer;
DELIMITER $$
	CREATE TRIGGER trigger_create_answer
    BEFORE INSERT ON Answer
    FOR EACH ROW
    BEGIN
		DECLARE NumberAnswer TINYINT UNSIGNED;
        DECLARE NumberCorrectAnswer TINYINT UNSIGNED;
			SELECT COUNT(AnswerID) INTO NumberAnswer
            FROM Answer
            WHERE QuestionID = New.QuestionID;
            
			SELECT COUNT(AnswerID) INTO NumberCorrectAnswer
            FROM Answer
            WHERE QuestionID = New.QuestionID AND isCorrect = 'Yes';
            
		IF NumberAnswer >=4 OR NumberCorrectAnswer>=2 THEN 
        SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Cannot insert data';
		END IF;
       
	END $$
    DELIMITER ;
    
    -- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
DROP TRIGGER IF EXISTS Delete_Exam;
DELIMITER $$
CREATE TRIGGER Delete_Exam
BEFORE DELETE ON Exam
FOR EACH ROW
BEGIN
      IF (NEW.CreateDate = DATE_SUB(NOW(),INTERVAL 2 DAY)) THEN
         SIGNAL SQLSTATE '12345'
         SET MESSAGE_TEXT = 'Không được xóa Exam vừa tạo 2 ngày trước';
	  END IF ;
END $$
DELIMITER ;
-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các
-- question khi question đó chưa nằm trong exam nào
DROP TRIGGER IF EXISTS Delete_Update;
DELIMITER $$
CREATE TRIGGER Delete_Update
BEFORE UPDATE  ON Question
FOR EACH ROW
BEGIN
	DECLARE Not_On_Exam TINYINT;   
	SELECT q.QuestionID INTO Not_On_Exam
	FROM Question q
	LEFT JOIN ExamQuestion eq ON q.QuestionID = eq.QuestionID
	WHERE eq.ExamID IS NULL;
		IF NEW.QuestionID != Not_On_Exam THEN
		SIGNAL SQLSTATE '12345'
		SET MESSAGE_TEXT = 'Không thể INSERT'; 
		END IF ;
END $$
DELIMITER ;

-- Question 12: Lấy ra thông tin exam trong đó
-- Duration <= 30 thì sẽ đổi thành giá trị "Short time"
-- 30 < duration <= 60 thì sẽ đổi thành giá trị "Medium time"
-- duration >60 thì sẽ đổi thành giá trị "Long time"
SELECT ExamID,
		CASE 
			WHEN Duration <= 30 THEN 'Short time'
            WHEN Duration <= 60 AND Duration >30 THEN 'Medium time'
            ELSE 'Longtime'
		END AS ExamDuration
FROM Exam;
-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên
-- là the_number_user_amount và mang giá trị được quy định như sau:
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher
SELECT GroupID, 
		CASE
			WHEN COUNT(AccountID) <=5 THEN 'Few'
            WHEN COUNT(AccountID) <=20 AND COUNT(AccountID)>5 THEN 'Normal'
            ELSE 'Higher'
		END AS the_number_user_amount
FROM GroupAccount
GROUP BY GroupID;


-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào
-- không có user thì sẽ thay đổi giá trị 0 thành "Không có User"

SELECT d.DepartmentName,
		CASE
			WHEN COUNT(a.AccountID) = 0 THEN 'Khong co User'
            ELSE COUNT(a.AccountID)
		END AS Number_of_Account
FROM Department d
JOIN `Account` a ON d.DepartmentID = a.DepartmentID
GROUP BY d.DepartmentName;

-- Question 12: xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE FROM Exam WHERE CreateDate < '2019-12-20';
ROLLBACK;
-- Question 13: xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
-- SET FOREIGN_KEY_CHECKS=0;
DELETE FROM Question 
WHERE (SUBSTRING_INDEX(Content,' ',2)) = 'Câu hỏi';
-- SET FOREIGN_KEY_CHECKS=1;