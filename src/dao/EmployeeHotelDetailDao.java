package dao;

import core.DBConnector;
import core.Helper;
import entity.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmployeeHotelDetailDao{

    public ArrayList<Season> getSeasonListByHotelID(int hotelID) {
        ArrayList<Season> list = new ArrayList<>();
        try(ResultSet rs = DBConnector.getPreparedStatement("SELECT season_id,season_name,start_date,end_date FROM tbl_season WHERE hotel_id="+hotelID).executeQuery()) {
            while(rs.next()){
                list.add(new Season(
                        rs.getInt("season_id"),
                        hotelID,
                        rs.getString("season_name"),
                        rs.getString("start_date"),
                        rs.getString("end_date")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    public boolean addSeason(int hotelID, String seasonName, String startDate, String endDate) {
        try(PreparedStatement ps = DBConnector.getPreparedStatement("INSERT INTO tbl_season (hotel_id,season_name,start_date,end_date) VALUES(?,?,?,?)")){
            ps.setInt(1,hotelID);
            ps.setString(2,seasonName);
            ps.setString(3,startDate);
            ps.setString(4,endDate);
            int result = ps.executeUpdate();
            return result != -1;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public ArrayList<Pension> getPensionList(int hotelID) {
        ArrayList<Pension> list = new ArrayList<>();
        try(ResultSet rs = DBConnector.getPreparedStatement("SELECT pension_id,pension_name FROM tbl_hotel_pension WHERE hotel_id="+hotelID).executeQuery()) {
            while(rs.next()){
                list.add(new Pension(
                        rs.getInt("pension_id"),
                        rs.getString("pension_name")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    public ArrayList<Pension> getPensionTypeList() {
        ArrayList<Pension> list = new ArrayList<>();
        try(ResultSet rs = DBConnector.getPreparedStatement("SELECT * FROM tbl_pensiontype").executeQuery()) {
            while(rs.next()){
                list.add(new Pension(
                        rs.getInt("id"),
                        rs.getString("pension_name")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    public boolean addPensiontoHotel(int hotelID, int pensionID, String pensionName) {
        try(PreparedStatement ps = DBConnector.getPreparedStatement("INSERT INTO tbl_hotel_pension (hotel_id,pension_id,pension_name) VALUES(?,?,?)")){
            ps.setInt(1,hotelID);
            ps.setInt(2,pensionID);
            ps.setString(3,pensionName);
            int result = ps.executeUpdate();
            return result != -1;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public ArrayList<HotelFeature> getHotelFeaturesList() {
        ArrayList<HotelFeature> list = new ArrayList<>();
        try(ResultSet rs = DBConnector.getPreparedStatement("SELECT * FROM tbl_featuretype").executeQuery()) {
            while(rs.next()){
                list.add(new HotelFeature(
                        rs.getInt("id"),
                        rs.getString("feature_name")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    public boolean addHotelFeature(int hotelID,int featureID ,String featuretoAdd) {
        try(PreparedStatement ps = DBConnector.getPreparedStatement("INSERT INTO tbl_hotel_feature (hotel_id,feature_id,feature_name) VALUES(?,?,?)")){
            ps.setInt(1,hotelID);
            ps.setInt(2,featureID);
            ps.setString(3,featuretoAdd);
            int result = ps.executeUpdate();
            return result != -1;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public boolean addHotelRoom(int hotelID, int seasonID, int pensionID, String roomType, int bedNumber, int stock, int priceChildren,int priceAdult) {
        try(PreparedStatement ps = DBConnector.getPreparedStatement(
                "INSERT INTO tbl_hotel_room (hotel_id,season_id,pension_id,room_type,bed_number,stock,price_child,price_adult) VALUES(?,?,?,?,?,?,?,?)")){
            ps.setInt(1,hotelID);
            ps.setInt(2,seasonID);
            ps.setInt(3,pensionID);
            ps.setString(4,roomType);
            ps.setInt(5,bedNumber);
            ps.setInt(6,stock);
            ps.setInt(7,priceChildren);
            ps.setInt(8,priceAdult);
            int result = ps.executeUpdate();
            return result != -1;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public ArrayList<HotelFeature> getHotelFeatureListByID(int hotelID) {
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


    public ArrayList<Room> getHotelRoomListByID(int hotelID) {
        ArrayList<Room> list = new ArrayList<>();
        try(ResultSet rs = DBConnector.getPreparedStatement("SELECT * FROM tbl_hotel_room WHERE hotel_id="+hotelID).executeQuery()) {
            while(rs.next()){
                list.add(new Room(
                        rs.getInt("room_id"),
                        rs.getInt("hotel_id"),
                        rs.getInt("season_id"),
                        rs.getInt("pension_id"),
                        rs.getString("room_type"),
                        rs.getInt("bed_number"),
                        rs.getInt("stock"),
                        rs.getInt("price_child"),
                        rs.getInt("price_adult")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    public String getSeasonNameByID(int seasonID) {
        try(ResultSet rs = DBConnector.getPreparedStatement("SELECT season_name FROM tbl_season WHERE season_id="+seasonID).executeQuery()) {
            if(rs.next()){
                return rs.getString("season_name");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public String getPensionNameByID(int pensionID) {
        try(ResultSet rs = DBConnector.getPreparedStatement("SELECT pension_name FROM tbl_pensiontype WHERE id="+pensionID).executeQuery()) {
            if(rs.next()){
                return rs.getString("pension_name");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public boolean addHotelRoomProperty(int roomID, String roomProperty) {
        try(PreparedStatement ps = DBConnector.getPreparedStatement(
                "INSERT INTO tbl_room_property (room_id,property_name) VALUES(?,?)")){
            ps.setInt(1,roomID);
            ps.setString(2,roomProperty);
            int result = ps.executeUpdate();
            return result != -1;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public ArrayList<RoomFeature> getRoomFeatureList(int roomID) {
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


    public boolean updateRoomInfo(String roomType, int bedNumber, int stock, int priceChild, int priceAdult) {
        try(PreparedStatement ps = DBConnector.getPreparedStatement("UPDATE tbl_hotel_room SET room_type=?,bed_number=?,stock=?,price_child=?,price_adult=?")) {
            ps.setString(1,roomType);
            ps.setInt(2,bedNumber);
            ps.setInt(3,stock);
            ps.setInt(4,priceChild);
            ps.setInt(5,priceAdult);
            int result = ps.executeUpdate();
            ps.close();
            return result != -1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public boolean deleteRoom(int roomID) {
        try(PreparedStatement ps = DBConnector.getPreparedStatement("DELETE FROM tbl_hotel_room WHERE room_id="+roomID)) {
            int result = ps.executeUpdate();
            ps.close();
            return result != -1;
        }catch (Exception e){
            Helper.showMsg("Hata","Veri Tabanı Hatası!!!");
        }
        return false;
    }


    public boolean deleteSeason(int seasonID) {
        try(PreparedStatement ps = DBConnector.getPreparedStatement("DELETE FROM tbl_season WHERE season_id="+seasonID)) {
            int result = ps.executeUpdate();
            ps.close();
            return result != -1;
        }catch (Exception e){
            Helper.showMsg("Hata","Veri Tabanı Hatası!!!");
        }
        return false;
    }


    public boolean deleteHotelFeature(int hotelID, String featureName) {
        try(PreparedStatement ps = DBConnector.getPreparedStatement("DELETE FROM tbl_hotel_feature WHERE hotel_id=? AND feature_name=?")) {
            ps.setInt(1,hotelID);
            ps.setString(2,featureName);
            int result = ps.executeUpdate();
            ps.close();
            return result != -1;
        }catch (Exception e){
            Helper.showMsg("Hata","Veri Tabanı Hatası!!!");
        }
        return false;
    }


    public boolean deleteHotelPension(int pensionID) {
        try (PreparedStatement ps = DBConnector.getPreparedStatement("DELETE FROM tbl_hotel_pension WHERE pension_id=?")) {
            ps.setInt(1, pensionID);
            int result = ps.executeUpdate();
            ps.close();
            return result != -1;
        } catch (Exception e) {
            Helper.showMsg("Hata","Veri Tabanı Hatası!!!");
        }
        return false;
    }

    public boolean deleteRoomProperty(int roomID, String property) {
        try(PreparedStatement ps = DBConnector.getPreparedStatement("DELETE FROM tbl_room_property WHERE room_id=? AND property_name=?")) {
            ps.setInt(1,roomID);
            ps.setString(2,property);
            int result = ps.executeUpdate();
            ps.close();
            return result != -1;
        }catch (Exception e){
            Helper.showMsg("Hata","Veri Tabanı Hatası!!!");
        }
        return false;
    }
}
