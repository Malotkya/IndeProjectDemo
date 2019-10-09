use IndeProject;

drop table roles;

create table roles (
	id int primary key auto_increment,
    role_name varchar(20),
    user_name varchar(20), 
    user_id int,
   foreign key (user_id) references users(id)
);

insert into roles values( 1, "administrator", "ajmalotky", 2);
update users
set user_name = "ajmalotky", password = "12345"
where id = 2;

/*CREATE USER 'tomcat'@'localhost' IDENTIFIED BY 'Zim563';
GRANT SELECT ON IndeProject.* to 'tomcat'@'localhost';*/