/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : crm-hkbn

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-09-16 22:23:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bill`
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `bill_id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `bill_createtime` date NOT NULL,
  `bill_money` float(6,1) NOT NULL,
  `cust_id` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`bill_id`),
  KEY `cust-bill` (`cust_id`),
  CONSTRAINT `cust-bill` FOREIGN KEY (`cust_id`) REFERENCES `customer` (`cust_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES ('1', '2018-09-15', '999.0', '2');
INSERT INTO `bill` VALUES ('2', '2018-09-15', '888.0', '1');
INSERT INTO `bill` VALUES ('5', '2018-09-16', '1123.0', '1');
INSERT INTO `bill` VALUES ('10', '2018-09-16', '9992.0', '2');
INSERT INTO `bill` VALUES ('14', '2018-09-16', '9993.0', '5');
INSERT INTO `bill` VALUES ('18', '2018-09-16', '777.0', '7');
INSERT INTO `bill` VALUES ('19', '2018-09-16', '666.0', '6');
INSERT INTO `bill` VALUES ('21', '2018-09-16', '222.0', '1');

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `cust_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(20) NOT NULL,
  `cust_createtime` date NOT NULL,
  `cust_phone` varchar(20) NOT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', 'Owen', '2018-09-15', '131');
INSERT INTO `customer` VALUES ('2', 'Beckham', '2018-09-15', '133');
INSERT INTO `customer` VALUES ('5', 'Rooney', '2018-09-15', '132');
INSERT INTO `customer` VALUES ('6', 'Lin', '2018-09-16', '189');
INSERT INTO `customer` VALUES ('7', '陈奕迅', '2018-09-16', '000');
INSERT INTO `customer` VALUES ('8', '杰拉德', '2018-09-16', '020');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userid` smallint(6) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', 'admin');
INSERT INTO `users` VALUES ('2', 'test', 'test');
