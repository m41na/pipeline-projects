insert into tbl_assignments (user_id, todo_id) values (
  (select id from tbl_users where first_name = 'mike'),
  (select id from tbl_todos where task = 'squeeze lime juice')
);

insert into tbl_assignments (user_id, todo_id) values (
  (select id from tbl_users where first_name = 'mary'),
  (select id from tbl_todos where task = 'bake banana bread')
);

insert into tbl_assignments (user_id, todo_id) values (
  (select id from tbl_users where first_name = 'mike'),
  (select id from tbl_todos where task = 'read morning jam')
);