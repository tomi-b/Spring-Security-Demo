insert into User (username, encryptedpassword, enabled)
values ('admin', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
 
insert into User (username, encryptedpassword, enabled)
values ('owner', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 2);

insert into User (username, encryptedpassword, enabled)
values ('manager', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 3);
 
insert into User (username, encryptedpassword, enabled)
values ('employee', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 4);
 

 
insert into Role (rolename)
values ('ROLE_ADMIN');
 
insert into Role (rolename)
values ('ROLE_OWNER');

insert into Role (rolename)
values ('ROLE_MANAGER');
 
insert into Role (rolename)
values ('ROLE_EMPLOYEE');


insert into user_roles (users_id, roles_id)
values (1, 1);

insert into user_roles (users_id, roles_id)
values (1, 2);

insert into user_roles (users_id, roles_id)
values (1, 3);

insert into user_roles (users_id, roles_id)
values (1, 4);
 
insert into user_roles (users_id, roles_id)
values (2, 2);
 
insert into user_roles (users_id, roles_id)
values (3, 3);

insert into user_roles (users_id, roles_id)
values (4, 4);

