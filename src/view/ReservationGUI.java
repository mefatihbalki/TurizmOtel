package view;

import business.EmployeeManager;
import core.Helper;

import javax.swing.*;

//Rezervasyon bilgileri
public class ReservationGUI extends Layout {
    private EmployeeManager employeeManager;
    private JPanel container;
    private JTextField fld_customerName;
    private JTextField fld_customerTcNo;
    private JTextField fld_customerPhone;
    private JTextField fld_customerEmail;
    private JButton btn_reservation;
    private JLabel fld_totalPrice;
    public ReservationGUI(EmployeeGUI gui, EmployeeManager employeeManager, int hotelID, int roomID, int childNumber, int adultNumber,int adultPrice,int childPrice, int totalPrice) {
        add(container);
        guiInitialize(500,500);
        this.employeeManager = employeeManager;
        fld_totalPrice.setText(String.valueOf(totalPrice));

        btn_reservation.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_customerName) || Helper.isFieldEmpty(fld_customerTcNo) || Helper.isFieldEmpty(fld_customerPhone) || Helper.isFieldEmpty(fld_customerEmail)){
                Helper.showMsg("Uyarı !","İlgili alanları doldurun");
            }else{
                if(employeeManager.addReservation(
                        hotelID,
                        roomID,
                        fld_customerName.getText(),
                        fld_customerTcNo.getText(),
                        fld_customerPhone.getText(),
                        fld_customerEmail.getText(),
                        childNumber,
                        adultNumber)){
                    employeeManager.decreaseStock(roomID);
                    gui.loadRezervationList();
                    Helper.showMsg("Başarılı !","Rezervasyon yapıldı");
                }
            }
        });
    }
}
