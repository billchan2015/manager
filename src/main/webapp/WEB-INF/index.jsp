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
	<div id="actionsdiv" style="margin-left: auto;margin-right: auto;text-align: center;width: 1401px;height: 100%">
		<s:form id="actonSelectForm" name="actonSelectForm"><s:select name="actonSelect" id="actonSelect" headerKey="-1" headerValue="请选择action" list="actionNameList" listKey="actionNme" listValue="actionNme" size="10" cssStyle="width:300px" ondblclick="onblcli(this)"></s:select>
		<s:submit action="queryaction" value="确定"><input type="button" value="添加action" onclick="addpage()"></s:submit>
		</s:form>
	<div style="visibility: hidden;"><textarea id="currentactionname" name="currentactionname"><s:property value="currentactionname"></s:property></textarea></div>	
	<table style="text-align:center;height: 100%;width: 100%">
		<s:iterator value="actionList" var="action">
		<tr>
		<td>
		<table style="border:solid 1px;color: black;text-align:center;width: 1400px;background-color:DarkGray;">
		<tr><td>name</td><td>period</td><td>step</td><td>gameId</td><td>worldId</td><td>accountType</td><td>操作</td></tr>
		<tr>
			<td><textarea style="color: red;" readonly="readonly"><s:property value="#action.actionNme"></s:property></textarea></td>
			<td><textarea><s:property value="#action.period"></s:property></textarea></td>
			<td><textarea><s:property value="#action.step"></s:property></textarea></td>
			<td><textarea><s:property value="#action.gameId"></s:property></textarea></td>
			<td><textarea><s:property value="#action.worldId"></s:property></textarea></td>
			<td><textarea><s:property value="#action.accountType"></s:property></textarea></td>
			<td><input type="button" value="保存" onclick="modifyaction(this)"><input type="button" value="删除" onclick="delaction(this)"></td>
		</tr>
		</table>
		</td>
		</tr>
		<tr><td><hr/></td></tr>
		<tr>
			<td>
			<table id="sqltable" style="border:solid 1px;color: black;text-align:center;width: 1400px;background-color: DarkSeaGreen;">
			<tr><td style="display: none;"></td><td>exeOrder</td><td>tempTable</td><td>actionSql</td><td>操作</td></tr>
			<s:iterator value="#action.sqlList" var="sql">
			<tr>
			<td style="visibility: hidden;display: none;"><textarea><s:property value="#sql.id"></s:property></textarea></td>
			<td><textarea><s:property value="#sql.exeOrder"></s:property></textarea></td>
			<td><textarea><s:property value="#sql.tempTable"></s:property></textarea></td>
			<td><textarea style="width: 700px;height: 800px"><s:property value="#sql.actionSql"></s:property></textarea></td>
			<td><input type="button" value="保存" onclick="modifysql(this)"><input type="button" value="删除" onclick="delsql(this)"></td>
			</tr>
			</s:iterator>
			</table>
			<input style="background-color: DarkSeaGreen;" id="addsqlbtn" type="button" value="添加sql">
			</td>
		</tr>
		<tr><td><hr/></td></tr>
		<tr>
			<td>
			<table id="tbtable" style="border:solid 1px;color: black;text-align:center;background-color: AntiqueWhite;">
			<tr><td style="display: none;"></td><td>exeOrder</td><td>actionTable</td><td>操作</td></tr>
			<s:iterator value="#action.tableList" var="tb">
			<tr>
			<td style="visibility: hidden;display: none;"><textarea><s:property value="#tb.id"></s:property></textarea></td>
			<td><textarea><s:property value="#tb.exeOrder"></s:property></textarea></td>
			<td><textarea><s:property value="#tb.actionTable"></s:property></textarea></td>
			<td><input type="button" value="保存" onclick="modifytb(this)"><input type="button" value="删除" onclick="deltb(this)"></td>
			</tr>
			</s:iterator>
			</table>
			<input style="background-color: AntiqueWhite;" id="addtbbtn" type="button" value="添加table">
			</td>
		</tr>
		<tr><td><hr/></td></tr>
		<tr>
			<td>
			<table id="finaltable" style="border:solid 1px;color: black;text-align:center;width: 1400px;background-color: LightBlue;">
			<tr><td style="display: none;"></td><td>exeOrder</td><td>url</td><td>finalTable</td><td>finalSql</td><td>操作</td></tr>
			<s:iterator value="#action.finalList" var="final">
			<tr>
			<td style="visibility: hidden;display: none;"><textarea><s:property value="#final.id"></s:property></textarea></td>
			<td><textarea><s:property value="#final.exeOrder"></s:property></textarea></td>
			<td><textarea><s:property value="#final.url"></s:property></textarea></td>
			<td><textarea><s:property value="#final.finalTable"></s:property></textarea></td>
			<td><textarea style="width: 700px;height: 800px"><s:property value="#final.finalSql"></s:property></textarea></td>
			<td><input type="button" value="保存" onclick="modifyfinal(this)"><input type="button" value="删除" onclick="delfinal(this)"></td>
			</tr>
			</s:iterator>
			</table>
			<input style="background-color: LightBlue;" id="addfinalbtn" type="button" value="添加final">
			</td>
		</tr>
		<tr><td><hr/></td></tr>
		</s:iterator>
	</table>
	
	
	</div>

</body>
<script type="text/javascript">
	function onblcli(btn){
		document.getElementById("actonSelectForm").submit();
	}
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
        
        var aaa = document.getElementById("currentactionname").value;
        
        var form = document.createElement('form');
        form.action = 'modifySql';
        form.method = 'POST';
        
        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "currentactionname";
        input.value = aaa;
        form.appendChild(input);

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
		
        var aaa = document.getElementById("currentactionname").value;
        
		var form = document.createElement('form');
        form.action = 'modifytb';
        form.method = 'POST';
        
        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "currentactionname";
        input.value = aaa;
        form.appendChild(input);

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
		
        var aaa = document.getElementById("currentactionname").value;
        
		var form = document.createElement('form');
        form.action = 'modifyfinal';
        form.method = 'POST';
        
        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "currentactionname";
        input.value = aaa;
        form.appendChild(input);

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
		var aaa = document.getElementById("currentactionname").value;
		window.location.href="delsql.action?delsqlid="+id+"&currentactionname="+aaa;
	}
	function deltb(btn){
		var tr = btn.parentNode.parentNode;
		var id = tr.cells[0].childNodes[0].value;
		var aaa = document.getElementById("currentactionname").value;
		window.location.href="deltb.action?deltbid="+id+"&currentactionname="+aaa;
	}
	function delfinal(btn){
		var tr = btn.parentNode.parentNode;
		var id = tr.cells[0].childNodes[0].value;
		var aaa = document.getElementById("currentactionname").value;
		window.location.href="delfinal.action?delfinalid="+id+"&currentactionname="+aaa;
	}
	
	function savesql(btn){
		var tr = btn.parentNode.parentNode;  
		
		var e = tr.cells[1].childNodes[0].value;
		var t = tr.cells[2].childNodes[0].value;
		var a = tr.cells[3].childNodes[0].value;
		
		var aaa = document.getElementById("currentactionname").value;
        
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
	        $("#sqltable").append("<tr><td style='visibility: hidden;display: none;'><textarea></textarea></td><td><textarea></textarea></td><td><textarea></textarea></td><td><textarea style='width: 700px;height: 800px'></textarea></td><td><input type='button' value='保存' onclick='savesql(this)'></td></tr>");  
	    });
		$("#addtbbtn").click(function(){  
	        $("#tbtable").append("<tr><td style='visibility: hidden;display: none;'><textarea></textarea></td><td><textarea></textarea></td><td><textarea></textarea></td><td><input type='button' value='保存' onclick='savetb(this)'></td></tr>");  
	    });
	    $("#addfinalbtn").click(function(){  
	        $("#finaltable").append("<tr><td style='visibility: hidden;display: none;'><textarea></textarea></td><td><textarea></textarea></td><td><textarea></textarea></td><td><textarea></textarea></td><td><textarea style='width: 700px;height: 800px'></textarea></td><td><input type='button' value='保存' onclick='savefinal(this)'></td></tr>");  
	    });
	});
</script>

</html>