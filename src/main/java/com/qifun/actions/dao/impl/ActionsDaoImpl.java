package com.qifun.actions.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qifun.actions.dao.ActionsDao;
import com.qifun.actions.model.ActionModel;
import com.qifun.actions.model.FinalModel;
import com.qifun.actions.model.SQLModel;
import com.qifun.actions.model.TableModel;
import com.qifun.actions.model.TemplateModel;
import com.qifun.actions.utils.DataSource;

public class ActionsDaoImpl implements ActionsDao {

	static Logger log = LoggerFactory.getLogger(ActionsDaoImpl.class);

	public boolean checkUser(String username, String pwd) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			String passwd = null;
			conn = DataSource.getInstance().getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT passwd FROM t_user where username = '"
					+ username + "'");
			while (rs.next()) {
				passwd = rs.getString("passwd");
			}
			if (passwd != null && pwd.equals(passwd)) {
				result = true;
			}
		} catch (Exception e) {
			log.error("checkUser Exception : " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					log.error("checkUser Exception : " + e2.getMessage());
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception e2) {
					log.error("checkUser Exception : " + e2.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					log.error("checkUser Exception : " + e2.getMessage());
				}
			}
		}

		return result;
	}

	public List<ActionModel> getActions() {
		List<ActionModel> actionList = new ArrayList<ActionModel>();

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DataSource.getInstance().getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM t_action_info");
			while (rs.next()) {
				ActionModel actionModel = new ActionModel();
				String actionName = rs.getString("vActionName");
				actionModel.setActionNme(actionName);
				actionModel.setPeriod(rs.getString("iPeriod"));
				actionModel.setStep(rs.getString("iStep"));
				actionModel.setGameId(rs.getString("iGameId"));
				actionModel.setWorldId(rs.getString("iWorldId"));
				actionModel.setAccountType(rs.getString("iAccountType"));

				putFinalIntoList(conn, actionModel, actionName);
				putTableIntoList(conn, actionModel, actionName);
				putSqlIntoList(conn, actionModel, actionName);
				actionList.add(actionModel);
			}
		} catch (Exception e) {
			log.error("getActions Exception : " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					log.error("getActions Exception : " + e2.getMessage());
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception e2) {
					log.error("getActions Exception : " + e2.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					log.error("getActions Exception : " + e2.getMessage());
				}
			}
		}

		return actionList;
	}

	private static void putFinalIntoList(Connection connection,
			ActionModel actionModel, String actionName) {
		Statement st = null;
		ResultSet fianlResultSet = null;
		try {
			st = connection.createStatement();
			fianlResultSet = st
					.executeQuery("SELECT * FROM t_action_final WHERE vActionName = '"
							+ actionName + "'" + " ORDER BY iExeOrder asc");
			List<FinalModel> tmp_Final = new ArrayList<FinalModel>();
			while (fianlResultSet.next()) {
				FinalModel finalModel = new FinalModel();
				finalModel.setId(fianlResultSet.getInt("id"));
				finalModel.setActionName(actionName);
				finalModel.setExeOrder(fianlResultSet.getInt("iExeOrder"));
				finalModel.setUrl(fianlResultSet.getString("vURL"));
				finalModel.setFinalTable(fianlResultSet
						.getString("vFinalTable"));
				finalModel.setFinalSql(fianlResultSet.getString("vFinalSql"));
				tmp_Final.add(finalModel);
			}
			actionModel.setFinalList(tmp_Final);
		} catch (Exception e) {
			log.error("putFinalIntoList Exception : " + e.getMessage());
		} finally {
			if (fianlResultSet != null) {
				try {
					fianlResultSet.close();
				} catch (Exception e2) {
					log.error("putFinalIntoList Exception : " + e2.getMessage());
				}
			}
		}
	}

	private static void putTableIntoList(Connection connection,
			ActionModel actionModel, String actionName) {
		Statement st = null;
		ResultSet tableResultSet = null;
		try {
			st = connection.createStatement();
			tableResultSet = st
					.executeQuery("SELECT * FROM t_action_table WHERE vActionName = '"
							+ actionName + "'" + " ORDER BY iExeOrder asc");
			List<TableModel> tmp_Table = new ArrayList<TableModel>();
			while (tableResultSet.next()) {
				TableModel tableModel = new TableModel();
				tableModel.setId(tableResultSet.getInt("id"));
				tableModel.setExeOrder(tableResultSet.getInt("iExeOrder"));
				tableModel.setActionName(actionName);
				tableModel.setActionTable(tableResultSet
						.getString("vActionTable"));
				tmp_Table.add(tableModel);
			}
			actionModel.setTableList(tmp_Table);
		} catch (Exception e) {
			log.error("putTableIntoList Exception : " + e.getMessage());
		} finally {
			if (tableResultSet != null) {
				try {
					tableResultSet.close();
				} catch (Exception e2) {
					log.error("putTableIntoList Exception : " + e2.getMessage());
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception e2) {
					log.error("putTableIntoList Exception : " + e2.getMessage());
				}
			}
		}
	}

	private static void putSqlIntoList(Connection connection,
			ActionModel actionModel, String actionName) {
		Statement st = null;
		ResultSet sqlResultSet = null;
		try {
			st = connection.createStatement();
			sqlResultSet = st
					.executeQuery("SELECT * FROM t_action_sql WHERE vActionName = '"
							+ actionName + "'" + " ORDER BY iExeOrder asc");
			List<SQLModel> tmp_Sql = new ArrayList<SQLModel>();
			while (sqlResultSet.next()) {
				SQLModel sqlModel = new SQLModel();
				sqlModel.setId(sqlResultSet.getInt("id"));
				sqlModel.setActionName(actionName);
				sqlModel.setExeOrder(sqlResultSet.getInt("iExeOrder"));
				sqlModel.setTempTable(sqlResultSet.getString("vTempTable"));
				sqlModel.setActionSql(sqlResultSet.getString("vActionSql"));
				tmp_Sql.add(sqlModel);
			}
			actionModel.setSqlList(tmp_Sql);
		} catch (Exception e) {
			log.error("putSqlIntoList Exception : " + e.getMessage());
		} finally {
			if (sqlResultSet != null) {
				try {
					sqlResultSet.close();
				} catch (Exception e2) {
					log.error("putSqlIntoList Exception : " + e2.getMessage());
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception e2) {
					log.error("putSqlIntoList Exception : " + e2.getMessage());
				}
			}
		}
	}

	public List<ActionModel> getActionsInfo() {
		List<ActionModel> actionList = new ArrayList<ActionModel>();

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DataSource.getInstance().getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM t_action_info");
			while (rs.next()) {
				ActionModel actionModel = new ActionModel();
				String actionName = rs.getString("vActionName");
				actionModel.setActionNme(actionName);
				actionModel.setPeriod(rs.getString("iPeriod"));
				actionModel.setStep(rs.getString("iStep"));
				actionModel.setGameId(rs.getString("iGameId"));
				actionModel.setWorldId(rs.getString("iWorldId"));
				actionModel.setAccountType(rs.getString("iAccountType"));

				List<FinalModel> tmp_Final = new ArrayList<FinalModel>();
				actionModel.setFinalList(tmp_Final);
				List<TableModel> tmp_Table = new ArrayList<TableModel>();
				actionModel.setTableList(tmp_Table);
				List<SQLModel> tmp_Sql = new ArrayList<SQLModel>();
				actionModel.setSqlList(tmp_Sql);
				actionList.add(actionModel);
			}
		} catch (Exception e) {
			log.error("getActionsInfo Exception : ", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					log.error("getActionsInfo Exception : ", e2);
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception e2) {
					log.error("getActionsInfo Exception : ", e2);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					log.error("getActionsInfo Exception : ", e2);
				}
			}
		}

		return actionList;
	}

	public List<ActionModel> getActionsInfoByName(String actionName) {

		List<ActionModel> actionList = new ArrayList<ActionModel>();

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DataSource.getInstance().getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM t_action_info WHERE vActionName = '"
					+ actionName + "'");
			while (rs.next()) {
				ActionModel actionModel = new ActionModel();
				actionModel.setActionNme(rs.getString("vActionName"));
				actionModel.setPeriod(rs.getString("iPeriod"));
				actionModel.setStep(rs.getString("iStep"));
				actionModel.setGameId(rs.getString("iGameId"));
				actionModel.setWorldId(rs.getString("iWorldId"));
				actionModel.setAccountType(rs.getString("iAccountType"));

				putFinalIntoList(conn, actionModel, actionName);
				putTableIntoList(conn, actionModel, actionName);
				putSqlIntoList(conn, actionModel, actionName);
				actionList.add(actionModel);
			}
		} catch (Exception e) {
			log.error("getActionsInfoByName Exception : " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					log.error("getActionsInfoByName Exception : "
							+ e2.getMessage());
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception e2) {
					log.error("getActionsInfoByName Exception : "
							+ e2.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					log.error("getActionsInfoByName Exception : "
							+ e2.getMessage());
				}
			}
		}

		return actionList;

	}

	public boolean mofifyActionsInfo(String actionNme, String period,
			String step, String gameId, String worldId, String accountType) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = -1;
		try {
			conn = DataSource.getInstance().getConnection();
			ps = conn
					.prepareStatement("UPDATE t_action_info SET iPeriod = ?,iStep=?,iGameId=?,iWorldId=?,iAccountType=? WHERE vActionName=?");
			ps.setString(1, period);
			ps.setString(2, step);
			ps.setString(3, gameId);
			ps.setString(4, worldId);
			ps.setString(5, accountType);
			ps.setString(6, actionNme);
			rs = ps.executeUpdate();
			// st = conn.createStatement();
			// rs = st.executeUpdate("UPDATE t_action_info SET iPeriod = '"
			// + period + "',iStep='" + step + "',iGameId='" + gameId
			// + "',iWorldId='" + worldId + "',iAccountType='"
			// + accountType + "'WHERE vActionName='" + actionNme + "'");
			if (rs > 0) {
				result = true;
			}
		} catch (Exception e) {
			log.error("mofifyActionsInfo Exception : " + e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
					log.error("mofifyActionsInfo Exception : "
							+ e2.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					log.error("mofifyActionsInfo Exception : "
							+ e2.getMessage());
				}
			}
		}
		return result;
	}

	public boolean modifySql(String sqlId, String sqlExeOrder,
			String sqltempTable, String sqlActionSql) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = -1;
		try {
			conn = DataSource.getInstance().getConnection();
			ps = conn
					.prepareStatement("UPDATE t_action_sql SET iExeOrder = ?,vTempTable=?,vActionSql=?WHERE id=?");
			ps.setInt(1, Integer.parseInt(sqlExeOrder));
			ps.setString(2, sqltempTable);
			ps.setString(3, sqlActionSql);
			ps.setInt(4, Integer.parseInt(sqlId));
			rs = ps.executeUpdate();
			
			// st = conn.createStatement();
			// rs = st.executeUpdate("UPDATE t_action_sql SET iExeOrder = "
			// + Integer.parseInt(sqlExeOrder) + ",vTempTable='"
			// + sqltempTable + "',vActionSql='" + sqlActionSql
			// + "'WHERE id=" + Integer.parseInt(sqlId));
			if (rs > 0) {
				result = true;
			}
		} catch (Exception e) {
			log.error("modifySql Exception : " + e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
					log.error("modifySql Exception : " + e2.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					log.error("modifySql Exception : " + e2.getMessage());
				}
			}
		}
		return result;
	}

	public boolean modifytb(String tbId, String tbExeOrder, String tbActionTable) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = -1;
		try {
			conn = DataSource.getInstance().getConnection();
			ps = conn
					.prepareStatement("UPDATE t_action_table SET iExeOrder = ?,vActionTable=?WHERE id=?");
			ps.setInt(1, Integer.parseInt(tbExeOrder));
			ps.setString(2, tbActionTable);
			ps.setInt(3, Integer.parseInt(tbId));
			rs = ps.executeUpdate();
			// st = conn.createStatement();
			// rs = st.executeUpdate("UPDATE t_action_table SET iExeOrder = "
			// + Integer.parseInt(tbExeOrder) + ",vActionTable='"
			// + tbActionTable + "'WHERE id=" + Integer.parseInt(tbId));
			if (rs > 0) {
				result = true;
			}
		} catch (Exception e) {
			log.error("modifytb Exception : " + e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
					log.error("modifytb Exception : " + e2.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					log.error("modifytb Exception : " + e2.getMessage());
				}
			}
		}
		return result;
	}

	public boolean modifyfinal(String finalId, String finalExeOrder,
			String finalURL, String finalFinalTable, String finalFinalSql) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = -1;
		try {
			conn = DataSource.getInstance().getConnection();
			ps = conn
					.prepareStatement("UPDATE t_action_final SET iExeOrder = ?,vURL= ?,vFinalTable= ?,vFinalSql= ? WHERE id= ?");
			ps.setInt(1, Integer.parseInt(finalExeOrder));
			ps.setString(2, finalURL);
			ps.setString(3, finalFinalTable);
			ps.setString(4, finalFinalSql);
			ps.setInt(5, Integer.parseInt(finalId));
			rs = ps.executeUpdate();

			// st = conn.createStatement();
			// rs = st.executeUpdate("UPDATE t_action_final SET iExeOrder = "
			// + Integer.parseInt(finalExeOrder) + ",vURL='" + finalURL
			// + "',vFinalTable='" + finalFinalTable + "',vFinalSql='"
			// + finalFinalSql + "'WHERE id=" + Integer.parseInt(finalId));
			if (rs > 0) {
				result = true;
			}
		} catch (Exception e) {
			log.error("modifyfinal Exception : " + e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
					log.error("modifyfinal Exception : " + e2.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					log.error("modifyfinal Exception : " + e2.getMessage());
				}
			}
		}
		return result;
	}

	public boolean delaction(String actionName) {
		boolean result = false;
		Connection conn = null;
		Statement st = null;
		int rs = -1;
		try {
			conn = DataSource.getInstance().getConnection();
			st = conn.createStatement();
			rs = st.executeUpdate("DELETE FROM t_action_info WHERE vActionName = '"
					+ actionName + "'");
			if (rs > 0) {
				result = true;
			}
		} catch (Exception e) {
			log.error("delaction Exception : " + e.getMessage());
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (Exception e2) {
					log.error("delaction Exception : " + e2.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					log.error("delaction Exception : " + e2.getMessage());
				}
			}
		}
		return result;
	}

	public boolean delsql(String sqlId) {
		boolean result = false;
		Connection conn = null;
		Statement st = null;
		int rs = -1;
		try {
			conn = DataSource.getInstance().getConnection();
			st = conn.createStatement();
			rs = st.executeUpdate("DELETE FROM t_action_sql WHERE id = "
					+ sqlId);
			if (rs > 0) {
				result = true;
			}
		} catch (Exception e) {
			log.error("delsql Exception : " + e.getMessage());
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (Exception e2) {
					log.error("delsql Exception : " + e2.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					log.error("delsql Exception : " + e2.getMessage());
				}
			}
		}
		return result;
	}

	public boolean deltb(String tbId) {
		boolean result = false;
		Connection conn = null;
		Statement st = null;
		int rs = -1;
		try {
			conn = DataSource.getInstance().getConnection();
			st = conn.createStatement();
			rs = st.executeUpdate("DELETE FROM t_action_table WHERE id = "
					+ tbId);
			if (rs > 0) {
				result = true;
			}
		} catch (Exception e) {
			log.error("deltb Exception : " + e.getMessage());
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (Exception e2) {
					log.error("deltb Exception : " + e2.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					log.error("deltb Exception : " + e2.getMessage());
				}
			}
		}
		return result;
	}

	public boolean delfinal(String finalId) {
		boolean result = false;
		Connection conn = null;
		Statement st = null;
		int rs = -1;
		try {
			conn = DataSource.getInstance().getConnection();
			st = conn.createStatement();
			rs = st.executeUpdate("DELETE FROM t_action_final WHERE id = "
					+ finalId);
			if (rs > 0) {
				result = true;
			}
		} catch (Exception e) {
			log.error("delfinal Exception : " + e.getMessage());
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (Exception e2) {
					log.error("delfinal Exception : " + e2.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					log.error("delfinal Exception : " + e2.getMessage());
				}
			}
		}
		return result;
	}

	public boolean addaction(String actionName, String addperiod,
			String addstep, String addgameId, String addworldId,
			String addaccountType) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = -1;
		try {
			conn = DataSource.getInstance().getConnection();
			ps = conn
					.prepareStatement("INSERT INTO t_action_info(vActionName,iPeriod,iStep,iGameId,iWorldId,iAccountType)VALUES(?,?,?,?,?,?)");
			ps.setString(1, actionName);
			ps.setString(2, addperiod);
			ps.setString(3, addstep);
			ps.setString(4, addgameId);
			ps.setString(5, addworldId);
			ps.setString(6, addaccountType);
			rs = ps.executeUpdate();
			// st = conn.createStatement();
			// rs =
			// st.executeUpdate("INSERT INTO t_action_info(vActionName,iPeriod,iStep,iGameId,iWorldId,iAccountType)VALUES('"
			// + actionName
			// + "','"
			// + addperiod
			// + "','"
			// + addstep
			// + "','"
			// + addgameId
			// + "','"
			// + addworldId
			// + "','"
			// + addaccountType
			// + "')");
			if (rs > 0) {
				result = true;
			}
		} catch (Exception e) {
			log.error("addaction Exception : " + e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
					log.error("addaction Exception : " + e2.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					log.error("addaction Exception : " + e2.getMessage());
				}
			}
		}
		return result;
	}

	public boolean addsql(String actionName, String addsqlExeOrder,
			String addsqltempTable, String addsqlActionSql) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = -1;
		try {
			conn = DataSource.getInstance().getConnection();
			ps = conn
					.prepareStatement("INSERT INTO t_action_sql(vActionName,iExeOrder,vTempTable,vActionSql)VALUES(?,?,?,?)");
			ps.setString(1, actionName);
			ps.setInt(2, Integer.parseInt(addsqlExeOrder));
			ps.setString(3, addsqltempTable);
			ps.setString(4, addsqlActionSql);
			rs = ps.executeUpdate();
			// st = conn.createStatement();
			// rs =
			// st.executeUpdate("INSERT INTO t_action_sql(vActionName,iExeOrder,vTempTable,vActionSql)VALUES('"
			// + actionName
			// + "',"
			// + Integer.parseInt(addsqlExeOrder)
			// + ",'" + addsqltempTable + "','" + addsqlActionSql + "')");
			if (rs > 0) {
				result = true;
			}
		} catch (Exception e) {
			log.error("addsql Exception : " + e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
					log.error("addsql Exception : " + e2.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					log.error("addsql Exception : " + e2.getMessage());
				}
			}
		}
		return result;
	}

	public boolean addtb(String actionName, String addtbexeOrder,
			String addtbactionTable) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = -1;
		try {
			conn = DataSource.getInstance().getConnection();
			ps = conn
					.prepareStatement("INSERT INTO t_action_table(iExeOrder,vActionName,vActionTable)VALUES(?,?,?)");
			ps.setInt(1, Integer.parseInt(addtbexeOrder));
			ps.setString(2, actionName);
			ps.setString(3, addtbactionTable);
			rs = ps.executeUpdate();
			// st = conn.createStatement();
			// rs =
			// st.executeUpdate("INSERT INTO t_action_table(iExeOrder,vActionName,vActionTable)VALUES("
			// + Integer.parseInt(addtbexeOrder)
			// + ",'"
			// + actionName
			// + "','" + addtbactionTable + "')");
			if (rs > 0) {
				result = true;
			}
		} catch (Exception e) {
			log.error("addtb Exception : " + e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
					log.error("addtb Exception : " + e2.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					log.error("addtb Exception : " + e2.getMessage());
				}
			}
		}
		return result;
	}

	public boolean addfinal(String actionName, String addfinalexeOrder,
			String addfinalurl, String addfinalfinalTable,
			String addfinalfinalSql) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = -1;
		try {
			conn = DataSource.getInstance().getConnection();
			ps = conn
					.prepareStatement("INSERT INTO t_action_final(vActionName,iExeOrder,vURL,vFinalTable,vFinalSql)VALUES(?,?,?,?,?)");
			ps.setString(1, actionName);
			ps.setInt(2, Integer.parseInt(addfinalexeOrder));
			ps.setString(3, addfinalurl);
			ps.setString(4, addfinalfinalTable);
			ps.setString(5, addfinalfinalSql);
			rs = ps.executeUpdate();
			// st = conn.createStatement();
			// rs =
			// st.executeUpdate("INSERT INTO t_action_final(vActionName,iExeOrder,vURL,vFinalTable,vFinalSql)VALUES('"
			// + actionName
			// + "',"
			// + Integer.parseInt(addfinalexeOrder)
			// + ",'"
			// + addfinalurl
			// + "','"
			// + addfinalfinalTable
			// + "','"
			// + addfinalfinalSql + "')");
			if (rs > 0) {
				result = true;
			}
		} catch (Exception e) {
			log.error("addfinal Exception : " + e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
					log.error("addfinal Exception : " + e2.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					log.error("addfinal Exception : " + e2.getMessage());
				}
			}
		}
		return result;
	}

	public List<TemplateModel> getTemplates() {
		List<TemplateModel> templateList = new ArrayList<TemplateModel>();

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DataSource.getInstance().getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM t_template_info");
			while (rs.next()) {
				TemplateModel templateModel = new TemplateModel();
				templateModel.setId(rs.getString("id"));
				templateModel.setPeriod(rs.getString("iPeriod"));
				templateModel.setStep(rs.getString("iStep"));
				templateModel.setGameId(rs.getString("iGameId"));
				templateModel.setWorldId(rs.getString("iWorldId"));
				templateModel.setAccountType(rs.getString("iAccountType"));
				templateList.add(templateModel);
			}
		} catch (Exception e) {
			log.error("getTemplateModels Exception : ", e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					log.error("getTemplateModels Exception : ", e2);
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception e2) {
					log.error("getTemplateModels Exception : ", e2);
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					log.error("getTemplateModels Exception : ", e2);
				}
			}
		}

		return templateList;
	}

	public boolean addTemplate(String addperiod, String addstep,
			String addgameId, String addworldId, String addaccountType) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = -1;
		try {
			conn = DataSource.getInstance().getConnection();
			ps = conn.prepareStatement("INSERT INTO t_template_info(iPeriod,iStep,iGameId,iWorldId,iAccountType)VALUES(?,?,?,?,?)");
			ps.setString(1, addperiod);
			ps.setString(2, addstep);
			ps.setString(3, addgameId);
			ps.setString(4, addworldId);
			ps.setString(5, addaccountType);
			rs = ps.executeUpdate();
			if (rs > 0) {
				result = true;
			}
		} catch (Exception e) {
			log.error("addTemplate Exception : " + e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
					log.error("addTemplate Exception : " + e2.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					log.error("addTemplate Exception : " + e2.getMessage());
				}
			}
		}
		return result;
	}

	public boolean modifyTemplate(String templateId, String period,
			String step, String gameId, String worldId, String accountType) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = -1;
		try {
			conn = DataSource.getInstance().getConnection();
			ps = conn
					.prepareStatement("UPDATE t_template_info SET iPeriod = ?,iStep=?,iGameId=?,iWorldId=?,iAccountType=? WHERE id=?");
			ps.setString(1, period);
			ps.setString(2, step);
			ps.setString(3, gameId);
			ps.setString(4, worldId);
			ps.setString(5, accountType);
			ps.setString(6, templateId);
			rs = ps.executeUpdate();
			if (rs > 0) {
				result = true;
			}
		} catch (Exception e) {
			log.error("modifyTemplate Exception : " + e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
					log.error("modifyTemplate Exception : "
							+ e2.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					log.error("modifyTemplate Exception : "
							+ e2.getMessage());
				}
			}
		}
		return result;
	}

	public boolean delTemplate(String templateId) {
		boolean result = false;
		Connection conn = null;
		Statement st = null;
		int rs = -1;
		try {
			conn = DataSource.getInstance().getConnection();
			st = conn.createStatement();
			rs = st.executeUpdate("DELETE FROM t_template_info WHERE id = "
					+ templateId);
			if (rs > 0) {
				result = true;
			}
		} catch (Exception e) {
			log.error("delTemplate Exception : " + e.getMessage());
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (Exception e2) {
					log.error("delTemplate Exception : " + e2.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					log.error("delTemplate Exception : " + e2.getMessage());
				}
			}
		}
		return result;
	}
}
