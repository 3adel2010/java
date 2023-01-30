<h1> week 4 day 1 exc..</h1>

create database store;<br>
### countries<br>
create table countries(<br>
    code int(25) primary key,<br>
    name varchar(25) unique ,<br>
    continent_name varchar(25) not null<br>
);

## users

create table users (<br>
    id int primary key,<br>
    email varchar(45) unique,<br>
    gender varchar(1) check ( gender = 'm' or gender  = 'f'),<br>
    created_at datetime default curdate(),<br>
    country_code int,<br>
    foreign key(country_code) references countries(code)<br>
);

## orders

create table orders (<br>
    id int(25) primary key,<br>
    status varchar(6) check ( status = 'start' or status = 'finish'),<br>
    created_at datetime default curdate(),<br>
    user_id int,<br>
    foreign key (user_id) references users(id)<br>
);

## products

create table products (<br>
    id int(25) primary key,<br>
    price int (8) default 0,<br>
    name varchar(25) not null,<br>
    status varchar(7) check (status  = 'valid' or status = 'expired')<br>
);

## order products

create table order_products (<br>
    quantity int (15) default 0,<br>
    created_at datetime default curdate(),<br>
    order_id int,<br>
    product_id int,<br>
    foreign key (order_id) references orders(id),<br>
    foreign key (product_id) references products(id)<br>
);

## solution

insert into countries value (1,'KSA','Asia');<br>
insert into users value (102,'aa1@aa.aa','m',curdate(),1);<br>
insert into orders value (201,'start',curdate(),101);<br>
insert into products value (301,150,'water','valid');<br>
insert into order_products value (12,curdate(),201,301);<br>
update countries set name = 'Saudi arabia' where code = 1;<br>
delete from products where id = 301;
