package graphicInterface;

import com.toedter.calendar.JDateChooser;
import dataBase.DataChildren;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static dataBase.ChildrenDAO.childrenInsertDB;

public class PanelInsert extends JPanel implements ActionListener{
    JLabel labelName = new JLabel();
    JLabel labelSurname = new JLabel();
    JLabel labelDNI = new JLabel();
    JLabel labelBirthday = new JLabel();
    JLabel labelDateIn = new JLabel();
    JLabel labelSex = new JLabel();
    JLabel labelRegular = new JLabel();
    JTextField textFieldName = new JTextField();
    JTextField textFieldSurname = new JTextField();
    JTextField textFieldDNI = new JTextField();
    JDateChooser dateChooserBirthday = new JDateChooser();
    Calendar calendarDateIn = Calendar.getInstance();
    JDateChooser dateChooserDateIn = new JDateChooser(calendarDateIn.getTime());
    JComboBox comboBoxSex = new JComboBox();
    JComboBox comboBoxRegular = new JComboBox();
    JButton buttonInsert = new JButton();
    JButton buttonClear = new JButton();


    public PanelInsert() {

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        //All the data to add
        add(panelInsertData());
        //the buttons
        add(panelInsertButtons());

    }

    private JPanel panelInsertButtons() {
        JPanel panelInsertButtons = new JPanel();

        buttonClear.setText("Borrar");
        buttonClear.setPreferredSize(new Dimension(100,20));
        buttonClear.addActionListener(this);
        buttonInsert.setText("Ingresar");
        buttonInsert.setPreferredSize(new Dimension(100,20));
        buttonInsert.addActionListener(this);

        panelInsertButtons.setLayout(new FlowLayout());
        panelInsertButtons.add(buttonInsert,BorderLayout.EAST);
        panelInsertButtons.add(buttonClear,BorderLayout.WEST);
        panelInsertButtons.setBorder(BorderFactory.createEmptyBorder(20,75,0,0));

        return panelInsertButtons;
    }

    private JPanel panelInsertData(){
        JPanel panelInsertData = new JPanel();
        labelName.setText("Nombre");
        labelSurname.setText("Apellido");
        labelDNI.setText("DNI");
        labelBirthday.setText("Fecha de Nacimiento");
        labelDateIn.setText("Fecha de Ingreso");
        dateChooserBirthday.setDateFormatString("yyyy-MM-dd");
        dateChooserDateIn.setDateFormatString("yyyy-MM-dd");
        labelSex.setText("Sexo");
        labelRegular.setText("Regularidad");

        comboBoxSex.addItem("Femenino");
        comboBoxSex.addItem("Masculino");
        comboBoxRegular.addItem("Si");
        comboBoxRegular.addItem("No");

        panelInsertData.setLayout(new GridLayout(7, 2, 10, 20));
        panelInsertData.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));
        panelInsertData.add(labelName);
        panelInsertData.add(textFieldName);
        panelInsertData.add(labelSurname);
        panelInsertData.add(textFieldSurname);
        panelInsertData.add(labelDNI);
        panelInsertData.add(textFieldDNI);
        panelInsertData.add(labelBirthday);
        panelInsertData.add(dateChooserBirthday);
        panelInsertData.add(labelDateIn);
        panelInsertData.add(dateChooserDateIn);
        panelInsertData.add(labelSex);
        panelInsertData.add(comboBoxSex);
        panelInsertData.add(labelRegular);
        panelInsertData.add(comboBoxRegular);

        return panelInsertData;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (clicked == buttonInsert) {
            DataChildren dataChildren = new DataChildren(Integer.valueOf(textFieldDNI.getText()),
                    textFieldName.getText(),
                    textFieldSurname.getText(),
                    dateFormat.format(dateChooserBirthday.getDate()),
                    dateFormat.format(dateChooserDateIn.getDate()),
                    comboBoxSex.getSelectedItem().toString(),
                    comboBoxRegular.getSelectedItem().toString());
            childrenInsertDB(dataChildren);
        }else {
            textFieldName.setText("");
            textFieldSurname.setText("");
            textFieldDNI.setText("");
            textFieldName.requestFocus();
        }
    }

}
