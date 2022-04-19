package counterPack;
/*
 to remember;
 name first JPanel for example mainPanel
 DO NOT click custom create on any component.
 right-click on a button and add action listener (in component tree)
 set label opaque.
 horiz/vertAlign=Fill
preferred size 400x200
Align/Text Center
*/

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class counterForm {
    private JPanel mainPanel;
    private JButton buttonStart;
    private JButton stopButton;
    private JButton resetButton;
    private JLabel jL1;
    private Timer timer;
    private int hh,mm,ss;

    public static void main(String[] args) {
        JFrame frame = new JFrame("counterForm");
        frame.setContentPane(new counterForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    void showTime(){
        jL1.setText(String.format("%02d" , hh)+":"+String.format("%02d" ,mm)+":"+String.format("%02d" ,ss));
    }
    void incTime(){
        ss++;
        if (ss==60){
            mm++;
            ss=0;
            if (mm==60){
                hh++;
                mm=0;
            }
        }
        showTime();
    }

    public counterForm() {
        Timer timer=new Timer(1000,new ActionListener(){public void actionPerformed(ActionEvent e){incTime();}});
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });
        hh=mm=ss=0;
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hh=mm=ss=0;
                showTime();
            }
        });
    }
}
