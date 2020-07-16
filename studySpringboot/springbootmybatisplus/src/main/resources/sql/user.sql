/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : mybatisplus

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2020-07-16 17:10:42
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1282945058361884675 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Jone', '18', 'test1@baomidou.com');
INSERT INTO `user` VALUES ('2', 'Jack', '20', 'test2@baomidou.com');
INSERT INTO `user` VALUES ('4', 'Sandy', '21', 'test4@baomidou.com');
INSERT INTO `user` VALUES ('5', 'Billie', '24', 'test5@baomidou.com');
INSERT INTO `user` VALUES ('1282930625824710657', '1tewq', '1', 'tyty@998.com');
INSERT INTO `user` VALUES ('1282930668564668417', '1tewq', '1', 'tyty@998.com');
INSERT INTO `user` VALUES ('1282930734729814017', '1tewq', '1', 'tyty@998.com');
INSERT INTO `user` VALUES ('1282932518986735618', '1tewq', '1', 'tyty@998.com');
INSERT INTO `user` VALUES ('1282932665162424321', '1tewq', '1', 'tyty@998.com');
INSERT INTO `user` VALUES ('1282939222583463937', '1tewq', '1', 'tyty@998.com');
INSERT INTO `user` VALUES ('1282939682245627905', '1tewq', '1', 'tyty@998.com');
INSERT INTO `user` VALUES ('1282940038660820993', '1tewq', '1', 'tyty@998.com');
INSERT INTO `user` VALUES ('1282940454257651713', '1tewq', '1', 'tyty@998.com');
INSERT INTO `user` VALUES ('1282940888112197634', '1tewq', '1', 'tyty@998.com');
INSERT INTO `user` VALUES ('1282941474916311041', '1tewq', '1', 'tyty@998.com');
INSERT INTO `user` VALUES ('1282941872863473665', '1tewq', '1', 'tyty@998.com');
INSERT INTO `user` VALUES ('1282944650222542849', '1tewq', '1', 'tyty@998.com');
INSERT INTO `user` VALUES ('1282944906335219713', '1tewq', '1', 'tyty@998.com');
INSERT INTO `user` VALUES ('1282945058361884673', '1tewq', '1', 'tyty@998.com');
INSERT INTO `user` VALUES ('1282945058361884674', '测试数据', '20', 'testEmail');
