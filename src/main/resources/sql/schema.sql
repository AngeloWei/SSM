
CREATE  DATABASE  ssm;
use ssm;
-- user table
CREATE  TABLE  user_z(
  user_id INT AUTO_INCREMENT ,
  user_name varchar(20) NOT NULL ,
  user_phone VARCHAR(20) NOT NULL ,
  score int NOT NULL  DEFAULT 0,
  create_time TIMESTAMP DEFAULT current_timestamp,
  PRIMARY KEY (user_id),
  KEY idx_user_phone(user_phone)
)AUTO_INCREMENT=1000;
-- goods table
CREATE  table goods_z(
  good_id int AUTO_INCREMENT,
  price FLOAT NOT NULL ,
  number int NOT NULL ,
  state int NOT NULL ,
  title VARCHAR(120),
  create_time TIMESTAMP DEFAULT current_timestamp,
  update_time TIMESTAMP DEFAULT current_timestamp,
  PRIMARY KEY (good_id)
)AUTO_INCREMENT=1000;
-- order table
create TABLE  order_z(
  order_id int AUTO_INCREMENT,
  user_id INT NOT NULL ,
  good_id int NOT NULL ,
  title VARCHAR(120) NOT NULL ,
  create_time TIMESTAMP NOT NULL  DEFAULT current_timestamp,
  PRIMARY KEY (order_id),
  KEY idx_user_id(user_id),
  KEY idx_goods_id(good_id)
)AUTO_INCREMENT=1000 DEFAULT CHARSET =UTF8;



