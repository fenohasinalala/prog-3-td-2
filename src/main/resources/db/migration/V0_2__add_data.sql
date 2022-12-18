insert into team(id,name)
values('teamId001','Barcelone');
insert into team(id,name)
values('teamId002','Real Madrid');
insert into team(id,name)
values('teamId003','Inter Milan');


insert into player(id,name,number,team_id)
values('player001','Lionel Messi',10,'teamId001');
insert into player(id,name,number,team_id)
values('player002','Cristiano Ronaldo',7,'teamId002');
insert into player(id,name,number,team_id)
values('player003','Zlatan Ibrahimovic',9,'teamId001');


insert into play_against(id,datetime,stadium,team_1_id,team_2_id)
values('match001','2022-12-20T08:25:24.00Z','parc des princes','teamId001','teamId002');
insert into play_against(id,datetime,stadium,team_1_id,team_2_id)
values('match002','2022-12-25T08:25:24.00Z','parc des princes','teamId001','teamId003');
insert into play_against(id,datetime,stadium,team_1_id,team_2_id)
values('match003','2022-12-26T08:25:24.00Z','parc des princes','teamId002','teamId003');


insert into sponsor(id,name)
values('sponsorId001','Konami');
insert into sponsor(id,name)
values('sponsorId002','Coca Cola');
insert into sponsor(id,name)
values('sponsorId003','AWS');


insert into sponsors_teams(team_id,sponsor_id)
values('teamId001','sponsorId001');
insert into sponsors_teams(team_id,sponsor_id)
values('teamId001','sponsorId002');
insert into sponsors_teams(team_id,sponsor_id)
values('teamId003','sponsorId003');