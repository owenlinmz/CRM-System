/*
Navicat MySQL Data Transfer

Source Server         : 本地开发
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2019-11-23 12:55:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hotel
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roomNumber` varchar(255) NOT NULL,
  `floor` tinyint(4) NOT NULL,
  `bed` tinyint(4) NOT NULL,
  `status` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `number` (`roomNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hotel
-- ----------------------------
INSERT INTO `hotel` VALUES ('1', '101', '1', '2', '正常', '100', '标准间');
INSERT INTO `hotel` VALUES ('2', '202', '2', '3', '维修', '150', '标准间');
INSERT INTO `hotel` VALUES ('4', '102', '1', '1', '正常', '200', '豪华间');
INSERT INTO `hotel` VALUES ('5', '303', '3', '3', '正常', '200', '标准间');
INSERT INTO `hotel` VALUES ('6', '702', '7', '3', '正常', '1000', '总统套房');

-- ----------------------------
-- Table structure for hotel_customer
-- ----------------------------
DROP TABLE IF EXISTS `hotel_customer`;
CREATE TABLE `hotel_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `identity` varchar(255) NOT NULL,
  `telephone` varchar(255) NOT NULL,
  `roomId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_number` (`identity`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hotel_customer
-- ----------------------------
INSERT INTO `hotel_customer` VALUES ('1', 'Owen', '000000', '110', '4');
INSERT INTO `hotel_customer` VALUES ('4', 'Superman', '19990909', '0', '0');
INSERT INTO `hotel_customer` VALUES ('5', 'Lin', '441284', '114', '5');
INSERT INTO `hotel_customer` VALUES ('8', '工具人', '12345', '54321', '5');

-- ----------------------------
-- Table structure for hotel_record
-- ----------------------------
DROP TABLE IF EXISTS `hotel_record`;
CREATE TABLE `hotel_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` int(11) NOT NULL,
  `roomId` int(11) NOT NULL,
  `inTime` datetime NOT NULL,
  `outTime` datetime DEFAULT NULL,
  `breakfast` varchar(2) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hotel_record
-- ----------------------------
INSERT INTO `hotel_record` VALUES ('18', '1', '4', '2019-11-20 09:53:00', null, '是', '200');
INSERT INTO `hotel_record` VALUES ('19', '4', '4', '2019-11-20 09:54:00', '2019-11-23 12:52:00', '是', '200');
INSERT INTO `hotel_record` VALUES ('20', '5', '5', '2019-11-21 09:54:00', null, '否', '200');
INSERT INTO `hotel_record` VALUES ('21', '8', '5', '2019-11-23 09:54:00', null, '否', '200');
