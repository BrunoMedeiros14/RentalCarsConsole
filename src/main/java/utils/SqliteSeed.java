package utils;

import java.sql.Connection;

public class SqliteSeed {

    public static void seedSqlite() {
        String[] sql = {"""
            CREATE TABLE IF NOT EXISTS tbl_owner (
              pk_owner_id INTEGER   NOT NULL PRIMARY KEY AUTOINCREMENT,
              name        TEXT      NOT NULL,
              cpf         CHAR (11) NOT NULL UNIQUE,
              age         INTEGER   NOT NULL,
              gender      TEXT      DEFAULT NULL
            );
            """, """
            CREATE TABLE IF NOT EXISTS tbl_car (
              pk_car_id        INTEGER       NOT NULL PRIMARY KEY AUTOINCREMENT,
              manufacture_year INTEGER       NOT NULL,
              price            FLOAT (10, 2) NOT NULL,
              color            TEXT          NOT NULL,
              brand            TEXT          NOT NULL,
              factory_name     TEXT          NOT NULL,
              fk_key_owner_id  INTEGER       DEFAULT NULL,
              FOREIGN KEY (fk_key_owner_id)
              REFERENCES tbl_owner (pk_owner_id) ON DELETE RESTRICT
            );
            """, """
            INSERT INTO `tbl_owner` (`pk_owner_id`, `name`, `cpf`, `age`, `gender`) VALUES
            (1, 'John Doe', '12345678901', 30, 'Male'),
            (2, 'Jane Smith', '23456789012', 25, 'Female'),
            (3, 'Michael Johnson', '34567890123', 40, 'Male'),
            (4, 'Emily Davis', '45678901234', 35, 'Female'),
            (5, 'David Brown', '56789012345', 28, 'Male'),
            (6, 'Sarah Wilson', '67890123456', 32, 'Female'),
            (7, 'Robert Taylor', '78901234567', 45, 'Male'),
            (8, 'Olivia Martinez', '89012345678', 27, 'Female'),
            (9, 'William Anderson', '90123456789', 33, 'Male'),
            (10, 'Sophia Thomas', '01234567890', 29, 'Female');
            """, """
            INSERT INTO `tbl_car` (`pk_car_id`, `manufacture_year`, `price`, `color`, `brand`, `factory_name`, `fk_key_owner_id`) VALUES
            (1, 2018, 15000.00, 'White', 'Honda', 'Honda Factory', 1),
            (2, 2020, 25000.00, 'Black', 'Ford', 'Ford Factory', 2),
            (3, 2019, 20000.00, 'Red', 'Hyundai', 'Hyundai Factory', 3),
            (4, 2021, 30000.00, 'Orange', 'Volkswagen', 'VW Factory', 4),
            (5, 2020, 22000.00, 'Blue', 'Chevrolet', 'Chevy Factory', 5),
            (6, 2017, 18000.00, 'Silver', 'Audi', 'Audi Factory', 6),
            (7, 2018, 15000.00, 'Gray', 'Mazda', 'Mazda Factory', 7),
            (8, 2022, 35000.00, 'Green', 'Toyota', 'Toyota Factory', 8),
            (9, 2019, 20000.00, 'Yellow', 'Volvo', 'Volvo Factory', 9),
            (10, 2020, 25000.00, 'Cian', 'Jaguar', 'Jaguar Factory', 10),
            (11, 2021, 30000.00, 'White', 'Mitsubishi', 'Mitsubishi Factory', 1),
            (12, 2020, 22000.00, 'Black', 'Lexus', 'Lexus Factory', 2),
            (13, 2017, 18000.00, 'Red', 'Nissan', 'Nissan Factory', 3),
            (14, 2018, 15000.00, 'Orange', 'Kia', 'Kia Factory', 4),
            (15, 2019, 20000.00, 'Blue', 'Subaru', 'Subaru Factory', 5),
            (16, 2022, 35000.00, 'Silver', 'Fiat', 'Fiat Factory', 6),
            (17, 2019, 20000.00, 'Gray', 'Honda', 'Honda Factory', 7),
            (18, 2020, 25000.00, 'Green', 'Ford', 'Ford Factory', 8),
            (19, 2021, 30000.00, 'Yellow', 'Hyundai', 'Hyundai Factory', 9),
            (20, 2022, 35000.00, 'Cian', 'Volkswagen', 'VW Factory', 10),
            (21, 2019, 20000.00, 'White', 'Chevrolet', 'Chevy Factory', 1),
            (22, 2020, 25000.00, 'Black', 'Audi', 'Audi Factory', 2),
            (23, 2021, 30000.00, 'Red', 'Mazda', 'Mazda Factory', 3),
            (24, 2017, 18000.00, 'Orange', 'Toyota', 'Toyota Factory', 4),
            (25, 2018, 15000.00, 'Blue', 'Volvo', 'Volvo Factory', 5);
            """,};

        try (SqlConnection server = new SqlConnection()) {

            Connection conn = server.connect();

            for (var test : sql)
                conn.prepareStatement(test).executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
