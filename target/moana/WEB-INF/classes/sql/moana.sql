

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for CUSTOMER
-- ----------------------------
DROP TABLE IF EXISTS `CUSTOMER`;
CREATE TABLE `CUSTOMER` (
  `CUSTOMER_ID` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `ACTIVATETIME` bigint(20) DEFAULT NULL,
  `CREATEDATE` timestamp NULL DEFAULT NULL,
  `NICKNAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `PASSWORD` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `STATUS` int(11) NOT NULL,
  `TOKEN` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of CUSTOMER
-- ----------------------------

-- ----------------------------
-- Table structure for MOVIE
-- ----------------------------
DROP TABLE IF EXISTS `MOVIE`;
CREATE TABLE `MOVIE` (
  `MOVIE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CASTS` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `COUNTRIES` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `DIRECTORS` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `GENRES` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `POSTER` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `PRICE` float NOT NULL,
  `PUBDATES` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `SUMMARY` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `TITLE` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `VERSION` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `STATUS` int(1) DEFAULT NULL,
  PRIMARY KEY (`MOVIE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of MOVIE
-- ----------------------------
INSERT INTO `MOVIE` VALUES ('1', '马修·麦康纳 / 安妮·海瑟薇 / 杰西卡·查斯坦', '美国 / 英国 / 加拿大', '克里斯托弗·诺兰', '剧情 / 科幻 / 悬疑 / 家庭 / 冒险', 'Interstellar.jpg', '85', '2014-11-12(中国大陆) / 2014-11-07(美国)', '近未来的地球黄沙遍野，小麦、秋葵等基础农作物相继因枯萎病灭绝，人类不再像从前那样仰望星空，放纵想象力和灵感的迸发，而是每日在沙尘暴的肆虐下倒数着所剩不多的光景。在家务农的前NASA宇航员库珀（马修·麦康纳 Matthew McConaughey 饰）接连在女儿墨菲（麦肯吉·弗依 Mackenzie Foy 饰）的书房发现奇怪的重力场现象，随即得知在某个未知区域内前NASA成员仍秘密进行一个拯救人类的计划。', '星际穿越', '2D / IMAX', '1');
INSERT INTO `MOVIE` VALUES ('2', '马特·达蒙 / 杰西卡·查斯坦 / 克里斯汀·韦格', '美国 / 英国', '雷德利·斯科特', '剧情 / 科幻 / 冒险', 'TheMartian.jpg', '85', '2015-11-25(中国大陆) / 2015-10-02(美国)', '载人航天宇宙飞船阿瑞斯3号成功抵达火星，谁知一场破坏力极其巨大的风暴向宇航员们袭来，阿瑞斯3号被迫中断任务，紧急返航。撤离途中，宇航员马克·沃特尼（马特·达蒙 Matt Damon 饰）被飞船上吹落的零件击中，由于生还希望渺茫，队友们只得匆匆返航，并向世人宣告他已牺牲的事实。出乎意料的是，马克以极低的概率活了下来。他躲进驻火星的航天基地疗伤。', '火星救援', '3D', '1');
INSERT INTO `MOVIE` VALUES ('3', '尼古拉斯·凯奇 / 黛安·克鲁格 / 贾斯汀·巴萨', '美国', '乔·德特杜巴', '动作 / 悬疑 / 惊悚 / 冒险', 'NationalTreasure.jpg', '90', '2004-11-19(美国)', '盖茨家族是出名的冒险家家族。本（尼古拉斯•凯奇 Nicolas Cage 饰）小时候就获悉了他们家族的一个惊天秘密：美国开国时埋藏国家财富的地点就藏在《独立宣言》中。尽管父亲不想盖茨家族在纠缠于国家宝藏，但本还是与电脑高手雷利（贾斯汀•巴萨 Justin Bartha 饰）一起开始了寻宝行动。', '国家宝藏', '2D', '1');
INSERT INTO `MOVIE` VALUES ('4', '蕾妮·泽尔维格 / 科林·费尔斯 / 帕特里克·德姆西', '英国', '沙朗·马奎尔', '喜剧 / 爱情', 'BridgetJones\'sBaby.jpg', '70', '2017-01-01(中国大陆) / 2016-09-16(美国/英国)', '布里切特·琼斯（蕾妮·泽尔维格 Renée Zellweger 饰）偶然邂逅了帅气的亿万富翁杰克（帕特里克·德姆西 Patrick Dempsey 饰），同时，与她有着复杂情史的达西先生（柯林·费尔斯 Colin Firth 饰）也重新回她的身边。两个完美男人同时闯入布里切特的生活，并且给她带来了一个巨大的“惊喜”，让她深陷甜蜜的烦恼之中。而布里切特的真命天子究竟是谁呢？', '单身日记：好孕来袭', '2D', '1');
INSERT INTO `MOVIE` VALUES ('5', '金妮弗·古德温 / 杰森·贝特曼 / 伊德里斯·艾尔巴 / 珍妮·斯蕾特 / 内特·托伦斯', '美国', '拜伦·霍华德 / 瑞奇·摩尔 / 杰拉德·布什', '喜剧 / 动作 / 动画 / 冒险', 'Zootopia.jpg', '90', '2016-03-04(中国大陆/美国)', '故事发生在一个所有哺乳类动物和谐共存的美好世界中，兔子朱迪（金妮弗·古德温 Ginnifer Goodwin 配音）从小就梦想着能够成为一名惩恶扬善的刑警，凭借着智慧和努力，朱迪成功的从警校中毕业进入了疯狂动物城警察局，殊不知这里是大型肉食类动物的领地，作为第一只，也是唯一的小型食草类动物，朱迪会遇到怎样的故事呢？', '疯狂动物城', '3D / IMAX', '1');
INSERT INTO `MOVIE` VALUES ('6', '郭富城 / 梁家辉 / 杨采妮 / 彭于晏 / 李治廷', '中国大陆 / 香港', '梁乐民 / 陆剑青', '剧情 / 动作 / 犯罪', 'ColdWarⅡ.jpg', '70', '2016-07-08(中国大陆/香港)', '冲锋车案件主谋李家俊（彭于晏 饰）设计逃脱警方控制，与幕后黑手汇合，联手策划更大阴谋。而现警务处长刘杰辉（郭富城 饰），前警务副处长李文彬（梁家辉 饰），和资深大律师简奥伟（周润发 饰）被卷入其中，香港将面临更加大的危机……', '寒战2', '3D / IMAX', '1');
INSERT INTO `MOVIE` VALUES ('7', '乔·阿尔文 / 加内特·赫德兰 / 克里斯汀·斯图尔特 / 范·迪塞尔', '美国 / 英国 / 中国大陆', '李安', '剧情 / 战争', 'BillLynn\'sLongHalftimeWalk.jpg', '100', '2016-11-11(美国/中国大陆) / 2016-10-15(纽约电影节)', '伊拉克战争时期，来自美国德州的19岁技术兵比利·林恩（乔·阿尔文 Joe Alwyn 饰）因为一段偶然拍摄的视频而家喻户晓。那是一次规模不大却激烈非常的遭遇战，战斗中林恩所在的B班班长（范·迪塞尔 Vin Diesel 饰）遭到当地武装分子的伏击和劫持，而林恩为了营救班长不惜铤而走险冲锋陷阵。视频公布于世让他成为全美民众所崇拜的英雄，然而却鲜有人理解他和战友们所经历的一切。', '比利·林恩的中场战事', '3D', '1');
INSERT INTO `MOVIE` VALUES ('8', '周润发 / 杨紫琼 / 章子怡 / 张震 / 郑佩佩', '台湾 / 香港 / 美国 / 中国大陆', '李安', '剧情 / 动作 / 爱情 / 武侠 / 古装', 'CrouchingTigerHiddenDragon.jpg', '70', '2000-10-13(中国大陆) / 2000-05-16(戛纳电影节) / 2000-07-07(台湾) / 2000-07-13(香港) / 2001-01-12(美国)', '一代大侠李慕白（周润发饰）有退出江湖之意，托付红颜知己俞秀莲（杨紫琼饰）将青冥剑转交给贝勒爷（郎雄饰）收藏，不料当夜遭玉娇龙（章子怡）窃取。俞秀莲暗中查访也大约知道是玉府小姐玉蛟龙所为，她想办法迫使玉蛟龙归还宝剑，免伤和气。但李慕白发现了害死师傅的碧眼狐狸（郑佩佩饰）的踪迹，她隐匿于玉府并收玉蛟龙为弟子。而玉蛟龙欲以青冥剑来斩断阻碍罗小虎（张震饰）的枷锁，他们私定终身。', '卧虎藏龙', '2D', '1');

-- ----------------------------
-- Table structure for ORDERS
-- ----------------------------
DROP TABLE IF EXISTS `ORDERS`;
CREATE TABLE `ORDERS` (
  `ORDER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CUSTOMER_ID` varchar(50) DEFAULT NULL,
  `MOVIE_ID` int(11) DEFAULT NULL,
  `SCREEN_ID` int(11) DEFAULT NULL,
  `SEAT_NUMBER` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `TOTAL` float NOT NULL,
  `UNITS` int(11) NOT NULL,
  PRIMARY KEY (`ORDER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ORDERS
-- ----------------------------
INSERT INTO `ORDERS` VALUES ('64', 'ykfkindle@163.com', '1', '6', '197', '100', '1');

-- ----------------------------
-- Table structure for SCREEN
-- ----------------------------
DROP TABLE IF EXISTS `SCREEN`;
CREATE TABLE `SCREEN` (
  `SCREEN_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DATE` timestamp NULL DEFAULT NULL,
  `END_TIME` timestamp NULL DEFAULT NULL,
  `MOVIE_ID` int(11) DEFAULT NULL,
  `PRICE` float NOT NULL,
  `SEAT` int(11) NOT NULL,
  `START_TIME` timestamp NULL DEFAULT NULL,
  `VERSION` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `HALL` int(11) DEFAULT NULL,
  PRIMARY KEY (`SCREEN_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of SCREEN
-- ----------------------------
INSERT INTO `SCREEN` VALUES ('1', '2017-01-11 23:59:59', '2017-01-11 18:00:00', '1', '55', '43', '2017-01-11 17:00:00', '2D', '1');
INSERT INTO `SCREEN` VALUES ('2', '2017-01-05 23:59:59', '2017-01-11 20:00:00', '1', '200', '91', '2017-01-11 18:00:00', 'IMAX', '2');
INSERT INTO `SCREEN` VALUES ('3', '2017-01-11 23:59:59', '2017-01-11 11:00:00', '2', '90', '189', '2017-01-11 09:00:00', '3D', '1');
INSERT INTO `SCREEN` VALUES ('4', '2017-01-13 23:59:59', '2017-01-13 14:00:00', '3', '70', '200', '2017-01-13 12:00:00', '2D', '5');
INSERT INTO `SCREEN` VALUES ('5', '2017-01-13 23:59:59', '2017-01-13 17:00:00', '3', '70', '200', '2017-01-13 15:00:00', '2D', '5');
INSERT INTO `SCREEN` VALUES ('6', '2017-01-13 23:59:59', '2017-01-13 20:00:00', '3', '70', '200', '2017-01-13 18:00:00', '2D', '5');
INSERT INTO `SCREEN` VALUES ('7', '2017-01-14 23:59:59', '2017-01-14 10:00:00', '4', '90', '193', '2017-01-14 08:00:00', '3D', '1');
INSERT INTO `SCREEN` VALUES ('8', '2017-01-14 23:59:59', '2017-01-14 13:00:00', '4', '90', '200', '2017-01-14 11:00:00', '3D', '2');
INSERT INTO `SCREEN` VALUES ('9', '2017-01-14 23:59:59', '2017-01-14 16:00:00', '4', '90', '200', '2017-01-14 14:00:00', '3D', '3');
INSERT INTO `SCREEN` VALUES ('10', '2017-01-15 23:59:59', '2017-01-15 11:00:00', '5', '90', '196', '2017-01-15 09:00:00', '3D', '1');
INSERT INTO `SCREEN` VALUES ('11', '2017-01-15 23:59:59', '2017-01-15 14:00:00', '5', '200', '199', '2017-01-15 12:00:00', 'IMAX', '2');
INSERT INTO `SCREEN` VALUES ('12', '2017-01-15 23:59:59', '2017-01-15 20:00:00', '5', '200', '200', '2017-01-15 18:00:00', 'IMAX', '3');
INSERT INTO `SCREEN` VALUES ('13', '2017-01-16 23:59:59', '2017-01-16 10:00:00', '6', '100', '200', '2017-01-16 08:00:00', '3D', '1');
INSERT INTO `SCREEN` VALUES ('14', '2017-01-16 23:59:59', '2017-01-16 13:00:00', '6', '100', '200', '2017-01-16 11:00:00', '3D', '2');
INSERT INTO `SCREEN` VALUES ('15', '2017-01-16 23:59:59', '2017-01-16 16:00:00', '6', '100', '200', '2017-01-16 14:00:00', '3D', '3');
INSERT INTO `SCREEN` VALUES ('16', '2017-01-16 23:59:59', '2017-01-16 17:00:00', '6', '100', '200', '2017-01-16 15:00:00', '3D', '4');
INSERT INTO `SCREEN` VALUES ('17', '2017-01-17 23:59:59', '2017-01-17 10:00:00', '7', '100', '198', '2017-01-17 08:00:00', '3D', '1');
INSERT INTO `SCREEN` VALUES ('18', '2017-01-17 23:59:59', '2017-01-17 12:00:00', '7', '100', '200', '2017-01-17 10:00:00', '3D', '2');
INSERT INTO `SCREEN` VALUES ('19', '2017-01-17 23:59:59', '2017-01-17 16:00:00', '7', '100', '200', '2017-01-17 14:00:00', 'IMAX', '3');
INSERT INTO `SCREEN` VALUES ('20', '2017-01-17 23:59:59', '2017-01-17 20:00:00', '7', '100', '200', '2017-01-17 18:00:00', 'IMAX', '4');
INSERT INTO `SCREEN` VALUES ('21', '2017-01-18 23:59:59', '2017-01-18 10:00:00', '8', '100', '199', '2017-01-18 08:00:00', '2D', '1');
INSERT INTO `SCREEN` VALUES ('22', '2017-01-18 23:59:59', '2017-01-18 12:00:00', '8', '100', '200', '2017-01-18 10:00:00', '2D', '2');
INSERT INTO `SCREEN` VALUES ('23', '2017-01-18 23:59:59', '2017-01-18 14:00:00', '8', '100', '200', '2017-01-18 12:00:00', '2D', '3');
INSERT INTO `SCREEN` VALUES ('24', '2017-01-18 23:59:59', '2017-01-18 17:00:00', '8', '100', '200', '2017-01-18 15:00:00', '2D', '4');
INSERT INTO `SCREEN` VALUES ('25', '2017-01-18 23:59:59', '2017-01-18 19:00:00', '8', '100', '200', '2017-01-18 17:00:00', '2D', '5');
INSERT INTO `SCREEN` VALUES ('26', '2017-01-11 23:59:59', '2017-01-11 10:00:00', '1', '100', '200', '2017-01-11 08:00:00', '2D', '2');
INSERT INTO `SCREEN` VALUES ('27', '2017-01-11 23:59:59', '2017-01-11 14:00:00', '1', '100', '200', '2017-01-11 12:00:00', '2D', '3');
INSERT INTO `SCREEN` VALUES ('28', '2017-01-11 23:59:59', '2017-01-11 16:00:00', '1', '100', '200', '2017-01-11 14:00:00', '2D', '4');
INSERT INTO `SCREEN` VALUES ('29', '2017-01-11 23:59:59', '2017-01-11 22:00:00', '1', '100', '200', '2017-01-11 20:00:00', 'IMAX', '5');
INSERT INTO `SCREEN` VALUES ('30', '2017-01-12 23:59:59', '2017-01-12 10:00:00', '2', '100', '200', '2017-01-12 08:00:00', 'IMAX', '2');
INSERT INTO `SCREEN` VALUES ('31', '2017-01-12 23:59:59', '2017-01-12 12:00:00', '2', '100', '200', '2017-01-12 10:00:00', 'IMAX', '3');
