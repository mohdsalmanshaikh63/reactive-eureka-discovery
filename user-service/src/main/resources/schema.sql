CREATE DATABASE users;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `user_movies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `movie_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_movies_FK` (`user_id`),
  CONSTRAINT `user_movies_FK` FOREIGN KEY (`user_id`) REFERENCES `user_movies` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

INSERT INTO users.users (name,country) VALUES 
('Salman Shaikh','India')
,('Fernando Rodriguez','France')
;
INSERT INTO users.user_movies (user_id,movie_id) VALUES 
(1,1)
,(1,2)
,(2,2)
,(2,3)
;