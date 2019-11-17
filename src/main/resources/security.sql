/*
 Navicat Premium Data Transfer

 Source Server         : 1
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : 1it.top:3306
 Source Schema         : security

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 17/11/2019 15:34:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for se_role
-- ----------------------------
DROP TABLE IF EXISTS `se_role`;
CREATE TABLE `se_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of se_role
-- ----------------------------
INSERT INTO `se_role` VALUES (1, 1, 'vip1', '2019-11-17 15:27:04', NULL);
INSERT INTO `se_role` VALUES (3, 2, 'vip2', '2019-11-17 15:27:26', NULL);
INSERT INTO `se_role` VALUES (4, 2, 'vip3', '2019-11-17 15:27:35', NULL);
INSERT INTO `se_role` VALUES (5, 3, 'vip1', '2019-11-17 15:28:00', NULL);
INSERT INTO `se_role` VALUES (6, 3, 'vip2', '2019-11-17 15:28:08', NULL);
INSERT INTO `se_role` VALUES (7, 3, 'vip3', '2019-11-17 15:28:16', NULL);

-- ----------------------------
-- Table structure for se_user
-- ----------------------------
DROP TABLE IF EXISTS `se_user`;
CREATE TABLE `se_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_titme` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of se_user
-- ----------------------------
INSERT INTO `se_user` VALUES (1, '张三', '123', '123', 1, '2019-11-17 15:26:10', NULL);
INSERT INTO `se_user` VALUES (2, '李四', 'user', '123', 1, '2019-11-17 15:26:28', NULL);
INSERT INTO `se_user` VALUES (3, '管理员', 'admin', 'admin', 1, '2019-11-17 15:26:46', NULL);

SET FOREIGN_KEY_CHECKS = 1;
