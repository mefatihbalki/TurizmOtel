package entity;

import java.util.ArrayList;

public class SearchResult {
    private String seasonName;
    private String seasonStartDate;
    private String seasonEndDate;
    private int hotelID;
    private String hotelName;
    private String hotelCity;
    private String hotelRegion;
    private String hotelAdress;
    private String hotelEmail;
    private String hotelPhoneNumber;
    private int hotelStars;
    private int seasonID;
    private int pensionID;
    private ArrayList<HotelFeature> hotelFeatures;
    private int roomID;
    private String roomType;
    private int roomBedNumber;
    private int roomStock;
    private int roomPriceChildren;
    private int roomPriceAdult;
    private ArrayList<RoomFeature> roomFeatures;

    public SearchResult(String seasonName, String seasonStartDate, String seasonEndDate, int hotelID, String hotelName, String hotelCity, String hotelRegion, String hotelAdress, String hotelEmail, String hotelPhoneNumber, int hotelStars, int seasonID, int pensionID,int roomID ,String roomType, int roomBedNumber, int roomStock, int roomPriceChildren, int roomPriceAdult) {
        this.seasonName = seasonName;
        this.seasonStartDate = seasonStartDate;
        this.seasonEndDate = seasonEndDate;
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.hotelCity = hotelCity;
        this.hotelRegion = hotelRegion;
        this.hotelAdress = hotelAdress;
        this.hotelEmail = hotelEmail;
        this.hotelPhoneNumber = hotelPhoneNumber;
        this.hotelStars = hotelStars;
        this.seasonID = seasonID;
        this.pensionID = pensionID;
        this.hotelFeatures = null;
        this.roomID=roomID;
        this.roomType = roomType;
        this.roomBedNumber = roomBedNumber;
        this.roomStock = roomStock;
        this.roomPriceChildren = roomPriceChildren;
        this.roomPriceAdult = roomPriceAdult;
        this.roomFeatures = null;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonStartDate() {
        return seasonStartDate;
    }

    public String getSeasonEndDate() {
        return seasonEndDate;
    }

    public int getHotelID() {
        return hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getHotelCity() {
        return hotelCity;
    }

    public String getHotelRegion() {
        return hotelRegion;
    }

    public String getHotelAdress() {
        return hotelAdress;
    }

    public String getHotelEmail() {
        return hotelEmail;
    }

    public String getHotelPhoneNumber() {
        return hotelPhoneNumber;
    }

    public int getHotelStars() {
        return hotelStars;
    }

    public int getSeasonID() {
        return seasonID;
    }

    public int getPensionID() {
        return pensionID;
    }

    public ArrayList<HotelFeature> getHotelFeatures() {
        return hotelFeatures;
    }
    public void getHotelFeatures(ArrayList<HotelFeature> hotelFeatures) {
        this.hotelFeatures = hotelFeatures;
    }

    public int getRoomID() {
        return roomID;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getRoomBedNumber() {
        return roomBedNumber;
    }

    public int getRoomStock() {
        return roomStock;
    }

    public int getRoomPriceChildren() {
        return roomPriceChildren;
    }

    public int getRoomPriceAdult() {
        return roomPriceAdult;
    }

    public ArrayList<RoomFeature> getRoomFeatures() {
        return roomFeatures;
    }
    public void setRoomFeatures(ArrayList<RoomFeature> roomFeatures) {
        this.roomFeatures = roomFeatures;
    }

}
