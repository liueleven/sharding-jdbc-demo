# Sharding-JDBC Demo
这个仓库是用来演示[Sharding-JDBC的使用](https://www.yuque.com/liueleven/ehffhb/msaxpq)，文档有中文的，[官网](https://shardingsphere.apache.org)


## 模块介绍
1. 01-demo，简单的演示了往不同的库插入数据，需要先执行SQL脚本: 01-demo/data.sql
2. 02-springboot，在SpringBoot中使用Sharding-JDBC，dao层使用[MybatisPlus](https://mp.baomidou.com/guide/#%E7%89%B9%E6%80%A7)
   ，该模块演示分库分表
