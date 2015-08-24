package com.qifun.actions.dao;

import java.util.List;

import com.qifun.actions.model.ActionModel;

public interface ActionsDao {
	public boolean checkUser(String username, String passwd);

	public List<ActionModel> getActions();

	public List<ActionModel> getActionsInfo();

	public List<ActionModel> getActionsInfoByName(String actionName);

	public boolean mofifyActionsInfo(String actionNme, String period,
			String step, String gameId, String worldId, String accountType);

	public boolean modifySql(String sqlId, String sqlExeOrder,
			String sqltempTable, String sqlActionSql);

	public boolean modifytb(String tbId, String tbExeOrder, String tbActionTable);

	public boolean modifyfinal(String finalId, String finalExeOrder,
			String finalURL, String finalFinalTable, String finalFinalSql);

	public boolean delaction(String actionName);

	public boolean delsql(String sqlId);

	public boolean deltb(String tbId);

	public boolean delfinal(String finalId);

	public boolean addaction(String actionName, String addperiod,
			String addstep, String addgameId, String addworldId,
			String addaccountType);

	public boolean addsql(String actionName, String addsqlExeOrder,
			String addsqltempTable, String addsqlActionSql);

	public boolean addtb(String actionName, String addtbexeOrder,
			String addtbactionTable);

	public boolean addfinal(String actionName, String addfinalexeOrder,
			String addfinalurl, String addfinalfinalTable,
			String addfinalfinalSql);

}
