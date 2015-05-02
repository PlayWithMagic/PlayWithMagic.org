# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

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
  constraint uq_magician_1 unique (first_name,last_name),
  constraint pk_magician primary key (id))
;

create table magician_type (
  id                        bigint not null,
  name                      varchar(255),
  description               varchar(255),
  display_order             integer,
  constraint pk_magician_type primary key (id))
;

create sequence magician_seq;

create sequence magician_type_seq;

alter table magician add constraint fk_magician_magicianType_1 foreign key (magician_type_id) references magician_type (id);
create index ix_magician_magicianType_1 on magician (magician_type_id);



# --- !Downs

drop table if exists magician cascade;

drop table if exists magician_type cascade;

drop sequence if exists magician_seq;

drop sequence if exists magician_type_seq;

