package UI;

import javax.swing.*;
import java.awt.*;

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
