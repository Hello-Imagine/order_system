-- create table notice(
-- 	notice_id int primary key auto_increment,
-- 	title varchar(100),
--     content varchar(300),
--     create_time datetime
-- );
insert into notice(title, content, create_time)
values 	("春节安排", "2022年春节即将到来，大家可以从2022年1月25日休假至2022年2月10日", "2022-1-24 08:08:08"),
		("新的一年", "2022年祝大家返工愉快", "2022-2-11 19:19:19"),
        ("快来围观", "对面也开了家餐厅，看上去很有竞争力，他们搞特价我们也搞特价，大家加油", "2022-2-12 10:10:10"),
        ("家庭原因说明", "最近墨莫默由于家庭原因导致工作状态出现问题，已经给了墨莫默一周的时间调整自己，大家在今后的工作中有事情要及时反应呀", "2022-2-13 07:07:07"),
        ("关怀父母", "最近墨莫默的曾祖父去世了，大家一起去送老人家一程吧，明天餐厅歇业", "2022-2-16 07:07:07"),
        ("悲后之喜", "莫末要与郑争结婚啦，大家一起去参加婚礼吧，明天餐厅歇业", "2022-2-20 09:09:09"),
        ("喜上加喜", "经过大家的不懈努力，我们终于取得了胜利，生意再次回归年前的光景！大家辛苦啦", "2022-2-23 09:09:09"),
        ("失物公告", "张彰璋在餐厅6号桌捡到了顾客的手机，现已放在失物招领台，有失主询问时请大家注意", "2022-2-24 09:09:09"),
        ("离职公告", "鹿鲁麓大哥由于家庭原因要回老家了，店里明天早上九点至十点给大哥送行，从十点半开始营业", "2022-2-25 09:09:09"),
        ("新的员工", "最近招了一个很幽默风趣的厨师向湘翔，今晚大家聚餐认识认识。", "2022-2-28 09:09:09");

-- select * from notice;

-- create table notice_user (
-- 	notice_id int,
--     user_id int,
--     status int,
--     primary key (notice_id, user_id));
insert into notice_user(notice_id, user_id, status)
values  (1, 1, 0),
		(2, 1, 0),
        (3, 1, 0),
        (4, 1, 0),
        (5, 1, 0),
        (6, 1, 0),
        (7, 1, 0),
        (8, 1, 0),
        (9, 1, 0),
        (10, 1, 0);
-- select * from notice_user; 

-- create table food_order (
-- 	order_id int,
--     food_id int,
--     num_food int,
--     status int,
--     delivery int,
--     primary key(order_id, food_id)
-- );

insert into food_order(order_id, food_id, num_food, status, delivery)
values  (1, 1, 1, 0, 0),
		(1, 2, 1, 0, 0),
        (1, 3, 2, 0, 0),
        (2, 1, 1, 0, 0),
        (2, 2, 1, 0, 0),
        (2, 3, 1, 0, 0),
        (3, 2, 1, 0, 0),
        (3, 3, 1, 0, 0);