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
set user_name = "ajmalotky",
	password = "ef951ba62d3a5f6c8e720523be24a5d9$100000$f2a114562ae3a81b95c5ba85bd35500f80dada0061ff1811456680c639686e10"
where id = 2;

/*CREATE USER 'tomcat'@'localhost' IDENTIFIED BY 'Zim563';
GRANT SELECT ON IndeProject.* to 'tomcat'@'localhost';*/