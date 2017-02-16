import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;



public class TimerGUI extends JFrame {

    JLabel promptLable, timerLable;
    //int count;
    JTextField text;
    JButton button;
    Timer timer;



    //constructor
    public TimerGUI(){
        //put items on the screen
        setLayout(new GridLayout(2, 2, 5, 5));

        promptLable = new JLabel("Enter the number");
        add(promptLable);

        text = new JTextField(5);
        add(text);

        button = new JButton("start timing");
        add(button);

        timerLable = new JLabel("waiting", SwingConstants.CENTER);
        add(timerLable);

        event e = new event();
        button.addActionListener(e);

    }

    public class event implements ActionListener {

        public void actionPerformed(ActionEvent e){
            // convert to int

            int count = (int) (Double.parseDouble(text.getText()));
            timerLable.setText("Time Left"+ count);


            TimeClass tc = new TimeClass(count);
            timer = new Timer(1000, tc);
            timer.start();
        }

    }



    public class TimeClass implements ActionListener{
        int counter;

        public TimeClass(int counter){
            this.counter = counter;
        }

        public void actionPerformed(ActionEvent tc){
            counter-- ;

            if(counter >= 1){
                timerLable.setText("Time left"+ counter);
            }else {
                timer.stop();
                timerLable.setText("DONE");
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }

    public static void main(String[] args){

        TimerGUI ob = new TimerGUI();
        ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ob.pack();
        ob.setVisible(true);

    }
}
