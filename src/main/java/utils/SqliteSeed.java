package utils;

import java.sql.Connection;
import java.sql.SQLException;

public class SqliteSeed {

  public static void seedSqlite() throws SQLException {
    String[] sql = {
      "PRAGMA foreign_keys = ON;",
      """
      CREATE TABLE IF NOT EXISTS `tbl_owner` (
        `pk_owner_id` INTEGER PRIMARY KEY AUTOINCREMENT,
        `name` TEXT NOT NULL,
        `cpf` TEXT NOT NULL UNIQUE,
        `age` INTEGER,
        `gender` TEXT
      );
    """,
      """
      CREATE TABLE IF NOT EXISTS `tbl_car` (
        `pk_car_id` INTEGER PRIMARY KEY AUTOINCREMENT,
        `manufacture_year` INTEGER NOT NULL,
        `price` REAL NOT NULL,
        `color` TEXT NOT NULL,
        `brand` TEXT NOT NULL,
        `factory_name` TEXT NOT NULL,
        `fk_key_owner_id` INTEGER,
        FOREIGN KEY (`fk_key_owner_id`) REFERENCES `tbl_owner` (`pk_owner_id`)
      );      
    """,
      """
      INSERT INTO `tbl_owner` (`pk_owner_id`, `name`, `cpf`, `age`, `gender`) VALUES
      (1, 'Robert Johnson', '11111111111', 40, 'Male'),
      (2, 'Emily Davis', '22222222222', 28, 'Male'),
      (3, 'Michael Wilson', '33333333333', 35, 'Male'),
      (4, 'Sophia Martinez', '44444444444', 32, 'Male'),
      (5, 'David Anderson', '55555555555', 45, 'Male'),
      (6, 'Olivia Taylor', '66666666666', 27, 'Male'),
      (7, 'James Thomas', '77777777777', 39, 'Male'),
      (8, 'Ava Garcia', '88888888888', 31, 'Male'),
      (9, 'Daniel Brown', '99999999999', 37, 'Male'),
      (10, 'Mia Johnson', '12345678901', 29, 'Male'),
      (11, 'Alexander Davis', '98765432109', 33, 'Male'),
      (12, 'Emma Wilson', '87654321098', 30, 'Male'),
      (13, 'Benjamin Martin', '76543210987', 41, 'Male'),
      (14, 'Isabella Anderson', '65432109876', 34, 'Male'),
      (15, 'William Taylor', '54321098765', 42, 'Male'),
      (16, 'Sophia Garcia', '43210987654', 36, 'Male'),
      (17, 'Joseph Brown', '32109876543', 43, 'Male'),
      (18, 'Abigail Johnson', '21098765432', 38, 'Male'),
      (20, 'Emily Wilson', '09876543210', 26, 'Female'),
      (21, 'Bruno', '12332112309', 22, 'Male'),
      (33, 'Bruno', '12332112302', 22, 'Male'),
      (42, 'Bruno', '12332112303', 22, 'Male');        
    """,
      """
      INSERT INTO `tbl_car` (`pk_car_id`, `manufacture_year`, `price`, `color`, `brand`, `factory_name`, `fk_key_owner_id`) VALUES
      (1, 2018, 22000.00, 'Silver', 'Ford', 'Ford Factory', 2),
      (2, 2020, 28000.00, 'Black', 'Chevrolet', 'Chevrolet Factory', 3),
      (3, 2017, 18000.00, 'White', 'Nissan', 'Nissan Factory', 4),
      (4, 2019, 32000.00, 'Red', 'Volkswagen', 'VW Factory', 5),
      (5, 2016, 25000.00, 'Blue', 'Hyundai', 'Hyundai Factory', 6),
      (6, 2022, 35000.00, 'Gray', 'BMW', 'BMW Factory', 7),
      (7, 2015, 20000.00, 'Green', 'Kia', 'Kia Factory', 8),
      (8, 2021, 40000.00, 'Yellow', 'Audi', 'Audi Factory', 9),
      (9, 2014, 18000.00, 'Silver', 'Mazda', 'Mazda Factory', 10),
      (10, 2020, 38000.00, 'Black', 'Mercedes-Benz', 'MB Factory', 11),
      (11, 2013, 15000.00, 'White', 'Toyota', 'Toyota Factory', 12),
      (12, 2018, 27000.00, 'Red', 'Honda', 'Honda Factory', 13),
      (13, 2012, 13000.00, 'Blue', 'Volvo', 'Volvo Factory', 14),
      (14, 2023, 42000.00, 'Silver', 'Jaguar', 'Jaguar Factory', 15),
      (15, 2011, 12000.00, 'Black', 'Subaru', 'Subaru Factory', 16),
      (16, 2019, 34000.00, 'White', 'Lexus', 'Lexus Factory', 17),
      (17, 2010, 11000.00, 'Red', 'Mitsubishi', 'Mitsubishi Factory', 18),
      (18, 2017, 26000.00, 'Blue', 'Land Rover', 'LR Factory', 20),
      (19, 2009, 10000.00, 'Gray', 'Peugeot', 'Peugeot Factory', 21);            
    """,
    };

    SqlConnection server = new SqlConnection();
    Connection conn = server.connect();

    for (var test : sql) conn.prepareStatement(test).execute();

    server.close();
  }
}
