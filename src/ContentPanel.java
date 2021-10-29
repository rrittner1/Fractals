import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContentPanel extends JPanel {
    private JFrame container;
    private static final int width = 600;
    public ContentPanel(JFrame c) {
        container = c;
    }
    public void paintComponent(Graphics g) {
        System.out.println(Thread.currentThread().getName());
        super.paintComponent(g);
        double[] bounds = ((MandelbrotSet)container).getImageBounds();
        int depth = ((MandelbrotSet)container).getDepth();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                //System.out.println("i: " + i + "j: " + j);
                double x = i;
                double y = width - 1 - j;
                /*if (i == 201 && j == 370) {
                    System.out.println("you got this far");
                }*/
                Complex c = new Complex(bounds[1] * x / width + bounds[0], bounds[3] * y / width + bounds[2]);
                int num = iterations(c);
                int red;
                int blue;
                int green;
                int d6 = depth/6;
                int mod = num % (3*d6);
                if (mod < d6) {
                    red = mod;
                    blue = 0;
                    green = d6 - mod;
                } else if (mod >= d6 && mod < 2*d6) {
                    red = 2*d6 - mod;
                    blue = mod - d6;
                    green = 0;
                } else {
                    red = 0;
                    blue = mod - 2*d6;
                    green = 3*d6 - mod;
                }
                red *= 1530.0/depth;
                green *= 1530.0/depth;
                blue *= 1530.0/depth;
                double ratio = 1.0*num/depth;
                red += (255 - red)*ratio;
                green += (255 - green)*ratio;
                blue += (255 - blue)*ratio;
                red = 255 - red;
                green = 255 - green;
                blue = 255 - blue;
                g.setColor(new Color(red, blue, green));
                g.fillRect((int)Math.round(x), (int)Math.round(y), 1, 1);
            }
        }
        //g.setColor(new Color(255,255,255));
        //g.drawString("" + System.currentTimeMillis(), 0, 10);

    }
    public int iterations(Complex c) {
        int i = -1;
        Complex x = new Complex(0,0);
        while (x.mod() <= 2 && i < ((MandelbrotSet)container).getDepth()) {
            x = c.plus(x.times(x));
            i++;
        }
        return i;
    }
}
