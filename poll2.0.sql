/*
Navicat MySQL Data Transfer

Source Server         : Test
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : poll2.0

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-07-02 10:12:37
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poll_answers
-- ----------------------------
INSERT INTO `poll_answers` VALUES ('1', 'ABCDACD', 'BC,CD,ACD', '我们组的人都超有材，说话又好听，我超喜欢这里', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poll_clazz
-- ----------------------------
INSERT INTO `poll_clazz` VALUES ('1', '超能特工队', '第八组', '1', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poll_grade
-- ----------------------------
INSERT INTO `poll_grade` VALUES ('1', '软开-Java', '软件开发与java强强联合', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poll_options
-- ----------------------------
INSERT INTO `poll_options` VALUES ('1', 'A', '认真', '10', '1');
INSERT INTO `poll_options` VALUES ('2', 'B', '还行', '8', '1');
INSERT INTO `poll_options` VALUES ('3', 'C', '一般', '5', '1');
INSERT INTO `poll_options` VALUES ('4', 'D', '不认真', '2', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poll_qq
-- ----------------------------
INSERT INTO `poll_qq` VALUES ('1', '3', '1');

-- ----------------------------
-- Table structure for poll_question
-- ----------------------------
DROP TABLE IF EXISTS `poll_question`;
CREATE TABLE `poll_question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `questionType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poll_question
-- ----------------------------
INSERT INTO `poll_question` VALUES ('1', '老师讲课认真吗？', '单选');

-- ----------------------------
-- Table structure for poll_questionnaire
-- ----------------------------
DROP TABLE IF EXISTS `poll_questionnaire`;
CREATE TABLE `poll_questionnaire` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poll_questionnaire
-- ----------------------------
INSERT INTO `poll_questionnaire` VALUES ('3', '老师教课怎么样？', '期末调研');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poll_school
-- ----------------------------
INSERT INTO `poll_school` VALUES ('1', '郑州轻工业大学', 'http://q1.qlogo.cn/g?b=qq&nk=741047261&s=100', '是大学不是学院喔', '科学大道', '666666', '@郑轻');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poll_survey
-- ----------------------------
INSERT INTO `poll_survey` VALUES ('1', '0', '1108', '2018-07-02', '2', '1', '1', '3');

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
INSERT INTO `poll_user` VALUES ('1', 'pibigstar', '男', '1996-02-02', '', null);
