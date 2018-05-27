/*
 Navicat Premium Data Transfer

 Source Server         : localhst
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : localhost
 Source Database       : test

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : utf-8

 Date: 05/28/2018 00:46:58 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `_timestamp` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `student`
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES ('1', 'zhang1', '1', '21', '2018-05-28 00:21:58', '澳门特别行政区 澳门半岛', '0', '2018-05-28 00:25:41'), ('2', 'zhang2', '0', '22', '2018-05-03 00:22:04', '湖北省 十堰市 郧西县', '0', '2018-05-28 00:25:41'), ('3', 'zhang3', '1', '31', '2018-05-28 00:22:02', '河南省 三门峡市 卢氏县', '0', '2018-05-28 00:25:41'), ('4', 'tom1', '1', '23', '2018-05-06 00:22:08', '江苏省 淮安市 清河区', '0', '2018-05-28 00:25:41'), ('5', 'tom2', '0', '25', '2018-05-26 00:22:11', '新疆维吾尔自治区 巴音郭楞蒙古自治州 轮台县', '0', '2018-05-28 00:25:41'), ('6', 'tom3', '0', '26', '2018-05-10 00:22:14', '湖北省 恩施土家族苗族自治州 建始县', '0', '2018-05-28 00:25:41'), ('7', 'jack1', '0', '23', '2018-05-05 00:22:17', '甘肃省 天水市 麦积区', '0', '2018-05-28 00:25:41'), ('8', 'jack2', '1', '21', '2018-05-13 00:22:21', '福建省 莆田市 涵江区', '0', '2018-05-28 00:25:41'), ('9', 'jack3', '1', '22', '2018-05-20 00:22:24', '上海 上海市 宝山区', '0', '2018-05-28 00:25:41'), ('10', 'lilli1', '1', '26', '2018-05-27 00:22:28', '青海省 黄南藏族自治州 其它区', '0', '2018-05-28 00:25:41'), ('11', 'lili2', '0', '27', '2018-05-14 00:22:31', '广东省 佛山市 高明区', '0', '2018-05-28 00:25:41'), ('12', 'lili3', '0', '28', '2018-05-18 00:22:36', '福建省 龙岩市 长汀县', '0', '2018-05-28 00:25:41');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
