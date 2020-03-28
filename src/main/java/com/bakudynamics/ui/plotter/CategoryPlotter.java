package com.bakudynamics.ui.plotter;

import com.bakudynamics.ui.UI;
import org.jfree.data.category.DefaultCategoryDataset;

public class CategoryPlotter implements RunningTimePlotter {

    private final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    @Override
    public void addDataPoint(String tag, int inputSize, double runningTime) {
        dataset.addValue(runningTime, tag, Integer.valueOf(inputSize));
    }

    @Override
    public void plot(String title, String xAxis, String yAxis) throws Exception {
        UI.plotCategoryLineChart(title, xAxis, yAxis, dataset);
        synchronized (this) {
            wait();
        }
    }
}
