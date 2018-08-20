use store_front;

#DBMS Session4 Q1

/*Create a function to calculate number of orders in a month. 
Month and year will be input parameter to function.*/
DROP FUNCTION IF EXISTS max_order_month;
DROP FUNCTION IF EXISTS number_of_order;

DELIMITER $$
CREATE FUNCTION number_of_order(year INT,month INT) RETURNS INT DETERMINISTIC
	BEGIN
		DECLARE no_of_order INT;
		SET no_of_order=0;

		SELECT COUNT(*)
		INTO no_of_order
		FROM Order_Placed
		WHERE YEAR(order_date)=year
		AND MONTH(order_date)=month;

		return no_of_order;
END $$


SELECT number_of_order(2018,6);


/*Create a function to return month in a year having maximum orders. Year will be input parameter.*/
DELIMITER $
CREATE FUNCTION max_order_month(year INT) RETURNS INT DETERMINISTIC
	BEGIN
	DECLARE max_month INT;

	SET max_month=0;
	SELECT MONTH(order_date)
	INTO max_month
	FROM order_placed
	WHERE YEAR(order_date)=year
	GROUP BY MONTH(order_date)
	ORDER BY COUNT(*) DESC
	LIMIT 1;
 
 return max_month;
END $

SELECT max_order_month(2018);


