package com.bakudynamics.sort;

import com.bakudynamics.input.RandomIntArraySource;
import com.bakudynamics.ui.plotter.RunningTimePlotter;
import com.bakudynamics.ui.plotter.XYSeriesPlotter;
import com.bakudynamics.utils.Logger;

import java.util.List;
import java.util.stream.IntStream;

public class ComplexityAnalysis {

    public static final int MIN_INPUT_SIZE = 0;
    public static final int MAX_INPUT_SIZE = 5000000;
    public static final int INCREMENT_SIZE = 100000;

    private final RunningTimePlotter plotter = new XYSeriesPlotter(MAX_INPUT_SIZE, MIN_INPUT_SIZE);

    public static void main(String[] args) throws Exception {
        ComplexityAnalysis analysis = new ComplexityAnalysis();
        List<Sort> sortingAlgorithms = List.of(
                new MergeSort(),
                new MergeInsertionSort(64)
        );

        for (Sort sortingAlgorithm : sortingAlgorithms) {
            analysis.analyze(sortingAlgorithm);
            analysis.analyzePrimitiveInt(sortingAlgorithm);
        }
        analysis.plot();
    }

    public void analyze(Sort sort) {
        var inputSource = new RandomIntArraySource(MIN_INPUT_SIZE, MAX_INPUT_SIZE, INCREMENT_SIZE);

        while (inputSource.hasNext()) {
            Integer[] input = IntStream.of(inputSource.next()).boxed().toArray(Integer[]::new);
            run(sort, input);
        }
    }


    public void analyzePrimitiveInt(Sort sort) {
        var inputSource = new RandomIntArraySource(MIN_INPUT_SIZE, MAX_INPUT_SIZE, INCREMENT_SIZE);

        while (inputSource.hasNext()) {
            int[] input = inputSource.next();
            run(sort, input);
        }
    }

    public void plot() throws Exception {
        plotter.plot("Sorting Algorithms Complexity Analysis", "Input Size", "Running Time (ms)");
    }

    private <T> void run(Sort sort, Comparable<T>[] input) {
        long start = sample();
        sort.sort(input);
        long end = sample();
        double time = (end - start) / 1000000.0;

        plotter.addDataPoint(sort.tag() +" Comparable[]", input.length, time);
        Logger.debug("%s input: %d runningTime: %f\n", sort.tag(), input.length, time);
    }

    private void run(Sort sort, int[] input) {
        long start = sample();
        sort.sort(input);
        long end = sample();
        double time = (end - start) / 1000000.0;

        plotter.addDataPoint(sort.tag() +" int[]", input.length, time);
        Logger.debug("%s input: %d runningTime: %f\n", sort.tag(), input.length, time);
    }

    private long sample() {
        return System.nanoTime();
    }
}
