use IndeProject;
-- use indetest;

drop table favorites;

create table favorites (
	recipe_id int,
    user_id int,
    foreign key (recipe_id) references recipes(id) on delete cascade,
    foreign key (user_id) references users(id) on delete cascade,
    primary key(recipe_id, user_id)
);