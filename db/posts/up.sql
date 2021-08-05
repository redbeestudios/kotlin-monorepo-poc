CREATE DATABASE posts;

CREATE TABLE posts.posts (
     id int auto_increment primary key,
     content varchar(3000),
     author int
);