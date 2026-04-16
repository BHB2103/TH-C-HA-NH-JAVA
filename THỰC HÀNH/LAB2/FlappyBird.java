import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class FlappyBird extends Background implements ActionListener, KeyListener {

    javax.swing.Timer timer;

    // Bird
    int birdX = 20;
    int birdY = 120;
    int birdW = 34;
    int birdH = 24;
    double velocity = 0;
    double gravity = 0.5;

    Image birdImg;

    // Pipes
    ArrayList<Pipe> pipes = new ArrayList<>();
    Image topPipeImg;
    Image bottomPipeImg;

    int pipeGap = 150;
    int speed = 2;

    int score = 0;
    boolean gameOver = false;

    Random rand = new Random();

    public FlappyBird() {
        birdImg = new ImageIcon("Images/flappybird.png").getImage();
        topPipeImg = new ImageIcon("Images/toppipe.png").getImage();
        bottomPipeImg = new ImageIcon("Images/bottompipe.png").getImage();

        timer = new javax.swing.Timer(16, this);
        timer.start();

        setFocusable(true);
        addKeyListener(this);

        spawnPipe();
    }

    void spawnPipe() {
        int pipeHeight = 512;
        int gap = 150;

        int randomY = (int)(-pipeHeight / 4 - Math.random() * (pipeHeight / 2));

        pipes.add(new Pipe(topPipeImg, 360, randomY, true));
        pipes.add(new Pipe(bottomPipeImg, 360, randomY + pipeHeight + gap, false));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            velocity += gravity;
            birdY += (int) velocity;

            for (Pipe p : pipes) {
                p.x -= speed;

                // score
                if (!p.isTop && !p.passed && p.x + p.width < birdX) {
                    score++;
                    p.passed = true;
                }

                Rectangle birdRect = new Rectangle(birdX, birdY, birdW, birdH);
                Rectangle pipeRect;

                pipeRect = new Rectangle(p.x, p.y, p.width, p.height);

                if (birdRect.intersects(pipeRect)) {
                    gameOver = true;
                }
            }

            if (pipes.size() > 0 && pipes.get(0).x < -64) {
                pipes.remove(0);
                pipes.remove(0);
                spawnPipe();
            }

            if (birdY <= 0 || birdY + birdH >= 640) {
                gameOver = true;
            }
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // bird
        g.drawImage(birdImg, birdX, birdY, birdW, birdH, null);

        // pipes
        for (Pipe p : pipes) {
            p.draw(g);
        }

        g.setFont(new Font("Arial", Font.BOLD, 20));
        FontMetrics fm = g.getFontMetrics();

        if (!gameOver) {
            String text = "Score: " + score;
            int textWidth = fm.stringWidth(text);
            int x = (360 - textWidth) / 2;
            g.drawString(text, x, 30);
        } else {
            String text = "Game Over! Score: " + score;
            int textWidth = fm.stringWidth(text);
            int x = (360 - textWidth) / 2;
            g.drawString(text, x, 30);

            String restartText = "Press ENTER to Restart";
            int restartWidth = fm.stringWidth(restartText);
            int restartX = (360 - restartWidth) / 2;
            g.drawString(restartText, restartX, 60);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (!gameOver) {
            if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_ENTER) {
                velocity = -7;
            }
        } else {
            if (key == KeyEvent.VK_ENTER) {
                restart();
            }
        }
    }

    void restart() {
        birdY = 120;
        velocity = 0;
        pipes.clear();
        score = 0;
        gameOver = false;
        spawnPipe();
    }

    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
}