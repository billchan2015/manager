package com.qifun.actions.model;

import java.util.List;

public class StructModel {
	private String tableName;
	private String id;
	private String desc;
	private List<StructInfoModel> structInfoModelList;

	public List<StructInfoModel> getStructInfoModelList() {
		return structInfoModelList;
	}

	public void setStructInfoModelList(List<StructInfoModel> structInfoModelList) {
		this.structInfoModelList = structInfoModelList;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
