USE store_front;

ALTER TABLE Order_Placed
ADD COLUMN user_id INT;

ALTER TABLE Order_Placed
ADD FOREIGN KEY(user_id) REFERENCES User(id);

