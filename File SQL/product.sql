create database product_management;
use product_management;

create table product(
id int primary key,
`name` varchar(45),
price double,
`description` varchar(45),
productor varchar(45)
);