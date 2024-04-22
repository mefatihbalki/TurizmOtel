package business;

import dao.AdminDao;
import entity.User;

import java.util.ArrayList;

// Yönetici ile ilgili işlemler
public class AdminManager {

    private final AdminDao adminDao; // Assuming AdminDao is the actual implementation

    // AdminManager'ı varsayılan bir AdminDao örneği ile başlatan varsayılan kurucu.
    public AdminManager() {
        this.adminDao = new AdminDao(); // Assuming AdminDao is the actual implementation
    }

    // Yeni kullanıcı ekleme
    public boolean addUser(String tcNo, String username, String password, String name, String surname, String userType) {
        try {
            return adminDao.addUser(tcNo, username, password, name, surname, userType);
        } catch (Exception e) {
            // Log the exception or print a detailed error message
            e.printStackTrace();
            return false;
        }
    }
    // kullanıcı bilgileri güncelleme
    public boolean updateUser(int userID, String tcNo, String username, String password, String name, String surname, String userType) {
        try{
            return adminDao.updateUser(userID, tcNo, username, password, name, surname, userType);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    // kullanıcı silme
    public boolean deleteUser(int userID) {
        return adminDao.deleteUser(userID);
    }

    // kullanıcı listeleme
    public ArrayList<User> getUserList() {
        return adminDao.getUserList();
    }
}
