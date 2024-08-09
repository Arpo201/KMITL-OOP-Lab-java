import javax.swing.*;
import java.awt.*;

public class CountTimeNonstop extends JLabel implements Runnable{
    long startTime = System.currentTimeMillis();
    @Override
    public void run() {
        try {
            while (true){
                long nowTime = System.currentTimeMillis();
                long elapseTime = (nowTime - startTime)/1000;
                int hour = (int)elapseTime/3600;
                elapseTime = elapseTime%3600;
                int min = (int)elapseTime/60;
                elapseTime = elapseTime%60;
                int sec = (int)elapseTime;
                setFont(new Font("TimesRoman", Font.BOLD, 80));
                setText(String.format("%02d", hour) + ":" + String.format("%02d", min) + ":" + String.format("%02d", sec));
                System.out.println(elapseTime);
                Thread.sleep(1000);
            }
        }catch (InterruptedException ex){}
    }
}
