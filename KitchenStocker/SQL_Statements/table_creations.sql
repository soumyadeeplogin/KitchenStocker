drop table department;
create table department (id int primary key not null, name varchar(299) not null, description varchar(1024));
drop table category;
create table category (id int primary key  not null, name varchar(299) not null, description varchar(1024), dept_id int not null, foreign key (dept_id) references department(id) on delete cascade);
drop table sub_category;
create table sub_category (id int primary key  not null, name varchar(299) not null, description varchar(1024), cat_id int, foreign key (cat_id) references category(id)  on delete cascade);
drop table item;
create table item (id int primary key  not null,  cat_id int, sub_cat_id int, quntity float(3,2), unit enum('kg','ltr','Pcs'), purchase_date datetime, update_date datetime, foreign key (cat_id) references category(id), foreign key (sub_cat_id) references sub_category(id));