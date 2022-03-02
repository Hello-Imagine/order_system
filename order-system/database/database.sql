create table user (
    user_id int primary key auto_increment,
    username varchar(50),
    password varchar(20),
    portrait varchar(100),
    role int,
    phone varchar(11),
    salary float,
    bonus float
);

create table food (
    food_id int primary key auto_increment,
    food_name varchar(50),
    description varchar(300),
    category int,
    price float,
    image varchar(100),
    is_like tinyint(1),
    is_available tinyint(1)
);

create table t_order (
    order_id int primary key auto_increment,
    user_id int,
    table_id int,
    total_price float,
    memo varchar(300),
    status int,
    create_time datetime,
    finish_time datetime,
    num_people int
);

create table food_order (
    order_id int,
    food_id int,
    num_food int,
    status int,
    delivery int,
    unique (order_id, food_id)
);

create table notice (
    notice_id int primary key auto_increment,
    title varchar(100),
    content varchar(300),
    create_time datetime
);

create table notice_user (
    notice_id int,
    user_id int,
    status int,
    unique (notice_id, user_id)
);

create table message (
    message_id int primary key auto_increment,
    order_id int,
    title varchar(100),
    content varchar(300),
    create_time datetime,
    send_user int,
    receive_user int,
    status int
);

create table waiter_menu (
    id int primary key auto_increment,
    name varchar(50),
    parent_id int,
    role int
);