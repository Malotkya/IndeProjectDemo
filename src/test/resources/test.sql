/*Test comment*/
delete from users;

insert into users(id, user_name, password, first_name, last_name)
values ( 1, "test1", "12345" , "John", "Smith");

insert into users(id, user_name, password, first_name, last_name)
values ( 2, "test2", "qwerty" , "Jane", "Doe");

insert into users(id, user_name, password, first_name, last_name)
values ( 3, "CalzoneZone", "password" , "Ben", "Wyatt");

/*
L
o
t
s

o
f

s
p
a
c
e
 */

insert into users(id, user_name, password, first_name, last_name) values ( 4, "User Name", "" , "First Name", "Last Name");

/* Just don't put a semicolon in a comment and everything will be just fine! */