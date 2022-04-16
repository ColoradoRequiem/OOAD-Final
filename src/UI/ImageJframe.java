package UI;

import javax.swing.*;
import java.awt.*;
//https://java-demos.blogspot.com/2012/09/setting-background-image-in-jframe.html
public class ImageJframe  extends JComponent {
    private Image background;
    public ImageJframe(Image image){
        this.background = image;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0,0, this);
    }
}
