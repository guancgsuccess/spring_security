drop table user_role;
drop table user;
drop table role;
drop table permission;
drop table role_permission;
create table role_permission(
  id int(7) PRIMARY KEY AUTO_INCREMENT,
  role_id int(7),
  permission_id int(7)
);
insert into role_permission values(1,1,1);
insert into role_permission values(2,1,2);
insert into role_permission values(3,1,3);

insert into role_permission values(4,2,3);

create table permission(
  id int(7) PRIMARY KEY AUTO_INCREMENT,
  url varchar(20),
  name varchar(10),
  pid int(7),
  description varchar(20)
);
insert into permission(id,url,name,pid,description) values(1,'/hello','测试helo',null,'测试hello的描述');
insert into permission(id,url,name,pid,description) values(2,'/hello/admin','测试admin',null,'测试hello/admin的描述');
insert into permission(id,url,name,pid,description) values(3,'/hello/user','测试user',null,'测试hello/user的描述');

create table user(
  id int(7) PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(20),
  password VARCHAR(20)
);
insert into user(username,password) values("admin","admin");
insert into user(username,password) values("tom","tom");

create table role(
  id int(7) PRIMARY KEY AUTO_INCREMENT,
  role_name varchar(20)
);
insert into role(role_name) values('admin');
insert into role(role_name) values('user');

create table user_role(
  id int(7) PRIMARY KEY AUTO_INCREMENT,
  user_id int(7),
  role_id int(7)
);
insert into user_role(user_id,role_id)values(1,1);
insert into user_role(user_id,role_id)values(1,2);
insert into user_role(user_id,role_id)values(2,2);