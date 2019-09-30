use Indeproject;

drop table recipes;

create table recipes (
	id int primary key auto_increment,
    name varchar(20) not null,
    ingredients varchar(2000),
    directions varchar(2000),
    public bool,
    owner int,
    foreign key (owner) references Users(id)
);

insert into recipes
values(
	0,
    "Boss Sauce",
	"{ {\"Spagheti Sauce\" , \"16 oz\" } }",
	"{\"Poor sauce into sauce pan\", \" Bring sauce to a boil\"}",
	false, 
    2
);

select * from recipes;