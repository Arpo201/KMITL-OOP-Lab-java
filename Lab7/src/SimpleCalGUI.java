import java.awt.*;
import javax.swing.*;
public class SimpleCalGUI {
    private JFrame fr;
    private JPanel pa;
    private JTextField fi1, fi2, fiBot;
    private JButton bPlus, bMinus, bTime, bDivide;
    public SimpleCalGUI(){
        fr = new JFrame("เครื่องคิดเลข");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pa = new JPanel();
        fi1 = new JTextField();
        fi2 = new JTextField();
        fiBot = new JTextField();
        bPlus = new JButton("Plus");
        bMinus = new JButton("Minus");
        bTime = new JButton("Time");
        bDivide = new JButton("Divide");
        fr.setLayout(new GridLayout(4,1));
        fr.add(fi1);
        fr.add(fi2);
        pa.add(bPlus);
        pa.add(bMinus);
        pa.add(bTime);
        pa.add(bDivide);
        fr.add(pa);
        fr.add(fiBot);
        fr.pack();
        fr.setVisible(true);
    }
    public static void main(String[] args) {
        new SimpleCalGUI();
    }
}
