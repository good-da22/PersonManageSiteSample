CREATE DATABASE  IF NOT EXISTS `ssafytest`;
USE `ssafytest`;

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person`(
  `id` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `department_name` varchar(20) NOT NULL,
  `pay` int NOT NULL,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `person` WRITE;
INSERT INTO `person`
VALUES ('P001', '유저1', '기획', 5000),
	('P002', '유저2', '개발', 4500),
	('P003', '유저3', '영업', 3700);
UNLOCK TABLES;