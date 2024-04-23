package dao;

import core.DBConnector;
import core.Helper;
import entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDao {
    // Adds a new user to the database.
    public boolean addUser(String tcNo, String username, String password, String name, String surname, String userType) {
        try (PreparedStatement ps = DBConnector.getPreparedStatement("INSERT INTO tbl_user (tcNo, username, password, name, surname, usertype) VALUES (?, ?, ?, ?, ?, ?)")) {
            ps.setString(1, tcNo);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, name);
            ps.setString(5, surname);
            ps.setString(6, userType);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Updates an existing user's information in the database.
    public boolean updateUser(int userID, String tcNo, String username, String password, String name, String surname, String userType) {
        try (PreparedStatement ps = DBConnector.getPreparedStatement("UPDATE tbl_user SET tcNo=?, username=?, password=?, name=?, surname=?, usertype=? WHERE id=?")) {
            ps.setString(1, tcNo);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, name);
            ps.setString(5, surname);
            ps.setString(6, userType);
            ps.setInt(7, userID);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Deletes a user from the database.
    public boolean deleteUser(int userID) {
        try (PreparedStatement ps = DBConnector.getPreparedStatement("DELETE FROM tbl_user WHERE id=?")) {
            ps.setInt(1, userID);
            int result = ps.executeUpdate();
            return result != -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Retrieves a list of all users from the database.
    public ArrayList<User> getUserList() {
        ArrayList<User> list = new ArrayList<>();
        try (PreparedStatement ps = DBConnector.getPreparedStatement("SELECT * FROM tbl_user");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new User(
                        rs.getInt("id"),
                        rs.getString("tcNo"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("usertype")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}