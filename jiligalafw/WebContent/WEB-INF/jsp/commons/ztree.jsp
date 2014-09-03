<%@ include file="/commons/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/commons/meta.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/widgets/ztree/css/zTreeStyle/zTreeStyle.css">
<script type="text/javascript" src="${ctx}/widgets/ztree/js/jquery.ztree.all-3.5.min.js"></script>
<style>
	body {
		font-size: 9pt;
		margin: 1px;
		font: normal 12px 宋体;
		scrollbar-face-color: #f3f3f3;
		scrollbar-highlight-color: #b9b9b9;
		scrollbar-shadow-color: #b9b9b9;
		scrollbar-arrow-color: #a2a2a2;
		scrollbar-track-color: #fcfcfc;
		scrollbar-3dlight-color: #ffffff;
		scrollbar-darkshadow-color: #ffffff;
	}

	#keyWord {
		border: 1px solid #ccc;
		width: 200px;
		height: 18px;
	}

	#buttonSearch {
		padding: 4px;
		border-bottom: 1px solid #ccc;
		margin-bottom: 2px;
	}

	#buttonBox {
		padding: 5px 0px;
		border-Top: 1px solid #ccc;
		margin-Top: 2px;
	}
	</style>
<script type="text/javascript">

var autoHeight = function(){};

var find;
var cancel;
var clearChecked;
var getResult;

$(document).ready(function(){
	
	
	var params = {
			"model"		: '${param.model}'||'${model}',
			"action" 	: '${param.action}'||'${action}',
			"target" 	: '${param.target}'||'${target}',
			"onlyLeaf"	: '${param.onlyLeaf}'||'${onlyLeaf}',
			"values"	: '${param.values}'||'${values}'
	};
	
	var ztree_select_model = 'checkbox';
	switch (params['model']){
		case 'c': 
			ztree_select_model = 'checkbox';
			break;
		case 'r': 
			ztree_select_model = 'radio';
			break;	
	}

	var ztree_href = params['action'] || '';
	var ztree_target = params['target'] || '';
	var ztree_onlyLeaf = params['onlyLeaf'] || '';
	var ztree_selected = params['values'] || '';

	if (window.dialogArguments && window.dialogArguments.values) {
		ztree_selected = window.dialogArguments.values;
	}
	
	function isSelected(val){
		var vals = ztree_selected.split(",");
		if(!vals){
			return false;
		}
		for(var i = 0 ;i<vals.length;i++){
			if(val == vals[i]){
				return true;
			}
		}
		return false;
	}
	
	var zNodes =[
		<c:forEach items="${tree}" var="node" varStatus="idx">
		<c:if test="${idx.index!=0}">,</c:if>
		{ id:"${node.id}", pId:"${node.pid}", name:"${node.name}" ,result:"${node.result}"}
		</c:forEach>
	];
	
	for(var i = 0;i<zNodes.length;i++){
		if(isSelected(zNodes[i].id)){
			zNodes[i].checked = true;
		}
	}
	
	if (window.dialogHeight != null || window.opener != null) {
		buttonBox.style.display = 'block';
		buttonSearch.style.display = 'block';
		tree.style.height = '350px';
		tree.style.overflow = 'auto';
		tree.style.position = 'relative';
		buttonBox.style.height = '15%';
		document.body.style.overflow = 'hidden';
	}
	else {
		buttonSearch.style.display = 'block';
		keyWord.style.width = '200px';
	}
	
	var finder = '${param.finder}'||'${finder}';
	if(finder == 'false'){
		$('#buttonSearch').hide();
	}
	
	$.fn.zTree.init($("#tree"), {
		view: {
			expandSpeed: "slow",
			selectedMulti: false
		},
		check: {
			enable: true,
			radioType: "all",
			chkStyle: ztree_select_model  //checkbox radio
						
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			beforeClick: function(treeId, treeNode, clickFlag){
				if(ztree_onlyLeaf == '1'){
					if(treeNode
							&& treeNode.isParent){
						return false;
					}
				}
			},
			onClick: function(event, treeId, treeNode){
				if(ztree_href
						&& ztree_target){
					window.open(ztree_href,ztree_target);
				} else {
					$.fn.zTree.getZTreeObj(treeId).checkNode(treeNode,!treeNode.checked,true);
				}
			}
		}
	}, zNodes);
	
/* 	var treeObj = $.fn.zTree.getZTreeObj("tree");
	var nodes = treeObj.getNodes();
	Loop:
	for (var i=0, l=nodes.length; i < l; i++) {
		for(var j=0;j<ztree_selected.length;j++){
			if(ztree_selected[j]===nodes[i].id){
				treeObj.checkNode(nodes[i], true, true);
				break Loop;
			}
		}
	}
 */	
 
 	var findValue = '';
	var findIndex = 0;

 	var treeObj = $.fn.zTree.getZTreeObj("tree");
 	var nodes = treeObj.transformToArray(treeObj.getNodes());

 	find = function () {
 	
	 	var key = keyWord.value.toLowerCase();
	 	if (key != findValue || findIndex >= nodes.length) {
	 		findIndex = 0;
	 	}
	 	findValue = key;
	 	if (findValue == '') {
	 		return;
	 	}
	 	
	 	for(;findIndex<nodes.length;findIndex++){
	 		var node = nodes[findIndex];
	 		if (node.name.toLowerCase().indexOf(findValue) != -1) {
	 			treeObj.selectNode(node,false);
	 			findIndex++;
	 			break;
	 		}
	 	}
 	}
 
 	getResult = function (){
 		var checkedNodes = treeObj.getCheckedNodes(true) || {};
		var result = {id:"",name:""};
		
		var checked = [];
		for(var i=0;i<checkedNodes.length;i++){
			var node = checkedNodes[i];
			node.result = node.result || "true";
			if(node.result == "true"){
				checked.push(node);
			}
		}
		
		switch (params['model']){
		case 'c': 
			for(var i =0;i<checked.length;i++){
				var delimiter = ',';
				if(i==checked.length-1){
					delimiter = '';
				}
				var node = checked[i];
				result.id += node.id +delimiter;
				result.name += node.name+delimiter;
			}
			break;
		case 'r': 
			var node = checked[0];
			result.id = node.id;
			result.name = node.name;
			break;	
		}
		return result;
 	}
 	
 	ok = function () {
		
		window.returnValue = getResult();
		self.close();
 	}
 
 	cancel = function () {
		self.close();
	}
	
 	clearChecked = function () {
 		var result = {};
 		result.id = '';
 		result.name='';
		window.returnValue = result;
		cancel();
	}
});



</script>
<title></title>

</head>
<body oncontextmenu="window.event.returnValue=false">

<div id="buttonSearch" style="width: 100%; display: none;">
	<input type="text" id="keyWord"/>&nbsp;
	<img src="${ctx}/images/btn15.png" alt="查 找" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:find();"/>
</div>

<div id="tree" class="ztree" style="width: 100%; height: 100%; font-size: 12px"></div>
</body>

<div id="buttonBox" align="center" style="width: 100%; display: none;">
    <img src="${ctx}/images/btn37.png" alt="确 定" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:ok();"/>
    &nbsp;&nbsp;
    <img src="${ctx}/images/btn38.png" alt="清 除" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:clearChecked();"/>
    &nbsp;&nbsp;
    <img src="${ctx}/images/btn8.png" alt="关闭" width="101" height="30" border="0" align="absmiddle" style="cursor:pointer;" onclick="javascript:cancel();"/>
</div>
</html>