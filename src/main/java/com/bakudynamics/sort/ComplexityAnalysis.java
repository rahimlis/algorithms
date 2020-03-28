package com.bakudynamics.sort;

import com.bakudynamics.input.RandomIntArraySource;
import com.bakudynamics.ui.plotter.RunningTimePlotter;
import com.bakudynamics.ui.plotter.XYSeriesPlotter;
import com.bakudynamics.utils.Logger;

import java.util.List;

public class ComplexityAnalysis {

    private final RunningTimePlotter plotter = new XYSeriesPlotter();

    public static void main(String[] args) throws Exception {
        ComplexityAnalysis analysis = new ComplexityAnalysis();
        List<Sort> sortingAlgorithms = List.of(
                new MergeSort(),
                new InsertionSort()
        );

        for (Sort sortingAlgorithm : sortingAlgorithms) {
            analysis.analyze(sortingAlgorithm);
        }

        analysis.plot();
    }

    public void analyze(Sort sort) {
        var inputSource = new RandomIntArraySource(10000, 400000, 20000);
        //var inputSource = new FileInputSource();

        while (inputSource.hasNext()) {
            int[] input = inputSource.next();
            run(sort, input);
        }
    }

    public void plot() throws Exception {
        plotter.plot("Sorting Algorithms Complexity Analysis", "Input Size", "Running Time (ns)");
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
