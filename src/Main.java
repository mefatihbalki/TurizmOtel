import business.LoginManager;
import dao.LoginDao;
import view.LoginGUI;

public class Main {
    public static void main(String[] args) {
        LoginGUI run = new LoginGUI(new LoginManager(new LoginDao()));
    }
}