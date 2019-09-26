use Indeproject;

drop table Recipes;

create table Recipes (
	id int primary key auto_increment,
    name varchar(20) not null,
    ingrediants varchar(2000),
    directions varchar(2000),
    owner int,
    foreign key (owner) references Users(id)
);

insert into recipes values(1, "boss sauce", "1 jar of spaghetti sauce", "poor sauce into sauce pan and bring to boil", null );

select * from recipes;