CREATE TABLE player (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(255) UNIQUE,
                        lifePoints INT
);

CREATE TABLE bag (
                     id SERIAL PRIMARY KEY,
                     BAG_SPACE INT,
                     id_player INT,
                     FOREIGN KEY (id_player) references player(id)
);

;CREATE TABLE item (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       description TEXT,
                       requiredSpace INT,
                       bag_id INT,
                       FOREIGN KEY (bag_id) references bag(id)
);

CREATE TABLE room (
                     id SERIAL PRIMARY KEY,
                     name VARCHAR(255) NOT NULL,
                     item_id INT,
                     FOREIGN KEY (item_id) references item(id)
);

CREATE TABLE animal (
                      id SERIAL PRIMARY KEY,
                      nickname VARCHAR(255) NOT NULL,
                      species VARCHAR(255) NOT NULL,
                      favourite_food VARCHAR(255) NOT NULL,
                      age INT,
                      entry_date DATE,
                      weight FLOAT,
                      height FLOAT,
                      wingspan FLOAT,
                      tail_lenght FLOAT,
                      room_id INT,
                      FOREIGN KEY (room_id) references room(id)
);

CREATE TABLE direction (
                           direction_id SERIAL PRIMARY KEY,
                           direction VARCHAR(255),
                           from_room_id INT,
                           to_room_id INT,
                           FOREIGN KEY (from_room_id) REFERENCES room(id),
                           FOREIGN KEY (to_room_id) REFERENCES room(id)
);