import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class PoringConstructor implements ActionListener{
    private JFrame frame;
    private JButton addBtn;
    public static int NUM_PORINGS;
    public PoringConstructor(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addBtn = new JButton("Add");

        addBtn.addActionListener(this);

        frame.setLayout(new FlowLayout());
        frame.add(addBtn);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(addBtn)){
            NUM_PORINGS++;
            Poring poring = new Poring();
            Thread t = new Thread(poring);
            t.start();
        }
    }
}
