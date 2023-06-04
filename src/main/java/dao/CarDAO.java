package dao;

import entities.Car;
import enums.Brand;
import enums.Color;
import utils.SqlConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class CarDAO {

    public Integer createCar(Car car) {
        String sql = """
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

    public Car getCarById(Integer id) {
        String sql = """
                SELECT * FROM `tbl_car` WHERE `pk_car_id` = ?;
                """;
        Car car = new Car();

        try (SqlConnection conn = new SqlConnection()) {
            PreparedStatement stm = conn.connect().prepareStatement(sql);
            stm.setInt(1, id);

            ResultSet resultSet = stm.executeQuery();
            while (resultSet.next()) {
                Integer ownerId = resultSet.getInt("fk_key_owner_id");
                car.setCarId(id);
                car.setBrand(Brand.fromValue(resultSet.getString("brand")));
                car.setColor(Color.fromValue(resultSet.getString("color")));
                car.setFactoryName(resultSet.getString("factory_name"));
                car.setOwner(new OwnerDAO().getOwnerById(ownerId));
                car.setPrice(resultSet.getDouble("price"));
                car.setYear(resultSet.getInt("manufacture_year"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return car;

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

    public Integer updateCar(Car car) {
        String sql = """
                UPDATE tbl_car
                SET manufacture_year=?,
                price=?,
                color=?,
                brand=?,
                factory_name=?,
                fk_key_owner_id=?
                WHERE pk_car_id = ?;
                """;

        try (SqlConnection conn = new SqlConnection()) {
            PreparedStatement stm = conn.connect().prepareStatement(sql);
            stm.setInt(1, car.getYear());
            stm.setDouble(2, car.getPrice());
            stm.setString(3, car.getColor().toString());
            stm.setString(4, car.getBrand().toString());
            stm.setString(5, car.getFactoryName());
            stm.setInt(6, car.getOwnerId());
            stm.setInt(7, car.getCarId());
            return stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public Integer deleteCar(Integer id) {
        String sql = """
                DELETE FROM tbl_car WHERE pk_car_id = ?
                """;

        try (SqlConnection conn = new SqlConnection()) {
            PreparedStatement stm = conn.connect().prepareStatement(sql);
            stm.setInt(1, id);
            return stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

}
