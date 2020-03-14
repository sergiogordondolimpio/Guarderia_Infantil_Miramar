package graphicInterface;

import com.toedter.calendar.JDateChooser;
import dataBase.ChildrenDAO;
import dataBase.DataChildren;
import main.Utilities;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PanelSee extends JPanel implements ListSelectionListener {

    DefaultListModel<DataChildren> model = new DefaultListModel<>();
    List<DataChildren> dataChildrenList;
    ChildrenDAO childrenDAO = new ChildrenDAO();
    Utilities utilities;

    JLabel labelName = new JLabel();
    JTextField textFieldSearch = new JTextField(10);
    JButton buttonSearch = new JButton();

    JLabel labelInformation = new JLabel();
    JList<DataChildren> list = new JList<>();

    //get the actual day and put in the textfield of the calendar
    JLabel labelDay = new JLabel();
    Calendar calendar = Calendar.getInstance();
    JDateChooser dateChooser = new JDateChooser(calendar.getTime());
    JLabel labelHours = new JLabel();
    JTextField textFieldHours = new JTextField(3);
    JButton buttonAdd = new JButton();

    public PanelSee(){
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(panelSearch());
        add(panelList());
        add(panelAdd());
    }

    private Component panelAdd() {
        JPanel panelAdd = new JPanel();

        labelDay.setText("Day:");
        labelHours.setText("Horas:");
        buttonAdd.setText("Agregar");
        dateChooser.setDateFormatString("yyyy-MM-dd");
        dateChooser.setPreferredSize(new Dimension(120,20));

        panelAdd.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        panelAdd.add(labelDay);
        panelAdd.add(dateChooser);
        panelAdd.add(labelHours);
        panelAdd.add(textFieldHours);
        panelAdd.add(buttonAdd);
        return panelAdd;
    }

    private Component panelList() {
        JPanel panelList = new JPanel();

        // set list
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(list);
        putChildJList();
        scrollPane.setPreferredSize(new Dimension(120,250));

        list.getSelectionModel().addListSelectionListener(this);

        //set labelInformation
        labelInformation.setPreferredSize(new Dimension(250,250));
        labelInformation.setOpaque(true);
        labelInformation.setBackground(Color.white);
        Border borderLabel = BorderFactory.createLineBorder(Color.black);
        labelInformation.setBorder(borderLabel);
        labelInformation.setVerticalAlignment(JLabel.TOP);

        panelList.setLayout(new FlowLayout(FlowLayout.CENTER,50,10));
        panelList.add(scrollPane);
        panelList.add(labelInformation);

        return panelList;
    }

    private Component panelSearch() {
        JPanel panelSearch = new JPanel();
        //set buttonSearch
        buttonSearch.setText("Buscar");
        //set labelName
        labelName.setText("Nombre:");

        panelSearch.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        panelSearch.add(labelName);
        panelSearch.add(textFieldSearch);
        panelSearch.add(buttonSearch);

        return panelSearch;
    }

    /**
     * This method put all the child of the database int the list, only
     * the name and the surname
     */
    public void putChildJList(){
        list.setModel(model);
        dataChildrenList = new ArrayList<>();
        dataChildrenList = ChildrenDAO.queryChildren();
        //put every element of the database
        //you have to generate toString override in the DataChildren to see
        //only surname and name
        for (DataChildren datachildren : dataChildrenList) {
            model.addElement(datachildren);
        }
    }

    //this is the way you can see the other elements
    @Override
    public void valueChanged(ListSelectionEvent e) {
        DataChildren dataChildren = list.getSelectedValue();
        try {
            labelInformation.setText(
                    "<html>" +
                            "<body>" +
                            "Nombre: " + dataChildren.getNameChildren() + " " + dataChildren.getSurnameChildren() + "<br> " +
                            "DNI: " + dataChildren.getDniChildren() + "<br>" +
                            "Nacimiento: " + dataChildren.getBirthday() + "<br>" +
                            "Fecha que ingresa: " + dataChildren.getDateIn() + "<br>" +
                            "Edad: " + Utilities.getAges(dataChildren.getBirthday()) +
                            "</body>" +
                            "</html>"
            );
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }


    //get the day of the calendar, have to chance the button
    public void getDate(){
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sdfmt = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdfmt.format(dateChooser.getDate());
                //dataChooser.setDate() to set to the calendar
            }
        });
    }

}