insert into USER_DeTAILS (id_user, birthdate, name)
values(10001, current_date(), 'Ranga');

insert into USER_DeTAILS (id_user, birthdate, name)
values(10002, current_date(), 'Robin');

insert into USER_DeTAILS (id_user, birthdate, name)
values(10003, current_date(), 'Saitama');

insert into post(id_post, description, user_id_user)
values(20001, 'I want to learn AWS', 10001);

insert into post(id_post, description, user_id_user)
values(20002, 'I want to learn DevOps', 10001);

insert into post(id_post, description, user_id_user)
values(20003, 'I want to learn AWS Certified', 10002);

insert into post(id_post, description, user_id_user)
values(20004, 'I want to learn Multicloud', 10002);