/*
SQLyog Ultimate v10.00 Beta1
MySQL - 8.0.31 : Database - class_management
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`class_management` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `class_management`;

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `photo` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '大头照',
  `name` char(15) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `phone` char(11) DEFAULT NULL,
  `parent_name` char(15) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '家长名字',
  `parent_phone` char(11) DEFAULT NULL COMMENT '家长电话',
  `address` varchar(20) DEFAULT NULL COMMENT '地址',
  `absent` int DEFAULT '0',
  `power` tinyint(1) DEFAULT '0' COMMENT '考勤权限',
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32102140338 DEFAULT CHARSET=utf8mb3;

/*Data for the table `student` */

insert  into `student`(`id`,`photo`,`name`,`phone`,`parent_name`,`parent_phone`,`address`,`absent`,`power`) values (32102140201,'http://8.138.58.49:9999/crh.png','蔡锐杭','13724711411','',NULL,'潮州国',1,0),(32102140202,'http://8.138.58.49:9999/A.webp','曾祥金','15728320983','曾秋东','18814255572','茂名职业技术学院',0,0),(32102140203,'http://8.138.58.49:9999/b.png','陈豪锋','13927163903','','','茂名职业技术学院',0,1),(32102140204,'http://8.138.58.49:9999/a.png','陈家裕','10086',NULL,NULL,'茂名职业技术学院',0,0),(32102140205,'http://8.138.58.49:9999/b.png','陈名东','10086111776',NULL,NULL,'茂名职业技术学院',0,0),(32102140206,'http://8.138.58.49:9999/b.png','陈桐钺','11111111111','','','茂名职业技术学院',0,0),(32102140207,'http://8.138.58.49:9999/b.png','陈文博','11111111111','','','茂名职业技术学院',0,0),(32102140208,'http://8.138.58.49:9999/b.png','邓济民','11111111111','','','茂名职业技术学院',0,1),(32102140209,'http://8.138.58.49:9999/b.png','方耀辉','11111111111','','','茂名职业技术学院',0,0),(32102140210,'http://8.138.58.49:9999/b.png','高源江','11111111111','','','茂名职业技术学院',0,0),(32102140211,'http://8.138.58.49:9999/b.png','何杨杰','11111111111','','','茂名职业技术学院',0,0),(32102140337,'http://8.138.58.49:9999/hr.png','冯浩然','13064570498',NULL,NULL,'茂名职业技术学院',0,0);

/*Table structure for table `student_attendance` */

DROP TABLE IF EXISTS `student_attendance`;

CREATE TABLE `student_attendance` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` bigint unsigned NOT NULL,
  `teacher_id` int NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `leave_reason` varchar(200) NOT NULL,
  `leave_school` tinyint(1) DEFAULT '0',
  `arrive_adress` varchar(20) DEFAULT NULL,
  `back_school` date DEFAULT NULL,
  `teacher_audit` tinyint(1) DEFAULT '0' COMMENT '班主任审批是否通过',
  `refuse` tinyint(1) DEFAULT '0' COMMENT 'true拒绝请假',
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_attendance_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3;

/*Data for the table `student_attendance` */

insert  into `student_attendance`(`id`,`student_id`,`teacher_id`,`name`,`leave_reason`,`leave_school`,`arrive_adress`,`back_school`,`teacher_audit`,`refuse`,`create_time`) values (11,32102140202,1,'曾祥金','不想去上课',0,'',NULL,1,0,'2023-06-04'),(15,32102140202,1,'蔡锐杭','我就不去',1,'回潮州','2023-06-17',0,1,'2023-06-03'),(20,32102140337,1,'冯浩然','不想去上课',1,'足浴店','2023-06-08',0,1,'2023-06-05'),(21,32102140201,1,'蔡锐杭','请假去当小丑',1,'茂名东汇城','2023-06-06',0,0,'2023-06-05');

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` char(5) NOT NULL,
  `phone` char(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `teacher_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

/*Data for the table `teacher` */

insert  into `teacher`(`id`,`name`,`phone`) values (1,'沈大旺','18088863987'),(2,'陈凡健',NULL),(3,'付玉珍',NULL),(4,'陈胜娣',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
