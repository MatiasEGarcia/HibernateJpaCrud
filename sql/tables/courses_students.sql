use hibernatecrud;

CREATE TABLE IF NOT EXISTS courses_students(
	student int not null,
    course int not null,
    primary key(student,course)
)