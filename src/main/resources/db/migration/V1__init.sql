create sequence users_sequence start with 1 increment by 1 minvalue 1 maxvalue 999999999999 cache 1;



create table categories
(
    id         bigint primary key auto_increment,
    name       varchar(50) unique not null,
    created_at timestamp          not null default current_timestamp(),
    updated_at timestamp          not null default current_timestamp(),
);


create table brands
(
    id         bigint primary key auto_increment,
    name       varchar(50) not null,
    created_at timestamp   not null default current_timestamp(),
    updated_at timestamp   not null default current_timestamp(),
);


create table positions
(
    id         bigint primary key auto_increment,
    name       varchar(50) unique not null,
    created_at timestamp          not null default current_timestamp(),
    updated_at timestamp          not null default current_timestamp(),
);



create table stores
(
    id           bigint primary key auto_increment,
    name         varchar(50) unique not null,
    phone_number varchar(50)        not null,

    created_at   timestamp          not null default current_timestamp(),
    updated_at   timestamp          not null default current_timestamp(),
);


create table employees
(
    id                     bigint                      default users_sequence.nextval primary key,
    name                   varchar(50)        not null,
    surname                varchar(50)        not null,
    username               varchar(50) unique not null,
    email                  varchar(50) unique not null,
    password               varchar(60)        not null,
    phone_number           varchar(50)        not null,

    store_id               bigint             not null,
    position_id            bigint             not null,
    added_by_employee_id   bigint             not null,

    is_expired             boolean            not null default false,
    is_locked              boolean            not null default false,
    is_credentials_expired boolean            not null default false,
    is_enabled             boolean            not null default false,
    created_at             timestamp          not null default current_timestamp(),
    updated_at             timestamp          not null default current_timestamp(),


    foreign key (position_id) references positions (id),
    foreign key (store_id) references stores (id)
);



create table products
(
    id                     bigint primary key auto_increment,
    name                   varchar(50) not null,
    price                  decimal     not null,
    category_id            bigint      not null,
    brand_id               bigint      not null,
    created_at             timestamp   not null default current_timestamp(),
    updated_at             timestamp   not null default current_timestamp(),
    added_by_employee_id   bigint      not null,
    updated_by_employee_id bigint      not null,

    foreign key (category_id) references categories (id),
    foreign key (brand_id) references brands (id),
    foreign key (added_by_employee_id) references employees (id),
    foreign key (updated_by_employee_id) references employees (id)

);



create table store_products
(
    store_id   bigint  not null,
    product_id bigint  not null,
    quantity   decimal not null,

    foreign key (store_id) references stores (id),
    foreign key (product_id) references products (id),

    primary key (store_id, product_id)

);



create table customers
(
    id                     bigint                      default users_sequence.nextval primary key,
    name                   varchar(50)        not null,
    surname                varchar(50)        not null,
    username               varchar(50) unique not null,
    email                  varchar(50) unique not null,
    password               varchar(60)        not null,
    phone_number           varchar(50)        not null,

    street                 varchar(50),
    city                   varchar(50),
    postal_code            varchar(50),
    added_by_employee_id   bigint,

    is_expired             boolean            not null default false,
    is_locked              boolean            not null default false,
    is_credentials_expired boolean            not null default false,
    is_enabled             boolean            not null default false,
    created_at             timestamp          not null default current_timestamp(),
    updated_at             timestamp          not null default current_timestamp()
);


create table roles
(
    id         bigint primary key auto_increment,
    name       varchar(50) unique not null,
    created_at timestamp          not null default current_timestamp(),
    updated_at timestamp          not null default current_timestamp(),

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
    customer_id bigint,
    employee_id bigint,
    store_id    bigint    not null,
    created_at  timestamp not null default current_timestamp(),
    updated_at  timestamp not null default current_timestamp(),
    total_price decimal   not null,

    foreign key (store_id) references stores (id),
    foreign key (customer_id) references customers (id),
    foreign key (employee_id) references employees (id)
);



create table order_products
(
    order_id   bigint  not null,
    product_id bigint  not null,
    quantity   decimal not null,
    price      decimal not null,
    position   int     not null,

    foreign key (product_id) references products (id),
    foreign key (order_id) references orders (id),

    primary key (product_id, order_id)
)





