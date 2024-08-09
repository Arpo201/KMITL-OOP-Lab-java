import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class StudentView implements ActionListener, WindowListener{
    private JFrame fr;
    private JPanel pa1, pa2;
    private JLabel idL, nameL, moneyL;
    private JTextField idF, nameF, moneyF;
    private JButton depoBtn, withBtn;
    public StudentView(){
        fr = new JFrame();
        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pa1 = new JPanel();
        pa2 = new JPanel();
        idL = new JLabel("  ID:");
        nameL = new JLabel("  Name:");
        moneyL = new JLabel("  Money:");
        idF = new JTextField();
        nameF = new JTextField();
        moneyF = new JTextField("0");
        depoBtn = new JButton("Deposit");
        withBtn = new JButton("Withdraw");

        fr.addWindowListener(this);
        depoBtn.addActionListener(this);
        withBtn.addActionListener(this);

        fr.setLayout(new BorderLayout());
        fr.add(pa1);
        fr.add(pa2, BorderLayout.SOUTH);

        pa1.setLayout(new GridLayout(3, 2));
        pa1.add(idL);
        pa1.add(idF);
        pa1.add(nameL);
        pa1.add(nameF);
        pa1.add(moneyL);
        pa1.add(moneyF);
        moneyF.setEditable(false);

        pa2.setLayout(new FlowLayout());
        pa2.add(depoBtn);
        pa2.add(withBtn);

        fr.setSize(250,150);
        fr.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(depoBtn)){
            this.moneyF.setText(Integer.toString(Integer.parseInt(this.moneyF.getText()) + 100));
        }else if(ae.getSource().equals(withBtn)){
            this.moneyF.setText(Integer.toString(Integer.parseInt(this.moneyF.getText()) - 100));
        }
    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {
        File file = new File("StudentM.dat");
        if(file.exists()){
            try(
                    FileInputStream fin = new FileInputStream("StudentM.dat");
                    ObjectInputStream oin = new ObjectInputStream(fin);
            )
            {
                Student std = (Student) oin.readObject();
                this.idF.setText("" + std.getID());
                this.nameF.setText(std.getName());
                this.moneyF.setText("" + std.getMoney());
            }catch (IOException ex){
                ex.printStackTrace();
            }catch (ClassNotFoundException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        try (
                FileOutputStream fout = new FileOutputStream("StudentM.dat");
                ObjectOutputStream oout = new ObjectOutputStream(fout);
                )
        {
            String strName = this.nameF.getText();
            int intID = Integer.parseInt(this.idF.getText());
            int intMoney = Integer.parseInt(this.moneyF.getText());
            Student std = new Student(strName, intID, intMoney);
            oout.writeObject(std);
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
        new StudentView();
    }
}
