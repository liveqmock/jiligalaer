
DELETE FROM BASIC_RESOURCE;
DELETE FROM BASIC_DICT_ITEM;
DELETE FROM BASIC_DICT;

/*资源分类*/
INSERT INTO  BASIC_DICT 
		(DICT_ID,DICT_NAME,STATE)
SELECT 'resource','资源分类',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT  
	  WHERE DICT_ID = 'resource'
); 

/*账户类别*/
INSERT INTO  BASIC_DICT 
		(DICT_ID,DICT_NAME,STATE)
SELECT 'userAccountType','账户类别',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT  
	  WHERE DICT_ID = 'userAccountType'
); 

/*账户身份*/
INSERT INTO  BASIC_DICT 
		(DICT_ID,DICT_NAME,STATE)
SELECT 'userIdentity','账户身份',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT  
	  WHERE DICT_ID = 'userIdentity'
); 

/*地区*/
INSERT INTO  BASIC_DICT 
		(DICT_ID,DICT_NAME,STATE)
SELECT 'geo','地区',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT  
	  WHERE DICT_ID = 'geo'
);

/*行业*/
INSERT INTO  BASIC_DICT 
		(DICT_ID,DICT_NAME,STATE)
SELECT 'industry','行业',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT  
	  WHERE DICT_ID = 'industry'
);


INSERT INTO  BASIC_DICT_ITEM 
		(DICT_ITEM_ID,PARENT_DICT_ITEM_ID,DICT_ID,ITEM_CODE,SUB_CODE,LEVEL_CODE,ITEM_NAME,STATE)
SELECT 'basic',null,'resource','basic','001','1','基础设置',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT_ITEM  
	  WHERE DICT_ID = 'resource'
	  AND   DICT_ITEM_ID = 'basic'
); 

INSERT INTO  BASIC_DICT_ITEM 
		(DICT_ITEM_ID,PARENT_DICT_ITEM_ID,DICT_ID,ITEM_CODE,SUB_CODE,LEVEL_CODE,ITEM_NAME,STATE)
SELECT 'navigation',null,'resource','navigation','001','1','导航',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT_ITEM  
	  WHERE DICT_ID = 'resource'
	  AND   DICT_ITEM_ID = 'navigation'
); 

/*账户类别*/
INSERT INTO  BASIC_DICT_ITEM 
		(DICT_ITEM_ID,PARENT_DICT_ITEM_ID,DICT_ID,ITEM_CODE,SUB_CODE,LEVEL_CODE,ITEM_NAME,STATE)
SELECT 'zhengshiaccount',null,'userAccountType','zhengshi','001','1','正式账户',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT_ITEM  
	  WHERE DICT_ID = 'userAccountType'
	  AND   DICT_ITEM_ID = 'zhengshiaccount'
); 

INSERT INTO  BASIC_DICT_ITEM 
		(DICT_ITEM_ID,PARENT_DICT_ITEM_ID,DICT_ID,ITEM_CODE,SUB_CODE,LEVEL_CODE,ITEM_NAME,STATE)
SELECT 'shiyongaccount',null,'userAccountType','shiyong','002','1','试用账户',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT_ITEM  
	  WHERE DICT_ID = 'userAccountType'
	  AND   DICT_ITEM_ID = 'shiyongaccount'
); 

/*账户身份*/
INSERT INTO  BASIC_DICT_ITEM 
		(DICT_ITEM_ID,PARENT_DICT_ITEM_ID,DICT_ID,ITEM_CODE,SUB_CODE,LEVEL_CODE,ITEM_NAME,STATE)
SELECT 'gongsiidentity',null,'userIdentity','gongsi','001','1','公司',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT_ITEM  
	  WHERE DICT_ID = 'userIdentity'
	  AND   DICT_ITEM_ID = 'gongsiidentity'
);

INSERT INTO  BASIC_DICT_ITEM 
		(DICT_ITEM_ID,PARENT_DICT_ITEM_ID,DICT_ID,ITEM_CODE,SUB_CODE,LEVEL_CODE,ITEM_NAME,STATE)
SELECT 'gerenidentity',null,'userIdentity','geren','002','1','个人',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT_ITEM  
	  WHERE DICT_ID = 'userIdentity'
	  AND   DICT_ITEM_ID = 'gerenidentity'
);

INSERT INTO  BASIC_DICT_ITEM 
		(DICT_ITEM_ID,PARENT_DICT_ITEM_ID,DICT_ID,ITEM_CODE,SUB_CODE,LEVEL_CODE,ITEM_NAME,STATE)
SELECT 'devidentity',null,'userIdentity','dev','003','1','开发者',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT_ITEM  
	  WHERE DICT_ID = 'userIdentity'
	  AND   DICT_ITEM_ID = 'devidentity'
);

/*地区*/
INSERT INTO  BASIC_DICT_ITEM 
		(DICT_ITEM_ID,PARENT_DICT_ITEM_ID,DICT_ID,ITEM_CODE,SUB_CODE,LEVEL_CODE,ITEM_NAME,STATE)
SELECT 'beijinggeo',null,'geo','bj','001','1','北京',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT_ITEM  
	  WHERE DICT_ID = 'geo'
	  AND   DICT_ITEM_ID = 'beijinggeo'
);

INSERT INTO  BASIC_DICT_ITEM 
		(DICT_ITEM_ID,PARENT_DICT_ITEM_ID,DICT_ID,ITEM_CODE,SUB_CODE,LEVEL_CODE,ITEM_NAME,STATE)
SELECT 'tianjingeo',null,'geo','tj','002','1','天津',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT_ITEM  
	  WHERE DICT_ID = 'geo'
	  AND   DICT_ITEM_ID = 'tianjingeo'
);

INSERT INTO  BASIC_DICT_ITEM 
		(DICT_ITEM_ID,PARENT_DICT_ITEM_ID,DICT_ID,ITEM_CODE,SUB_CODE,LEVEL_CODE,ITEM_NAME,STATE)
SELECT 'shanghaigeo',null,'geo','sh','003','1','上海',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT_ITEM  
	  WHERE DICT_ID = 'geo'
	  AND   DICT_ITEM_ID = 'shanghaigeo'
);

/*行业*/
INSERT INTO  BASIC_DICT_ITEM 
		(DICT_ITEM_ID,PARENT_DICT_ITEM_ID,DICT_ID,ITEM_CODE,SUB_CODE,LEVEL_CODE,ITEM_NAME,STATE)
SELECT 'gameindustry',null,'industry','game','001','1','游戏',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT_ITEM  
	  WHERE DICT_ID = 'industry'
	  AND   DICT_ITEM_ID = 'gameindustry'
);

INSERT INTO  BASIC_DICT_ITEM 
		(DICT_ITEM_ID,PARENT_DICT_ITEM_ID,DICT_ID,ITEM_CODE,SUB_CODE,LEVEL_CODE,ITEM_NAME,STATE)
SELECT 'retailindustry',null,'industry','retail','002','1','零售',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT_ITEM  
	  WHERE DICT_ID = 'industry'
	  AND   DICT_ITEM_ID = 'retailindustry'
);



/* 
 * 导航数据初始化开始
 * ---------------------------------------------------------------------------------------------------
 */
/**
DELETE FROM BASIC_RESOURCE;

INSERT INTO  BASIC_RESOURCE 
		(RES_ID,PARENT_RES_ID,RES_TYPE,SUB_CODE,LEVEL_CODE,RES_NAME,STATE,SORT,CREATED_BY,CREATED)
SELECT 'homepage',NULL,'navigation','000','1','首页',1,0,'Sys',sysdate()
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_RESOURCE  
	  WHERE RES_ID = 'homepage'
);


INSERT INTO  BASIC_RESOURCE 
		(RES_ID,PARENT_RES_ID,RES_TYPE,SUB_CODE,LEVEL_CODE,RES_NAME,STATE,SORT,CREATED_BY,CREATED)
SELECT 'controlPanel','homepage','navigation','000000','2','控制板',1,0,'Sys',sysdate(),
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_RESOURCE  
	  WHERE RES_ID = 'controlPanel'
);

INSERT INTO  BASIC_RESOURCE 
		(RES_ID,PARENT_RES_ID,RES_TYPE,SUB_CODE,LEVEL_CODE,RES_NAME,STATE,SORT,CREATED_BY,CREATED,RES_URL)
SELECT 'myNotice','homepage','navigation','000001','2','我的公告',1,1,'Sys',sysdate(),'/noticeMessages/list.do'
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_RESOURCE  
	  WHERE RES_ID = 'myNotice'
);

INSERT INTO  BASIC_RESOURCE 
		(RES_ID,PARENT_RES_ID,RES_TYPE,SUB_CODE,LEVEL_CODE,RES_NAME,STATE,SORT,CREATED_BY,CREATED,RES_URL)
SELECT 'myWarning','homepage','navigation','000002','2','我的警告',1,2,'Sys',sysdate(),'/warning/myWarning.do'
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_RESOURCE  
	  WHERE RES_ID = 'myWarning'
);

INSERT INTO  BASIC_RESOURCE 
		(RES_ID,PARENT_RES_ID,RES_TYPE,SUB_CODE,LEVEL_CODE,RES_NAME,STATE,SORT,CREATED_BY,CREATED,RES_URL)
SELECT 'myRemind','homepage','navigation','000003','2','我的提醒',1,3,'Sys',sysdate(),'/remind/myRemind.do'
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_RESOURCE  
	  WHERE RES_ID = 'myRemind'
);

INSERT INTO  BASIC_RESOURCE 
		(RES_ID,PARENT_RES_ID,RES_TYPE,SUB_CODE,LEVEL_CODE,RES_NAME,STATE,SORT,CREATED_BY,CREATED)
SELECT 'userManagement',NULL,'navigation','001','1','用户管理',1,1,'Sys',sysdate()
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_RESOURCE  
	  WHERE RES_ID = 'userManagement'
);


INSERT INTO  BASIC_RESOURCE 
		(RES_ID,PARENT_RES_ID,RES_TYPE,SUB_CODE,LEVEL_CODE,RES_NAME,STATE,SORT,CREATED_BY,CREATED)
SELECT 'acManagement',NULL,'navigation','002','1','账户管理',1,2,'Sys',sysdate()
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_RESOURCE  
	  WHERE RES_ID = 'acManagement'
);

INSERT INTO  BASIC_RESOURCE 
		(RES_ID,PARENT_RES_ID,RES_TYPE,SUB_CODE,LEVEL_CODE,RES_NAME,STATE,SORT,CREATED_BY,CREATED,RES_URL)
SELECT 'prodManagement',NULL,'navigation','003','1','产品管理',1,3,'Sys',sysdate(),'/customBuy/selectDc.do'
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_RESOURCE  
	  WHERE RES_ID = 'prodManagement'
);

INSERT INTO  BASIC_RESOURCE 
		(RES_ID,PARENT_RES_ID,RES_TYPE,SUB_CODE,LEVEL_CODE,RES_NAME,STATE,SORT,CREATED_BY,CREATED)
SELECT 'myResources',NULL,'navigation','004','1','我的资源',1,4,'Sys',sysdate()
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_RESOURCE  
	  WHERE RES_ID = 'myResources'
);

INSERT INTO  BASIC_RESOURCE 
		(RES_ID,PARENT_RES_ID,RES_TYPE,SUB_CODE,LEVEL_CODE,RES_NAME,STATE,SORT,CREATED_BY,CREATED)
SELECT 'marketAct',NULL,'navigation','005','1','市场活动',1,5,'Sys',sysdate()
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_RESOURCE  
	  WHERE RES_ID = 'marketAct'
);


INSERT INTO  BASIC_RESOURCE 
		(RES_ID,PARENT_RES_ID,RES_TYPE,SUB_CODE,LEVEL_CODE,RES_NAME,STATE,SORT,CREATED_BY,CREATED)
SELECT 'saleManagement',NULL,'navigation','006','1','销售管理',1,6,'Sys',sysdate()
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_RESOURCE  
	  WHERE RES_ID = 'saleManagement'
);

INSERT INTO  BASIC_RESOURCE 
		(RES_ID,PARENT_RES_ID,RES_TYPE,SUB_CODE,LEVEL_CODE,RES_NAME,STATE,SORT,CREATED_BY,CREATED)
SELECT 'financeManagement',NULL,'navigation','007','1','财务管理',1,7,'Sys',sysdate()
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_RESOURCE  
	  WHERE RES_ID = 'financeManagement'
);


INSERT INTO  BASIC_RESOURCE 
		(RES_ID,PARENT_RES_ID,RES_TYPE,SUB_CODE,LEVEL_CODE,RES_NAME,STATE,SORT,CREATED_BY,CREATED)
SELECT 'omManagement',NULL,'navigation','008','1','运维管理',1,8,'Sys',sysdate()
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_RESOURCE  
	  WHERE RES_ID = 'omManagement'
);

INSERT INTO  BASIC_RESOURCE 
		(RES_ID,PARENT_RES_ID,RES_TYPE,SUB_CODE,LEVEL_CODE,RES_NAME,STATE,SORT,CREATED_BY,CREATED,RES_URL)
SELECT 'resManagement','omManagement','navigation','008000','2','资源管理',1,0,'Sys',sysdate(),'/resource/list.do'
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_RESOURCE  
	  WHERE RES_ID = 'resManagement'
);

INSERT INTO  BASIC_RESOURCE 
		(RES_ID,PARENT_RES_ID,RES_TYPE,SUB_CODE,LEVEL_CODE,RES_NAME,STATE,SORT,CREATED_BY,CREATED,RES_URL)
SELECT 'roleManagement','omManagement','navigation','008001','2','权限管理',1,1,'Sys',sysdate(),'/role/list.do'
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_RESOURCE  
	  WHERE RES_ID = 'roleManagement'
);


INSERT INTO  BASIC_RESOURCE 
		(RES_ID,PARENT_RES_ID,RES_TYPE,SUB_CODE,LEVEL_CODE,RES_NAME,STATE,SORT,CREATED_BY,CREATED)
SELECT 'swManagement',NULL,'navigation','009','1','软件管理',1,9,'Sys',sysdate()
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_RESOURCE  
	  WHERE RES_ID = 'swManagement'
);


INSERT INTO  BASIC_RESOURCE 
		(RES_ID,PARENT_RES_ID,RES_TYPE,SUB_CODE,LEVEL_CODE,RES_NAME,STATE,SORT,CREATED_BY,CREATED)
SELECT 'rptManagement',NULL,'navigation','010','1','统计报表',1,10,'Sys',sysdate()
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_RESOURCE  
	  WHERE RES_ID = 'rptManagement'
);


insert into basic_resource (RES_ID, PARENT_RES_ID, SUB_CODE, LEVEL_CODE, RES_NAME, SORT, STATE, CREATED_BY, CREATED, UPDATED_BY, UPDATED, RES_TYPE,RES_URL) 
SELECT 'userInfo','userManagement','002001','2','用户信息','1','1','Sys','2013-09-06 20:01:55',NULL,NULL,'navigation','/user/list.do'
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_RESOURCE  
	  WHERE RES_ID = 'userInfo'
);


insert into basic_resource (RES_ID, PARENT_RES_ID, SUB_CODE, LEVEL_CODE, RES_NAME, SORT, STATE, CREATED_BY, CREATED, UPDATED_BY, UPDATED, RES_TYPE,RES_URL) 
SELECT 'userPermission','userManagement','002002','2','用户权限','2','1','Sys','2013-09-06 20:01:55',NULL,NULL,'navigation',''
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_RESOURCE  
	  WHERE RES_ID = 'userPermission'
);


insert into basic_resource (RES_ID, PARENT_RES_ID, SUB_CODE, LEVEL_CODE, RES_NAME, SORT, STATE, CREATED_BY, CREATED, UPDATED_BY, UPDATED, RES_TYPE, RES_URL) 
SELECT 'userApproval','userManagement','002003','2','用户审批','3','1','Sys','2013-09-06 20:01:55',NULL,NULL,'navigation','/userApproval/list.do'
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_RESOURCE  
	  WHERE RES_ID = 'userApproval'
);


insert into basic_resource (RES_ID, PARENT_RES_ID, SUB_CODE, LEVEL_CODE, RES_NAME, SORT, STATE, CREATED_BY, CREATED, UPDATED_BY, UPDATED, RES_TYPE, RES_URL) 
SELECT 'resourcesApproval','userManagement','002004','2','资源审批','4','1','Sys','2013-09-06 20:01:55',NULL,NULL,'navigation','/resourcesApproval/list.do'
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_RESOURCE  
	  WHERE RES_ID = 'resourcesApproval'
);
*/
/* 
 * 导航数据初始化结束
 * ---------------------------------------------------------------------------------------------------
 */


/**date:2013-09-01 xhchen*/

/*字典类别部门*/
INSERT INTO  BASIC_DICT 
		(DICT_ID,DICT_NAME,STATE)
SELECT 'department','部门',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT  
	  WHERE DICT_ID = 'department'
);

/**部门初始化数据*/
INSERT INTO  BASIC_DICT_ITEM 
		(DICT_ITEM_ID,PARENT_DICT_ITEM_ID,DICT_ID,ITEM_CODE,SUB_CODE,LEVEL_CODE,ITEM_NAME,STATE)
SELECT 'managerdepart001',null,'department','manager','001','1','运维管理部',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT_ITEM  
	  WHERE DICT_ID = 'department'
	  AND   DICT_ITEM_ID = 'managerdepart001'
);

INSERT INTO  BASIC_DICT_ITEM 
		(DICT_ITEM_ID,PARENT_DICT_ITEM_ID,DICT_ID,ITEM_CODE,SUB_CODE,LEVEL_CODE,ITEM_NAME,STATE)
SELECT 'devdepart001',null,'department','dev','002','1','开发部',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT_ITEM  
	  WHERE DICT_ID = 'department'
	  AND   DICT_ITEM_ID = 'devdepart001'
);

/**测试数据初始化
 *管理员:admin/1
 *测试账户：dev/1
 *测试用户：devuser/1
 * */
insert into `basic_user` (`USER_ID`, `USER_ACCOUNT`, `USER_NAME`, `USER_PASSWORD`, `USER_ACCOUNT_TYPE_ID`, `USER_IDENTITY_ID`, `USER_DEPART_ID`, `INVITE_USER_ID`, `PARENT_USER_ID`, `USER_FLAG`, `TEL`, `GEO_ID`, `INDUSTRY_ID`, `COMPANY_NAME`, `COMP_LOGO_FILE_URI`, `BUSINESS_LICENSE`, `BUSINESS_ORG_CODE`, `TAX_CODE`, `IDENTITY_CARD`, `BIRTH_DATE`, `REMARK`, `REGISTER_DATE`, `APPROVAL_DATE`, `REFUSE_MEMO`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`) values('admin001','admin','系统管理员','1','zhengshiaccount','gongsiidentity','managerdepart001',NULL,NULL,'0','010-98989898','beijinggeo','gameindustry','瑞云软件技术有限公司',NULL,'Busi20130830','平台管理部001','010-67899876','123122324343434','2000-01-01 00:00:00','管理员','2013-08-01 00:00:00','2013-08-10 00:00:00',NULL,'3','admin','2013-08-01 00:00:00','admin','2013-08-31 00:00:00');
insert into `basic_user` (`USER_ID`, `USER_ACCOUNT`, `USER_NAME`, `USER_PASSWORD`, `USER_ACCOUNT_TYPE_ID`, `USER_IDENTITY_ID`, `USER_DEPART_ID`, `INVITE_USER_ID`, `PARENT_USER_ID`, `USER_FLAG`, `TEL`, `GEO_ID`, `INDUSTRY_ID`, `COMPANY_NAME`, `COMP_LOGO_FILE_URI`, `BUSINESS_LICENSE`, `BUSINESS_ORG_CODE`, `TAX_CODE`, `IDENTITY_CARD`, `BIRTH_DATE`, `REMARK`, `REGISTER_DATE`, `APPROVAL_DATE`, `REFUSE_MEMO`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`) values('devaccount001','dev','开发测试账户','1','zhengshiaccount','gongsiidentity','managerdepart001',NULL,NULL,'1','010-66666666','beijinggeo','gameindustry','盛大网络',NULL,'Busi20130831','运维管理部001','010-67899876','777777777777777','2000-01-01 00:00:00','账户','2013-08-01 00:00:00','2013-08-10 00:00:00',NULL,'3','admin','2013-08-01 00:00:00','admin','2013-08-31 00:00:00');
insert into `basic_user` (`USER_ID`, `USER_ACCOUNT`, `USER_NAME`, `USER_PASSWORD`, `USER_ACCOUNT_TYPE_ID`, `USER_IDENTITY_ID`, `USER_DEPART_ID`, `INVITE_USER_ID`, `PARENT_USER_ID`, `USER_FLAG`, `TEL`, `GEO_ID`, `INDUSTRY_ID`, `COMPANY_NAME`, `COMP_LOGO_FILE_URI`, `BUSINESS_LICENSE`, `BUSINESS_ORG_CODE`, `TAX_CODE`, `IDENTITY_CARD`, `BIRTH_DATE`, `REMARK`, `REGISTER_DATE`, `APPROVAL_DATE`, `REFUSE_MEMO`, `STATE`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`) values('devuser001','devuser','开发测试用户','1','zhengshiaccount','gongsiidentity','devdepart001',NULL,'devaccount001','2','010-99999999','beijinggeo','gameindustry','盛大网络',NULL,'Busi20130832','开发部001','010-67899876','999999999999999','2000-01-01 00:00:00','用户','2013-08-01 00:00:00','2013-08-10 00:00:00',NULL,'3','admin','2013-08-01 00:00:00','admin','2013-08-31 00:00:00');


/**市场活动类型*/
INSERT INTO  BASIC_DICT 
		(DICT_ID,DICT_NAME,STATE)
SELECT 'promotionType','市场活动类型',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT  
	  WHERE DICT_ID = 'promotionType'
);

/**初始化市场活动类型*/
INSERT INTO  BASIC_DICT_ITEM 
		(DICT_ITEM_ID,PARENT_DICT_ITEM_ID,DICT_ID,ITEM_CODE,SUB_CODE,LEVEL_CODE,ITEM_NAME,STATE)
SELECT 'promotionType001',null,'promotionType','singleActivity','001','1','单一产品',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT_ITEM  
	  WHERE DICT_ID = 'promotionType'
	  AND   DICT_ITEM_ID = 'promotionType001'
);

INSERT INTO  BASIC_DICT_ITEM 
		(DICT_ITEM_ID,PARENT_DICT_ITEM_ID,DICT_ID,ITEM_CODE,SUB_CODE,LEVEL_CODE,ITEM_NAME,STATE)
SELECT 'promotionType002',null,'promotionType','combinationActivity','001','1','组合产品',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT_ITEM  
	  WHERE DICT_ID = 'promotionType'
	  AND   DICT_ITEM_ID = 'promotionType002'
);

INSERT INTO  BASIC_DICT_ITEM 
		(DICT_ITEM_ID,PARENT_DICT_ITEM_ID,DICT_ID,ITEM_CODE,SUB_CODE,LEVEL_CODE,ITEM_NAME,STATE)
SELECT 'promotionType003',null,'promotionType','firstRechargeActivity','001','1','首次充值',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT_ITEM  
	  WHERE DICT_ID = 'promotionType'
	  AND   DICT_ITEM_ID = 'promotionType003'
);

INSERT INTO  BASIC_DICT_ITEM 
		(DICT_ITEM_ID,PARENT_DICT_ITEM_ID,DICT_ID,ITEM_CODE,SUB_CODE,LEVEL_CODE,ITEM_NAME,STATE)
SELECT 'promotionType004',null,'promotionType','rechargeRebateActivity','001','1','充值返利',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT_ITEM  
	  WHERE DICT_ID = 'promotionType'
	  AND   DICT_ITEM_ID = 'promotionType004'
);

INSERT INTO  BASIC_DICT_ITEM 
		(DICT_ITEM_ID,PARENT_DICT_ITEM_ID,DICT_ID,ITEM_CODE,SUB_CODE,LEVEL_CODE,ITEM_NAME,STATE)
SELECT 'promotionType005',null,'promotionType','recommendationActivity','001','1','推荐返利',1
FROM dual  
WHERE NOT EXISTS(  
	  SELECT *  
	  FROM BASIC_DICT_ITEM  
	  WHERE DICT_ID = 'promotionType'
	  AND   DICT_ITEM_ID = 'promotionType005'
);

/**
 * 管理员角色
 *
INSERT INTO BASIC_ROLE
	(ROLE_ID,ROLE_NAME,PRIORITY,DATA_AUTH,STATE,CREATED_BY,CREATED)
VALUES
	('1','管理员',1,'UNLIMITED',1,'Sys',sysdate());
	
INSERT INTO BASIC_USER_ROLE
	(USER_ROLE_ID,USER_ID,ROLE_ID)
VALUES
	(1,'admin001','1');
	
	
/**
*管理员角色资源初始化
**/
/**
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('4028815f40e94dcb0140e988b6e60000','1','acManagement');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('4028815f40e94dcb0140e988b72e0001','1','financeManagement');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('4028815f40e94dcb0140e988b72f0002','1','homepage');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('4028815f40e94dcb0140e988b72f0003','1','controlPanel');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('4028815f40e94dcb0140e988b72f0004','1','myNotice');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('4028815f40e94dcb0140e988b72f0005','1','myRemind');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('4028815f40e94dcb0140e988b72f0006','1','myWarning');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('4028815f40e94dcb0140e988b72f0007','1','marketAct');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('4028815f40e94dcb0140e988b7300008','1','myResources');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('4028815f40e94dcb0140e988b7300009','1','omManagement');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('4028815f40e94dcb0140e988b730000a','1','resManagement');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('4028815f40e94dcb0140e988b730000b','1','roleManagement');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('4028815f40e94dcb0140e988b730000c','1','prodManagement');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('4028815f40e94dcb0140e988b730000d','1','rptManagement');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('4028815f40e94dcb0140e988b730000e','1','saleManagement');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('4028815f40e94dcb0140e988b731000f','1','swManagement');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('4028815f40e94dcb0140e988b7320010','1','userManagement');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('4028815f40e94dcb0140e98914f20011','ff80808140b503000140b50476570001','acManagement');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('4028815f40e94dcb0140e98914f20012','ff80808140b503000140b50476570001','financeManagement');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('4028815f40e94dcb0140e98914f20013','1','userInfo');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('4028815f40e94dcb0140e98914f20014','1','userPermission');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('4028815f40e94dcb0140e98914f20015','1','userApproval');
insert into `basic_role_res` (`ID`, `ROLE_ID`, `RES_ID`) values('4028815f40e94dcb0140e98914f20016','1','resourcesApproval');

*/


insert into `basic_dict` (`DICT_ID`, `DICT_NAME`, `REMARK`, `STATE`, `SORT`) values('prodType','产品类型','单一(计算方案、磁盘方案、模板、网络方案、IP)、组合',NULL,NULL);

insert into `basic_dict_item` (`DICT_ITEM_ID`, `PARENT_DICT_ITEM_ID`, `DICT_ID`, `ITEM_CODE`, `EXT_CODE`, `SUB_CODE`, `LEVEL_CODE`, `ITEM_NAME`, `ITEM_ALIAS`, `MEMO1`, `MEMO2`, `MEMO3`, `MEMO4`, `MEMO5`, `MEMO6`, `REMARK`, `STATE`, `SORT`, `PI1`, `PI2`, `PI3`, `PI4`, `PI5`, `PI6`, `PI7`, `PN1`, `PN2`, `PN3`, `PN4`, `PN5`, `PN6`, `PN7`, `PNALL`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`) values('cpuSoln',NULL,'prodType','cpuSoln',NULL,NULL,'1','计算方案',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert into `basic_dict_item` (`DICT_ITEM_ID`, `PARENT_DICT_ITEM_ID`, `DICT_ID`, `ITEM_CODE`, `EXT_CODE`, `SUB_CODE`, `LEVEL_CODE`, `ITEM_NAME`, `ITEM_ALIAS`, `MEMO1`, `MEMO2`, `MEMO3`, `MEMO4`, `MEMO5`, `MEMO6`, `REMARK`, `STATE`, `SORT`, `PI1`, `PI2`, `PI3`, `PI4`, `PI5`, `PI6`, `PI7`, `PN1`, `PN2`, `PN3`, `PN4`, `PN5`, `PN6`, `PN7`, `PNALL`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`) values('diskSoln',NULL,'prodType','diskSoln',NULL,NULL,'1','磁盘方案',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert into `basic_dict_item` (`DICT_ITEM_ID`, `PARENT_DICT_ITEM_ID`, `DICT_ID`, `ITEM_CODE`, `EXT_CODE`, `SUB_CODE`, `LEVEL_CODE`, `ITEM_NAME`, `ITEM_ALIAS`, `MEMO1`, `MEMO2`, `MEMO3`, `MEMO4`, `MEMO5`, `MEMO6`, `REMARK`, `STATE`, `SORT`, `PI1`, `PI2`, `PI3`, `PI4`, `PI5`, `PI6`, `PI7`, `PN1`, `PN2`, `PN3`, `PN4`, `PN5`, `PN6`, `PN7`, `PNALL`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`) values('template',NULL,'prodType','template',NULL,NULL,'1','模板',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert into `basic_dict_item` (`DICT_ITEM_ID`, `PARENT_DICT_ITEM_ID`, `DICT_ID`, `ITEM_CODE`, `EXT_CODE`, `SUB_CODE`, `LEVEL_CODE`, `ITEM_NAME`, `ITEM_ALIAS`, `MEMO1`, `MEMO2`, `MEMO3`, `MEMO4`, `MEMO5`, `MEMO6`, `REMARK`, `STATE`, `SORT`, `PI1`, `PI2`, `PI3`, `PI4`, `PI5`, `PI6`, `PI7`, `PN1`, `PN2`, `PN3`, `PN4`, `PN5`, `PN6`, `PN7`, `PNALL`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`) values('networkSoln',NULL,'prodType','networkSoln',NULL,NULL,'1','网络方案',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert into `basic_dict_item` (`DICT_ITEM_ID`, `PARENT_DICT_ITEM_ID`, `DICT_ID`, `ITEM_CODE`, `EXT_CODE`, `SUB_CODE`, `LEVEL_CODE`, `ITEM_NAME`, `ITEM_ALIAS`, `MEMO1`, `MEMO2`, `MEMO3`, `MEMO4`, `MEMO5`, `MEMO6`, `REMARK`, `STATE`, `SORT`, `PI1`, `PI2`, `PI3`, `PI4`, `PI5`, `PI6`, `PI7`, `PN1`, `PN2`, `PN3`, `PN4`, `PN5`, `PN6`, `PN7`, `PNALL`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`) values('ip',NULL,'prodType','ip',NULL,NULL,'1','IP',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert into `basic_dict_item` (`DICT_ITEM_ID`, `PARENT_DICT_ITEM_ID`, `DICT_ID`, `ITEM_CODE`, `EXT_CODE`, `SUB_CODE`, `LEVEL_CODE`, `ITEM_NAME`, `ITEM_ALIAS`, `MEMO1`, `MEMO2`, `MEMO3`, `MEMO4`, `MEMO5`, `MEMO6`, `REMARK`, `STATE`, `SORT`, `PI1`, `PI2`, `PI3`, `PI4`, `PI5`, `PI6`, `PI7`, `PN1`, `PN2`, `PN3`, `PN4`, `PN5`, `PN6`, `PN7`, `PNALL`, `CREATED_BY`, `CREATED`, `UPDATED_BY`, `UPDATED`) values('compProd',NULL,'prodType','compProd',NULL,NULL,'1','组合产品',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);