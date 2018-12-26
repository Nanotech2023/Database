import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CreateChart extends JFrame{
    private ArrayList<String> forDiagram;

    public CreateChart(String appTitle, String chartTitle, ArrayList<String> forDiagram)
    {
        this.forDiagram = forDiagram;
        PieDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset,chartTitle);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500,300));
        setContentPane(chartPanel);
    }


    private PieDataset createDataset() {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for(int i=0;i<forDiagram.size();++i)
        {
            if(map.containsKey(forDiagram.get(i)))
            {
                map.put(forDiagram.get(i), map.get(forDiagram.get(i))+1);
            }
            else {map.put(forDiagram.get(i), 1);}
        }

        DefaultPieDataset result = new DefaultPieDataset();

        for (Map.Entry entry : map.entrySet()) {
            result.setValue(entry.getKey().toString(), (Integer)entry.getValue());
        }
        return result;
    }
    private JFreeChart createChart(PieDataset dataset, String title)
    {
        JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, false);

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(90);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;
    }
}