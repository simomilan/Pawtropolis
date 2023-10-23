CREATE TABLE player (
                        id BIGSERIAL PRIMARY KEY,
                        name VARCHAR(255) UNIQUE,
                        lifePoints INT
);

CREATE TABLE bag (
                     id BIGSERIAL PRIMARY KEY,
                     BAG_SPACE INT DEFAULT 4,
                     id_player INT,
                     FOREIGN KEY (id_player) references player(id)
);

CREATE TABLE room (
                      id BIGSERIAL PRIMARY KEY,
                      name VARCHAR(255) NOT NULL
);

CREATE TABLE item (
                      id BIGSERIAL PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      description TEXT,
                      requiredSpace INT,
                      bag_id INT,
                      room_id INT,
                      FOREIGN KEY (bag_id) references bag(id),
                      FOREIGN KEY (room_id) references room(id)
);

CREATE TABLE species_type (
                          species_type_id BIGSERIAL PRIMARY KEY,
                          species VARCHAR(255)

);
CREATE TABLE animal (
                        id BIGSERIAL PRIMARY KEY,
                        nickname VARCHAR(255) NOT NULL,
                        species_type_id INT,
                        favourite_food VARCHAR(255) NOT NULL,
                        age INT,
                        entry_date DATE,
                        weight FLOAT,
                        height FLOAT,
                        wingspan FLOAT,
                        tail_length FLOAT,
                        room_id INT,
                        FOREIGN KEY (room_id) references room(id),
                        FOREIGN KEY (species_type_id) references species_type(species_type_id)
);

CREATE TABLE direction (
                           direction_id BIGSERIAL PRIMARY KEY,
                           direction VARCHAR(255),
                           from_room_id INT,
                           to_room_id INT,
                           FOREIGN KEY (from_room_id) REFERENCES room(id),
                           FOREIGN KEY (to_room_id) REFERENCES room(id)
);
