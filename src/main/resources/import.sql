
INSERT INTO USER (user_id, email, password, username, name, last_name, age) VALUES (1, 'admin@mail.com', '$2a$12$DSeznl66kU/SL5SiVcQH2eRdOfCrY7IDe9mExTOySLyAI9Olrg0Lq',  'admin', 'admin', 'admin', 18);
INSERT INTO USER (user_id, email, password, username, name, last_name, age) VALUES (2, 'user@mail.com', '$2a$12$Wxs066XoOD/QNi0yO/lTleqaYSU1JdznHfqw/v7wf705.mVv4tqiq',  'user', 'user', 'user', 18);
INSERT INTO USER (user_id, email, password, username, name, last_name, age) VALUES (3, 'fulluser@mail.com', '$2a$12$i7vWHfoh7ulX3yGnZdLBT.jwiyD3avZeHpEVXfI683YkSUGHX8quy',  'fulluser', 'fulluser', 'fulluser', 18);
INSERT INTO USER (user_id, email, password, username, name, last_name, age) VALUES (4, 'tomek@gmail.com', '$2a$12$jhpq2vYCwTIv8Oj1PUDDNu60/eRexeybhSQJJxqS4.tI3ICakexXu',  'tomek', 'tomek', 'tomek', 21);

Insert into role(role_id, name) values(1,'ADMIN');
Insert into role(role_id, name) values(2,'USER');
Insert into role(role_id, name) values(3,'FULLUSER');

INSERT INTO USER_ROLE (user_id, role_id) VALUES (1, 1);
INSERT INTO USER_ROLE (user_id, role_id) VALUES (2, 2);
INSERT INTO USER_ROLE (user_id, role_id) VALUES (3, 3);
INSERT INTO USER_ROLE (user_id, role_id) VALUES (4, 3);

insert into information (information_id, title, content, add_Date, category, is_Shared, user_id) values (1,'notatka 1', 'taka se zanotowana notatka zawierająca adnotację do innej notatki :)', TO_DATE('01-01-2022','dd-MM-yyyy'), 'glupotki', false, 3);
insert into information (information_id, title, content, add_Date, category, is_Shared, user_id) values (2,'notatka 2','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non est vel enim laoreet scelerisque. Fusce pulvinar vehicula neque non ultrices. Donec dictum convallis risus vel tempor. Suspendisse eget erat lorem. Etiam malesuada urna urna. Integer sed interdum magna.', TO_DATE('01-12-2019','dd-MM-yyyy'), 'wazne', false, 3);
insert into information (information_id, title, content, add_Date, category, is_Shared, user_id) values (3,'notatka 3','Donec egestas vulputate lorem, eu pellentesque mi accumsan ac. Nam tempor in libero vitae posuere. Sed placerat ante id consectetur eleifend. Morbi vel mauris malesuada, sodales nulla ut, fringilla metus. Nulla facilisi.. Pellentesque malesuada rhoncus velit, et elementum lorem vehicula vel. Praesent laoreet est diam, eu sodales dolor faucibus a.', TO_DATE('14-05-2021','dd-MM-yyyy'), 'wazne', false, 3);
insert into information (information_id, title, content, add_Date, category, is_Shared, user_id) values (4,'notatka 4','Morbi in erat et arcu mollis elementum. Fusce eros risus, egestas at lacinia in, rhoncus sit amet nunc. Etiam varius malesuada odio in elementum.', TO_DATE('01-01-2023','dd-MM-yyyy'), 'szkola', false, 3);
insert into information (information_id, title, content, add_Date, category, is_Shared, user_id) values (5,'notatka 5','Donec egestas vulputate lorem, eu pellentesque mi accumsan ac. Nam tempor in libero vitae posuere. Sed placerat ante id consectetur eleifend. Morbi vel mauris malesuada, sodales nulla ut, fringilla metus. Nulla facilisi.. Pellentesque malesuada rhoncus velit, et elementum lorem vehicula vel. Praesent laoreet est diam, eu sodales dolor faucibus a.', TO_DATE('14-05-2021','dd-MM-yyyy'), 'wazne', true, 3);
insert into information (information_id, title, content, add_Date, category, is_Shared, user_id) values (6,'notatka 6','Morbi in erat et arcu mollis elementum. Fusce eros risus, egestas at lacinia in, rhoncus sit amet nunc. Etiam varius malesuada odio in elementum.', TO_DATE('01-01-2024','dd-MM-yyyy'), 'praca', true, 1);

insert into information (information_id, title, content, add_Date, category, is_Shared, user_id) values (7,'notatka 7','Notatka tomka 1 ', TO_DATE('01-01-2022','dd-MM-yyyy'), 'tomek', false, 4);
insert into information (information_id, title, content, add_Date, category, is_Shared, user_id) values (8,'notatka 8','Notatka tomka 2 ', TO_DATE('01-01-2022','dd-MM-yyyy'), 'tomek', true, 4);