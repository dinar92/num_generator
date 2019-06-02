DROP DATABASE IF EXISTS numbers;
DROP USER IF EXISTS 'admin'@'%';

CREATE USER 'admin'@'%' IDENTIFIED BY 'admin';
CREATE DATABASE numbers CHARACTER SET utf8;
GRANT ALL PRIVILEGES  ON numbers.* TO 'admin'@'%' IDENTIFIED BY 'admin' WITH GRANT OPTION;