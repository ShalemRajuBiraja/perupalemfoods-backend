create table orders(

    order_id int primary key auto_increment,

    product_id int not null,

    product_name varchar(255) not null,

    product_price decimal(10,2) not null,

    product_quantity int not null,

    created_on datetime not null default current_timestamp,

    updated_on datetime not null default current_timestamp
    on update current_timestamp,

    foreign key (product_id) references productlists(product_id)

);