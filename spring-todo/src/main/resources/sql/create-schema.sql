CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

drop table if exists tbl_todos;

create table if not exists tbl_todos (
    id uuid DEFAULT uuid_generate_v4 () primary key,
    task varchar not null,
    completed bool default false
);