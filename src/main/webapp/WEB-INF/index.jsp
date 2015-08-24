<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-2.1.1.js" ></script>
<title>index</title>
</head>
<body style="text-align: center;">
	<div id="actionsdiv" style="margin-left: auto;margin-right: auto;text-align: center;width: 1200px;height: 100%">
		<s:form><s:select name="actonSelect" id="actonSelect" headerKey="-1" headerValue="请选择action" list="actionNameList" listKey="actionNme" listValue="actionNme" size="10" cssStyle="width:300px"></s:select>
		<s:submit action="queryaction" value="确定"><input type="button" value="添加action" onclick="addpage()"></s:submit>
		</s:form>
	<div style="visibility: hidden;"><textarea id="currentactionname"><s:property value="currentactionname"></s:property></textarea></div>	
	<table style="text-align:center;width: 1200px;height: 100%">
		<s:iterator value="actionList" var="action">
		<tr>
		<td>
		<table style="border:solid 1px;color: black;text-align:center;">
		<tr><td>name</td><td>period</td><td>step</td><td>gameId</td><td>worldId</td><td>accountType</td><td>操作</td></tr>
		<tr>
			<td><textarea style="color: red;"><s:property value="#action.actionNme"></s:property></textarea></td>
			<td><textarea><s:property value="#action.period"></s:property></textarea></td>
			<td><textarea><s:property value="#action.step"></s:property></textarea></td>
			<td><textarea><s:property value="#action.gameId"></s:property></textarea></td>
			<td><textarea><s:property value="#action.worldId"></s:property></textarea></td>
			<td><textarea><s:property value="#action.accountType"></s:property></textarea></td>
			<td><input type="button" value="修改" onclick="modifyaction(this)"><input type="button" value="删除" onclick="delaction(this)"></td>
		</tr>
		</table>
		</td>
		<tr>
			<td>
			<table id="sqltable" style="border:solid 1px;color: black;text-align:center;">
			<tr><td></td><td>exeOrder</td><td>tempTable</td><td>actionSql</td><td>操作</td></tr>
			<s:iterator value="#action.sqlList" var="sql">
			<tr>
			<td style="visibility: hidden;"><textarea><s:property value="#sql.id"></s:property></textarea></td>
			<td><textarea><s:property value="#sql.exeOrder"></s:property></textarea></td>
			<td><textarea><s:property value="#sql.tempTable"></s:property></textarea></td>
			<td><textarea style="width: 700px;height: 800px"><s:property value="#sql.actionSql"></s:property></textarea></td>
			<td><input type="button" value="修改" onclick="modifysql(this)"><input type="button" value="删除" onclick="delsql(this)"></td>
			</tr>
			</s:iterator>
			</table>
			<input id="addsqlbtn" type="button" value="添加">
			</td>
		</tr>
		<tr>
			<td>
			<table id="tbtable" style="border:solid 1px;color: black;text-align:center;">
			<tr><td></td><td>exeOrder</td><td>actionTable</td><td>操作</td></tr>
			<s:iterator value="#action.tableList" var="tb">
			<tr>
			<td style="visibility: hidden;"><textarea><s:property value="#tb.id"></s:property></textarea></td>
			<td><textarea><s:property value="#tb.exeOrder"></s:property></textarea></td>
			<td><textarea><s:property value="#tb.actionTable"></s:property></textarea></td>
			<td><input type="button" value="修改" onclick="modifytb(this)"><input type="button" value="删除" onclick="deltb(this)"></td>
			</tr>
			</s:iterator>
			</table>
			<input id="addtbbtn" type="button" value="添加">
			</td>
		</tr>
		<tr>
			<td>
			<table id="finaltable" style="border:solid 1px;color: black;text-align:center;">
			<tr><td></td><td>exeOrder</td><td>url</td><td>finalTable</td><td>finalSql</td><td>操作</td></tr>
			<s:iterator value="#action.finalList" var="final">
			<tr>
			<td style="visibility: hidden;"><textarea><s:property value="#final.id"></s:property></textarea></td>
			<td><textarea><s:property value="#final.exeOrder"></s:property></textarea></td>
			<td><textarea><s:property value="#final.url"></s:property></textarea></td>
			<td><textarea><s:property value="#final.finalTable"></s:property></textarea></td>
			<td><textarea style="width: 700px;height: 800px"><s:property value="#final.finalSql"></s:property></textarea></td>
			<td><input type="button" value="修改" onclick="modifyfinal(this)"><input type="button" value="删除" onclick="delfinal(this)"></td>
			</tr>
			</s:iterator>
			</table>
			<input id="addfinalbtn" type="button" value="添加">
			</td>
		</tr>
		
		</s:iterator>
	</table>
	
	
	</div>

</body>
<script type="text/javascript">
 	function addpage(btn){

 		window.location.href="addpage.action?"
 	}
	function modifyaction(btn){
		
		var tr = btn.parentNode.parentNode;  
		var ac = tr.cells[0].childNodes[0].value;
		var p = tr.cells[1].childNodes[0].value;
		var s = tr.cells[2].childNodes[0].value;
		var g = tr.cells[3].childNodes[0].value;
		var w = tr.cells[4].childNodes[0].value;
		var a = tr.cells[5].childNodes[0].value;
		
        //window.location.href="modifyaction.action?actionNme="+ac+"&period="+p+"&step="+s+"&gameId="+g+"&worldId="+w+"&accountType="+a;
        
		var form = document.createElement('form');
        form.action = 'modifyaction';
        form.method = 'POST';

        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "actionNme";
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
	function modifysql(btn){
		
		var tr = btn.parentNode.parentNode;  
		var id = tr.cells[0].childNodes[0].value;
		var e = tr.cells[1].childNodes[0].value;
		var t = tr.cells[2].childNodes[0].value;
		var a = tr.cells[3].childNodes[0].value;
        
        //window.location.href="modifySql.action?sqlId="+id+"&sqlExeOrder="+e+"&sqltempTable="+t+"&sqlActionSql="+a;
        
		var form = document.createElement('form');
        form.action = 'modifySql';
        form.method = 'POST';

        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "sqlId";
        input.value = id;
        form.appendChild(input);
        
        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "sqlExeOrder";
        input.value = e;
        form.appendChild(input);
        
        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "sqltempTable";
        input.value = t;
        form.appendChild(input);
        
        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "sqlActionSql";
        input.value = a;
        form.appendChild(input);
        
        form.submit();
		
	}
	function modifytb(btn){
		var tr = btn.parentNode.parentNode;  
		var id = tr.cells[0].childNodes[0].value;
		var e = tr.cells[1].childNodes[0].value;
		var a = tr.cells[2].childNodes[0].value;
		
        //window.location.href="modifytb.action?tbId="+id+"&tbExeOrder="+e+"&tbActionTable="+a;
        
		var form = document.createElement('form');
        form.action = 'modifytb';
        form.method = 'POST';

        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "tbId";
        input.value = id;
        form.appendChild(input);
        
        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "tbExeOrder";
        input.value = e;
        form.appendChild(input);
        
        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "tbActionTable";
        input.value = a;
        form.appendChild(input);
        
        form.submit();
        
	}
	function modifyfinal(btn){
		var tr = btn.parentNode.parentNode;  
		var id = tr.cells[0].childNodes[0].value;
		var e = tr.cells[1].childNodes[0].value;
		var u = tr.cells[2].childNodes[0].value;
		var ft = tr.cells[3].childNodes[0].value;
		var fs = tr.cells[4].childNodes[0].value;
		
        //window.location.href="modifyfinal.action?finalId="+id+"&finalExeOrder="+e+"&finalURL="+u+"&finalFinalTable="+ft+"&finalFinalSql="+fs;
        
		var form = document.createElement('form');
        form.action = 'modifyfinal';
        form.method = 'POST';

        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "finalId";
        input.value = id;
        form.appendChild(input);
        
        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "finalExeOrder";
        input.value = e;
        form.appendChild(input);
        
        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "finalURL";
        input.value = u;
        form.appendChild(input);
        
        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "finalFinalTable";
        input.value = ft;
        form.appendChild(input);
        
        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "finalFinalSql";
        input.value = fs;
        form.appendChild(input);

        form.submit();
	}
	
	function delaction(btn){
		var tr = btn.parentNode.parentNode;
		var name = tr.cells[0].childNodes[0].value;
		window.location.href="delaction.action?delActionNme="+name;
	}
	function delsql(btn){
		var tr = btn.parentNode.parentNode;
		var id = tr.cells[0].childNodes[0].value;
		window.location.href="delsql.action?delsqlid="+id;
	}
	function deltb(btn){
		var tr = btn.parentNode.parentNode;
		var id = tr.cells[0].childNodes[0].value;
		window.location.href="deltb.action?deltbid="+id;
	}
	function delfinal(btn){
		var tr = btn.parentNode.parentNode;
		var id = tr.cells[0].childNodes[0].value;
		window.location.href="delfinal.action?delfinalid="+id;
	}
	
	function savesql(btn){
		var tr = btn.parentNode.parentNode;  
		
		var e = tr.cells[1].childNodes[0].value;
		var t = tr.cells[2].childNodes[0].value;
		var a = tr.cells[3].childNodes[0].value;
		
		var aaa = document.getElementById("currentactionname").value;
		alert(aaa);
        //window.location.href="addSql.action?currentactionname="+aaa+"&addsqlExeOrder="+e+"&addsqltempTable="+t+"&addsqlActionSql="+a;
        
		var form = document.createElement('form');
        form.action = 'addSql';
        form.method = 'POST';

        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "currentactionname";
        input.value = aaa;
        form.appendChild(input);
        
        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "addsqlExeOrder";
        input.value = e;
        form.appendChild(input);
        
        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "addsqltempTable";
        input.value = t;
        form.appendChild(input);
        
        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "addsqlActionSql";
        input.value = a;
        form.appendChild(input);

        form.submit();
	}
	
	function savetb(btn){
		var tr = btn.parentNode.parentNode;  
		
		var e = tr.cells[1].childNodes[0].value;
		var t = tr.cells[2].childNodes[0].value;
		
		var aaa = document.getElementById("currentactionname").value;
		alert(aaa);
		//window.location.href="addtb.action?currentactionname="+aaa+"&addtbexeOrder="+e+"&addtbactionTable="+t;
		
		var form = document.createElement('form');
        form.action = 'addtb';
        form.method = 'POST';

        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "currentactionname";
        input.value = aaa;
        form.appendChild(input);
        
        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "addtbexeOrder";
        input.value = e;
        form.appendChild(input);
        
        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "addtbactionTable";
        input.value = t;
        form.appendChild(input);

        form.submit();
	}
	
	function savefinal(btn){
		var tr = btn.parentNode.parentNode;  
		
		var e = tr.cells[1].childNodes[0].value;
		var t = tr.cells[2].childNodes[0].value;
		var a = tr.cells[3].childNodes[0].value;
		var p = tr.cells[4].childNodes[0].value;
		
		var aaa = document.getElementById("currentactionname").value;
		alert(aaa);
		//window.location.href="addfinal.action?currentactionname="+aaa+"&addfinalexeOrder="+e+"&addfinalurl="+t+"&addfinalfinalTable="+a+"&addfinalfinalSql="+p;
        
        var form = document.createElement('form');
        form.action = 'addfinal';
        form.method = 'POST';

        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "currentactionname";
        input.value = aaa;
        form.appendChild(input);
        
        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "addfinalexeOrder";
        input.value = e;
        form.appendChild(input);
        
        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "addfinalurl";
        input.value = t;
        form.appendChild(input);
        
        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "addfinalfinalTable";
        input.value = a;
        form.appendChild(input);
        
        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "addfinalfinalSql";
        input.value = p;
        form.appendChild(input);

        form.submit();
	}
	
	
	$(document).ready(function(){
		$("#addsqlbtn").click(function(){  
	        $("#sqltable").append("<tr><td style='visibility: hidden;'><textarea></textarea></td><td><textarea></textarea></td><td><textarea></textarea></td><td><textarea style='width: 700px;height: 800px'></textarea></td><td><input type='button' value='保存' onclick='savesql(this)'></td></tr>");  
	    });
		$("#addtbbtn").click(function(){  
	        $("#tbtable").append("<tr><td style='visibility: hidden;'><textarea></textarea></td><td><textarea></textarea></td><td><textarea></textarea></td><td><input type='button' value='保存' onclick='savetb(this)'></td></tr>");  
	    });
	    $("#addfinalbtn").click(function(){  
	        $("#finaltable").append("<tr><td style='visibility: hidden;'><textarea></textarea></td><td><textarea></textarea></td><td><textarea></textarea></td><td><textarea></textarea></td><td><textarea style='width: 700px;height: 800px'></textarea></td><td><input type='button' value='保存' onclick='savefinal(this)'></td></tr>");  
	    });
	});
</script>

</html>