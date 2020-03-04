package graphicInterface;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelRoot extends JPanel {
    BufferedImage image;

    public PanelRoot(){
        try {
            image = ImageIO.read(new File(
                    "C:/Users/Usuario/IdeaProjects/Guarderia_Infantil_Miramar/src/image/image1.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g){
        //g.drawImage(image,0,0,null);  pone una imagen de un archivo, en este case jpg

        //dibuja un rectangulo
        g.setColor(Color.BLUE);
        g.fill3DRect(10,20,30,50,true);
    }
}
