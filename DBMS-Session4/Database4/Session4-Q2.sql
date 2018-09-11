
#DBMS Session4 Q2
USE store_front;

/*Create a Stored procedure to retrieve average sales of each product in a month.
Month and year will be input parameter to function.*/
DROP PROCEDURE IF EXISTS monthly_sales;

DELIMITER $$

CREATE PROCEDURE monthly_sales(IN year INT,IN month INT)
	BEGIN
	SELECT p.name,SUM(od.product_quantity)
	FROM product p
	INNER JOIN order_details od ON p.id=od.product_id
	INNER JOIN order_placed op ON od.order_id=op.id
	WHERE YEAR(op.order_date)=year AND MONTH(op.order_date)=month
	GROUP BY od.product_id;
 END $$
 
 CALL monthly_sales(2018,2);


/*Create a stored procedure to retrieve table having order detail with status for a given period. 
Start date and end date will be input parameter.
Put validation on input dates like start date is less than end date. 
If start date is greater than end date take first date of month as start date.
*/
DROP PROCEDURE IF EXISTS find_order_details;
DELIMITER $
CREATE PROCEDURE find_order_details(IN start_date DATE,IN end_date DATE)
BEGIN
	IF start_date > end_date
	THEN
		SET start_date=end_date-(DAY(end_date)-1);
	END IF;

	SELECT p.name,od.status
	FROM product p
	INNER JOIN order_details od ON p.id=od.product_id
	INNER JOIN order_placed op ON od.order_id=op.id
	WHERE op.order_date BETWEEN start_date AND end_date;

END $

CALL find_order_Details('2018-04-01','2018-06-01');
