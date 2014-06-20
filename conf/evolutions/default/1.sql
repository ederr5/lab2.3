# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table hackaton (
  id                        bigint not null,
  label                     varchar(255),
  description               varchar(255),
  date                      varchar(255),
  type                      varchar(255),
  is_done                   boolean,
  constraint pk_hackaton primary key (id))
;

create table participantes (
  id                        bigint not null,
  nome                      varchar(255),
  email                     varchar(255),
  constraint pk_participantes primary key (id))
;

create table task (
  id                        bigint not null,
  label                     varchar(255),
  priority                  varchar(255),
  week                      varchar(255),
  is_done                   boolean,
  constraint pk_task primary key (id))
;

create sequence hackaton_seq;

create sequence participantes_seq;

create sequence task_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists hackaton;

drop table if exists participantes;

drop table if exists task;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists hackaton_seq;

drop sequence if exists participantes_seq;

drop sequence if exists task_seq;

