
SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


CREATE DATABASE `pickup`;
use `pickup`;
CREATE TABLE IF NOT EXISTS `pick_lines` (
  `line_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `author` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `line` text CHARACTER SET utf8 COLLATE utf8_bin,
  `created` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `likes` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`line_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=0 ;


