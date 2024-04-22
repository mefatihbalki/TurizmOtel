package view;
import business.EmployeeHotelDetailManager;
import core.Helper;
import entity.RoomFeature;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class AddRoomPropertyGUI extends Layout {
    private JPanel container;
    private JTextField txt_room_property;
    private JButton btn_addRoomFeature;
    private EmployeeHotelDetailManager detailManager;
    private JTable tbl_room_property;
    private DefaultTableModel mdl_room_property;
    private Object[] row_room_property;
    int roomID;
    public AddRoomPropertyGUI(EmployeeHotelDetailManager detailManager, int roomID){
        this.detailManager = detailManager;
        this.roomID = roomID;
        add(container);
        guiInitialize(400,400);
        // kullanıcıya tabloyu göstermek için yapılan işlemler
        mdl_room_property = new DefaultTableModel();
        mdl_room_property.setColumnIdentifiers(new Object[]{"Oda Özellikleri"});
        row_room_property = new Object[1];
        tbl_room_property.setModel(mdl_room_property); // setleme işlemi

        tbl_room_property.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tbl_room_property.setRowSelectionInterval(tbl_room_property.rowAtPoint(e.getPoint()), tbl_room_property.rowAtPoint(e.getPoint()));
            }
        });

        // Tablo için oluşturulan menü
        JPopupMenu popup = new JPopupMenu();
        popup.add("Sil").addActionListener(e ->{
            detailManager.deleteRoomProperty(
                    roomID,
                    tbl_room_property.getValueAt(tbl_room_property.getSelectedRow(),0).toString());
            loadRoomPropertyList();
        });
        tbl_room_property.setComponentPopupMenu(popup);
        loadRoomPropertyList();
        btn_addRoomFeature.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Helper.isFieldEmpty(txt_room_property)){
                    Helper.showMsg("Uyarı","Eksik metin");
                }else{
                    if(detailManager.addHotelRoomProperty(roomID,txt_room_property.getText())){
                        loadRoomPropertyList();
                        Helper.showMsg("Başarılı","Başarıyla Eklendi");
                    }
                }
            }
        });
    }

    // oda özelliklerini göstermesi için tanımlanan metod
    private void loadRoomPropertyList(){
        DefaultTableModel db = (DefaultTableModel) tbl_room_property.getModel();
        db.setRowCount(0);
        for(RoomFeature feature : detailManager.getRoomFeatureList(roomID)){
            row_room_property[0] = feature.getFeatureName();
            mdl_room_property.addRow(row_room_property);
        }
    }
}
