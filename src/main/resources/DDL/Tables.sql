DROP TABLE IF EXISTS player;
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

DROP TABLE IF EXISTS location;
CREATE TABLE location
(
    location_id   int primary key not null auto_increment,
    address       varchar(255),
    name          varchar(255),
    max_Courts    int,
    free_Courts   int,
    unique (location_id)
);
DROP TABLE IF EXISTS playevent;
CREATE TABLE playevent
(
    playevent_id    int primary key not null auto_increment,
	location_id     int NOT NULL,
    eventDate       date,
    eventTime       time,
    title           varchar(25),
    gameType        int,
    freeSlots       int,
    unique (playevent_id),
    KEY FK_playevent_location (location_id),
  CONSTRAINT FK_playevent_location FOREIGN KEY (location_id) REFERENCES location (location_id),
	KEY FK_player_playevent (player_id),
  CONSTRAINT FK_player_playevent FOREIGN KEY (player_id) REFERENCES player (player_id)
);

DROP TABLE IF EXISTS review;
CREATE TABLE review
(
    review_id   int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    player_id int not null,
    timestamp   datetime,
    description text,
    unique (review_id),
    KEY FK_player_review (player_id),
  CONSTRAINT FK_player_review FOREIGN KEY (player_id) REFERENCES player (player_id)
);

DROP TABLE IF EXISTS player_playevent;
CREATE TABLE player_playevent
(
	player_id 		int not null,
    playevent_id 	int not null,
	primary key(player_id, playevent_id),
    constraint fk_player_id foreign key (player_id) references player (player_id),
    constraint fk_playevent_id foreign key (playevent_id) references playevent (playevent_id)
);

DROP TABLE IF EXISTS playevent_review;
CREATE TABLE playevent_review
(
	playevent_id	int not null,
    review_id		int not null,
    primary key (playevent_id, review_id),
    key fk_playevent (playevent_id),
    key fk_review	(review_id),
    constraint fk_playevent foreign key (playevent_id) references playevent (playevent_id),
    constraint fk_review foreign key (review_id) references review (review_id)

);