package entity;

public class Hotel {
    private final int hotelID;
    private String hotelName;
    private String city;
    private String region;
    private String address;
    private String hotelEmail;
    private String hotelPhoneNumber;
    private int hotelStars;


    public Hotel(int hotelID, String hotelName, String city, String region, String address, String hotelEmail, String hotelPhoneNumber, int hotelStars) {
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.city = city;
        this.region = region;
        this.address = address;
        this.hotelEmail = hotelEmail;
        this.hotelPhoneNumber = hotelPhoneNumber;
        this.hotelStars = hotelStars;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getAddress() {
        return address;
    }

    public int getHotelID() {
        return hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelEmail() {
        return hotelEmail;
    }

    public void setHotelEmail(String hotelEmail) {
        this.hotelEmail = hotelEmail;
    }

    public String getHotelPhoneNumber() {
        return hotelPhoneNumber;
    }

    public void setHotelPhoneNumber(String hotelPhoneNumber) {
        this.hotelPhoneNumber = hotelPhoneNumber;
    }

    public int getHotelStars() {
        return hotelStars;
    }

    public void setHotelStars(int hotelStars) {
        this.hotelStars = hotelStars;
    }
}
