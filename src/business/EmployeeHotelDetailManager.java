package business;

import dao.EmployeeHotelDetailDao;
import entity.*;

import java.util.ArrayList;

// Çalışanlarla ilgili otel ayrıntılarını ve sezonları yönetme kısmı
public class EmployeeHotelDetailManager  {

    private EmployeeHotelDetailDao employeeHotelDetailDao = new EmployeeHotelDetailDao();

    // otel id ve kimlik

    public ArrayList<Season> getSeasonListByHotelID(int hotelID) {
        return employeeHotelDetailDao.getSeasonListByHotelID(hotelID);
    }

    // otel sezonu

    public boolean addSeason(int hotelID, String seasonName, String startDate, String endDate) {
        return employeeHotelDetailDao.addSeason(hotelID, seasonName, startDate, endDate);
    }

    // pansiyon listeleme

    public ArrayList<Pension> getPensionList(int hotelID) {
        return employeeHotelDetailDao.getPensionList(hotelID);
    }

    // Retrieves a list of available pension types.

    public ArrayList<Pension> getPensionTypeList() {
        return employeeHotelDetailDao.getPensionTypeList();
    }

    // Adds a pension to a hotel.

    public boolean addPensiontoHotel(int hotelID, int pensionID, String pensionName) {
        return employeeHotelDetailDao.addPensiontoHotel(hotelID, pensionID, pensionName);
    }

    // Retrieves a list of available hotel features.

    public ArrayList<HotelFeature> getHotelFeaturesList() {
        return employeeHotelDetailDao.getHotelFeaturesList();
    }

    // Adds a new feature to a hotel.

    public boolean addHotelFeature(int hotelID, int featureID, String featuretoAdd) {
        return employeeHotelDetailDao.addHotelFeature(hotelID, featureID, featuretoAdd);
    }

    // Adds a new room to a hotel.

    public boolean addHotelRoom(int hotelID, int seasonID, int pensionID, String roomType, int bedNumber, int stock, int priceChildren, int priceAdult) {
        return employeeHotelDetailDao.addHotelRoom(hotelID, seasonID, pensionID, roomType, bedNumber, stock, priceChildren, priceAdult);
    }

    // Retrieves a list of hotel features by hotel ID.

    public ArrayList<HotelFeature> getHotelFeatureListByID(int hotelID) {
        return employeeHotelDetailDao.getHotelFeatureListByID(hotelID);
    }

    // Retrieves a list of rooms by hotel ID.

    public ArrayList<Room> getHotelRoomListByID(int hotelID) {
        return employeeHotelDetailDao.getHotelRoomListByID(hotelID);
    }

    // Retrieves the name of a season by its ID.

    public String getSeasonNameByID(int seasonID) {
        return employeeHotelDetailDao.getSeasonNameByID(seasonID);
    }

    // Retrieves the name of a pension by its ID.

    public String getPensionNameByID(int pensionID) {
        return employeeHotelDetailDao.getPensionNameByID(pensionID);
    }

    // Adds a property to a hotel room.

    public boolean addHotelRoomProperty(int roomID, String roomProperty) {
        return employeeHotelDetailDao.addHotelRoomProperty(roomID, roomProperty);
    }

    // Retrieves a list of room features by room ID.

    public ArrayList<RoomFeature> getRoomFeatureList(int roomID) {
        return employeeHotelDetailDao.getRoomFeatureList(roomID);
    }

    // Updates room information.

    public boolean updateRoomInfo(String roomType, int bedNumber, int stock, int priceChild, int priceAdult) {
        return employeeHotelDetailDao.updateRoomInfo(roomType, bedNumber, stock, priceChild, priceAdult);
    }

    // Deletes a room by its ID.

    public boolean deleteRoom(int roomID) {
        return employeeHotelDetailDao.deleteRoom(roomID);
    }

    // Deletes a season by its ID.

    public boolean deleteSeason(int seasonID) {
        return employeeHotelDetailDao.deleteSeason(seasonID);
    }

    // Deletes a hotel feature by its name and hotel ID.

    public boolean deleteHotelFeature(int hotelID, String featureName) {
        return employeeHotelDetailDao.deleteHotelFeature(hotelID, featureName);
    }

    // Deletes a pension by its ID.

    public boolean deleteHotelPension(int pensionID) {
        return employeeHotelDetailDao.deleteHotelPension(pensionID);
    }

    // Deletes a room property by its name and room ID.

    public boolean deleteRoomProperty(int roomID, String property) {
        return employeeHotelDetailDao.deleteRoomProperty(roomID, property);
    }
}
