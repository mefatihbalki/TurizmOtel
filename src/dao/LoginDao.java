package dao;

import core.DBConnector;
import entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao  {
    public int login(String username_tcno, String password) {
        String query = "SELECT * FROM tbl_user WHERE ((tcNo=? OR username=?) AND password=?)";
        try(PreparedStatement ps = DBConnector.getPreparedStatement(query)){
            ps.setString(1,username_tcno);
            ps.setString(2,username_tcno);
            ps.setString(3,password);
            ResultSet rs = ps.executeQuery();
            //ps.close();
            //rs.close();
            if(rs.next()){
                return rs.getInt("id");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    public User getUserByID(int id){
        User user = null;
        String query = "SELECT * FROM tbl_user WHERE id="+id;
        // PreparedStatement ve ResultSet ayrı yapıyorduk
        try(ResultSet rs = DBConnector.getPreparedStatement(query).executeQuery()){
            if(rs.next()){
                user = new User(rs.getInt("id"),
                        rs.getString("tcNo"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("usertype"));
            }
            //rs.close();
            //ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
