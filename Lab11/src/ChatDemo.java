import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;


public class ChatDemo implements ActionListener, WindowListener, Serializable {
    private JFrame fr;
    private JPanel pa1, pa2;
    private JTextArea ta;
    private JTextField tf;
    private JButton sbtn, rbtn;

    public ChatDemo(){
        fr = new JFrame();
        fr.addWindowListener(this);
        ta = new JTextArea(20, 45);
        tf = new JTextField(45);

        pa1 = new JPanel();
        pa2 = new JPanel();
        sbtn = new JButton("Submit");
        rbtn = new JButton("Reset");

        sbtn.addActionListener(this);
        rbtn.addActionListener(this);

        fr.setLayout(new BorderLayout());
        fr.add(ta);
        ta.setEditable(false);
        fr.add(pa1, BorderLayout.SOUTH);

        pa1.setLayout(new GridLayout(2, 1));
        pa1.add(tf);
        pa1.add(pa2);

        pa2.setLayout(new FlowLayout());
        pa2.add(sbtn);
        pa2.add(rbtn);

        fr.pack();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(sbtn)){
            System.out.println("sbtn");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            ta.append(dtf.format(LocalDateTime.now()) + ": ");
            ta.append(tf.getText() + "\n");
            tf.setText("");
        }else if(actionEvent.getSource().equals(rbtn)){
            System.out.println("rbtn");
            ta.setText("");
        }
    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {
        File fi = new File("ChatDemo.dat");
        if (fi.exists()){
            try(
                    FileInputStream fin = new FileInputStream("ChatDemo.dat");
                    ObjectInputStream in = new ObjectInputStream(fin);)
            {
                this.ta.setText(""+(String) in.readObject());
            }catch (IOException i){
                i.printStackTrace();
            }catch (ClassNotFoundException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        try (
                FileOutputStream fout = new FileOutputStream("ChatDemo.dat");
                ObjectOutputStream oout = new ObjectOutputStream(fout);

        ){
            oout.writeObject(this.ta.getText());
            System.out.println("Serialized data is saved");
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {

    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {

    }

    public static void main(String[] args) {
        new ChatDemo();
    }
}
