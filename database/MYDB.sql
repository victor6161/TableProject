-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `reader_id` int(11) NOT NULL,
  `writer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_book_reader_idx` (`reader_id`),
  KEY `fk_book_writer1_idx` (`writer_id`),
  CONSTRAINT `fk_book_reader` FOREIGN KEY (`reader_id`) REFERENCES `reader` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_book_writer1` FOREIGN KEY (`writer_id`) REFERENCES `writer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'green mile','11',2,1),(2,'Eugene Onegin','11',1,5),(3,'Call of the wild','9',3,2),(4,'shine','19',2,2),(10,'Ruslan and Ludmila','7',2,5),(11,'sea dog','151',2,2),(13,'The Stand','13',2,1),(14,'Martin Eden','8',2,2),(15,'The Hills of Georgia','12',2,5),(16,'Elegy','8',2,5),(21,'test','21',2,19),(22,'kniga ilay','20',2,48),(23,'Adventures of Huckleberry Finn','33',2,3),(24,'Adventures of Huckleberry Finn','33',2,3),(25,'Adventures of Huckleberry Finn','33',2,3),(26,'Adventures of Huckleberry Finn','33',2,3),(27,'testbook','21',2,19),(28,'eee','12',2,2),(29,'testbook','33',2,19),(30,'rrr','222',2,39),(31,'asd','23',2,30),(32,'asd','3',2,36),(33,'sd','21',2,19),(34,'as','21',2,26),(35,'hhh','5',2,1),(36,'asd','33',2,34),(37,'tuman','33',2,1);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reader`
--

DROP TABLE IF EXISTS `reader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reader` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `date_registration` date DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `login` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_reader_role_idx` (`role_id`),
  CONSTRAINT `fk_reader_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reader`
--

LOCK TABLES `reader` WRITE;
/*!40000 ALTER TABLE `reader` DISABLE KEYS */;
INSERT INTO `reader` VALUES (1,'not booked',NULL,NULL,'password4567',NULL,NULL,NULL),(2,'viktor','ivanov',NULL,'password2345',1,'login2',NULL),(3,'vasiliy','petrov',NULL,'password3456',2,'login3',NULL),(4,'evgenii','rodionov',NULL,'password4567',1,'login4',NULL),(5,'ivan','ivanich',NULL,'rrr123',1,'rrr',NULL),(6,'','',NULL,'123',1,'rrr',NULL),(7,'','',NULL,'123',1,'acab',NULL),(8,'','',NULL,'123',1,'acab',NULL),(9,'','',NULL,'123',1,'test',NULL),(10,'','',NULL,'MTIz',1,'eee',NULL),(11,'','',NULL,'MTIz',2,'testSalt',NULL),(12,'','',NULL,'dGVzdFZhbA==',1,'testVal',NULL);
/*!40000 ALTER TABLE `reader` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'reader'),(2,'admin');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `writer`
--

DROP TABLE IF EXISTS `writer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `writer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `writer`
--

LOCK TABLES `writer` WRITE;
/*!40000 ALTER TABLE `writer` DISABLE KEYS */;
INSERT INTO `writer` VALUES (1,'Stephen','king','USA'),(2,'Jack','London','USA'),(3,'Mark','Twain','USA'),(5,'alex','Pushkin','Russia'),(6,'Ivan','Turgenev','Russia'),(7,'Yanka','Kupalaa','Belarus'),(11,'yakub','Kolas','Belarus'),(19,'test','testr','teste'),(20,'rrr','rrr','rrr'),(21,'111','111','111'),(22,'222','222','222'),(23,'123','123','123'),(24,'rrr','rrrrrrrrrrrrrr','rrr'),(25,'olha','olha','olha'),(26,'yala','yala','ya'),(27,'aaa','aaa','aa'),(28,'hhh','hhh','hhh'),(29,'eee','eee','eee'),(30,'re','re','re'),(31,'ddd','ddd','ddd'),(32,'asd','dfg','dsf'),(33,'fff','fff','fff'),(34,'sad','sda','df'),(35,'gggg','ccc','cccc'),(36,'fff','sss','bbb'),(37,'zzzz','sss','dddd'),(38,'asd','das','dsf'),(39,'testtesttest','testtesttest','testtesttest'),(40,'sd','asd','sd'),(41,'xcv','asd','asd'),(42,'xc','sd','asd'),(43,'ter','ret','ter'),(44,'aka-47','aka-47','aka-47'),(45,'troli','live','in a hostel'),(46,'гномы','живут ','под землей'),(47,'nanana','nanana','nanan'),(48,'Feodor','Dostoeeeeeeeeeeeeevsky',NULL),(49,'asd','dsdf','sdf'),(50,'asd','sdf','asd'),(51,'qe','wer','12');
/*!40000 ALTER TABLE `writer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-28 20:27:11
