-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: mac
-- ------------------------------------------------------
-- Server version	5.7.17

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `category_id` varchar(36) NOT NULL COMMENT '类别ID',
  `category_name` varchar(40) DEFAULT NULL COMMENT '类别名称',
  `category_order` int(11) DEFAULT NULL COMMENT '类别排序',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('402880e55b86c24d015b86c8d2680001','烤肉',8),('f39cad194bee6826014c34ebcd050012','火锅',1),('f39cad194bee6826014c34ebe9f30013','西餐',2),('f39cad194bee6826014c34ec02120014','酒水',3),('f39cad194bee6826014c34ec2e200015','饮料',4),('f39cad194bee6826014c34ec90fe0016','小吃',5);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `dish_id` varchar(36) NOT NULL COMMENT '菜品ID',
  `dish_name` varchar(45) DEFAULT NULL COMMENT '菜品名称',
  `dish_english_name` varchar(40) DEFAULT NULL COMMENT '菜品英文名',
  `category_id` varchar(36) DEFAULT NULL COMMENT '菜品类型 火锅,酒水,西点等',
  `dish_price` decimal(6,2) DEFAULT NULL COMMENT '菜品价格',
  `dish_description` varchar(200) DEFAULT NULL COMMENT '菜品描述',
  `spicy_level` int(11) DEFAULT NULL COMMENT '麻辣等级,0为不辣',
  `hot_level` int(11) DEFAULT NULL COMMENT '火热程度',
  `dish_imgurl` varchar(100) DEFAULT NULL COMMENT '菜品图片路径',
  `dish_price2` decimal(6,2) DEFAULT NULL COMMENT '大份价格',
  `dish_origin` varchar(20) DEFAULT NULL COMMENT '产地',
  `dish_capacity` int(11) DEFAULT NULL COMMENT '容量',
  `dish_unit` varchar(8) DEFAULT NULL COMMENT '菜品单位',
  `dish_group` varchar(4) DEFAULT NULL COMMENT '菜品分组',
  `dish_order` int(3) DEFAULT NULL COMMENT '菜品排序',
  PRIMARY KEY (`dish_id`),
  KEY `senq` (`dish_id`),
  KEY `fk_reference_1` (`category_id`),
  CONSTRAINT `fk_reference_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜品单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES ('402880e55b776633015b776b27d10000','马超烤肉','mc bee','f39cad194bee6826014c34ebcd050012',9999.00,'哈哈哈哈哈哈哈哈哈',5,5,NULL,9999.00,'',NULL,'份','1',0),('402880e85bc8f004015bc8f2b2190000','ddddddd','dddddd','f39cad194bee6826014c34ebe9f30013',66.00,'4564',5,5,'static/upload/images/2017050243063.jpg',666.00,'',NULL,'fen','1',0),('402880e85bc90818015bc91f112b0000','99999','9999','f39cad194bee6826014c34ec02120014',99.00,'',1,1,NULL,NULL,'',NULL,'fen','1',NULL),('402880e85bc90818015bc91f4a250001','yyyyy','','f39cad194bee6826014c34ec2e200015',88.00,'',1,1,'',NULL,'',NULL,'fen','1',NULL),('402880e85bc90818015bc91f7d9e0002','chi','','f39cad194bee6826014c34ec90fe0016',77.00,'',1,1,'',NULL,'',NULL,'fen','1',NULL),('402880e85bc90818015bc91fbd1b0003','rou','','402880e55b86c24d015b86c8d2680001',90.00,'',1,1,'',NULL,'',NULL,'chuan','1',NULL),('f39cad194c34fc27014c34fe1dc70000','秘制排骨','mizhipaigu','f39cad194bee6826014c34ebcd050012',55.00,'吃了还想吃',1,5,'static/upload/images/2015032432133.jpg',100.00,'西安',NULL,'份','1',1),('f39cad194c34fc27014c34fe1dc70001','秘制排骨','mizhipaigu','f39cad194bee6826014c34ebcd050012',55.00,'吃了还想吃',1,5,'static/upload/images/2015032432133.jpg',100.00,'西安',NULL,'份','1',1),('f39cad194c34fc27014c34ff0aa10001','香辣虾','xianglaxia','f39cad194bee6826014c34ebcd050012',55.00,'辣到爆',5,5,'static/upload/images/2015032453090.jpg',100.00,'西安',800,'份','1',2),('f39cad194c34fc27014c34ff0aa10002','香辣虾','xianglaxia','f39cad194bee6826014c34ebcd050012',55.00,'辣到爆',5,5,'static/upload/images/2015032453090.jpg',100.00,'西安',800,'份','1',2),('f39cad194c34fc27014c34ff0aa10003','香辣虾','xianglaxia','f39cad194bee6826014c34ebcd050012',55.00,'辣到爆',5,5,'static/upload/images/2015032453090.jpg',100.00,'西安',800,'份','1',2);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `order_id` varchar(36) NOT NULL DEFAULT '',
  `people_number` int(2) DEFAULT NULL COMMENT '聚会人数',
  `order_by_username` varchar(16) DEFAULT NULL COMMENT '联系人',
  `order_by_phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `order_message` varchar(2000) DEFAULT NULL COMMENT '客户留言',
  PRIMARY KEY (`order_id`)
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
-- Table structure for table `order_time_range`
--

DROP TABLE IF EXISTS `order_time_range`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_time_range` (
  `order_id` varchar(36) NOT NULL,
  `time_range_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `order_time_range_fk` (`time_range_id`),
  CONSTRAINT `order_time_range_fk` FOREIGN KEY (`time_range_id`) REFERENCES `time_range` (`time_range_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_time_range`
--

LOCK TABLES `order_time_range` WRITE;
/*!40000 ALTER TABLE `order_time_range` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_time_range` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time_range`
--

DROP TABLE IF EXISTS `time_range`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `time_range` (
  `time_range_id` varchar(36) NOT NULL COMMENT 'ID',
  `start_time` varchar(8) DEFAULT NULL COMMENT '开始时间',
  `end_time` varchar(8) DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`time_range_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_range`
--

LOCK TABLES `time_range` WRITE;
/*!40000 ALTER TABLE `time_range` DISABLE KEYS */;
INSERT INTO `time_range` VALUES ('402881be4c6f2fc4014c6f315caf0000','10:00','17:00');
/*!40000 ALTER TABLE `time_range` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `uid` varchar(36) NOT NULL DEFAULT '' COMMENT '用户ID',
  `user_name` varchar(16) DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(64) DEFAULT NULL COMMENT '用户密码',
  `user_email` varchar(60) DEFAULT NULL COMMENT '邮箱',
  `nickname` varchar(16) DEFAULT NULL COMMENT '昵称',
  `open_id` varchar(30) DEFAULT NULL COMMENT '微信openID',
  `real_name` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `phone` varchar(11) DEFAULT NULL COMMENT '电话',
  `gender` char(20) DEFAULT NULL COMMENT '性别',
  `status` int(11) DEFAULT NULL COMMENT '账号状态',
  `last_login_ip` varchar(15) DEFAULT NULL COMMENT '上次登录IP',
  `superman` int(11) DEFAULT NULL COMMENT '超级用户',
  `created_at` datetime DEFAULT NULL COMMENT '账号创建时间',
  `created_by_user_id` varchar(60) DEFAULT NULL COMMENT '账号创建用户',
  `head_img_url` varchar(300) DEFAULT NULL COMMENT '用户头像',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('402881be4c4ae14a014c4ae4d6b20000','deletejeff','c22fd19c3d56ec8e2feaac962a194f1b','deletejeff@qq.com','mac','','马超','18629068099','男',1,'',1,'2015-03-24 16:27:33','',''),('402881be4c4ae14a014c4aed16180001','test1','86eff6e6d3cf47d988f7067938265ea4','test1@qq.com','test1','','','','女',1,'',0,'2015-03-24 16:36:34','',''),('f39cad194c4b2ad4014c4b2fc07d0000','mac','3d3dc741380d7231730c77ade61811ce','','',NULL,'','','男',1,NULL,0,'2015-03-24 17:49:23',NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wx_base_info`
--

DROP TABLE IF EXISTS `wx_base_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wx_base_info` (
  `mp_id` varchar(15) NOT NULL COMMENT '公众号原始ID',
  `mp_name` varchar(40) DEFAULT NULL COMMENT '公众号名称',
  `mp_type` int(11) DEFAULT NULL COMMENT '公众号类型 1:服务号,2:订阅号',
  `mp_description` varchar(200) DEFAULT NULL COMMENT '公众号描述',
  `domain_name` varchar(45) DEFAULT NULL COMMENT '回调域名',
  `wx_id` varchar(40) DEFAULT NULL COMMENT '微信号',
  `app_id` varchar(20) DEFAULT NULL COMMENT '应用ID',
  `app_secret` varchar(50) DEFAULT NULL COMMENT '应用秘钥',
  `token` varchar(32) DEFAULT NULL COMMENT '令牌',
  `url` varchar(200) DEFAULT NULL COMMENT '服务器地址',
  `encoding_aes_key` varchar(43) DEFAULT NULL COMMENT '消息加解密秘钥',
  `enconding_type` int(11) DEFAULT NULL COMMENT '消息加密方式 1:明文模式,2:兼容模式,3:安全模式',
  `fans_quantity` int(11) DEFAULT NULL COMMENT '关注人数',
  `verified` int(11) DEFAULT NULL COMMENT '认证情况 1:已认证,2:未认证',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`mp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='微信公众号基本信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wx_base_info`
--

LOCK TABLES `wx_base_info` WRITE;
/*!40000 ALTER TABLE `wx_base_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `wx_base_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-02 21:26:30
