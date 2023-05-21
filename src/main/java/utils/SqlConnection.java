package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection implements AutoCloseable {

  private final boolean LITE = true;
  private final String URL = "jdbc:mysql://localhost:3306/rental-cars";
  private final String URL_LITE = "jdbc:sqlite:./database.db";
  private final String USERNAME = "root";
  private final String PASSWORD = "wera";

  private Connection conn;

  public SqlConnection() {
  }

  public Connection connect() throws SQLException {
    if (LITE)
      conn = DriverManager.getConnection(URL_LITE);
    else
      conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    return conn;
  }

  @Override
  public void close() throws SQLException {
    if (conn != null && !conn.isClosed())
      conn.close();
  }
}
