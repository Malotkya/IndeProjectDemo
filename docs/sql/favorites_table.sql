use IndeProject;
-- use indetest;

drop table favorites;

create table favorites (
	id int primary key auto_increment, -- Needed for hibernate
	recipe_id int,
    user_id int,
    foreign key (recipe_id) references recipes(id) on delete cascade,
    foreign key (user_id) references users(id) on delete cascade,
    unique(recipe_id, user_id)
);

insert into favorites values(1, 1, 1);
insert into favorites values(2, 3, 1);
insert into favorites values(3, 1, 2);
insert into favorites values(4, 2, 2);
insert into favorites values(5, 3, 2);

select * from favorites;