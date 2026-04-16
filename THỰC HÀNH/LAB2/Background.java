import java.awt.*;
import javax.swing.*;

public class Background extends JPanel {
    Image bg;

    public Background() {
        bg = new ImageIcon("Images/flappybirdbg.png").getImage();
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, 360, 640, null);
    }
}
