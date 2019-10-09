-- 02-springboot demo需要的数据源
-- 使用SpringBoot+MybatisPlus+Sharding-JDBC实现数据分片，主键自增
-- ********* 库介绍 *********************
-- 一个是库是 ds0
-- 一个是库是 ds1
-- *************************************
-- ********* 表介绍 *********************
-- user_0,user_1  用户表
-- address_0,address_1 地址表，和user表为绑定表
-- code  是广播表，也叫全局表
-- *************************************

DROP TABLE IF EXISTS `user_0`;
CREATE TABLE `user_0` (
  `uid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
	`age` int(3) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user_1`;
CREATE TABLE `user_1` (
  `uid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
	`age` int(3) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `address_0`;
CREATE TABLE `address_0` (
  `aid` int(11) NOT NULL,
  `uid` int(11) NOT NULL comment '关联user表id',
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `address_1`;
CREATE TABLE `address_1` (
  `aid` int(11) NOT NULL,
  `uid` int(11) NOT NULL comment '关联user表id',
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `code`;
CREATE TABLE `code` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
