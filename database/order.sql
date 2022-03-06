insert into t_order (order_id, user_id, table_id, total_price, memo, status, create_time, finish_time, num_people) values (1, 7,
2, 60, "少放辣椒", 0, "2020-03-02", null, 1);
insert into t_order (order_id, user_id, table_id, total_price, memo, status, create_time, finish_time, num_people) values (2, 8,
3, 60, "少放辣椒，少放油", 0, "2020-03-02", null, 1);
insert into t_order (order_id, user_id, table_id, total_price, memo, status, create_time, finish_time, num_people) values (3, 9,
4, 90, "多放辣椒", 0, "2020-03-02", null, 1);

insert into food_order (order_id, food_id, num_food, status, delivery) values (1, 1, 1, 0, 0);
insert into food_order (order_id, food_id, num_food, status, delivery) values (1, 2, 1, 0, 0);
insert into food_order (order_id, food_id, num_food, status, delivery) values (2, 1, 1, 0, 0);
insert into food_order (order_id, food_id, num_food, status, delivery) values (2, 3, 1, 0, 0);
insert into food_order (order_id, food_id, num_food, status, delivery) values (3, 4, 1, 0, 0);
insert into food_order (order_id, food_id, num_food, status, delivery) values (3, 6, 1, 0, 0);