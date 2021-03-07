-- thông tin các account tham gia vào bao nhiêu group
        -- b1 thống kê các account tham gia vào bao nhiêu group
        -- account số lượng
        SELECT *, COUNT(GroupID) as sluong
        FROM groupaccount
        GROUP BY AccountID;
        
        -- B2 lấy max số lượng (2)
        SELECT *, COUNT(GroupID) as sluong
        FROM groupaccount
        GROUP BY AccountID
        ORDER BY sluong DESC
        LIMIT 1;
        -- b3 : lấy số  lương = max
        SELECT AccountID, COUNT(GroupID) as sluong
        FROM groupaccount
        GROUP BY AccountID
        HAVING sluong=3;
        
-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
CREATE VIEW dsnhanviensale AS
( SELECT *
FROM `Account` 
WHERE DepartmentID = (	SELECT DepartmentID
						FROM Department 
                        WHERE DepartmentName =N'Sale'));
                        
--  thông tin các account tham gia vào nhiều group nhất

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
			FROM groupaccount
			GROUP BY AccountID)
        SELECT *
        FROM acctgianhieugroup 
        WHERE sluong = (SELECT MAX(sluong) FROM acctgianhieugroup
						)
                        ;
                        
-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi

-- Question 4: Tạo view có chứa danh sách các phòng ban department có nhiều nhân viên account nhất
 SELECT *, COUNT(DepartmentID)
 FROM `Account`


-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
