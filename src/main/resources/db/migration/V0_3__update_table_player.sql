ALTER TABLE player
    ADD COLUMN is_goal_keeper boolean default false;

insert into player(id,name,number,team_id,is_goal_keeper)
values('player004','Gianluigi Buffon',1,'teamId003',true);