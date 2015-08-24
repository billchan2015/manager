package com.qifun.actions.model;

import java.util.List;

public class ActionModel {
	private String actionNme;
	private String beforeActionName;
	private String period;
	private String step;
	private String gameId;
	private String worldId;
	private String accountType;

	private List<SQLModel> sqlList;
	private List<TableModel> tableList;
	private List<FinalModel> finalList;

	public String getActionNme() {
		return actionNme;
	}

	public void setActionNme(String actionNme) {
		this.actionNme = actionNme;
	}

	public String getBeforeActionName() {
		return beforeActionName;
	}

	public void setBeforeActionName(String beforeActionName) {
		this.beforeActionName = beforeActionName;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getWorldId() {
		return worldId;
	}

	public void setWorldId(String worldId) {
		this.worldId = worldId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public List<SQLModel> getSqlList() {
		return sqlList;
	}

	public void setSqlList(List<SQLModel> sqlList) {
		this.sqlList = sqlList;
	}

	public List<TableModel> getTableList() {
		return tableList;
	}

	public void setTableList(List<TableModel> tableList) {
		this.tableList = tableList;
	}

	public List<FinalModel> getFinalList() {
		return finalList;
	}

	public void setFinalList(List<FinalModel> finalList) {
		this.finalList = finalList;
	}

}
