CREATE TABLE topics(
    id SERIAL NOT NULL,
    title VARCHAR(50) NOT NULL ,
    message VARCHAR(300) NOT NULL ,
    created_at TIMESTAMP NOT NULL ,
    status VARCHAR(20) NOT NULL ,
    course_id SERIAL NOT NULL,
    author_id SERIAL NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (course_id) REFERENCES courses(id),
    FOREIGN KEY (author_id) REFERENCES users(id)
);

