import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
public class BookView implements ActionListener, WindowListener{
    private ArrayList list = new ArrayList();
    private BookAdd bookAdd;
    private Book book;
    private JFrame frame;
    private JPanel panel1, panel2, panel3, panel4;
    private JLabel name, price, type;
    private JTextField nameFi, priceFi, seq;
    private JComboBox typeCom;
    private JButton previous, next, add, update, delete;

    public BookView(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(this);
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();

        //body
        name = new JLabel("  Name");
        price = new JLabel("  Price");
        type = new JLabel("  Type");
        nameFi = new JTextField("");
        priceFi = new JTextField("");
        typeCom = new JComboBox();

        //South line 1
        seq = new JTextField("0", 4);
        previous = new JButton("<<<");
        next = new JButton(">>>");
        previous.addActionListener(this);
        next.addActionListener(this);

        //South line 2
        add = new JButton("Add");
        update = new JButton("Update");
        delete = new JButton("Delete");
        add.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);

        frame.setLayout(new BorderLayout());
        frame.add(panel1);
        frame.add(BorderLayout.SOUTH, panel2);

        panel1.setLayout(new GridLayout(3, 2));
        panel1.add(name);
        panel1.add(nameFi);
        panel1.add(price);
        panel1.add(priceFi);
        panel1.add(type);
        panel1.add(typeCom);
        typeCom.addItem("General");
        typeCom.addItem("Computer");
        typeCom.addItem("Math&Sci");
        typeCom.addItem("Photo");

        panel2.setLayout(new GridLayout(2,1));
        panel2.add(panel3);
        panel2.add(panel4);

        panel3.setLayout(new FlowLayout());
        panel3.add(previous);
        panel3.add(seq);
        panel3.add(next);

        panel4.add(add);
        panel4.add(update);
        panel4.add(delete);

        frame.setSize(300, 250);
        frame.setVisible(true);

        bookAdd = new BookAdd();
        bookAdd.getInsert().addActionListener(this);
    }

    public void autoSet(){
        int nowSeq = Integer.parseInt(seq.getText());
        if (nowSeq == 0){
            this.nameFi.setText("");
            this.priceFi.setText("");
            this.typeCom.setSelectedIndex(0);
        }else {
            Book nowBook = (Book)list.get(nowSeq);
            this.nameFi.setText(nowBook.getName());
            this.priceFi.setText(Double.toString(nowBook.getPrice()));
            this.typeCom.setSelectedItem(nowBook.getType());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(add)){
            bookAdd.getAddFrame().setVisible(true);
        }else if(ae.getSource().equals(bookAdd.getInsert())) {
            String insertName = bookAdd.getAddName().getText();
            double insertPrice = Double.parseDouble(bookAdd.getAddPrice().getText());
            String insertType = bookAdd.getAddType().getSelectedItem().toString();
            System.out.println(insertName + " - " + insertPrice + " - " + insertType);
            book = new Book(insertName, insertPrice, insertType);
            list.add(book);
            JOptionPane.showMessageDialog(bookAdd.getAddFrame(), "Done it.", "",1);
            bookAdd.getAddFrame().dispose();
        }else if(ae.getSource().equals(previous)){
            if (!seq.getText().equals("1") && !seq.getText().equals("0")){
                seq.setText(Integer.toString(Integer.parseInt(seq.getText())-1));
                autoSet();
            }
        }else if(ae.getSource().equals(next)){
            if (Integer.parseInt(seq.getText()) < list.size()-1){
                seq.setText(Integer.toString(Integer.parseInt(seq.getText())+1));
                autoSet();
            }
        }else if (ae.getSource().equals(update)){
            Book nowBook = (Book)this.list.get(Integer.parseInt(seq.getText()));
            nowBook.setName(this.nameFi.getText());
            nowBook.setPrice(Double.parseDouble(this.priceFi.getText()));
            nowBook.setType(this.typeCom.getSelectedItem().toString());
            JOptionPane.showMessageDialog(bookAdd.getAddFrame(), "Done it.", "Update Command",1);
        }else if (ae.getSource().equals(delete)){
            int nowSeq = Integer.parseInt(this.seq.getText());
            if (nowSeq != 0){
                this.list.remove(nowSeq);
                this.seq.setText(Integer.toString(Integer.parseInt(this.seq.getText())-1));
                JOptionPane.showMessageDialog(bookAdd.getAddFrame(), "Done it.", "Delete Command",1);
                autoSet();
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {
        try(
                FileInputStream fin = new FileInputStream("Book.data");
                ObjectInputStream oin = new ObjectInputStream(fin);
        )
        {
            list = (ArrayList) oin.readObject();
            if (list.size() > 1){
                seq.setText("1");
                autoSet();
            }
        }catch (IOException ex){
            list.add(new Book());
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        System.out.println("Arraylist size has" + list.size());
        if (list.size() > 1){
            try(
                    FileOutputStream fout = new FileOutputStream("Book.data");
                    ObjectOutputStream oout = new ObjectOutputStream(fout);
            )
            {
                oout.writeObject(list);
            }catch (IOException ex){
                ex.printStackTrace();
            }
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
        new BookView();
    }
}
