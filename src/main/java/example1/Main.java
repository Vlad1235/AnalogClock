//package example1;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Main {
//    public static void main(String[] args) throws Exception {
//        JFrame f = new JFrame("Часики");
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setLayout(new BorderLayout());
//
//        final ClockPanel clockPanel = new ClockPanel();
//        clockPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
//
//        f.add(clockPanel, BorderLayout.CENTER);
//        f.pack();
//        f.setVisible(true);
//
//        Timer timer = new Timer(500, new ActionListener() {
//
//            public void actionPerformed(ActionEvent e) {
//                clockPanel.repaint();
//            }
//        });
//        timer.start();
//    }
//}
