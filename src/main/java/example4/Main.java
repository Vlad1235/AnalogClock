package example4;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.swing.JFrame;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.dial.DialPlot;
import org.jfree.chart.plot.dial.DialPointer.Pin;
import org.jfree.chart.plot.dial.DialPointer.Pointer;
import org.jfree.chart.plot.dial.StandardDialFrame;
import org.jfree.chart.plot.dial.StandardDialScale;
import org.jfree.data.general.DefaultValueDataset;

public class Main extends JFrame {
    private static final long serialVersionUID = 1L;

    public Main() {
        super("JFreeChart Clock");
        setSize(600, 600);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        //Создание шкалы для часов.
        StandardDialScale clock = new StandardDialScale();
        //Нижнее значение на шкале.
        clock.setLowerBound(0);
        //Верхнее значение на шкале.
        clock.setUpperBound(12);
        //Угол, с которого начинается рисование шкалы.
        clock.setStartAngle(90);
        //Угол сектора, в котором будет находится шкала.
        clock.setExtent(-360);
        //Форматирования меток шкалы.
        clock.setTickLabelFormatter(new DecimalFormat(""));
        //Радиус шкалы.
        clock.setTickRadius(.85);
        //Запрет на отображение первой метки на шкале(для часов то не нужно).
        clock.setFirstTickLabelVisible(false);
        //Шаг на шкале.
        clock.setMajorTickIncrement(1);
        //Количество промежуточных отметок на шкале.
        clock.setMinorTickCount(4);
        //Объект для хранения и отображения значения часов.
        final DefaultValueDataset timeH = new DefaultValueDataset();
        timeH.setValue(0);
        //Объект для хранения и отображения значения минут.
        final DefaultValueDataset timeM = new DefaultValueDataset();
        timeM.setValue(0);
        //Объект для хранения и отображения значения секунд.
        final DefaultValueDataset timeS = new DefaultValueDataset();
        timeS.setValue(0);

        //Часовая стрелка.
        Pointer hours = new Pointer();
        hours.setRadius(.6);
        hours.setWidthRadius(.03);
        //Установка датасета, значение которого должна отображать эта стрелка.
        hours.setDatasetIndex(0);
        hours.setVisible(true);

        //Минутная стрелка.
        Pointer minuts = new Pointer();
        minuts.setRadius(.8);
        minuts.setWidthRadius(.03);
        minuts.setDatasetIndex(1);
        minuts.setVisible(true);

        //Секундная стрелка.
        Pin seconds = new Pin();
        seconds.setRadius(.85);
        seconds.setDatasetIndex(2);
        seconds.setVisible(true);

        //Внешняя граница фрейма.
        StandardDialFrame dl = new StandardDialFrame();
        dl.setRadius(.9);
        dl.setVisible(true);

        //Фрейм в центре.
        StandardDialFrame dlC = new StandardDialFrame();
        dlC.setRadius(.03);
        dlC.setVisible(true);

        //Собственно, график.
        DialPlot plot = new DialPlot();
        //Добавление шкалы.
        plot.addScale(0, clock);
        //Установка датасетов.
        //Часы.
        plot.setDataset(0, timeH);
        //Минуты.
        plot.setDataset(1, timeM);
        //Секунды.
        plot.setDataset(2, timeS);
        //Установка стрелок.
        //Часовая.
        plot.addPointer(hours);
        //Минутная.
        plot.addPointer(minuts);
        //Секундная
        plot.addPointer(seconds);
        plot.setDialFrame(dl);
        plot.addLayer(dlC);

        //Создание объекта диаграммы.
        JFreeChart ClockChart = new JFreeChart("Moscow Time", plot);
        //Создания фрейма для отображения диаграммы.
        ChartFrame ClockFrame = new ChartFrame("Clock", ClockChart);

        //Отображения диаграммы на контексте JFrame'а.
        getContentPane().add(ClockFrame.getContentPane());
//##############################################################################
    Thread time = new Thread(new Runnable() {
            //Поток, который будет имитировать ход часов.
            /***/
            public void run() {
                GregorianCalendar gc = new GregorianCalendar(TimeZone.getTimeZone("GMT+3"));
                int c = gc.get(GregorianCalendar.HOUR_OF_DAY) * 60 * 60 +
                        gc.get(GregorianCalendar.MINUTE) * 60 +
                        gc.get(GregorianCalendar.SECOND);
                for (;;)
                try
                {
                    c = (c + 1) % 86400;
                    timeH.setValue(((c / 3600.0)));
                    timeM.setValue((c * .2 / 60.0));
                    timeS.setValue((c * .2) % 12.0);
                    Thread.sleep(1000);
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        });
            time.start();
            setVisible(true);
    }

        public static void main (String[] args) {
            new Main();
        }
}

