create database phong_tro;

use phong_tro;


create table payment(
id int primary key,
`name` varchar(45)
);

create table danh_sach_phong_tro(
id int primary key auto_increment,
id_rent varchar(45),
`name` varchar(45),
phone varchar(45),
start_date date,
payment_id int,
note varchar(45),
foreign key(payment_id) references payment(id)
);


select * from payment;
select * from danh_sach_phong_tro;
 UPDATE danh_sach_phong_tro SET id_rent = 'PT-005'  where id = 2;