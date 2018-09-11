SHOW DATABASES;

USE store_front;

#Display Recent 50 Orders placed (Id, Order Date, Order Total).*/
SELECT op.id,op.order_date,op.total_amount
FROM Order_Placed op
ORDER BY op.order_date DESC
LIMIT 50;

#Display 10 most expensive Orders.
SELECT op.id,op.total_amount
FROM Order_Placed op
ORDER BY op.total_amount DESC
LIMIT 10;


/*Display all the Orders which are placed more than 10 days old and one or 
more items from those orders are still not shipped.
*/
SELECT Order_Placed.id,Order_Placed.total_amount
FROM Order_Placed 
WHERE Order_Placed.order_date>=(CURDATE()-INTERVAL 10 DAY)
AND Order_Placed.id IN
	(SELECT Order_Details.order_id
	FROM Order_Details
	WHERE Order_Details.status='placed');

#Display list of shoppers which haven't ordered anything since last month.
SELECT User.id,User.name
FROM User
WHERE User.usertype='user' AND User.id  NOT IN
	(SELECT Address.user_id
	FROM Address,Order_Placed
	WHERE Order_Placed.order_date>=(CURDATE()-INTERVAL 1 MONTH)
	AND Address.id=Order_Placed.address_id 
	);

#Display list of shopper along with orders placed by them in last 15 days.
SELECT User.id,User.name,Order_Placed.id,Order_Placed.order_date
FROM User,Order_Placed
WHERE User.usertype='user' AND User.id IN
	(SELECT Address.user_id
	FROM Address
	WHERE Order_Placed.order_date>=(CURDATE()-INTERVAL 15 DAY)
	AND Order_Placed.address_id=Address.id);


#Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))
SELECT Product.id,Product.name
FROM Product INNER JOIN
Order_Details
ON Order_Details.product_id=Product.id
WHERE Order_Details.order_id=1 AND Order_Details.status='shipped';

#Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price.
SELECT Order_Placed.id AS Order_id,Order_Placed.order_date,Order_Details.product_id,Order_Details.price,Product.name
FROM Order_Placed,Order_Details,Product
WHERE Order_Placed.id=Order_Details.order_id 
AND Order_Details.product_id=Product.id
AND Product.price BETWEEN 20 AND 50;

#Update first 20 Order items status to “Shipped” which are placed today.

UPDATE Order_Details
SET status='shipped'
WHERE Order_Details.order_id IN
	(SELECT id 
	FROM Order_Placed
	WHERE Order_Placed.order_date=now())
LIMIT 20;