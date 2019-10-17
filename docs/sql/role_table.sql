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
insert into roles values( 2, "registered-user", "ajmalotky", 2);
update users
set user_name = "ajmalotky",
	password = "5e9c27edf3feda053c3303a261541d8e357447c48559a3e7d5799241ff9a37fe$1$c1d45dcf986a01e7c61968b06a27d4de26fc47c12ffab6d8258cf9cb4a20d019"
where id = 2;

/*CREATE USER 'tomcat'@'localhost' IDENTIFIED BY 'Zim563';
GRANT SELECT ON IndeProject.* to 'tomcat'@'localhost';*/