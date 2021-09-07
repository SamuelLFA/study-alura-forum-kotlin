CREATE TABLE answers(
    id SERIAL NOT NULL,
    message VARCHAR(300) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    topic_id SERIAL NOT NULL,
    author_id SERIAL NOT NULL,
    solution BOOLEAN NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (topic_id) REFERENCES topics(id),
    FOREIGN KEY (author_id) REFERENCES users(id)
);

