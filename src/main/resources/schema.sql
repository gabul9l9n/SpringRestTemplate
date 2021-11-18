drop table if exists website;
drop table if exists "USER";
drop table if exists address;
drop table if exists geo;
drop table if exists company;

drop index if exists idx_website_on_name;

drop sequence if exists sql_sequence_geo_id;
drop sequence if exists sql_sequence_address_id;
drop sequence if exists sql_sequence_company_id;
drop sequence if exists sql_sequence_user_id;

create table if not exists website
(
    name           varchar(255) primary key,
    website        varchar(255),
    icon_image_url varchar(255),
    title          varchar(255),
    description    varchar(255)
);
create unique index if not exists idx_website_on_name on website (name);

--
create table if not exists geo
(
    g_id  int primary key,
    g_lat varchar(255),
    g_lng varchar(255)
);

create sequence if not exists sql_sequence_geo_id start with 1 increment by 1;

--
create table if not exists address
(
    a_id      int primary key,
    a_street  varchar(255),
    a_suite   varchar(255),
    a_city    varchar(255),
    a_zipcode varchar(255),
    geo_id    varchar(255) unique references geo (g_id)
);

create sequence if not exists sql_sequence_address_id start with 1 increment by 1;

--
create table if not exists company
(
    c_id           int primary key,
    c_name         varchar(255),
    c_catch_phrase varchar(255),
    c_bs           varchar(255)
);

create sequence if not exists sql_sequence_company_id start with 1 increment by 1;

--
create table if not exists "USER"
(
    u_id       int primary key,
    u_name     varchar(255),
    u_username varchar(255),
    u_email    varchar(255),
    address_id varchar(255) unique references address (a_id),
    u_phone    varchar(255),
    u_website  varchar(255),
    company_id varchar(255) unique references company (c_id)
);

create sequence if not exists sql_sequence_user_id start with 1 increment by 1;