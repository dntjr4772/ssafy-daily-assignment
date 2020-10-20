SELECT * FROM mydb.todolist;
/* 할일 등록 */
insert into todolist(content,userid,write_date,end_date,done)
values(todo.getContent(),todo.getUserId(),todo.getWriteDate(),todo.getEndDate(),todo.getDone());
/* 할일 수정 */
update todolist 
set content=todo.getContent(),userid=todo.getUserId(),write_date=todo.getWriteDate(),end_date=todo.getEndDate(),done=todo.getDone()
where no=no;
/* 할일 삭제 */
delete from todolist where no=todo.getNo();
/* 특정 사용자의 할일리스트 전체 조회 */
select * from todolist where userid=userId;
/* 할일번호로 할일 조회  */
select * from todolist where no=no;
/* 특정 사용자의 할일리스트 전체 삭제 */
delete from todolist where userid=userId;
/* 할일번호로 할일 완료 처리 */
update todolist 
set done="Y"
where no=no;