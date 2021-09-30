import java.awt.*;
import javax.swing.*;
import java.util.Timer;

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
        m.setDepth(1530);//1530 is last color
        m.setVisible(true);
        //m.animate();

    }// cool points: (-0.00099645, .75097625, .00000085)
    public static double[] getImageBounds() {//values for picture of whole fractal shown
        double[] out = new double[4];
        double centerX = .251;//-.5
        double centerY = .00005;//0
        double range = .000005;//3

        out[0] = centerX - range/2.0;
        out[1] = range;
        out[2] = -centerY - range/2.0;
        out[3] = range;
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
        int limit = 600;
        while (depth < limit) {
            //ScuffedTimer.wait(100);
            depth++;
            System.out.println("d = " + depth);
            this.repaint();
        }
    }
}
