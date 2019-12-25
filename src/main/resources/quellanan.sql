/*
Date: 2017-12-26 18:36:12
*/

CREATE DATABASE `quellanan` DEFAULT CHARACTER SET utf8;

USE `quellanan`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1', '超级管理员');
INSERT INTO `roles` VALUES ('2', '普通用户');
INSERT INTO `roles` VALUES ('3', '测试角色1');
INSERT INTO `roles` VALUES ('4', '测试角色2');
INSERT INTO `roles` VALUES ('5', '测试角色3');

-- ----------------------------
-- Table structure for roles_user
-- ----------------------------
DROP TABLE IF EXISTS `roles_user`;
CREATE TABLE `roles_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) DEFAULT '2',
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rid` (`rid`),
  KEY `roles_user_ibfk_2` (`uid`),
  CONSTRAINT `roles_user_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `roles` (`id`),
  CONSTRAINT `roles_user_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles_user
-- ----------------------------
INSERT INTO `roles_user` VALUES ('1', '1', '1');
INSERT INTO `roles_user` VALUES ('2', '2', '2');
INSERT INTO `roles_user` VALUES ('3', '3', '3');
INSERT INTO `roles_user` VALUES ('4', '1', '4');


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `nickname` varchar(64) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `email` varchar(64) DEFAULT NULL,
  `userface` varchar(255) DEFAULT NULL,
  `regTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'quellanan', '', '$2a$10$Hv0YGLi/siOswCTP236MtOTWbClcM6rN1LCyqwfRmrwCJZqXHsj5a', '1', 'quellanan@qq.com','', '2017-12-08 09:30:22');

INSERT INTO `user` VALUES ('2', 'qaz', '', '$2a$10$6H69XLebCrGhHeHzDXEoH.0x8tMFS0XfdDPwI5s.Eu9pbqRpncA.G', '1', 'quellanan@qq.com','', '2017-12-08 09:30:22');

INSERT INTO `user` VALUES ('3', 'wsx', '', '$2a$10$6H69XLebCrGhHeHzDXEoH.0x8tMFS0XfdDPwI5s.Eu9pbqRpncA.G', '1', 'quellanan@qq.com','', '2017-12-08 09:30:22');

INSERT INTO `user` VALUES ('4', 'test', '', '$2a$10$6H69XLebCrGhHeHzDXEoH.0x8tMFS0XfdDPwI5s.Eu9pbqRpncA.G', '1', 'quellanan@qq.com','', '2017-12-08 09:30:22');


SET FOREIGN_KEY_CHECKS=1;
