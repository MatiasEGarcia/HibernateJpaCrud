use hibernatecrud;

CREATE TABLE IF NOT EXISTS students(
	id_student int not null primary key auto_increment,
    name varchar(45) not null,
    lastname varchar(45) not null,
    phone varchar(45) not null,
    mail varchar(45) not null,
    country varchar(45) not null,
    address varchar(45) not null
);
