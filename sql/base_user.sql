/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50540
Source Host           : 127.0.0.1:3306
Source Database       : base_user

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2017-09-07 09:15:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `id` bigint(20) NOT NULL,
  `breand_id` bigint(20) NOT NULL,
  `company_code` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `company_code` (`company_code`,`breand_id`),
  UNIQUE KEY `brand_company_code_breand_id` (`company_code`,`breand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(54) NOT NULL COMMENT '登录用户名',
  `nick_name` varchar(128) DEFAULT NULL COMMENT '昵称',
  `email` varchar(128) NOT NULL COMMENT '邮箱',
  `password` varchar(64) NOT NULL,
  `phone` varchar(128) DEFAULT NULL COMMENT '电话',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_by` varchar(64) DEFAULT NULL COMMENT '修改者',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_info_role
-- ----------------------------
DROP TABLE IF EXISTS `user_info_role`;
CREATE TABLE `user_info_role` (
  `id` bigint(20) NOT NULL,
  `user_info_id` bigint(20) NOT NULL,
  `user_role_id` bigint(20) NOT NULL COMMENT '用户角色标识',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_by` varchar(64) DEFAULT NULL COMMENT '修改者',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_permission
-- ----------------------------
DROP TABLE IF EXISTS `user_permission`;
CREATE TABLE `user_permission` (
  `id` bigint(20) NOT NULL,
  `name` varchar(128) DEFAULT NULL COMMENT '权限名称',
  `resources` varchar(512) NOT NULL COMMENT '资源项字符串',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_by` varchar(64) DEFAULT NULL COMMENT '修改者',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(128) DEFAULT NULL COMMENT '角色名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `user_role_permission`;
CREATE TABLE `user_role_permission` (
  `id` bigint(20) NOT NULL,
  `user_role_id` bigint(20) NOT NULL COMMENT '用户角色主键',
  `user_permission_id` bigint(20) NOT NULL COMMENT '用户权限主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_by` varchar(64) DEFAULT NULL COMMENT '修改者',
  `is_deleted` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
