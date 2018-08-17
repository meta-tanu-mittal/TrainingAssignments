SHOW DATABASES;

USE store_front;

#Display Recent 50 Orders placed (Id, Order Date, Order Total).*/
SELECT op.id,op.order_date,op.total_amount
FROM Order_Placed op
ORDER BY op.order_date DESC
LIMIT 2;

#Display 10 most expensive Orders.
SELECT op.id,op.total_amount
FROM Order_Placed op
ORDER BY op.total_amount DESC
LIMIT 2;



