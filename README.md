# Home-Automation

Setup:

This application uses MySQL DB.
List of queries to be run in Mysql:
create database homeautomation;

CREATE TABLE homeautomation.`devices` (
  `DeviceID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DeviceName` varchar(100) NOT NULL,
  `UserId` char(36) NOT NULL,
  PRIMARY KEY (`DeviceID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

Insert into homeautomation.devices (DeviceName, UserId) values ("Phone", "6c57599f-2c43-4c82-806a-e07c3410f5d3");
Insert into homeautomation.devices (DeviceName, UserId) values ("Laptop", "6c57599f-2c43-4c82-806a-e07c3410f5d3");
Insert into homeautomation.devices (DeviceName, UserId) values ("Smart Watch", "f48fdd16-92db-4188-854d-1ecd9b62d066");
Insert into homeautomation.devices (DeviceName, UserId) values ("TV", "f48fdd16-92db-4188-854d-1ecd9b62d066");


change the following In application.properties file:

1) spring.datasource.url=jdbc:mysql://173.3.0.4/homeautomation?useSSL=false&zeroDateTimeBehavior=convertToNull

This config by default uses the DB named homeautomation in mysqsl. Query for DB creation is given in the list of queries above.

2) spring.datasource.username=username
3) spring.datasource.password=password

Provide Mysql Credentials in these configs. Default username is "username". Default password is "password".

This Project Supports 4 APIs currently

1) List all smart devices of a user from DB
2) Add new smart device for a user
3) Remove an installed device for a user
4) Perform an operation on a device
