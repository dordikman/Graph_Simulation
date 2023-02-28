package org.example;
import java.util.ArrayList;
import java.util.List;

public class GraphRunner {
    public static List<Integer> runConnectivity(List<Double> pVals) {
        List<Integer> results = new ArrayList<Integer>();
        for (double p : pVals) {
            int numConnected = 0;
            for (int i = 0; i < 500; i++) {
                Graph g = new Graph(1000,p);
                if (GraphUtils.IsConnected(g)) {
                    numConnected++;
                }
            }
            results.add(numConnected);
        }
        return results;
    }

    public static List<Integer> runIsIsolated(List<Double> pVals) {
        List<Integer> results = new ArrayList<Integer>();
        for (double p : pVals) {
            int numIsolated = 0;
            for (int i = 0; i < 500; i++) {
                Graph g = new Graph(1000,p);
                if (GraphUtils.hasIsolatedVertex(g) == 1) {
                    numIsolated++;
                }
            }
            results.add(numIsolated);
        }
        return results;
    }

    public static List<Integer> runDiameter(List<Double> pVals) {
        List<Integer> results = new ArrayList<Integer>();
        for (double p : pVals) {
            int totalDistance = 0;
            for (int i = 0; i < 500; i++) {
                Graph g = new Graph(1000,p);
                totalDistance += GraphUtils.diameter(g);
            }
            int avgDistance = totalDistance / 100;
            results.add(avgDistance);
        }
        return results;
    }


}
