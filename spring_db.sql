--Схема для хранения товаров и характеристик товаров специфических для каждой
-- отдельно взятой категории.

-- В схеме должна быть возможность хранения категорий у каждой из которых может
-- быть свой перечень характеристик, например категория `Процессоры` с
-- характеристиками `Производитель`, `Количество ядер`, `Сокет` или категория
-- `Мониторы` с характеристиками `Производитель`, `Диагональ`, `Матрица`,
-- `Разрешение`.

-- Процессоры      -> Intel Core I9 9900 -> AMD Ryzen R7 7700
-- Производитель   -> Intel              -> AMD
-- Количество ядер -> 8                  -> 12
-- Сокет           -> 1250               -> AM4

-- Мониторы      -> Samsung SU556270 -> AOC Z215S659
-- Производитель -> Samsung          -> AOC
-- Диагональ     -> 27               -> 21.5
-- Матрица       -> TN               -> AH-IPS
-- Разрешение    -> 2560*1440        -> 1920*1080

create table product
(
    id          serial8,
    category_id int8    not null,
    name        varchar not null,
    price       int8    not null,
    primary key (id),
    foreign key (category_id) references categories (id)

);


create table categories
(
    id   serial8,
    name varchar not null,
    primary key (id)

);

create table options
(
    id          serial8,
    category_id int8    not null,
    name        varchar not null,
    primary key (id),
    foreign key (category_id) references categories (id)

);

create table values
(
    id         serial8,
    product_id int8    not null,
    option_id  int8    not null,
    value      varchar not null,
    primary key (id),
    foreign key (option_id) references options (id),
    foreign key (product_id) references product (id)


);



-- новые таблицы --

create table users
(
    id serial8,
    role int2 not null,
    login varchar not null,
    password varchar not null,
    email varchar not null,
    number varchar(20) not null,
    name varchar not null,
    surname varchar not null,
    date timestamp not null,
    primary key (id)

);


create table orders
(
    id serial8,
    user_id int8 not null,
    status int2 not null,
    street varchar not null,
    building varchar not null,
    floor varchar not null,
    flat  varchar not null,
    date timestamp not null,
    primary key (id),
    foreign key (user_id) references users(id)

);

create table order_products
(
    id SERIAL8,
    order_id int8 not null references orders,
    product_id int8 not null references product,
    amount int2 not null,
    UNIQUE (product_id, order_id)

);


create table comments
(
    id serial8,
    user_id int8 not null,
    product_id int8 not null,
    moderation boolean not null,
    score int2 not null,
    comment varchar not null,
    date timestamp not null,
    primary key (id),
    foreign key (user_id) references users (id),
    foreign key (product_id) references product (id)

);

create table cart_items
(
    id serial8,
    user_id int8 not null,
    product_id int8 not null,
    quantity int2 not null,
    primary key (id),
    foreign key (user_id) references users (id),
    foreign key (product_id) references product (id)


);

-- id
-- user_id
-- product_id
-- quantity



-- product
insert into product (category_id, name, price)
values (1, 'Intel Core I7 Ice Lake-Y', 225000);
insert into product (category_id, name, price)
values (1, 'Ryzen 5 2400G', 205000);
insert into product (category_id, name, price)
values (2, 'SAMSUNG LC32G55TQWIXCI', 169990);
insert into product (category_id, name, price)
values (2, 'ASUS TUF (VG279QR)', 190990);
insert into product (category_id, name, price)
values (3, 'ATX QD-400PNR', 12800);
insert into product (category_id, name, price)
values (3, 'DeepCool Alta 9', 3200);

--category
insert into categories (id, name)
values (1, 'Процессоры');
insert into categories (id, name)
values (2, 'Мониторы');
insert into categories (id, name)
values (3, 'Комплектующие');


insert into options (category_id, name)
values (1, 'Производитель'),
       (1, 'Количество ядер'),
       (1, 'Сокет'),
       (2, 'Производитель'),
       (2, 'Диагональ'),
       (2, 'Матрица'),
       (2, 'Разрешение'),
       (3, 'Наименование'),
       (3, 'Производитель');




insert into values (product_id, option_id, value)
values (1, 1, 'Intel'),
       (1, 2, 8),
       (1, 3, 'LGA 1200'),

       (2, 1, 'AMD'),
       (2, 2, 16),
       (2, 3, 'LGA 1700 '),

       (3, 4, 'SAMSUNG'),
       (3, 5, 32),
       (3, 6, 'VA'),
       (3, 7, 2560*1440),

       (4, 4, 'ASUS'),
       (4, 5, 27),
       (4, 6, 'IPS'),
       (4, 7, 1920*1080),

       (5, 8, 'Блок питания'),
       (5, 9, 'Asus'),

       (6, 8, 'Кулер охлаждения'),
       (6, 9, 'DeepCool');

