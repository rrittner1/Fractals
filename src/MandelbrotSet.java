import java.awt.*;
import javax.swing.*;
import java.util.Set;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MandelbrotSet extends JFrame {

    private ContentPanel panel;
    private int depth;
    private double centerX;
    private double centerY;
    private double range;
    private TextField[] fields;
    private Button depthButton;
    private Button zoomButton;
    private boolean done;
    private Timer timer;
    private static Object sync = new Object();

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
        x.setText("" + centerX);
        panel.add(x);
        fields[0] = x;
        TextField y = new TextField("centerY",this);
        y.setBounds(120, 625, 100, 25);
        y.setText("" + centerY);
        panel.add(y);
        fields[1] = y;
        TextField r = new TextField("range",this);
        r.setText("" + range);
        r.setBounds(240, 625, 100, 25);
        panel.add(r);
        fields[2] = r;
        TextField d = new TextField("depth",this);
        d.setText("" + depth);
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

        depthButton = new Button("Sharpen", this, "animate button");
        depthButton.setBounds(460, 600, 120,25);
        depthButton.setHorizontalTextPosition(SwingConstants.CENTER);
        panel.add(depthButton);
        zoomButton = new Button("Zoom", this, "zoom button");
        zoomButton.setBounds(460,625,120,25);
        zoomButton.setHorizontalTextPosition(SwingConstants.CENTER);
        panel.add(zoomButton);
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
            if (!done) {
                done = true;
                ScuffedTimer.wait(depth*2 + 150);
            }

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
            System.out.println(System.currentTimeMillis());
            this.repaint();
        }
    }
    public static void main(String args[]) throws InterruptedException {
        MandelbrotSet m = new MandelbrotSet("Mandelbrot set");
        m.componentSetup();
        m.setVisible(true);
        System.out.println(Thread.currentThread().getName());
        //System.out.println(Thread.currentThread());
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
    public TextField[] getfields() {
        return fields;
    }
    public Timer getTimer() {
        return timer;
    }
    public void sharpen() {
        int delay = 500;
        ActionListener animateRunner = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                depth += 6;
                fields[3].setText("" + depth);
                panel.repaint();
            }
        };
        timer = new Timer(delay, animateRunner);
        depthButton.setText("stop");
        timer.start();
    }
    public void zoom() {
        int delay = 17;
        ActionListener animateRunner = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                range *= 0.9;
                fields[2].setText(String.format("%.12f", range));
                panel.repaint();
            }
        };
        timer = new Timer(delay, animateRunner);
        zoomButton.setText("stop");
        timer.start();
    }
    public void nextFrame() {
        depth += 6;
        fields[3].setText("" + depth);
        panel.repaint();
    }
    /*
    @Override
    public void paint(Graphics g) {
        synchronized (sync) {
            super.paint(g);
        }
    }*/

}
