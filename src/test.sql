/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.28 : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `class` */

DROP TABLE IF EXISTS `class`;

CREATE TABLE `class` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(20) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_id`),
  KEY `fk_teacher_id` (`teacher_id`),
  CONSTRAINT `fk_teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `class` */

insert  into `class`(`c_id`,`c_name`,`teacher_id`) values (1,'class_a',1),(2,'class_b',2);

/*Table structure for table `community_post` */

DROP TABLE IF EXISTS `community_post`;

CREATE TABLE `community_post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(2000) DEFAULT NULL,
  `likenum` int(11) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `publishtime` datetime DEFAULT NULL,
  `publisherid` bigint(20) DEFAULT NULL,
  `replynum` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `community_post` */

insert  into `community_post`(`id`,`content`,`likenum`,`memo`,`publishtime`,`publisherid`,`replynum`,`type`) values (7,'123aaa\r\n',68,NULL,'2016-03-02 16:32:56',NULL,0,0);

/*Table structure for table `conf` */

DROP TABLE IF EXISTS `conf`;

CREATE TABLE `conf` (
  `id` varchar(30) NOT NULL DEFAULT '0',
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `conf` */

insert  into `conf`(`id`,`name`) values ('1','sunxt');

/*Table structure for table `marriageseeking_info` */

DROP TABLE IF EXISTS `marriageseeking_info`;

CREATE TABLE `marriageseeking_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `expirationtime` datetime DEFAULT NULL,
  `petid` bigint(20) DEFAULT NULL,
  `publishtime` datetime DEFAULT NULL,
  `publisherid` bigint(20) DEFAULT NULL,
  `responsersid` varchar(255) DEFAULT NULL,
  `validation` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `marriageseeking_info` */

insert  into `marriageseeking_info`(`id`,`content`,`expirationtime`,`petid`,`publishtime`,`publisherid`,`responsersid`,`validation`) values (1,NULL,NULL,1234,NULL,234,NULL,'\0');

/*Table structure for table `myuser` */

DROP TABLE IF EXISTS `myuser`;

CREATE TABLE `myuser` (
  `id` int(11) NOT NULL DEFAULT '0',
  `age` int(11) DEFAULT NULL,
  `nice_name` varchar(32) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `myuser` */

insert  into `myuser`(`id`,`age`,`nice_name`,`user_name`,`course`) values (1,90,'吕功建','gongjian','数学'),(2,30,'吕功建','gongjian','语文'),(3,77,'吕功建','gongjian','英语'),(4,80,' 晓腾','什么','数学'),(5,17,' 大师姐','得分','数学'),(6,90,' 晓腾','什么','语文');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL,
  `order_price` float DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`order_id`,`order_no`,`order_price`) values (1,'aaaa',23),(2,'bbbb',33),(3,'cccc',22);

/*Table structure for table `p_user` */

DROP TABLE IF EXISTS `p_user`;

CREATE TABLE `p_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `p_user` */

insert  into `p_user`(`id`,`name`,`sex`) values (1,'A','男'),(2,'B','女'),(3,'C','男');

/*Table structure for table `stu` */

DROP TABLE IF EXISTS `stu`;

CREATE TABLE `stu` (
  `name` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stu` */

insert  into `stu`(`name`,`time`,`score`) values ('sxt','2017-04-05 14:25:02',88),('sxt','2017-04-21 14:25:14',92),('lgj','2017-04-05 14:25:26',79),('lgj','2017-04-01 14:25:37',100),('zq','2017-04-19 14:25:48',84);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(20) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`s_id`,`s_name`,`class_id`) values (1,'student_A',1),(2,'student_B',1),(3,'student_C',1),(4,'student_D',2),(5,'student_E',2),(6,'student_F',2);

/*Table structure for table `students` */

DROP TABLE IF EXISTS `students`;

CREATE TABLE `students` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `date1` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `score` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `students` */

insert  into `students`(`id`,`name`,`date1`,`score`) values (1,'zhangsan','2017-04-12 21:56:43',60),(2,'zhangsan','2012-10-03 00:00:00',80),(3,'lisi','2015-10-05 00:00:00',90),(4,'lisi','2014-01-02 00:00:00',80);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`t_id`,`t_name`) values (1,'teacher1'),(2,'teacher2');

/*Table structure for table `user_t` */

DROP TABLE IF EXISTS `user_t`;

CREATE TABLE `user_t` (
  `id` int(10) NOT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `age` int(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_t` */

insert  into `user_t`(`id`,`user_name`,`password`,`age`) values (123,'孙晓腾','123456',25);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `nice_name` varchar(32) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`age`,`nice_name`,`user_name`,`course`) values (1,90,'吕功建','gongjian','数学'),(2,30,'吕功建','gongjian','语文'),(3,25,'吕功建','emma','英语'),(4,80,' 晓腾','什么','数学'),(6,90,' 晓腾','什么','语文'),(7,20,'emma','张琦',NULL);

/* Procedure structure for procedure `ges_user_count` */

/*!50003 DROP PROCEDURE IF EXISTS  `ges_user_count` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`%` PROCEDURE `ges_user_count`(IN sex_id INT, OUT user_count INT)
BEGIN  
IF sex_id=0 THEN
SELECT COUNT(*) FROM test.p_user WHERE p_user.sex='女' INTO user_count;
ELSE
SELECT COUNT(*) FROM test.p_user WHERE p_user.sex='男' INTO user_count;
END IF;
END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
