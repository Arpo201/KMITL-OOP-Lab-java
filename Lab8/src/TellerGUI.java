import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TellerGUI implements ActionListener {
    private Account ac;
    private JFrame fr;
    private JPanel gtop, rowBut;
    private JLabel balance, amount;
    private JTextField baField, amField;
    private JButton depo, with, exit;
    public TellerGUI(){
        ac = new Account(6000, "Name");
        fr = new JFrame("Teller GUI");
        gtop = new JPanel();
        rowBut = new JPanel();
        balance = new JLabel("Balance");
        amount = new JLabel("Amount");
        baField = new JTextField(Double.toString(this.ac.getBalance()));
        baField.setEditable(false);
        amField = new JTextField();
        depo = new JButton("Deposit");
        with = new JButton("Withdraw");
        exit = new JButton("Exit");

        depo.addActionListener(this);
        with.addActionListener(this);
        exit.addActionListener(this);

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

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(with)){
            System.out.println("Button with");
            double amo = Double.parseDouble(amField.getText());
            ac.withdraw(amo);
            baField.setText(Double.toString(this.ac.getBalance()));
        }else if(ae.getSource().equals(depo)){
            System.out.println("Button depo");
            double amo = Double.parseDouble(amField.getText());
            ac.deposit(amo);
            baField.setText(Double.toString(this.ac.getBalance()));
        }
    }
}

