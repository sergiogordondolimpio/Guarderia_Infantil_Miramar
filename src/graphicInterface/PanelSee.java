package graphicInterface;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dataBase.DataChildren;
import javafx.scene.control.SplitPane;

public class PanelSee extends JPanel {
    JList<DataChildren> list = new JList<>();
    DefaultListModel<DataChildren> model = new DefaultListModel<>();

    JLabel label = new JLabel();
    JPanel panel = new JPanel();
    JSplitPane splitPane = new JSplitPane();

    public PanelSee(){
        list.setModel(model);

        //put every element of the database
        //you have to generate toString override in the DataChildren to see
        //only surname and name
        model.addElement(new DataChildren(1213,"Fran","Gordon","2020-02-12","2020-02-12",
                "femenino","si"));

        //this is the way you can see the other elements
        list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                DataChildren dataChildren = list.getSelectedValue();
                label.setText("<html>" +
                        "<body>" + dataChildren.getNameChildren() + " " + dataChildren.getSurnameChildren() + "<br> " +
                        + dataChildren.getDniChildren() + "</body></html>"
                );
            }
        });

        splitPane.setLeftComponent(new JScrollPane(list));
        addComponentPanel();
        splitPane.setRightComponent(panel);
        //we have to add the splitPane to the PanelSee, so the class is the Panel
        //only put add(splitPane)
        add(splitPane);

    }

    /**
     * add the component to the right panel, in this panel are the button to
     * search the name of the child with the textField, the label with the
     * information of the child, and in the bottom the button to add the
     * day and how many hours stay in the garden
     */
    private void addComponentPanel(){

    }
}
