import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class MyTextEditor implements ActionListener {
    private JFrame frame;
    private JPanel panal;
    private JTextArea textarea;
    private JMenuBar menubar;
    private JMenu menu;
    private JMenuItem redoc, open, save, close;
    public MyTextEditor(){
        frame = new JFrame("My Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panal = new JPanel();
        textarea = new JTextArea();
        menubar = new JMenuBar();
        menu = new JMenu("File");
        redoc = new JMenuItem("New");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        close = new JMenuItem("Close");

        redoc.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        close.addActionListener(this);

        frame.setLayout(new BorderLayout());
        frame.add(panal);
        panal.setLayout(new BorderLayout());
        panal.add(textarea);

        frame.setJMenuBar(menubar);
        menubar.add(menu);
        menu.add(redoc);
        menu.add(open);
        menu.add(save);
        menu.add(new JSeparator());
        menu.add(close);

        frame.setSize(600,400);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(redoc)){
            textarea.setText("");
        }else if(ae.getSource().equals(open)){
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(frame);
            File file = fc.getSelectedFile();
            try(
                    FileInputStream fin = new FileInputStream(file);
                    ObjectInputStream oin = new ObjectInputStream(fin);
            )
            {
                this.textarea.setText(""+(String) oin.readObject());
                System.out.println("Get data from " + file);
            }catch (IOException ex){
                ex.printStackTrace();
            }catch (ClassNotFoundException ex){
                ex.printStackTrace();
            }
        }else if (ae.getSource().equals(save)) {
            JFileChooser fc = new JFileChooser();
            fc.showSaveDialog(frame);
            File file = fc.getSelectedFile();
            try(
                    FileOutputStream fout = new FileOutputStream(file);
                    ObjectOutputStream owrite = new ObjectOutputStream(fout);
                )
            {
                owrite.writeObject(this.textarea.getText());
                System.out.println("Data is saved at " + file);
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }else if(ae.getSource().equals(close)){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new MyTextEditor();
    }
}
