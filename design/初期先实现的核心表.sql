/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : interestclass

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-01-04 17:07:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `classId` int(8) NOT NULL AUTO_INCREMENT,
  `className` varchar(50) NOT NULL,
  `courseId` int(8) NOT NULL,
  `courseName` varchar(50) DEFAULT NULL,
  `classStartTime` date NOT NULL,
  `classEndTime` date DEFAULT NULL,
  PRIMARY KEY (`classId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `courseId` int(8) NOT NULL AUTO_INCREMENT,
  `courseName` varchar(50) NOT NULL,
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `groupId` int(8) NOT NULL,
  `classId` int(8) NOT NULL,
  `groupName` varchar(50) NOT NULL,
  `groupExpireTime` int(13) DEFAULT NULL,
  `classname` varchar(50) NOT NULL,
  `groupCount` int(3) NOT NULL,
  `groupType` varchar(50) NOT NULL,
  `type_one_sectionCount` tinyint(1) DEFAULT NULL,
  `type_two_groupedCount` tinyint(1) DEFAULT NULL,
  `type_two_payCount` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`groupId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for group_section
-- ----------------------------
DROP TABLE IF EXISTS `group_section`;
CREATE TABLE `group_section` (
  `sectionId` int(8) NOT NULL,
  `groupId` int(8) NOT NULL,
  `sectionRank` tinyint(1) NOT NULL,
  `sectionMaxCount` tinyint(1) NOT NULL,
  `sectionPrice` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`sectionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `managerId` int(8) NOT NULL,
  `managerName` varchar(50) NOT NULL,
  `managerTelephone` int(11) NOT NULL,
  `managerPassword` varchar(255) NOT NULL,
  PRIMARY KEY (`managerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
-- Table structure for user_group
-- ----------------------------
DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group` (
  `userGroupId` int(8) NOT NULL,
  `userId` int(8) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `groupId` int(8) NOT NULL,
  `userGroupExpire` int(13) NOT NULL,
  `userGroupCount` int(3) NOT NULL,
  `userGroupType` varchar(50) NOT NULL,
  `groupIsEnd` tinyint(1) NOT NULL,
  `groupEndType` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userGroupId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
