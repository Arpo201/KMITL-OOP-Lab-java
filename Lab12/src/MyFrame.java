import javax.swing.*;
import java.awt.*;

public class MyFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        MyClock clock = new MyClock();
        Thread t = new Thread(clock);
        t.start();
        frame.setLayout(new FlowLayout());
        frame.add(clock);
        frame.setSize(400,180);
        frame.setVisible(true);
    }
}
