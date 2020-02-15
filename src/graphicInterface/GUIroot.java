package graphicInterface;

import com.sun.javafx.logging.JFRInputEvent;
import dataBase.DataChildren;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GUIroot {
    JButton buttonInsert = new JButton();
    JButton buttonClear = new JButton();
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
    JPanel panelInsertButtons = new JPanel();
    JPanel panelSee = new JPanel();
    JPanel panelDelete = new JPanel();
    JPanel panelEdit = new JPanel();
    JTabbedPane tabbedPane = new JTabbedPane();
    JFrame frame = new JFrame();

    public GUIroot(){
        buttonClear.setText("Borrar");
        buttonClear.setPreferredSize(new Dimension(100,50));
        buttonInsert.setText("Ingresar");
        buttonInsert.setPreferredSize(new Dimension(100,50));

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

        panelInsert.setLayout(new BorderLayout());
        panelInsert.add(panelInsertData,BorderLayout.NORTH);
        panelInsert.add(panelInsertButtons,BorderLayout.SOUTH);

        panelInsertData.setLayout(new GridLayout(7,2,10,20));
        panelInsertData.add(labelName);
        panelInsertData.add(textFieldName);
        panelInsertData.add(labelSurname);
        panelInsertData.add(textFieldSurname);
        panelInsertData.add(labelDNI);
        panelInsertData.add(textFieldDNI);
        panelInsertData.add(labelDateIn);
        panelInsertData.add(textFieldBirthday);
        panelInsertData.add(labelSex);
        panelInsertData.add(comboBoxSex);
        panelInsertData.add(labelRegular);
        panelInsertData.add(comboBoxRegular);

        panelInsertButtons.setLayout(new BorderLayout());
        panelInsertButtons.add(buttonInsert,BorderLayout.EAST);
        panelInsertButtons.add(buttonClear,BorderLayout.WEST);

        tabbedPane.add("Ingresar",panelInsert);
        tabbedPane.add("Ver",panelSee);
        tabbedPane.add("Eliminar",panelDelete);
        tabbedPane.add("Editar", panelEdit);

        frame.add(tabbedPane);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400,400);
        frame.setVisible(true);

        buttonInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<DataChildren> dataChildren = new ArrayList<DataChildren>();
                dataChildren.add(new DataChildren(Integer.valueOf(textFieldDNI.getText()),
                        textFieldName.getText(),
                        textFieldSurname.getText(),
                        textFieldBirthday.getText(),
                        textFieldDateIn.getText(),
                        comboBoxSex.getSelectedItem().toString(),
                        comboBoxRegular.getSelectedItem().toString()));
                JOptionPane.showMessageDialog(null, "El nombre es "
                                + dataChildren.get(0).getNameChildren(),
                        "Ingresar niño",JOptionPane.PLAIN_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUIroot();
            }
        });
    }
}
