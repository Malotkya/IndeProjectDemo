
delete from favorites;
delete from recipes;
delete from users;

insert into users(id, user_name, password, first_name, last_name) values ( 1, "test1", "12345" , "Bob", "Vance");
insert into users(id, user_name, password, first_name, last_name) values ( 2, "test2", "qwerty" , "Alex", "Malotky");
insert into users(id, user_name, password, first_name, last_name) values ( 3, "test3", "password" , "Ben", "Wyatt");

insert into recipes
values(
	1,
    "Sliced Bread",
	"{ {\"Italian Loaf\" , \"1 Loaf\" } }",
	"{\"Use a knife to cut the bread into slices\"}",
	false,
    1
);

insert into recipes
values(
	2,
    "Boss Sauce",
	"{ {\"Spagheti Sauce\" , \"16 oz\" } }",
	"{\"Poor sauce into sauce pan\", \" Bring sauce to a boil\"}",
	false,
    2
);

insert into recipes
values(
	3,
    "Test Recipe",
	"{ {\"Ingrediant 1\" , \"16 oz\" }, {\"Ingrediant 2\" , \"5 lbs\" } }",
	"{\"Instruction 1\", \"Instruction 2\"}",
	false,
    3
);

insert into favorites values(1, 1, 1);
insert into favorites values(2, 3, 1);
insert into favorites values(3, 1, 2);
insert into favorites values(4, 2, 2);
insert into favorites values(5, 3, 2);