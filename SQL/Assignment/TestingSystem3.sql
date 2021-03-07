
-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
CREATE VIEW dsnhanviensale AS
( SELECT *
FROM `Account` 
WHERE DepartmentID = (	SELECT DepartmentID
						FROM Department 
                        WHERE DepartmentName =N'Sale'));
                        
-- Question 2 thông tin các account tham gia vào nhiều group nhất

CREATE VIEW acctgianhieugroup AS (
     SELECT AccountID, COUNT(GroupID) as sluong
        FROM groupaccount
        GROUP BY AccountID
        HAVING sluong=(	SELECT COUNT(GroupID) as sluong
						FROM groupaccount
						GROUP BY AccountID
						ORDER BY sluong DESC
						LIMIT 1)
                        );
          -- Dạng CTE 
	WITH acctgianhieugroup AS (
			SELECT AccountID, COUNT(GroupID) as sluong
			FROM GroupAccount
			GROUP BY AccountID)
        SELECT *
        FROM acctgianhieugroup 
        WHERE sluong = (SELECT MAX(sluong) 
						FROM acctgianhieugroup)
                        ;
                        
-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi
CREATE OR REPLACE VIEW ContenTren18Tu
AS
SELECT 	LENGTH(Content)
FROM	Question
WHERE	LENGTH(Content) > 18;
SELECT * FROM ContenTren18Tu;
DROP VIEW ContenTren18Tu;


-- Question 4: Tạo view có chứa danh sách các phòng ban department có nhiều nhân viên account nhất
 CREATE OR REPLACE VIEW DepartmentMaxAccount AS
SELECT 		D.*, COUNT(A.DepartmentID)
FROM		Department D 
JOIN `Account` A ON D.DepartmentID = A.DepartmentID
GROUP BY	D.DepartmentID
HAVING		COUNT(A.DepartmentID) = (
									SELECT 		COUNT(A.DepartmentID)
									FROM		Department D 
                                    JOIN `Account` A ON	D.DepartmentID = A.DepartmentID
									GROUP BY	D.DepartmentID
									HAVING		COUNT(A.DepartmentID)
                                    ORDER BY	COUNT(A.DepartmentID) DESC
                                    LIMIT		1
                                    );
SELECT * FROM DepartmentMaxAccount;


-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
CREATE OR REPLACE VIEW QuesHoNguyen
AS
SELECT 		Q.*, A.FullName
FROM 		Question Q
 JOIN `Account` A ON Q.CreatorID = A.AccountID
WHERE		SUBSTRING_INDEX(FullName,' ',1) = 'Nguyen';
