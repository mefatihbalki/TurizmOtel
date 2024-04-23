-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: patika_turizm
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_featuretype`
--

DROP TABLE IF EXISTS `tbl_featuretype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_featuretype` (
  `id` int NOT NULL AUTO_INCREMENT,
  `feature_name` varchar(150) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_featuretype`
--

LOCK TABLES `tbl_featuretype` WRITE;
/*!40000 ALTER TABLE `tbl_featuretype` DISABLE KEYS */;
INSERT INTO `tbl_featuretype` VALUES (1,'Ücretsiz Otopark'),(2,'7/24 Oda Servisi'),(3,'Fitness Center'),(4,'SPA'),(5,'Ücretsiz WiFi'),(6,'Yüzme havuzu'),(7,'Hotel Concierge');
/*!40000 ALTER TABLE `tbl_featuretype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_hotel`
--

DROP TABLE IF EXISTS `tbl_hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_hotel` (
  `hotel_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `city` varchar(150) NOT NULL,
  `region` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phoneNumber` varchar(15) NOT NULL,
  `stars` int NOT NULL,
  PRIMARY KEY (`hotel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_hotel`
--

LOCK TABLES `tbl_hotel` WRITE;
/*!40000 ALTER TABLE `tbl_hotel` DISABLE KEYS */;
INSERT INTO `tbl_hotel` VALUES (1,'Marmara Hotel','İstanbul','Taksim','Beyoğlu, İstanbul','marmara@gmail','02125058085',3),(2,'Hilton Hotel','İstanbul','Şişli','Harbiye, Cumhuriyet Cd. No:50, 34367 Şişli/İstanbul','hilton@gmail.com','02123406780',4),(3,'kapadokya','nevşehir','kapadokya','Ortahisar/Kapadokya/Nevşehir','kapadokya@gmail.com','021678',4),(4,'Swissotel','İzmir','Alsancak, Konak, İzmir','Konak','swissotel@gmail.com','02325056070',3),(9,'Otel Seyhan','Adana','Seyhan','Seyhan, Turhan Cemal Beriker Blv. Otel Seyhan 20/A, 01120',' fitness@otelseyhan.com.tr',' 4553030',4),(12,'Edis Premier Hotel','Adana','Seyhan',' Zahit Akdağ Blv. No:2, 01360 Çukurova/Adana','premier@hotmail.com',' 0322290',1),(13,'Anemon Hotel','Ankara','Çankaya','Kavaklıdere, Konur Sok. No:60, 06680 Çankaya/Ankara','anemon@hotmail.com','03129502160',3),(14,'Sürmeli Hotels','Adana','Seyhan','Beriker Blv. Otel Seyhan 20/A, 01120',' hotel@sürmeli.com.tr',' 4553030',4),(15,'Vinifera Vineyards Hotel','İzmir','Selçuk','Yedi Bilgeler, 35920 Selçuk/İzmir','vinifre@hotmail.com','894 82 57',5),(16,'Hilton Hotel','İzmir','Konak','İsmet Kaptan, Gazi Osman Paşa Blv. No:7, 35210 Konak/İzmir','izmirhilton@hotmail.com','506874',5),(17,'hilton','kayseri','melikgazi','alpaslan mah kayseri','hilton@gmail','789',3),(22,'Rönesans','İzmir','Konak','Konak, Konak mahallesi','rönesans@rönesans.com','023245698741',4),(23,'İzmir Ege Otel','İzmir','Alsancak','Alsancak mah,1409 sk. no:10','otelege@gmail.com','5368744125',3),(24,'Patika Otel','İzmir','Buca','Buca koop. mah. 1409 sk.','bucali@gmail.com','541575',5);
/*!40000 ALTER TABLE `tbl_hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_hotel_feature`
--

DROP TABLE IF EXISTS `tbl_hotel_feature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_hotel_feature` (
  `hotel_id` int NOT NULL,
  `feature_id` int NOT NULL,
  `feature_name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_hotel_feature`
--

LOCK TABLES `tbl_hotel_feature` WRITE;
/*!40000 ALTER TABLE `tbl_hotel_feature` DISABLE KEYS */;
INSERT INTO `tbl_hotel_feature` VALUES (1,5,'Ücretsiz WİFİ'),(9,7,'Hotel Concierge'),(9,7,'Hotel Concierge'),(1,1,'Ücretsiz Otopark'),(2,2,'7/24 Oda Servisi'),(3,5,'Ücretsiz WiFi'),(4,1,'Ücretsiz Otopark'),(5,4,'Fitness Center'),(12,2,'7/24 Oda Servisi'),(9,8,'Yüzme Havuzu'),(13,1,'Ücretsiz Otopark'),(14,5,'Ücretsiz WiFi'),(15,4,'Fitness Center'),(16,1,'Ücretsiz Otopark'),(16,8,'Yüzme Havuzu'),(12,7,'Hotel Concierge'),(1,6,'Yüzme havuzu'),(1,4,'SPA'),(9,5,'Ücretsiz WiFi'),(17,3,'Fitness Center'),(17,6,'Yüzme havuzu'),(3,5,'Ücretsiz WiFi'),(16,5,'Ücretsiz WiFi'),(9,6,'Yüzme havuzu'),(4,2,'7/24 Oda Servisi'),(15,6,'Yüzme havuzu'),(5,1,'Ücretsiz Otopark'),(2,4,'SPA'),(24,5,'Ücretsiz WiFi'),(24,3,'Fitness Center'),(16,2,'7/24 Oda Servisi'),(16,4,'SPA'),(23,5,'Ücretsiz WiFi'),(22,1,'Ücretsiz Otopark');
/*!40000 ALTER TABLE `tbl_hotel_feature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_hotel_pension`
--

DROP TABLE IF EXISTS `tbl_hotel_pension`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_hotel_pension` (
  `id` int NOT NULL AUTO_INCREMENT,
  `hotel_id` int NOT NULL,
  `pension_id` int NOT NULL,
  `pension_name` varchar(150) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_hotel_pension`
--

LOCK TABLES `tbl_hotel_pension` WRITE;
/*!40000 ALTER TABLE `tbl_hotel_pension` DISABLE KEYS */;
INSERT INTO `tbl_hotel_pension` VALUES (8,13,2,'Tam Pansiyon'),(9,1,6,'Herşey Dahil'),(10,15,2,'Tam Pansiyon'),(11,16,7,'Oda Kahvaltı'),(13,15,7,'Alkol Hariç Full credit'),(16,23,4,'Tam Pansiyon'),(17,23,5,'Yarım Pansiyon'),(18,2,2,'Her Şey Dahil'),(19,24,4,'Tam Pansiyon'),(20,24,5,'Yarım Pansiyon'),(21,24,6,'Sadece Yatak'),(22,5,3,'Oda Kahvaltı'),(23,16,2,'Her Şey Dahil'),(27,23,5,'Yarım Pansiyon'),(29,4,2,'Her Şey Dahil'),(30,4,5,'Yarım Pansiyon'),(33,22,1,'Ultra Her Şey Dahil'),(34,22,2,'Her Şey Dahil');
/*!40000 ALTER TABLE `tbl_hotel_pension` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_hotel_room`
--

DROP TABLE IF EXISTS `tbl_hotel_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_hotel_room` (
  `room_id` int NOT NULL AUTO_INCREMENT,
  `hotel_id` int NOT NULL,
  `season_id` int NOT NULL,
  `pension_id` int NOT NULL,
  `room_type` varchar(150) NOT NULL,
  `bed_number` int NOT NULL,
  `stock` int NOT NULL,
  `price_child` int NOT NULL,
  `price_adult` int NOT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_hotel_room`
--

LOCK TABLES `tbl_hotel_room` WRITE;
/*!40000 ALTER TABLE `tbl_hotel_room` DISABLE KEYS */;
INSERT INTO `tbl_hotel_room` VALUES (1,1,1,1,'Single',70,199,200,300),(2,1,10,2,'Double',10,100,200,500),(3,9,13,3,'King',2,5,700,900),(16,15,14,2,'single',3,5,400,900),(17,1,15,6,'king',4,5,600,800),(18,9,16,5,'junior',3,6,700,1000),(19,1,1,1,'junior king',3,6,500,600),(20,9,16,5,'single',2,5,700,900),(21,9,16,5,'double',2,3,400,600),(22,2,10,1,'King',2,3,1000,2000),(23,23,21,4,'King',2,4,500,1500),(24,24,22,4,'2 Kişilik',2,2,500,1000),(26,16,25,2,'Jumbo',2,10,1000,2500);
/*!40000 ALTER TABLE `tbl_hotel_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_pensiontype`
--

DROP TABLE IF EXISTS `tbl_pensiontype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_pensiontype` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pension_name` varchar(150) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_pensiontype`
--

LOCK TABLES `tbl_pensiontype` WRITE;
/*!40000 ALTER TABLE `tbl_pensiontype` DISABLE KEYS */;
INSERT INTO `tbl_pensiontype` VALUES (1,'Ultra Her Şey Dahil'),(2,'Her Şey Dahil'),(3,'Oda Kahvaltı'),(4,'Tam Pansiyon'),(5,'Yarım Pansiyon'),(6,'Sadece Yatak'),(7,'Alkol Hariç Full credit');
/*!40000 ALTER TABLE `tbl_pensiontype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_reservation`
--

DROP TABLE IF EXISTS `tbl_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_reservation` (
  `reservation_id` int NOT NULL AUTO_INCREMENT,
  `hotel_id` int NOT NULL,
  `room_id` int NOT NULL,
  `customer_name` varchar(150) NOT NULL,
  `customer_tc` varchar(150) NOT NULL,
  `customer_phone` varchar(150) NOT NULL,
  `customer_email` varchar(150) NOT NULL,
  `child_number` int NOT NULL,
  `adult_number` int NOT NULL,
  PRIMARY KEY (`reservation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_reservation`
--

LOCK TABLES `tbl_reservation` WRITE;
/*!40000 ALTER TABLE `tbl_reservation` DISABLE KEYS */;
INSERT INTO `tbl_reservation` VALUES (22,1,1,'ilke','456321','123654','ilke@gmail.com',0,1),(23,9,3,'Emre Arabali','5458211','584566323','emre@emre.com.tr',0,2),(26,24,24,'Yasin','00008888000','5985445','yasin@arabeni.com',0,1),(27,24,24,'said','54545','541541','541541@gmail.com',1,1),(28,23,23,'asdaf','54545','878787','asdaf@gmail.com.tr',0,2),(29,24,24,'ali balkı','55585','54545454','asd@asd.com',1,1);
/*!40000 ALTER TABLE `tbl_reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_room_property`
--

DROP TABLE IF EXISTS `tbl_room_property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_room_property` (
  `room_id` int NOT NULL,
  `property_name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_room_property`
--

LOCK TABLES `tbl_room_property` WRITE;
/*!40000 ALTER TABLE `tbl_room_property` DISABLE KEYS */;
INSERT INTO `tbl_room_property` VALUES (1,'Televizyon'),(2,'Minibar'),(3,'Kasa'),(4,'Ücretsiz Wifi'),(5,'Wifi'),(6,'Oyun Konsolu'),(7,'Projeksiyon'),(20,'televizyon'),(22,'Televizyon'),(24,'Klima'),(24,'Televizyon');
/*!40000 ALTER TABLE `tbl_room_property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_season`
--

DROP TABLE IF EXISTS `tbl_season`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_season` (
  `season_id` int NOT NULL AUTO_INCREMENT,
  `hotel_id` int NOT NULL,
  `season_name` varchar(150) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  PRIMARY KEY (`season_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_season`
--

LOCK TABLES `tbl_season` WRITE;
/*!40000 ALTER TABLE `tbl_season` DISABLE KEYS */;
INSERT INTO `tbl_season` VALUES (1,1,'Kış Sezonu','2024-01-01','2024-05-31'),(10,2,'Yaz sezonu','2024-05-01','2024-09-01'),(11,3,'Yaz sezonu','2024-05-01','2024-09-01'),(12,4,'Kış Sezonu','2024-01-01','2024-05-31'),(14,15,'1','2024-02-01','2024-03-01'),(15,1,'Yaz sezonu','2024-06-06','2024-09-06'),(16,9,'kış sezonu','2024-01-01','2024-09-09'),(17,17,'Yaz Sezonu','2024-06-01','2024-09-01'),(18,3,'Kış sezonu','2024-01-01','2024-06-01'),(19,16,'kış sezonu','2024-01-01','2024-05-01'),(20,9,'yaz sezonu','2024-06-01','2024-09-01'),(21,23,'Yaz Sezonu','2024-01-01','2024-06-01'),(22,24,'Yaz Sezon','2024-01-01','2024-05-31'),(24,12,'winter','2025-02-01','2025-05-01'),(25,16,'Yaz Sezonu','2024-06-01','2024-09-30');
/*!40000 ALTER TABLE `tbl_season` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user`
--

DROP TABLE IF EXISTS `tbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tcNo` varchar(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `usertype` enum('admin','employee','user') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user`
--

LOCK TABLES `tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` VALUES (1,'3578','Fatih','541','Fatih','Balkı','employee'),(2,'4555','İlke','29','İlke','Balkı','admin'),(26,'5590621','admin','admin','Yönetici','Yönetici','admin'),(27,'545454','selami','sel1','selami','hello','admin'),(29,'5454','asddas','asddas','asddas','asddas','employee'),(30,'5454','asd','da','asss','assdd','employee');
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'patika_turizm'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-23 22:24:31
