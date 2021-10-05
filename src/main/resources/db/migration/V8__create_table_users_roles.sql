CREATE TABLE users_roles(
    id SERIAL NOT NULL,
    user_id SERIAL NOT NULL,
    role_id SERIAL NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

INSERT INTO users_roles (id, user_id, role_id) VALUES (1, 1 , 1);