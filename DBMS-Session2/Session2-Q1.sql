
SHOW DATABASES;
CREATE DATABASE Store_front;

USE store_front;

#user table
CREATE TABLE User(
id INT PRIMARY KEY AUTO_INCREMENT,
email varchar(50) UNIQUE NOT NULL,
name varchar(50) NOT NULL,
password varchar(30) NOT NULL,
usertype enum('admin','user') NOT NULL,
contact_no varchar(12) NOT NULL,
date DATE NOT NULL);

#product table
CREATE TABLE Product(
id INT PRIMARY KEY AUTO_INCREMENT,
name varchar(30) NOT NULL,
price float NOT NULL,
quantity INT NOT NULL,
date DATE NOT NULL,
description varchar(300) NOT NULL);

#product image table
CREATE TABLE Product_Image(
id INT PRIMARY KEY AUTO_INCREMENT,
name varchar(30),
image_url varchar(100) NOT NULL,
product_id INT,
FOREIGN KEY(product_id) REFERENCES Product(id));

# product category table
CREATE TABLE Category(
id INT PRIMARY KEY AUTO_INCREMENT,
name varchar(30),
parent_id INT,
FOREIGN KEY(parent_id) REFERENCES Category(id));

#address of user table
CREATE TABLE Address(
id INT PRIMARY KEY AUTO_INCREMENT,
plot_no varchar(10),
street varchar(20) NOT NULL,
city varchar(20) NOT NULL,
state varchar(20) NOT NULL,
pin_code varchar(10) NOT NULL,
user_id INT,
contact_no varchar(12) NOT NULL,
FOREIGN KEY(user_id) REFERENCES User(id));

#Product category relationship tabl
CREATE TABLE Product_Category_Relation(
category_id INT,
product_id INT,
FOREIGN KEY(category_id) REFERENCES Category(id) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY(product_id) REFERENCES Product(id) ON UPDATE CASCADE ON DELETE CASCADE
);

#order placed table
CREATE TABLE Order_Placed(
id INT PRIMARY KEY AUTO_INCREMENT,
quantity INT NOT NULL,
total_amount float NOT NULL,
order_date DATE NOT NULL,
address_id INT,
FOREIGN KEY(address_id) REFERENCES Address(id)
);

#order details table
CREATE TABLE Order_Details(
id INT PRIMARY KEY AUTO_INCREMENT,
order_id INT,
product_id INT,
price float,
status enum('shipped','returned','cancelled','placed','delievered') NOT NULL,
shipped_date DATE,
deliever_date DATE,
FOREIGN KEY(order_id) REFERENCES Order_Placed(id),
FOREIGN KEY(product_id) REFERENCES Product(id)
);


#show all tables of database
SHOW TABLES;


#drop product table
DROP TABLE Product_Image;
DROP TABLE Order_Details;
DROP TABLE Product_Category_Relation;
DROP TABLE Product;

#product table
CREATE TABLE Product(
id INT PRIMARY KEY AUTO_INCREMENT,
name varchar(30) NOT NULL,
price float NOT NULL,
quantity INT NOT NULL,
date DATE NOT NULL,
description varchar(300) NOT NULL);

#product image
CREATE TABLE Product_Image(
id INT PRIMARY KEY AUTO_INCREMENT,
name varchar(30),
image_url varchar(100) NOT NULL,
product_id INT,
FOREIGN KEY(product_id) REFERENCES Product(id)
);

#order details table
CREATE TABLE Order_Details(
id INT PRIMARY KEY AUTO_INCREMENT,
order_id INT,
product_id INT,
price float,
status enum('shipped','returned','cancelled','placed','delievered') NOT NULL,
shipped_date DATE,
deliever_date DATE,
FOREIGN KEY(order_id) REFERENCES Order_Placed(id),
FOREIGN KEY(product_id) REFERENCES Product(id)
);

#Product category relationship
CREATE TABLE Product_Category_Relation(
category_id INT,
product_id INT,
FOREIGN KEY(category_id) REFERENCES Category(id) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY(product_id) REFERENCES Product(id) ON UPDATE CASCADE ON DELETE CASCADE
);