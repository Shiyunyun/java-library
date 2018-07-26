???prompt PL/SQL Developer import file
prompt Created on 2018年7月26日 by Administrator
set feedback off
set define off
prompt Disabling triggers for T_CLASS...
alter table T_CLASS disable all triggers;
prompt Disabling triggers for T_STUDENT...
alter table T_STUDENT disable all triggers;
prompt Disabling triggers for T_TEACHER...
alter table T_TEACHER disable all triggers;
prompt Disabling foreign key constraints for T_STUDENT...
alter table T_STUDENT disable constraint T_STUDENT_CLASS_ID_FK;
prompt Deleting T_TEACHER...
delete from T_TEACHER;
commit;
prompt Deleting T_STUDENT...
delete from T_STUDENT;
commit;
prompt Deleting T_CLASS...
delete from T_CLASS;
commit;
prompt Loading T_CLASS...
insert into T_CLASS (id, name, start_date, end_date, study_direction, classroom, count)
values (2, 'JAVA-2', to_date('02-02-2018', 'dd-mm-yyyy'), to_date('19-06-2018', 'dd-mm-yyyy'), 'JAVA', 'A102', 26);
insert into T_CLASS (id, name, start_date, end_date, study_direction, classroom, count)
values (3, 'JAVA-3', to_date('03-03-2018', 'dd-mm-yyyy'), to_date('29-07-2018', 'dd-mm-yyyy'), 'JAVA', 'A103', 20);
insert into T_CLASS (id, name, start_date, end_date, study_direction, classroom, count)
values (5, 'HTML-2', to_date('02-02-2018', 'dd-mm-yyyy'), to_date('20-05-2018', 'dd-mm-yyyy'), 'HTML', 'B102', 32);
insert into T_CLASS (id, name, start_date, end_date, study_direction, classroom, count)
values (1, 'JAVA-1', to_date('01-01-2018', 'dd-mm-yyyy'), to_date('14-04-2018', 'dd-mm-yyyy'), 'JAVA', 'A101', 20);
insert into T_CLASS (id, name, start_date, end_date, study_direction, classroom, count)
values (6, 'HTML-3', to_date('03-03-2018', 'dd-mm-yyyy'), to_date('20-07-2018', 'dd-mm-yyyy'), 'HTML', 'B103', 20);
insert into T_CLASS (id, name, start_date, end_date, study_direction, classroom, count)
values (4, 'HTML-1', to_date('01-01-2018', 'dd-mm-yyyy'), to_date('20-04-2018', 'dd-mm-yyyy'), 'HTML', 'B101', 30);
commit;
prompt 6 records loaded
prompt Loading T_STUDENT...
insert into T_STUDENT (id, no, name, gender, class_id, school, profession, graduation_date, mobile, email, contact_relation, contact_name, contact_phone)
values (61, '2018051901', '张子枫', '女', 5, '广州大学', '金融学', to_date('21-06-2018', 'dd-mm-yyyy'), '12092329013', 'zhangzifeng@yeah.net', null, null, null);
insert into T_STUDENT (id, no, name, gender, class_id, school, profession, graduation_date, mobile, email, contact_relation, contact_name, contact_phone)
values (41, '2018051604', '赵柯', '男', 4, '杭州师范大学', '生物学', to_date('21-06-2018', 'dd-mm-yyyy'), '15032849103', 'zhaoke@yeah.net', null, null, null);
insert into T_STUDENT (id, no, name, gender, class_id, school, profession, graduation_date, mobile, email, contact_relation, contact_name, contact_phone)
values (42, '2018051606', '张慧', '女', 3, '北京大学', '管理学', to_date('21-06-2018', 'dd-mm-yyyy'), '13423012343', 'zhanghui@yeah.net', null, null, null);
insert into T_STUDENT (id, no, name, gender, class_id, school, profession, graduation_date, mobile, email, contact_relation, contact_name, contact_phone)
values (2, '2018051601', '张三', '男', null, '深圳大学', '计算机科学', to_date('12-06-2018', 'dd-mm-yyyy'), '17293203242', 'zhangsan@yeah.net', null, null, null);
insert into T_STUDENT (id, no, name, gender, class_id, school, profession, graduation_date, mobile, email, contact_relation, contact_name, contact_phone)
values (3, '2018051602', '李四', '男', null, null, null, null, null, null, null, null, null);
insert into T_STUDENT (id, no, name, gender, class_id, school, profession, graduation_date, mobile, email, contact_relation, contact_name, contact_phone)
values (4, '2018051603', '王五', '女', null, null, null, null, null, null, null, null, null);
insert into T_STUDENT (id, no, name, gender, class_id, school, profession, graduation_date, mobile, email, contact_relation, contact_name, contact_phone)
values (62, '2018051902', '田七', '男', 6, '北京大学', '计算机科学', to_date('21-06-2018', 'dd-mm-yyyy'), '19232042234', 'tianqi@yeah.net', null, null, null);
commit;
prompt 7 records loaded
prompt Loading T_TEACHER...
insert into T_TEACHER (id, no, password, name, gender, mobile, qq, email, job)
values (106, '555', 'e10adc3949ba59abbe56e057f20f883e', '田七', '男', '13492301234', '3565334275', 'tianqi@yeah.net', 'SSM讲师');
insert into T_TEACHER (id, no, password, name, gender, mobile, qq, email, job)
values (101, 'admin', '21232f297a57a5a743894a0e4a801fc3', '管理人', '男', '16329201293', '834330223', 'admin@yeah.net', '管理人');
insert into T_TEACHER (id, no, password, name, gender, mobile, qq, email, job)
values (102, '111', 'e10adc3949ba59abbe56e057f20f883e', '张三', '男', '12402331321', '83943243', 'zhangsan@yeah.net', 'java讲师');
insert into T_TEACHER (id, no, password, name, gender, mobile, qq, email, job)
values (103, '222', 'e10adc3949ba59abbe56e057f20f883e', '李四', '女', '15620922380', '7834303432', 'lisi@yeah.net', 'html讲师');
insert into T_TEACHER (id, no, password, name, gender, mobile, qq, email, job)
values (104, '333', 'e10adc3949ba59abbe56e057f20f883e', '王五', '女', '17493430232', '366575343', 'wangwu@yeah.net', 'js讲师');
insert into T_TEACHER (id, no, password, name, gender, mobile, qq, email, job)
values (105, '444', 'e10adc3949ba59abbe56e057f20f883e', '赵六', '男', '18822320324', '2435534334', 'zhaoliu@yeah.net', 'javaweb讲师');
commit;
prompt 6 records loaded
prompt Enabling foreign key constraints for T_STUDENT...
alter table T_STUDENT enable constraint T_STUDENT_CLASS_ID_FK;
prompt Enabling triggers for T_CLASS...
alter table T_CLASS enable all triggers;
prompt Enabling triggers for T_STUDENT...
alter table T_STUDENT enable all triggers;
prompt Enabling triggers for T_TEACHER...
alter table T_TEACHER enable all triggers;
set feedback on
set define on
prompt Done.
