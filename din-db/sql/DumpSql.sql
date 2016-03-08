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
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `tt_role`
--

DROP TABLE IF EXISTS `tt_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tt_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `status` int(1) unsigned zerofill DEFAULT '0',
  `type` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `external_name` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `modtime` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tt_role`
--

LOCK TABLES `tt_role` WRITE;
/*!40000 ALTER TABLE `tt_role` DISABLE KEYS */;
INSERT INTO `tt_role` VALUES (1,0,'','Basic User',' ','2016-03-05 00:07:01','2016-03-05 00:07:01','Basic Login Functionality'),(2,0,'','User Administrator',' ','2016-03-05 00:13:03','2016-03-05 00:13:03','User CRUD OPRATIONS');
/*!40000 ALTER TABLE `tt_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tt_system_audit`
--

DROP TABLE IF EXISTS `tt_system_audit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tt_system_audit` (
  `audit_id` varchar(255) NOT NULL,
  `audit_ref` varchar(255) DEFAULT NULL,
  `audittype` int(11) NOT NULL,
  `createtime` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`audit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tt_system_audit`
--

LOCK TABLES `tt_system_audit` WRITE;
/*!40000 ALTER TABLE `tt_system_audit` DISABLE KEYS */;
/*!40000 ALTER TABLE `tt_system_audit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tt_user`
--

DROP TABLE IF EXISTS `tt_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tt_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `blocked` int(11) NOT NULL,
  `blockedtime` datetime DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `dob` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `modtime` datetime DEFAULT NULL,
  `no_attempt` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` int(1) unsigned zerofill NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tt_user`
--

LOCK TABLES `tt_user` WRITE;
/*!40000 ALTER TABLE `tt_user` DISABLE KEYS */;
INSERT INTO `tt_user` VALUES (1,0,NULL,NULL,'25/01/1980','d@d.com','dinkar','m','sharma','din','','2015-01-18 23:20:26',0,'1234',0);
/*!40000 ALTER TABLE `tt_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-08  9:33:27
