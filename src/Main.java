//Rafael Chaves
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Game");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        int width = 800;
        int height = 800;
        frame.setPreferredSize(new Dimension(width, height + 24));
        JPanel panel = new Game(width, height);
        panel.setFocusable(true);
        panel.grabFocus();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

