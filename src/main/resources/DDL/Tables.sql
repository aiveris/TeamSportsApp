CREATE TABLE player
(
	id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username varchar(255),
    password varchar(255),
    email varchar(255),
	userrank int,
    usertype enum("ADMIN", "USER")
);

CREATE TABLE LOCATION
(
	id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    address varchar(255),
    name varchar(255),
	maxCourts int,
);