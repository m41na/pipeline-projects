CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

drop table if exists tbl_users;

create table if not exists tbl_users (
    id uuid DEFAULT uuid_generate_v4 () primary key,
    first_name varchar,
    last_name varchar,
    email_address varchar unique not null
);