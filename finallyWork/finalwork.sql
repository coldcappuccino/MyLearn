/*
Navicat MySQL Data Transfer

Source Server         : qwe
Source Server Version : 50605
Source Host           : localhost:3306
Source Database       : finalwork

Target Server Type    : MYSQL
Target Server Version : 50605
File Encoding         : 65001

Date: 2018-03-11 14:49:34
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `price` varchar(10) DEFAULT NULL,
  `picture` varchar(30) DEFAULT NULL,
  `describe` varchar(50) DEFAULT NULL,
  `cagID` varchar(10) DEFAULT NULL,
  `bookID` int(10) NOT NULL,
  `bookname` varchar(10) NOT NULL,
  PRIMARY KEY (`bookID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO book VALUES ('10', 'book1.jpg', 'aaaaa', '1', '1', 'bafeite');
INSERT INTO book VALUES ('2', '2', '2', '2', '2', '2');
INSERT INTO book VALUES ('12', '1_dr_lou.jpg', 'gg', '1', '5', 'aa');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cagName` varchar(20) DEFAULT NULL,
  `cagID` int(10) NOT NULL,
  PRIMARY KEY (`cagID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO category VALUES ('life', '1');
INSERT INTO category VALUES ('artist', '2');

-- ----------------------------
-- Table structure for `resource`
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `sourceID` int(10) NOT NULL,
  `sourcename` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`sourceID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO resource VALUES ('1', 'shopping');
INSERT INTO resource VALUES ('2', 'addbook');
INSERT INTO resource VALUES ('3', 'deletebook');
INSERT INTO resource VALUES ('4', 'setright');

-- ----------------------------
-- Table structure for `resource_role`
-- ----------------------------
DROP TABLE IF EXISTS `resource_role`;
CREATE TABLE `resource_role` (
  `roleID` int(10) NOT NULL,
  `sourceID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of resource_role
-- ----------------------------
INSERT INTO resource_role VALUES ('3', '1');
INSERT INTO resource_role VALUES ('3', '2');
INSERT INTO resource_role VALUES ('3', '3');
INSERT INTO resource_role VALUES ('1', '1');
INSERT INTO resource_role VALUES ('3', '4');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleName` varchar(10) DEFAULT NULL,
  `roleID` int(10) NOT NULL,
  PRIMARY KEY (`roleID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO role VALUES ('commenuser', '1');
INSERT INTO role VALUES ('admin', '2');
INSERT INTO role VALUES ('superadmin', '3');

-- ----------------------------
-- Table structure for `role_user`
-- ----------------------------
DROP TABLE IF EXISTS `role_user`;
CREATE TABLE `role_user` (
  `uid` int(10) DEFAULT NULL,
  `roleID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of role_user
-- ----------------------------
INSERT INTO role_user VALUES ('1', '3');
INSERT INTO role_user VALUES ('2', '1');
INSERT INTO role_user VALUES ('11', '1');

-- ----------------------------
-- Table structure for `sale`
-- ----------------------------
DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale` (
  `Provider` varchar(36) DEFAULT NULL,
  `PrincipallID` varchar(36) DEFAULT NULL,
  `CustomerID` varchar(36) DEFAULT NULL,
  `Title` varchar(100) DEFAULT NULL,
  `UUID` varchar(36) NOT NULL,
  PRIMARY KEY (`UUID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sale
-- ----------------------------
INSERT INTO sale VALUES ('22', '22', '22', '22', '1');
INSERT INTO sale VALUES ('33', '33', '33', '33', '5');
INSERT INTO sale VALUES ('66', '66', '66', '66', '6');

-- ----------------------------
-- Table structure for `shoppingcart`
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart` (
  `price` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `bookID` int(11) NOT NULL,
  `uid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of shoppingcart
-- ----------------------------
INSERT INTO shoppingcart VALUES ('10', '3', '1', '2');
INSERT INTO shoppingcart VALUES ('10', '2', '1', '2');

-- ----------------------------
-- Table structure for `timetask`
-- ----------------------------
DROP TABLE IF EXISTS `timetask`;
CREATE TABLE `timetask` (
  `endDate` date DEFAULT NULL,
  `number` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of timetask
-- ----------------------------
INSERT INTO timetask VALUES ('2017-08-31', '1');
INSERT INTO timetask VALUES ('2017-08-21', '0');
INSERT INTO timetask VALUES ('2017-08-06', '0');
INSERT INTO timetask VALUES ('2017-08-05', '0');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(10) NOT NULL AUTO_INCREMENT,
  `password` varchar(10) DEFAULT NULL,
  `username` varchar(10) DEFAULT '',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('1', 'langziwen', 'langziwen');
INSERT INTO user VALUES ('2', 'sunruiyang', 'sunruiyang');
INSERT INTO user VALUES ('7', 'aaaaaa', 'aaaaa');
INSERT INTO user VALUES ('8', 'vvvvvv', 'vvvvvv');
INSERT INTO user VALUES ('9', 'hhh', 'hhhh');
INSERT INTO user VALUES ('11', 'jjjj', 'jjjjj');
