DROP DATABASE IF EXISTS `elements`;

CREATE DATABASE `elements`;

USE `elements`;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id`       TINYINT(3) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '管理员ID',
  `username` CHAR(20)            NOT NULL
  COMMENT '管理员账号',
  `password` CHAR(32)            NOT NULL
  COMMENT '管理员密码',
  `power`    CHAR(1)             NOT NULL
  COMMENT '管理员权限:高级(1).普通(0)',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='管理员表';

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `id`        INT(10) UNSIGNED       NOT NULL AUTO_INCREMENT
  COMMENT '医生ID',
  `username`  CHAR(20)               NOT NULL
  COMMENT '医生账号',
  `password`  CHAR(32)               NOT NULL
  COMMENT '医生密码',
  `real_name` CHAR(40)               NOT NULL
  COMMENT '医生姓名',
  `mail`      CHAR(40) UNIQUE        NOT NULL
  COMMENT '医生邮件',
  `state`     CHAR(1)                NOT NULL
  COMMENT '医生激活状态:审核通过(1).未审核(0)',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='医生表';

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS category;
CREATE TABLE `category` (
  `id`         INT(10) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT 'ID',
  `phone`      CHAR(12) UNIQUE  NOT NULL
  COMMENT '电话号码',
  `feature`    CHAR(1)          NOT NULL
  COMMENT '脸形特点',
  `complexion` CHAR(1)          NOT NULL
  COMMENT '面色特点',
  `trunk`      CHAR(1)          NOT NULL
  COMMENT '躯干特点',
  `limb`       CHAR(1)          NOT NULL
  COMMENT '四肢特点',
  `voice`      CHAR(1)          NOT NULL
  COMMENT '语音特点',
  `psychology` CHAR(1)          NOT NULL
  COMMENT '心理特征',
  `disease`    CHAR(1)          NOT NULL
  COMMENT '好发病位',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='五行分类条目表';

-- ----------------------------
-- Table structure for item_wood
-- ----------------------------
DROP TABLE IF EXISTS `item_wood`;
CREATE TABLE `item_wood` (
  `id`            INT(10) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT 'ID',
  `phone`         CHAR(12) UNIQUE  NOT NULL
  COMMENT '电话号码',
  `complexion`    CHAR(1)          NOT NULL
  COMMENT '面色特点',
  `psychology`    CHAR(1)          NOT NULL
  COMMENT '心理特征',
  `cold`          CHAR(1)          NOT NULL
  COMMENT '寒热',
  `sweat`         CHAR(1)          NOT NULL
  COMMENT '汗证',
  `diet`          CHAR(1)          NOT NULL
  COMMENT '饮食口味',
  `shit`          CHAR(1)          NOT NULL
  COMMENT '大便',
  `urine`         CHAR(1)          NOT NULL
  COMMENT '小便',
  `sleep`         CHAR(1)          NOT NULL
  COMMENT '睡眠',
  `dizzy`         CHAR(1)          NOT NULL
  COMMENT '头晕目眩',
  `eyes`          CHAR(1)          NOT NULL
  COMMENT '双目症状',
  `chest`         CHAR(1)          NOT NULL
  COMMENT '胸胁症状',
  `limbs`         CHAR(1)          NOT NULL
  COMMENT '肢体症状',
  `menstruate`    CHAR(1)                   DEFAULT NULL
  COMMENT '月经症状',
  `season`        CHAR(1)          NOT NULL
  COMMENT '好发季节',
  `qualitative_a` TINYINT(4)       NOT NULL
  COMMENT '正定性值',
  `qualitative_k` TINYINT(4)       NOT NULL
  COMMENT '负定性值',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='木表';

-- ----------------------------
-- Table structure for item_fire
-- ----------------------------
DROP TABLE IF EXISTS `item_fire`;
CREATE TABLE `item_fire` (
  `id`            INT(10) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT 'ID',
  `phone`         CHAR(12) UNIQUE  NOT NULL
  COMMENT '电话号码',
  `complexion`    CHAR(1)          NOT NULL
  COMMENT '面色特点',
  `psychology`    CHAR(1)          NOT NULL
  COMMENT '心理特征',
  `cold`          CHAR(1)          NOT NULL
  COMMENT '寒热',
  `sweat`         CHAR(1)          NOT NULL
  COMMENT '汗证',
  `diet`          CHAR(1)          NOT NULL
  COMMENT '饮食口味',
  `urine`         CHAR(1)          NOT NULL
  COMMENT '小便',
  `sleep`         CHAR(1)          NOT NULL
  COMMENT '睡眠',
  `mental`        CHAR(1)          NOT NULL
  COMMENT '精神状态',
  `lips`          CHAR(1)          NOT NULL
  COMMENT '口唇症状',
  `mind`          CHAR(1)          NOT NULL
  COMMENT '心胸症状',
  `prone`         CHAR(1)          NOT NULL
  COMMENT '易发症状',
  `season`        CHAR(1)          NOT NULL
  COMMENT '好发季节',
  `qualitative_a` TINYINT(4)       NOT NULL
  COMMENT '正定性值',
  `qualitative_k` TINYINT(4)       NOT NULL
  COMMENT '负定性值',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='火表';

-- ----------------------------
-- Table structure for item_earth
-- ----------------------------
DROP TABLE IF EXISTS `item_earth`;
CREATE TABLE `item_earth` (
  `id`            INT(10) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT 'ID',
  `phone`         CHAR(12) UNIQUE  NOT NULL
  COMMENT '电话号码',
  `complexion`    CHAR(1)          NOT NULL
  COMMENT '面色特点',
  `psychology`    CHAR(1)          NOT NULL
  COMMENT '心理特征',
  `diet`          CHAR(1)          NOT NULL
  COMMENT '饮食口味',
  `shit`          CHAR(1)          NOT NULL
  COMMENT '大便',
  `mental`        CHAR(1)          NOT NULL
  COMMENT '精神状态',
  `body`          CHAR(1)          NOT NULL
  COMMENT '头身症状',
  `lips`          CHAR(1)          NOT NULL
  COMMENT '口唇症状',
  `stomach`       CHAR(1)          NOT NULL
  COMMENT '胃脘症状',
  `season`        CHAR(1)          NOT NULL
  COMMENT '好发季节',
  `qualitative_a` TINYINT(4)       NOT NULL
  COMMENT '正定性值',
  `qualitative_k` TINYINT(4)       NOT NULL
  COMMENT '负定性值',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='土表';

-- ----------------------------
-- Table structure for item_metal
-- ----------------------------
DROP TABLE IF EXISTS `item_metal`;
CREATE TABLE `item_metal` (
  `id`            INT(10) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT 'ID',
  `phone`         CHAR(12) UNIQUE  NOT NULL
  COMMENT '电话号码',
  `complexion`    CHAR(1)          NOT NULL
  COMMENT '面色特点',
  `psychology`    CHAR(1)          NOT NULL
  COMMENT '心理特征',
  `sweat`         CHAR(1)          NOT NULL
  COMMENT '汗证',
  `diet`          CHAR(1)          NOT NULL
  COMMENT '饮食口味',
  `shit`          CHAR(1)          NOT NULL
  COMMENT '大便',
  `mental`        CHAR(1)          NOT NULL
  COMMENT '精神状态',
  `cough`         CHAR(1)          NOT NULL
  COMMENT '咳嗽',
  `expectoration` CHAR(1)          NOT NULL
  COMMENT '咯痰',
  `nose`          CHAR(1)          NOT NULL
  COMMENT '鼻部症状',
  `skin`          CHAR(1)          NOT NULL
  COMMENT '皮肤',
  `season`        CHAR(1)          NOT NULL
  COMMENT '好发季节',
  `qualitative_a` TINYINT(4)       NOT NULL
  COMMENT '正定性值',
  `qualitative_k` TINYINT(4)       NOT NULL
  COMMENT '负定性值',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='金表';

-- ----------------------------
-- Table structure for item_water
-- ----------------------------
DROP TABLE IF EXISTS `item_water`;
CREATE TABLE `item_water` (
  `id`            INT(10) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT 'ID',
  `phone`         CHAR(12) UNIQUE  NOT NULL
  COMMENT '电话号码',
  `complexion`    CHAR(1)          NOT NULL
  COMMENT '面色特点',
  `psychology`    CHAR(1)          NOT NULL
  COMMENT '心理特征',
  `sweat`         CHAR(1)          NOT NULL
  COMMENT '汗证',
  `urine`         CHAR(1)          NOT NULL
  COMMENT '小便',
  `waist`         CHAR(1)          NOT NULL
  COMMENT '腰膝症状',
  `sexuality`     CHAR(1)          NOT NULL
  COMMENT '性欲',
  `spermatorrhea` CHAR(1)                   DEFAULT NULL
  COMMENT '遗精',
  `menstruate`    CHAR(1)                   DEFAULT NULL
  COMMENT '月经症状',
  `leucorrhea`    CHAR(1)                   DEFAULT NULL
  COMMENT '带下症状',
  `season`        CHAR(1)          NOT NULL
  COMMENT '好发季节',
  `qualitative_a` TINYINT(4)       NOT NULL
  COMMENT '正定性值',
  `qualitative_k` TINYINT(4)       NOT NULL
  COMMENT '负定性值',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='水表';

-- ----------------------------
-- Table structure for conclusion
-- ----------------------------
DROP TABLE IF EXISTS `conclusion`;
CREATE TABLE `conclusion` (
  `id`            INT(10) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT 'ID',
  `phone`         CHAR(12) UNIQUE  NOT NULL
  COMMENT '电话号码',
  `real_name`     CHAR(40)         NOT NULL
  COMMENT '姓名',
  `sex`           CHAR(3)          NOT NULL
  COMMENT '性别',
  `solar_birth`   CHAR(20)         NOT NULL
  COMMENT '公历出生日期',
  `lunar_birth`   CHAR(20)         NOT NULL
  COMMENT '农历出生日期',
  `niangan`       CHAR(3)                   DEFAULT NULL
  COMMENT '年干',
  `nianzhi`       CHAR(3)                   DEFAULT NULL
  COMMENT '年支',
  `yuegan`        CHAR(3)                   DEFAULT NULL
  COMMENT '月干',
  `yuezhi`        CHAR(3)                   DEFAULT NULL
  COMMENT '月支',
  `rigan`         CHAR(3)                   DEFAULT NULL
  COMMENT '日干',
  `rizhi`         CHAR(3)                   DEFAULT NULL
  COMMENT '日支',
  `shigan`        CHAR(3)                   DEFAULT NULL
  COMMENT '时干',
  `shizhi`        CHAR(3)                   DEFAULT NULL
  COMMENT '时支',
  `wood`          FLOAT                     DEFAULT NULL
  COMMENT '木',
  `fire`          FLOAT                     DEFAULT NULL
  COMMENT '火',
  `earth`         FLOAT                     DEFAULT NULL
  COMMENT '土',
  `metal`         FLOAT                     DEFAULT NULL
  COMMENT '金',
  `water`         FLOAT                     DEFAULT NULL
  COMMENT '水',
  `inborn_genus`  CHAR(5)                   DEFAULT NULL
  COMMENT '先天五行所属,11000',
  `inborn_lack`   CHAR(5)                   DEFAULT NULL
  COMMENT '先天五行所缺,00111',
  `acquire_genus` CHAR(5)          NOT NULL
  COMMENT '后天五行所属,11000',
  `acquire_lack`  CHAR(5)          NOT NULL
  COMMENT '后天五行所缺,缺:00111,次:00222',

  `yang_value1`   TINYINT                   DEFAULT NULL
  COMMENT '所属阳值1',
  `yang_value2`   TINYINT                   DEFAULT NULL
  COMMENT '所属阳值2',
  `yang_value3`   TINYINT                   DEFAULT NULL
  COMMENT '所属阳值3',
  `yin_value1`    TINYINT                   DEFAULT NULL
  COMMENT '所属阴值1',
  `yin_value2`    TINYINT                   DEFAULT NULL
  COMMENT '所属阴值2',
  `yin_value3`    TINYINT                   DEFAULT NULL
  COMMENT '所属阴值3',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='结论总表';