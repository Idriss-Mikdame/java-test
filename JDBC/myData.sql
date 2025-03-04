DROP DATABASE IF EXISTS jdbc_course_data;
CREATE  DATABASE jdbc_course_data;
USE jdbc_course_data;
CREATE TABLE employee(
    id INT(15) PRIMARY KEY AUTO_INCREMENT,
    name varchar(15),
    city varchar(15),
    jbob varchar(20),
    salary real
)