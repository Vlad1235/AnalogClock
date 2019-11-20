package example2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ClockForm extends JFrame {
        JLabel l=new JLabel();
        private Timer ClockTimer = new Timer(500, new Clock());

        public ClockForm() {
            ClockTimer.start();
            add(l);
        }

        class Clock implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

                // *** For DATE : 2013.12.12
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy.dd.MM");
                l.setText(sdf.format(d));

                // *** For TIME : 22:33:22
                DateFormat df = new SimpleDateFormat("HH:mm:ss");
                Date time = Calendar.getInstance().getTime();
                String reportDate = df.format(time);
                l.setText(reportDate);
            }
        }

        public static void main(String[] args) {
            ClockForm m = new ClockForm();
            m.setSize(300, 300);
            m.setVisible(true); // делаем фрейм видимым
        }
}

