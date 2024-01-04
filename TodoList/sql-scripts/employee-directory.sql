create database todo_list; 

use todo_list;

drop table todo;
Create table todo(
	id int auto_increment primary key,
    title varchar(200) not null,
    Contents varchar(200),
    Date date not null,
    Completed varchar(2) default 'N'
);

-- alter table member rename to todo;


INSERT INTO todo(title, Contents, Date, Completed)
VALUES ('스프링공부', '스프링프로젝트진행', '2024-05-05'),
	   ('하이큐극장판', '하이큐 극장판보기!!', '2024-02-16')
       ('자바공부', '자바모던인액션 공부하기', '2024-02-02');

commit;
select * from todo;