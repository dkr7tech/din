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
-- Table structure for table `tl_user_role`
--

DROP TABLE IF EXISTS `tl_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tl_user_role` (
  `tl_user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`tl_user_role_id`),
  KEY `FK5gd6ki0143rdfe3yo2w2uq65a` (`role_id`),
  KEY `FKpgbxcy3i3kqtlp8s6v24q2wal` (`user_id`),
  CONSTRAINT `FK5gd6ki0143rdfe3yo2w2uq65a` FOREIGN KEY (`role_id`) REFERENCES `tt_role` (`role_id`),
  CONSTRAINT `FKpgbxcy3i3kqtlp8s6v24q2wal` FOREIGN KEY (`user_id`) REFERENCES `tt_user` (`user_id`),
  CONSTRAINT `FK_48q69d45mcfm32yxhve9ynhnk` FOREIGN KEY (`role_id`) REFERENCES `tt_role` (`role_id`),
  CONSTRAINT `FK_mhfyx0iqd5dc8c96mlc4270ds` FOREIGN KEY (`user_id`) REFERENCES `tt_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tl_user_role`
--

LOCK TABLES `tl_user_role` WRITE;
/*!40000 ALTER TABLE `tl_user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `tl_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-08  9:30:06
