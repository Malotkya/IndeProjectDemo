use IndeProject;

drop table users;

create table users (
	id int auto_increment primary key,
    user_name varchar(20), 
    password varchar(256),
    first_name varchar(20),
    last_name varchar(20)
);

insert into users(user_name, password) values ( "test1", "12345" );
insert into users(user_name, password) values ( "test2", "qwerty" );
insert into users(user_name, password) values ( "test3", "password" );