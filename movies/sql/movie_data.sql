SELECT * FROM movie.movie_list;
INSERT INTO `movie`.`movie_list` (`mov_id`, `mov_title`, `mov_gross`, `mov_active`, `mov_date_of_launch`, `mov_genre`, `mov_teaser`) VALUES ('1', 'Avatar', '2787965087', 'Yes', '2020-10-10', 'Science Fiction', 'Yes');
INSERT INTO `movie`.`movie_list` (`mov_id`, `mov_title`, `mov_gross`, `mov_active`, `mov_date_of_launch`, `mov_genre`, `mov_teaser`) VALUES ('2', 'The Avengers', '1518812988', 'Yes', '2019-09-09', 'Suoerhero', 'No');
INSERT INTO `movie`.`movie_list` (`mov_id`, `mov_title`, `mov_gross`, `mov_active`, `mov_date_of_launch`, `mov_genre`, `mov_teaser`) VALUES ('3', 'Titanic', '2187483115', 'Yes', '2020-10-03', 'Romance', 'No');
INSERT INTO movie.movie_list (mov_title, mov_gross, mov_active , mov_date_of_launch, mov_genre, mov_teaser) VALUES ('Jurassic World', '1689750459', 'No', '2020-09-20', 'Science Fiction', 'Yes');
INSERT INTO movie.movie_list (mov_title, mov_gross, mov_active , mov_date_of_launch, mov_genre, mov_teaser) VALUES ('Avengers- End Game', '2789563489', 'Yes' ,'2019-05-30', 'Superhero' , 'Yes'); 

SELECT * FROM movie.movie_list;

use movie;
SELECT mov_id, mov_title, mov_gross, mov_genre, mov_teaser FROM movie_list where mov_date_of_launch > curdate() AND mov_active='Yes';

UPDATE `movie`.`movie_list` SET `mov_title` = 'Frozen', `mov_gross` = '1689750788', `mov_date_of_launch` = '2020-10-30', `mov_genre` = 'Animation' WHERE (`mov_id` = '4');

INSERT INTO `movie`.`user` (`us_id`, `us_name`) VALUES ('1', 'Shanu');
INSERT INTO `movie`.`user` (`us_id`, `us_name`) VALUES ('2', 'Suba');

INSERT INTO `movie`.`favorites` (`fav_id`, `fav_us_id`, `fav_mov_id`) VALUES ('101', '1', '1');
INSERT INTO `movie`.`favorites` (`fav_id`, `fav_us_id`, `fav_mov_id`) VALUES ('102', '1', '3');
INSERT INTO `movie`.`favorites` (`fav_id`, `fav_us_id`, `fav_mov_id`) VALUES ('103', '1', '4');

SELECT * FROM movie.favorites;

use movie;
select mov_id,mov_title, mov_gross, mov_genre from movie_list inner join favorites on fav_mov_id=mov_id where fav_us_id=1;



select count(fav_id) as no_of_favorites from movie.movie_list inner join movie.favorites where fav_mov_id=mov_id and fav_us_id=1;

DELETE FROM `movie`.`favorites` WHERE (`fav_id` = '103') ;
