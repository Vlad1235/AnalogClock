//package example1;
//
//import javax.swing.*;
//import java.awt.*;
//import java.util.Calendar;
//
//public class ClockPanel extends JPanel {
//    private Clock clock;
//
//    public ClockPanel(Clock clock) {
//        setDoubleBuffered(true);
//        setPreferredSize(new Dimension(600, 400));
//        setClock(сlock);
//    }
//
//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//        if (clock != null) {
//            drawClock(g, clock);
//        }
//    }
//
//    private void drawCircle(Graphics g, Point center, int radius) {
//        g.setColor(Color.RED);
//        g.fillOval(center.x - radius / 2, center.y - radius / 2, radius, radius);
//    }
//
//    public Point convertCoordinatesToPanel(Point point) {
//        Point O = new Point(getSize().width / 2, getSize().height / 2);
//        return new Point(O.x + point.x, O.y - point.y);
//    }
//
//    private Point getEndPoint(double angle, int radius) {
//        Point O = new Point(getSize().width / 2, getSize().height / 2);
//        int x = (int) (O.x + radius * Math.cos(angle));
//        int y = (int) (O.y - radius * Math.sin(angle));
//        return new Point(x, y);
//    }
//
//
//    /**
//     * Метод рисует аналоговые часы с текущим временем.
//     * Магические числа:
//     * (Math.PI / 2) - отклонение 12 часов от горизонтали
//     * (Math.PI / x) = (2 * Math.PI / 2 * x) - сокращаем дроби, хотя не обязательно
//     *
//     */
//    private void drawClock(Graphics g) {
//        Point O = new Point(getSize().width / 2, getSize().height / 2);
//        int radiusClock = Math.min(O.x, O.y) - 20;
//        int radiusMinute = radiusClock - 10;
//        int radiusHour = radiusMinute - 20;
//        double angle;
//        for (int i = 1; i < 13; i++) {
//            angle = Math.PI / 2 - i * Math.PI / 6;
//            Point point = getEndPoint(angle, radiusClock);
//            drawCircle(g, point, 8);
//        }
//        Calendar time = Calendar.getInstance();
//        int hour = time.get(Calendar.HOUR_OF_DAY);
//        int minute = time.get(Calendar.MINUTE);
//        int second = time.get(Calendar.SECOND);
//        angle = Math.PI / 2 - (hour + minute / 60.0) * Math.PI / 6;
//        Point point = getEndPoint(angle, radiusHour);
//        g.setColor(Color.GREEN);
//        g.drawLine(O.x, O.y, point.x, point.y);
//
//        angle = Math.PI / 2 - (minute + second / 60.0) * Math.PI / 30;
//        point = getEndPoint(angle, radiusMinute);
//        g.setColor(Color.GRAY);
//        g.drawLine(O.x, O.y, point.x, point.y);
//
//        angle = Math.PI / 2 - second * Math.PI / 30;
//        point = getEndPoint(angle, radiusMinute);
//        g.setColor(Color.RED);
//        g.drawLine(O.x, O.y, point.x, point.y);
//    }
//
//}
