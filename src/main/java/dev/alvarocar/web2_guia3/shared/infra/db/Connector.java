package dev.alvarocar.web2_guia3.shared.infra.db;

import java.sql.Connection;
import java.sql.SQLException;

public interface Connector {
  Connection getConnection() throws SQLException;
}
