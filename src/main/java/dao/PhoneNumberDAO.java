package dao;

import entities.PhoneNumber;
import utils.SqlConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class PhoneNumberDAO {

    public Integer createPhoneNumber(PhoneNumber phoneNumber) {
        String sql = """
                INSERT INTO tbl_phone
                (ddd, number, fk_owner_id)
                VALUES (?,?,?)
                """;
        try (SqlConnection conn = new SqlConnection()) {
            PreparedStatement stm = conn.connect().prepareStatement(sql);
            stm.setString(1, phoneNumber.getDdd());
            stm.setString(2, phoneNumber.getNumber());
            stm.setInt(3, phoneNumber.getOwner().getOwnerId());
            return stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public Set<PhoneNumber> getPhonesByOwnerId() {
        Set<PhoneNumber> phoneNumbers = new HashSet<>();

        String sql = """
                SELECT * FROM `tbl_owner`
                WHERE pk_owner_id == ?
                """;

        try (SqlConnection conn = new SqlConnection()) {
            PreparedStatement stm = conn.connect().prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();
            while (resultSet.next()) {
                PhoneNumber phoneNumber = new PhoneNumber();
                phoneNumber.setDdd(resultSet.getString("ddd"));
                phoneNumber.setNumber(resultSet.getString("number"));

                phoneNumbers.add(phoneNumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return phoneNumbers;
    }

}
