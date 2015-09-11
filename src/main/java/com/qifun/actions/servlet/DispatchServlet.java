package com.qifun.actions.servlet;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.opensymphony.xwork2.ActionSupport;
import com.qifun.actions.dao.ActionsDao;
import com.qifun.actions.dao.impl.ActionsDaoImpl;
import com.qifun.actions.model.ActionModel;
import com.qifun.actions.model.FinalModel;
import com.qifun.actions.model.SQLModel;
import com.qifun.actions.model.TableModel;
import com.qifun.actions.model.TemplateModel;
import com.qifun.actions.utils.DataSource;

public class DispatchServlet extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Logger log = LoggerFactory.getLogger(DispatchServlet.class);

	private String actonSelect;
	private List<ActionModel> actionList;
	private List<ActionModel> actionNameList;
	private List<TemplateModel> templateList;
	
	private List<SQLModel> addSqlList;
	public List<SQLModel> getAddSqlList() {
		return addSqlList;
	}
	public void setAddSqlList(List<SQLModel> addSqlList) {
		this.addSqlList = addSqlList;
	}
	
	private List<SQLModel> modifySqlList;
	public List<SQLModel> getModifySqlList() {
		return modifySqlList;
	}
	public void setModifySqlList(List<SQLModel> modifySqlList) {
		this.modifySqlList = modifySqlList;
	}
	
	private List<TableModel> addTbList;
	public List<TableModel> getAddTbList() {
		return addTbList;
	}
	public void setAddTbList(List<TableModel> addTbList) {
		this.addTbList = addTbList;
	}
	private List<TableModel> modifyTbList;
	public List<TableModel> getModifyTbList() {
		return modifyTbList;
	}
	public void setModifyTbList(List<TableModel> modifyTbList) {
		this.modifyTbList = modifyTbList;
	}
	
	private List<FinalModel> addFinalList;
	public List<FinalModel> getAddFinalList() {
		return addFinalList;
	}
	public void setAddFinalList(List<FinalModel> addFinalList) {
		this.addFinalList = addFinalList;
	}
	private List<FinalModel> modifyFinalList;
	public List<FinalModel> getModifyFinalList() {
		return modifyFinalList;
	}
	public void setModifyFinalList(List<FinalModel> modifyFinalList) {
		this.modifyFinalList = modifyFinalList;
	}

	private String actionNme;
	private String period;
	private String step;
	private String gameId;
	private String worldId;
	private String accountType;

	private String sqlId;
	private String sqlExeOrder;
	private String sqltempTable;
	private String sqlActionSql;

	private String tbId;
	private String tbExeOrder;
	private String tbActionTable;

	private String finalId;
	private String finalExeOrder;
	private String finalURL;
	private String finalFinalTable;
	private String finalFinalSql;

	private String delActionNme;
	private String delsqlid;
	private String deltbid;
	private String delfinalid;

	private String addName;
	private String addPeriod;
	private String addStep;
	private String addGameId;
	private String addWorldId;
	private String addAccountType;

	private String addsqlExeOrder;
	private String addsqltempTable;
	private String addsqlActionSql;

	private String addtbexeOrder;
	private String addtbactionTable;

	private String addfinalexeOrder;
	private String addfinalurl;
	private String addfinalfinalTable;
	private String addfinalfinalSql;
	
	private String templateId;
	private String isTemplate;

	public String getIsTemplate() {
		return isTemplate;
	}

	public void setIsTemplate(String isTemplate) {
		this.isTemplate = isTemplate;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public List<TemplateModel> getTemplateList() {
		return templateList;
	}

	public void setTemplateList(List<TemplateModel> templateList) {
		this.templateList = templateList;
	}

	public String getAddfinalexeOrder() {
		return addfinalexeOrder;
	}

	public void setAddfinalexeOrder(String addfinalexeOrder) {
		this.addfinalexeOrder = addfinalexeOrder;
	}

	public String getAddfinalurl() {
		return addfinalurl;
	}

	public void setAddfinalurl(String addfinalurl) {
		this.addfinalurl = addfinalurl;
	}

	public String getAddfinalfinalTable() {
		return addfinalfinalTable;
	}

	public void setAddfinalfinalTable(String addfinalfinalTable) {
		this.addfinalfinalTable = addfinalfinalTable;
	}

	public String getAddfinalfinalSql() {
		return addfinalfinalSql;
	}

	public void setAddfinalfinalSql(String addfinalfinalSql) {
		this.addfinalfinalSql = addfinalfinalSql;
	}

	public String getAddtbexeOrder() {
		return addtbexeOrder;
	}

	public void setAddtbexeOrder(String addtbexeOrder) {
		this.addtbexeOrder = addtbexeOrder;
	}

	public String getAddtbactionTable() {
		return addtbactionTable;
	}

	public void setAddtbactionTable(String addtbactionTable) {
		this.addtbactionTable = addtbactionTable;
	}

	public String getAddsqlExeOrder() {
		return addsqlExeOrder;
	}

	public void setAddsqlExeOrder(String addsqlExeOrder) {
		this.addsqlExeOrder = addsqlExeOrder;
	}

	public String getAddsqltempTable() {
		return addsqltempTable;
	}

	public void setAddsqltempTable(String addsqltempTable) {
		this.addsqltempTable = addsqltempTable;
	}

	public String getAddsqlActionSql() {
		return addsqlActionSql;
	}

	public void setAddsqlActionSql(String addsqlActionSql) {
		this.addsqlActionSql = addsqlActionSql;
	}

	private String currentactionname;

	public String getCurrentactionname() {
		return currentactionname;
	}

	public void setCurrentactionname(String currentactionname) {
		this.currentactionname = currentactionname;
	}

	public String getAddName() {
		return addName;
	}

	public void setAddName(String addName) {
		this.addName = addName;
	}

	public String getAddPeriod() {
		return addPeriod;
	}

	public void setAddPeriod(String addPeriod) {
		this.addPeriod = addPeriod;
	}

	public String getAddStep() {
		return addStep;
	}

	public void setAddStep(String addStep) {
		this.addStep = addStep;
	}

	public String getAddGameId() {
		return addGameId;
	}

	public void setAddGameId(String addGameId) {
		this.addGameId = addGameId;
	}

	public String getAddWorldId() {
		return addWorldId;
	}

	public void setAddWorldId(String addWorldId) {
		this.addWorldId = addWorldId;
	}

	public String getAddAccountType() {
		return addAccountType;
	}

	public void setAddAccountType(String addAccountType) {
		this.addAccountType = addAccountType;
	}

	public String getDelActionNme() {
		return delActionNme;
	}

	public void setDelActionNme(String delActionNme) {
		this.delActionNme = delActionNme;
	}

	public String getDelsqlid() {
		return delsqlid;
	}

	public void setDelsqlid(String delsqlid) {
		this.delsqlid = delsqlid;
	}

	public String getDeltbid() {
		return deltbid;
	}

	public void setDeltbid(String deltbid) {
		this.deltbid = deltbid;
	}

	public String getDelfinalid() {
		return delfinalid;
	}

	public void setDelfinalid(String delfinalid) {
		this.delfinalid = delfinalid;
	}

	public String getFinalId() {
		return finalId;
	}

	public void setFinalId(String finalId) {
		this.finalId = finalId;
	}

	public String getFinalExeOrder() {
		return finalExeOrder;
	}

	public void setFinalExeOrder(String finalExeOrder) {
		this.finalExeOrder = finalExeOrder;
	}

	public String getFinalURL() {
		return finalURL;
	}

	public void setFinalURL(String finalURL) {
		this.finalURL = finalURL;
	}

	public String getFinalFinalTable() {
		return finalFinalTable;
	}

	public void setFinalFinalTable(String finalFinalTable) {
		this.finalFinalTable = finalFinalTable;
	}

	public String getFinalFinalSql() {
		return finalFinalSql;
	}

	public void setFinalFinalSql(String finalFinalSql) {
		this.finalFinalSql = finalFinalSql;
	}

	public String getTbId() {
		return tbId;
	}

	public void setTbId(String tbId) {
		this.tbId = tbId;
	}

	public String getTbExeOrder() {
		return tbExeOrder;
	}

	public void setTbExeOrder(String tbExeOrder) {
		this.tbExeOrder = tbExeOrder;
	}

	public String getTbActionTable() {
		return tbActionTable;
	}

	public void setTbActionTable(String tbActionTable) {
		this.tbActionTable = tbActionTable;
	}

	public String getSqlId() {
		return sqlId;
	}

	public void setSqlId(String sqlId) {
		this.sqlId = sqlId;
	}

	public String getSqlExeOrder() {
		return sqlExeOrder;
	}

	public void setSqlExeOrder(String sqlExeOrder) {
		this.sqlExeOrder = sqlExeOrder;
	}

	public String getSqltempTable() {
		return sqltempTable;
	}

	public void setSqltempTable(String sqltempTable) {
		this.sqltempTable = sqltempTable;
	}

	public String getSqlActionSql() {
		return sqlActionSql;
	}

	public void setSqlActionSql(String sqlActionSql) {
		this.sqlActionSql = sqlActionSql;
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

	public String getActionNme() {
		return actionNme;
	}

	public void setActionNme(String actionNme) {
		this.actionNme = actionNme;
	}

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

	public String getActonSelect() {
		return actonSelect;
	}

	public void setActonSelect(String actonSelect) {
		this.actonSelect = actonSelect;
	}

	public String queryaction() {
		ActionsDao actionsDao = new ActionsDaoImpl();
		currentactionname = actonSelect;
		actionList = actionsDao.getActionsInfoByName(actonSelect);
		if (null != actionList && actionList.size() > 0) {
			actionNameList = actionsDao.getActionsInfo();
			return "success";
		}
		return "false";
	}

	public String modifyaction() {
		ActionsDao actionsDao = new ActionsDaoImpl();
		if (actionsDao.mofifyActionsInfo(actionNme, period, step, gameId,
				worldId, accountType)) {
			actionNameList = actionsDao.getActionsInfo();
			actionList = actionsDao.getActionsInfoByName(actionNme);
			return "success";
		}
		return "false";
	}

	public String modifySql() {
		ActionsDao actionsDao = new ActionsDaoImpl();
		if (actionsDao
				.modifySql(sqlId, sqlExeOrder, sqltempTable, sqlActionSql)) {
			actionNameList = actionsDao.getActionsInfo();
			actionList = actionsDao.getActionsInfoByName(currentactionname);
			return "success";
		}
		return "false";
	}

	public String modifytb() {
		ActionsDao actionsDao = new ActionsDaoImpl();
		if (actionsDao.modifytb(tbId, tbExeOrder, tbActionTable)) {
			actionNameList = actionsDao.getActionsInfo();
			actionList = actionsDao.getActionsInfoByName(currentactionname);
			return "success";
		}
		return "false";
	}

	public String modifyfinal() {
		ActionsDao actionsDao = new ActionsDaoImpl();
		if (actionsDao.modifyfinal(finalId, finalExeOrder, finalURL,
				finalFinalTable, finalFinalSql)) {
			actionNameList = actionsDao.getActionsInfo();
			actionList = actionsDao.getActionsInfoByName(currentactionname);
			return "success";
		}
		return "false";
	}

	public String delaction() {
		ActionsDao actionsDao = new ActionsDaoImpl();
		if (actionsDao.delaction(delActionNme)) {
			actionNameList = actionsDao.getActionsInfo();
			actionList = new ArrayList<ActionModel>();
			return "success";
		}
		return "false";
	}

	public String delsql() {
		ActionsDao actionsDao = new ActionsDaoImpl();
		if (actionsDao.delsql(delsqlid)) {
			actionNameList = actionsDao.getActionsInfo();
			actionList = actionsDao.getActionsInfoByName(currentactionname);
			return "success";
		}
		return "false";
	}

	public String deltb() {
		ActionsDao actionsDao = new ActionsDaoImpl();
		if (actionsDao.deltb(deltbid)) {
			actionNameList = actionsDao.getActionsInfo();
			actionList = actionsDao.getActionsInfoByName(currentactionname);
			return "success";
		}
		return "false";
	}

	public String delfinal() {
		ActionsDao actionsDao = new ActionsDaoImpl();
		if (actionsDao.delfinal(delfinalid)) {
			actionNameList = actionsDao.getActionsInfo();
			actionList = actionsDao.getActionsInfoByName(currentactionname);
			return "success";
		}
		return "false";
	}

	public String addpage() {
		ActionsDao actionsDao = new ActionsDaoImpl();
		templateList = actionsDao.getTemplates();
		return "success";
	}

	public String addactionaction() {
		ActionsDao actionsDao = new ActionsDaoImpl();
		if(addName==null||"".equals(addName)){
			log.error("add actionname null!");
			return "false";
		}
		if (actionsDao.addaction(addName, addPeriod, addStep, addGameId,
				addWorldId, addAccountType)) {
			/**
			 * Ä£°æÌí¼Ó
			if("1".equals(isTemplate)){
				boolean add = actionsDao.addTemplate(addPeriod, addStep, addGameId,
						addWorldId, addAccountType);
				if(!add) return "false";
			}**/
			actionNameList = actionsDao.getActionsInfo();
			actionList = actionsDao.getActionsInfoByName(addName);
			return "success";
		}
		return "false";
	}

	public String addsql() {
		try {
			ActionsDao actionsDao = new ActionsDaoImpl();
			if(!(addSqlList==null||addSqlList.size()<=0)){
				for(SQLModel sqlModel:addSqlList){
					if(!actionsDao.addsql(currentactionname, String.valueOf(sqlModel.getExeOrder()),
							sqlModel.getTempTable(), sqlModel.getActionSql())){
						System.out.println(currentactionname +" addsql failed");
					}
				}
			}
			if(!(modifySqlList==null||modifySqlList.size()<=0)){
				for(SQLModel sqlModel:modifySqlList){
					if(!actionsDao.modifySql(String.valueOf(sqlModel.getId()), String.valueOf(sqlModel.getExeOrder()), sqlModel.getTempTable(), sqlModel.getActionSql())){
						System.out.println(currentactionname +" modifySql failed");
					}
				}
			}
			actionNameList = actionsDao.getActionsInfo();
			actionList = actionsDao.getActionsInfoByName(currentactionname);
			return "success";
		} catch (Exception e) {
			System.out.println(currentactionname +" Exception");
			e.printStackTrace();
			return "false";
		}
		
		
		/**
		if (actionsDao.addsql(currentactionname, addsqlExeOrder,
				addsqltempTable, addsqlActionSql)) {
			actionNameList = actionsDao.getActionsInfo();
			actionList = actionsDao.getActionsInfoByName(currentactionname);
			return "success";
		}
		return "false";
		**/
	}

	public String addtb() {
		try {
			ActionsDao actionsDao = new ActionsDaoImpl();
			if(!(addTbList==null||addTbList.size()<=0)){
				for(TableModel tableModel:addTbList){
					if(!actionsDao.addtb(currentactionname,String.valueOf(tableModel.getExeOrder()) ,tableModel.getActionTable())){
						System.out.println(currentactionname +" addtb failed!");
					}
				}
			}
			if(!(modifyTbList==null||modifyTbList.size()<=0)){
				for(TableModel tableModel:modifyTbList){
					if(!actionsDao.modifytb(String.valueOf(tableModel.getId()),String.valueOf(tableModel.getExeOrder()), tableModel.getActionTable())){
						System.out.println(currentactionname +" modifytb failed!");
					}
				}
			}
			actionNameList = actionsDao.getActionsInfo();
			actionList = actionsDao.getActionsInfoByName(currentactionname);
			return "success";
		} catch (Exception e) {
			System.out.println(currentactionname +" Exception");
			e.printStackTrace();
			return "false";
		}
		
		/**
		if (actionsDao
				.addtb(currentactionname, addtbexeOrder, addtbactionTable)) {
			actionNameList = actionsDao.getActionsInfo();
			actionList = actionsDao.getActionsInfoByName(currentactionname);
			return "success";
		}
		return "false";
		**/
	}

	public String addfinal() {
		try {
			ActionsDao actionsDao = new ActionsDaoImpl();
			if(!(addFinalList==null||addFinalList.size()<=0)){
				for(FinalModel finalModel:addFinalList){
					if(!actionsDao.addfinal(currentactionname, String.valueOf(finalModel.getExeOrder()), finalModel.getUrl(), finalModel.getFinalTable(), finalModel.getFinalSql())){
						System.out.println(currentactionname +" addfinal failed!");
					}
				}
			}
			if(!(modifyFinalList==null||modifyFinalList.size()<=0)){
				for(FinalModel finalModel:modifyFinalList){
					if(!actionsDao.modifyfinal(String.valueOf(finalModel.getId()), String.valueOf(finalModel.getExeOrder()), finalModel.getUrl(), finalModel.getFinalTable(), finalModel.getFinalSql())){
						System.out.println(currentactionname +" modifytb failed!");
					}
				}
			}
			actionNameList = actionsDao.getActionsInfo();
			actionList = actionsDao.getActionsInfoByName(currentactionname);
			return "success";
		} catch (Exception e) {
			System.out.println(currentactionname +" Exception");
			e.printStackTrace();
			return "false";
		}
		
		
		/**
		if (actionsDao.addfinal(currentactionname, addfinalexeOrder,
				addfinalurl, addfinalfinalTable, addfinalfinalSql)) {
			actionNameList = actionsDao.getActionsInfo();
			actionList = actionsDao.getActionsInfoByName(currentactionname);
			return "success";
		}
		return "false";
		**/
	}
	
	public String modifyTemplate(){
		ActionsDao actionsDao = new ActionsDaoImpl();
		if(actionsDao.modifyTemplate(templateId, period, step, gameId, worldId, accountType)){
			templateList = actionsDao.getTemplates();
			return "success";
		}
		return "false";
	}
	
	public String delTemplate(){
		ActionsDao actionsDao = new ActionsDaoImpl();
		if(actionsDao.delTemplate(templateId)){
			templateList = actionsDao.getTemplates();
			return "success";
		}
		return "false";
	}

	/**
	 * spark-job.xml to mysql
	 * 
	 */

	void sparkjobtomysql() {
		try {
			File fXmlFile = new File("f:\\spark-job.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			System.out.println("Root element :"
					+ doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("Action");

			ActionsDao actionsDao = new ActionsDaoImpl();

			for (int i = 0; i < nList.getLength(); i++) {

				System.out.println("---   start   ---");

				Node nNode = nList.item(i);
				Element eElement = (Element) nNode;

				String addName, addPeriod, addStep, addGameId, addWorldId, addAccountType;

				addName = eElement.getAttribute("Name").trim();
				addPeriod = eElement.getElementsByTagName("Period").item(0)
						.getTextContent();
				addStep = eElement.getElementsByTagName("Step").item(0)
						.getTextContent();
				addGameId = eElement.getElementsByTagName("GameId").item(0)
						.getTextContent();
				addWorldId = eElement.getElementsByTagName("WorldId").item(0)
						.getTextContent();
				addAccountType = eElement.getElementsByTagName("AccountType")
						.item(0).getTextContent();

				boolean result = actionsDao.addaction(addName, addPeriod,
						addStep, addGameId, addWorldId, addAccountType);
				System.out.println("addaction result : " + result);

				String[] Table = eElement.getElementsByTagName("Table").item(0)
						.getTextContent().split(",");
				for (int t = 0; t < Table.length; t++) {
					boolean result1 = actionsDao.addtb(addName,
							String.valueOf(t + 1), Table[t]);
					System.out.println("addtb result : " + result1);
				}

				NodeList SqlList = eElement.getElementsByTagName("Sql");
				for (int j = 0; j < SqlList.getLength(); j++) {
					Element e = (Element) SqlList.item(j);
					boolean result2 = actionsDao.addsql(addName, String
							.valueOf(j + 1),
							e.getAttribute("TempTable").trim(), e
									.getTextContent());
					System.out.println("addsql result : " + result2);
				}

				NodeList finalList = eElement.getElementsByTagName("Final");
				for (int k = 0; k < finalList.getLength(); k++) {
					Element e = (Element) finalList.item(k);
					boolean result3 = actionsDao.addfinal(addName,
							String.valueOf(k + 1),
							e.getAttribute("URL").trim(),
							e.getAttribute("Table").trim(), e.getTextContent());
					System.out.println("addfinal result : " + result3);
				}

				System.out.println("---   end   ---");
			}
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}

	}

	/**
	 * DajianLog.xml to mysql
	 */
	void DajianLogtomysql() {
		try {
			File fXmlFile = new File("f:\\DajianLog.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			System.out.println("Root element :"
					+ doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("struct");

			for (int i = 0; i < nList.getLength(); i++) {

				System.out.println("---   start   ---");

				Node nNode = nList.item(i);
				Element eElement = (Element) nNode;

				String structName = eElement.getAttribute("name").trim();
				String structId = eElement.getAttribute("id").trim();
				String structDesc = eElement.getAttribute("desc").trim();

				boolean r = addStruct(structName, structId, structDesc);
				System.out.println("addStruct : " + r);

				NodeList entryList = eElement.getElementsByTagName("entry");
				for (int j = 0; j < entryList.getLength(); j++) {
					Element e = (Element) entryList.item(j);
					boolean result2 = addStructInfo(structName,
							e.getAttribute("name").trim(),
							e.getAttribute("type").trim(),
							e.getAttribute("size").trim(), e
									.getAttribute("key").trim(), e
									.getAttribute("desc").trim());
					System.out.println("addStructInfo : " + result2);
				}

				System.out.println("---   end   ---");
			}
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}

	}

	static boolean addStruct(String structName, String structId,
			String structDesc) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = -1;
		try {
			conn = DataSource.getInstance().getConnection();
			ps = conn
					.prepareStatement("INSERT INTO t_struct(vTableName,vId,vDesc)VALUES(?,?,?)");
			ps.setString(1, structName);
			ps.setString(2, structId);
			ps.setString(3, structDesc);
			rs = ps.executeUpdate();
			if (rs > 0) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("addaction Exception : " + e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
					System.out.println("addaction Exception : "
							+ e2.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					System.out.println("addaction Exception : "
							+ e2.getMessage());
				}
			}
		}
		return result;
	}

	static boolean addStructInfo(String vTableName, String ColumnName,
			String Type, String Size, String Key, String Desc) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = -1;
		try {
			conn = DataSource.getInstance().getConnection();
			ps = conn
					.prepareStatement("INSERT INTO t_struct_info(vTableName,vColumnName,vType,vSize,vKey,vDesc)VALUES(?,?,?,?,?,?)");
			ps.setString(1, vTableName);
			ps.setString(2, ColumnName);
			ps.setString(3, "int".equals(Type) ? "bigint" : Type);
			ps.setString(4, Size);
			ps.setString(5, Key);
			ps.setString(6, Desc);
			rs = ps.executeUpdate();
			if (rs > 0) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("addaction Exception : " + e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e2) {
					System.out.println("addaction Exception : "
							+ e2.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					System.out.println("addaction Exception : "
							+ e2.getMessage());
				}
			}
		}
		return result;
	}
}
