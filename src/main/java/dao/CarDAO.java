package dao;

import entities.Car;
import enums.Brand;
import enums.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import utils.SqlConnection;

public class CarDAO {

  public Integer createCar(Car car) {
    String sql =
      """
      INSERT INTO tbl_car 
      (brand, color, manufacture_year, price, factory_name, fk_key_owner_id)
      VALUES (?,?,?,?,?,?)
      """;
    try (SqlConnection conn = new SqlConnection()) {
      PreparedStatement stm = conn.connect().prepareStatement(sql);
      stm.setString(1, car.getBrand().toString());
      stm.setString(2, car.getColor().toString());
      stm.setInt(3, car.getYear());
      stm.setDouble(4, car.getPrice());
      stm.setString(5, car.getFactoryName());
      stm.setInt(6, car.getOwnerId());
      return stm.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return -1;
  }

  public Set<Car> getAllCars() {
    Set<Car> cars = new HashSet<>();

    String sql = """
      SELECT * FROM `tbl_car`;
      """;

    try (SqlConnection conn = new SqlConnection()) {
      PreparedStatement stm = conn.connect().prepareStatement(sql);
      ResultSet resultSet = stm.executeQuery();
      while (resultSet.next()) {
        Integer ownerId = resultSet.getInt("fk_key_owner_id");
        Car car = new Car() {
          {
            setBrand(Brand.fromValue(resultSet.getString("brand")));
            setCarId(resultSet.getInt("pk_car_id"));
            setColor(Color.fromValue(resultSet.getString("color")));
            setFactoryName(resultSet.getString("factory_name"));
            setPrice(resultSet.getDouble("price"));
            setYear(resultSet.getInt("manufacture_year"));
            setOwner(new OwnerDAO().getOwnerById(ownerId));
          }
        };
        cars.add(car);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return cars;
  }
}
