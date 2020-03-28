package com.bakudynamics.ui.chart;

import com.bakudynamics.ui.panels.PanelParams;
import org.jfree.chart.JFreeChart;

public interface ChartFactory {

    ChartType type();

    JFreeChart create(PanelParams params);
}