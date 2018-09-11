USE store_front;

Session3 Q4
/*Consider a form where providing a Zip Code populates associated City and
State. 
Create appropriate tables and relationships for the same and write a SQL
         query for that returns a Resultset containing Zip Code, City Names and
         States ordered by State Name and City Name.
*/

CREATE TABLE Zip_Code_Details
(zip_code INT NOT NULL,
city varchar(50) NOT NULL,
state varchar(50) NOT NULL,
PRIMARY KEY(zip_code));

INSERT INTO Zip_Code_Details
VALUES
(313001, 'udaipur', 'rajasthan'),
(302001, 'jaipur', 'rajasthan'),
(305001, 'ajmer', 'rajasthan'),
(282001, 'agra', 'madhya pradesh'),
(411001, 'pune', 'maharashtra'),
(321001, 'bharatpur', 'rajasthan'),
(400008, 'mumbai', 'maharashtra');


SELECT zip_code,city,state
FROM Zip_Code_Details
ORDER BY state,city;