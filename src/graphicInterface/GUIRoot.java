package graphicInterface;

import dataBase.DataChildren;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static dataBase.ChildrenDAO.childrenInsertDB;

public class GUIRoot {

    PanelInsert panelInsert = new PanelInsert();
    PanelSee panelSee = new PanelSee();
    JTabbedPane tabbedPane = new JTabbedPane();
    JFrame frame = new JFrame();

    JPanel panelDelete = new JPanel();
    JPanel panelEdit = new JPanel();


    public GUIRoot(){

        //insert panel to tabbedPanel, but the panel see is gonna be
        //in another class, PanelSee()
        tabbedPane.add("Ingresar",panelInsert);
        tabbedPane.add("Ver",panelSee);
        tabbedPane.add("Eliminar",panelDelete);
        tabbedPane.add("Editar", panelEdit);

        frame.add(tabbedPane);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500,450);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUIRoot();
            }
        });
    }


    /**
     * validate the date
     * @param dateToValidate
     * @param dateFromat
     * @return
     */
    public boolean isThisDateValid(String dateToValidate, String dateFromat){

        if(dateToValidate == null){
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);

        try {

            //if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);
            //System.out.println(date);

        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
