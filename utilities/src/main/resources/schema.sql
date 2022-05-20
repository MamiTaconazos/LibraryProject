drop DATABASE if EXISTS library;

Create database library;

use library;

CREATE TABLE if not exists country(
  cod_country int(11) PRIMARY KEY,
  name varchar(25) NOT NULL);

CREATE TABLE if not exists author(
  cod_author varchar(25) PRIMARY KEY,
  name varchar(25),
  surname varchar(25),
  birth date,
  cod_country int(10),
  index id_cod_country (cod_country),
  foreign key (cod_country) references country(cod_country));

create table if not exists book(
cod_book int(15) primary key,
title varchar(50) not null);

create table if not exists autoria(
cod_book int(15) primary key,
cod_author varchar(25) not null,
index id_cod_book (cod_book),
index id_codi_author (cod_author),
foreign key (cod_book) references book(cod_book),
foreign key (cod_author) references author (cod_author));

create table if not exists genre(
cod_genre int(5) primary key,
description varchar(20) not null
);

create table if not exists sub_genre(
cod_sub_genre int(5),
cod_genre int(5),
primary key (cod_genre),
index id_cod_genre (cod_genre),
foreign key (cod_genre) references genre(cod_genre)
);

  create table if not exists thematic(
  cod_book int(15) ,
  cod_genre int(5) ,
  primary key (cod_book),
  titel varchar(50) not null,
  description varchar(20) not null,
  index id_cod_book (cod_book ),
  foreign key (cod_book) references book(cod_book));

create table if not exists member(
cod_member int(10) primary key,
name varchar(25) not null,
surname varchar(30) not null,
address varchar(25) not null,
cod_postal varchar(25) not null,
poblation varchar(25) not null,
phone_num int(9),
data_birth date);


