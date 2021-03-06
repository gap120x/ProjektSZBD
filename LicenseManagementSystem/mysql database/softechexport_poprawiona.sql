-- MariaDB dump 10.17  Distrib 10.4.14-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: softech
-- ------------------------------------------------------
-- Server version	10.4.14-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) NOT NULL,
  `text` longtext NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (2,'Siemens PLM Software wprowadza nową mobilną aplikację dla Teamcenter','Siemens PLM Software, wiodący światowy dostawca oprogramowania do zarządzania cyklem życia produktu, poinformował o udostępnieniu w sklepie Apple App Store aplikacji Teamcenter AppShare na iPada.\r\n\r\nTa nowa aplikacja z linii mobilnych aplikacji PLM od Siemens PLM Software umożliwia użytkownikom jeszcze sprawniejszą współpracę z dowolnego miejsca z dostępem do mobilnego internetu. Dzięki Teamcenter AppShare na iPada użytkownicy mogą dołączyć do istniejących sesji AppShare, korzystając z opcji współdzielenia ekranu. W ten sposób ich ekran będzie wyświetlał zawartość ekranu współpracowników.\r\nDołozona została dodatkowa treść..... cos tam cos tam');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billing_address`
--

DROP TABLE IF EXISTS `billing_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billing_address` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Street` varchar(255) NOT NULL,
  `City` varchar(255) NOT NULL,
  `Postal_Code` varchar(255) NOT NULL,
  `Country` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billing_address`
--

LOCK TABLES `billing_address` WRITE;
/*!40000 ALTER TABLE `billing_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `billing_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bonus`
--

DROP TABLE IF EXISTS `bonus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bonus` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Description` varchar(255) DEFAULT NULL,
  `Date` date NOT NULL,
  `BonusAmount` float NOT NULL,
  `Salary_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Salary_id` (`Salary_id`),
  CONSTRAINT `bonus_ibfk_1` FOREIGN KEY (`Salary_id`) REFERENCES `salary` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bonus`
--

LOCK TABLES `bonus` WRITE;
/*!40000 ALTER TABLE `bonus` DISABLE KEYS */;
/*!40000 ALTER TABLE `bonus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `complaint`
--

DROP TABLE IF EXISTS `complaint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `complaint` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Order_id` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Order_id` (`Order_id`),
  CONSTRAINT `complaint_ibfk_1` FOREIGN KEY (`Order_id`) REFERENCES `orders` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complaint`
--

LOCK TABLES `complaint` WRITE;
/*!40000 ALTER TABLE `complaint` DISABLE KEYS */;
/*!40000 ALTER TABLE `complaint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `ID` bigint(20) NOT NULL,
  `VAT` varchar(255) DEFAULT NULL,
  `nip` varchar(255) DEFAULT NULL,
  `Discount` float DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `Billing_Address_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Billing_Address_ID` (`Billing_Address_ID`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`Billing_Address_ID`) REFERENCES `billing_address` (`ID`),
  CONSTRAINT `customer_ibfk_2` FOREIGN KEY (`ID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (4,'1234567890','6462933516',0,'Softwareaholic',NULL),(5,'1232567890','23134123',0,'Test Company',NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_service_user`
--

DROP TABLE IF EXISTS `customer_service_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_service_user` (
  `ID` bigint(20) NOT NULL,
  `Sales_target_value` float DEFAULT NULL,
  `Sales_target_licenses` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `customer_service_user_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `employee` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_service_user`
--

LOCK TABLES `customer_service_user` WRITE;
/*!40000 ALTER TABLE `customer_service_user` DISABLE KEYS */;
INSERT INTO `customer_service_user` VALUES (2,0,0),(3,20000,100);
/*!40000 ALTER TABLE `customer_service_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `leader` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'Dział Sprzedaży Oprogramowania','Michał Kowalski'),(2,'Dział do Optymalizacji Treści','');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `ID` bigint(20) NOT NULL,
  `employment_date` date DEFAULT NULL,
  `Position` varchar(255) NOT NULL,
  `Basic_salary` float DEFAULT NULL,
  `Working_hours` int(11) DEFAULT NULL,
  `department_id` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `department_id` (`department_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`ID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (2,'2020-06-05','Menedżer',8500,140,1),(3,'2021-01-01','Sprzedawca ds. klientów kluczowych',4300,160,1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `license`
--

DROP TABLE IF EXISTS `license`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `license` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `License_Key` varchar(255) NOT NULL,
  `Release_Date` date NOT NULL,
  `Expiration_Date` date NOT NULL,
  `Product_ID` bigint(20) NOT NULL,
  `Customer_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Product_ID` (`Product_ID`),
  KEY `Customer_ID` (`Customer_ID`),
  CONSTRAINT `license_ibfk_1` FOREIGN KEY (`Product_ID`) REFERENCES `product` (`ID`),
  CONSTRAINT `license_ibfk_2` FOREIGN KEY (`Customer_ID`) REFERENCES `customer` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `license`
--

LOCK TABLES `license` WRITE;
/*!40000 ALTER TABLE `license` DISABLE KEYS */;
INSERT INTO `license` VALUES (1,'6KTFN-PQH9H T8MMB-YG8K4-367TX','2021-01-13','2022-01-14',1,4);
/*!40000 ALTER TABLE `license` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `Description` text NOT NULL,
  `status` varchar(255) NOT NULL,
  `recipient` varchar(255) NOT NULL,
  `User_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `User_ID` (`User_ID`),
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`User_ID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monthly_timesheet`
--

DROP TABLE IF EXISTS `monthly_timesheet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `monthly_timesheet` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Hours` int(11) DEFAULT NULL,
  `Overtime_hours` int(11) DEFAULT NULL,
  `date` date NOT NULL,
  `Employee_id` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Employee_id` (`Employee_id`),
  CONSTRAINT `monthly_timesheet_ibfk_1` FOREIGN KEY (`Employee_id`) REFERENCES `employee` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monthly_timesheet`
--

LOCK TABLES `monthly_timesheet` WRITE;
/*!40000 ALTER TABLE `monthly_timesheet` DISABLE KEYS */;
/*!40000 ALTER TABLE `monthly_timesheet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offer`
--

DROP TABLE IF EXISTS `offer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offer` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Expiration_Date` date DEFAULT NULL,
  `Description` longtext DEFAULT NULL,
  `Date` date NOT NULL,
  `Status` varchar(255) DEFAULT NULL,
  `Customer_Service_User_ID` bigint(20) NOT NULL,
  `Customer_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Customer_Service_User_ID` (`Customer_Service_User_ID`),
  KEY `Customer_ID` (`Customer_ID`),
  CONSTRAINT `offer_ibfk_1` FOREIGN KEY (`Customer_Service_User_ID`) REFERENCES `customer_service_user` (`ID`),
  CONSTRAINT `offer_ibfk_2` FOREIGN KEY (`Customer_ID`) REFERENCES `customer` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offer`
--

LOCK TABLES `offer` WRITE;
/*!40000 ALTER TABLE `offer` DISABLE KEYS */;
INSERT INTO `offer` VALUES (1,'2021-01-31','Przedmiotem Oferty są produkty Firmy Softech.\r\nOferta Zawiera:\r\n-Windows XP - Cena 80zł\r\n-Windows 10 - Cena 350zł\r\n-Pakiet Office Cena 450zł','2021-01-13','Przegrana',3,4),(3,'2021-01-31','Przedmiotem Oferty są produkty Firmy Softech.</br> \r\nOferta Zawiera:</br> \r\n-Windows XP - Cena 80zł</br>\r\n-Windows 10 - Cena 350zł </br> \r\n-Pakiet Office Cena 450zł </br>','2021-01-13','Wysłana',3,4);
/*!40000 ALTER TABLE `offer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_date` date NOT NULL,
  `total_price` float NOT NULL,
  `Customer_Service_User_ID` bigint(20) NOT NULL,
  `Payment_id` bigint(20) DEFAULT NULL,
  `Customer_ID` bigint(20) NOT NULL,
  `Status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Payment_id` (`Payment_id`),
  KEY `Customer_Service_User_ID` (`Customer_Service_User_ID`),
  KEY `idx_customer_id` (`Customer_ID`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`Payment_id`) REFERENCES `payment` (`ID`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`Customer_Service_User_ID`) REFERENCES `customer_service_user` (`ID`),
  CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`Customer_ID`) REFERENCES `customer` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2021-01-13',1199.97,2,NULL,4,'Oczekiwanie na płatność'),(2,'2021-01-13',399.99,2,NULL,4,'Oczekiwanie na płatność'),(3,'2021-01-13',1199.97,3,NULL,4,'Oczekiwanie na płatność'),(4,'2021-01-13',799.98,3,NULL,4,'Oczekiwanie na płatność'),(9,'2021-01-14',0,3,NULL,4,'Oczekiwanie na płatność'),(10,'2021-01-14',1599.96,3,NULL,4,'W Trakcie Tworzenia');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Payment_Date` date NOT NULL,
  `Amount` float NOT NULL,
  `Status` varchar(255) NOT NULL,
  `Currency` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Price` float NOT NULL,
  `Currency` varchar(255) NOT NULL,
  `Software_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Software_ID` (`Software_ID`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`Software_ID`) REFERENCES `software` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,399.99,'PLN',1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_list`
--

DROP TABLE IF EXISTS `product_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_list` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_ID` bigint(20) NOT NULL,
  `Order_ID` bigint(20) NOT NULL,
  `Price` float DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `total_price` float NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Order_ID` (`Order_ID`),
  KEY `product_ID` (`product_ID`),
  CONSTRAINT `product_list_ibfk_1` FOREIGN KEY (`Order_ID`) REFERENCES `orders` (`ID`),
  CONSTRAINT `product_list_ibfk_2` FOREIGN KEY (`product_ID`) REFERENCES `product` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_list`
--

LOCK TABLES `product_list` WRITE;
/*!40000 ALTER TABLE `product_list` DISABLE KEYS */;
INSERT INTO `product_list` VALUES (1,1,1,399.99,3,1199.97),(2,1,2,399.99,1,399.99),(3,1,3,399.99,3,1199.97),(4,1,4,399.99,2,799.98),(9,1,10,399.99,4,1599.96);
/*!40000 ALTER TABLE `product_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salary` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Basic` float NOT NULL,
  `Bonus` float DEFAULT NULL,
  `Total` float NOT NULL,
  `Status` varchar(255) DEFAULT NULL,
  `Payout_date` date DEFAULT NULL,
  `period_start` date DEFAULT NULL,
  `period_end` date DEFAULT NULL,
  `Employee_id` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Employee_id` (`Employee_id`),
  CONSTRAINT `salary_ibfk_1` FOREIGN KEY (`Employee_id`) REFERENCES `employee` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `software`
--

DROP TABLE IF EXISTS `software`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `software` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Release_Date` date DEFAULT NULL,
  `Description` longtext DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `software`
--

LOCK TABLES `software` WRITE;
/*!40000 ALTER TABLE `software` DISABLE KEYS */;
INSERT INTO `software` VALUES (1,'Microsoft Office 2019','2019-03-13',' Pakiet aplikacji biurowych');
/*!40000 ALTER TABLE `software` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `updates`
--

DROP TABLE IF EXISTS `updates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `updates` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Changes` longtext NOT NULL,
  `Date` date NOT NULL,
  `Article_ID` bigint(20) NOT NULL,
  `Customer_Service_User_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Customer_Service_User_ID` (`Customer_Service_User_ID`),
  KEY `Article_ID` (`Article_ID`),
  CONSTRAINT `updates_ibfk_1` FOREIGN KEY (`Customer_Service_User_ID`) REFERENCES `customer_service_user` (`ID`),
  CONSTRAINT `updates_ibfk_2` FOREIGN KEY (`Article_ID`) REFERENCES `article` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `updates`
--

LOCK TABLES `updates` WRITE;
/*!40000 ALTER TABLE `updates` DISABLE KEYS */;
INSERT INTO `updates` VALUES (1,'Stworzenie Artykułu','2021-01-13',2,3),(3,'dodano kolejny akapit o xyzzz','2021-01-13',2,3),(4,'test edycji','2021-01-13',2,3);
/*!40000 ALTER TABLE `updates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Nickname` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Firstname` varchar(255) DEFAULT NULL,
  `Surname` varchar(255) DEFAULT NULL,
  `role` varchar(255) NOT NULL,
  `enabled` tinyint(4) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `idx_usernickname` (`Nickname`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$10$JFnonKMEo7VCCJqbzlWjE.C.PJgVrwhNagVfHbv.dOQBh5s42w79S','admin@gmail.com','admin','admin','ROLE_ADMIN',1),(2,'michal.kowalski','$2a$10$9pZ/8eraYtTD4wJzxck0U.UFQ51AgtwS.pp/d6M4.Xn7ur3vbgVxq','michal.kowalski@softech.com','Michał','Kowalski','ROLE_MANAGER',1),(3,'andrzej.nowak','$2a$10$egtU5TcjO.u1HdjeZ/6bQOILtrx/10V9SLTjs2NWp/iVGaeNTHlA.','andrzej.nowak@softech.com','Andrzej','Nowak','ROLE_CUSTOMERSERVICEUSER',1),(4,'alan.wysocki','$2a$10$EUfEOqzOCdx6uZzzGhxGn.JoCWDvg/r3ATKXUykD7hdPnMnycxVUy','alan.wysocki@Softwareaholic.com','Alan','Wysocki','ROLE_CUSTOMER',1),(5,'lukasz.marzec','$2a$10$ERRQTA73VrXUb4fSG3xIwu.DyR8lyZELO5JgsXcYS8fR4Onw.gvSi','lukasz.marzec@testcompany.com','Łukasz','Marzec','ROLE_CUSTOMER',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workday`
--

DROP TABLE IF EXISTS `workday`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workday` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `Start_time` time DEFAULT NULL,
  `End_time` time DEFAULT NULL,
  `Hours` int(11) DEFAULT NULL,
  `Monthly_timesheet_id` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Monthly_timesheet_id` (`Monthly_timesheet_id`),
  CONSTRAINT `workday_ibfk_1` FOREIGN KEY (`Monthly_timesheet_id`) REFERENCES `monthly_timesheet` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workday`
--

LOCK TABLES `workday` WRITE;
/*!40000 ALTER TABLE `workday` DISABLE KEYS */;
/*!40000 ALTER TABLE `workday` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-14 16:43:15
