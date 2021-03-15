
DROP TABLE IF EXISTS users_information;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS password;
DROP TABLE IF EXISTS information;


CREATE TABLE information(
        information_id serial PRIMARY KEY,
        first_name varchar(35) NOT NULL,
        last_name varchar(35) NOT NULL

);

CREATE TABLE password(
        password_id serial PRIMARY KEY,
        password_hash varchar(255) NOT NULL,
        cipher_number int NOT NULL
);

CREATE TABLE users(
        user_id serial PRIMARY KEY,
        password_id int NOT NULL,
        username varchar(255) UNIQUE NOT NULL,
        
        CONSTRAINT fk_password_id FOREIGN KEY (password_id) REFERENCES password(password_id)
); 

CREATE TABLE users_information(
        user_id int NOT NULL,
        information_id int NOT NULL,
        
        PRIMARY KEY (user_id, information_id),
        
        CONSTRAINT fk_contstraint_users_information_user_id FOREIGN KEY (user_id) REFERENCES users (user_id),
        CONSTRAINT fk_contstraint_users_information_information_id FOREIGN KEY (information_id) REFERENCES information (information_id)
);