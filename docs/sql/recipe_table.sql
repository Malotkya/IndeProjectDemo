/*use Indeproject;*/
use indeTest;

drop table recipes;

create table recipes (
	id int primary key auto_increment,
    name varchar(20) not null,
    ingredients varchar(2000),
    directions varchar(2000),
    public bool,
    user_id int,
    foreign key (user_id) references Users(id)
);

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
	"[\"{\\\"item\\\":\\\"Ingredient 1\\\", \\\"amount\\\":\\\"20\\\", \\\"unit\\\":\\\"oz\\\"}\",\"{\\\"item\\\":\\\"Ingredient 2\\\", \\\"amount\\\":\\\"5\\\", \\\"unit\\\":\\\"lbs\\\"}\"]",
	"[\"Instruction 1\", \"Instruction 2\"]",
	false,
    3
);

select * from recipes;