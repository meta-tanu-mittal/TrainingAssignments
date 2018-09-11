USE store_front;

ALTER TABLE Order_Placed
ADD COLUMN user_id INT;

ALTER TABLE Order_Placed
ADD FOREIGN KEY(user_id) REFERENCES User(id);

ALTER TABLE order_details
ADD COLUMN product_quantity INT NOT NULL;


ALTER TABLE product_category_relation
ADD PRIMARY KEY(product_id,category_id);
