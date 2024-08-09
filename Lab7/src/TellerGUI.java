import java.awt.*;
import javax.swing.*;
public class TellerGUI {
    private JFrame fr;
    private JPanel gtop, rowBut;
    private JLabel balance, amount;
    private JTextField baField, amField;
    private JButton depo, with, exit;
    public TellerGUI(){
        fr = new JFrame("Teller GUI");
        gtop = new JPanel();
        rowBut = new JPanel();
        balance = new JLabel("Balance");
        amount = new JLabel("Amount");
        baField = new JTextField("6000");
        baField.setEditable(false);
        amField = new JTextField();
        depo = new JButton("Deposit");
        with = new JButton("Withdraw");
        exit = new JButton("Exit");
        fr.setLayout(new GridLayout(2, 1));
        gtop.setLayout(new GridLayout(2, 2));
        rowBut.setLayout(new FlowLayout());
        gtop.add(balance);
        gtop.add(baField);
        gtop.add(amount);
        gtop.add(amField);
        fr.add(gtop);
        rowBut.add(depo);
        rowBut.add(with);
        rowBut.add(exit);
        fr.add(rowBut);
        fr.pack();
        fr.setVisible(true);
    }
    public static void main(String[] args) {
        new TellerGUI();
    }
}

