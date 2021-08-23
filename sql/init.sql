CREATE DATABASE IF NOT EXISTS `db`;
CREATE TABLE roles(
                          id int NOT NULL AUTO_INCREMENT,
                          name VARCHAR(255) NOT NULL,
                          PRIMARY KEY (id)
);


INSERT INTO `roles` (`id`, `name`) VALUES ('1', 'ROLE_USER'), (NULL, 'ROLE_MODERATOR\r\n    '), (NULL, 'ROLE_ADMIN');