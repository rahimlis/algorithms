package com.bakudynamics.ui;

import com.bakudynamics.ui.chart.ChartType;
import com.bakudynamics.ui.panels.LineChartPanel;
import com.bakudynamics.ui.panels.PanelParams;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.xy.XYDataset;

public class UI {

    public static void plotXYLineChart(String chartTitle, String xAxisLabel, String yAxisLabel, XYDataset dataset, int xTick) {
        var chartPanel = createLineChart(ChartType.XY_LINE_CHART, chartTitle, xAxisLabel, yAxisLabel, dataset);
        chartPanel.pack();
        chartPanel.setVisible(true);

        var plot = (XYPlot) chartPanel.getChart().getPlot();
        final var xAxis = (NumberAxis) plot.getDomainAxis();
        xAxis.setTickUnit(new NumberTickUnit(xTick));
    }

    public static void plotCategoryLineChart(String chartTitle, String xAxisLabel, String yAxisLabel, CategoryDataset dataset) {
        var chartPanel = createLineChart(ChartType.LINE_CHART, chartTitle, xAxisLabel, yAxisLabel, dataset);
        chartPanel.pack();
        chartPanel.setVisible(true);
    }

    private static LineChartPanel createLineChart(ChartType chartType,
                                                  String chartTitle,
                                                  String xAxisLabel,
                                                  String yAxisLabel,
                                                  Dataset dataset) {
        var params = new PanelParams.Builder(chartType)
                .setChartTitle(chartTitle)
                .setCategoryAxisLabel(xAxisLabel)
                .setValueAxisLabel(yAxisLabel)
                .setDataset(dataset)
                .build();
        return new LineChartPanel(params);
    }
}
