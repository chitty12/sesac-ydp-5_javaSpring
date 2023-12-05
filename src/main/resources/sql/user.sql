use sesac;

create table user2 (
    id bigint not null auto_increment,
    name varchar(255) not null,
    nickname varchar(255) not null,
    primary key(id)
);

desc user2;