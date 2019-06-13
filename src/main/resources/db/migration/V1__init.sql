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



create table employees
(
    id                     bigint primary key auto_increment,
    name                   varchar(50)        not null,
    surname                varchar(50)        not null,
    username               varchar(50) unique not null,
    email                  varchar(50) unique not null,
    password               varchar(50)        not null,
    phone_number           varchar(50)        not null,

    store_id               bigint             not null,
    position_id            int                not null,

    is_expired             boolean            not null default false,
    is_locked              boolean            not null default false,
    is_credentials_expired boolean            not null default false,
    is_enabled             boolean            not null default false,
    created_at             timestamp          not null,
    updated_at             timestamp          not null,


    foreign key (position_id) references positions (id)
);

create table positions
(
    id         bigint primary key auto_increment,
    name       varchar(50) unique not null,
    created_at timestamp          not null,
    updated_at timestamp          not null
);

create table customers
(
    id                     bigint primary key auto_increment,
    name                   varchar(50)        not null,
    surname                varchar(50)        not null,
    username               varchar(50) unique not null,
    email                  varchar(50) unique not null,
    password               varchar(50)        not null,
    phone_number           varchar(50)        not null,

    street                 varchar(50),
    city                   varchar(50),
    postcode               varchar(50),

    is_expired             boolean            not null default false,
    is_locked              boolean            not null default false,
    is_credentials_expired boolean            not null default false,
    is_enabled             boolean            not null default false,
    created_at             timestamp          not null,
    updated_at             timestamp          not null
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

    foreign key (role_id) references roles (id),

    primary key (user_id, role_id)
);



create table orders
(
    id          bigint primary key auto_increment,
    customer_id bigint    not null,
    store_id    bigint    not null,
    created_at  timestamp not null,
    updated_at  timestamp not null,
    total_price decimal   not null,

    foreign key (store_id) references stores (id),
    foreign key (customer_id) references customers (id)
);



create table ordered_products
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





