use IndeProject;
-- use indeTest;

drop table users;

create table users (
	id int primary key auto_increment,
    user_name varchar(20), 
    password varchar(256),
    first_name varchar(20),
    last_name varchar(20),
    email varchar(50)
);

insert into users(id, user_name, password, first_name, last_name) values ( 1, "test1", "12345" , "Test", "Person");
insert into users(id, user_name, password, first_name, last_name) values ( 2, "test2", "qwerty" , "Testing", "People");
insert into users(id, user_name, password, first_name, last_name) values ( 3, "test3", "password" , "FirstName", "LastName");

select * from users;