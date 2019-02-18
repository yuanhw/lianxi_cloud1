drop table if exists user;
CREATE TABLE `user` (
`id`  bigint NOT NULL AUTO_INCREMENT ,
`user_name`  varchar(255) NULL ,
`name`  varchar(255) NULL ,
`age`  int NULL ,
`balance`  decimal(10,2) NULL ,
PRIMARY KEY (`id`)
);