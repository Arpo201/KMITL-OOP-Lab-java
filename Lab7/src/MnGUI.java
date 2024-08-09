import javax.swing.*;
import java.awt.*;

public class MnGUI {
    private JFrame fr;
    private JDesktopPane jdp;
    private JInternalFrame app1, app2, app3;
    private JMenuBar mb;
    private JMenu m1, m2, m3, mi1;
    private JMenuItem mi2, mi3, mi4;
    private JMenuItem mi11, mi12;
    public MnGUI(){
        fr = new JFrame();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jdp = new JDesktopPane();
        jdp.setBackground(Color.BLACK);

        app1 = new JInternalFrame("Application 01", true, true, true, true);
        app1.setSize(300,200);
        app1.setVisible(true);
        jdp.add(app1);

        app2 = new JInternalFrame("Application 02", true, true, true, true);
        app2.setSize(350,200);
        app2.setVisible(true);
        jdp.add(app2);

        app3 = new JInternalFrame("Application 03", true, true, true, true);
        app3.setSize(400,250);
        app3.setVisible(true);
        jdp.add(app3);

        fr.add(jdp);

        mb = new JMenuBar();
        m1 = new JMenu("File");
        m2 = new JMenu("Edit");
        m3 = new JMenu("View");
        fr.setJMenuBar(mb);
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        mi1 = new JMenu("New");
        mi2 = new JMenuItem("Open");
        mi3 = new JMenuItem("Save");
        mi4 = new JMenuItem("Exit");
        m1.add(mi1);
        m1.addSeparator();
        m1.add(mi2);
        m1.addSeparator();
        m1.add(mi3);
        mi11 = new JMenuItem("Window");
        mi12 = new JMenuItem("Message");
        mi1.add(mi11);
        mi1.addSeparator();
        mi1.add(mi12);
        fr.setSize(800,800);
        fr.setVisible(true);
    }
    public static void main(String[] args) {
        new MnGUI();
    }
}
