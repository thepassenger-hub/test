
DROP TABLE IF EXISTS stuff;


CREATE TABLE stuff(
    id BIGINT NOT NULL PRIMARY KEY auto_increment,
    address VARCHAR(255) NOT NULL,
    items INTEGER NOT NULL
);

