create user 'spring4'@'localhost' identified by 'spring4';


create database spring4fs character set=utf8;

grant all privileges on spring4fs.*to 'spring4'@'localhost';

