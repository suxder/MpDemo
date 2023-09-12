/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.22 : Database - development_application
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`development_application` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `development_application`;

/*Table structure for table `plan_apply_base` */

DROP TABLE IF EXISTS `plan_apply_base`;

CREATE TABLE `plan_apply_base` (
  `apply_id` bigint NOT NULL AUTO_INCREMENT COMMENT '申请ID',
  `apply_code` varchar(30) NOT NULL COMMENT '申请编号',
  `apply_user_name` varchar(30) DEFAULT NULL COMMENT '申请人姓名',
  `apply_user_id` bigint NOT NULL COMMENT '申请人ID',
  `apply_company` varchar(30) NOT NULL COMMENT '申请单位',
  `supplier_code` varchar(30) DEFAULT NULL COMMENT '供应商代码',
  `supplier_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '供应商名称',
  PRIMARY KEY (`apply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `plan_apply_base` */

insert  into `plan_apply_base`(`apply_id`,`apply_code`,`apply_user_name`,`apply_user_id`,`apply_company`,`supplier_code`,`supplier_name`) values 
(1,'ZRKF012234','李四',1,'采购中心','00001','河北科技技术有限单位');

/*Table structure for table `plan_apply_info` */

DROP TABLE IF EXISTS `plan_apply_info`;

CREATE TABLE `plan_apply_info` (
  `supply_detail_id` bigint NOT NULL AUTO_INCREMENT COMMENT '供应明细ID',
  `apply_id` bigint DEFAULT NULL COMMENT '申请ID（外键）',
  `product_area` varchar(30) DEFAULT NULL COMMENT '产品领域',
  `product_name` varchar(30) DEFAULT NULL COMMENT '产品名称',
  PRIMARY KEY (`supply_detail_id`),
  KEY `apply_id` (`apply_id`),
  CONSTRAINT `plan_apply_info_ibfk_1` FOREIGN KEY (`apply_id`) REFERENCES `plan_apply_base` (`apply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `plan_apply_info` */

insert  into `plan_apply_info`(`supply_detail_id`,`apply_id`,`product_area`,`product_name`) values 
(1,1,'前桥','转向节'),
(2,1,'前桥','前轴');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`birthday`) values 
(1,'张怡然','123','2023-08-16'),
(2,'梅花十三','123','2023-10-06'),
(3,'伍六七','123','2023-10-06'),
(4,'可乐','123','2023-10-06');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
