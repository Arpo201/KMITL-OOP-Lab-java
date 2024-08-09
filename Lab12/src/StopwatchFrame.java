import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StopwatchFrame implements MouseListener {
    boolean state = true;
    Thread t;
    Stopwatch clock;
    public StopwatchFrame(){
        clock = new Stopwatch();
        t = new Thread(clock);
        t.start();
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.add(clock);
        frame.setSize(400,180);
        frame.setVisible(true);
        frame.addMouseListener(this);
    }

    public static void main(String[] args) {
        new StopwatchFrame();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (state){
            state = false;
            t.suspend();
        }else {
            state = true;
            t.resume();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
