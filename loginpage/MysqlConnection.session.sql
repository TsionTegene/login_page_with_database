CREATE DATABASE userinfo;

USE userinfo;

CREATE TABLE user_account (
    account_id int NOT NULL PRIMARY KEY,
    lastname varchar(50) NOT NULL,
    firstname varchar(50) NOT NULL,
    username varchar(50) NOT NULL,
    `password` varchar(15) NOT NULL,
    email varchar(15) NOT NULL,
);