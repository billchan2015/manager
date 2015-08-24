package com.qifun.actions.servlet;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.qifun.actions.dao.ActionsDao;
import com.qifun.actions.dao.impl.ActionsDaoImpl;
import com.qifun.actions.model.ActionModel;

public class LoginServlet extends ActionSupport {

	private String name;
	private String password;
	
	private List<ActionModel> actionNameList;
	private List<ActionModel> actionList;

	public List<ActionModel> getActionNameList() {
		return actionNameList;
	}

	public void setActionNameList(List<ActionModel> actionNameList) {
		this.actionNameList = actionNameList;
	}

	public List<ActionModel> getActionList() {
		return actionList;
	}

	public void setActionList(List<ActionModel> actionList) {
		this.actionList = actionList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String login() {
		ActionsDao actionsDao = new ActionsDaoImpl();
		actionNameList = actionsDao.getActionsInfo();
		actionList = new ArrayList<ActionModel>(); 
		return "success";
	}

}
