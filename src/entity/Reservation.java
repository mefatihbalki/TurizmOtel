package entity;

public class Reservation {
    private int id;
    private int hotelID;
    private int roomID;
    private String customerName;
    private String customerTcNo;
    private String customerPhone;
    private String customerEmail;
    private int childNumber;
    private int adultNumber;

    public Reservation(int id,int hotelID, int roomID, String customerName, String customerTcNo, String customerPhone, String customerEmail, int childNumber, int adultNumber) {
        this.id=id;
        this.hotelID = hotelID;
        this.roomID = roomID;
        this.customerName = customerName;
        this.customerTcNo = customerTcNo;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.childNumber = childNumber;
        this.adultNumber = adultNumber;
    }

    public int getId() {
        return id;
    }

    public int getHotelID() {
        return hotelID;
    }

    public int getRoomID() {
        return roomID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerTcNo() {
        return customerTcNo;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public int getChildNumber() {
        return childNumber;
    }

    public int getAdultNumber() {
        return adultNumber;
    }
}
