package com.bakudynamics.ui.chart;

import com.bakudynamics.ui.panels.PanelParams;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;

public class XYLineChartFactory implements ChartFactory {

    @Override
    public ChartType type() {
        return ChartType.XY_LINE_CHART;
    }

    @Override
    public JFreeChart create(PanelParams params) {
        return org.jfree.chart.ChartFactory.createXYLineChart(
                params.getChartTitle(),
                params.getCategoryAxisLabel(),
                params.getValueAxisLabel(),
                (XYDataset) params.getDataset(),
                params.getPlotOrientation(),
                params.isShowLegend(),
                params.isShowToolTips(),
                params.isShowUrls());
    }
}
