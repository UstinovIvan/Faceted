CREATE DATABASE  IF NOT EXISTS `stankin_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `stankin_db`;
-- MySQL dump 10.13  Distrib 5.7.24, for macos10.14 (x86_64)
--
-- Host: localhost    Database: stankin_db
-- ------------------------------------------------------
-- Server version	5.7.24

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
-- Table structure for table `APP_ROLE`
--

DROP TABLE IF EXISTS `APP_ROLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `APP_ROLE` (
  `ROLE_ID` bigint(20) NOT NULL,
  `ROLE_NAME` varchar(30) NOT NULL,
  PRIMARY KEY (`ROLE_ID`),
  UNIQUE KEY `APP_ROLE_UK` (`ROLE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `APP_ROLE`
--

LOCK TABLES `APP_ROLE` WRITE;
/*!40000 ALTER TABLE `APP_ROLE` DISABLE KEYS */;
INSERT INTO `APP_ROLE` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `APP_ROLE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `APP_USER`
--

DROP TABLE IF EXISTS `APP_USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `APP_USER` (
  `USER_ID` bigint(20) NOT NULL,
  `USER_NAME` varchar(36) NOT NULL,
  `ENCRYTED_PASSWORD` varchar(128) NOT NULL,
  `ENABLED` bit(1) NOT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `APP_USER_UK` (`USER_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `APP_USER`
--

LOCK TABLES `APP_USER` WRITE;
/*!40000 ALTER TABLE `APP_USER` DISABLE KEYS */;
INSERT INTO `APP_USER` VALUES (3,'116453','$2a$10$kzpJ85Mb6CcW.MFbd.BzvOfnmWcQ.lt03iVz5AktXQKtuSK6PSJgu',_binary ''),(4,'116454','$2a$10$196W/Xa6S42NZcdfN1o07OTpY9HIOQ2kmQxHGWEP5IqlTMcvjRx3i',_binary ''),(5,'116455','$2a$10$dJH5mLSHTsh1DuprUUxbBO6Q.p4zH0nBiVD5AlGyxszIuZjGrbt06',_binary ''),(6,'116456','$2a$10$Tmx/Ec0U8wNtnEZOUJa4E.2VRmeuJn7AZwPKCM6e6Y93xbf46Owpq',_binary ''),(7,'116457','$2a$10$i1D3t5ejvS8Nkcynzm72SOCR/k/ql1/ilVzN8oZBSZ7jY86jzdWXW',_binary ''),(8,'116458','$2a$10$audYBL3EoumbTfJBXakbN.AD5Cg5sCPDSTW0GAW10ixBtC6tCNP0i',_binary ''),(9,'116459','$2a$10$IYupAklCg4dRIfyg9qCio.6dZb5zTRv5IXf98yWngQ90Ely7jrojG',_binary ''),(10,'116460','$2a$10$6QZG5TX7A/05LSIkbZUqo.9xCf3yD.YhM4Cz4hPzErwWmSKsk9Rd.',_binary '');
/*!40000 ALTER TABLE `APP_USER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DAYS`
--

DROP TABLE IF EXISTS `DAYS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DAYS` (
  `DAY_ID` int(11) NOT NULL,
  `DESCRIPTION` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DAYS`
--

LOCK TABLES `DAYS` WRITE;
/*!40000 ALTER TABLE `DAYS` DISABLE KEYS */;
INSERT INTO `DAYS` VALUES (1,'Понедельник'),(2,'Вторник'),(3,'Среда'),(4,'Четверг'),(5,'Пятница'),(6,'Суббота');
/*!40000 ALTER TABLE `DAYS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GROUPS`
--

DROP TABLE IF EXISTS `GROUPS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GROUPS` (
  `GROUP_ID` int(11) NOT NULL,
  `GROUP_NAME` varchar(100) NOT NULL,
  PRIMARY KEY (`GROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GROUPS`
--

LOCK TABLES `GROUPS` WRITE;
/*!40000 ALTER TABLE `GROUPS` DISABLE KEYS */;
INSERT INTO `GROUPS` VALUES (1,'ИДБ-16-02');
/*!40000 ALTER TABLE `GROUPS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Persistent_Logins`
--

DROP TABLE IF EXISTS `Persistent_Logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Persistent_Logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Persistent_Logins`
--

LOCK TABLES `Persistent_Logins` WRITE;
/*!40000 ALTER TABLE `Persistent_Logins` DISABLE KEYS */;
/*!40000 ALTER TABLE `Persistent_Logins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `REQUESTS`
--

DROP TABLE IF EXISTS `REQUESTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `REQUESTS` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TICKET_FROM` int(11) NOT NULL,
  `REQUEST_TYPE` int(11) NOT NULL,
  `APPLICATION_DATE` datetime NOT NULL,
  `CLOSING_DATE` datetime DEFAULT NULL,
  `REQUEST_STATUS` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `REQUESTS`
--

LOCK TABLES `REQUESTS` WRITE;
/*!40000 ALTER TABLE `REQUESTS` DISABLE KEYS */;
INSERT INTO `REQUESTS` VALUES (7,116453,1,'2019-02-24 23:14:15',NULL,1),(8,116453,2,'2019-02-24 23:14:19',NULL,3),(9,116453,3,'2019-02-24 23:14:23',NULL,1),(10,116453,4,'2019-02-24 23:14:28',NULL,4),(11,116453,1,'2019-02-24 23:48:34',NULL,1),(12,116453,3,'2019-02-24 23:48:38',NULL,2),(13,116453,4,'2019-02-24 23:48:43',NULL,1),(14,116453,2,'2019-02-25 01:55:18',NULL,1),(15,116453,3,'2019-02-25 12:38:24',NULL,1),(16,116460,2,'2019-02-25 12:38:58',NULL,1),(17,116455,3,'2019-02-25 12:43:40',NULL,1);
/*!40000 ALTER TABLE `REQUESTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SCHEDULE`
--

DROP TABLE IF EXISTS `SCHEDULE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SCHEDULE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DAY_ID` int(11) NOT NULL,
  `GROUP_ID` int(11) NOT NULL,
  `SUBJECT_ID` int(11) NOT NULL,
  `TIME_ID` int(11) NOT NULL,
  `CLASSROOM` varchar(45) NOT NULL,
  `TEACHER_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `GROUP_FK_idx` (`GROUP_ID`),
  KEY `SUBJECT_FK_idx` (`SUBJECT_ID`),
  KEY `TEACHER_ID_FK_idx` (`TEACHER_ID`),
  CONSTRAINT `GROUP_FK` FOREIGN KEY (`GROUP_ID`) REFERENCES `GROUPS` (`GROUP_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `SUBJECT_FK` FOREIGN KEY (`SUBJECT_ID`) REFERENCES `SUBJECTS` (`SUBJECT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `TEACHER_ID_FK` FOREIGN KEY (`TEACHER_ID`) REFERENCES `TEACHERS` (`TEACHER_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SCHEDULE`
--

LOCK TABLES `SCHEDULE` WRITE;
/*!40000 ALTER TABLE `SCHEDULE` DISABLE KEYS */;
INSERT INTO `SCHEDULE` VALUES (1,1,1,1,3,'0406',1),(2,1,1,2,4,'0207',2),(3,2,1,1,1,'313',1),(4,2,1,1,2,'313',1),(5,2,1,3,3,'240(б)',3),(6,2,1,4,4,'0204',4),(7,3,1,5,3,'Спортзал',5),(8,3,1,6,4,'0409',6),(9,4,1,7,4,'305',7),(10,5,1,7,4,'0812',7),(11,5,1,3,5,'313',8),(12,5,1,3,6,'313',8),(13,6,1,3,1,'306а',3),(14,6,1,8,2,'409',9),(15,6,1,8,3,'0409',9),(16,6,1,1,4,'0808',1);
/*!40000 ALTER TABLE `SCHEDULE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `STATUS_REQUESTS`
--

DROP TABLE IF EXISTS `STATUS_REQUESTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `STATUS_REQUESTS` (
  `ID` int(11) NOT NULL,
  `DESCRIPTION` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `STATUS_REQUESTS`
--

LOCK TABLES `STATUS_REQUESTS` WRITE;
/*!40000 ALTER TABLE `STATUS_REQUESTS` DISABLE KEYS */;
INSERT INTO `STATUS_REQUESTS` VALUES (1,'Подана'),(2,'Принята в обработку'),(3,'Выполнена'),(4,'Не прошла обработку');
/*!40000 ALTER TABLE `STATUS_REQUESTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SUBJECTS`
--

DROP TABLE IF EXISTS `SUBJECTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SUBJECTS` (
  `SUBJECT_ID` int(11) NOT NULL,
  `SUBJECT_NAME` varchar(100) NOT NULL,
  PRIMARY KEY (`SUBJECT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SUBJECTS`
--

LOCK TABLES `SUBJECTS` WRITE;
/*!40000 ALTER TABLE `SUBJECTS` DISABLE KEYS */;
INSERT INTO `SUBJECTS` VALUES (1,'Функциональное логическое программирование'),(2,'Системы цифровой обработки изображений'),(3,'Оптимальное планирование и управление производством'),(4,'Компьютерная графика'),(5,'Физкультура'),(6,'WEB программирование'),(7,'Теория массового обслуживания'),(8,'Метрология стандартизация и сертификация');
/*!40000 ALTER TABLE `SUBJECTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TEACHERS`
--

DROP TABLE IF EXISTS `TEACHERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TEACHERS` (
  `TEACHER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TEACHER_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`TEACHER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TEACHERS`
--

LOCK TABLES `TEACHERS` WRITE;
/*!40000 ALTER TABLE `TEACHERS` DISABLE KEYS */;
INSERT INTO `TEACHERS` VALUES (1,'Стоякова К.Л.'),(2,'Гаврилов А.Г'),(3,'Фролов Е.Б.'),(4,'Болдарев А.С.'),(5,'Волкова Г.Л.'),(6,'Ефромеев Н.М.'),(7,'Климанов В.П.'),(8,'Комиссаров Р.Н'),(9,'Сильвестрова Е.Э.');
/*!40000 ALTER TABLE `TEACHERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TYPES_REQUESTS`
--

DROP TABLE IF EXISTS `TYPES_REQUESTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TYPES_REQUESTS` (
  `ID` int(11) NOT NULL,
  `DESCRIPTION` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TYPES_REQUESTS`
--

LOCK TABLES `TYPES_REQUESTS` WRITE;
/*!40000 ALTER TABLE `TYPES_REQUESTS` DISABLE KEYS */;
INSERT INTO `TYPES_REQUESTS` VALUES (1,'Справка о факте обучения в университете'),(2,'Справка о факте обучения в университете (для пенсионного фонда)'),(3,'Получение квитанции на оплату за проживание в общежитии'),(4,'Получить допуск до экзамена');
/*!40000 ALTER TABLE `TYPES_REQUESTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_ROLE`
--

DROP TABLE IF EXISTS `USER_ROLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_ROLE` (
  `ID` bigint(20) NOT NULL,
  `USER_ID` bigint(20) NOT NULL,
  `ROLE_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USER_ROLE_UK` (`USER_ID`,`ROLE_ID`),
  KEY `USER_ROLE_FK2` (`ROLE_ID`),
  CONSTRAINT `USER_ROLE_FK1` FOREIGN KEY (`USER_ID`) REFERENCES `APP_USER` (`USER_ID`),
  CONSTRAINT `USER_ROLE_FK2` FOREIGN KEY (`ROLE_ID`) REFERENCES `APP_ROLE` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_ROLE`
--

LOCK TABLES `USER_ROLE` WRITE;
/*!40000 ALTER TABLE `USER_ROLE` DISABLE KEYS */;
INSERT INTO `USER_ROLE` VALUES (4,3,2),(5,4,2),(6,5,2),(7,6,2),(8,7,2),(9,8,2),(10,9,2),(11,10,2);
/*!40000 ALTER TABLE `USER_ROLE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `TICKET` int(11) NOT NULL,
  `SURNAME` varchar(100) NOT NULL,
  `SNAME` varchar(100) NOT NULL,
  `PATRONYMIC` varchar(100) DEFAULT NULL,
  `BIRTH_DATE` date NOT NULL,
  `GROUP_ID` int(11) NOT NULL,
  `BUDGET` varchar(10) NOT NULL,
  `HOSTEL` varchar(10) DEFAULT NULL,
  `TELEPHONE` varchar(1000) DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `RATING` int(11) DEFAULT NULL,
  `level` varchar(100) NOT NULL,
  PRIMARY KEY (`TICKET`),
  KEY `GROUP_ID_FK_idx` (`GROUP_ID`),
  CONSTRAINT `GROUP_ID_FK` FOREIGN KEY (`GROUP_ID`) REFERENCES `GROUPS` (`GROUP_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (116453,'Устинов','Иван','Сергеевич','1996-02-28',1,'Контракт','','88005553535','sdfkjn@gmail.com',54,'Бакалавр'),(116454,'Савинов','Александр','Константинович','1996-02-28',1,'Бюджет','8','89463782847','sdfkjn@gmail.com',54,'Бакалавр'),(116455,'Соловьева','Александра','Алексеевна','1996-02-28',1,'Бюджет','','84643637373','sdfkjn@gmail.com',54,'Бакалавр'),(116456,'Солодянкин','Денис','Александрович','1995-02-21',1,'Бюджет','8','23423423243','sdfkjn@gmail.com',54,'Бакалавр'),(116457,'Суворова','Мария','Антоновна','1996-02-28',1,'Бюджет','','24342634587','sdfkjn@gmail.com',54,'Бакалавр'),(116458,'Толбузов','Михаил','Викторович','1994-02-28',1,'Бюджет','','87654432444','sdfkjn@gmail.com',54,'Бакалавр'),(116459,'Ряскина','Анна','Александровна','1996-02-28',1,'Бюджет','8','85656756564','sdfkjn@gmail.com',54,'Бакалавр'),(116460,'Федотов','Иван','Андреевич','2000-04-21',1,'Бюджет','','84824723783','sdfkjn@gmail.com',35,'Хуесос');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'stankin_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-18 22:23:04
