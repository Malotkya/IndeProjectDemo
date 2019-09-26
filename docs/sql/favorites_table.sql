use Indeproject;

drop table favorites;

create table favorites (
	recipe_id int,
    user_id int,
    primary key (recipe_id, user_id),
    foreign key (recipe_id) references recipes(id),
    foreign key (user_id) references users(id)
);