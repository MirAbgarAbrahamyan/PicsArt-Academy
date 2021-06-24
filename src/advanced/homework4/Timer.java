package advanced.homework4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Timer implements ActionListener {
    private JTextField minutesTextField;
    private JTextField secondsTextField;
    private JTextField outputTextField;
    private JButton startButton;
    SwingWorker<Void, String> worker;

    public Timer() {
        JFrame screen = new JFrame();
        minutesTextField = new JTextField();
        minutesTextField.setBounds(75, 50, 150, 20);
        secondsTextField = new JTextField();
        secondsTextField.setBounds(75, 100, 150, 20);
        outputTextField = new JTextField();
        outputTextField.setBounds(75, 150, 150, 20);
        outputTextField.setEditable(false);
        startButton = new JButton("Start");
        startButton.setBounds(50, 200, 200, 50);
        startButton.addActionListener(this);
        screen.add(minutesTextField);
        screen.add(secondsTextField);
        screen.add(outputTextField);
        screen.add(startButton);
        screen.setSize(300, 300);
        screen.setResizable(false);
        screen.setLayout(null);
        screen.setVisible(true);
        screen.setLocationRelativeTo(null);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String minutesStr = minutesTextField.getText();
        String secondsStr = secondsTextField.getText();
        long minutes = Long.parseLong(minutesStr);
        long seconds = Long.parseLong(secondsStr);
        startTimer(minutes, seconds);
    }

    boolean isOneDigit(long n) {
        if (n == 0)
            return true;
        return (int) Math.floor(Math.log10(n) + 1) == 1;
    }

    void startTimer(long minutes, long seconds) {
//        if (worker != null)
//            System.out.println(worker.getState());
        if (worker != null && !worker.isDone()) {
            worker.cancel(true);
            //System.out.println(worker.cancel(true));
        }
        if (seconds >= 60) {
            minutes += seconds / 60;
            seconds = seconds % 60;
        }
        final long m = minutes;
        final long s = seconds;
        worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() {
                long min = m;
                long sec = s;
                //System.out.println(worker.isCancelled());
                //System.out.println(getState() == StateValue.DONE);
                while ((min != 0 || sec != 0) && !(getState() == StateValue.DONE)) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        // nothing here
                    }
                    if (sec == 0) {
                        min--;
                        sec = 60;
                    }
                    sec--;
                    String result = (isOneDigit(min) ? "0" + min : min) +
                            (isOneDigit(sec) ? "::0" : "::") + sec;
                    //System.out.println(result);
                    publish(result);
                }
                return null;
            }

            @Override
            protected void process(List<String> items) {
                if(isCancelled())
                    return;
                String latestItem = items.get(items.size() - 1);
                outputTextField.setText(latestItem);
            }

            /*
            @Override
            protected void done() {
                System.out.println("AGSHDB");
            }
            */
        };
        worker.execute();
    }

    public static void main(String[] args) {
        new Timer();
    }
}
