package com.qifun.actions.model;

public class SQLModel {
	private int id;
	private String actionName;
	private int exeOrder;
	private String tempTable;
	private String actionSql;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public int getExeOrder() {
		return exeOrder;
	}

	public void setExeOrder(int exeOrder) {
		this.exeOrder = exeOrder;
	}

	public String getTempTable() {
		return tempTable;
	}

	public void setTempTable(String tempTable) {
		this.tempTable = tempTable;
	}

	public String getActionSql() {
		return actionSql;
	}

	public void setActionSql(String actionSql) {
		this.actionSql = actionSql;
	}

}
