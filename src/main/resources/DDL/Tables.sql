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
	freeCourts int,
);

CREATE TABLE PLAYEVENT
(
	id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Location_id int (25),
    eventDate date,
    title CHAR (25),
    gametype enum("SO", "SC", "DO", "DC"),
    review CHAR (25),
    organiser CHAR (25),
    users CHAR (25),
    freeSlots INT
);

CREATE TABLE REVIEW
(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    timestamp DATETIME,
    description TEXT
);
