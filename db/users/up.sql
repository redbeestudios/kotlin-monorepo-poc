CREATE DATABASE users;

CREATE TABLE users.users (
    id int auto_increment primary key,
    name varchar(200),
    lastName varchar(200),
    email varchar(300),
    password varchar(100)
);