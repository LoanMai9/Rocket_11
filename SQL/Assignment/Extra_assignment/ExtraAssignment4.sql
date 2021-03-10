-- Questions Tạo table với các ràng buộc và kiểu dữ liệu và thêm ít nhất 3 bản ghi vào mỗi table trên
-- TẠO DATABASE 
DROP DATABASE IF EXISTS ExtraAssignment4;
CREATE DATABASE ExtraAssignment4;
USE ExtraAssignment4;

/* =====TẠO BẢNG DỮ LIỆU========*/
DROP TABLE IF EXISTS Project_Modules;
CREATE TABLE Project_Modules
(
	ModuleID 					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ProjectID					TINYINT UNSIGNED NOT NULL,
    EmployeeID					TINYINT UNSIGNED NOT NULL,
    ProjectModulesDate			DATETIME DEFAULT NOW(),
    ProjectModulesOn			DATETIME DEFAULT NOW(),
    ProjectModulesDescription	NVARCHAR(50),
    FOREIGN KEY (ProjectID) 	REFERENCES		Projects(ProjectID),
    FOREIGN KEY	(EmployeeID) 	REFERENCES		Employee(EmployeeID)
);
DROP TABLE IF EXISTS Projects;
CREATE TABLE Projects(
	ProjectID 					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ManagerID					TINYINT	UNSIGNED NOT NULL,
    ProjectName 				NVARCHAR(50) NOT NULL,
    ProjectStartDate			DATETIME DEFAULT NOW(),
    ProjectDescription			NVARCHAR(50) NOT NULL,
    ProjectDetail				NVARCHAR(50) NOT NULL,
    ProjectCompletedOn			DATETIME DEFAULT NOW(),
    FOREIGN KEY 	(ManagerID) REFERENCES		Employee(EmployeeID)
);
DROP TABLE IF EXISTS Work_Done;
CREATE TABLE Work_Done(
	WorkDoneID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    EmployeeID					TINYINT UNSIGNED NOT NULL,
    ModuleID					TINYINT UNSIGNED NOT NULL,
    WorkDoneDate				DATETIME DEFAULT NOW(),
    WorkDoneDescription			NVARCHAR(50) NOT NULL,
    WorkDoneStatus				BIT NOT NULL, -- 1: Hoàn thành, 0: Không hoàn thành
    FOREIGN KEY 	(EmployeeID) REFERENCES		Employee(EmployeeID),
    FOREIGN KEY 	(ModuleID) REFERENCES		Project_Modules(ModuleID)
);
DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee(
	EmployeeID 					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    EmployeeLastName			NVARCHAR(30) NOT NULL,
    EmployeeFirstName			NVARCHAR(30) NOT NULL,
    EmployeeHireDate			DATETIME DEFAULT NOW(),
    EmployeeStatus				BIT NOT NULL,
    SupervisorID				TINYINT UNSIGNED NOT NULL,
    SocialSecurityNumber		CHAR(5),
    FOREIGN KEY (SupervisorID) 	REFERENCES		Employee(EmployeeID)
);

-- Insert dữ liệu
