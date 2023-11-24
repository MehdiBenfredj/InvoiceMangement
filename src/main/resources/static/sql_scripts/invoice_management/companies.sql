create table if not exists companies
(
    uuid         int auto_increment
        primary key,
    company_name varchar(45) not null
);

