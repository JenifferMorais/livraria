package br.edu.ifg.projetoweb.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexao {
	private static BasicDataSource dataSource = null;
	private static DataSource getDataSource() {
		if(dataSource == null) {
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName("org.postgresql.Driver");
			dataSource.setUsername("postgres");
			dataSource.setPassword("admin123");
			dataSource.setUrl("jdbc:postgresql://localhost:5432/projetoweb");
			dataSource.setInitialSize(50);
			dataSource.setMaxIdle(100);
			dataSource.setMaxTotal(1000);
			dataSource.setMaxWaitMillis(5000);
		}
		return dataSource;
	}
	
	public static Connection getConnection() throws SQLException{
		return getDataSource().getConnection();
	}

}
