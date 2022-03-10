package dev.alvarocar.guia3_web.shared.infra;

import java.sql.Connection;
import java.sql.SQLException;

public interface Connector {
  Connection getConnection() throws SQLException;
}
