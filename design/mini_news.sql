/*
 Navicat Premium Data Transfer

 Source Server         : tencentCloud
 Source Server Type    : MySQL
 Source Server Version : 50718 (5.7.18-cynos-log)
 Source Host           : bj-cynosdbmysql-grp-og8zp5ro.sql.tencentcdb.com:26956
 Source Schema         : mini_news

 Target Server Type    : MySQL
 Target Server Version : 50718 (5.7.18-cynos-log)
 File Encoding         : 65001

 Date: 11/05/2023 21:53:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(11) NOT NULL COMMENT '评论ID',
  `news_id` int(11) NOT NULL COMMENT '新闻ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `time` datetime NULL DEFAULT NULL COMMENT '评论发布时间',
  `text` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '评论内容',
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `comment-news`(`news_id`) USING BTREE,
  INDEX `comment-user`(`user_id`) USING BTREE,
  CONSTRAINT `comment-news` FOREIGN KEY (`news_id`) REFERENCES `news` (`news_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `comment-user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for favourite
-- ----------------------------
DROP TABLE IF EXISTS `favourite`;
CREATE TABLE `favourite`  (
  `favourite_id` int(11) NOT NULL COMMENT '收藏ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `news_id` int(11) NOT NULL COMMENT '新闻ID',
  PRIMARY KEY (`favourite_id`) USING BTREE,
  INDEX `favourite-user`(`user_id`) USING BTREE,
  INDEX `favourite-news`(`news_id`) USING BTREE,
  CONSTRAINT `favourite-news` FOREIGN KEY (`news_id`) REFERENCES `news` (`news_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `favourite-user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `news_id` int(11) NOT NULL COMMENT '新闻ID',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '新闻标题',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '新闻作者',
  `time` datetime NULL DEFAULT NULL COMMENT '新闻发布时间',
  `text` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '新闻内容',
  `favourite_num` int(11) NOT NULL DEFAULT 0 COMMENT '新闻收藏数',
  PRIMARY KEY (`news_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `phone_number` int(11) NULL DEFAULT NULL COMMENT '用户手机号',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
