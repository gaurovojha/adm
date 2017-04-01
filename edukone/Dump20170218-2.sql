CREATE DATABASE  IF NOT EXISTS `ng` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ng`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ng
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `board` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `desc` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,'CBSE',NULL),(2,'ICSE',NULL);
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Pune','Maharashtra','India'),(2,'Indore','Madhya Pradesh','India');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facility`
--

DROP TABLE IF EXISTS `facility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facility` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `desc` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility`
--

LOCK TABLES `facility` WRITE;
/*!40000 ALTER TABLE `facility` DISABLE KEYS */;
INSERT INTO `facility` VALUES (1,'Sports',NULL),(2,'Pick-up and drop',NULL),(3,'Air conditioned classes',NULL),(4,'Library',NULL),(5,'Hostel',NULL),(6,'Auditorium',NULL),(7,'Cafeteria',NULL),(8,'Gym',NULL),(9,'Computer lab',NULL);
/*!40000 ALTER TABLE `facility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `institute`
--

DROP TABLE IF EXISTS `institute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `institute` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `about_us` varchar(400) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `contacts` bigint(20) DEFAULT NULL,
  `established_on` date DEFAULT NULL,
  `website` varchar(45) DEFAULT NULL,
  `ownership` varchar(45) DEFAULT NULL,
  `faculties` int(11) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `zip_code` varchar(45) DEFAULT NULL,
  `facility` varchar(200) DEFAULT NULL,
  `city` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs82euwfte35lwconf3eva3e8v` (`city_id`),
  CONSTRAINT `FK_bek6770wuhiqrwy5pce40bg6b` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`),
  CONSTRAINT `FKs82euwfte35lwconf3eva3e8v` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `institute`
--

LOCK TABLES `institute` WRITE;
/*!40000 ALTER TABLE `institute` DISABLE KEYS */;
INSERT INTO `institute` VALUES (1,'Delhi Public School','DPS Pune is one of the most trusted name in quality education, which is recognized throughout the academic world for its progressive approach and commitment to excellence.','Vill. Mohammadwadi, Nyati County, Pune - 411060',2026970412,'2008-01-02','http://www.dpspune.com/','private',32,1,'411060','1,2,3',NULL),(2,'VIBGYOR','VIBGYOR High, Magarpatta aims to provide education for the all-round development of its studentsadd','Vibgyor High Survey No.130, Plot No.MP4, Opp.Megameals. Near West Gate, ',2069000500,'2014-02-09','https://www.vibgyorhigh.com','private',20,1,'411013','2,3,4',NULL);
/*!40000 ALTER TABLE `institute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `institute_offering`
--

DROP TABLE IF EXISTS `institute_offering`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `institute_offering` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fees` int(11) DEFAULT NULL,
  `institute_id` int(11) DEFAULT NULL,
  `institute_offering_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `institute_id_idx` (`institute_id`),
  KEY `institute_type_id_idx` (`institute_offering_id`),
  CONSTRAINT `FKn84b15mp7q8n2kjyn2acjm8vn` FOREIGN KEY (`institute_id`) REFERENCES `institute` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FKobxab8r9itqqo1wuoiouk8r21` FOREIGN KEY (`institute_offering_id`) REFERENCES `offering` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `institute_offering`
--

LOCK TABLES `institute_offering` WRITE;
/*!40000 ALTER TABLE `institute_offering` DISABLE KEYS */;
INSERT INTO `institute_offering` VALUES (1,1000,1,2),(2,2000,1,3),(3,3000,1,4),(4,2000,2,2);
/*!40000 ALTER TABLE `institute_offering` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `institute_type`
--

DROP TABLE IF EXISTS `institute_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `institute_type` (
  `institute_id` int(11) NOT NULL,
  `institute_type_id` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `institute_type_id_idx` (`institute_type_id`),
  KEY `institute_id_idx` (`institute_id`),
  CONSTRAINT `FK1qmqsdpwcyiwl66s98vpn91cy` FOREIGN KEY (`institute_id`) REFERENCES `institute` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FKjap8i3bgml1vqi7au5v1hfn21` FOREIGN KEY (`institute_type_id`) REFERENCES `type` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `institute_type`
--

LOCK TABLES `institute_type` WRITE;
/*!40000 ALTER TABLE `institute_type` DISABLE KEYS */;
INSERT INTO `institute_type` VALUES (1,1,1),(1,2,2),(2,2,3);
/*!40000 ALTER TABLE `institute_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offering`
--

DROP TABLE IF EXISTS `offering`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offering` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `type` FOREIGN KEY (`id`) REFERENCES `type` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offering`
--

LOCK TABLES `offering` WRITE;
/*!40000 ALTER TABLE `offering` DISABLE KEYS */;
INSERT INTO `offering` VALUES (1,'Play School',NULL),(2,'Primary',NULL),(3,'Secondary',NULL),(4,'Higher Secondary',NULL);
/*!40000 ALTER TABLE `offering` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `country` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `desc` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,'Play School',NULL),(2,'School',NULL),(3,'College',NULL),(4,'Coaching',NULL);
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-18 19:01:23
