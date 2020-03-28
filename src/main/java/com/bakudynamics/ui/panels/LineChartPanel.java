package com.bakudynamics.ui.panels;

import com.bakudynamics.ui.chart.ChartFactory;
import com.bakudynamics.ui.chart.LineChartFactory;
import com.bakudynamics.ui.chart.XYLineChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ui.ApplicationFrame;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class LineChartPanel extends ApplicationFrame {

    private final JFreeChart chart;
    private final List<ChartFactory> builders = Arrays.asList(new XYLineChartFactory(), new LineChartFactory());

    public LineChartPanel(PanelParams params) {
        super(params.getFrameTitle());
        chart = buildChart(params);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(params.getFrameWidth(), params.getFrameHeight()));
        setContentPane(chartPanel);
    }

    private JFreeChart buildChart(PanelParams params) {
        return builders.stream()
                .filter(it -> it.type() == params.getChartType())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No such chart factory!"))
                .create(params);
    }

    public JFreeChart getChart() {
        return chart;
    }
}