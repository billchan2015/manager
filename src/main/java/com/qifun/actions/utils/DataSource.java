package com.qifun.actions.utils;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSource {

	static Logger log = LoggerFactory.getLogger(DataSource.class);

	private static DataSource dataSource;

	private ComboPooledDataSource comboPooledDataSource;

	public static DataSource getInstance() {
		if (dataSource == null) {
			dataSource = new DataSource();
		}
		return dataSource;
	}

	private DataSource() {
		try {
			comboPooledDataSource = new ComboPooledDataSource();
			// load db properties
			Properties prop = new Properties();
			InputStream stream = DataSource.class.getClassLoader()
					.getResourceAsStream("config.properties");
			prop.load(stream);
			stream.close();

			comboPooledDataSource = new ComboPooledDataSource();
			comboPooledDataSource.setDriverClass(prop.getProperty("database.driver"));
			comboPooledDataSource.setJdbcUrl(prop.getProperty("database.url"));
			comboPooledDataSource.setUser(prop.getProperty("database.user"));
			comboPooledDataSource.setPassword(prop.getProperty("database.pwd"));
			
			comboPooledDataSource.setMinPoolSize(5);
			comboPooledDataSource.setAcquireIncrement(5);
			comboPooledDataSource.setMaxPoolSize(20);
			comboPooledDataSource.setMaxStatements(180);
		} catch (Exception e) {
			log.error("DataSource Exception : ", e);
		}

	}

	public Connection getConnection() throws SQLException {
		return comboPooledDataSource.getConnection();
	}
}
