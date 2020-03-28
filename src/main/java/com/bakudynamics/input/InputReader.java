package com.bakudynamics.input;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {

    public static int[] readIntArray(String filename) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(filename);
        List<Integer> integers = new ArrayList<>();
        if (is != null) {
            Scanner scanner = new Scanner(is);
            while (scanner.hasNextInt()) {
                integers.add(scanner.nextInt());
            }
        }
        return integers.stream().mapToInt(i -> i).toArray();
    }
}
