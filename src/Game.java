//Rafael Chaves
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Game extends JPanel {
    private int[][] gr;
    private int turn = 0;
    private int player;

    public Game(int w, int h) {
        setSize(w, h);
        gr = new int[3][3];
        for (int r = 0; r < gr.length; r++) {
            for (int c = 0; c < gr[0].length; c++) {
                gr[r][c] = 0;
            }
        }
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                int w = getWidth() / 3;
                int h = getHeight() / 3;
                int r = y / h;
                int c = x / w;
                if (didWin() == false) {
                    if (gr[r][c] == 0 && turn % 2 == 0) {
                        gr[r][c] = 1;
                        turn++;
                    }
                    if (gr[r][c] == 0 && turn % 2 == 1) {
                        gr[r][c] = 2;
                        turn++;
                    }
                }
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public boolean didWin() {
        for (int r = 0; r < gr.length; r++) {
            if (gr[r][0] == gr[r][1] && gr[r][1] == gr[r][2] && gr[r][0] != 0) {
                player = gr[r][0];
                return true;
            }
        }
        for (int c = 0; c < gr.length; c++) {
            if (gr[0][c] == gr[1][c] && gr[1][c] == gr[2][c] && gr[0][c] != 0) {
                player = gr[0][c];
                return true;
            }
        }
        if (gr[0][0] == gr[1][1] && gr[1][1] == gr[2][2] && gr[0][0] != 0) {
            player = gr[0][0];
            return true;
        }
        else if (gr[0][2] == gr[1][1] && gr[1][1] == gr[2][0] && gr[0][2] != 0) {
            player = gr[0][2];
            return true;
        }
        return false;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int w = getWidth() / 3;
        int h = getHeight() / 3;
        for (int r = 0; r < gr.length; r++) {
            for (int c = 0; c < gr[0].length; c++) {
                g2.setStroke(new BasicStroke(3));
                g2.drawRect(c * w, r * h, w, h);
                if (gr[r][c] == 1) {
                    g2.setColor(Color.blue);
                    g2.drawOval(c * w, r * h, w, h);
                    g2.setColor(Color.black);
                }
                if (gr[r][c] == 2) {
                    g2.setColor(Color.red);
                    g2.drawLine(c * w, r * h, c * w + w, r * h + h);
                    g2.drawLine(c * w, r * h + h, c * w + w, r * h);
                    g2.setColor(Color.black);
                }

            }
        }
        if (didWin())
            System.out.println("Player " + player + " Wins!");

    }


}