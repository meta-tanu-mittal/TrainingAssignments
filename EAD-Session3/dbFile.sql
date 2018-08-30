/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.0.67-community-nt : Database - employee
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`employee` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `employee`;

/*Table structure for table `employee_detail` */

DROP TABLE IF EXISTS `employee_detail`;

CREATE TABLE `employee_detail` (
  `id` int(11) NOT NULL auto_increment,
  `first_name` varchar(10) NOT NULL,
  `last_name` varchar(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `employee_detail` */

insert  into `employee_detail`(`id`,`first_name`,`last_name`,`email`,`age`) values (1,'tanu','mittal','tanu@gmail.com',21),(2,'kirti','mittal','kirti@gmail.com',21),(3,'twinkle','garg','twinkle.garg@metacube.com',21),(4,'namrata','agarwal','namrata@gmail.com',24),(5,'rahul','sharma','rahul@gmail.com',22),(6,'richa','jain','richa@gmail.com',22),(7,'richa','jain','richa@metacube.com',24),(8,'Tanu','Mittal','tanumittal195@gmail.com',24);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
