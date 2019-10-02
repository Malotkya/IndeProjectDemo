delete from recipes;
delete from users;

insert into users(id, user_name, password, first_name, last_name) values ( 1, "test1", "12345" , "Bob", "Vance");
insert into users(id, user_name, password, first_name, last_name) values ( 2, "test2", "qwerty" , "Alex", "Malotky");
insert into users(id, user_name, password, first_name, last_name) values ( 3, "test3", "password" , "Ben", "Wyatt");

insert into recipes
values(
	1,
    "Boss Sauce",
	"{ {\"Spagheti Sauce\" , \"16 oz\" } }",
	"{\"Poor sauce into sauce pan\", \" Bring sauce to a boil\"}",
	false,
    2
);