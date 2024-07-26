create database signal_graphic;

use signal_graphic;

create table signal_data(
    `id` int auto_increment primary key,
    `info_time` varchar(10),
    `county_id` int  ,
    `county` varchar(5) not null ,
    `town_id` int ,
    `town` varchar(5) not null,
    `night_work` decimal(10,3),
    `day_work(7:00~13:00)` decimal(10,3),
    `day_work(13:00~19:00)` decimal(10,3),
    `day_work` decimal(10,3),
    `night_weekend` decimal(10,3),
    `day_weekend(7:00~13:00)` decimal(10,3),
    `day_weekend(13:00~19:00)` decimal(10,3),
    `day_weekend` decimal(10,3),
    `morning_work` decimal(10,3),
    `midday_work`decimal(10,3),
    `afternoon_work` decimal(10,3),
    `evening_work` decimal(10,3),
    `morning_weekend` decimal(10,3),
    `midday_weekend` decimal(10,3),
    `afternoon_weekend` decimal(10,3),
    `evening_weekend` decimal(10,3)
);

create table person(
    `id` int auto_increment primary key,
    `name` varchar(10),
    `money` int
)