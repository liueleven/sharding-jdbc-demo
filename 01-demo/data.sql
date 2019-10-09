-- 这里在一个MySQL实例中演示

-- 创建两个库，库一：ds_0，库二：ds_1
create database ds_0 character set utf8mb4;
create database ds_1 character set utf8mb4;

-- 分表在两个库中创建下列两个订单表
DROP TABLE IF EXISTS `t_order_0`;
CREATE TABLE `t_order_0` (
  `oid` int(11) NOT NULL,
  `uid` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_order_1`;
CREATE TABLE `t_order_1` (
  `oid` int(11) NOT NULL,
  `uid` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;