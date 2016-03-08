CREATE DATABASE  IF NOT EXISTS `ent` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ent`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: ent
-- ------------------------------------------------------
-- Server version	5.5.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tt_permission`
--

DROP TABLE IF EXISTS `tt_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tt_permission` (
  `perm_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `status` int(1) unsigned zerofill DEFAULT '0',
  `createtime` datetime DEFAULT NULL,
  `modtime` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`perm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tt_permission`
--

LOCK TABLES `tt_permission` WRITE;
/*!40000 ALTER TABLE `tt_permission` DISABLE KEYS */;
INSERT INTO `tt_permission` VALUES (1,'Basic User ',1,'2016-03-04 20:39:59','2016-03-04 20:39:59','User can Login in system'),(2,'Create User',1,'2016-03-04 20:40:05','2016-03-04 20:40:05','User Create'),(3,'Delete User',1,'2016-03-04 20:40:13','2016-03-04 20:40:13','User Delet'),(4,'Modify User',1,'2016-03-04 20:40:20','2016-03-04 20:40:20','User Modify/Activate/Deactivate'),(5,'RolePerm Admistrator2',1,'2016-03-07 21:48:08','2016-03-07 21:48:08','Create/Delete/Modify  Roles And Permission'),(6,'RolePerm Assigner',1,'2016-03-05 00:12:40','2016-03-05 00:12:40','Assign Roles And Permission');
/*!40000 ALTER TABLE `tt_permission` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-08  9:30:10
