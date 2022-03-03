create table customers (
    id varchar(100) not null,
    name varchar(100) not null,
    email varchar(100) not null,
    constraint email_unique unique (email),
    primary key (id)
) ENGINE = InnoDB;