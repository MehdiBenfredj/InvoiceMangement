create table if not exists employees
(
    uuid          int auto_increment
        primary key,
    project_uuid  int         not null,
    first_name    varchar(45) not null,
    last_name     varchar(45) not null,
    position      varchar(45) not null,
    phone_number  varchar(45) not null,
    email_address varchar(45) not null,
    salary        int         not null,
    constraint fk_employees_projects
        foreign key (project_uuid) references projects (uuid)
            on delete cascade
);

create index fk_employees_projects_idx
    on employees (project_uuid);

