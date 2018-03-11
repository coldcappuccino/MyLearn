/*
Navicat MySQL Data Transfer

Source Server         : qwe
Source Server Version : 50605
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50605
File Encoding         : 65001

Date: 2018-03-11 10:17:57
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '商品类别编号（主键，自动增量）',
  `cag_name` char(20) DEFAULT NULL COMMENT '商品类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO category VALUES ('1', '文学');
INSERT INTO category VALUES ('7', '小说');
INSERT INTO category VALUES ('9', '青春');
INSERT INTO category VALUES ('10', '人文社科');
INSERT INTO category VALUES ('11', '教育');
INSERT INTO category VALUES ('12', '科学');
INSERT INTO category VALUES ('13', '文艺');

-- ----------------------------
-- Table structure for `products`
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `pro_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '商品编号（主键，自动增量）',
  `pro_name` varchar(40) NOT NULL COMMENT '商品名称',
  `pro_details` varchar(500) DEFAULT NULL COMMENT '商品描述',
  `pro_cag` int(4) DEFAULT NULL COMMENT '商品分类',
  `pro_price` float(8,2) DEFAULT '0.00' COMMENT '商品价格',
  `picture` varchar(30) DEFAULT NULL COMMENT '商品图片',
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO products VALUES ('10', '好教育点亮人生', '　身为家长、教师或学生的您，一定期盼拥有一本这样的教育书籍；一是有趣、实用，启迪孩子心智；二是唯美、精炼，富有收藏价值。\r\n　　本书正是满足您这一需求的教育指导书籍，选用文章多用故事和实际事例来阐释现代教育理念，诸多教育观点、教育思维、教育方法和异国教育风情让您耳目一新。它既可以作为课外补充读物，也可以作为收藏书或馈赠品。\r\n　身为家长、教师或学生的您，一定期盼拥有一本这样的教育书籍；一是有趣、实用，启迪孩子心智；二是唯美、精炼，富有收藏价值。\r\n　　本书正是满足您这一需求的教育指导书籍，选用文章多用故事和实际事例来阐释现代教育理念，诸多教育观点、教育思维、教育方法和异国教育风情让您耳目一新。', '10', '60.00', 'book2.jpg');
INSERT INTO products VALUES ('11', '朱镕基讲话实录', '《朱镕基讲话实录》收入了朱镕基担任国务院副总理、国务院总理期间的重要讲话、谈话、文章、信件、批语等348篇，照片272幅，批语、书信及题词影印件 30件，这些讲话、谈话、文章等从各个方面翔实记录了朱镕基领导中国经济的历程，内容涉及中国财税体制改革、金融体制改革、国有企业改革、社会保障体制改革、投融资体制改革、住房制度改革、应对亚洲金融危机冲击、治理通货膨胀等经济社会各领域重大问题。不仅是读者深入了解朱镕基经济社会管理思想、领导风格、个人魅力和心路历程最全面的读本，也是读者回顾和解读中国经济发展历程和基本规律的一部丰富史料。', '10', '120.00', 'book1.jpg');
INSERT INTO products VALUES ('12', '蔡康永的说话之道', '蔡康永的说话之道》是蔡康永的第一本实用书，在“说话”多年之后，首次尝试教人“说话”。本书开端康永哥便许下宏愿：这本书会令“本来已经很讨人喜欢的你，在未来变得更讨人喜欢”。全书包括40篇精彩短文，每篇都是让谈话变美的醍醐味，并配以熊宝绘制的令人喷饭的搞笑插画，如同蔡康永的主持风格一样犀利俏皮，饶有情趣。\r\n\r\n', '10', '55.00', 'book3.jpg');
INSERT INTO products VALUES ('13', '素年锦时', '本书是著名青年女作家安妮宝贝小说散文新作集。\r\n　　在这本书里，安妮宝贝以文字探索呈现自我与外在环境及内心世界的关系，以及与之保持的疏离感。这种疏离感使她得以对照记忆与真实之间细微层次，谈论身世，家庭，童年，南方，流失，生命的客观性。作者沉着剥离个人回忆在时间中的内核，将它的黑暗与光亮，呈现在多年新旧读者的面前，是一场清谈的形式。书中另一部分属于思省的层面，坦率讨论写作和作品，涉及天分，交际，孤立，圈子，争议，价值观，读书，世相，人情，个性……风格清淡洗练，观点直率深入。\r\n　　全文分春夏秋冬四季，除小说《月棠记》之外，都是她“自言自语”，以一个词语比如“祖母”、“阅读”、“自闭”等等为题写下所想所感。随笔集中散文与小说并存，小说很像散文，散文又像小说，安妮宝贝认为那或许因为她一直是个趋向关注状态而抹去观点界限的人。\r\n', '1', '16.00', 'book5.jpg');
INSERT INTO products VALUES ('14', '二十年滋味', '我们为什么关注幸福？为什么生活好了，却感觉不幸福了？幸福与年龄有关吗？幸福与他人有关吗？幸福与国家有关吗？幸福与信仰有关吗？如何让自己多一些幸福感？有一天我们会到达幸福吗？   \r\n\r\n　　——如果您也渴望幸福人生，请与白岩松一同寻找答案。\r\n　　中央电视台著名主持人、资深新闻评论员白岩松在国内首创名人公开课，本套装中的独家演讲光碟《关于幸福的问与答》，在60分钟的讲述中，将于读者一起探讨获得幸福的方法。白岩松亲自选定的精美套盒，并随书附赠藏书卡一张。本套装中还包括了白岩松代表作《幸福了吗》《痛并快乐着》，随书附赠的超值光碟大礼：《关于幸福的问与答》+《白岩松耶鲁大学演讲唯一完整版》+《季羡林、启功、丁聪等绝版采访实录》。\r\n', '1', '60.00', 'book6.jpg');
INSERT INTO products VALUES ('16', '二十年滋味', '我们为什么关注幸福？为什么生活好了，却感觉不幸福了？幸福与年龄有关吗？幸福与他人有关吗？幸福与国家有关吗？幸福与信仰有关吗？如何让自己多一些幸福感？有一天我们会到达幸福吗？   \r\n\r\n　　——如果您也渴望幸福人生，请与白岩松一同寻找答案。\r\n　　中央电视台著名主持人、资深新闻评论员白岩松在国内首创名人公开课，本套装中的独家演讲光碟《关于幸福的问与答》，在60分钟的讲述中，将于读者一起探讨获得幸福的方法。白岩松亲自选定的精美套盒，并随书附赠藏书卡一张。本套装中还包括了白岩松代表作《幸福了吗》《痛并快乐着》，随书附赠的超值光碟大礼：《关于幸福的问与答》+《白岩松耶鲁大学演讲唯一完整版》+《季羡林、启功、丁聪等绝版采访实录》。\r\n', '7', '60.00', 'book6.jpg');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `account` int(20) DEFAULT NULL,
  `username` char(20) NOT NULL,
  `userpsw` char(20) DEFAULT NULL,
  `email` char(50) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('100', 'tomjerry', 'tomjerry', 'tomjerry@126.com');
INSERT INTO user VALUES ('0', 'tomjerry2', '111111', 'tomjerry2@126.com');
INSERT INTO user VALUES ('0', 'tomjerry3', 'tomjerry3', 'tomjerry3@126.com');
INSERT INTO user VALUES ('0', 'tomjerry5', 'tomjerry5', 'tomjerry5@126.com');
INSERT INTO user VALUES ('0', 'tomjerry6', 'tomjerry6', 'tomjerry6@126.com');
INSERT INTO user VALUES ('1', '郎子文', null, null);
