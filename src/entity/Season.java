package entity;

public class Season {
    private int id;
    private int hotelID;
    private String seasonName;
    private String startDate;
    private String endDate;

    public Season(int id, int hotelID, String seasonName, String startDate, String endDate) {
        this.id = id;
        this.hotelID = hotelID;
        this.seasonName = seasonName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return this.seasonName;
    }

    public int getId() {
        return id;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
