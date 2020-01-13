

INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('1', 'Sandwich', '99', 'Yes', '2019-03-15', 'Main Course', 'Yes');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('2', 'Burger', '129', 'Yes', '2020-07-15', 'Main Course', 'Yes');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('3', 'Pizza', '149', 'Yes', '2020-03-21', 'Main Course', 'No');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('4', 'French Fries', '57', 'No', '2019-09-17', 'Starters', 'No');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('5', 'Chocolate Brownies', '32', 'Yes', '2020-09-20', 'Dessert', 'Yes');

INSERT INTO `truyum`.`user` (`us_id`, `us_name`) VALUES ('1', 'Vijay');
INSERT INTO `truyum`.`user` (`us_name`) VALUES ('Ajith');
INSERT INTO truyum.user(us_name) values ('Surya'); 


select*from truyum.menu_item;


SELECT me_id,me_name,me_free_delivery,me_price,me_category FROM truyum.menu_item  where me_date_of_launch > curdate() and  me_active = 'yes'; 
 
 
 UPDATE `truyum`.`menu_item` SET `me_name` = 'Briyan1', `me_price` = '200' WHERE (`me_id` = '5');
 

 INSERT INTO `truyum`.`cart` (`ct_id`, `ct_us_id`, `ct_me_id`) VALUES ('101', '1', '1');
INSERT INTO `truyum`.`cart` (`ct_us_id`, `ct_me_id`) VALUES ('1', '3');
INSERT INTO `truyum`.`cart` (`ct_us_id`, `ct_me_id`) VALUES ('1', '5');

select me_id,me_name,me_free_delivery,me_price from truyum.menu_item inner join truyum.cart on ct_me_id=me_id where ct_us_id=1;

select sum(me_price) as Total from truyum.menu_item inner join truyum.cart on ct_me_id= me_id;

delete from truyum.cart where ct_us_id='1' and  ct_me_id='3' limit 1;


 
 
