package com.bakudynamics.ui.plotter;

public interface RunningTimePlotter {
    void addDataPoint(String tag, int inputSize, double runningTime);

    void plot(String title, String xAxis, String yAxis) throws Exception;
}
