use sesac;

create table board (
	id int auto_increment primary key,
    title varchar(20) not null,
    content varchar(100) not null,
    writer varchar(40) not null,
    registered datetime default current_timestamp
);

desc board;