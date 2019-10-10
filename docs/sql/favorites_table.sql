use IndeProject;
use indetest;

drop table favorites;

create table favorites (
	id int, -- Needed for hibernate
	recipe_id int,
    user_id int,
    primary key (id),
    foreign key (recipe_id) references recipes(id),
    foreign key (user_id) references users(id)
);

insert into favorites values(1, 1, 1);
insert into favorites values(2, 3, 1);
insert into favorites values(3, 1, 2);
insert into favorites values(4, 2, 2);
insert into favorites values(5, 3, 2);