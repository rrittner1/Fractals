import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MandelbrotSet extends JFrame {

    private ContentPanel panel;
    private int depth;
    private double centerX;
    private double centerY;
    private double range;
    private TextField[] fields;

    public MandelbrotSet(String title) {
        super(title);
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new ContentPanel(this);
        panel.setLayout(null);
        this.getContentPane().add(panel);
        depth = 60;//1530 is last color
        centerX = -0.5;
        centerY = 0;
        range = 3;
        fields = new TextField[4];
    }
    public void componentSetup() {
        TextField x = new TextField("centerX",this);
        x.setBounds(0,625,100,25);
        panel.add(x);
        fields[0] = x;
        TextField y = new TextField("centerY",this);
        y.setBounds(120, 625, 100, 25);
        panel.add(y);
        fields[1] = y;
        TextField r = new TextField("range",this);
        r.setBounds(240, 625, 100, 25);
        panel.add(r);
        fields[2] = r;
        TextField d = new TextField("depth",this);
        d.setBounds(360, 625, 100, 25);
        panel.add(d);
        fields[3] = d;

        JLabel xLabel = new JLabel("Real Center");
        xLabel.setBounds(0,600, 100, 25);
        panel.add(xLabel);
        JLabel yLabel = new JLabel("Complex Center");
        yLabel.setBounds(120,600, 100, 25);
        panel.add(yLabel);
        JLabel rLabel = new JLabel("Range");
        rLabel.setBounds(240,600, 100, 25);
        panel.add(rLabel);
        JLabel dLabel = new JLabel("Depth");
        dLabel.setBounds(360,600, 100, 25);
        panel.add(dLabel);

    }
    public void valueEntered(String str) {
        /*
        if (str.equals("centerX")) {
            if (!fields[0].getText().equals("")) {
                centerX = Double.parseDouble(fields[0].getText());
            }
        } else if (str.equals("centerY")) {
            if (!fields[1].getText().equals("")) {
                centerY = Double.parseDouble(fields[1].getText());
            }
        } else if (str.equals("range")) {
            if (!fields[2].getText().equals("")) {
                range = Double.parseDouble(fields[2].getText());
            }
        } else if (str.equals("depth")) {//runs on depth entry*/
        if (true) {
            if (!fields[0].getText().equals("")) {
                centerX = Double.parseDouble(fields[0].getText());
            }
            if (!fields[1].getText().equals("")) {
                centerY = Double.parseDouble(fields[1].getText());
            }
            if (!fields[2].getText().equals("")) {
                range = Double.parseDouble(fields[2].getText());
            }
            if (!fields[3].getText().equals("")) {
                depth = Integer.parseInt(fields[3].getText());
            }
            this.repaint();
        }
    }
    public static void main(String args[]) throws InterruptedException {
        MandelbrotSet m = new MandelbrotSet("Mandelbrot set");
        m.componentSetup();
        m.setVisible(true);
        //m.animate();

    }// cool points: (-0.00099645, .75097625, .00000085)
    //.251, .00005, .000005
    public double[] getImageBounds() {//values for picture of whole fractal shown
        double[] out = new double[4];
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
