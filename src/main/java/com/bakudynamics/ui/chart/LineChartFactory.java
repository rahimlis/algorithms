package com.bakudynamics.ui.chart;

import com.bakudynamics.ui.panels.PanelParams;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;

public class LineChartFactory implements ChartFactory {

    @Override
    public ChartType type() {
        return ChartType.LINE_CHART;
    }

    @Override
    public JFreeChart create(PanelParams params) {
        return org.jfree.chart.ChartFactory.createLineChart(
                params.getChartTitle(),
                params.getCategoryAxisLabel(),
                params.getValueAxisLabel(),
                (CategoryDataset) params.getDataset(),
                params.getPlotOrientation(),
                params.isShowLegend(),
                params.isShowToolTips(),
                params.isShowUrls());
    }
}
