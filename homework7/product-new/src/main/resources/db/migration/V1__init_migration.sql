CREATE TABLE IF NOT EXISTS users
(
    id       serial unique not null,
    username varchar(1000) not null
);

CREATE TABLE IF NOT EXISTS products
(
    id             serial not null,
    user_id        bigint not null references users (id),
    account_number varchar(1000),
    balance        varchar(1000),
    product_type   varchar(1000)
);


