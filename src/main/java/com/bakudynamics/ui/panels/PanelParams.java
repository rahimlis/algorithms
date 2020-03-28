package com.bakudynamics.ui.panels;

import com.bakudynamics.ui.chart.ChartType;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.Dataset;

public class PanelParams {

    private final ChartType chartType;
    private final String frameTitle;
    private final String chartTitle;
    private final String categoryAxisLabel;
    private final String valueAxisLabel;
    private final Dataset dataset;
    private final PlotOrientation plotOrientation;
    private final boolean showLegend;
    private final boolean showToolTips;
    private final boolean showUrls;
    private final int frameWidth;
    private final int frameHeight;

    public PanelParams(ChartType chartType,
                       String frameTitle,
                       String chartTitle,
                       String categoryAxisLabel,
                       String valueAxisLabel,
                       Dataset dataset,
                       PlotOrientation plotOrientation,
                       boolean showLegend,
                       boolean showToolTips,
                       boolean showUrls,
                       int frameWidth,
                       int frameHeight) {
        this.chartType = chartType;
        this.frameTitle = frameTitle;
        this.chartTitle = chartTitle;
        this.categoryAxisLabel = categoryAxisLabel;
        this.valueAxisLabel = valueAxisLabel;
        this.dataset = dataset;
        this.plotOrientation = plotOrientation;
        this.showLegend = showLegend;
        this.showToolTips = showToolTips;
        this.showUrls = showUrls;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
    }

    public ChartType getChartType() {
        return chartType;
    }

    public String getFrameTitle() {
        return frameTitle;
    }

    public String getChartTitle() {
        return chartTitle;
    }

    public String getCategoryAxisLabel() {
        return categoryAxisLabel;
    }

    public String getValueAxisLabel() {
        return valueAxisLabel;
    }

    public Dataset getDataset() {
        return dataset;
    }

    public PlotOrientation getPlotOrientation() {
        return plotOrientation;
    }

    public boolean isShowLegend() {
        return showLegend;
    }

    public boolean isShowToolTips() {
        return showToolTips;
    }

    public boolean isShowUrls() {
        return showUrls;
    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public int getFrameHeight() {
        return frameHeight;
    }

    public static class Builder {
        private final ChartType chartType;
        private String frameTitle = "Title";
        private String chartTitle = "Chart";
        private String categoryAxisLabel = "X Axis";
        private String valueAxisLabel = "Y Axis";
        private Dataset dataset;
        private PlotOrientation plotOrientation = PlotOrientation.VERTICAL;
        private boolean showLegend = true;
        private boolean showToolTips = true;
        private boolean showUrls = false;
        private int frameWidth = 1024;
        private int frameHeight = 768;

        public Builder(ChartType chartType) {
            this.chartType = chartType;
        }

        public Builder setFrameTitle(String frameTitle) {
            this.frameTitle = frameTitle;
            return this;
        }

        public Builder setChartTitle(String chartTitle) {
            this.chartTitle = chartTitle;
            return this;
        }

        public Builder setCategoryAxisLabel(String categoryAxisLabel) {
            this.categoryAxisLabel = categoryAxisLabel;
            return this;
        }

        public Builder setValueAxisLabel(String valueAxisLabel) {
            this.valueAxisLabel = valueAxisLabel;
            return this;
        }

        public Builder setDataset(Dataset dataset) {
            this.dataset = dataset;
            return this;
        }

        public Builder setPlotOrientation(PlotOrientation plotOrientation) {
            this.plotOrientation = plotOrientation;
            return this;
        }

        public Builder setShowLegend(boolean showLegend) {
            this.showLegend = showLegend;
            return this;
        }

        public Builder setShowToolTips(boolean showToolTips) {
            this.showToolTips = showToolTips;
            return this;
        }

        public Builder setShowUrls(boolean showUrls) {
            this.showUrls = showUrls;
            return this;
        }

        public Builder setFrameWidth(int frameWidth) {
            this.frameWidth = frameWidth;
            return this;
        }

        public Builder setFrameHeight(int frameHeight) {
            this.frameHeight = frameHeight;
            return this;
        }

        public PanelParams build() {
            return new PanelParams(
                    chartType,
                    frameTitle,
                    chartTitle,
                    categoryAxisLabel,
                    valueAxisLabel,
                    dataset,
                    plotOrientation,
                    showLegend,
                    showToolTips,
                    showUrls,
                    frameWidth,
                    frameHeight);
        }
    }
}
