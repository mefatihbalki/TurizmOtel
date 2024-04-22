package entity;

public class User {
    private int userID;
    private String tcNo;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String userType;

    public User(int userID, String tcNo, String username,String password, String name, String surname, String userType) {
        this.userID = userID;
        this.tcNo = tcNo;
        this.username = username;
        this.password=password;
        this.name = name;
        this.surname = surname;
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public int getUserID() {
        return userID;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
