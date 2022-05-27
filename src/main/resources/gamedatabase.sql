/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2022/5/25 21:11:17                           */
/*==============================================================*/


drop table if exists ad_weapon;

drop table if exists advanced;

drop table if exists characters;

drop table if exists def_weapon;

drop table if exists job;

drop table if exists resources;

drop table if exists weapons;

/*==============================================================*/
/* Table: ad_weapon                                             */
/*==============================================================*/
create table ad_weapon
(
   weapon_name          varchar(255) not null,
   weapon_count         int,
   atk                  int,
   damage_type          varchar(255),
   primary key (weapon_name)
);

/*==============================================================*/
/* Table: advanced                                              */
/*==============================================================*/
create table advanced
(
   id                   int not null,
   res_name             varchar(255) not null,
   primary key (id, res_name)
);

/*==============================================================*/
/* Table: characters                                            */
/*==============================================================*/
create table characters
(
   id                   int not null,
   job_name             varchar(255) not null,
   weapon_name          varchar(255),
   name                 varchar(255) not null,
   sex                  char(1),
   atk                  int,
   def                  int,
   damage_type          varchar(255),
   level                int,
   primary key (id)
);

/*==============================================================*/
/* Table: def_weapon                                            */
/*==============================================================*/
create table def_weapon
(
   weapon_name          varchar(255) not null,
   weapon_count         int,
   armor                int,
   magic_resist         int,
   primary key (weapon_name)
);

/*==============================================================*/
/* Table: job                                                   */
/*==============================================================*/
create table job
(
   job_name             varchar(255) not null,
   profiling            varchar(255),
   primary key (job_name)
);

/*==============================================================*/
/* Table: resources                                             */
/*==============================================================*/
create table resources
(
   res_name             varchar(255) not null,
   rarity               varchar(255),
   count                int,
   primary key (res_name)
);

/*==============================================================*/
/* Table: weapons                                               */
/*==============================================================*/
create table weapons
(
   weapon_name          varchar(255) not null,
   weapon_count         int,
   primary key (weapon_name)
);

alter table ad_weapon add constraint FK_is foreign key (weapon_name)
      references weapons (weapon_name) on delete restrict on update restrict;

alter table advanced add constraint FK_advanced foreign key (id)
      references characters (id) on delete restrict on update restrict;

alter table advanced add constraint FK_advanced2 foreign key (res_name)
      references resources (res_name) on delete restrict on update restrict;

alter table characters add constraint FK_belong_job foreign key (job_name)
      references job (job_name) on delete restrict on update restrict;

alter table characters add constraint FK_equiped foreign key (weapon_name)
      references weapons (weapon_name) on delete restrict on update restrict;

alter table def_weapon add constraint FK_is2 foreign key (weapon_name)
      references weapons (weapon_name) on delete restrict on update restrict;

