insert into house(address) values ('Ленина 1'), ('Пушкина 2'), ('Гагарина 3');
insert into human(name) values ('Петя'), ('Маша'), ('Леха');
insert into furniture(name) values ('Стул'), ('Стол'), ('Диван');

insert into house_humans(house_id, human_id) values (1, 1), (2, 2);
insert into house_furniture(house_id, furniture_id) values (2, 3), (3, 1);