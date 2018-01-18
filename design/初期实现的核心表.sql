/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 50719
Source Host           : world-elite.site:3306
Source Database       : interestclass

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-01-18 18:18:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `classId` int(8) NOT NULL AUTO_INCREMENT,
  `className` varchar(255) NOT NULL,
  `courseId` int(8) NOT NULL,
  `courseName` varchar(255) DEFAULT NULL,
  `classStartTime` date DEFAULT NULL,
  `classEndTime` date DEFAULT NULL,
  `classPrice` int(8) DEFAULT NULL,
  PRIMARY KEY (`classId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '\r\n2017年12月下旬班', '1', '【零基础】Scratch趣味创意编程', '2017-12-21', '2018-01-21', '100');
INSERT INTO `class` VALUES ('2', '\r\n2017年12月下旬班', '2', '面向对象程序设计', '2017-12-21', '2018-01-21', '100');
INSERT INTO `class` VALUES ('3', '2017年12月下旬班', '3', '数据结构及算法', '2017-10-19', '2018-01-17', '1302');
INSERT INTO `class` VALUES ('4', '2017年12月上旬班', '1', '【零基础】Scratch趣味创意编程', '2017-12-21', '2018-01-21', '100');
INSERT INTO `class` VALUES ('6', 'hahahahclass', '1', '【零基础】Scratch趣味创意编程', '2017-10-13', '2018-01-11', '100');
INSERT INTO `class` VALUES ('7', 'scratch初级班', '1', '【零基础】Scratch趣味创意编程', '2017-10-19', '2018-01-17', '120');

-- ----------------------------
-- Table structure for classgroup
-- ----------------------------
DROP TABLE IF EXISTS `classgroup`;
CREATE TABLE `classgroup` (
  `groupId` int(8) NOT NULL,
  `classId` int(8) NOT NULL,
  `classname` varchar(255) NOT NULL,
  `classPrice` int(11) DEFAULT NULL,
  `groupName` varchar(255) NOT NULL,
  `groupStartTime` date DEFAULT NULL,
  `groupEndTime` date DEFAULT NULL,
  `groupCount` int(3) NOT NULL COMMENT '满团人数',
  `groupType` int(5) NOT NULL COMMENT '1-优惠拼团 2-满人付少拼团',
  `groupFavourablePrice` int(8) DEFAULT NULL COMMENT '优惠后价格',
  `groupPayCount` int(3) DEFAULT NULL COMMENT '成团付人数',
  `groupDetail` longtext,
  PRIMARY KEY (`groupId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classgroup
-- ----------------------------
INSERT INTO `classgroup` VALUES ('1', '1', '1111', '111', '111', '2017-11-06', '2017-02-06', '10', '1', '98', null, '<img src=\"http://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/1.jpg\" alt=\"\">');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `courseId` int(8) NOT NULL AUTO_INCREMENT,
  `courseName` varchar(255) NOT NULL,
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '【零基础】Scratch趣味创意编程');
INSERT INTO `course` VALUES ('2', '面向对象程序设计');
INSERT INTO `course` VALUES ('3', '数据结构及算法');
INSERT INTO `course` VALUES ('4', '信息安全基础');
INSERT INTO `course` VALUES ('5', '高级程序设计acm');
INSERT INTO `course` VALUES ('6', '初级数据结构与算法');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `managerId` int(8) NOT NULL,
  `managerName` varchar(50) NOT NULL,
  `managerTelephone` varchar(20) NOT NULL DEFAULT '',
  `managerPassword` varchar(255) NOT NULL,
  `managerAvatarUrl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`managerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', 'lvzu', '13777821015', '0d2f6d9537873f7b9b2e004414496e8ac39361a8', 'http://lvzu-imgs.oss-cn-hangzhou.aliyuncs.com/contact/lvzu.png');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userOpenid` varchar(50) NOT NULL,
  `userTelephone` varchar(11) DEFAULT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `userSex` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for user_child
-- ----------------------------
DROP TABLE IF EXISTS `user_child`;
CREATE TABLE `user_child` (
  `userChildId` int(8) NOT NULL,
  `userChildParentId` int(8) NOT NULL,
  `userChildName` varchar(50) NOT NULL,
  `userChildBirthday` date DEFAULT NULL,
  `userChildSex` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`userChildId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_child
-- ----------------------------

-- ----------------------------
-- Table structure for user_group
-- ----------------------------
DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group` (
  `userGroupId` int(8) NOT NULL,
  `userId` int(8) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `className` varchar(255) DEFAULT NULL,
  `groupId` int(8) NOT NULL,
  `groupType` varchar(50) NOT NULL,
  `groupFavourablePrice` int(8) DEFAULT NULL,
  `groupPayCount` int(3) DEFAULT NULL,
  `userGroupStartTime` date NOT NULL,
  `userGroupEndTime` date NOT NULL,
  `userGroupCount` int(3) NOT NULL,
  `groupEndType` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userGroupId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_group
-- ----------------------------

-- ----------------------------
-- Table structure for user_group_member
-- ----------------------------
DROP TABLE IF EXISTS `user_group_member`;
CREATE TABLE `user_group_member` (
  `groupMemberId` int(8) NOT NULL,
  `userGroupId` int(8) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `userId` int(8) NOT NULL,
  `attendUserId` int(8) NOT NULL,
  `attendUserName` varchar(50) NOT NULL,
  `attendTime` date NOT NULL,
  PRIMARY KEY (`groupMemberId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_group_member
-- ----------------------------

-- ----------------------------
-- Table structure for verify
-- ----------------------------
DROP TABLE IF EXISTS `verify`;
CREATE TABLE `verify` (
  `verifyId` int(8) NOT NULL,
  `verifyCode` int(4) NOT NULL,
  `userId` int(8) NOT NULL,
  `expire` int(13) NOT NULL,
  PRIMARY KEY (`verifyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of verify
-- ----------------------------
