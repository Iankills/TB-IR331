--suppression des tables

drop table if exists "salarie";
drop table if exists "conges";

--Création des tables 

create table "salarie"
(
id 		serial primary key,
nom 		varchar,
prenom		varchar,
solde		float,
soldeprev	float,
pseudo		varchar,
password	varchar,
idManager	serial,
isEmploye	boolean,
IsManager	boolean,
iSRH		boolean

)
;

create table "conges"
(
id 		serial primary key,
idemploye	serial,
status		varchar,
periode 	float,
debutConges	varchar,
finConges	varchar

)
;

--Donnes de tests
insert into "salarie" values (10,'Lelabousse','Tristan',30,30,'tlelabou','tlelabou',10,true,true,false);
insert into "salarie" values (11,'binouze','bruno',30,30,'bbinouze','bbinouze',10,true,false,false);
insert into "salarie" values (12,'Emprou','Pierre',30,30,'tlelabou','tlelabou',12,true,true,false);
insert into "salarie" values (13,'binouze','bruno',30,30,'bbinouze','bbinouze',12,true,false,false);
--RH--
insert into "salarie" values (15,'azkende','redouane',30,30,'razkende','razkende',15,true,false,true);

