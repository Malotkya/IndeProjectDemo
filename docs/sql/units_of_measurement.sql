use Indeproject;

drop table Volume;
drop table Weight;

create table Volume (
	id int primary key,
    name varchar(20),
    unit float
);

create table Weight (
	id int primary key,
    name varchar(20),
    unit float
);

insert into Volume values ( 0, "Teaspoon", 1.0 );
insert into Volume values ( 1, "Tablespoon", 3.0 );
insert into Volume values ( 2, "Fluid Ounce", 6.0);
insert into Volume values ( 3, "Cup", 48.6922 );
insert into Volume values ( 4, "Pint", 96.0 );
insert into Volume values ( 5, "Quart", 192.0 );
insert into Volume values ( 6, "Gallon", 768.0 );
insert into Volume values ( 7, "Milliliter", 0.202884 );
insert into Volume values ( 8, "Liter", 202.884 );

insert into Weight values ( 0, "Milligram", 1.0 );
insert into Weight values ( 1, "Gram", 1000.0 );
insert into Weight values ( 2, "Kilogram", 1000000.0 );
insert into Weight values ( 3, "Ounce", 28349.5 );
insert into Weight values ( 4, "Pound", 453592.37 );

select * from Volume;
select * from Weight;