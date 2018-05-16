/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : trainingcollege

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-05-16 10:05:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` char(255) NOT NULL,
  `balance` double DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('i000001', '1456.0876', '1');
INSERT INTO `account` VALUES ('s000001', '11532.196999999993', '0');
INSERT INTO `account` VALUES ('s000005', '12780', '0');
INSERT INTO `account` VALUES ('s000006', '9800', '0');
INSERT INTO `account` VALUES ('system', '1999588.7803', '2');

-- ----------------------------
-- Table structure for `checklist`
-- ----------------------------
DROP TABLE IF EXISTS `checklist`;
CREATE TABLE `checklist` (
  `institutionid` char(255) NOT NULL,
  `password` char(255) DEFAULT NULL,
  `address` char(255) DEFAULT NULL,
  `name` char(255) DEFAULT NULL,
  `type` int(11) NOT NULL,
  `ischecked` int(11) DEFAULT NULL,
  PRIMARY KEY (`institutionid`,`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of checklist
-- ----------------------------
INSERT INTO `checklist` VALUES ('i000004', '123456', 'ssss', 'sss', '1', '2');
INSERT INTO `checklist` VALUES ('i000004', '123456', '666', '666', '2', '2');
INSERT INTO `checklist` VALUES ('i000005', '123456', '广州路', '软件学院', '1', '2');
INSERT INTO `checklist` VALUES ('i000005', '123456', '湖南路', '南京大学', '2', '2');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `courseid` char(255) NOT NULL,
  `coursehour` int(11) DEFAULT NULL,
  `weeknumber` int(11) DEFAULT NULL,
  `coursename` char(255) DEFAULT NULL,
  `teacherid` char(255) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `type` char(255) DEFAULT NULL,
  `description` char(255) DEFAULT NULL,
  `institutionid` char(255) DEFAULT NULL,
  `startday` date DEFAULT NULL,
  PRIMARY KEY (`courseid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('c000001', '20', '10', '绝地求生', 't000001', '200', '5000', '电竞', '教你如何走位', 'i000001', '2018-03-21');
INSERT INTO `course` VALUES ('c000002', '20', '10', 'ow', 't000001', '200', '500', '射击', '哦看到你了', 'i000001', '2018-04-19');
INSERT INTO `course` VALUES ('c000003', '20', '20', 'mmm', 't000001', '100', '4000', '奥数', 'ffff', 'i000001', '3918-05-20');
INSERT INTO `course` VALUES ('c000004', '20', '1', 'ss', 't000001', '20', '200', 'aushu', '123', 'i000003', '2018-04-20');
INSERT INTO `course` VALUES ('c000005', '20', '10', 'ss', 't000001', '200', '2000', 'aushu', 'lll', 'i000004', '2018-04-20');
INSERT INTO `course` VALUES ('c000006', '20', '20', '计算机', 't000001', '200', '2000', '计算机', '计算机课', 'i000005', '2018-04-20');

-- ----------------------------
-- Table structure for `institution`
-- ----------------------------
DROP TABLE IF EXISTS `institution`;
CREATE TABLE `institution` (
  `institutionid` char(255) NOT NULL,
  `psword` char(255) DEFAULT NULL,
  `address` char(255) DEFAULT NULL,
  `institutionname` char(255) DEFAULT NULL,
  PRIMARY KEY (`institutionid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of institution
-- ----------------------------
INSERT INTO `institution` VALUES ('i000001', '123456', 's', 's');
INSERT INTO `institution` VALUES ('i000002', '123456', 'gg', 'gg');
INSERT INTO `institution` VALUES ('i000003', '123456', 'ss', 'ruanjian');
INSERT INTO `institution` VALUES ('i000004', '123456', '666', '666');
INSERT INTO `institution` VALUES ('i000005', '123456', '湖南路', '南京大学');

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `managerid` char(255) NOT NULL,
  `psword` char(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  `balance` double DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`managerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('admin', '123456', 'admin', '5000', '2');

-- ----------------------------
-- Table structure for `mark`
-- ----------------------------
DROP TABLE IF EXISTS `mark`;
CREATE TABLE `mark` (
  `studentid` char(255) NOT NULL,
  `courseid` char(255) NOT NULL,
  `attendence` int(11) DEFAULT NULL,
  `mark` int(11) DEFAULT NULL,
  PRIMARY KEY (`studentid`,`courseid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mark
-- ----------------------------
INSERT INTO `mark` VALUES ('s000001', 'c000001', '12', '60');
INSERT INTO `mark` VALUES ('s000001', 'c000004', '20', '80');
INSERT INTO `mark` VALUES ('s000005', 'c000005', '20', '80');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderid` char(255) NOT NULL,
  `studentid` char(255) DEFAULT NULL,
  `institutionid` char(255) DEFAULT NULL,
  `courseid` char(255) DEFAULT NULL,
  `foundtime` date DEFAULT NULL,
  `state` char(255) DEFAULT NULL,
  `initialprice` double DEFAULT NULL,
  `lastprice` double DEFAULT NULL,
  `point` int(11) DEFAULT NULL,
  `classnumber` int(11) DEFAULT NULL,
  `studentnumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('o000001', 's000001', 'i000001', 'c000001', '2018-03-14', '已支付', '5000', '4000', '4000', '0', '1');
INSERT INTO `orders` VALUES ('o000002', 's000001', 'i000001', 'c000002', '2018-03-06', '未支付', '3000', '2000', '2000', '1', '2');
INSERT INTO `orders` VALUES ('o000003', 's000001', 'i000001', 'c000002', '1970-01-18', '未支付', '500', '261.67', '3000', '1', '1');
INSERT INTO `orders` VALUES ('o000004', 's000001', 'i000001', 'c000002', '1970-01-18', '未支付', '500', '261.67', '3000', '1', '1');
INSERT INTO `orders` VALUES ('o000005', 's000001', 'i000001', 'c000002', '1970-01-18', '未支付', '500', '261.67', '3000', '1', '1');
INSERT INTO `orders` VALUES ('o000006', 's000001', 'i000001', 'c000002', '2018-04-02', '已支付', '500', '291.67', '0', '1', '1');
INSERT INTO `orders` VALUES ('o000007', 's000001', 'i000001', 'c000001', '2018-04-03', '未支付', '10000', '5384.62', '0', '1', '2');
INSERT INTO `orders` VALUES ('o000008', 's000001', 'i000001', 'c000003', '2018-04-04', '已取消', '4000', '2150.94', '291', '1', '1');
INSERT INTO `orders` VALUES ('o000009', 's000001', 'i000003', 'c000004', '2018-04-04', '未支付', '400', '215.38', '0', '1', '2');
INSERT INTO `orders` VALUES ('o000010', 's000001', 'i000003', 'c000004', '2018-04-04', '已退订', '200', '83.28', '2441', '1', '1');
INSERT INTO `orders` VALUES ('o000011', 's000005', 'i000003', 'c000004', '2018-04-08', '已退订', '200', '200', '0', '1', '1');
INSERT INTO `orders` VALUES ('o000012', 's000005', 'i000004', 'c000005', '2018-04-08', '已退订', '2000', '1750', '0', '1', '1');
INSERT INTO `orders` VALUES ('o000013', 's000001', 'i000005', 'c000006', '2018-04-08', '已退订', '2000', '1050.8500000000001', '2607', '2', '1');
INSERT INTO `orders` VALUES ('o000014', 's000006', 'i000005', 'c000006', '2018-04-08', '已支付', '2000', '2000', '0', '0', '1');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentid` char(255) NOT NULL,
  `name` char(255) DEFAULT NULL,
  `gender` char(255) DEFAULT NULL,
  `email` char(255) DEFAULT NULL,
  `psword` char(255) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `point` int(11) DEFAULT NULL,
  `consume` double DEFAULT NULL,
  `iscanceled` int(11) DEFAULT NULL,
  PRIMARY KEY (`studentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('s000001', '方家俊', '男', '1040701709@qq.com', '123456', '6', '0', '18714.254999999997', '0');
INSERT INTO `student` VALUES ('s000002', 'company1admin', '男', '1040701709@qq.com', '123456', '0', '0', '0', '0');
INSERT INTO `student` VALUES ('s000003', 'financial', '男', '1040@qq.com', '123456', '0', '0', '0', '0');
INSERT INTO `student` VALUES ('s000004', 'ss', '男', '151250034@smail.nju.edu.cn', '123457', '0', '0', '0', '0');
INSERT INTO `student` VALUES ('s000005', '方', '女', '151250034@smail.nju.edu.cn', '1234567', '1', '200', '550', '0');
INSERT INTO `student` VALUES ('s000006', 'fjj', '男', '151250034@smail.nju.edu.cn', '1234567', '1', '0', '200', '0');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacherid` char(255) NOT NULL,
  `teachername` char(255) DEFAULT NULL,
  `institutionid` char(255) DEFAULT NULL,
  PRIMARY KEY (`teacherid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('t000001', 'jamlee', 'i000001');
