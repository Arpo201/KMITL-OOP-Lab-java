/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Asus
 */
public class lab11 implements ActionListener {
    private JFrame frame;
    private JPanel panel1, panel2, panel3;
    private JTextArea textArea;
    private JTextField textField;
    private JButton btnSub, btnRe;
    public lab11(){
        frame = new JFrame();
        frame.setFont(new Font("Angsana New", Font.BOLD,16));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textArea = new JTextArea();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        textArea = new JTextArea();
        textField = new JTextField();
        btnSub = new JButton("ยืนยัน");
        btnRe = new JButton("รีเซ็ต");

        btnSub.addActionListener(this);
        btnRe.addActionListener(this);

        frame.add(panel1);
        panel1.add(textArea);

        frame.add(panel2, BorderLayout.SOUTH);
        panel2.setLayout(new BorderLayout());
        panel2.add(textField, BorderLayout.NORTH);
        panel2.add(panel3);
        panel3.add(btnSub);
        panel3.add(btnRe);

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(btnSub)){

        }else if(ae.getSource().equals(btnRe)){

        }
    }

    public static void main(String[] args) {
        new lab11();
    }
}
