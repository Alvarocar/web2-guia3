package dev.alvarocar.web2_guia3.shared.infra.db;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class MysqlConnector implements Connector {

  private static BasicDataSource dataSource = new BasicDataSource();

  private static MysqlConnector connector;

  static {
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUsername("alvaro");
    dataSource.setPassword("alvaro");
    dataSource.setUrl("jdbc:mysql://localhost/web");
    dataSource.setMaxIdle(10);
    dataSource.setMinIdle(5);
    dataSource.setMaxOpenPreparedStatements(100);
  }

  private MysqlConnector() {}

  public static MysqlConnector getConnector() {
    if (connector == null) {
      connector = new MysqlConnector();
    }
    return connector;
  }

  public Connection getConnection() throws SQLException {
    dataSource.setValidationQuery("SELECT 1");
    return dataSource.getConnection();
  }
}
