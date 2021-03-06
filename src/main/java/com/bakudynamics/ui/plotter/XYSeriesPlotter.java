package com.bakudynamics.ui.plotter;

import com.bakudynamics.ui.UI;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.HashMap;
import java.util.Map;

public class XYSeriesPlotter implements RunningTimePlotter {

    private final XYSeriesCollection dataset = new XYSeriesCollection();
    private final Map<String, XYSeries> seriesMap = new HashMap<>();

    private final int max, min;

    public XYSeriesPlotter(int max, int min) {
        this.max = max;
        this.min = min;
    }

    @Override
    public void addDataPoint(String tag, int inputSize, double runningTime) {
        var series = seriesMap.get(tag);
        if (series == null) {
            series = new XYSeries(tag);
            dataset.addSeries(series);
            seriesMap.put(tag, series);
        }
        series.add(inputSize, runningTime);
    }

    @Override
    public void plot(String title, String xAxis, String yAxis) throws Exception {
        UI.plotXYLineChart(title, xAxis, yAxis, dataset, calculateTick());
        synchronized (this) {
            wait();
        }
    }

    private int calculateTick() {
        return (max - min) / 10;
    }
}
