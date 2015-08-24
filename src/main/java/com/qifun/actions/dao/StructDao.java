package com.qifun.actions.dao;

import java.util.List;

import com.qifun.actions.model.StructInfoModel;
import com.qifun.actions.model.StructModel;

public interface StructDao {
	public List<StructModel> getStructList();

	public List<StructInfoModel> getStructInfoList(String tableName);
}
