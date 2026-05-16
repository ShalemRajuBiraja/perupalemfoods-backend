create table users(
	user_id int primary key auto_increment,
	full_name varchar(255) not null ,
	email varchar(255) not null unique,
	mobile_number  varchar(15) not null,
	password_hash varchar(255) not null,
	created_at timestamp default current_timestamp,
	updated_at timestamp default current_timestamp on update current_timestamp
);