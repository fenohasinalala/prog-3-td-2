create extension if not exists "uuid-ossp";


create table if not exists team
(
	id			varchar
		constraint team_pk primary key default uuid_generate_v4(),
	name		varchar		not null
		constraint team_name_unique unique
);
create index if not exists team_name_index on team(name);



create table if not exists player
(
	id			varchar
		constraint player_pk primary key default uuid_generate_v4(),
	name		varchar		not null
	    constraint player_name_unique unique,
	number		integer,
	team_id		varchar		not null
		constraint player_team_id_fk references team(id)
);
create index if not exists player_name_index on player(name);



create table if not exists play_against
(
  id			varchar
    constraint play_against_pk primary key default uuid_generate_v4(),
  datetime timestamp  not null,
  stadium varchar     not null,
  team_1_id   varchar not null
    constraint play_against_team_1_id_fk references team(id),
  team_2_id   varchar not null
  constraint play_against_team_2_id_fk references team(id)
);



create table if not exists sponsor
(
  id      varchar
    constraint sponsor_pk primary key default  uuid_generate_v4(),
  name    varchar   not null
    constraint sponsor_name_unique unique
);
create index if not exists sponsor_name_index on sponsor(name);



create table if not exists sponsors_teams
(
  team_id varchar   not null
    constraint sponsors_teams_team_id_fk references team(id),
  sponsor_id varchar not null
    constraint sponsors_teams_sponsor_id_fk references sponsor(id)
);
