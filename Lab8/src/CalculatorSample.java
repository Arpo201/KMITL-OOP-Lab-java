import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CalculatorSample implements ActionListener{
    private double val1, val2;
    private int operator;
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

        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        bPlus.addActionListener(this);
        bMinus.addActionListener(this);
        bTime.addActionListener(this);
        bDivide.addActionListener(this);
        bEqual.addActionListener(this);
        bc.addActionListener(this);

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

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(b0)){
            System.out.println("b0");
            ftop.setText(ftop.getText() + "0");
        }else if(ae.getSource().equals(b1)){
            System.out.println("b1");
            ftop.setText(ftop.getText() + "1");
        }else if(ae.getSource().equals(b2)){
            System.out.println("b2");
            ftop.setText(ftop.getText() + "2");
        }else if(ae.getSource().equals(b3)){
            System.out.println("b3");
            ftop.setText(ftop.getText() + "3");
        }else if(ae.getSource().equals(b4)){
            System.out.println("b4");
            ftop.setText(ftop.getText() + "4");
        }else if(ae.getSource().equals(b5)){
            System.out.println("b5");
            ftop.setText(ftop.getText() + "5");
        }else if(ae.getSource().equals(b6)){
            System.out.println("b6");
            ftop.setText(ftop.getText() + "6");
        }else if(ae.getSource().equals(b7)){
            System.out.println("b7");
            ftop.setText(ftop.getText() + "7");
        }else if(ae.getSource().equals(b8)){
            System.out.println("b8");
            ftop.setText(ftop.getText() + "8");
        }else if(ae.getSource().equals(b9)){
            System.out.println("b9");
            ftop.setText(ftop.getText() + "9");
        }else if(ae.getSource().equals(bPlus)){
            System.out.println("bPlus");
            this.val1 = Double.parseDouble(ftop.getText());
            ftop.setText("");
            this.operator = 1;
        }else if(ae.getSource().equals(bMinus)){
            System.out.println("bMinus");
            this.val1 = Double.parseDouble(ftop.getText());
            ftop.setText("");
            this.operator = 2;
        }else if(ae.getSource().equals(bTime)){
            System.out.println("bTime");
            this.val1 = Double.parseDouble(ftop.getText());
            ftop.setText("");
            this.operator = 3;
        }else if(ae.getSource().equals(bDivide)){
            System.out.println("bDivide");
            this.val1 = Double.parseDouble(ftop.getText());
            ftop.setText("");
            this.operator = 4;
        }else if(ae.getSource().equals(bc)){
            System.out.println("bc");
            this.val1 = 0;
            this.val2 = 0;
            this.operator = 0;
            ftop.setText("");
        }else if(ae.getSource().equals(bEqual)){
            System.out.println("bEqual");
            this.val2 = Double.parseDouble(ftop.getText());
            if(this.operator == 1){
                ftop.setText(Double.toString(this.val1 + this.val2));
            }else if(this.operator == 2){
                ftop.setText(Double.toString(this.val1 - this.val2));
            }else if(this.operator == 3){
                ftop.setText(Double.toString(this.val1 * this.val2));
            }else if(this.operator == 4){
                ftop.setText(Double.toString(this.val1 / this.val2));
            }
        }
    }
}
