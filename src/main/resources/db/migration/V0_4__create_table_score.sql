create extension if not exists "uuid-ossp";

create table if not exists "score"
(
    id                varchar
        constraint score_pk primary key default uuid_generate_v4(),
    minute            integer
        CONSTRAINT score_minute_verification CHECK (minute > 0 AND 91 > minute),
    is_own_goal       boolean       default false,
    match_id        varchar                  not null
        constraint score_play_against_id_fk references "play_against"(id),
    player_id              varchar                  not null
        constraint score_player_id_fk references "player"(id)
);
