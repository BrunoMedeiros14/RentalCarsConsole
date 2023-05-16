package dao;

import entities.Car;
import java.sql.PreparedStatement;
import utils.SqlConnection;

public class CarDAO {

  public boolean createCar(Car car) {
    boolean action = true;
    String sql =
      """
      INSERT INTO tbl_car 
      (brand, color, manufacture_year, price, factory_name, fk_key_owner_id)
      VALUES (?,?,?,?,?,?)
      """;
    try (
      PreparedStatement stm = new SqlConnection()
        .connect()
        .prepareStatement(sql)
    ) {
      stm.setString(1, car.getBrand().toString());
      stm.setString(2, car.getColor().toString());
      stm.setInt(3, car.getYear());
      stm.setDouble(4, car.getPrice());
      stm.setString(5, car.getFactoryName());
      // stm.setString(5, car.getFactoryName());
      stm.execute();
    } catch (Exception e) {
      e.printStackTrace();
      action = false;
    }
    return action;
  }

  public Car getCarById(Integer id) {
    return new Car();
  }
  // public List<ModelCar> getCars() {
  //   List<ModelCar> cars = new ArrayList<>();
  //   connect();

  //   String sql = "SELECT * FROM tbl_car";

  //   PreparedStatement preparedStatement = getPreparedStatement(sql);

  //   try {
  //     ResultSet resultSet = preparedStatement.executeQuery();
  //     while (resultSet.next()) {
  //       ModelCar car = new ModelCar() {
  //         {
  //           setId(resultSet.getInt("pk_car_id"));
  //           setBrand(resultSet.getString("brand"));
  //           setColor(resultSet.getString("color"));
  //           setFactory(resultSet.getString("factory_name"));
  //           setPrice(resultSet.getDouble("price"));
  //           setYear(resultSet.getInt("year"));
  //         }
  //       };
  //       cars.add(car);
  //     }
  //   } catch (Exception e) {
  //     e.printStackTrace();
  //   }
  //   disconnect();
  //   return cars;
  // }
}
