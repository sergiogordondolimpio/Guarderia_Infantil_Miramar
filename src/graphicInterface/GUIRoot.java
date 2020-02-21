package graphicInterface;

import dataBase.DataChildren;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static dataBase.ChildrenDAO.childrenInsertDB;

public class GUIRoot {

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
    JTextField textFieldBirthday = new JTextField();
    JTextField textFieldDateIn = new JTextField();
    JComboBox<String> comboBoxSex = new JComboBox<String>();
    JComboBox<String> comboBoxRegular = new JComboBox<String>();


    JPanel panelInsert = new JPanel();
    JPanel panelInsertData = new JPanel();

    PanelSee panelSee = new PanelSee();
    JPanel panelDelete = new JPanel();
    JPanel panelEdit = new JPanel();
    JTabbedPane tabbedPane = new JTabbedPane();
    JFrame frame = new JFrame();

    public GUIRoot(){


        labelName.setText("Nombre");
        labelSurname.setText("Apellido");
        labelDNI.setText("DNI");
        labelBirthday.setText("Fecha de Nacimiento");
        labelDateIn.setText("Fecha de Ingreso");
        labelSex.setText("Sexo");
        labelRegular.setText("Regularidad");

        comboBoxSex.addItem("Femenino");
        comboBoxSex.addItem("Masculino");
        comboBoxRegular.addItem("Si");
        comboBoxRegular.addItem("No");

        panelInsert.setLayout(new BoxLayout(panelInsert,BoxLayout.PAGE_AXIS));
        panelInsert.add(panelInsertData);
        //se agrega los botones con una funcion que retorna el panel configurado
        panelInsert.add(panelInsertButtons());

        panelInsertData.setLayout(new GridLayout(7,2,10,20));
        panelInsertData.setBorder(BorderFactory.createEmptyBorder(20,20,0,20));
        panelInsertData.add(labelName);
        panelInsertData.add(textFieldName);
        panelInsertData.add(labelSurname);
        panelInsertData.add(textFieldSurname);
        panelInsertData.add(labelDNI);
        panelInsertData.add(textFieldDNI);
        panelInsertData.add(labelBirthday);
        panelInsertData.add(textFieldBirthday);
        panelInsertData.add(labelDateIn);
        panelInsertData.add(textFieldDateIn);
        panelInsertData.add(labelSex);
        panelInsertData.add(comboBoxSex);
        panelInsertData.add(labelRegular);
        panelInsertData.add(comboBoxRegular);

        //insert panel to tabbedPanel, but the panel see is gonna be
        //in another class, PanelSee()
        tabbedPane.add("Ingresar",panelInsert);
        tabbedPane.add("Ver",panelSee);
        tabbedPane.add("Eliminar",panelDelete);
        tabbedPane.add("Editar", panelEdit);

        frame.add(tabbedPane);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400,450);
        frame.setVisible(true);
    }
    //the buttons
    protected JComponent panelInsertButtons(){
        JPanel panel = new JPanel();
        JButton buttonInsert = new JButton();
        JButton buttonClear = new JButton();

        buttonClear.setText("Borrar");
        buttonClear.setPreferredSize(new Dimension(100,20));
        buttonInsert.setText("Ingresar");
        buttonInsert.setPreferredSize(new Dimension(100,20));

        panel.setLayout(new FlowLayout());
        panel.add(buttonInsert,BorderLayout.EAST);
        panel.add(buttonClear,BorderLayout.WEST);
        panel.setBorder(BorderFactory.createEmptyBorder(20,75,0,0));

        buttonInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*List<DataChildren> dataChildren = new ArrayList<DataChildren>();
                dataChildren.add(new DataChildren(Integer.valueOf(textFieldDNI.getText()),
                        textFieldName.getText(),
                        textFieldSurname.getText(),
                        textFieldBirthday.getText(),
                        textFieldDateIn.getText(),
                        comboBoxSex.getSelectedItem().toString(),
                        comboBoxRegular.getSelectedItem().toString()));
                        */
                DataChildren dataChildren = new DataChildren(Integer.valueOf(textFieldDNI.getText()),
                        textFieldName.getText(),
                        textFieldSurname.getText(),
                        textFieldBirthday.getText(),
                        textFieldDateIn.getText(),
                        comboBoxSex.getSelectedItem().toString(),
                        comboBoxRegular.getSelectedItem().toString());
                childrenInsertDB(dataChildren);
                JOptionPane.showMessageDialog(null, dataChildren.getNameChildren()
                                + " fue ingresado a la base de datos",
                        "Ingresar niño",JOptionPane.PLAIN_MESSAGE);
            }
        });

        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldName.setText("");
                textFieldSurname.setText("");
                textFieldDNI.setText("");
                textFieldBirthday.setText("");
                textFieldDateIn.setText("");
                textFieldName.requestFocus();
            }
        });

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUIRoot();
            }
        });
    }
}
