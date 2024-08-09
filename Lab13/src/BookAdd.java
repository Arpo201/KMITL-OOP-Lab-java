import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BookAdd {
    private JFrame addFrame;
    private JPanel addPanel1, addPanel2;
    private JLabel name, price, type;
    private JTextField addName, addPrice;
    private JComboBox addType;
    private JButton insert;
    public BookAdd(){
        addFrame = new JFrame();
        addPanel1 = new JPanel();
        addPanel2 = new JPanel();
        name = new JLabel("Name");
        price = new JLabel("Price");
        type = new JLabel("Type");
        addName = new JTextField("");
        addPrice = new JTextField("");
        addType = new JComboBox();
        insert = new JButton("Insert");

        addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addFrame.setLayout(new BorderLayout());

        addFrame.add(addPanel1);
        addFrame.add(BorderLayout.SOUTH, addPanel2);

        addPanel1.setLayout(new GridLayout(3,2));
        addPanel1.add(name);
        addPanel1.add(addName);
        addPanel1.add(price);
        addPanel1.add(addPrice);
        addPanel1.add(type);
        addPanel1.add(addType);
        addType.addItem("General");
        addType.addItem("Computer");
        addType.addItem("Math&Sci");
        addType.addItem("Photo");

        addPanel2.add(insert);

        addFrame.setSize(300, 150);
    }

    public JFrame getAddFrame() {
        return addFrame;
    }

    public void setAddFrame(JFrame addFrame) {
        this.addFrame = addFrame;
    }

    public JPanel getAddPanel1() {
        return addPanel1;
    }

    public void setAddPanel1(JPanel addPanel1) {
        this.addPanel1 = addPanel1;
    }

    public JPanel getAddPanel2() {
        return addPanel2;
    }

    public void setAddPanel2(JPanel addPanel2) {
        this.addPanel2 = addPanel2;
    }

    public JLabel getName() {
        return name;
    }

    public void setName(JLabel name) {
        this.name = name;
    }

    public JLabel getPrice() {
        return price;
    }

    public void setPrice(JLabel price) {
        this.price = price;
    }

    public JLabel getType() {
        return type;
    }

    public void setType(JLabel type) {
        this.type = type;
    }

    public JTextField getAddName() {
        return addName;
    }

    public void setAddName(JTextField addName) {
        this.addName = addName;
    }

    public JTextField getAddPrice() {
        return addPrice;
    }

    public void setAddPrice(JTextField addPrice) {
        this.addPrice = addPrice;
    }

    public JComboBox getAddType() {
        return addType;
    }

    public void setAddType(JComboBox addType) {
        this.addType = addType;
    }

    public JButton getInsert() {
        return insert;
    }

    public void setInsert(JButton insert) {
        this.insert = insert;
    }
}
