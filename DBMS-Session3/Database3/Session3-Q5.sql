USE store_front;

/*Create a view displaying the order information 
(Id, Title, Price, Shopper’s name, Email, Orderdate, Status) 
with latest ordered items should be displayed first for last 60 days.*/
CREATE VIEW Order_Information AS
SELECT u.id AS User_id ,u.name AS User_name,u.email AS email,od.product_id AS Product_id ,
p.name as product_name ,od.price,op.order_date,od.status
FROM User u
INNER JOIN Order_Placed op ON u.id=op.user_id
INNER JOIN Order_Details od ON op.id=od.order_id
INNER JOIN Product p ON p.id=od.product_id
WHERE DATEDIFF(CURDATE(),op.order_date)<160;

/*Use the above view to display the Products(Items) which are in ‘shipped’ state.*/
SELECT product_name
FROM order_information
WHERE status='shipped';

/*Use the above view to display the top 5 most selling products.*/

SELECT product_name
FROM Order_Information
ORDER BY order_date DESC;