create database test1;

use test1;

create table student(
id int primary key auto_increment,
student_name varchar(45)
);

insert into student 
values(1,'Chien'),(2,'Lam'),(3,'Cuong');

SELECT * FROM student 
HAVING (REVERSE(SUBSTRING(REVERSE(student_name), 1, INSTR(REVERSE(student_name,' ')) LIKE ‘C%’;