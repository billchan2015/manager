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
<div style="margin-left: auto;margin-right: auto;text-align: center;width: 800px;height: 100%">
	<s:form action="addactionaction" method="post">
		name:<input type="text" name="addName" />
		period:<input type="text" name="addPeriod" />
		step:<input type="text" name="addStep" /><br>
		gameId:<input type="text" name="addGameId" />
		worldId:<input type="text" name="addWorldId" />
		accountType:<input type="text" name="addAccountType" /><br>
		<input type="submit" value="确定" />
	</s:form>
	
</div>
</body>
</html>