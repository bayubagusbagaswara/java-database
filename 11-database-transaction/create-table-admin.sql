create table admin (
    username varchar(100) not null,
    password varchar(100) not null,
    primary key (username)
) ENGINE = InnoDB;

-- insert data
insert into admin (username, password)
values ('admin', 'admin');

-- select data
select * from admin;