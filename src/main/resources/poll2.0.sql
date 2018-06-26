/*
Navicat MySQL Data Transfer

Source Server         : briup
Source Server Version : 50553
Source Host           : 127.0.0.1:3306
Source Database       : poll2.0

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2018-06-25 08:12:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for poll_answers
-- ----------------------------
DROP TABLE IF EXISTS `poll_answers`;
CREATE TABLE `poll_answers` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `selections` varchar(255) DEFAULT NULL,
  `checkes` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `survey_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `survey_id` (`survey_id`),
  CONSTRAINT `poll_answers_ibfk_1` FOREIGN KEY (`survey_id`) REFERENCES `poll_survey` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poll_answers
-- ----------------------------

-- ----------------------------
-- Table structure for poll_clazz
-- ----------------------------
DROP TABLE IF EXISTS `poll_clazz`;
CREATE TABLE `poll_clazz` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` text,
  `grade_id` bigint(20) DEFAULT NULL,
  `charge_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `grade_id` (`grade_id`),
  KEY `charge_id` (`charge_id`),
  CONSTRAINT `poll_clazz_ibfk_1` FOREIGN KEY (`grade_id`) REFERENCES `poll_grade` (`id`),
  CONSTRAINT `poll_clazz_ibfk_2` FOREIGN KEY (`charge_id`) REFERENCES `poll_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poll_clazz
-- ----------------------------

-- ----------------------------
-- Table structure for poll_course
-- ----------------------------
DROP TABLE IF EXISTS `poll_course`;
CREATE TABLE `poll_course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` text,
  `period` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poll_course
-- ----------------------------
INSERT INTO `poll_course` VALUES ('2', 'Html', '超文本标记语言', '5');
INSERT INTO `poll_course` VALUES ('5', 'css2', '层叠样式表222', '5');
INSERT INTO `poll_course` VALUES ('7', '马克思主义', '非常神奇一个学科', '5');
INSERT INTO `poll_course` VALUES ('9', '列宁主义', '这是一个列宁主义', '4');
INSERT INTO `poll_course` VALUES ('10', '新增的课程', '17:04', '4');

-- ----------------------------
-- Table structure for poll_grade
-- ----------------------------
DROP TABLE IF EXISTS `poll_grade`;
CREATE TABLE `poll_grade` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `descriptioin` text,
  `school_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `school_id` (`school_id`),
  CONSTRAINT `poll_grade_ibfk_1` FOREIGN KEY (`school_id`) REFERENCES `poll_school` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poll_grade
-- ----------------------------

-- ----------------------------
-- Table structure for poll_options
-- ----------------------------
DROP TABLE IF EXISTS `poll_options`;
CREATE TABLE `poll_options` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `label` varchar(255) DEFAULT NULL,
  `name` text,
  `score` int(11) DEFAULT NULL,
  `question_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `question_id` (`question_id`),
  CONSTRAINT `poll_options_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `poll_question` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poll_options
-- ----------------------------

-- ----------------------------
-- Table structure for poll_qq
-- ----------------------------
DROP TABLE IF EXISTS `poll_qq`;
CREATE TABLE `poll_qq` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `questionnaire_id` bigint(20) DEFAULT NULL,
  `question_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `questionnaire_id` (`questionnaire_id`),
  KEY `question_id` (`question_id`),
  CONSTRAINT `poll_qq_ibfk_1` FOREIGN KEY (`questionnaire_id`) REFERENCES `poll_questionnaire` (`id`),
  CONSTRAINT `poll_qq_ibfk_2` FOREIGN KEY (`question_id`) REFERENCES `poll_question` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poll_qq
-- ----------------------------

-- ----------------------------
-- Table structure for poll_question
-- ----------------------------
DROP TABLE IF EXISTS `poll_question`;
CREATE TABLE `poll_question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `questionType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poll_question
-- ----------------------------

-- ----------------------------
-- Table structure for poll_questionnaire
-- ----------------------------
DROP TABLE IF EXISTS `poll_questionnaire`;
CREATE TABLE `poll_questionnaire` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poll_questionnaire
-- ----------------------------

-- ----------------------------
-- Table structure for poll_school
-- ----------------------------
DROP TABLE IF EXISTS `poll_school`;
CREATE TABLE `poll_school` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `logoPath` varchar(255) DEFAULT NULL,
  `description` text,
  `address` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `copyright` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poll_school
-- ----------------------------

-- ----------------------------
-- Table structure for poll_survey
-- ----------------------------
DROP TABLE IF EXISTS `poll_survey`;
CREATE TABLE `poll_survey` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `surveyDate` varchar(255) DEFAULT NULL,
  `course_id` bigint(20) DEFAULT NULL,
  `clazz_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `questionnaire_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `course_id` (`course_id`),
  KEY `clazz_id` (`clazz_id`),
  KEY `user_id` (`user_id`),
  KEY `questionnaire_id` (`questionnaire_id`),
  CONSTRAINT `poll_survey_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `poll_course` (`id`),
  CONSTRAINT `poll_survey_ibfk_2` FOREIGN KEY (`clazz_id`) REFERENCES `poll_clazz` (`id`),
  CONSTRAINT `poll_survey_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `poll_user` (`id`),
  CONSTRAINT `poll_survey_ibfk_4` FOREIGN KEY (`questionnaire_id`) REFERENCES `poll_questionnaire` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poll_survey
-- ----------------------------

-- ----------------------------
-- Table structure for poll_user
-- ----------------------------
DROP TABLE IF EXISTS `poll_user`;
CREATE TABLE `poll_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `birth` varchar(255) DEFAULT NULL,
  `hiredate` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poll_user
-- ----------------------------
INSERT INTO `poll_user` VALUES ('1', 'terry', '男', '1996-02-02', '', null);
