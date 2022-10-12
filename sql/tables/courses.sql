use hibernatecrud;

CREATE TABLE IF NOT EXISTS courses(
	id_curso int not null primary key auto_increment,
    nombre varchar(50) not null,
    precio float
);