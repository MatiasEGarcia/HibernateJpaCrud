use hibernatecrud;

CREATE TABLE IF NOT EXISTS students(
	id_student int not null primary key auto_increment,
    name varchar(50) not null,
    lastname varchar(50) not null
);
