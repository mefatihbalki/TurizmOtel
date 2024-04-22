package entity;

public class Room {
    private int id;
    private int hotelID;
    private int seasonID;
    private int pensionID;
    private String roomType;
    private int bedNumber;
    private int stock;
    private int priceChild;
    private int priceAdult;

    public Room(int id, int hotelID, int seasonID, int pensionID, String roomType, int bedNumber, int stock, int priceChild,int priceAdult) {
        this.id = id;
        this.hotelID = hotelID;
        this.seasonID = seasonID;
        this.pensionID = pensionID;
        this.roomType = roomType;
        this.bedNumber = bedNumber;
        this.stock = stock;
        this.priceChild = priceChild;
        this.priceAdult = priceAdult;
    }

    public int getId() {
        return id;
    }

    public int getHotelID() {
        return hotelID;
    }

    public int getSeasonID() {
        return seasonID;
    }
    public void setSeasonID(int seasonID) {
        this.seasonID = seasonID;
    }

    public int getPensionID() {
        return pensionID;
    }

    public void setPensionID(int pensionID) {
        this.pensionID = pensionID;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPriceChild() {
        return priceChild;
    }
    public int getPriceAdult() {
        return priceAdult;
    }

    public void setPriceAdult(int _priceAdult) {
        this.priceAdult = _priceAdult;
    }
    public void setPriceChild(int _priceChild) {
        this.priceChild = _priceChild;
    }
}

