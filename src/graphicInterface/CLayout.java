package graphicInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CLayout {
    JFrame frame = new JFrame("Taller Infantil Miramar");
    JPanel panelCont = new JPanel();
    JPanel panelFirst = new JPanel();
    JPanel panelSecond = new JPanel();
    JPanel panelThird = new JPanel();
    JButton buttonOne = new JButton("Switch to second panel/workspace");
    JButton buttonSecond = new JButton("Switch to first panel/workspace");
    CardLayout cl = new CardLayout();

    PanelRoot panelRoot = new PanelRoot();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JPanel contentPane = new JPanel();

    JTabbedPane tabbedPane = new JTabbedPane();

    public CLayout(){

        //panelFirst.add(buttonOne);
        //panelSecond.add(buttonSecond);


        buttonOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelCont,"2");
            }
        });

        buttonSecond.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelCont,"1");
            }
        });

        /*          Este es el del Layout de esta clase
        panelCont.setLayout(cl);
        panelCont.add(panelFirst, "1");
        panelCont.add(panelSecond,"2");
        cl.show(panelCont, "1");
        frame.add(panelCont); */

        //      agrego al frame un Panel pero que está en otra clase
        //frame.add(panelRoot);

        /*      agregar label, y asignarle text y cambiar el formato y el tamaño
        label1.setText("Nombre");
        label2.setText("Apellido");
        label2.setFont(new Font("Consolas",Font.PLAIN,24));
        panelRoot.add(label1);
        panelRoot.add(label2);*/

        //asigno caracteristicas a los paneles y el texto a los label, y los tamaños
        //de todos los elementos
        panelFirst.setBackground(Color.BLUE);
        panelSecond.setBackground(Color.GREEN);
        panelThird.setBackground(Color.GRAY);
        buttonOne.setPreferredSize(new Dimension(100,50));
        buttonSecond.setPreferredSize(new Dimension(100,50));
        label1.setText("Nombre");
        label1.setPreferredSize(new Dimension(100,50));
        label2.setText("Apellido");
        label2.setPreferredSize(new Dimension(100,50));

        //layout que es solo un borde que lo divide en varias partes
        panelFirst.setLayout(new BorderLayout());
        panelFirst.add(label1,BorderLayout.WEST);
        panelFirst.add(buttonOne,BorderLayout.EAST);

        //FlowLayout los acomoda automatico, se puede modificar para que todo este en el centro
        // o para un lado, y vertical, en este caso lo hice con un BoxLayout
        panelSecond.setLayout(new BoxLayout(panelSecond,BoxLayout.LINE_AXIS));
        panelSecond.add(label1);
        panelSecond.add(buttonSecond);
        panelSecond.add(label2);

        //un grid
        panelThird.setLayout(new GridLayout(2,2,10,10));
        panelThird.add(label1);
        panelThird.add(buttonOne);
        panelThird.add(label2);
        panelThird.add(buttonSecond);

        //Este es mas interesante, se agrega JTabbedPAne, las opciones aparecen arriba como en la web
        tabbedPane.add("First Panel",panelFirst);
        tabbedPane.add("Second Panel", panelSecond);
        tabbedPane.add("Third Panel", panelThird);
        frame.add(tabbedPane);

        //le da tiempo a la computadora a cerrar todos los componentes y no se cierra violentamente
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300,200);
        frame.setVisible(true);



    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CLayout();
            }
        });
    }
}
