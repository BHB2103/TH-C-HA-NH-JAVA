import java.awt.*;

public class Pipe {
    int x;
    int y;
    int width = 64;
    int height = 512;
    Image img;
    boolean passed = false;
    boolean isTop;

    public Pipe(Image img, int x, int y, boolean isTop) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.isTop = isTop;
    }

    public void draw(Graphics g) {
        g.drawImage(img, x, y, width, height, null);
    }
}