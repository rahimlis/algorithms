package com.bakudynamics.sort;

import com.bakudynamics.input.RandomIntArraySource;
import com.bakudynamics.ui.plotter.RunningTimePlotter;
import com.bakudynamics.ui.plotter.XYSeriesPlotter;
import com.bakudynamics.utils.Logger;

import java.util.List;

public class ComplexityAnalysis {

    public static final int MIN_INPUT_SIZE = 0;
    public static final int MAX_INPUT_SIZE = 15000000;
    public static final int INCREMENT_SIZE = 250000;

    private final RunningTimePlotter plotter = new XYSeriesPlotter(MAX_INPUT_SIZE, MIN_INPUT_SIZE);

    public static void main(String[] args) throws Exception {
        ComplexityAnalysis analysis = new ComplexityAnalysis();
        List<Sort> sortingAlgorithms = List.of(
                new MergeSort(),
                new InsertionSort(),
                new BubbleSort()
        );

        for (Sort sortingAlgorithm : sortingAlgorithms) {
            analysis.analyze(sortingAlgorithm);
        }

        analysis.plot();
    }

    public void analyze(Sort sort) {
        var inputSource = new RandomIntArraySource(MIN_INPUT_SIZE, MAX_INPUT_SIZE, INCREMENT_SIZE);
        //var inputSource = new FileInputSource();

        while (inputSource.hasNext()) {
            int[] input = inputSource.next();
            run(sort, input);
        }
    }

    public void plot() throws Exception {
        plotter.plot("Sorting Algorithms Complexity Analysis", "Input Size", "Running Time (ms)");
    }

    private void run(Sort sort, int[] input) {
        long start = sample();
        sort.sort(input);
        long end = sample();
        double time = (end - start) / 1000000.0;

        plotter.addDataPoint(sort.getClass().getSimpleName(), input.length, time);
        Logger.debug("%s input: %d runningTime: %f\n", sort.getClass().getSimpleName(), input.length, time);
    }

    private long sample() {
        return System.nanoTime();
    }
}
