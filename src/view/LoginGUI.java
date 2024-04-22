package view;
import business.LoginManager;
import core.Helper;
import javax.swing.*;
public class LoginGUI extends Layout {
    private JPanel container;
    private JTextField fld_username_tcno;
    private JPasswordField fld_password;
    private JButton btn_login;
    private LoginManager loginManager;
    public LoginGUI(LoginManager loginManager) {
        this.loginManager = loginManager;

        try {
            // nimbus kullanıldı
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            add(container);
            guiInitialize(350, 250);

            // login butonu için action listener oluşturuldu

            btn_login.addActionListener(e -> {

                // ilgili alanların doluluğu kontrol edildiği yer

                if (Helper.isFieldEmpty(fld_username_tcno) || Helper.isFieldEmpty(fld_password)) {
                    Helper.showMsg("Hata", "Lütfen ilgili alanları doldurunuz");
                } else {

                    // giriş işleminin gerçekleşmesi için kontrollerin yapıldığı yer

                    if (loginManager.login(fld_username_tcno.getText(), fld_password.getText())) {
                        dispose();
                    } else {
                        Helper.showMsg("Uyarı", "Kullanıcı adı veya şifre hatalı !");
                    }
                }
            });
        });
    }
}
