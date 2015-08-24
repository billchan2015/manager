package com.qifun.actions.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qifun.actions.dao.StructDao;
import com.qifun.actions.dao.impl.StructDaoImpl;
import com.qifun.actions.model.StructInfoModel;
import com.qifun.actions.model.StructModel;
import com.qifun.actions.service.StructService;

public class StructServiceImpl implements StructService {

	static Logger log = LoggerFactory.getLogger(StructServiceImpl.class);

	public Map<String, StructModel> getStructMap() {
		Map<String, StructModel> structMap = new HashMap<String, StructModel>();
		try {
			StructDao structDao = new StructDaoImpl();
			List<StructModel> structList = structDao.getStructList();
			for(StructModel structModel : structList){
				List<StructInfoModel> structInfoList = structDao
						.getStructInfoList(structModel.getTableName());
				structModel.setStructInfoModelList(structInfoList);
				structMap.put(structModel.getTableName(), structModel);
			}
		} catch (Exception e) {
			log.error("StructServiceImpl getStructMap Exception : " + e.getMessage());
		}
		return structMap;
	}
}
