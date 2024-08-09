import javax.swing.*;
import java.awt.*;

public class CountFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        CountTimeNonstop clock = new CountTimeNonstop();
        Thread t = new Thread(clock);
        t.start();
        frame.setLayout(new FlowLayout());
        frame.add(clock);
        frame.setSize(400,180);
        frame.setVisible(true);
    }
}
