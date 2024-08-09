import javax.swing.*;
import java.awt.*;


public class Stopwatch extends JLabel implements Runnable {
    int time;
    public Stopwatch(){
    }

    @Override
    public void run() {
        try {
            while (true){
                int calTime = time;
                int hour = calTime/3600;
                calTime = calTime%3600;
                int min = calTime/60;
                calTime = calTime%60;
                int sec = calTime;
                setFont(new Font("TimesRoman", Font.BOLD, 80));
                setText(String.format("%02d", hour) + ":" + String.format("%02d", min) + ":" + String.format("%02d", sec));
                Thread.sleep(1000);
                time++;
            }
        }catch (InterruptedException ex){}
    }

}
