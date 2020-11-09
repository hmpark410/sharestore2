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
-- Table structure for table `category_keyword`
--

DROP TABLE IF EXISTS `category_keyword`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_keyword` (
  `category` varchar(45) NOT NULL,
  `keyword1` varchar(45) DEFAULT NULL,
  `keyword2` varchar(45) DEFAULT NULL,
  `keyword3` varchar(45) DEFAULT NULL,
  `keyword4` varchar(45) DEFAULT NULL,
  `keyword5` varchar(45) DEFAULT NULL,
  `keyword6` varchar(45) DEFAULT NULL,
  `keyword7` varchar(45) DEFAULT NULL,
  `keyword8` varchar(45) DEFAULT NULL,
  `keyword9` varchar(45) DEFAULT NULL,
  `keyword10` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_keyword`
--

LOCK TABLES `category_keyword` WRITE;
/*!40000 ALTER TABLE `category_keyword` DISABLE KEYS */;
INSERT INTO `category_keyword` VALUES ('1001','여성','여자','women','woman','옷','apparel','garment','의류','상의','하의'),('1002','여성','여자','women','woman','가방','bag','백','','',''),('1003','여성','여자','women','woman','신발','shoes','슈즈','','',''),('1004','여성','여자','women','woman','악세사리','acc','accessory',NULL,NULL,NULL),('2001','남성','남자','men','man','옷','apparel','garment','의류','상의','하의'),('2002','남성','남자','men','man','가방','bag','백',NULL,NULL,NULL),('2003','남성','남자','men','man','신발','shoes','슈즈',NULL,NULL,NULL),('2004','남성','남자','men','man','악세사리','acc','accessory','액세사리',NULL,NULL),('3005','LIFE','라이프','생활','생활용품','물건',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `category_keyword` ENABLE KEYS */;
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
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('aaa','aaa','심현우','01012345678','sim@naver.com','female',2004,NULL,NULL,NULL),('buyer','qwer1234','홍길동','01048652156','buyer@gmail.com','male',1992,7,16,'경기도 용인시');
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
  `order_date` datetime DEFAULT NULL,
  `total_price` int DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `member_id` varchar(45) DEFAULT NULL,
  `seller_id` varchar(45) DEFAULT NULL,
  `delivery_date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`order_number`),
  KEY `member_id_idx` (`member_id`),
  KEY `seller_id_idx` (`seller_id`),
  CONSTRAINT `member` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`),
  CONSTRAINT `seller` FOREIGN KEY (`seller_id`) REFERENCES `seller` (`seller_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES ('20201102_240246','2020-11-02 07:33:10',198000,'환불신청','buyer','111',NULL),('20201102_711624','2020-11-02 07:33:30',765000,'주문취소','buyer','111',NULL);
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
  PRIMARY KEY (`order_number`,`product_number`),
  KEY `product_number_idx` (`product_number`),
  KEY `order_idx` (`order_number`),
  CONSTRAINT `order_number` FOREIGN KEY (`order_number`) REFERENCES `order` (`order_number`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `product_number` FOREIGN KEY (`product_number`) REFERENCES `product` (`product_number`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_product`
--

LOCK TABLES `order_product` WRITE;
/*!40000 ALTER TABLE `order_product` DISABLE KEYS */;
INSERT INTO `order_product` VALUES ('20201102_240246',1,2),('20201102_711624',8,3),('20201102_711624',10,1);
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
  `exp` varchar(45) DEFAULT NULL,
  `seller_id` varchar(45) DEFAULT NULL,
  `filename1` varchar(100) DEFAULT NULL,
  `filename2` varchar(100) DEFAULT NULL,
  `filename3` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`product_number`),
  KEY `seller_id_idx` (`seller_id`),
  CONSTRAINT `seller_id` FOREIGN KEY (`seller_id`) REFERENCES `seller` (`seller_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'LIE','M',99000,0,'1001','슬릿 슬리브 셔츠 아이보리','111','apparelwomen_lie1.JPG','apparelwomen_lie2.JPG','apparelwomen_lie1.JPG'),(5,'MAISON KITSUNE','220',135000,32,'1003','20FW 여성 폭스 패치 하이탑 스니커즈 EU04705WW9000 WH','111','shoeswomen_maison1.JPG','shoeswomen_maison2.JPG','shoeswomen_maison3.jpg'),(6,'PIANARI','ONE',30000,0,'1004','L2 로고 볼캡','111','accwomen_PIANARI1.JPG','accwomen_PIANARI2.JPG','accwomen_PIANARI3.JPG'),(7,'delllve','2floor',25000,3,'3005','마리 호마이카 사각 선반책장 1800 2단','111','life_del1.JPG','life_del2.JPG','life_del3.JPG'),(8,'FRONTROW MEN','M',210000,18,'2001','Thermore® Multi-way Quilted Jacke','111','2001_APP1.png','2001_APP2.png','apparelwomen_lie3.jpg'),(9,'MAISON MINED','ONE',76500,22,'2002','TWO BUCKLE MESSENGER BAG','111','2002bag1.png','2002bag2.png','2002bag3.png'),(10,'CONVERSE','260',135000,43,'2003','컨버스 X 펑첸왕 척 70 투인원 네추럴아이보리 169839C','111','2003sh1.png','2003sh2.png','2003sh3.png'),(11,'FUMAGALLI1891','ONE',45000,71,'2004','PAVIA-A583.1','111','2004acc1.png','2004acc2.png','2004acc3.png'),(18,'MELOPE','ONE',60000,30,'1002','MARKER BAG (OLIVE)','111','bagwomen_melope1.JPG','bagwomen_melope2.JPG','bagwomen_melope3.JPG'),(19,'JILL BY  JILLSTUART','ONE',82000,15,'1002','LUNE 가죽 참장식 드로스트링 백팩(BLACK)','111','bagwomen_jill1.JPG','bagwomen_jill2.JPG','bagwomen_jill3.JPG'),(27,'침구','ONE',120000,13,'3005','푹신한 보라색 침구','111','SHAREROOM_16.JPG','SHAREROOM_26.JPG','SHAREROOM_36.JPG');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `search_keyword`
--

DROP TABLE IF EXISTS `search_keyword`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `search_keyword` (
  `keyword` varchar(45) NOT NULL,
  PRIMARY KEY (`keyword`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `search_keyword`
--

LOCK TABLES `search_keyword` WRITE;
/*!40000 ALTER TABLE `search_keyword` DISABLE KEYS */;
INSERT INTO `search_keyword` VALUES ('바지'),('반팔'),('셔츠'),('청바지');
/*!40000 ALTER TABLE `search_keyword` ENABLE KEYS */;
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
INSERT INTO `seller` VALUES ('111','111','SHIMSIM','01077123948','심현우');
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

-- Dump completed on 2020-11-04  0:04:04
