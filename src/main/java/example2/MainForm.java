//package example2;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Timer;
//
//public class MainForm extends javax.swing.JFrame {
//
//        private Timer ClockTimer = new Timer(500, new Clock());
//
//        public MainForm() {
//            ClockTimer.start();
//        }
//
//        class Clock implements ActionListener {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                // *** For DATE : 2013.12.12
//                Date d = new Date();
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy.dd.MM");
//                YOUR_LABEL.setText(sdf.format(d));
//
//                // *** For TIME : 22:33:22
//                DateFormat df = new SimpleDateFormat("HH:mm:ss");
//                Date time = Calendar.getInstance().getTime();
//                String reportDate = df.format(time);
//                YOUR_LABEL.setText(reportDate);
//            }
//        }
//}
