create table if not exists human (
    id bigserial primary key,
    name text not null
);

create table if not exists house (
    id bigserial primary key,
    address text not null
);

create table if not exists furniture (
    id bigserial primary key,
    name text not null
);

create table if not exists house_humans (
    house_id bigint references house(id),
    human_id bigint references human(id),
    primary key (human_id, house_id)
);

create table if not exists house_furniture (
    house_id bigint references house(id),
    furniture_id bigint references furniture(id),
    unique (house_id, furniture_id)
);