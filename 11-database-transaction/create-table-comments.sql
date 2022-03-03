create table comments (
    id int not null auto_increment,
    email varchar(100),
    comment text,
    primary key (id)
) ENGINE = InnoDB;

-- select
select * from comments;

-- count
select count(id) from comments;