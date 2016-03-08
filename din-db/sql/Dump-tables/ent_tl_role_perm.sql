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
-- Table structure for table `tl_role_perm`
--

DROP TABLE IF EXISTS `tl_role_perm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tl_role_perm` (
  `role_perm_id` int(11) NOT NULL AUTO_INCREMENT,
  `perm_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `permission` tinyblob,
  `role` tinyblob,
  PRIMARY KEY (`role_perm_id`),
  UNIQUE KEY `UK_rlojwvb3upoi60c29kjm52iti` (`perm_id`),
  KEY `FK9kjo8w3ccqqd0s0690b7iwct9` (`role_id`),
  CONSTRAINT `FK9kjo8w3ccqqd0s0690b7iwct9` FOREIGN KEY (`role_id`) REFERENCES `tt_role` (`role_id`),
  CONSTRAINT `FKdn0qh0476cqvc1tiuwjpm21sm` FOREIGN KEY (`perm_id`) REFERENCES `tt_permission` (`perm_id`),
  CONSTRAINT `FK_tne7v25yckij0nqd7g5vuf6rp` FOREIGN KEY (`role_id`) REFERENCES `tt_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tl_role_perm`
--

LOCK TABLES `tl_role_perm` WRITE;
/*!40000 ALTER TABLE `tl_role_perm` DISABLE KEYS */;
INSERT INTO `tl_role_perm` VALUES (2,1,1,NULL,NULL),(3,2,2,NULL,NULL),(4,3,2,NULL,NULL),(5,4,2,NULL,NULL),(6,5,2,NULL,NULL),(7,6,2,NULL,NULL);
/*!40000 ALTER TABLE `tl_role_perm` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-08  9:30:07
