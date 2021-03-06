    drop table attempt if exists;

    drop table game if exists;

    drop table syllabus if exists;

    drop table user if exists;

    create table attempt (
        id integer generated by default as identity (start with 1),
        isGuessed boolean,
        letter varchar(1),
        game_id integer,
        primary key (id)
    );

    create table game (
        id integer generated by default as identity (start with 1),
        gameStatus varchar(255),
        maxAttempts integer,
        syllabus_id integer,
        user_id integer,
        primary key (id)
    );

    create table syllabus (
        id integer generated by default as identity (start with 1),
        phrase varchar(255),
        primary key (id)
    );

    create table user (
        id integer generated by default as identity (start with 1),
        email varchar(255) not null,
        name varchar(255) not null,
        password varchar(255) not null,
        primary key (id)
    );
