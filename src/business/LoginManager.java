package business;

import dao.LoginDao;
import entity.User;
import view.AdminGUI;
import view.EmployeeGUI;

import javax.swing.*;

import static javax.swing.UIManager.setLookAndFeel;

public class LoginManager  {

    private final LoginDao loginDao;

    public LoginManager(LoginDao loginDao) {
        this.loginDao = loginDao;
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

    }


    public boolean login(String userName_tcNo, String password) {
        int id = loginDao.login(userName_tcNo, password);
        if (id != -1) {
            // Login which depends on user type
            User user = loginDao.getUserByID(id);
            switch (user.getUserType()) {
                case "admin":
                    SwingUtilities.invokeLater(() -> {
                        AdminGUI admin = new AdminGUI(user);
                        admin.setVisible(true);
                    });
                    break;
                case "employee":
                    SwingUtilities.invokeLater(() -> {
                        EmployeeGUI employeeGUI = new EmployeeGUI(user);
                        employeeGUI.setVisible(true);
                    });
                    break;
            }
            return true;
        }
        return false;
    }
}
