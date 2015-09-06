<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add</title>
</head>
<body style="text-align: center;">
<div style="margin-left: auto;margin-right: auto;text-align: center;width: 1800px;height: 100%;">
	<p>添加action</p>
	<s:form action="addactionaction" method="post">
		actionName:<input type="text" name="addName" id="addName"/>
		period:<input type="text" name="addPeriod" />
		step:<input type="text" name="addStep" /><br><br>
		gameId:<input type="text" name="addGameId" />
		worldId:<input type="text" name="addWorldId" />
		accountType:<input type="text" name="addAccountType" /><br><br>
		是否添加为模版:<s:select list="#{o:'false',1:'true'}" id="isTemplate" name="isTemplate" label="是否添加为模版" listKey="key" listValue="value" theme="simple"/>&nbsp;
		<input type="submit" value="确定添加" />
	</s:form><br>
	<div style="margin-left: auto;margin-right: auto;width: 750px">
	<table style="text-align:left;">
	<tr><td>Tips:</td></tr>
	<tr><td>*添加action时可同时将action设置为模版，在下拉单中选择true，并提交</td></tr>
	<tr><td>*使用模版添加action时先填写actionName，然后在模版表中点击对应模版《使用》按钮</td></tr>
	</table>
	</div>
	<p>模版表</p>
	<table style="margin:auto;border:solid 1px;color: black;text-align:center;width: 1400px;background-color:DarkGray;">
		<tr><td style="display: none;"></td><td>period</td><td>step</td><td>gameId</td><td>worldId</td><td>accountType</td><td>操作</td></tr>
		<s:iterator value="templateList" var="template">
		<tr>
			<td style="visibility: hidden;display: none;"><textarea><s:property value="#template.id"></s:property></textarea></td>
			<td><textarea><s:property value="#template.period"></s:property></textarea></td>
			<td><textarea><s:property value="#template.step"></s:property></textarea></td>
			<td><textarea><s:property value="#template.gameId"></s:property></textarea></td>
			<td><textarea><s:property value="#template.worldId"></s:property></textarea></td>
			<td><textarea><s:property value="#template.accountType"></s:property></textarea></td>
			<td><input type="button" value="使用" onclick="use(this)"><input type="button" value="保存" onclick="modify(this)"><input type="button" value="删除" onclick="del(this)"></td>
		</tr>
		</s:iterator>
	</table>
</div>
</body>
<script type="text/javascript">
function use(btn){
	
	var tr = btn.parentNode.parentNode;  
	var ac = document.getElementById("addName").value;
	if(ac == ""){  
	     alert("actionName is null !");  
	     addName.focus();
	     return false;
	}  
	var p = tr.cells[0].childNodes[0].value;
	var s = tr.cells[1].childNodes[0].value;
	var g = tr.cells[2].childNodes[0].value;
	var w = tr.cells[3].childNodes[0].value;
	var a = tr.cells[4].childNodes[0].value;
	
	var form = document.createElement('form');
    form.action = 'addactionaction';
    form.method = 'POST';

    var input = document.createElement('textarea');
    input.type = 'hidden';
    input.name = "addName";
    input.value = ac;
    form.appendChild(input);
    
    var input = document.createElement('textarea');
    input.type = 'hidden';
    input.name = "addPeriod";
    input.value = p;
    form.appendChild(input);
    
    var input = document.createElement('textarea');
    input.type = 'hidden';
    input.name = "addStep";
    input.value = s;
    form.appendChild(input);
    
    var input = document.createElement('textarea');
    input.type = 'hidden';
    input.name = "addGameId";
    input.value = g;
    form.appendChild(input);
    
    var input = document.createElement('textarea');
    input.type = 'hidden';
    input.name = "addWorldId";
    input.value = w;
    form.appendChild(input);
    
    var input = document.createElement('textarea');
    input.type = 'hidden';
    input.name = "addAccountType";
    input.value = a;
    form.appendChild(input);
    
    form.submit();
	
}

function modify(btn){
	
	var tr = btn.parentNode.parentNode;  
	var ac = tr.cells[0].childNodes[0].value;
	var p = tr.cells[1].childNodes[0].value;
	var s = tr.cells[2].childNodes[0].value;
	var g = tr.cells[3].childNodes[0].value;
	var w = tr.cells[4].childNodes[0].value;
	var a = tr.cells[5].childNodes[0].value;
	
	var form = document.createElement('form');
    form.action = 'modifyTemplate';
    form.method = 'POST';

    var input = document.createElement('textarea');
    input.type = 'hidden';
    input.name = "templateId";
    input.value = ac;
    form.appendChild(input);
    
    var input = document.createElement('textarea');
    input.type = 'hidden';
    input.name = "period";
    input.value = p;
    form.appendChild(input);
    
    var input = document.createElement('textarea');
    input.type = 'hidden';
    input.name = "step";
    input.value = s;
    form.appendChild(input);
    
    var input = document.createElement('textarea');
    input.type = 'hidden';
    input.name = "gameId";
    input.value = g;
    form.appendChild(input);
    
    var input = document.createElement('textarea');
    input.type = 'hidden';
    input.name = "worldId";
    input.value = w;
    form.appendChild(input);
    
    var input = document.createElement('textarea');
    input.type = 'hidden';
    input.name = "accountType";
    input.value = a;
    form.appendChild(input);
    
    form.submit();
	
}

function del(btn){
	var tr = btn.parentNode.parentNode;
	var id = tr.cells[0].childNodes[0].value;
	
	window.location.href="delTemplate.action?templateId="+id;
}
</script>
</html>