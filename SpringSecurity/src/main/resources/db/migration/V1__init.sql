create table users
(
    id       bigserial primary key,
    username varchar(50)  not null unique,
    password varchar(100)  not null,
    email    varchar(150) not null
);

create table roles
(
    id serial primary key,
    name varchar(50) not null
);

create table users_roles
(
    user_id bigint not null,
    role_id int not null,
    primary key (user_id,role_id),
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);

create table privileges
(
    id serial primary key,
    name varchar(50)
);

create table privileges_for_roles
(
    role_id int not null,
    privilege_id int not null,
    primary key (role_id,privilege_id),
    foreign key (role_id) references roles (id),
    foreign key (privilege_id) references privileges (id)
);

insert into roles (name) values
('ROLE_ADMIN'),
('ROLE_USER'),
('ROLE_GUEST');

insert into users (username, password, email) values
('admin','$2a$12$lHRYfWz9V0YNefV0iH/2he7bbljUqw9uDgbDIIlzheNvgTbcnPSaK','admin@mail.com'),
('user','$2a$12$Y8YFr5L3jmQRK7qjnbuTfOrTraiwHlbO3BFAvgpn0X816hDloCE.2','user@mail.com'),
('guest','$2a$12$/IIkzoPiFpBI4IZmOX5a3ey4wuU1t.nSHo/Ix9NLsksNmP8J7CvQy','guest@mail.com');

insert into users_roles (user_id, role_id) VALUES
(1,1),
(1,2),
(2,2),
(3,3);

insert into privileges (name) values
('read'),
('write'),
('update'),
('delete');

insert into privileges_for_roles (role_id, privilege_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(2, 1),
(2, 2),
(3, 1);


