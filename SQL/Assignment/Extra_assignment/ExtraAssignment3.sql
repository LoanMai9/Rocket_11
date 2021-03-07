-- Question 1: Viết 1 query lấy thông tin "Name" từ bảng Production.Product có name của ProductSubcategory là 'Saddles'.
SELECT 	`Name` 
FROM 	product 
WHERE	ProductSubcategoryID = (SELECT   ProductSubcategoryID
								FROM ProductSubcategory
								WHERE `Name` ='Saddles');
                          
-- Question 2: Thay đổi câu Query 1 để lấy được kết quả sau.
SELECT 	`Name`
FROM 	product 
WHERE	ProductSubcategoryID = (SELECT   `Name`
								FROM ProductSubcategory
								WHERE SUBSTRING_INDEX(SUBSTRING_INDEX(`Name`, ' ', 2), ' ', -1) LIKE 'Bo%'
                                 AND		LENGTH(`Name`)>15);
                                
-- Question 3: Viết câu query trả về tất cả các sản phẩm có giá rẻ nhất (lowest ListPrice) và Touring Bike (nghĩa là ProductSubcategoryID = 3)
    -- lấy ra tất cả sản phẩm có ProductSubcategoryID=3
    SELECT `Name`
    FROM Product
    WHERE ListPrice =(SELECT 	MIN(ListPrice)
						FROM 	Product
						WHERE 	ProductSubcategoryID = 3);

-- Exercise 2: JOIN nhiều bảng 
-- Question 1: Viết query lấy danh sách tên country và province được lưu trong AdventureWorks2008sample database.
 
 SELECT cr.Name, sp.Name 
 FROM countryregion cr
 JOIN stateprovince sp ON sp.CountryRegionCode=cr.CountryRegionCode;
 
 -- Question 2: Tiếp tục với câu query trước và thêm điều kiện là chỉ lấy country Germany và Canada
 
 SELECT cr.Name, sp.Name 
 FROM countryregion cr
 JOIN stateprovince sp ON sp.CountryRegionCode=cr.CountryRegionCode
 WHERE 	cr.Name = 'Canada' 
 OR 	cr.Name= 'Germany';
 
 -- Question 3: SalesOrderID, OrderDate and SalesPersonID. Từ bảng SalesPerson, chúng ta lấy cột BusinessEntityID (là định danh của người sales),
	-- Bonus and the SalesYTD (là đã sale được bao nhiêu người trong năm nay)
    SELECT soh.SalesOrderID, soh.OrderDate, sp.SalesPersonID, sp.Bonus, sp.SalesYTD
    FROM SalesPerson sp
    JOIN salesorderheader soh ON sp.SalesPersonID = soh.SalesPersonID;
    
    -- Question 4:Sử dụng câu query, thêm cột JobTitle and xóa cột SalesPersonID và BusinessEntityID.

    SELECT 		soh.SalesOrderID, soh.OrderDate, e.Title, sp.Bonus, sp.SalesYTD
FROM		salesperson sp 
JOIN salesorderheader soh ON sp.SalesPersonID = soh.SalesPersonID
JOIN	employee e ON sp.SalesPersonID = e.EmployeeID;
			-- xóa cột SalesPersonID
With 
ketqua AS(
	SELECT 		soh.SalesOrderID, soh.OrderDate, e.Title, sp.Bonus, sp.SalesYTD
	FROM		salesperson sp 
	JOIN salesorderheader soh ON sp.SalesPersonID = soh.SalesPersonID
	JOIN	employee e ON sp.SalesPersonID = e.EmployeeID
)
ALTER TABLE ketqua DROP COLUMN SalesPersonID;
