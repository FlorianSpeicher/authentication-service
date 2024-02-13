-- Adminer 4.8.1 MySQL 8.1.0 dump

DROP TABLE IF EXISTS `token`;
CREATE TABLE `token` (
  `id` int NOT NULL AUTO_INCREMENT,
  `token_string` varchar(128) NOT NULL,
  `time_stamp` bigint NOT NULL,
  PRIMARY KEY (`id`)
)


-- 2024-02-13 12:23:49