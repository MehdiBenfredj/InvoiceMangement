create table if not exists projects
(
    uuid            int auto_increment
        primary key,
    department_uuid int         not null,
    project_name    varchar(45) not null,
    constraint fk_projects_departments
        foreign key (department_uuid) references departments (uuid)
            on delete cascade
);

create index fk_projects_departments_idx
    on projects (department_uuid);

