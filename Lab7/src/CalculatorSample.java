import java.awt.*;
import javax.swing.*;
public class CalculatorSample {
    private JFrame fr;
    private JTextField ftop;
    private JPanel body;
    private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bPlus, bMinus, bTime, bDivide, bEqual, bc;
    public CalculatorSample(){
        fr = new JFrame("Calculator Sample");
        ftop = new JTextField();
        body = new JPanel();
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        bPlus = new JButton("+");
        bMinus = new JButton("-");
        bTime = new JButton("*");
        bDivide = new JButton("/");
        bEqual = new JButton("=");
        bc = new JButton("C");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLayout(new BorderLayout());
        fr.add(ftop, BorderLayout.NORTH);
        body.setLayout(new GridLayout(4, 4));
        body.add(b7);
        body.add(b8);
        body.add(b9);
        body.add(bPlus);
        body.add(b4);
        body.add(b5);
        body.add(b6);
        body.add(bMinus);
        body.add(b1);
        body.add(b2);
        body.add(b3);
        body.add(bTime);
        body.add(b0);
        body.add(bc);
        body.add(bEqual);
        body.add(bDivide);
        fr.add(body);
        fr.pack();
        fr.setSize(400,400);
        fr.setVisible(true);
    }
    public static void main(String[] args){
        new CalculatorSample();
    }
}
