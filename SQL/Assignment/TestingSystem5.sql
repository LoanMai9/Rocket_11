INSERT INTO Question(Content			, 	CategoryID, 	TypeID		, CreatorID	, CreateDate )
VALUES				(N'Câu hỏi về Java3', 		1,			'1',				'2',	'2024-04-05');

DROP TRIGGER IF EXISTS trigger_create_date_question;
DELIMITER $$
CREATE TRIGGER trigger_create_date_question
BEFORE INSERT ON Question
FOR EACH ROW
BEGIN
	IF NEW.CreateDate > NOW() THEN
     SET NEW.CreateDate = NOW();
     END IF;
END $$
DELIMITER ;
-- không cho phép insert
DROP TRIGGER IF EXISTS trigger_create_date_question;
DELIMITER $$
CREATE TRIGGER trigger_create_date_question
BEFORE INSERT ON Question
FOR EACH ROW
BEGIN
	IF NEW.CreateDate > NOW() THEN
     SIGNAL SQLSTATE '12345'
     SET MESSAGE_TEXT = 'Create Date khong the lon hon tgian hien tai';
     END IF;
END $$
DELIMITER ;
-- Delete id 
	DELETE
    FROM Question
    WHERE QuestionID = 2;
DROP TRIGGER IF EXISTS trigger_delete_id_question;
DELIMITER $$
CREATE TRIGGER trigger_delete_id_question
BEFORE DELETE ON Question
FOR EACH ROW
BEGIN
	DELETE
    FROM Answer
    WHERE QuestionID = OLD.QuestionID;
    DELETE
    FROM Examquestion 
    WHERE QuestionID = OLD.QuestionID;
END $$
DELIMITER ;

-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user
INSERT INTO `GroupAccount`	(  GroupID	, AccountID	, JoinDate	 )
VALUES 						(	1		,    12		,'2020-03-05');
DROP TRIGGER IF EXISTS trigger_insert_groupaccount;
DELIMITER $$
CREATE TRIGGER trigger_insert_groupaccount
BEFORE INSERT ON GroupAccount
FOR EACH ROW
BEGIN
	IF (SELECT GroupID
		FROM GroupAccount
        GROUP BY GroupID
        HAVING COUNT(AccountID)>=5 ) THEN 
	 SIGNAL SQLSTATE '12345'
     SET MESSAGE_TEXT = 'mỗi group nhiều nhất 5 người';
     END IF;
END $$
DELIMITER ;
INSERT INTO `GroupAccount`	(  GroupID	, AccountID	, JoinDate	 )
VALUES 						(	1		,    15		,'2020-03-05');
