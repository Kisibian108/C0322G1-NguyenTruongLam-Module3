create database hokhau;

use hokhau;

create table ho_khau(
id int primary key auto_increment,
ma_ho_khau_id int,
ten_chu_ho varchar(45),
so_luong_thanh_vien int,
ngay_lap_ho_khau date,
dia_chi_nha varchar(45),
foreign key (ma_ho_khau_id) references gia_dinh(id)
);

create table gia_dinh(
id int primary key auto_increment,
ho_khau varchar(45),
chung_minh_thu varchar(45),
ho_ten varchar(45),
ngay_sinh date
);

select * from ho_khau;
select * from gia_dinh;


