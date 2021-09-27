import java.awt.*;
import javax.swing.*;

public class MandelBrotSet extends JFrame {
    private ContentPanel panel;
    private int depth;
    public MandelBrotSet(String title) {
        super(title);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new ContentPanel(this);
        panel.setLayout(null);
        this.getContentPane().add(panel);
        depth = 60;
    }
    public static void main(String args[]) throws InterruptedException {
        MandelBrotSet m = new MandelBrotSet("Mandelbrot set");
        m.setDepth(60);
        m.setVisible(true);
       // m.animate();

    }
    public static double[] getImageBounds() {//values for picture of whole fractal shown
        double[] out = new double[4];
        double centerX = -0.5;//-.5
        double centerY = 0;//0
        double range = 3;//3

        out[0] = centerX - range/2.0;
        out[1] = range;
        out[2] = -centerY - range/2.0;
        out[3] = range;
        System.out.println(out[0]);
        System.out.println(out[1]);
        return out;
    }
    public int getDepth() {
        return depth;
    }
    public void setDepth(int d) {
        depth = d;
    }
    public void animate() throws InterruptedException {
        depth = 6;
        while (depth < 1000) {
            System.out.println("d = " + depth);
            Thread.sleep(1);
            depth += 1;
            this.repaint();
        }
    }
}
