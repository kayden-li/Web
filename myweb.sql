/*
Navicat MySQL Data Transfer

Source Server         : lianjie
Source Server Version : 50553
Source Host           : 127.0.0.1:3306
Source Database       : myweb

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2019-01-01 13:56:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `name` varchar(20) NOT NULL,
  `area` varchar(100) NOT NULL,
  `intro` varchar(200) NOT NULL,
  `img` varchar(100) DEFAULT NULL,
  `publisher` varchar(20) NOT NULL,
  PRIMARY KEY (`name`),
  KEY `publisher` (`publisher`),
  CONSTRAINT `publisher` FOREIGN KEY (`publisher`) REFERENCES `user` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES ('南宋定胜糕', '浙江', '定胜糕是浙江传统的特色名点，属于杭州菜系，具有春季养生调理，术后调理的功效。有甜味，色呈淡红，松软清香，入口甜糯。将配置好的米粉放进特制的印版里，中间再放入红豆沙，蒸少许时间就可以了。糕点比较软，有点松，带甜甜的豆沙味。传说是南宋时百姓为韩家军出征鼓舞将士而特制的，糕上有“定胜”二字，后就被称“定胜糕”。', 'ns_1543897799166.jpg', '杭州');
INSERT INTO `food` VALUES ('吴山酥油饼', '浙江', '吴山酥油饼是浙江省杭州市特色传统名点，至今已有七八百年历史，号称“吴山第一点”。其色泽金黄，层酥叠起，上尖下圆，形似金山，覆以细绵白糖，脆而不碎，油而不腻，香甜味美，入口即酥。', 'ws_1543897815936.jpg', '杭州');
INSERT INTO `food` VALUES ('怪味胡豆', '重庆', '怪味胡豆是重庆特有的名小吃，主要原料是胡豆，很多地方也叫蚕豆，其营养丰富，食用方种多种，有川菜灵魂称号的郫县豆瓣，其中就是胡豆的身影。', 'gw_1543898532695.jpg', '重庆');
INSERT INTO `food` VALUES ('磁器口陈麻花', '重庆', '磁器口麻花又称陈麻花，是一道美味可口的传统小吃，重庆市磁器口镇特产。磁器口麻花有10个品种：原味、黑芝麻、椒盐、黑米、玉米、冰糖糯米、麻辣、海苔、巧克力、蜂蜜。作原味，香甜可口，入口即化，老少皆宜；椒盐麻花，口味纯正，酥脆化渣；麻辣麻花，重庆口味，集甜、麻、辣于一体，回味无穷；新产品蜂蜜麻花，口味纯正，含有丰富的矿物质元素。', 'cq_1543898496703.jpg', '重庆');
INSERT INTO `food` VALUES ('萝卜炖粉条', '河南', '因为没钱买猪肉再加上猪瘟横行于世，特此去掉猪肉，成为刘浩的特色美食佳肴！！！李帆好坏，竟然删掉刘浩辛辛苦苦的精妙绝伦的美食介绍！', '123_1543330344473.jpg', '刘浩');
INSERT INTO `food` VALUES ('葱包桧', '浙江', '“葱包桧儿”是浙江杭州风味的特色传统小吃。望仙桥畔王二炸“油炸桧”出了名，王二有时炸多了，一下子卖不出去，冷了又软又韧，味道不佳，更无人买。\r\n他对秦桧夫妇的心头之恨，还愤愤难平，就将冷油炸桧在热锅一烤，把烤熟的油炸桧同葱段卷入拌着甜面酱的春饼里，再用铁板压烤，烤到表皮呈金黄色，油炸桧“吱吱”发叫，王二方才解恨，他拿起来一吃，觉葱香可口，便取名叫“葱包桧儿”，一直流传至今。其中“儿”为儿化音。', 'cb_1543897832989.jpg', '杭州');
INSERT INTO `food` VALUES ('重庆江津米花糖', '重庆', '江津米花糖，因产于重庆江津区而得名，是重庆市的著名特色小吃之一。以优质糯米、核桃仁、花生仁、芝麻、白糖、动植物油、饴糖、玫瑰糖等为原料，经10余道工序精工制成。产品洁白晶莹，香甜酥脆，爽口化渣，甜而不腻，营养丰富，有滋阴补肾、开胃健脾等功效。江津米花糖历史悠久，销往北京、广州、深圳、上海、昆明、新疆等234个城市，还远销美国、新西兰等国家和地区，深受各地消费者的喜爱。', 'jjm_1543898575520.jpg', '重庆');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `name` varchar(20) NOT NULL,
  `area` varchar(100) NOT NULL,
  `sex` bit(1) NOT NULL,
  `id` char(10) NOT NULL,
  `password` varchar(20) NOT NULL,
  `number` char(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('侯新征', '山西', '', '123', '123', null);
INSERT INTO `user` VALUES ('刘浩', '河南', '', '162056224', '162056224', '15364925795');
INSERT INTO `user` VALUES ('重庆', '重庆', '', 'cq123', '123', '');
INSERT INTO `user` VALUES ('杭州', '浙江', '', 'zj123', '123', '');
