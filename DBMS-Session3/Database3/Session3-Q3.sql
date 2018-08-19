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
SELECT p.id ,p.name,COUNT(od.product_id)
FROM Product p
INNER JOIN Order_Details od ON p.id=od.product_id
INNER JOIN Order_Placed op ON od.order_id=op.id
WHERE DATEDIFF(now(),op.order_date)<160
GROUP BY od.product_id
ORDER BY COUNT(od.product_id)
LIMIT 20;

