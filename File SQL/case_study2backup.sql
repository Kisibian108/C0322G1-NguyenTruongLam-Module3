create database case_study2;

use case_study2;

create table `position`(
id int,
position_name varchar(45)
);

create table education_degree(
id int,
education_degree_name varchar(45)
);

create table division(
id int,
division_name varchar(45)
);

create table employee (
id int,
`name` varchar(45),
birthday date,
id_card varchar(45),
salary double,
phone varchar(45),
email varchar(45),
address varchar(45),
position_id int,
education_degree_id int,
division_id int,
username varchar(255),
foreign key (position_id) references `position`(position_id),
foreign key (education_degree_id) references education_degree(education_degree_id),
foreign key (division_id) references division(division_id),
foreign key (username) references `user`(username)
);

create table customer(
id int,
customer_type_id int,
name varchar(45),
date_of_birth date,
gender bit(1),
id_card varchar(45),
phone_number varchar(45),
email varchar(45),
address varchar(45),
foreign key (customer_type_id) references customer_type(id)
);

create table customer_type (
id int,
`name` varchar(45)
);

create table `role`(
role_id int,
role_name varchar(255)
);

create table `user`(
username varchar(255),
`password` varchar(255)
);

create table user_role(
role_id int,
username varchar(255),
foreign key (role_id) references `role`(role_id),
foreign key (username) references `user`(username)
);

create table contract(
id int,
start_date datetime,
end_date datetime,
deposit double,
employee_id int,
customer_id int,
facility_id int,
foreign key (employee_id) references employee(id),
foreign key (customer_id) references customer(customer_id),
foreign key (facility_id) references facility(id)
);

create table facility (
id int,
`name` varchar(45),
area int,
cost double,
max_people int,
rent_type_id int,
facility_type_id int,
standard_room varchar(45),
description_other_convenience varchar(45),
pool_area double,
number_of_floors int,
facility_free text,
foreign key (rent_type_id) references rent_type(id),
foreign key (facility_type_id) references facility(id)

);

create table facility_type(
id int,
`name` varchar(45)
);

create table rent_type(
id int,
`name` varchar(45)
);

create table contract_detail(
id int,
contract_id int,
attach_facility_id int,
quantity int,
foreign key(contract_id) references contract(id),
foreign key(attach_service_id) references attach_facility(id)
);

create table attach_facility(
id int,
`name` varchar(45),
cost double,
unit int,
`status` varchar(45)
);






