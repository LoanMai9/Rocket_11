-- create database
DROP DATABASE IF EXISTS ProductManagement;
CREATE DATABASE ProductManagement;
USE ProductManagement;

-- create table: Product
-- DROP TABLE IF EXISTS Product;
-- CREATE TABLE Product(
-- 	ProductID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
--     ProductName 			NVARCHAR(30) NOT NULL,
--     TotalProduct			SMALLINT UNSIGNED
-- );
-- create table: Employee
DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee(
	id		 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    FullName 			NVARCHAR(50) NOT NULL UNIQUE KEY,
    UserName			VARCHAR(50) NOT NULL UNIQUE KEY,
    `password` 			VARCHAR(800) NOT NULL,
    OrderID				TINYINT UNSIGNED,
    FOREIGN KEY (OrderID) 			REFERENCES `Order`(OrderID)
);
-- create table: Order
DROP TABLE IF EXISTS `Order`;
CREATE TABLE `Order`(
	OrderID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    OrderName 			NVARCHAR(30) NOT NULL,
    Amount				SMALLINT UNSIGNED,
    ImportDate			DATETIME DEFAULT NOW(),
    employee_id			TINYINT UNSIGNED    
);


-- Create table OrderProduct
-- DROP TABLE IF EXISTS 	OrderProduct;
-- CREATE TABLE IF NOT EXISTS OrderProduct (
--     OrderID 			TINYINT UNSIGNED NOT NULL,
--     ProductID 			TINYINT UNSIGNED NOT NULL,
-- 	FOREIGN KEY (OrderID) 			REFERENCES `Order`(OrderID),
-- 	FOREIGN KEY (ProductID) 		REFERENCES  Product(ProductID),
-- 	PRIMARY KEY (OrderID,ProductID)
-- );
-- INSERT DATA                           

-- password: password
INSERT INTO Employee (FullName,   			 UserName	,			`password`,													OrderID)
VALUE			('Hà Văn Hanh'		,		'hanhvan'	,			'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',		3),	
				('Nguyễn Thanh Hưng',		'thanhhung'	,			'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',		2),	
				("Trần Ngọc Bảo Lan",		'baolan'	,			'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',		4),
                ("Cấn Tuấn Anh"		,		'tuananh'	,			'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',		5),
				("Nguyễn Anh Toàn"	,		'anhtoan'	,			'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',		1);
                
INSERT INTO `Order` 		(OrderName	, 		Amount,		ImportDate,		employee_id)
VALUE					 	('LUX A2.0'	,		5,			'2021-06-28', 		5), 
							('FADI'		,		6,			NOW()		,		2), 
							('VS e34'	,		7,			'2021-06-28',		1),
							('PRESIDENT',		8,			'2021-06-28',		3),
							('LUX SA2.0',		9,			'2021-06-29',		4);
                
-- INSERT INTO Product 	(	ProductName, 		TotalProduct)
-- VALUE					 	('PRESIDENT',				15), 
-- 							('VS e34'	,				16), 
-- 							('LUX A2.0'	,				17),
-- 							('LUX SA2.0',				18),
-- 							('FADI'		,				19);
                            
                            
-- INSERT INTO OrderProduct (OrderID,	ProductID)
-- VALUES					(4,			1		),
-- 						(1,			3		),
--                         (3,			2		),
--                         (5,			4		),
--                         (2,			5		);
	

-- SET FOREIGN_KEY_CHECKS=0;
                
