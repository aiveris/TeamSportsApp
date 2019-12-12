
CREATE TABLE location
(
    location_id   int primary key not null auto_increment,
    address       varchar(255),
    name          varchar(255),
    max_Courts    int,
    free_Courts   int,
	unique (location_id)
);

CREATE TABLE playevent
(
    playevent_id    int primary key not null auto_increment,
	location_id     int NOT NULL,
    eventDate       varchar(25),
    eventTime       varchar(25),
    title           varchar(25),
    gameType        int,
    freeSlots       int,
    unique (playevent_id),
    KEY FK_playevent_location (location_id),
  CONSTRAINT FK_playevent_location FOREIGN KEY (location_id) REFERENCES location (location_id)
);

CREATE TABLE player
(
    player_id       int primary key not null auto_increment,
    username        varchar(30),
    password        varchar(30),
    email           varchar(50),
    user_rank       int,
    user_type       int,
    unique (player_id)
);

CREATE TABLE review
(
    review_id   int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    timestamp   datetime,
    description text,
	unique (review_id)
);