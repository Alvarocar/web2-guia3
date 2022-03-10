package dev.alvarocar.guia3_web.shared.infra;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class MysqlConnector implements Connector{

  private static BasicDataSource dataSource = new BasicDataSource();

  private static MysqlConnector connector;

  static {
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUsername("alvaro");
    dataSource.setPassword("alvaro");
    dataSource.setUrl("jdbc:mysql://localhost/web");
    dataSource.setMaxIdle(10);
    dataSource.setMinIdle(5);
    dataSource.setMaxOpenPreparedStatements(100);
  }

  private MysqlConnector() {}

  public static MysqlConnector getConnector() {
    if (connector.equals(null)) {
      connector = new MysqlConnector();
    }
    return connector;
  }

  public Connection getConnection() throws SQLException {

    return dataSource.getConnection();
  }
}
