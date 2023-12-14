create table if not exists compilation
(
    id    bigserial primary key,
    title text
);

create table if not exists genre
(
    id    bigserial primary key,
    title text
);

create table if not exists artist
(
    id    bigserial primary key,
    title text
);

create table if not exists track
(
    id     bigserial primary key,
    title  text
);


create table if not exists track_artist
(
    track  bigint not null references track (id),
    artist bigint not null references artist (id)
);

create table if not exists track_genre
(
    track bigint not null references track (id),
    genre bigint not null references genre (id)
);

create table if not exists track_compilation
(
    track       bigint not null references track (id),
    compilation bigint not null references compilation (id)
);

insert into artist(title) values ('artist 1'), ('artist 2');
insert into track(title) values ('test 1'), ('test 2'), ('test 3');
insert into genre(title) values ('classic'), ('rock'), ('pop');
insert into compilation(title) values ('AAA'), ('BBB'), ('CCC');

insert into track_artist(track, artist) values (1, 1), (2, 2), (3, 3), (3, 1);
insert into track_genre(track, genre) values (1, 1), (2, 2), (3, 3), (3, 2), (2, 1);
insert into track_compilation(track, compilation) values (1, 1), (2, 1), (3, 1), (1, 2), (1, 3), (2, 3);