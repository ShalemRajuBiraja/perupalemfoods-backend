create table carts(

    cart_id int primary key auto_increment,

    user_id int not null,

    product_id int not null,

    product_name varchar(255) not null,

    price decimal(10,2) not null,

    created_on timestamp default current_timestamp,

    updated_on timestamp default current_timestamp
    on update current_timestamp,

    foreign key (user_id)
    references users(user_id),

    foreign key (product_id)
    references productlists(product_id),

    unique (user_id, product_id)

); 