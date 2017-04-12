-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: ces
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `gene`
--

DROP TABLE IF EXISTS `gene`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gene` (
  `uuid` varchar(32) NOT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `value` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `score`
--

DROP TABLE IF EXISTS `score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `score` (
  `uuid` varchar(32) NOT NULL,
  `score_id` varchar(100) NOT NULL,
  `number` varchar(100) DEFAULT NULL,
  `gene_code` varchar(100) DEFAULT NULL,
  `gene_name` varchar(100) DEFAULT NULL,
  `gene_type` varchar(100) DEFAULT NULL,
  `explosive_force` varchar(100) DEFAULT NULL,
  `explosive_force_score` double(100,0) DEFAULT NULL,
  `stamina` varchar(100) DEFAULT NULL,
  `stamina_score` double(100,0) DEFAULT NULL,
  `motion_sensitivity` varchar(100) DEFAULT NULL,
  `motion_sensitivity_score` double(100,0) DEFAULT NULL,
  `injury_recovery_ability` varchar(100) DEFAULT NULL,
  `injury_recovery_ability_score` double(100,0) DEFAULT NULL,
  `injury_risk` varchar(100) DEFAULT NULL,
  `injury_risk_score` double(100,0) DEFAULT NULL,
  `obesity_risk` varchar(100) DEFAULT NULL,
  `obesity_risk_score` double(100,0) DEFAULT NULL,
  `fat_reducing_sensitivity` varchar(100) DEFAULT NULL,
  `fat_reducing_sensitivity_score` double(100,0) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `uuid` varchar(32) NOT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `position_384` varchar(100) DEFAULT NULL,
  `star` varchar(1) DEFAULT NULL COMMENT '1运动员2用户数据',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_score`
--

DROP TABLE IF EXISTS `user_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_score` (
  `uuid` varchar(32) NOT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `gene_uuid` varchar(100) DEFAULT NULL,
  `score_uuid` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-12 10:18:07
