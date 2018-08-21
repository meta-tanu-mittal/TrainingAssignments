#DBMS Session4 Q3

use store_front;

ALTER TABLE product ADD INDEX product_index(id);

ALTER TABLE order_placed ADD INDEX user_index(id);

ALTER TABLE category ADD INDEX category_index(id);

