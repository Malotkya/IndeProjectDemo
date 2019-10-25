use IndeProject;
-- use indetest;

drop table favorites;

create table favorites (
	id int primary key auto_increment, -- Needed for hibernate
	recipe_id int,
    user_id int,
    foreign key (recipe_id) references recipes(id) on delete cascade,
    foreign key (user_id) references users(id) on delete cascade,
    unique(recipe_id, user_id) -- formerly primary key(recipe_id, user_id)
);