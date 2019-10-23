use IndeProject;
-- use indetest;

-- drop table calendar;

create table calendar (
	id int primary key auto_increment,
    user_id int,
    recipe_id int,
    day date,
    foreign key (user_id) references users(id),
    foreign key (recipe_id) references recipes(id)
);