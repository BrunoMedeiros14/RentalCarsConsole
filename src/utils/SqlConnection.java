package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnection {
  private static String user = "root";
  private static String password = "asdf";
  private static String url = "jdbc:sqlserver://localhost:3306/rental-cars";

  private static Connection conn;

  public static Connection getConnection() {

    

    return conn;
  }

}
