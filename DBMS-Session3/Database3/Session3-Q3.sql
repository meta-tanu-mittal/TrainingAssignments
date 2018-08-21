USE store_front;

#Session3 Q3
/*Display Shopper’s information along with number of orders he/she placed during last 30 days.*/
SELECT u.id,u.email,u.name,u.contact_no,count(o.user_id)
FROM User u
INNER JOIN Order_Placed o
ON u.id=o.user_id
WHERE DATEDIFF(now(),o.order_date)<30
GROUP BY o.user_id;

/*Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.*/
SELECT u.id,u.name,SUM(op.total_amount)
FROM User u
INNER JOIN Order_Placed op ON u.id=op.user_id
WHERE DATEDIFF(now(),op.order_date)<30
GROUP BY op.user_id
ORDER BY SUM(op.total_amount) DESC
LIMIT 10;

/*Display top 20 Products which are ordered most in last 60 days along with numbers.*/
SELECT p.id ,p.name,SUM(od.product_quantity)
FROM Product p
INNER JOIN Order_Details od ON p.id=od.product_id
INNER JOIN Order_Placed op ON od.order_id=op.id
WHERE DATEDIFF(now(),op.order_date)<60
GROUP BY od.product_id
ORDER BY SUM(od.product_quantity) DESC
LIMIT 20;


/*Display Monthly sales revenue of the StoreFront for last 6 months. 
It should display each month’s sale.*/
SELECT MONTH(order_date) AS month,SUM(total_amount)
FROM Order_Placed 
WHERE order_date >(CURDATE()-INTERVAL 6 MONTH)
GROUP BY MONTH(order_date);

/*Mark the products as Inactive which are not ordered in last 90 days.*/
ALTER TABLE Product
ADD COLUMN product_state varchar(10) default 'active';

UPDATE Product p
SET p.product_state='inactive'
WHERE p.id NOT IN
	(SELECT DISTINCT od.product_id
	FROM Order_Details od
	INNER JOIN Order_Placed op  ON od.order_id=op.id
	WHERE DATEDIFF(CURDATE(),op.order_date)<90);


/*Given a category search keyword, display all the Products present in this category/categories. */
SELECT p.id,p.name
FROM Category c
INNER JOIN Product_Category_Relation pcr ON c.id=pcr.category_id
INNER JOIN Product p ON pcr.product_id=p.id
WHERE c.name='mobile';

/*Display top 10 Items which were cancelled most.*/
SELECT p.id,p.name,count(*)
FROM Product p
INNER JOIN Order_Details od ON p.id=od.product_id
WHERE od.status='cancelled'
GROUP BY od.product_id DESC
ORDER BY COUNT(*)
LIMIT 10;

