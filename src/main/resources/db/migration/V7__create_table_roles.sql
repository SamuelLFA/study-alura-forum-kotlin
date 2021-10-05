CREATE TABLE roles(
    id SERIAL NOT NULL,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO roles (id, name) VALUES (1, 'READ_WRITE');