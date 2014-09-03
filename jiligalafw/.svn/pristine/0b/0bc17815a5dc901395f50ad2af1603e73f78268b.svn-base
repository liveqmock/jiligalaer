
delete from basic_user_role;
delete from basic_role_res;
delete from basic_resource;
delete from basic_role;


/** 角色 */

insert into `basic_role` (`ROLE_ID`, `ROLE_NAME`, `DESCRIPTION`, `REMARK`, `PRIORITY`, `DATA_AUTH`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`,`ROLE_FLAG`) values('1','管理员','',NULL,'1','UNLIMITED','1','Sys','2013-09-05 20:40:19','系统管理员','2013-09-08 20:36:53','0');
insert into `basic_role` (`ROLE_ID`, `ROLE_NAME`, `DESCRIPTION`, `REMARK`, `PRIORITY`, `DATA_AUTH`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`,`ROLE_FLAG`) values('2','账户','',NULL,'2','UNLIMITED','1','Sys','2013-09-05 20:40:19','系统管理员','2013-09-08 20:31:59','1');
insert into `basic_role` (`ROLE_ID`, `ROLE_NAME`, `DESCRIPTION`, `REMARK`, `PRIORITY`, `DATA_AUTH`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`,`ROLE_FLAG`) values('3','用户','',NULL,'3','UNLIMITED','1','Sys','2013-09-05 20:40:19','系统管理员','2013-09-08 20:34:59','2');

/** 用户角色 */

insert into `basic_user_role` (`USER_ROLE_ID`, `USER_ID`, `ROLE_ID`) values('1','admin001','1');
insert into `basic_user_role` (`USER_ROLE_ID`, `USER_ID`, `ROLE_ID`) values('2','devaccount001','2');
insert into `basic_user_role` (`USER_ROLE_ID`, `USER_ID`, `ROLE_ID`) values('3','devuser001','3');



/** 资源 --2013-09-20*/

insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('homepage',NULL,'000','1','首页',NULL,'0','1','Sys','2013-09-08 09:38:27',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('userManagement',NULL,'001','1','用户管理',NULL,'1','1','Sys','2013-09-08 09:38:27',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('acManagement',NULL,'002','1','账户管理',NULL,'2','1','Sys','2013-09-08 09:38:27',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('prodManagement',NULL,'003','1','产品管理',NULL,'3','1','Sys','2013-09-08 09:38:27',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('myResources',NULL,'004','1','我的资源',NULL,'4','1','Sys','2013-09-08 09:38:27',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('marketAct',NULL,'005','1','市场活动',NULL,'5','1','Sys','2013-09-08 09:38:27',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('financeManagement',NULL,'007','1','财务管理',NULL,'7','1','Sys','2013-09-08 09:38:27',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('omManagement',NULL,'008','1','运维管理',NULL,'8','1','Sys','2013-09-08 09:38:27',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('swManagement',NULL,'009','1','软件管理',NULL,'9','1','Sys','2013-09-08 09:38:27',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('rptManagement',NULL,'010','1','统计报表',NULL,'10','1','Sys','2013-09-08 09:38:27',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('prodBuy',NULL,'011','1','产品购买','/quickBuy/selectVm.do','11','1','Sys','2013-09-08 09:38:27',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('myBills',NULL,'012','1','我的账单','','12','1','系统管理员','2013-09-08 20:00:28',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('adminPanel','homepage','000000','2','控制板','/panel/adminPanel.do','0','1','Sys','2013-09-08 09:38:27',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('myNotice','homepage','000001','2','我的公告','/noticeMessages/list.do','1','1','Sys','2013-09-08 09:38:27',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('myWarning','homepage','000002','2','我的警告','/warning/myWarning.do','2','1','Sys','2013-09-08 09:38:27',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('myRemind','homepage','000003','2','我的提醒','/remind/myRemind.do','3','1','Sys','2013-09-08 09:38:27',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('accountPanel','homepage','000004','2','控制板','/panel/accountPanel.do','0','1','Sys','2013-09-08 09:38:27',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('userInfo','userManagement','001001','2','用户信息','/user/list.do','1','1','Sys','2013-09-06 20:01:55',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('userPermission','userManagement','001002','2','用户权限',NULL,'2','1','Sys','2013-09-06 20:01:55',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('userApproval','userManagement','001003','2','用户审批','/userApproval/list.do','3','1','Sys','2013-09-06 20:01:55',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('resourcesApproval','userManagement','001004','2','资源审批','/resourcesApproval/list.do','4','1','Sys','2013-09-06 20:01:55',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('accountInfo','acManagement','002001','2','账户信息','/account/list.do','1','1',NULL,NULL,NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('accountApproval','acManagement','002002','2','账户审批','/accApproval/list.do','2','1',NULL,NULL,NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('resManagement','omManagement','008000','2','资源管理','/resource/list.do','0','1','Sys','2013-09-08 09:38:27',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('roleManagement','omManagement','008001','2','角色管理','/role/list.do','1','1','Sys','2013-09-08 09:38:27',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('permissionManagement','omManagement','008002','2','权限管理',NULL,'2','1','Sys','2013-09-08 09:38:27',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('402880e640fcfb3d0140fd6bd8780000','homepage','000005','2','我的订单','/order/myOrder.do','5','1','系统管理员','2013-09-08 19:53:58',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('402880e640fcfb3d0140fd6d34050001','homepage','000006','2','我的本期账单','/bill/myBill.do','6','1','系统管理员','2013-09-08 19:55:27',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('402880e640fcfb3d0140fd6ddaf10002','homepage','000007','2','促销信息','/promotion/promotionInfo.do','7','1','系统管理员','2013-09-08 19:56:09',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('402880e640fcfb3d0140fd70216c0003','myResources','004000','2','我的虚拟机','/vmware/list.do','1','1','系统管理员','2013-09-08 19:58:38','系统管理员','2013-09-19 16:44:30','navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('402880e640fcfb3d0140fd70722d0004','myResources','004001','2','我的网络','/network/list.do','2','1','系统管理员','2013-09-08 19:58:59','系统管理员','2013-09-19 21:48:03','navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('402880e640fcfb3d0140fd7220010006','myBills','012000','2','充值','/onlinePay/list.do','1','1','系统管理员','2013-09-08 20:00:49','系统管理员','2013-09-18 23:30:06','navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('402880e640fcfb3d0140fd726d950007','myBills','012001','2','退款','/applyRefund/list.do','2','1','系统管理员','2013-09-08 20:01:09','系统管理员','2013-09-18 23:38:40','navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('402880e640fcfb3d0140fd72db120008','myBills','012002','2','账单','/bill/myBill.do','3','1','系统管理员','2013-09-08 20:01:37','系统管理员','2013-09-18 21:25:40','navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('402880e640fcfb3d0140fd7558eb0009','homepage','000008','2','账户设置','/basicUserQuota/edit.do','8','1','系统管理员','2013-09-08 20:04:20',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('402880e640fcfb3d0140fd764c63000a','prodManagement','003000','2','单一产品','/singleProd/list.do','1','1','系统管理员','2013-09-08 20:05:23','系统管理员','2013-09-14 21:15:21','navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('402880e640fcfb3d0140fd7694d1000b','prodManagement','003001','2','组合产品','/combinProd/list.do','2','1','系统管理员','2013-09-08 20:05:41','系统管理员','2013-09-14 21:15:41','navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('402880e640fcfb3d0140fd77f330000c','prodManagement','003002','2','定价','/makePrice/list.do','3','1','系统管理员','2013-09-08 20:07:11','系统管理员','2013-09-14 21:16:21','navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('402880e640fcfb3d0140fd812f1a0012','financeManagement','007000','2','账户充值','/accPay/list.do','1','1','系统管理员','2013-09-08 20:17:16','系统管理员','2013-09-15 15:30:30','navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('402880e640fcfb3d0140fd819ae00013','financeManagement','007001','2','账户退款','/refund/list.do','2','1','系统管理员','2013-09-08 20:17:44','系统管理员','2013-09-15 17:08:20','navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('402880e640fcfb3d0140fd821fc60014','financeManagement','007002','2','账户余额','/balance/list.do','3','1','系统管理员','2013-09-08 20:18:18','系统管理员','2013-09-15 17:38:56','navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('402880e640fcfb3d0140fd82da580015','financeManagement','007003','2','账户扣费账单','/accBills/list.do','4','1','系统管理员','2013-09-08 20:19:05','系统管理员','2013-09-15 17:42:39','navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('402880e640fcfb3d0140fd8424450016','omManagement','008003','2','管理员信息','/admin/list.do','4','1','系统管理员','2013-09-08 20:20:30',NULL,NULL,'navigation');
insert into `basic_resource` (`RES_ID`, `PARENT_RES_ID`, `SUB_CODE`, `LEVEL_CODE`, `RES_NAME`, `RES_URL`, `SORT`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`, `RES_TYPE`) values('402880e6411fa8c901411ff763b70000','marketAct','005005','2','促销活动','/promotion/list.do','0','1','系统管理员','2013-09-15 12:53:28','系统管理员','2013-09-15 12:54:47','navigation');


/** 角色资源 */

insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696b0028','1','402880e640fcfb3d0140fd72db120008');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696b0024','1','prodBuy');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696b0025','1','myBills');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696b0026','1','402880e640fcfb3d0140fd7220010006');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696b0027','1','402880e640fcfb3d0140fd726d950007');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696b0022','1','permissionManagement');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696b0023','1','402880e640fcfb3d0140fd8424450016');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696b0021','1','roleManagement');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696b0020','1','resManagement');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696b001f','1','omManagement');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696b001d','1','402880e640fcfb3d0140fd821fc60014');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696b001e','1','402880e640fcfb3d0140fd82da580015');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696a001b','1','402880e640fcfb3d0140fd812f1a0012');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696b001c','1','402880e640fcfb3d0140fd819ae00013');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696a001a','1','financeManagement');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696a0019','1','402880e6411fa8c901411ff763b70000');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696a0018','1','marketAct');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696a0017','1','402880e640fcfb3d0140fd70722d0004');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696a0016','1','402880e640fcfb3d0140fd70216c0003');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696a0015','1','myResources');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696a0014','1','402880e640fcfb3d0140fd77f330000c');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696a0013','1','402880e640fcfb3d0140fd7694d1000b');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696a0012','1','402880e640fcfb3d0140fd764c63000a');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696a0011','1','prodManagement');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a01413722696a0010','1','accountApproval');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a014137226968000f','1','accountInfo');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a014137226968000e','1','acManagement');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a014137226968000d','1','resourcesApproval');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a014137226968000c','1','userApproval');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a014137226968000a','1','userInfo');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a014137226968000b','1','userPermission');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a0141372269680009','1','userManagement');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a0141372269680008','1','402880e640fcfb3d0140fd7558eb0009');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a0141372269680006','1','402880e640fcfb3d0140fd6d34050001');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd8ea69a006b','2','402880e640fcfb3d0140fd70722d0004');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd8ea69a006a','2','402880e640fcfb3d0140fd70216c0003');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd8ea69a0069','2','myResources');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd8ea69a0068','2','resourcesApproval');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd8ea69a0067','2','userApproval');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd8ea6990066','2','userPermission');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd8ea6990065','2','userInfo');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd8ea6990064','2','userManagement');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd8ea6990063','2','402880e640fcfb3d0140fd6ddaf10002');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd8ea6990062','2','402880e640fcfb3d0140fd6d34050001');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd8ea6990061','2','402880e640fcfb3d0140fd6bd8780000');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd8ea6990060','2','accountPanel');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd8ea699005f','2','myRemind');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd8ea699005e','2','myNotice');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd8ea699005d','2','homepage');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd8ea69a006c','2','prodBuy');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd8ea69a006d','2','402880e640fcfb3d0140fd71cb690005');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd8ea69a006e','2','402880e640fcfb3d0140fd7220010006');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd8ea69a006f','2','402880e640fcfb3d0140fd726d950007');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd8ea69a0070','2','402880e640fcfb3d0140fd72db120008');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd9167c00071','3','homepage');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd9167c00072','3','myNotice');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd9167c00073','3','myRemind');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd9167c00074','3','accountPanel');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd9167c00075','3','402880e640fcfb3d0140fd6bd8780000');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd9167c00076','3','402880e640fcfb3d0140fd6d34050001');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd9167c00077','3','402880e640fcfb3d0140fd6ddaf10002');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd9167c00078','3','myResources');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd9167c10079','3','402880e640fcfb3d0140fd70216c0003');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd9167c1007a','3','402880e640fcfb3d0140fd70722d0004');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd9167c1007b','3','prodBuy');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd9167c1007c','3','402880e640fcfb3d0140fd71cb690005');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e640fcfb3d0140fd9167c1007d','3','402880e640fcfb3d0140fd72db120008');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a0141372269680007','1','402880e640fcfb3d0140fd6ddaf10002');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a0141372269670005','1','402880e640fcfb3d0140fd6bd8780000');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a0141372269670004','1','myRemind');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a0141372269670003','1','myWarning');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a0141372269670002','1','myNotice');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a0141372269670001','1','adminPanel');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('402880e64137199a0141372269460000','1','homepage');



insert into `cloud_mdm_product` (`ID`, `PROD_NAME`, `DESCRIPTION`, `PROD_TYPE`, `CREATED`, `STATE`) values('ipprice','IP',NULL,'0','2013-10-01 00:00:00','1');
insert into `cloud_mdm_product_item` (`ID`, `PROD_ID`, `ITEM_ID`, `ITEM_TYPE`, `ZONE_ID`, `CPU_SOLN_ID`, `DISK_SOLN_ID`, `TEMPLATE_ID`, `NETWORK_SOLN_ID`, `IP_ID`, `CREATED`, `STATE`) values('ipprice','ipprice',NULL,'ip',NULL,NULL,NULL,NULL,NULL,NULL,'2013-10-01 00:00:00','1');
