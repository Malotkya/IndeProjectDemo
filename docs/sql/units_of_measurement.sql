use Indeproject;

drop table Volume;
drop table Weight;

create table Volume (
	id int primary key,
    name varchar(20),
    code char(3),
    value float
);

create table Weight (
	id int primary key,
    name varchar(20),
    code char(3),
    value float
);

insert into Volume values ( 0, "Teaspoon", "tsp", 1.0 );
insert into Volume values ( 1, "Tablespoon", "Tsp", 3.0 );
insert into Volume values ( 2, "Fluid Ounce", "foz", 6.0);
insert into Volume values ( 3, "Cup", "c", 48.6922 );
insert into Volume values ( 4, "Pint", "p", 96.0 );
insert into Volume values ( 5, "Quart", "q", 192.0 );
insert into Volume values ( 6, "Gallon", "g", 768.0 );
insert into Volume values ( 7, "Milliliter", "mL", 0.202884 );
insert into Volume values ( 8, "Liter", "L", 202.884 );

insert into Weight values ( 0, "Milligram", "mg", 1.0 );
insert into Weight values ( 1, "Gram", "g", 1000.0 );
insert into Weight values ( 2, "Kilogram", "kg", 1000000.0 );
insert into Weight values ( 3, "Ounce", "oz", 28349.5 );
insert into Weight values ( 4, "Pound", "lbs", 453592.37 );

select * from Volume;
select * from Weight;