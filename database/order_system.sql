create table food
(
	food_id int auto_increment
		primary key,
	food_name varchar(50) null,
	description varchar(3000) null,
	category int null,
	price float null,
	image varchar(100) null,
	is_like tinyint(1) null,
	is_available tinyint(1) null
);

create table food_order
(
	order_id int null,
	food_id int null,
	num_food int null,
	status int null,
	delivery int null,
	constraint order_id
		unique (order_id, food_id)
);

create table message
(
	message_id int auto_increment
		primary key,
	order_id int null,
	title varchar(100) null,
	content varchar(300) null,
	create_time datetime null,
	send_user int null,
	receive_user int null,
	status int null
);

create table notice
(
	notice_id int auto_increment
		primary key,
	title varchar(100) null,
	content varchar(300) null,
	create_time datetime null
);

create table notice_user
(
	notice_id int null,
	user_id int null,
	status int null,
	constraint notice_id
		unique (notice_id, user_id)
);

create table t_order
(
	order_id int auto_increment
		primary key,
	user_id int null,
	table_id int null,
	total_price float null,
	memo varchar(300) null,
	status int null,
	create_time datetime null,
	finish_time datetime null,
	num_people int null
);

create table user
(
	user_id int auto_increment
		primary key,
	username varchar(50) null,
	password varchar(20) null,
	portrait varchar(100) null,
	role int null,
	phone varchar(11) null,
	salary float null,
	bonus float null,
	email varchar(100) null,
	image_path varchar(100) null,
	image_base64 mediumtext null
);

create table waiter_menu
(
	id int auto_increment
		primary key,
	name varchar(50) null,
	parent_id int null,
	role int null,
	href varchar(200) null
);