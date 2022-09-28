create database dethi1;
use dethi1;

create table danh_sach_xe (
id int primary key auto_increment,
tenxe_id int,
mausac_id int,
so_luong int,
nam_san_xuat date,
quoc_gia varchar(45),
foreign key (tenxe_id) references loai_xe(id),
foreign key (mausac_id) references mau_sac(id)
);

create table loai_xe(
id int primary key auto_increment,
`name` varchar(45)
);

create table mau_sac(
id int primary key auto_increment,
`name` varchar(45)
);