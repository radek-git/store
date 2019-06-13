create table categories
(
    id         bigint primary key auto_increment,
    name       varchar(50) unique not null,
    created_at timestamp          not null,
    updated_at timestamp          not null
);


create table brands
(
    id         bigint primary key auto_increment,
    name       varchar(50) not null,
    created_at timestamp   not null,
    updated_at timestamp   not null
);


create table products
(
    id          bigint primary key auto_increment,
    name        varchar(50) not null,
    price       decimal     not null,
    category_id bigint      not null,
    brand_id    bigint      not null,
    created_at  timestamp   not null,
    updated_at  timestamp   not null,

    foreign key (category_id) references categories (id),
    foreign key (brand_id) references brands (id)

);


create table stores
(
    id           bigint primary key auto_increment,
    name         varchar(50) unique not null,
    phone_number varchar(50)        not null,

    created_at   timestamp          not null,
    updated_at   timestamp          not null
);


create table stocks
(
    store_id   bigint    not null,
    product_id bigint    not null,
    quantity   decimal   not null,
    created_at timestamp not null,
    updated_at timestamp not null,

    foreign key (store_id) references stores (id),
    foreign key (product_id) references products (id),

    primary key (store_id, product_id)

);

create table user_types
(
    id   int primary key auto_increment,
    type varchar(50) unique not null
);

create table users
(
    id                     bigint primary key auto_increment,
    user_type_id           int                not null,
    name                   varchar(50)        not null,
    surname                varchar(50)        not null,
    username               varchar(50) unique not null,
    email                  varchar(50) unique not null,
    password               varchar(50)        not null,
    phone_number           varchar(50)        not null,
    store_id               bigint             not null,
    is_expired             boolean            not null default false,
    is_locked              boolean            not null default false,
    is_credentials_expired boolean            not null default false,
    is_enabled             boolean            not null default false,
    created_at             timestamp          not null,
    updated_at             timestamp          not null,

    foreign key (store_id) references stores (id),
    foreign key (user_type_id) references user_types(id)

);

create table roles
(
    id         bigint primary key auto_increment,
    name       varchar(50) unique not null,
    created_at timestamp          not null,
    updated_at timestamp          not null

);


create table user_roles
(
    user_id bigint not null,
    role_id bigint not null,

    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id),

    primary key (user_id, role_id)
);


create table positions
(
    id   bigint primary key auto_increment,
    name varchar(50) unique not null
);



create table orders
(
    id          bigint primary key auto_increment,
    user_id     bigint    not null,
    store_id    bigint    not null,
    created_at  timestamp not null,
    updated_at  timestamp not null,
    total_price decimal   not null,

    foreign key (user_id) references users (id),
    foreign key (store_id) references stores (id)
);


create table order_products
(
    product_id bigint  not null,
    order_id   bigint  not null,
    quantity   decimal not null,
    price      decimal not null,
    position   int     not null,

    foreign key (product_id) references products (id),
    foreign key (order_id) references orders (id),

    primary key (product_id, order_id)
)





