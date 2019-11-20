use IndeProject;
-- use indetest;

drop table calendar;

create table calendar (
    user_id int,
    recipe_id int,
    record bigint,
    foreign key (user_id) references users(id),
    foreign key (recipe_id) references recipes(id),
    primary key(user_id, recipe_id, record)
);

select * from calendar;