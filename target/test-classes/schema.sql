DROP TABLE IF EXISTS `devices`;
CREATE TABLE `devices` (
  `DeviceID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DeviceName` varchar(100) NOT NULL,
  `UserId` char(36) NOT NULL,
  PRIMARY KEY (`DeviceID`)
) DEFAULT CHARSET=utf8;