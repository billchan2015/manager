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
		<s:submit action="queryaction" value="确定"><input type="button" value="添加action" onclick="addpage(this)"></s:submit>
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
			<td><input style="visibility: hidden;display: none;" type="button" value="保存" onclick="modifysql(this)"><input type="button" value="删除" onclick="delsql(this)"></td>
			</tr>
			</s:iterator>
			</table>
			<input style="background-color: DarkSeaGreen;" id="addsqlbtn" type="button" value="添加sql">
			<input style="background-color: DarkSeaGreen;" id="saveallsqlbtn" type="button" value="保存sql" onclick="saveallsql()">
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
			<td><input style="visibility: hidden;display: none;" type="button" value="保存" onclick="modifytb(this)"><input type="button" value="删除" onclick="deltb(this)"></td>
			</tr>
			</s:iterator>
			</table>
			<input style="background-color: AntiqueWhite;" id="addtbbtn" type="button" value="添加table">
			<input style="background-color: AntiqueWhite;" id="addtbbtn" type="button" value="保存table" onclick="savealltable()">
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
			<td><input style="visibility: hidden;display: none;" type="button" value="保存" onclick="modifyfinal(this)"><input type="button" value="删除" onclick="delfinal(this)"></td>
			</tr>
			</s:iterator>
			</table>
			<input style="background-color: LightBlue;" id="addfinalbtn" type="button" value="添加final">
			<input style="background-color: LightBlue;" id="addfinalbtn" type="button" value="保存final" onclick="saveallfinal()">
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
	
	
	function saveallsql(){
		var aaa = document.getElementById("currentactionname").value;
        
		var form = document.createElement('form');
        form.action = 'addSql';
        form.method = 'POST';

        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "currentactionname";
        input.value = aaa;
        form.appendChild(input);
        
        var sqlTable = document.getElementById("sqltable");
		var addSqlList = new Array();
		var modifySqlList = new Array();
		var j = 0;
		var k = 0;
		
		for (var i=1;i<sqlTable.rows.length;i++){
			if(sqlTable.rows[i].cells[0].getElementsByTagName("textarea")[0].value==-1){
				//新添加
        		var addsqlExeOrder = sqlTable.rows[i].cells[1].getElementsByTagName("textarea")[0].value;
        		var addsqltempTable = sqlTable.rows[i].cells[2].getElementsByTagName("textarea")[0].value;
        		var addsqlActionSql = sqlTable.rows[i].cells[3].getElementsByTagName("textarea")[0].value;
        		
        		var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "addSqlList["+ j +"].exeOrder";
                input.value = addsqlExeOrder;
                form.appendChild(input);
                
                var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "addSqlList["+ j +"].tempTable";
                input.value = addsqltempTable;
                form.appendChild(input);
                
                var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "addSqlList["+ j +"].actionSql";
                input.value = addsqlActionSql;
                form.appendChild(input);
                
                j = j + 1;
                
                var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "addSqlList";
                input.value = addSqlList;
                form.appendChild(input);
                
			}else{
				//修改
				var modifysqlId = sqlTable.rows[i].cells[0].getElementsByTagName("textarea")[0].value;
				var modifysqlExeOrder = sqlTable.rows[i].cells[1].getElementsByTagName("textarea")[0].value;
        		var modifysqltempTable = sqlTable.rows[i].cells[2].getElementsByTagName("textarea")[0].value;
        		var modifysqlActionSql = sqlTable.rows[i].cells[3].getElementsByTagName("textarea")[0].value;
        		
        		var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "modifySqlList["+ k +"].id";
                input.value = modifysqlId;
                form.appendChild(input);
                
        		var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "modifySqlList["+ k +"].exeOrder";
                input.value = modifysqlExeOrder;
                form.appendChild(input);
                
                var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "modifySqlList["+ k +"].tempTable";
                input.value = modifysqltempTable;
                form.appendChild(input);
                
                var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "modifySqlList["+ k +"].actionSql";
                input.value = modifysqlActionSql;
                form.appendChild(input);
                
                k = k + 1;
                
                var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "modifySqlList";
                input.value = modifySqlList;
                form.appendChild(input);
			}			
		}
		form.submit();
	}
	
	function savealltable(){
		var aaa = document.getElementById("currentactionname").value;
        
		var form = document.createElement('form');
        form.action = 'addtb';
        form.method = 'POST';

        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "currentactionname";
        input.value = aaa;
        form.appendChild(input);
        
        var tbTable = document.getElementById("tbtable");
		var addTbList = new Array();
		var modifyTbList = new Array();
		var j = 0;
		var k = 0;
		
		for (var i=1;i<tbTable.rows.length;i++){
			if(tbTable.rows[i].cells[0].getElementsByTagName("textarea")[0].value==-1){
				//新添加
        		var addtbexeOrder = tbTable.rows[i].cells[1].getElementsByTagName("textarea")[0].value;
        		var addtbactionTable = tbTable.rows[i].cells[2].getElementsByTagName("textarea")[0].value;
        		var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "addTbList["+ j +"].exeOrder";
                input.value = addtbexeOrder;
                form.appendChild(input);
                
                var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "addTbList["+ j +"].actionTable";
                input.value = addtbactionTable;
                form.appendChild(input);
                
                j = j + 1;
                
                var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "addTbList";
                input.value = addTbList;
                form.appendChild(input);
                
			}else{
				//修改
				var modifyTbId = tbTable.rows[i].cells[0].getElementsByTagName("textarea")[0].value;
				var modifyTbExeOrder = tbTable.rows[i].cells[1].getElementsByTagName("textarea")[0].value;
        		var modifyTbactionTable = tbTable.rows[i].cells[2].getElementsByTagName("textarea")[0].value;
        		var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "modifyTbList["+ k +"].id";
                input.value = modifyTbId;
                form.appendChild(input);
                
        		var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "modifyTbList["+ k +"].exeOrder";
                input.value = modifyTbExeOrder;
                form.appendChild(input);
                
                var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "modifyTbList["+ k +"].actionTable";
                input.value = modifyTbactionTable;
                form.appendChild(input);
                
                k = k + 1;
                
                var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "modifyTbList";
                input.value = modifyTbList;
                form.appendChild(input);
			}			
		}
		form.submit();
	}
	
	function saveallfinal(){
		var aaa = document.getElementById("currentactionname").value;
        
		var form = document.createElement('form');
        form.action = 'addfinal';
        form.method = 'POST';

        var input = document.createElement('textarea');
        input.type = 'hidden';
        input.name = "currentactionname";
        input.value = aaa;
        form.appendChild(input);
        
        var finalTable = document.getElementById("finaltable");
		var addFinalList = new Array();
		var modifyFinalList = new Array();
		var j = 0;
		var k = 0;
		
		for (var i=1;i<finalTable.rows.length;i++){
			if(finalTable.rows[i].cells[0].getElementsByTagName("textarea")[0].value==-1){
				//新添加
        		var addfinalexeOrder = finalTable.rows[i].cells[1].getElementsByTagName("textarea")[0].value;
        		var addfinalurl = finalTable.rows[i].cells[2].getElementsByTagName("textarea")[0].value;
        		var addfinalfinalTable = finalTable.rows[i].cells[3].getElementsByTagName("textarea")[0].value;
        		var addfinalfinalSql = finalTable.rows[i].cells[4].getElementsByTagName("textarea")[0].value;
        		
        		
        		var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "addFinalList["+ j +"].exeOrder";
                input.value = addfinalexeOrder;
                form.appendChild(input);
                
                var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "addFinalList["+ j +"].url";
                input.value = addfinalurl;
                form.appendChild(input);
                
                var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "addFinalList["+ j +"].finalTable";
                input.value = addfinalfinalTable;
                form.appendChild(input);
                
                var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "addFinalList["+ j +"].finalSql";
                input.value = addfinalfinalSql;
                form.appendChild(input);
                
                j = j + 1;
                
                var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "addFinalList";
                input.value = addFinalList;
                form.appendChild(input);
                
			}else{
				//修改
				var modifyfinalId = finalTable.rows[i].cells[0].getElementsByTagName("textarea")[0].value;
				var modifyfinalexeOrder = finalTable.rows[i].cells[1].getElementsByTagName("textarea")[0].value;
        		var modifyfinalurl = finalTable.rows[i].cells[2].getElementsByTagName("textarea")[0].value;
        		var modifyfinalTable = finalTable.rows[i].cells[3].getElementsByTagName("textarea")[0].value;
        		var modifyfinalSql = finalTable.rows[i].cells[4].getElementsByTagName("textarea")[0].value;
        		
        		
        		var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "modifyFinalList["+ k +"].id";
                input.value = modifyfinalId;
                form.appendChild(input);
                
                var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "modifyFinalList["+ k +"].exeOrder";
                input.value = modifyfinalexeOrder;
                form.appendChild(input);
                
                var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "modifyFinalList["+ k +"].url";
                input.value = modifyfinalurl;
                form.appendChild(input);
                
                var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "modifyFinalList["+ k +"].finalTable";
                input.value = modifyfinalTable;
                form.appendChild(input);
                
                var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "modifyFinalList["+ k +"].finalSql";
                input.value = modifyfinalSql;
                form.appendChild(input);
                
                k = k + 1;
                
                var input = document.createElement('textarea');
                input.type = 'hidden';
                input.name = "modifyFinalList";
                input.value = modifyFinalList;
                form.appendChild(input);
			}			
		}
		form.submit();
	}
	
	function canceladdsql(btn){
		var tr = btn.parentNode.parentNode;  
		var tb = tr.parentNode;
		tb.deleteRow(tr.rowIndex);
	}
	function canceladdtb(btn){
		var tr = btn.parentNode.parentNode;  
		var tb = tr.parentNode;
		tb.deleteRow(tr.rowIndex);
	}
	function canceladdfinal(btn){
		var tr = btn.parentNode.parentNode;  
		var tb = tr.parentNode;
		tb.deleteRow(tr.rowIndex);
	}
	
	$(document).ready(function(){
		$("#addsqlbtn").click(function(){  
	        $("#sqltable").append("<tr><td style='visibility: hidden;display: none;'><textarea>-1</textarea></td><td><textarea></textarea></td><td><textarea></textarea></td><td><textarea style='width: 700px;height: 800px'></textarea></td><td><input type='button' value='删除' onclick='canceladdsql(this)'></td></tr>");  
	    });
		$("#addtbbtn").click(function(){  
	        $("#tbtable").append("<tr><td style='visibility: hidden;display: none;'><textarea>-1</textarea></td><td><textarea></textarea></td><td><textarea></textarea></td><td><input type='button' value='删除' onclick='canceladdtb(this)'></td></tr>");  
	    });
	    $("#addfinalbtn").click(function(){  
	        $("#finaltable").append("<tr><td style='visibility: hidden;display: none;'><textarea>-1</textarea></td><td><textarea></textarea></td><td><textarea></textarea></td><td><textarea></textarea></td><td><textarea style='width: 700px;height: 800px'></textarea></td><td><input type='button' value='删除' onclick='canceladdfinal(this)'></td></tr>");  
	    });
	});
</script>

</html>