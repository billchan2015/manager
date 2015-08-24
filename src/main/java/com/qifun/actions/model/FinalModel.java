package com.qifun.actions.model;

public class FinalModel {
	private int id;
	private String actionName;
	private int exeOrder;
	private String url;
	private String finalTable;
	private String finalSql;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFinalTable() {
		return finalTable;
	}

	public void setFinalTable(String finalTable) {
		this.finalTable = finalTable;
	}

	public String getFinalSql() {
		return finalSql;
	}

	public void setFinalSql(String finalSql) {
		this.finalSql = finalSql;
	}

}
