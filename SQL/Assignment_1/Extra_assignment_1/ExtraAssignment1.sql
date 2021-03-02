DROP DATABASE IF EXISTS Fresher_management;
CREATE DATABASE Fresher_management;
USE Fresher_management;

-- Khai báo thực tập sinh
DROP TABLE IF EXISTS Trainee;
CREATE TABLE Trainee(
	TraineeID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Full_Name 				NVARCHAR(50) NOT NULL,
    Birth_Date				DATETIME CHECK(Birth_Date >= '1990-01-01'),
    Gender					ENUM('Male','Female','Unknown') NOT NULL UNIQUE KEY,
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
    ModifiedDate	TIMESTAMP      -- DATETIME DEFAULT NOW()
);

-- Exercise3
DROP TABLE IF EXISTS Exercise3;
CREATE TABLE Exercise3(
	ID 				MEDIUMINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name`			VARCHAR(50) NOT NULL,
    BirthDate		DATE NOT NULL,
    Gender			BIT NULL, 		-- 0: Male, 1: Female, 2:Unknown
    IsDeletedFlag	BIT NOT NULL 	-- 0: Active,	1: Deleted
);