CREATE TABLE player
(
    id        int primary key not null auto_increment,
    username  varchar(30),
    password  varchar(30),
    email     varchar(50),
    user_rank int,
    user_type int
);

CREATE TABLE location
(
    id         int primary key not null auto_increment,
    address    varchar(255),
    name       varchar(255),
    maxCourts  int,
    freeCourts int
);

CREATE TABLE playevent
(
    id          int primary key not null auto_increment,
    Location_id int(25),
    eventDate   date,
    title       char(25),
    gametype    enum ("SO", "SC", "DO", "DC"),
    review_id   int (25),
    organiser   char(25),
    users       char(25),
    freeSlots   int
);

CREATE TABLE review
(
    id          int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    timestamp   datetime,
    description text
);
