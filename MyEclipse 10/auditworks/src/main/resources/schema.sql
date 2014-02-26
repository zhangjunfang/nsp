-- ============ mybatis ============ 
-- drop table account;
create table account (
    userid varchar(80) not null,
    email varchar(80) not null,
    name varchar(80) not null,
    constraint pk_account primary key (userid)
);

-- ============ shiro ============ 
--users
create table users (
	username varchar(255) primary key,
    password varchar(255) not null
);

create table roles (
	role_name varchar(255) primary key
);

create table user_roles (
	username varchar(255) not null,
	role_name varchar(255) not null,
	constraint user_roles_uq unique ( username, role_name )
);

create table roles_permissions (
	role_name varchar(255) not null,
	permission varchar(255) not null,
	primary key (role_name, permission)
);


-- ============ mybatis ============
INSERT INTO account VALUES('id1','beyondj2ee@gmail.com','justine');
INSERT INTO account VALUES('id2','beyondj2ee+mybatis@gmail.com','daniel');

-- ============ shiro ============
insert into users values ('user1', 'user1' );
insert into users values ('user2', 'user2' );

insert into roles values ( 'role1' );
insert into roles values ( 'role2' );

insert into user_roles values ( 'user1', 'role1' );
insert into user_roles values ( 'user1', 'role2' );
insert into user_roles values ( 'user2', 'role2' );

insert into roles_permissions values ( 'role1', 'permission1');
insert into roles_permissions values ( 'role1', 'permission2');
insert into roles_permissions values ( 'role2', 'permission1');

commit;


