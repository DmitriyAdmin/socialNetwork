insert into `person` (`first_name`, `last_name`, `reg_date`, `birth_date`, `e_mail`, `phone`,
`password`, `photo`, `about`, `town` , `confirmation_code`, `is_approved`,
`messages_permission`, `last_online_time` ,`is_blocked`) values
( 'Иванов', 'Иван', '21-01-2015', '25-03-1963', 'ivaniavanov@mail.ru', '79234567895', 'asdf1234', null, 'good man', 'Tomsk','', '0', ALL, '2013-10-08 16:07:28', 0),
( 'Сидоров', 'Максим', '22-07-2010', '14-05-1985', 'sidorovmaxim@mail.ru', '79856321456', 'maxim1234', null, 'good man', 'Omsk','', '0', ALL, '2019-06-08 10:09:29', 0),
( 'Михайлов', 'Сергей', '01-07-2012', '19-05-1990', 'mihailovsergei@mail.ru', '79135546932', 'sergei1990', null, 'funny man', 'Moscow','', '0', FRIENDS, '2019-06-15 15:07:28', 0),
( 'Твердохлебов', 'Роман', '05-05-2005', '12-06-1991', 'roman1991@mail.ru', '79423652145', 'roman1991', null, 'strong man', 'Moscow','', '0', FRIENDS, '2019-06-16 16:08:20', 0),
( 'Быкова', 'Анастасия', '02-12-2013', '17-01-1998', 'nasty1998@mail.ru', '79456328975', 'nasty456', null, 'nice girl', 'Krum','', '0', FRIENDS, '2019-05-15 05:07:12', 0),
( 'Ефремова', 'Алена', '08-08-2015', '06-06-1987', 'efremovaalena@mail.ru', '79238856712', 'alenka1278', null, 'happy woman', 'Tula','', '0', FRIENDS, '2019-06-16 12:09:28', 0),
( 'Губкин', 'Иван', '09-01-2012', '15-03-1993', 'ivangubkin@mail.ru', '79452548235', 'ivan8235', null, 'busy man', 'Moscow','', '0', ALL, '2019-06-15 21:01:28', 0),
( 'Никифоров', 'Никита', '08-01-2019', '09-09-2005', 'nikita2005@mail.ru', '79234435614', 'nikita5614', null, 'little man', 'Kazan','', '0', ALL, '2019-06-15 22:57:28', 0),
( 'Васов', 'Вадим', '07-07-2018', '05-01-2003', 'vadikvasov@mail.ru', '79839541265', 'vadik1265', null, 'cool', 'Ufa','', '0', FRIENDS, '2019-06-15 23:01:56', 0),
( 'Дымова', 'Дарья', '07-09-2015', '15-11-1995', 'dumova1995@mail.ru', '79234331552', 'dumova1552', null, 'happy', 'Moscow','', '0', FRIENDS, '2019-06-15 13:52:14', 0);

insert into `block_history` (`time`, `person_id`, `post_id`, `comment_id`, `action`) values
('2019-05-15 13:12:14', '2', '3', '6', UNBLOCK),
('2016-01-10 18:16:33', '3', '10', '1', UNBLOCK),
('2017-05-12 14:12:51', '5', '2', '6', UNBLOCK),
('2017-10-10 05:00:42', '1', '4', '3', UNBLOCK),
('2017-11-10 05:05:52', '2', '5', '4', UNBLOCK),
('2018-08-08 17:17:10', '7', '3', '2', UNBLOCK),
('2019-01-21 02:42:48', '3', '2', '3', UNBLOCK),
('2019-02-25 08:32:16', '6', '9', '6', UNBLOCK),
('2019-04-14 10:57:14', '4', '8', '1', UNBLOCK),
('2019-06-12 13:50:30', '10', '2', '1', BLOCK);


insert into `user` (`name`,`e_mail`, `password`, `type`) values
('Алексей', 'alex_inbox@gmail.com', 'alex1224', ADMIN),
('Вася', 'vasya_inbox@gmail.com', 'vasya456321', ADMIN),
('Света', 'sveta2000@gmail.com', 'sveta789', MODERATOR),
('Игорь', 'igor1995@gmail.com', 'igor1995', MODERATOR),
('Артем', 'tema_box@gmail.com', 'artem1996', MODERATOR),
('Кирилл', 'kirill_box@gmail.com', 'kirill2005', MODERATOR),
('Даня', 'danil2001@gmail.com', 'passdanil1525', ADMIN),
('Виталий', 'vitali_inbox@gmail.com', 'vitali1224', MODERATOR),
('Максим', 'max_box@gmail.com', 'maxpass1995', ADMIN),
('Айгуль', 'igul8888@gmail.com', 'aigulpass8888', ADMIN);

insert into `friendship` (`status_id`,`src_person_id`, `dst_person_id`) values
('1', '2', '3'),
('2', '5', '2'),
('3', '4', '7'),
('3', '5', '1'),
('2', '2', '1'),
('2', '5', '2'),
('4', '8', '4'),
('4', '7', '4'),
('5', '9', '8'),
('5', '10', '3');


insert into `friendship_status` (`time`, `name`, `code`) values
('2019-06-12 13:50:30', 'Максим', REQUEST),
('2018-01-10 12:01:10', 'Анастасия', FRIEND),
('2018-10-02 09:50:15', 'Роман', BLOCKED),
('2019-02-02 17:42:10', 'Анастасия', BLOCKED),
('2019-02-27 08:57:33', 'Максим', FRIEND),
('2019-03-21 22:55:30', 'Анастасия', FRIEND),
('2019-04-01 19:50:30', 'Никита', DECLINED),
('2019-05-12 17:50:30', 'Иван', DECLINED),
('2019-06-06 16:12:39', 'Вадим', SUBSCRIBED),
('2019-06-12 07:55:30', 'Дарья', SUBSCRIBED);

insert into `message` (`time`,`author_id`, `recipient_id`, `message_text`, `read_status`) values
('2019-04-14 17:50:30', '1', '3', 'привет, пойдем гулять', READ),
('2018-02-19 13:01:10', '2', '9', 'привет, СДЕЛАЛ ДОМАШКУ', READ),
('2018-12-06 08:35:15', '3', '5', 'пока', READ),
('2019-05-17 17:12:10', '7', '5', 'привет, познакомимся', READ),
('2019-05-17 18:47:33',  '5', '7', 'привет, НЕТ', SENT),
('2019-07-28 23:55:30',  '10', '1', 'удачи', READ),
('2019-09-24 11:57:30',  '8', '5', 'привет, до завтра', SENT),
('2019-10-17 04:14:30',  '5', '4', 'зимой поеду домой', READ),
('2019-04-14 18:22:39',  '3', '1', 'через час дождь', SENT),
('2019-06-09 16:15:30',  '8', '9', 'конференция через 3 месяца', SENT);

insert into `post` (`time`,`author_id`, `title`, `post_text`, `is_blocked`) values
('2018-12-06 08:35:15', '2', 'Конференция', 'В МГУ 1 марта будет проходить международная конференция среди молодых ученых, заявки принимаются до 1 февраля', 1),
('2018-12-28 18:14:15', '4', 'Новый год', 'Мандарины - символ Нового года. В магазинах "Пятерочка" всего за 69 р/кг', 1),
('2019-02-05 09:26:15', '6', 'Новый год по всоточному календарю', 'Многие жители нашей многонациональной страны празднуют Новый год по восточному календарю', 1),
('2019-03-01 18:18:15', '10', 'Отдых за границей', 'Названы самые бюджетные варианты стран, куда можно отправиться всей семьей на море', 1),
('2019-03-24 12:52:15', '1', 'Масленица', 'В площади Ленина в предстоящие выходные пройдет ярмарка в честь масленницы', 1),
('2019-04-01 15:00:15', '5', 'Горящие туры', 'Успейте приобрести тур в солнечную Анапу по выгодным ценам', 1),
('2019-04-07 18:35:15', '7', 'Робототехника в России', 'Российские ученые изобрели робота-водителя', 1),
('2019-04-12 11:53:15', '9', 'День космонавтики', 'В день космонавтики мэр вручил дипломы ректору нашего университета', 1),
('2019-05-01 08:00:15', '8', 'Сборная России в чемпионате Европы пробился в полуфинал', 'Вратарь сборной проявил себя ловким и не пропустил ни одного гола. Благодаря ему команда одержала победу', 1),
('2019-05-05 18:35:15', '5', 'Худеть легко', 'Добавьте в свой ежедневный рацион грейфрут', 1);
insert into `tag`(`tag`) values
('Погода'),
('Праздники'),
('Здоровье'),
('Наука'),
('Политика'),
('Путешествия'),
('Спорт'),
('Религия'),
('Еда'),
('Технологии');

insert into `post2tag`(`post_id`, `tag_id`) values
('1', '4'),
('2', '9'),
('3', '8'),
('4', '6'),
('5', '2'),
('6', '6'),
('7', '4'),
('8', '2'),
('9', '7'),
('10', '9');

insert into `post_like`(`time`,`person_id`, `post_id`) values
('2018-12-06 08:35:15', '2','2'),
('2015-11-14 07:01:56', '1','8'),
('2013-08-02 11:55:01', '5','4'),
('2011-07-04 12:12:10', '3','5'),
('2018-05-01 17:59:22', '1','2'),
('2016-03-16 18:17:39', '10','3'),
('2017-04-17 23:31:47', '4','7'),
('2016-11-12 12:02:54', '8','1'),
('2013-11-14 04:12:12', '9','3'),
('2019-01-18 05:14:51', '4','8'),
('2014-07-15 03:07:02', '3','7'),
('2015-06-19 17:12:15', '5','6'),
('2019-08-15 22:22:15', '3','7');

insert into `post_file`(`post_id`, `name`, `path`) values
('1', 'forma.doc','d:/Conference/'),
('1', 'zaiavlenie.doc','d:/Conference/'),
('1', 'list.doc','d:/Conference/'),
('2', 'orange.png','d:/Images/'),
('5', 'vesna.mp3','d:/Music/'),
('6', 'sun.png','d:/Images/'),
('6', 'komorovo.mp3','d:/Music/'),
('10', 'fruit.png','d:/Images/'),
('7', 'robot.png','d:/Images/'),

insert into `post_comment`(`time`, `post_id`, `parent_id`, `author_id`, `comment_text`, `is_blocked`) values
('2018-12-06 11:00:15', '1','', '4','Дистанционно можно участвовать?', 0),
('2018-12-06 15:40:15', '1','1', '2','Да, взнос 1000 руб', 0),
('2018-12-28 21:10:15', '2', '', '10', 'Еще бы', 0),
('2019-03-02 17:11:00', '4', '', '2', 'Какое море, на рыбалку с пацанами съездить бы хоть', 0),
('2019-03-02 18:51:00', '4', '5', '3', 'Точняк, хоть нормально отдохням без бабских "А сфотай так, а сфотай сидя еще..." ', 0),
('2019-03-02 18:54:00', '4', '6', '2', 'Все, на майские поедем', 0),
('2019-05-01 18:01:15', '9', '', '3', 'Красавик Акинфеев!!! Тащит всю команду', 0),
('2019-05-01 18:40:15', '9', '7', '4', 'Как в ЧМ. Гордость нашего народа. Ты до конца смотрел матч', 0),
('2019-05-01 18:45:15', '9', '8', '3', 'Нет, до 3 раунда', 0),
('2019-05-01 18:45:15', '9', '9', '4', 'Тогда зрелищное пропустил в конце 4 раунда', 0);

insert into `notification` (`type_id`, `sent_time`, `person_id`, `entity_id`, `contact`) values
('102', '2018-12-06 11:00:15', '2', '1', 'sidorovmaxim@mail.ru'),
('102', '2018-12-06 15:40:15', '4', '1', 'roman1991@mail.ru'),
('105', '2019-04-14 17:50:30', '3', '1', 'mihailovsergei@mail.ru'),
('105', '2019-04-14 18:22:39', '1', '9', 'ivaniavanov@mail.ru'),
('104', '2019-06-12 13:50:30', '3', '4', 'nasty1998@mail.ru'),
('101', '2018-12-06 08:35:15', '8','9', 'roman1991@mail.ru'),
('102', '2019-03-02 17:11:00', '2','4', 'dumova1995@mail.ru'),
('103', '2019-03-02 18:51:00', '5','5', 'sidorovmaxim@mail.ru'),
('103', '2019-03-02 18:54:00', '6','3', 'mihailovsergei@mail.ru'),
('102', '2018-12-28 21:10:15', '10','3', 'roman1991@mail.ru');



insert into `notification_type`(`code` , `name`) values
('101',POST ),
('102',POST_COMMENT ),
('103', COMMENT_COMMENT),
('104', FRIEND_REQUEST),
('105', MESSAGE);


