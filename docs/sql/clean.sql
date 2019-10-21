use IndeProject;

SET SQL_SAFE_UPDATES=0;
delete from roles;
delete from favorites;
delete from recipes;
delete from users;
SET SQL_SAFE_UPDATES=1;

insert into users(id, user_name, password, first_name, last_name)
values( 1,
		"ajmalotky",
        "5e9c27edf3feda053c3303a261541d8e357447c48559a3e7d5799241ff9a37fe$1$c1d45dcf986a01e7c61968b06a27d4de26fc47c12ffab6d8258cf9cb4a20d019" ,
        "Alex",
        "Malotky"
);

insert into roles values( 1, "administrator", "ajmalotky", 1);
insert into roles values( 2, "registered-user", "ajmalotky", 1);

insert into recipes
values(
	1,
    "Test Recipe",
	"[\"{\\\"item\\\":\\\"Ingredient 1\\\", \\\"amount\\\":\\\"20\\\", \\\"unit\\\":\\\"oz\\\"}\",\"{\\\"item\\\":\\\"Ingredient 2\\\", \\\"amount\\\":\\\"5\\\", \\\"unit\\\":\\\"lbs\\\"}\"]",
	"[\"Instruction 1\", \"Instruction 2\"]",
	true,
    1
);

insert into favorites
values( 1, 1, 1 );