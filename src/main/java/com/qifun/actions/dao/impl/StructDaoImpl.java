package com.qifun.actions.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qifun.actions.dao.StructDao;
import com.qifun.actions.model.StructInfoModel;
import com.qifun.actions.model.StructModel;
import com.qifun.actions.utils.DataSource;

public class StructDaoImpl implements StructDao {

	static Logger log = LoggerFactory.getLogger(StructDaoImpl.class);

	public List<StructModel> getStructList() {
		List<StructModel> structList = new ArrayList<StructModel>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DataSource.getInstance().getConnection();
			ps = conn.prepareStatement("select * from t_struct");
			rs = ps.executeQuery();
			while (rs.next()) {
				StructModel structModel = new StructModel();
				structModel.setTableName(rs.getString("vTableName"));
				structModel.setId(rs.getString("vId"));
				structModel.setDesc(rs.getString("vDesc"));
				structModel.setStructInfoModelList(new ArrayList<StructInfoModel>());
				structList.add(structModel);
			}
		} catch (Exception e) {
			log.error("getStructList Exception : " + e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
					log.error("getStructList Exception : " + e2.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					log.error("getStructList Exception : " + e2.getMessage());
				}
			}
		}
		return structList;
	}

	public List<StructInfoModel> getStructInfoList(String tableName) {
		List<StructInfoModel> structInfoModelList = new ArrayList<StructInfoModel>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DataSource.getInstance().getConnection();
			ps = conn
					.prepareStatement("select * from t_struct_info where vTableName = ?");
			ps.setString(1, tableName);
			rs = ps.executeQuery();
			while (rs.next()) {
				StructInfoModel structInfoModel = new StructInfoModel();
				structInfoModel.setId(String.valueOf(rs.getInt("id")));
				structInfoModel.setTableName(rs.getString("vTableName"));
				structInfoModel.setColumnName(rs.getString("vColumnName"));
				structInfoModel.setType(rs.getString("vType"));
				structInfoModel.setSize(rs.getString("vSize"));
				structInfoModel.setKey(rs.getString("vKey"));
				structInfoModel.setDesc(rs.getString("vDesc"));
				structInfoModelList.add(structInfoModel);
			}
		} catch (Exception e) {
			log.error("getStructInfoList Exception : " + e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
					log.error("getStructInfoList Exception : "
							+ e2.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					log.error("getStructInfoList Exception : "
							+ e2.getMessage());
				}
			}
		}
		return structInfoModelList;
	}
}
