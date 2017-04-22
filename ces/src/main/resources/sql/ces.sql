/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : ces

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-04-22 20:46:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gene
-- ----------------------------
DROP TABLE IF EXISTS `gene`;
CREATE TABLE `gene` (
  `uuid` varchar(32) NOT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `value` varchar(100) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for national_ranking
-- ----------------------------
DROP TABLE IF EXISTS `national_ranking`;
CREATE TABLE `national_ranking` (
  `uuid` varchar(32) NOT NULL,
  `item_type` varchar(100) DEFAULT NULL,
  `key1` varchar(100) DEFAULT NULL,
  `gene_code1` varchar(100) DEFAULT NULL,
  `gene_name1` varchar(100) DEFAULT NULL,
  `gene_type1` varchar(100) DEFAULT NULL,
  `key2` varchar(100) DEFAULT NULL,
  `gene_code2` varchar(100) DEFAULT NULL,
  `gene_name2` varchar(100) DEFAULT NULL,
  `gene_type2` varchar(100) DEFAULT NULL,
  `ranking` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `uuid` varchar(32) NOT NULL,
  `score_id` varchar(100) NOT NULL,
  `number` varchar(100) DEFAULT NULL,
  `gene_code` varchar(100) DEFAULT NULL,
  `gene_name` varchar(100) DEFAULT NULL,
  `gene_type` varchar(100) DEFAULT NULL,
  `explosive_force` varchar(100) DEFAULT NULL,
  `explosive_force_score` double(100,0) DEFAULT NULL,
  `stamina` varchar(100) DEFAULT NULL,
  `stamina_score` double(100,0) DEFAULT NULL,
  `motion_sensitivity` varchar(100) DEFAULT NULL,
  `motion_sensitivity_score` double(100,0) DEFAULT NULL,
  `injury_recovery_ability` varchar(100) DEFAULT NULL,
  `injury_recovery_ability_score` double(100,0) DEFAULT NULL,
  `injury_risk` varchar(100) DEFAULT NULL,
  `injury_risk_score` double(100,0) DEFAULT NULL,
  `obesity_risk` varchar(100) DEFAULT NULL,
  `obesity_risk_score` double(100,0) DEFAULT NULL,
  `fat_reducing_sensitivity` varchar(100) DEFAULT NULL,
  `fat_reducing_sensitivity_score` double(100,0) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for score_female
-- ----------------------------
DROP TABLE IF EXISTS `score_female`;
CREATE TABLE `score_female` (
  `uuid` varchar(32) NOT NULL,
  `gene_code1` varchar(100) DEFAULT NULL,
  `gene_name1` varchar(100) DEFAULT NULL,
  `gene_type1` varchar(100) DEFAULT NULL,
  `gene_code2` varchar(100) DEFAULT NULL,
  `gene_name2` varchar(100) DEFAULT NULL,
  `gene_type2` varchar(100) DEFAULT NULL,
  `injury_risk` varchar(100) DEFAULT NULL,
  `injury_risk_score` double(100,0) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uuid` varchar(32) NOT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `sex` varchar(100) DEFAULT NULL,
  `position_384` varchar(100) DEFAULT NULL,
  `star` varchar(1) DEFAULT NULL COMMENT '1运动员2用户数据',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_score
-- ----------------------------
DROP TABLE IF EXISTS `user_score`;
CREATE TABLE `user_score` (
  `uuid` varchar(32) NOT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `gene_uuid` varchar(100) DEFAULT NULL,
  `score_uuid` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_score_female
-- ----------------------------
DROP TABLE IF EXISTS `user_score_female`;
CREATE TABLE `user_score_female` (
  `uuid` varchar(32) NOT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `gene_uuid` varchar(100) DEFAULT NULL,
  `score_female_uuid` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
