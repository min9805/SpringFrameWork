-- schema.sql

CREATE TABLE IF NOT EXISTS user (
      id BIGINT AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(255),
      email VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS product (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     user_id BIGINT,
     FOREIGN KEY (user_id) REFERENCES user(id),
     name VARCHAR(255),
     description VARCHAR(255),
     price INT
);
