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
set user_name = "ajmalotky", password = "$2a$10$jESJRbXmyrANHXsmxqeSM.4.pINwRnb7VOw0e6iiXqcLAl2EEP9Y."
where id = 2;