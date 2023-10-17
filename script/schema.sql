CREATE TABLE item (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      description TEXT,
                      requiredSpace INT
);

CREATE TABLE bag (
                     id SERIAL PRIMARY KEY,
                     availableSpace INT
);

CREATE TABLE player (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(255),
                        lifePoints INT,
                        bag_id BIGINT REFERENCES bag(id)
);
