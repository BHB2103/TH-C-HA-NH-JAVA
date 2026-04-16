import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Flappy Bird");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        FlappyBird game = new FlappyBird();
        game.setPreferredSize(new java.awt.Dimension(360, 640));

        frame.add(game);
        frame.pack();

        frame.setLocationRelativeTo(null); // căn giữa màn hình
        frame.setVisible(true);
    }
}