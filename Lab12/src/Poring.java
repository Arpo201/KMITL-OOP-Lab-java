import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Poring implements MouseListener, Runnable{
    private JFrame frame;
    private JLabel poring, numPoring;
    private ImageIcon poringImg;
    PoringConstructor pc;
    public Poring(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);

        poringImg = new ImageIcon("E:/OOP/Lab12/poring.png");
        poring = new JLabel(poringImg);
        numPoring = new JLabel(Integer.toString(pc.NUM_PORINGS));

        frame.setLayout(new FlowLayout());
        frame.add(poring);
        frame.add(numPoring);

        poring.addMouseListener(this);
        frame.setLocation((int)(Math.random()*1600), (int)(Math.random()*1080));
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void run() {
        try {
            while (true){
                int x = frame.getLocation().x + (int)(Math.random()*20);
                int y = frame.getLocation().y + (int)(Math.random()*20);
                frame.setLocation(x, y);
                Thread.sleep((int)(Math.random()*400));
                x = frame.getLocation().x - (int)(Math.random()*20);
                y = frame.getLocation().y - (int)(Math.random()*20);
                frame.setLocation(x, y);
            }
        }catch (InterruptedException ex){}
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getSource().equals(poring)){
            System.out.println("click on poring");
            frame.dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

//    public static void main(String[] args) {
//        new Poring();
//    }
}
