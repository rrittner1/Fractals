import java.awt.*;
import javax.swing.*;

public class MandelBrotSet extends JFrame {
    private JPanel panel;
    public MandelBrotSet(String title) {
        super(title);
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    public static void main(String args[]) {

    }

}
