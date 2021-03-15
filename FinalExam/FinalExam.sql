-- Create Database Project
DROP DATABASE IF EXISTS ThucTap;
CREATE DATABASE IF NOT EXISTS ThucTap;
-- Use Database
USE ThucTap;

-- Create Table Country
DROP TABLE IF EXISTS Country;
CREATE TABLE 	Country ( 
	country_id 							TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	country_name						VARCHAR(30) NOT NULL
	
);

-- Create Table Location
DROP TABLE IF EXISTS Location;
CREATE TABLE 	Location (
	location_id 						TINYINT  UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	street_address 						NVARCHAR(50) NOT NULL,
	postal_code							VARCHAR(30) NOT NULL,
	country_id 							TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY (country_id) REFERENCES  Country(country_id) ON DELETE CASCADE
);

-- Create Table Employee
DROP TABLE IF EXISTS Employee;
CREATE TABLE 	Employee ( 
	employee_id 						TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	full_name							NVARCHAR(30) NOT NULL,
    email 								VARCHAR(30) NOT NULL UNIQUE KEY,
	location_id 						TINYINT  UNSIGNED NOT NULL,
    FOREIGN KEY (location_id) REFERENCES  Location(location_id) ON DELETE CASCADE
);
-- Thêm ít nhất 3 bản ghi vào table 
-- Insert  vao Country
INSERT INTO 	Country(country_name)
VALUES 			(N'Việt Nam'),
				(N'Mỹ'),
				(N'Đức'),
				(N'Pháp'),
				(N'Việt Nam');
                
                
			-- Insert  vao Location
INSERT INTO     Location(street_address,    		  postal_code,           country_id)
VALUES					(N'Los Angeles ',				90089,					2	 ),
						(N'Poitou Charentes',			86984,					4	 ),
                        (N'Delitzsch',					04509,					3	 ),
                        (N'Bến Tre',					96000,					5	 ),
                        (N'Hà Nội',						85000,					1	 );
                        
			-- Insert  vao Employee
INSERT INTO     Employee(full_name,    							  email,          		 location_id)
VALUES					(N'Nguyễn Trung Anh',				'trunganh.nta@gmail.com',			2		 ),
						(N'Mai Anh Tuấn', 					'anhtuan.mat@gmail.com',			1		 ),
                        (N'Hoàng Mai Huyền', 				'nn03@gmail.com',					3		 ),
                        (N'Trần Đức Thành', 				'ducthanh.tdt@gmail.com',			4		 ),
                        (N'Hoàng Đình Thắng', 				'dinhthang.hdt@gmail.com',			5		 );
                        
-- Lấy tất cả các nhân viên thuộc Việt nam

SELECT c.country_id, c.country_name, e.employee_id, e.full_name, e.email
FROM  Country c 
JOIN Location l ON c.country_id = l.country_id
JOIN Employee e ON l.location_id = e.location_id
WHERE c.country_name ='Việt Nam';

-- Lấy ra tên quốc gia của employee có email là "nn03@gmail.com"
SELECT e.employee_id,c.country_name AS `Quốc gia`
FROM  Country c 
JOIN Location l ON c.country_id = l.country_id
JOIN Employee e ON l.location_id = e.location_id
WHERE e.email ='nn03@gmail.com';
							
-- Thống kê mỗi country, mỗi location có bao nhiêu employee đang làm việc.

WITH locationhasemployee AS (
			SELECT		l.country_id,e.full_name, l.street_address, COUNT(e.employee_id)
			FROM		location l
			JOIN employee e ON	l.location_id = e.location_id
			GROUP BY	l.location_id)
SELECT c.country_id, c.country_name, le.street_address, COUNT(c.country_name) AS `SL Employee`
FROM Country c
JOIN locationhasemployee le ON c.country_id = le.country_id
GROUP BY c.country_name;

-- Tạo trigger cho table Employee chỉ cho phép insert mỗi quốc gia có tối đa 10 employee
DROP TRIGGER IF EXISTS trigger_insert_employee_country;
DELIMITER $$
CREATE TRIGGER trigger_insert_employee_country
BEFORE INSERT ON Country
FOR EACH ROW
BEGIN
	IF (WITH country_employee AS (
			SELECT c.country_id, c.country_name, e.employee_id, e.full_name
			FROM  Country c 
			JOIN Location l ON c.country_id = l.country_id
			JOIN Employee e ON l.location_id = e.location_id
            GROUP BY country_name
            )
		SELECT country_name
		FROM country_employee
        GROUP BY country_name
        HAVING COUNT(country_name)>=10
	) THEN 
	 SIGNAL SQLSTATE '12345'
     SET MESSAGE_TEXT = 'mỗi quốc gia nhiều nhất 10 employees';
     END IF;
END $$
DELIMITER ;

COMMIT;
-- Hãy cấu hình table sao cho khi xóa 1 location nào đó thì tất cả employee ở location đó sẽ có location_id = null
-- set on delete set null cho Foreign key bảng Employee
DELETE
FROM Employee 
WHERE location_id = '1' ;

