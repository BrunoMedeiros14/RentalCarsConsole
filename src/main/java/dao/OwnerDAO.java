package dao;

import entities.Owner;
import enums.Gender;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import utils.SqlConnection;

public class OwnerDAO {

  public Integer createOwner(Owner owner) {
    String sql = """
        INSERT INTO tbl_owner
        (name, age, cpf, gender)
        VALUES (?,?,?,?)
        """;
    try (SqlConnection conn = new SqlConnection()) {
      PreparedStatement stm = conn.connect().prepareStatement(sql);
      stm.setString(1, owner.getName());
      stm.setInt(2, owner.getAge());
      stm.setString(3, owner.getCpf());
      stm.setString(4, owner.getGender().toString());
      return stm.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return -1;
  }

  public Owner getOwnerById(Integer id) {
    String sql = """
        SELECT * FROM `tbl_owner` WHERE `pk_owner_id` = ?;
        """;
    Owner owner = new Owner();

    try (SqlConnection conn = new SqlConnection()) {
      PreparedStatement stm = conn.connect().prepareStatement(sql);
      stm.setInt(1, id);

      ResultSet resultSet = stm.executeQuery();
      while (resultSet.next()) {
        owner.setAge(resultSet.getInt("age"));
        owner.setCpf(resultSet.getString("cpf"));
        owner.setGender(Gender.fromValue(resultSet.getString("gender")));
        owner.setName(resultSet.getString("name"));
        owner.setOwnerId(resultSet.getInt("pk_owner_id"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return owner;
  }

  public Set<Owner> getAllOwners() {
    Set<Owner> owners = new HashSet<>();

    String sql = """
        SELECT * FROM `tbl_owner`;
        """;

    try (SqlConnection conn = new SqlConnection()) {
      PreparedStatement stm = conn.connect().prepareStatement(sql);
      ResultSet resultSet = stm.executeQuery();
      while (resultSet.next()) {
        Owner owner = new Owner() {
          {
            setAge(resultSet.getInt("age"));
            setCpf(resultSet.getString("cpf"));
            setGender(Gender.fromValue(resultSet.getString("gender")));
            setName(resultSet.getString("name"));
            setOwnerId(resultSet.getInt("pk_owner_id"));
          }
        };
        owners.add(owner);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return owners;
  }

  public Integer updateOwner(Owner owner) {
    String sql = """
        UPDATE tbl_owner
        SET name=?,
        cpf=?,
        age=?,
        gender=?
        WHERE pk_owner_id = ?;
        """;

    try (SqlConnection conn = new SqlConnection()) {
      PreparedStatement stm = conn.connect().prepareStatement(sql);
      stm.setString(1, owner.getName());
      stm.setString(2, owner.getCpf());
      stm.setInt(3, owner.getAge());
      stm.setString(4, owner.getGender().toString());
      stm.setInt(5, owner.getOwnerId());
      return stm.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return -1;
  }

  public Integer deleteOwner(Integer id) {
    String sql = """
        DELETE FROM tbl_owner WHERE pk_owner_id = ?""";

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
