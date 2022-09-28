create database dethi;
use dethi;

create table danhsach (
id int primary key auto_increment,
id_benh_an int ,
id_benh_nhan int ,
ten_benh_nhan varchar(45),
ngay_nhap_vien date,
ngay_ra_vien date,
ly_do varchar(45),
foreign key(id_benh_an) references benh_an(id),
foreign key(id_benh_nhan) references benh_nhan(id)
);

SELECT danhsach.id_benh_an, danhsach.id_benh_nhan  FROM danhsach inner join benh_an on danhsach.id_benh_an = benh_an.id;


create table benh_an(
id int primary key auto_increment,
ma_benh_an varchar(45)
);

create table benh_nhan(
id int primary key auto_increment,
ma_benh_nhan varchar(45)
);

