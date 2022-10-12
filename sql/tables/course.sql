use hibernatecrud;

CREATE TABLE IF NOT EXISTS courses(
	id_course int not null primary key auto_increment,
    name varchar(50) not null,
    price float
);