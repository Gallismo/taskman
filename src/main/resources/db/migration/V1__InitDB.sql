create table email_confirmations
(
    id                bigserial    not null,
    user_id           bigint       not null UNIQUE,
    confirmation_hash varchar(255) not null,
    created_at        timestamp(6) not null,
    updated_at        timestamp(6) not null,
    primary key (id)
);
create table files
(
    id          bigserial    not null,
    name        varchar(255) not null,
    path        text         not null,
    uploader_id bigint       not null,
    created_at  timestamp(6) not null,
    updated_at  timestamp(6) not null,
    primary key (id)
);
create table tasks
(
    id             bigserial    not null,
    name           varchar(255) not null,
    address        varchar(255),
    deadline_date  date,
    description    text,
    repeat_rule    integer,
    creator_id     bigint,
    parent_task_id bigint,
    performer_id   bigint,
    created_at     timestamp(6),
    updated_at     timestamp(6),
    primary key (id)
);
create table tasks_comments
(
    id         bigserial    not null,
    task_id    bigint,
    message    text,
    created_at timestamp(6) not null,
    updated_at timestamp(6) not null,
    primary key (id)
);
create table tasks_files
(
    file_id bigint not null,
    task_id bigint not null
);
create table tasks_history
(
    id         bigserial not null,
    status_id  bigint,
    task_id    bigint,
    created_at timestamp(6),
    primary key (id)
);
create table tasks_statuses
(
    id   bigserial not null,
    name varchar(255),
    primary key (id)
);
create table users
(
    id            bigserial    not null,
    login         varchar(255) not null UNIQUE,
    password      varchar(255) not null,
    email         varchar(255) not null UNIQUE,
    email_confirm boolean      not null,
    first_name    varchar(255) not null,
    last_name     varchar(255) not null,
    middle_name   varchar(255),
    is_admin      boolean      not null,
    updated_at    timestamp(6) not null,
    created_at    timestamp(6) not null,
    primary key (id)
);

alter table if exists email_confirmations add constraint fk_user_id foreign key (user_id) references users ON DELETE CASCADE;
alter table if exists files add constraint fk_uploader_id foreign key (uploader_id) references users ON DELETE SET NULL;
alter table if exists tasks add constraint fk_creator_id foreign key (creator_id) references users ON DELETE CASCADE;
alter table if exists tasks add constraint fk_performer_id foreign key (performer_id) references users ON DELETE SET NULL;
alter table if exists tasks_comments add constraint fk_task_id foreign key (task_id) references tasks ON DELETE CASCADE;
alter table if exists tasks_files add constraint fk_task_id foreign key (task_id) references tasks ON DELETE CASCADE;
alter table if exists tasks_files add constraint fk_file_id foreign key (file_id) references files ON DELETE CASCADE;
alter table if exists tasks_history add constraint fk_status_id foreign key (status_id) references tasks_statuses ON DELETE CASCADE;
alter table if exists tasks_history add constraint fk_task_id foreign key (task_id) references tasks ON DELETE CASCADE;