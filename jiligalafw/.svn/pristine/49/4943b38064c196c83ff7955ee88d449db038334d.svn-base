/**
 * 全部选中checkbok
 */
function checkAll(boxName,checkName){
	var box=document.getElementById(boxName);
	var boxList=document.getElementsByName(checkName);
	for(var i=0;i<boxList.length;i++){
		if(box.type=="checkbox" && boxList[i].type=="checkbox"){
			if(box.checked==true){
				boxList[i].checked=true;
			}else{
				boxList[i].checked=false;
			}	
		}
	}
}

function openwindow(url,name,iWidth,iHeight){
	var url; //转向网页的地址;
	var name; //网页名称，可为空;
	var iWidth; //弹出窗口的宽度;
	var iHeight; //弹出窗口的高度;
	var iTop = (window.screen.availHeight-60-iHeight)/2; //获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth-10-iWidth)/2; //获得窗口的水平位置;
	window.open(url,name,'height='+iHeight+',,innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=yes,resizable=0,location=no,status=no');
}

/**
 * 定义简单Map
 * @returns {___map_0}
 */  
function getMap() {
	//初始化map_,给map_对象增加方法，使map_像Map    
	var map_ = new Object();
	map_.put = function(key, value) {
		map_[key + '_'] = value;
	};
	map_.get = function(key) {
		return map_[key + '_'];
	};
	map_.remove = function(key) {
		delete map_[key + '_'];
	};
	map_.keyset = function() {
		var ret = "";
		for ( var p in map_) {
			if (typeof p == 'string' && p.substring(p.length - 1) == "_") {
				ret += ",";
				ret += p.substring(0, p.length - 1);
			}
		}
		if (ret == "") {
			return ret.split(",");
		} else {
			return ret.substring(1).split(",");
		}
	};
	return map_;    
}  

/**
 * 金额验证
 * @param val
 * @returns
 */
function checkAmount(val){
	if(val == ''){
		return true;
	}
	reg = /^[-\+]?\d+(\.\d+)?$/;
	return reg.test(val);
}

/**
 * 获取当前日期
 * @returns {String}
 */
function getCurrDate(){
	var date = new Date();
	var yy=date.getFullYear();
	var mm=date.getMonth()+1;
	var dd=date.getDate();
	var dateStr=yy+'-';
	if(mm<10){
		dateStr = dateStr + '0' + mm + '-';
	}else{
		dateStr = dateStr + mm + '-';
	}
	if(dd<10){
		dateStr = dateStr + '0' + dd;
	}else{
		dateStr = dateStr + dd;
	}
	return dateStr;
}

function onlyNum(frm)
{
   if(window.event.keyCode>57||window.event.keyCode<48)
     {
       window.event.keyCode=0;
     }
}

//对电子邮件的验证
function checkEmail(emailAddr){
   //var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
   //var myreg = /^([a-zA-Z0-9]+[_|_|.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|_|.]?)*[a-zA-Z0-9]+\.(?:com|cn)$/;
   var myreg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
   /*
   if(!myreg.test(emailAddr)){
        //alert('提示\n\n请输入有效的E_mail！');
        return false;
   }*/
   return myreg.test(emailAddr);
}

//去除单列中多行重复的文本，只保留第一行的文本
function colapsnRowsText(cellNum){
	//列名
	var cellText = '';
	$(".odd,.even").each(function(j,m){
		//j=行
		$(m).find("td").each(function(i,n){
			//i=列
			switch(i){
				case cellNum:
				if(cellText == $(n).text()){
					$(this).text(""); 
				}else{
					cellText = $(n).text();
				}
				break;
			} 
		});
	
	}); 
}

function colapsnRowsHtml(cellNum){
	//列名
	var cellHtml = '';
	$(".odd,.even").each(function(j,m){
		//j=行
		$(m).find("td").each(function(i,n){
			//i=列
			switch(i){
				case cellNum:
				if(cellHtml == $(n).html()){
					$(this).html(""); 
				}else{
					cellHtml = $(n).html();
				}
				break;
			} 
		});
	
	}); 
}



function dataAddToStr(date,number){
	//new Date('2013/12/30')
	date = new Date(date.replace(/-/g,'/'));
	var dd = DateAdd("d ", number, date); 
	var y = dd.getFullYear(); 
	var m = dd.getMonth()+1;//获取当前月份的日期 
	var d = dd.getDate(); 
	if(m < 10){
		m = '0' + m;
	}
	if(d < 10){
		d = '0' + d;
	}
	return y+"-"+m+"-"+d;
}

function DateAdd(interval, number, date) {
	/* 
	 *   功能:实现VBScript的DateAdd功能. 
	 *   参数:interval,字符串表达式，表示要添加的时间间隔. 
	 *   参数:number,数值表达式，表示要添加的时间间隔的个数. 
	 *   参数:date,时间对象. 
	 *   返回:新的时间对象. 
	 *   var   now   =   new   Date(); 
	 *   var   newDate   =   DateAdd( "d ",5,now); 
	 *---------------   DateAdd(interval,number,date)   ----------------- 
	 */
	switch (interval) {
		case "y ": {
			date.setFullYear(date.getFullYear() + number);
			return date;
			break;
		}
		case "q ": {
			date.setMonth(date.getMonth() + number * 3);
			return date;
			break;
		}
		case "m ": {
			date.setMonth(date.getMonth() + number);
			return date;
			break;
		}
		case "w ": {
			date.setDate(date.getDate() + number * 7);
			return date;
			break;
		}
		case "d ": {
			date.setDate(date.getDate() + number);
			return date;
			break;
		}
		case "h ": {
			date.setHours(date.getHours() + number);
			return date;
			break;
		}
		case "mm ": {
			date.setMinutes(date.getMinutes() + number);
			return date;
			break;
		}
		case "s ": {
			date.setSeconds(date.getSeconds() + number);
			return date;
			break;
		}
		default: {
			date.setDate(d.getDate() + number);
			return date;
			break;
		}
	}
	
	/**
	var   now   =   new   Date();  
	//加五天.  
	var   newDate   =   DateAdd( "d ",5,now);  
	alert(newDate.toLocaleDateString())  
	//加两个月.  
	newDate   =   DateAdd( "m ",2,now);  
	alert(newDate.toLocaleDateString())  
	//加一年  
	newDate   =   DateAdd( "y ",1,now);  
	alert(newDate.toLocaleDateString())   
	*/
}


//CharMode函数 
//测试某个字符是属于哪一类. 
function CharMode(iN) {
	if (iN >= 48 && iN <= 57) //数字 
		return 1;
	if (iN >= 65 && iN <= 90) //大写字母 
		return 2;
	if (iN >= 97 && iN <= 122) //小写 
		return 4;
	else
		return 8; //特殊字符 
}
//bitTotal函数 
//计算出当前密码当中一共有多少种模式 
function bitTotal(num) {
	modes = 0;
	for (i = 0; i < 4; i++) {
		if (num & 1)
			modes++;
		num >>>= 1;
	}
	return modes;
}
//checkStrong函数 
//返回密码的强度级别 
function checkStrong(sPW) {
	if (sPW.length <= 4)
		return 0; //密码太短 
	Modes = 0;
	for (i = 0; i < sPW.length; i++) {
		//测试每一个字符的类别并统计一共有多少种模式. 
		Modes |= CharMode(sPW.charCodeAt(i));
	}
	return bitTotal(Modes);
}
//pwStrength函数 
//当用户放开键盘或密码输入框失去焦点时,根据不同的级别显示不同的颜色 
function pwStrength(pwd) {
	O_color = "#eeeeee";
	L_color = "#FF0000";
	M_color = "#FF9900";
	H_color = "#33CC00";
	if (pwd == null || pwd == '') {
		Lcolor = Mcolor = Hcolor = O_color;
	} else {
		S_level = checkStrong(pwd);
		switch (S_level) {
		case 0:
			Lcolor = Mcolor = Hcolor = O_color;
		case 1:
			Lcolor = L_color;
			Mcolor = Hcolor = O_color;
			break;
		case 2:
			Lcolor = Mcolor = M_color;
			Hcolor = O_color;
			break;
		default:
			Lcolor = Mcolor = Hcolor = H_color;
		}
	}
	document.getElementById("strength_L").style.background = Lcolor;
	document.getElementById("strength_M").style.background = Mcolor;
	document.getElementById("strength_H").style.background = Hcolor;
	return;
}




// 构造函数，变量为15位或者18位的身份证号码
function clsIDCard(CardNo) { 
  this.Valid = false; 
  this.ID15 = ''; 
  this.ID18 = ''; 
  this.Local = ''; 
  if (CardNo != null) 
    this.SetCardNo(CardNo); 
} 


// 设置身份证号码，15位或者18位
clsIDCard.prototype.SetCardNo = function(CardNo) { 
  this.ID15 = ''; 
  this.ID18 = ''; 
  this.Local = ''; 
  CardNo = CardNo.replace(" ", ""); 
  var strCardNo; 
  if (CardNo.length == 18) { 
    pattern = /^\d{17}(\d|x|X)$/; 
    if (pattern.exec(CardNo) == null) 
      return; 
    strCardNo = CardNo.toUpperCase(); 
  } else { 
    pattern = /^\d{15}$/; 
    if (pattern.exec(CardNo) == null) 
      return; 
    strCardNo = CardNo.substr(0, 6) + '19' + CardNo.substr(6, 9); 
    strCardNo += this.GetVCode(strCardNo); 
  } 
  this.Valid = this.CheckValid(strCardNo); 
}; 
// 校验身份证有效性
clsIDCard.prototype.IsValid = function() { 
  return this.Valid; 
}; 
// 返回生日字符串，格式如下，1981-10-10
clsIDCard.prototype.GetBirthDate = function() { 
  var BirthDate = ''; 
  if (this.Valid) 
    BirthDate = this.GetBirthYear() + '-' + this.GetBirthMonth() + '-' 
        + this.GetBirthDay(); 
  return BirthDate; 
}; 
// 返回生日中的年，格式如下，1981
clsIDCard.prototype.GetBirthYear = function() { 
  var BirthYear = ''; 
  if (this.Valid) 
    BirthYear = this.ID18.substr(6, 4); 
  return BirthYear; 
}; 
// 返回生日中的月，格式如下，10
clsIDCard.prototype.GetBirthMonth = function() { 
  var BirthMonth = ''; 
  if (this.Valid) 
    BirthMonth = this.ID18.substr(10, 2); 
  if (BirthMonth.charAt(0) == '0') 
    BirthMonth = BirthMonth.charAt(1); 
  return BirthMonth; 
}; 
// 返回生日中的日，格式如下，10
clsIDCard.prototype.GetBirthDay = function() { 
  var BirthDay = ''; 
  if (this.Valid) 
    BirthDay = this.ID18.substr(12, 2); 
  return BirthDay; 
}; 

// 返回性别，1：男，0：女
clsIDCard.prototype.GetSex = function() { 
  var Sex = ''; 
  if (this.Valid) 
    Sex = this.ID18.charAt(16) % 2; 
  return Sex; 
}; 

// 返回15位身份证号码
clsIDCard.prototype.Get15 = function() { 
  var ID15 = ''; 
  if (this.Valid) 
    ID15 = this.ID15; 
  return ID15; 
}; 

// 返回18位身份证号码
clsIDCard.prototype.Get18 = function() { 
  var ID18 = ''; 
  if (this.Valid) 
    ID18 = this.ID18; 
  return ID18; 
}; 

// 返回所在省，例如：上海市、浙江省
clsIDCard.prototype.GetLocal = function() { 
  var Local = ''; 
  if (this.Valid) 
    Local = this.Local; 
  return Local; 
}; 

clsIDCard.prototype.GetVCode = function(CardNo17) { 
  var Wi = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1); 
  var Ai = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'); 
  var cardNoSum = 0; 
  for (var i = 0; i < CardNo17.length; i++) 
    cardNoSum += CardNo17.charAt(i) * Wi[i]; 
  var seq = cardNoSum % 11; 
  return Ai[seq]; 
}; 

clsIDCard.prototype.CheckValid = function(CardNo18) { 
  if (this.GetVCode(CardNo18.substr(0, 17)) != CardNo18.charAt(17)) 
    return false; 
  if (!this.IsDate(CardNo18.substr(6, 8))) 
    return false; 
  var aCity = { 
    11 : "北京", 
    12 : "天津", 
    13 : "河北", 
    14 : "山西", 
    15 : "内蒙古", 
    21 : "辽宁", 
    22 : "吉林", 
    23 : "黑龙江 ", 
    31 : "上海", 
    32 : "江苏", 
    33 : "浙江", 
    34 : "安徽", 
    35 : "福建", 
    36 : "江西", 
    37 : "山东", 
    41 : "河南", 
    42 : "湖北 ", 
    43 : "湖南", 
    44 : "广东", 
    45 : "广西", 
    46 : "海南", 
    50 : "重庆", 
    51 : "四川", 
    52 : "贵州", 
    53 : "云南", 
    54 : "西藏 ", 
    61 : "陕西", 
    62 : "甘肃", 
    63 : "青海", 
    64 : "宁夏", 
    65 : "新疆", 
    71 : "台湾", 
    81 : "香港", 
    82 : "澳门", 
    91 : "国外" 
  }; 
  if (aCity[parseInt(CardNo18.substr(0, 2))] == null) 
    return false; 
  this.ID18 = CardNo18; 
  this.ID15 = CardNo18.substr(0, 6) + CardNo18.substr(8, 9); 
  this.Local = aCity[parseInt(CardNo18.substr(0, 2))]; 
  return true; 
}; 

clsIDCard.prototype.IsDate = function(strDate) { 
  var r = strDate.match(/^(\d{1,4})(\d{1,2})(\d{1,2})$/); 
  if (r == null) 
    return false; 
  var d = new Date(r[1], r[2] - 1, r[3]); 
  return (d.getFullYear() == r[1] && (d.getMonth() + 1) == r[2] && d 
      .getDate() == r[3]); 
};


String.prototype.Trim = function() {
	var m = this.match(/^\s*(\S+(\s+\S+)*)\s*$/);
	return (m == null) ? "" : m[1];
}

String.prototype.isMobile = function() {
	//return (/^(?:13\d|15[89])-?\d{5}(\d{3}|\*{3})$/.test(this.Trim()));
	return (/^(?:13\d|15\d|18\d)-?\d{5}(\d{3}|\*{3})$/.test(this.Trim()));
}

String.prototype.isTel = function(){
	// "兼容格式: 国家代码(2到3位)-区号(2到3位)-电话号码(7到8位)-分机号(3位)"
    // return
	// (/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(this.Trim()));
    return (/^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/.test(this.Trim()));
}

function checkTel(val) {
	if (tel.value.isMobile() || tel.value.isTel())  {
		//alert("您的电话/手机号码是:" + tel.value);
		return true;
	} else {
		//alert("请输入正确的手机号码或电话号码\n\n例如:13916752109或0712-3614072");
		return false;
	}
}
