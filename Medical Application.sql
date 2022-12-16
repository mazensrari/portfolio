DROP DATABASE IF EXISTS surgery;
CREATE DATABASE surgery;
USE surgery;

DROP TABLE IF EXISTS Surgery_Day22;
CREATE TABLE Surgery_Day22(
	ID INT primary key,
	FName VARCHAR(15),
	LName VARCHAR(15),
    DateOfBirth DATE,
	HouseNo INT,
	Street VARCHAR(30),
	City VARCHAR(15),
	Budget INT,
	SurgeryID INT,
    SurgeryAddress VARCHAR(40),
    SurgeryPhoneNo VARCHAR(25)
);

INSERT INTO Surgery_Day22 (ID, FName, LName, DateOfBirth, HouseNo, Street, City, Budget, SurgeryID, SurgeryAddress, SurgeryPhoneNo) VALUES (1,'Ben','Miflin','1980-01-04',12,'Greek Street','Tamworth',10000,231,'44 Wibble Street, Tamworth','0553987654');
INSERT INTO Surgery_Day22 (ID, FName, LName, DateOfBirth, Street, City, Budget, SurgeryID, SurgeryAddress, SurgeryPhoneNo) VALUES (2,'Hans','Krebbs','1984-07-18','Rothamsted Manor','Lichfield',24200,231,'44 Wibble Street, Tamworth', '0553987654');
INSERT INTO Surgery_Day22 (ID, FName, LName, DateOfBirth, HouseNo, Street, City, Budget, SurgeryID, SurgeryAddress) VALUES (3,'Mary','Jones','1974-09-25',12,'Rotten Row','Tamworth',1100,243,'47 Codfangler Lane, Lichfield');
INSERT INTO Surgery_Day22 (ID, FName, LName, DateOfBirth, Street, City, Budget, SurgeryID, SurgeryAddress, SurgeryPhoneNo) VALUES (4,'Jane','Hughes','1988-12-03','Rothamsted Manor','Lichfield',12100,231,'44 Wibble Street, Tamworth', '0553987654');
INSERT INTO Surgery_Day22 (ID, FName, LName, DateOfBirth, HouseNo, Street, City, Budget, SurgeryID, SurgeryAddress) VALUES (5,'Bill','Pirie','1977-05-05',23,'Final Way','Lichfield',16500,243,'47 Codfangler Lane, Lichfield');

/*ALTER TABLE Surgery_Day22
ADD DateOfBirth DATE;

UPDATE Surgery_Day22
SET DateOfBirth = '1980-01-01'
WHERE ID = 1;

UPDATE Surgery_Day22
SET DateOfBirth = '1984-07-18'
WHERE ID = 2;*/

SELECT * FROM Surgery_Day22;

-- Display the names of those patients who do not live in Lichfield

SELECT 
    FName, LName
FROM
    Surgery_Day22
WHERE
    City != 'Lichfield';
    
    -- Display the total number of surgeries

SELECT 
    COUNT(SurgeryID)
FROM
    Surgery_Day22;
    
    -- Return the total budget for Lichfield

SELECT 
    SUM(Budget) AS TotalBudgetLichfield
FROM
    Surgery_Day22
WHERE
    City = 'Lichfield';
    
    -- Display the average budget allocation for patients attending surgery 231

SELECT 
    AVG(budget) AS AverageBudget231
FROM
    Surgery_Day22
WHERE
    SurgeryID = 231;
    
/*SELECT 
 SUM(budget) - (SELECT AVG(budget) FROM Surgery_Day22)
 FROM
 Surgery_Day22;*/
    
-- Produce a query to show by how much the budget of patients with an above average
-- budget differs from the average 

SELECT 
    budget - (SELECT 
            AVG(budget)
        FROM
            Surgery_Day22)
FROM
    Surgery_Day22;

-- Select the total cost of the budget for surgeries 231 and 243 only

SELECT 
    SUM(budget)
FROM
    Surgery_Day22
WHERE
    SurgeryID = 231 OR SurgeryID = 243;
    
-- • Return the names of any patients with a budget greater than the average for surgery 243.

SELECT 
    FName, LName
FROM
    Surgery_Day22
WHERE
    budget > (SELECT 
            AVG(budget)
        FROM
            Surgery_Day22
        WHERE
            SurgeryID = 243);
            
-- Return the names of any patients with a budget allocation greater than any of the
-- patients attending surgery 231.

SELECT 
    FName, LName
FROM
    Surgery_Day22
WHERE
    budget > (SELECT 
            MAX(budget)
        FROM
            Surgery_Day22
        WHERE
            SurgeryID = 231);
            
-- Return the patients with an above average budget allocation. 
-- Patients should be in alphabetical order.

SELECT 
    FName, LName
FROM
    Surgery_Day22
WHERE
    budget > (SELECT 
            AVG(budget)
        FROM
            Surgery_Day22)
ORDER BY FName , LName; -- by default the ORDER BY will put them in ascending order, no need to specify

-- Return the names of patients without a House No in alphabetical order.

SELECT 
    FName, LName
FROM
    Surgery_Day22
WHERE
    HouseNo IS NULL
ORDER BY FName , LName;

-- ADVANCED TASK FROM HERE ONWARDS

-- Return the average budget for those people born on or after 1 January 1980.
    
SELECT 
    AVG(budget) AS AverageBudgetPatientsBorn1980Onwards
FROM
    Surgery_Day22
WHERE
    DateOfBirth > '1980-01-01';
    
-- 
    
    