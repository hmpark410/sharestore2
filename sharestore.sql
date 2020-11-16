-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: sharestore
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `cart_number` int NOT NULL AUTO_INCREMENT,
  `product_number` int DEFAULT NULL,
  `count` int DEFAULT NULL,
  `member_id` varchar(45) DEFAULT NULL,
  `seller_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cart_number`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `id` varchar(20) NOT NULL,
  `passwd` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `birth_y` int DEFAULT NULL,
  `birth_m` int DEFAULT NULL,
  `birth_d` int DEFAULT NULL,
  `postcode` varchar(45) DEFAULT NULL,
  `roadAddress` varchar(45) DEFAULT NULL,
  `detailAddress` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('aaa','aaa','심현우','01012345678','sim@naver.com','female',2004,8,12,'13485','경기 성남시 분당구 판교로 20','142'),('buyer','qwer1234','홍길동','01048652156','buyer@gmail.com','male',1992,7,16,'03751','서울 서대문구 경기대로3길 4','551');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `order_number` varchar(45) NOT NULL,
  `order_date` varchar(45) DEFAULT NULL,
  `total_price` int DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `member_id` varchar(45) DEFAULT NULL,
  `seller_id` varchar(45) DEFAULT NULL,
  `delivery_date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`order_number`),
  KEY `member_id_idx` (`member_id`),
  KEY `seller_id_idx` (`seller_id`),
  CONSTRAINT `member` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `seller` FOREIGN KEY (`seller_id`) REFERENCES `seller` (`seller_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_product`
--

DROP TABLE IF EXISTS `order_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_product` (
  `order_number` varchar(45) NOT NULL,
  `product_number` int NOT NULL,
  `count` int DEFAULT NULL,
  PRIMARY KEY (`product_number`,`order_number`),
  KEY `product_number_idx` (`product_number`),
  KEY `order_number_idx` (`order_number`),
  CONSTRAINT `order_number` FOREIGN KEY (`order_number`) REFERENCES `order` (`order_number`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `product_number` FOREIGN KEY (`product_number`) REFERENCES `product` (`product_number`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_product`
--

LOCK TABLES `order_product` WRITE;
/*!40000 ALTER TABLE `order_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_number` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `size` varchar(10) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `sub_category` varchar(45) DEFAULT NULL,
  `season` varchar(45) DEFAULT NULL,
  `exp` varchar(45) DEFAULT NULL,
  `seller_id` varchar(45) DEFAULT NULL,
  `filename1` varchar(100) DEFAULT NULL,
  `filename2` varchar(100) DEFAULT NULL,
  `filename3` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`product_number`),
  KEY `seller_id_idx` (`seller_id`),
  CONSTRAINT `seller_id` FOREIGN KEY (`seller_id`) REFERENCES `seller` (`seller_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'셔츠','M',45000,0,'1001','4','가을','슬릿 슬리브 셔츠 아이보리','111','apparelwomen_lie1.JPG','apparelwomen_lie2.JPG','apparelwomen_lie1.JPG'),(6,'PIANARI','ONE',30000,12,'1004','22','','L2 로고 볼캡','111','accwomen_PIANARI1.JPG','accwomen_PIANARI2.JPG','accwomen_PIANARI3.JPG'),(7,'delllve','2floor',25000,14,'3005','28',NULL,'마리 호마이카 사각 선반책장 1800 2단','111','life_del1.JPG','life_del2.JPG','life_del3.JPG'),(8,'FRONTROW MEN','M',210000,12,'2001','1','가을','Thermore® Multi-way Quilted Jacket','111','2001_APP1.png','2001_APP2.png','apparelwomen_lie3.jpg'),(9,'MAISON MINED','ONE',76500,49,'2002','8',NULL,'TWO BUCKLE MESSENGER BAG','111','2002bag1.png','2002bag2.png','2002bag3.png'),(10,'CONVERSE','260',135000,42,'2003','19','봄','컨버스 X 펑첸왕 척 70 투인원 네추럴아이보리 169839C','111','2003sh1.png','2003sh2.png','2003sh3.png'),(11,'FUMAGALLI1891','ONE',45000,67,'2004','24','','PAVIA-A583.1','111','2004acc1.png','2004acc2.png','2004acc3.png'),(18,'MELOPE','ONE',60000,22,'1002','8',NULL,'MARKER BAG (OLIVE)','111','bagwomen_melope1.JPG','bagwomen_melope2.JPG','bagwomen_melope3.JPG'),(19,'JILL BY  JILLSTUART','ONE',82000,4,'1002','11',NULL,'LUNE 가죽 참장식 드로스트링 백팩(BLACK)','222','bagwomen_jill1.JPG','bagwomen_jill2.JPG','bagwomen_jill3.JPG'),(36,'베이직 재킷','M',130000,20,'1001','1',NULL,'베이지 셔츠 재킷 :)','111','여자아우터1.jpg',NULL,NULL),(37,'베이지 울 코트','M',150000,30,'1001','1',NULL,'울 코트','222','여자아우터2.jpg',NULL,NULL),(38,'블랙 패딩 셔츠','S',120000,15,'1001','1',NULL,'','111','여자아우터3.jpg','',NULL),(39,'울 원피스','L',160000,1,'1001','2',NULL,'오렌지색 울 머메이드 원피스','111','여자원피스1.jpg',NULL,NULL),(40,'블랙 트렌치 원피스','S',80000,30,'1001','2',NULL,'네이비색상','333','여자원피스2.jpg',NULL,NULL),(50,'플라워 원피스','M',42000,15,'1001','2',NULL,'레드 미니 랩 플라워 원피스','111','여자원피스3.jpg',NULL,NULL),(51,'심플 베이직 셔츠','L',62000,320,'1001','4',NULL,'','111','여자셔츠1.jpg',NULL,NULL),(52,'포켓 셔링 셔츠','S',55000,33,'1001','4',NULL,'','444','여자셔츠2.jpg',NULL,NULL),(53,'사선 라인 셔츠','L',55500,30,'1001','4',NULL,'brick, white','111','여자셔츠3.jpg',NULL,NULL),(54,'브라운 니트 가디건','ONE',45500,54,'1001','5',NULL,'','111','여자니트1.jpg',NULL,NULL),(55,'브이넥 니트','S',35000,42,'1001','5',NULL,'','555','여자니트2.jpg',NULL,NULL),(56,'피자 블랙 후드티','L',79000,20,'1001','3',NULL,'','111','여자상의1.jpg',NULL,NULL),(57,'PLEATED T-SHIRT','M',45000,5,'1001','3',NULL,'Gray','666','여자상의3.jpg',NULL,NULL),(58,'핀턱 베이지 팬츠','M',65300,60,'1001','6',NULL,'','111','여자팬츠1.jpg',NULL,NULL),(59,'블랙 숄더백','ONE',23000,46,'1002','8',NULL,NULL,'111','여자숄더1.jpg',NULL,NULL),(60,'레드 토트백','ONE',46000,30,'1002','9',NULL,'','111','여자토트1.jpg',NULL,NULL),(61,'튤립 팟 LED 무드등','ONE',12000,5,'3005','30',NULL,'','777','조명 튤립 팟 LED 무드등.jpg',NULL,NULL),(62,'미니 컴포던트 블루투스 오디오','ONE',65000,10,'3005','32',NULL,'','111','디지털기기 미니컴포넌트 블루투스 오디오.jpg',NULL,NULL),(63,'블랙 심플 부츠','270',90000,6,'2003','18',NULL,'','666','남자부츠.jpg',NULL,NULL),(64,'남성 블랙 로퍼','265',43000,15,'2003','15',NULL,'','111','남자로퍼.jpg',NULL,NULL),(65,'데일리 백팩','',1,1,'1002','11',NULL,'수납 공간 많은 머스타드 백팩','777','여자백팩.jpg',NULL,NULL),(66,'심플 그레이 클러치','ONE',84000,12,'1002','10',NULL,'','111','여자클러치.jpg',NULL,NULL),(67,'크리스마스 카드','ONE',4500,30,'3005','34',NULL,'','111','문구 크리스마스 카드.jpg',NULL,NULL),(68,'10K 진주 귀걸이','ONE',99000,8,'1004','21',NULL,'','444','10K 여자 진주 귀걸이.jpg',NULL,NULL),(69,'울 소프트 숏 머플러','ONE',13000,5,'1004','24',NULL,'','111','여자 울 소프트 숏 머플러.jpg',NULL,NULL),(70,'Ted black 스퀘어 뿔테 안경','ONE',47000,16,'1004','25',NULL,'','111','여자 ted black 스퀘어 뿔테 안경.jpg',NULL,NULL),(71,'더블 나바크 팔찌','ONE',67000,7,'2004','21',NULL,'','555','남자 더블 나바크 팔찌.jpg',NULL,NULL),(72,'블랙 심플 선글라스','ONE',64000,10,'2004','26',NULL,'','111','남자 선글라스.jpg',NULL,NULL),(73,'자동 버클 벨트','ONE',23000,8,'2004','27',NULL,'','111','남자 자동 버클 벨트.jpg',NULL,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seller`
--

DROP TABLE IF EXISTS `seller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seller` (
  `seller_id` varchar(45) NOT NULL,
  `passwd` varchar(45) DEFAULT NULL,
  `store` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `seller_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`seller_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seller`
--

LOCK TABLES `seller` WRITE;
/*!40000 ALTER TABLE `seller` DISABLE KEYS */;
INSERT INTO `seller` VALUES ('111','111','SHIMSIM','01077123948','심현우'),('222','222','sstore',NULL,''),('333','333','mini',NULL,NULL),('444','444','simple',NULL,NULL),('555','555','riria',NULL,NULL),('666','666','glass',NULL,NULL),('777','777','unit',NULL,NULL);
/*!40000 ALTER TABLE `seller` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-16 23:31:55
