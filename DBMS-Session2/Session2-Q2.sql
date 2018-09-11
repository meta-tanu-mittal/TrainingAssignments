USE store_front;

#insert values in table
INSERT INTO Category(name,parent_id)
VALUES
('electronic appliances',null),#1
('home and furniture',null),
('tv and appliances',null),
('fashion',null),#4
('mobile',1),
('mobile accessories',1),
('laptop',1),
('home decor',2);#8


INSERT INTO Product(name ,price ,quantity ,date ,description)
VALUES
('headphone',300,4,'2017-08-07','samsung headphone'),
('mobile',8000,2,'2018-06-07','redmi note5'),
('laptop',3000,4,'2017-05-07','dell laptop 8gb ram'),
('bedsheet',1000,6,'2017-09-01','cotton bedsheet');

INSERT INTO Product(name ,price ,quantity ,date ,description)
VALUES
('power bank',600,4,'2017-08-07','power bank for mobile'),
('honors',9000,2,'2018-07-17','honor mobile'),
('paintings',5000,4,'2017-05-07','traditional paininting'),
('clock',2000,6,'2017-09-01','wall clock'),
('tv',1000,5,'2018-02-23','panasonic tv');

INSERT INTO Product_Category_Relation(product_id,category_id)
VALUES
(1,6),
(2,5),
(3,7),
(4,8),
(5,6),
(6,5),
(7,8),
(8,8),
(9,1),
(9,3);

INSERT INTO PRODUCT_IMAGE(name,image_url,product_id)
VALUES
('headphone','https://www.amazon.in/Life-Like-Bluetooth-Wireless-Headphones/dp/B01N0UW67E?tag=googinhydr18418-21',1),
('tv front','https://www.amazon.in/Life-Like-Bluetooth-Wireless-Headphones/dp/B01N0UW67E?tag=googinhydr18418-21',9),
('tv back','https://www.amazon.in/Life-Like-Bluetooth-Wireless-Headphones/dp/B01N0UW67E?tag=googinhydr18418-21',9);

INSERT INTO User(email,name,password,usertype,contact_no,date)
VALUES
('tanu.mittal@metacube.com','tanu mittal','tanu','admin','8560863402','2017-02-09'),
('richa.jain@metacube.com','richa jain','richa123','user','8107941572','2018-06-02'),
('namrata.agarwal@metacube.com','namrata','namrata123','user','8239370519','2018-02-07'),
('twinkle.garg@metacube.com','twinkle','twinkle123','user','7791979665','2018-02-07');

INSERT INTO Address(plot_no,street,city,state,pin_code,user_id,contact_no)
VALUES
('51','pratap nagar','jaipur','rajasthan','302025',1,'9511593554'),
('22','railway colony','jaipur','rajasthan','302017',2,'98765434'),
('10','bapu nagar','jaipur','rajasthan','302015',3,'9511593554'),
('','metacube','jaipur','rajasthan','302025',2,'9876543210'),
('','metacube','jaipur','rajasthan','302025',4,'9876543210');

INSERT INTO Order_placed(quantity,total_amount,order_date,address_id)
VALUES 
(2,3300,'2018-06-08', 1),
(1,9000,'2018-05-04',2), 
(1,2000,'2018-04-20',4);  
        
INSERT INTO Order_Details(order_id,product_id,price,status,shipped_date,deliever_date)
VALUES
(1,1,300,'placed','2018-06-08','2018-06-10'),
(1,3,3000,'shipped',2018-06-09,'2018-06-11'),
(2,6,9000,'delievered','2018-05-05','2018-05-10'),order_detailsorder_detailsorder_placed
(3,8,2000,'returned','2018-04-22','2018-04-24');

/*Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top
*/
SELECT p.id as product_id,p.name as product_name,p.price,r.category_id,c.name as category_name
FROM Product p
INNER JOIN Product_Category_Relation r
ON p.id=r.product_id AND p.quantity>0
INNER JOIN Category c
ON r.category_id=c.id
ORDER BY p.date DESC
LIMIT 3;

/*Display the list of products which don't have any images.*/
SELECT DISTINCT Product.name
FROM Product
WHERE NOT EXISTS (SELECT * FROM Product_image
		  WHERE
		  Product.id = Product_image.product_id);

/*Display all Id, Title and Parent Category Title for all the Categories listed, 
sorted by Parent Category Title and then Category Title. 
(If Category is top category then Parent Category Title column should display “Top Category” as value.)
*/
SELECT child.id, child.name, IFNULL(parent.name, 'Top Category') AS parent_category 
FROM Category Child
LEFT JOIN Category parent
ON Child.parent_id=parent.id
ORDER BY parent.name,child.name;

/*Display Id, Title, Parent Category Title of all the leaf Categories 
(categories which are not parent of any other category)
*/
SELECT child.id, child.name, IFNULL(parent.name, 'Top Category') AS parent_category
FROM category child
INNER JOIN category parent
ON child.parent_id = parent.id
WHERE child.id NOT IN (SELECT distinct parent_id FROM Category where parent_id IS NOT NULL);

/*Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)
*/
SELECT p.id,p.name,p.price,p.description
FROM Product p,Category c,Product_Category_Relation pcr
WHERE c.name='mobile' AND c.id=pcr.category_id  AND pcr.product_id=p.id;

/*Display the list of Products whose Quantity on hand (Inventory) is under 50.
*/
SELECT Product.name,Product.quantity
FROM Product
WHERE Product.quantity<50;

/*Increase the Inventory of all the products by 100.*/
UPDATE Product
SET quantity=quantitproducty+100;

