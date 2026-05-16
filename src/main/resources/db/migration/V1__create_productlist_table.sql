create table productLists(
	
	product_id int primary key auto_increment,
	image_url varchar(255) not null,
	product_name varchar(255) not null,
	price decimal(10,2) not null
)