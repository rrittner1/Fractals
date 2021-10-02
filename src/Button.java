import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton implements ActionListener {
    private String text;
    private MandelbrotSet m;
    private boolean animateStatus;
    public Button(String str, MandelbrotSet m) {
        super(str);
        text = str;
        this.m = m;
        this.addActionListener(this);
        animateStatus = true;
    }
    public void actionPerformed(ActionEvent e) {
        try {
            m.animate();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }/*
    public void done(boolean status) {
        animateStatus = status;
    }
    public void animate() throws InterruptedException {
        int limit = 600 + m.getDepth();
        while (m.getDepth() < limit && animateStatus) {
            Thread.sleep(150+(int)(1.6*m.getDepth()));
            m.setDepth(m.getDepth() + 6);
            m.getfields()[3].setText("" + m.getDepth());
            m.repaint();
        }
        animateStatus = true;
    }*/
}
