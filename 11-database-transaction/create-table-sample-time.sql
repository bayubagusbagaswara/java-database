create table sample_time(
    id int not null auto_increment,
    sample_date date,
    sample_time time,
    sample_timestamp timestamp,
    primary key (id)
) ENGINE = InnoDB;