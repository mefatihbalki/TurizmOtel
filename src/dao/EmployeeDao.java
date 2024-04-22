package dao;

import core.DBConnector;
import core.Helper;
import entity.Reservation;
import entity.Hotel;
import entity.HotelFeature;
import entity.RoomFeature;
import entity.SearchResult;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeDao  {

    public ArrayList<Hotel> getHotelList() {
        ArrayList<Hotel> hotelList = new ArrayList<>();
        try(ResultSet rs = DBConnector.getPreparedStatement("SELECT * FROM tbl_hotel").executeQuery()) {
            while(rs.next()){
                hotelList.add(new Hotel(rs.getInt("hotel_id"),
                                        rs.getString("name"),
                                        rs.getString("city"),
                                        rs.getString("region"),
                                        rs.getString("address"),
                                        rs.getString("email"),
                                        rs.getString("phoneNumber"),
                                        rs.getInt("stars")));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return hotelList;
    }

    public Hotel getHotelByID(int hotelID) {
        Hotel hotel = null;
        try(ResultSet rs = DBConnector.getPreparedStatement("SELECT * FROM tbl_hotel WHERE hotel_id="+hotelID).executeQuery()) {
            if(rs.next()){
                hotel = new Hotel(
                        rs.getInt("hotel_id"),
                        rs.getString("name"),
                        rs.getString("city"),
                        rs.getString("region"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("phoneNumber"),
                        rs.getInt("stars")
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return hotel;
    }


    public boolean addHotel(String hotelName,String city,String region,String address, String hotelEmail, String hotelPhone, int star) {
        try(PreparedStatement ps = DBConnector.getPreparedStatement("INSERT INTO tbl_hotel (name,city,region,address,email,phoneNumber,stars) VALUES(?,?,?,?,?,?,?)")){
            ps.setString(1,hotelName);
            ps.setString(2,city);
            ps.setString(3,region);
            ps.setString(4,address);
            ps.setString(5,hotelEmail);
            ps.setString(6,hotelPhone);
            ps.setInt(7,star);
            ps.executeUpdate();
            ps.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public boolean updateHotel(int hotelID,String hotelName,String city,String region,String address, String hotelEmail, String hotelPhone, int star) {
        try(PreparedStatement ps = DBConnector.getPreparedStatement("UPDATE tbl_hotel SET name=?,city=?,region=?,address=?,email=?,phoneNumber=?,stars=? WHERE hotel_id=?")) {
            ps.setString(1,hotelName);
            ps.setString(2,city);
            ps.setString(3,region);
            ps.setString(4,address);
            ps.setString(5,hotelEmail);
            ps.setString(6,hotelPhone);
            ps.setInt(7,star);
            ps.setInt(8,hotelID);
            ps.executeUpdate();
            ps.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public boolean deleteHotel(int hotelID) {
        try(PreparedStatement ps = DBConnector.getPreparedStatement("DELETE FROM tbl_hotel WHERE hotel_id="+hotelID)) {
            int result = ps.executeUpdate();
            ps.close();
            deleteRoomByHotelID(hotelID);
            deleteSeasonByHotelID(hotelID);
            deleteReservationByHotelID(hotelID);
            return result != -1;
        }catch (Exception e){
            Helper.showMsg("Hata","Veri Tabanı Hatası!!!");
        }
        return false;
    }


    public String searchQuery(String city,String region,String hotelName, String startDate, String endDate, int bedCount) {
        if(startDate.isEmpty()){}
        String query = "SELECT s.season_name,s.start_date,s.end_date,h.hotel_id,h.name,h.city,h.region,h.address,h.email,h.phoneNumber,h.stars,r.season_id,r.pension_id,r.room_id,r.room_type,r.bed_number,r.stock,r.price_child,r.price_adult\n" +
                "FROM tbl_season AS s \n" +
                "INNER JOIN tbl_hotel_room AS r ON s.season_id = r.season_id\n" +
                "INNER JOIN tbl_hotel AS h ON r.hotel_id = h.hotel_id\n" +
                "WHERE (h.name LIKE '%{{hotel}}%' OR h.city LIKE '%{{city}}%' OR h.region LIKE '%{{region}}%') AND r.bed_number>={{bedNumber}}";

        query = query.replace("{{hotel}}",hotelName);
        query = query.replace("{{city}}",city);
        query = query.replace("{{region}}",region);
        query = query.replace("{{bedNumber}}", String.valueOf(bedCount));

        if(!startDate.isEmpty()){
            query += "\nAND start_date <= '{{startDate}}'";
            query = query.replace("{{startDate}}",startDate);
        }
        if(!endDate.isEmpty()){
            query+=" AND end_date >= '{{endDate}}'";
            query = query.replace("{{endDate}}",endDate);
        }
        return query;
    }


    public ArrayList<SearchResult> search(String query) {
        ArrayList<SearchResult> resultList = new ArrayList<>();
        SearchResult object;
        try {
            Statement statement = DBConnector.getConnectionInstance().createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                object = new SearchResult(
                        rs.getString("season_name"),
                        rs.getString("start_date"),
                        rs.getString("end_date"),
                        rs.getInt("hotel_id"),
                        rs.getString("name"),
                        rs.getString("city"),
                        rs.getString("region"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("phoneNumber"),
                        rs.getInt("stars"),
                        rs.getInt("season_id"),
                        rs.getInt("pension_id"),
                        rs.getInt("room_id"),
                        rs.getString("room_type"),
                        rs.getInt("bed_number"),
                        rs.getInt("stock"),
                        rs.getInt("price_child"),
                        rs.getInt("price_adult")
                );
                resultList.add(object);
            }
            statement.close();
            rs.close();
        } catch (SQLException e) {

        }
        return resultList;
    }


    public ArrayList<HotelFeature> getHotelFeatures(int hotelID) {
        ArrayList<HotelFeature> list = new ArrayList<>();
        try(ResultSet rs = DBConnector.getPreparedStatement("SELECT * FROM tbl_hotel_feature WHERE hotel_id="+hotelID).executeQuery()) {
            while(rs.next()){
                list.add(new HotelFeature(
                        rs.getInt("feature_id"),
                        rs.getString("feature_name")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    public ArrayList<RoomFeature> getRoomFeatures(int roomID) {
        ArrayList<RoomFeature> list = new ArrayList<>();
        try(ResultSet rs = DBConnector.getPreparedStatement("SELECT * FROM tbl_room_property WHERE room_id="+roomID).executeQuery()) {
            while(rs.next()){
                list.add(new RoomFeature(
                        rs.getInt("room_id"),
                        rs.getString("property_name")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    public boolean addReservation(int hotelID, int roomID, String customerName, String customerTc, String customerPhone, String customerEmail, int childNumber, int adultNumber) {
        try(PreparedStatement ps = DBConnector.getPreparedStatement("INSERT INTO tbl_reservation (hotel_id,room_id,customer_name,customer_tc,customer_phone,customer_email,child_number,adult_number) VALUES(?,?,?,?,?,?,?,?)")){
            ps.setInt(1,hotelID);
            ps.setInt(2,roomID);
            ps.setString(3,customerName);
            ps.setString(4,customerTc);
            ps.setString(5,customerPhone);
            ps.setString(6,customerEmail);
            ps.setInt(7,childNumber);
            ps.setInt(8,adultNumber);
            ps.executeUpdate();
            ps.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public boolean decreaseStock(int roomID) {
        try(PreparedStatement ps = DBConnector.getPreparedStatement("UPDATE tbl_hotel_room SET stock=stock-1 WHERE room_id="+roomID)) {
            int result = ps.executeUpdate();
            ps.close();
            return result != -1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean increaseStock(int roomID) {
        try(PreparedStatement ps = DBConnector.getPreparedStatement("UPDATE tbl_hotel_room SET stock=stock+1 WHERE room_id="+roomID)) {
            int result = ps.executeUpdate();
            ps.close();
            return result != -1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public ArrayList<Reservation> getReservationList() {
        ArrayList<Reservation> list = new ArrayList<>();
        try(ResultSet rs = DBConnector.getPreparedStatement("SELECT * FROM tbl_reservation").executeQuery()) {
            while(rs.next()){
                list.add(new Reservation(
                        rs.getInt("reservation_id"),
                        rs.getInt("hotel_id"),
                        rs.getInt("room_id"),
                        rs.getString("customer_name"),
                        rs.getString("customer_tc"),
                        rs.getString("customer_phone"),
                        rs.getString("customer_email"),
                        rs.getInt("child_number"),
                        rs.getInt("adult_number")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    public boolean updateReservation(int reservationID,String customerName, String customerTc, String customerPhone, String customerEmail, int childNumber, int adultNumber) {
        try(PreparedStatement ps = DBConnector.getPreparedStatement("UPDATE tbl_reservation SET customer_name=?,customer_tc=?,customer_phone=?,customer_email=?,child_number=?,adult_number=? WHERE reservation_id=?")) {
            ps.setString(1,customerName);
            ps.setString(2,customerTc);
            ps.setString(3,customerPhone);
            ps.setString(4,customerEmail);
            ps.setInt(5,childNumber);
            ps.setInt(6,adultNumber);
            ps.setInt(7,reservationID);
            ps.executeUpdate();
            ps.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public boolean deleteReservation(int reservationID) {
        try(PreparedStatement ps = DBConnector.getPreparedStatement("DELETE FROM tbl_reservation WHERE reservation_id="+reservationID)) {
            int result = ps.executeUpdate();
            ps.close();
            return result != -1;
        }catch (Exception e){
            Helper.showMsg("Hata","Veri Tabanı Hatası!!!");
        }
        return false;
    }


    public void deleteRoomByHotelID(int hotelID) {
        try(PreparedStatement ps = DBConnector.getPreparedStatement("DELETE FROM tbl_hotel_room WHERE hotel_id="+hotelID)) {
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteSeasonByHotelID(int hotelID) {
        try(PreparedStatement ps = DBConnector.getPreparedStatement("DELETE FROM tbl_season WHERE hotel_id="+hotelID)) {
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteReservationByHotelID(int hotelID){
        try(PreparedStatement ps = DBConnector.getPreparedStatement("DELETE FROM tbl_reservation WHERE hotel_id="+hotelID)) {
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
