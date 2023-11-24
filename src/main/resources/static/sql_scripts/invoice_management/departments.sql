create table if not exists departments
(
    uuid            int auto_increment
        primary key,
    company_uuid    int         not null,
    department_name varchar(45) not null,
    constraint fk_departments_companies
        foreign key (company_uuid) references companies (uuid)
            on delete cascade
);

create index fk_departments_companies_idx
    on departments (company_uuid);

