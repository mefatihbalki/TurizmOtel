package view;
import core.Config;
import javax.swing.*;

public abstract class Layout extends JFrame {
    public void guiInitialize(int width,int height){
        setSize(width,height);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);

        setVisible(true);
    }
    public int getTableSelectedRow(JTable table, int index){
        return Integer.parseInt(table.getValueAt(table.getSelectedRow(),index).toString());
    }



}
