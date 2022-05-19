
INSERT INTO USER (user_id, email, password, username, name, last_name, age) VALUES (1, 'admin@mail.com', 'admin',  'admin', 'admin', 'admin', 18);
INSERT INTO USER (user_id, email, password, username, name, last_name, age) VALUES (2, 'user@mail.com', 'user',  'user', 'user', 'user', 18);
INSERT INTO USER (user_id, email, password, username, name, last_name, age) VALUES (3, 'fulluser@mail.com', 'fulluser',  'fulluser', 'fulluser', 'fulluser', 18);
INSERT INTO USER (user_id, email, password, username, name, last_name, age) VALUES (4, 'tomek@gmail.com', 'tomek',  'tomek', 'tomek', 'tomek', 21);

Insert into role(role_id, name) values(1,'admin');
Insert into role(role_id, name) values(2,'user');
Insert into role(role_id, name) values(3,'fulluser');

INSERT INTO USER_ROLE (user_id, role_id) VALUES (1, 1);
INSERT INTO USER_ROLE (user_id, role_id) VALUES (2, 2);
INSERT INTO USER_ROLE (user_id, role_id) VALUES (3, 3);
INSERT INTO USER_ROLE (user_id, role_id) VALUES (4, 3);

insert into information (information_id, title, content, add_Date, category, is_Shared, user_id) values (1,'notatka 1', 'taka se zanotowana notatka zawierająca adnotację do innej notatki :)', TO_DATE('01-01-2022','dd-MM-yyyy'), 'glupotki', false, 3);
insert into information (information_id, title, content, add_Date, category, is_Shared, user_id) values (2,'notatka 2','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non est vel enim laoreet scelerisque. Fusce pulvinar vehicula neque non ultrices. Donec dictum convallis risus vel tempor. Suspendisse eget erat lorem. Etiam malesuada urna urna. Integer sed interdum magna.', TO_DATE('01-12-2019','dd-MM-yyyy'), 'wazne', false, 3);
insert into information (information_id, title, content, add_Date, category, is_Shared, user_id) values (3,'notatka 3','Donec egestas vulputate lorem, eu pellentesque mi accumsan ac. Nam tempor in libero vitae posuere. Sed placerat ante id consectetur eleifend. Morbi vel mauris malesuada, sodales nulla ut, fringilla metus. Nulla facilisi.. Pellentesque malesuada rhoncus velit, et elementum lorem vehicula vel. Praesent laoreet est diam, eu sodales dolor faucibus a.', TO_DATE('14-05-2021','dd-MM-yyyy'), 'wazne', false, 3);
insert into information (information_id, title, content, add_Date, category, is_Shared, user_id) values (4,'notatka 4','Morbi in erat et arcu mollis elementum. Fusce eros risus, egestas at lacinia in, rhoncus sit amet nunc. Etiam varius malesuada odio in elementum.', TO_DATE('01-01-2022','dd-MM-yyyy'), 'szkola', false, 3);

insert into information (information_id, title, content, add_Date, category, is_Shared, user_id) values (5,'notatka 5','Notatka tomka 1 ', TO_DATE('01-01-2022','dd-MM-yyyy'), 'tomek', false, 4);
insert into information (information_id, title, content, add_Date, category, is_Shared, user_id) values (6,'notatka 5','Notatka tomka 2 ', TO_DATE('01-01-2022','dd-MM-yyyy'), 'tomek', false, 4);