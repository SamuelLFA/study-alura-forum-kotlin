CREATE TABLE users(
    id SERIAL NOT NULL,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO users(id, name, email) VALUES (1, 'Samuel', 'samuellfa3@gmail.com')
