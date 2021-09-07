CREATE TABLE courses(
    id SERIAL NOT NULL,
    name VARCHAR(50) NOT NULL,
    category VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO courses(id, name, category) VALUES (1, 'Kotlin', 'Programacao')
