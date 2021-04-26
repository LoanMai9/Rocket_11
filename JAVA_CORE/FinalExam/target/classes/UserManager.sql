DROP DATABASE IF EXISTS UserManager;
CREATE DATABASE IF NOT EXISTS UserManager; 
USE UserManager;
Drop TABLE IF EXISTS Project;
CREATE TABLE Project(

	projectId 		INT AUTO_INCREMENT PRIMARY KEY,
    teamSize 		INT NOT NULL,
    idManager		INT NOT NULL,
    idEmployees  	INT NOT NULL
);

Drop TABLE IF EXISTS UserManager;
CREATE TABLE UserManager(

	id 				INT AUTO_INCREMENT PRIMARY KEY,
    fullName		NVARCHAR(100),
    email			NVARCHAR(100),
    `password`		NVARCHAR(30) CHECK(length(`password`) >= 6),
    `role`			ENUM('EMPLOYEE', 'MANAGER'),
    expInYear		INT,
    projectId		INT,
    proSkill		NVARCHAR(30),
    FOREIGN KEY(projectId)		REFERENCES 	Project(projectId)
);
INSERT INTO Project (projectId,			teamSize,		 idManager,			idEmployees)
VALUE 				('1',		 		2 ,  				1,					2		),
					('2',		 		2 ,  				2,					6		),
                    ('3',		 		2 ,  				1,					3		),
                    ('4',		 		2 ,  				2,					5		),
                    ('5',		 		2 ,  				2,					6		),
                    ('6',		 		2 ,  				1,					2		);



INSERT	INTO		UserManager	(	id	,	fullName			,	 email				,	`password`		,	`role`			,	expInYear, 		projectId	, proSkill	)
VALUE						(	'1' ,	'Tran Tuan Anh'		, 'anhtuantran@gmail.com'	,	'AnhTuan'		,	'MANAGER'		, 	10				, null		,	null	),
							(	'2' ,	'Nguyen Van Hieu'	, 'hieunv@gmail.com'		,	'HieuNV99'		,	'EMPLOYEE'		, 	null			,  2		,	'Dev'	),
                            (	'3' ,	'Tran Thi Hoa'		, 'hoatt@gmail.com'			,	'MaiTran99'		,	'EMPLOYEE'		, 	null			,  3		,	'Test'	),
                            (	'4' ,	'Tran Ngoc Ha'		, 'hatn@gmail.com'			,	'HaTran123'		,	'MANAGER'		, 	6				,  null		,	'JAVA'	),
                            (	'5' ,	'Mai Van Nam'		, 'nammv@gmail.com'			,	'No123456'		,	'EMPLOYEE'		, 	null			,	5 		, 	'SQL'	),
                            (	'6' ,	'Ha Thi Hong'		, 'honghtt@gmail.com'		,	'HongHa99'		,	'EMPLOYEE'		, 	null			,	6		,	'BM'	);
		