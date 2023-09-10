CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

drop table if exists tbl_assignments;

create table if not exists tbl_assignments (
    todo_id uuid,
    user_id uuid,
    difficulty int default 0,
    date_assigned timestamp default now()
);