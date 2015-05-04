# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table image (
  id                        bigint not null,
  name                      varchar(255),
  data                      bytea,
  constraint pk_image primary key (id))
;

create table magician (
  id                        bigint not null,
  first_name                varchar(45) not null,
  last_name                 varchar(45) not null,
  email                     varchar(255) not null,
  password                  varchar(255) not null,
  magician_type_id          bigint,
  stage_name                varchar(255),
  location                  varchar(255),
  biography                 varchar(2000),
  interests                 varchar(2000),
  influences                varchar(255),
  year_started              integer,
  organizations             varchar(255),
  website                   varchar(255),
  facebook                  varchar(255),
  twitter                   varchar(255),
  linked_in                 varchar(255),
  google_plus               varchar(255),
  flickr                    varchar(255),
  instagram                 varchar(255),
  constraint uq_magician_email unique (email),
  constraint uq_magician_1 unique (email),
  constraint pk_magician primary key (id))
;

create table magician_type (
  id                        bigint not null,
  name                      varchar(255),
  description               varchar(255),
  display_order             integer,
  constraint pk_magician_type primary key (id))
;

create table material (
  id                        bigint not null,
  routine_id                bigint,
  name                      varchar(45) not null,
  description               varchar(2000),
  is_inspectable            boolean not null,
  is_given_away             boolean not null,
  is_consumed               boolean not null,
  price                     integer,
  purchase_url              varchar(255),
  image_url                 varchar(255),
  constraint pk_material primary key (id))
;

create table routine (
  id                        bigint not null,
  name                      varchar(45) not null,
  description               varchar(2000) not null,
  duration                  integer not null,
  method                    varchar(2000),
  handling                  varchar(2000),
  reset_duration            integer,
  reset_description         varchar(2000),
  you_tube_url              varchar(255),
  image_url                 varchar(255),
  review_url                varchar(255),
  inspiration               varchar(2000),
  placement                 varchar(2000),
  choices                   varchar(2000),
  constraint uq_routine_name unique (name),
  constraint pk_routine primary key (id))
;

create table set (
  id                        bigint not null,
  magician_id               bigint,
  name                      varchar(45) not null,
  description               varchar(2000) not null,
  constraint pk_set primary key (id))
;


create table set_routine (
  set_id                         bigint not null,
  routine_id                     bigint not null,
  constraint pk_set_routine primary key (set_id, routine_id))
;
create sequence image_seq;

create sequence magician_seq;

create sequence magician_type_seq;

create sequence material_seq;

create sequence routine_seq;

create sequence set_seq;

alter table magician add constraint fk_magician_magicianType_1 foreign key (magician_type_id) references magician_type (id);
create index ix_magician_magicianType_1 on magician (magician_type_id);
alter table material add constraint fk_material_routine_2 foreign key (routine_id) references routine (id);
create index ix_material_routine_2 on material (routine_id);
alter table set add constraint fk_set_magician_3 foreign key (magician_id) references magician (id);
create index ix_set_magician_3 on set (magician_id);



alter table set_routine add constraint fk_set_routine_set_01 foreign key (set_id) references set (id);

alter table set_routine add constraint fk_set_routine_routine_02 foreign key (routine_id) references routine (id);

# --- !Downs

<<<<<<< HEAD
drop table if exists magician cascade;

drop table if exists magician_type cascade;

drop table if exists material cascade;

drop table if exists routine cascade;

drop table if exists set_routine cascade;

drop table if exists set cascade;
=======
drop table if exists image cascade;

drop table if exists magician cascade;

drop table if exists magician_type cascade;

drop table if exists material cascade;

drop table if exists routine cascade;

drop table if exists set_routine cascade;

drop table if exists set cascade;

drop sequence if exists image_seq;
>>>>>>> origin/imageUploads-1

drop sequence if exists magician_seq;

drop sequence if exists magician_type_seq;

drop sequence if exists material_seq;

drop sequence if exists routine_seq;

drop sequence if exists set_seq;

