CREATE DATABASE movies;

CREATE TABLE `movies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `year` varchar(100) DEFAULT NULL,
  `rating` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

INSERT INTO movies.movies (title,`year`,rating) VALUES 
('Matrix','1998','9')
,('Speed','1990','8.2')
,('Terminator','1986','9.1')
;