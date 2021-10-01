import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextField extends JTextField implements ActionListener {
    private String id;
    private MandelbrotSet m;
    public TextField(String id, MandelbrotSet m) {
        super();
        this.id = id;
        this.m = m;
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (id.equals("centerX")) {
           m.valueEntered("centerX");
        } else if (id.equals("centerY")) {
            m.valueEntered("centerY");
        } else if (id.equals("range")) {
            m.valueEntered("range");
        } else if (id.equals("depth")) {
            m.valueEntered("depth");
        }
    }
}
