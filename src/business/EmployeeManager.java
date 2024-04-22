package business;
import core.DBConnector;
import dao.EmployeeDao;
import entity.Reservation;
import entity.Hotel;
import entity.HotelFeature;
import entity.RoomFeature;
import entity.SearchResult;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
public class EmployeeManager  {

    private EmployeeDao employeeDao = new EmployeeDao();

    // Retrieves a list of hotels.
    public ArrayList<Hotel> getHotelList() {
        return employeeDao.getHotelList();
    }

    // Retrieves a hotel by its ID.
    public Hotel getHotelByID(int hotelID) {
        return employeeDao.getHotelByID(hotelID);
    }

    // Adds a new hotel.
    public boolean addHotel(String hotelName, String city, String region, String address, String hotelEmail, String hotelPhone, int star) {
        return employeeDao.addHotel(hotelName, city, region, address, hotelEmail, hotelPhone, star);
    }

    // Updates hotel information.
    public boolean updateHotel(int hotelID,String hotelName,String city,String region,String address, String hotelEmail, String hotelPhone, int star) {
        return employeeDao.updateHotel(hotelID,hotelName,city,region,address,hotelEmail,hotelPhone,star);
    }


    // Deletes a hotel by its ID.
    public boolean deleteHotel(int hotelID) {
        return employeeDao.deleteHotel(hotelID);
    }

    // Performs a search query.
    public String searchQuery(String city, String region, String hotelName, String startDate, String endDate, int bedCount) {
        startDate = (startDate.isEmpty()) ? startDate : formatDate(startDate);
        endDate = (endDate.isEmpty()) ? endDate : formatDate(endDate);
        return employeeDao.searchQuery(city, region, hotelName, startDate, endDate, bedCount);
    }

    // Searches and returns a list of search results based on a query.
    public ArrayList<SearchResult> search(String query) {
        return employeeDao.search(query);
    }

    // Searches and returns a list of search results with a default query.
    public ArrayList<SearchResult> search() {
        String query = "SELECT s.season_name,s.start_date,s.end_date,h.hotel_id,h.name,h.city,h.region,h.address,h.email,h.phoneNumber,h.stars,r.season_id,r.pension_id,r.room_id,r.room_type,r.bed_number,r.stock,r.price_child,r.price_adult\n" +
                "FROM tbl_season AS s\n" +
                "INNER JOIN tbl_hotel_room AS r ON s.season_id = r.season_id\n" +
                "INNER JOIN tbl_hotel AS h ON r.hotel_id = h.hotel_id\n";
        return employeeDao.search(query);
    }

    // Retrieves a list of hotel features by hotel ID.
    public ArrayList<HotelFeature> getHotelFeatures(int hotelID) {
        return employeeDao.getHotelFeatures(hotelID);
    }

    // Retrieves a list of room features by room ID.
    public ArrayList<RoomFeature> getRoomFeatures(int roomID) {
        return employeeDao.getRoomFeatures(roomID);
    }

    // Adds a new reservation.
    public boolean addReservation(int hotelID, int roomID, String customerName, String customerTc, String customerPhone, String customerEmail, int childNumber, int adultNumber) {
        return employeeDao.addReservation(hotelID, roomID, customerName, customerTc, customerPhone, customerEmail, childNumber, adultNumber);
    }

    // Decreases the stock of a room.
    public boolean decreaseStock(int roomID) {
        return employeeDao.decreaseStock(roomID);
    }

    // Increases the stock of a room.
    public boolean increaseStock(int roomID) {
        return employeeDao.increaseStock(roomID);
    }

    // Retrieves a list of reservations.
    public ArrayList<Reservation> getReservationList() {
        return employeeDao.getReservationList();
    }

    // Updates reservation information.
    public boolean updateReservation(int reservationID, String customerName, String customerTc, String customerPhone, String customerEmail, int childNumber, int adultNumber) {
        return employeeDao.updateReservation(reservationID, customerName, customerTc, customerPhone, customerEmail, childNumber, adultNumber);
    }

    // Deletes a reservation by its ID.
    public boolean deleteReservation(int reservationID) {
        return employeeDao.deleteReservation(reservationID);
    }

    // Deletes all rooms associated with a hotel by its ID.
    public void deleteRoomByHotelID(int hotelID) {
    }

    // Deletes all seasons associated with a hotel by its ID.
    public void deleteSeasonByHotelID(int hotelID) {
    }

    // Checks if the input dates are valid.
    public Boolean isValidDates(String dateToCheck1, String dateToCheck2) {
        if (dateToCheck1.isEmpty() && dateToCheck2.isEmpty()) {
            return true;
        }
        DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = null;
        try {
            if (!dateToCheck1.isEmpty()) {
                date = LocalDate.parse(dateToCheck1, DATE_TIME_FORMATTER);
            }
            if (!dateToCheck2.isEmpty()) {
                date = LocalDate.parse(dateToCheck2, DATE_TIME_FORMATTER);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Formats the date from dd/MM/yyyy to yyyy-MM-dd.
    private String formatDate(String input) {
        String[] arr = input.split("/");
        return arr[2] + "-" + arr[1] + "-" + arr[0];
    }

    // Formats the date from yyyy-MM-dd to dd/MM/yyyy.
    public String formatDateBack(String input) {
        String[] arr = input.split("-");
        return arr[2] + "/" + arr[1] + "/" + arr[0];
    }

    // Calculates the number of days between two dates.
    public int calculateDay(String startDate, String endDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate date1 = LocalDate.parse(startDate, dtf);
            LocalDate date2 = LocalDate.parse(endDate, dtf);
            return (int) ChronoUnit.DAYS.between(date1, date2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Retrieves the pension name by its ID.
    public String getPensionNameByID(int pensionID) {
        try (ResultSet rs = DBConnector.getPreparedStatement("SELECT pension_name FROM tbl_pensiontype WHERE id=" + pensionID).executeQuery()) {
            if (rs.next()) {
                return rs.getString("pension_name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
