package org.example;

import java.util.ArrayList;
import java.util.List;

public class Simulate {

    public void RunAll(){
        List<Double> list = Graph.generateRandomP("Connectivity");
        List<Double> list2 = Graph.generateRandomP("Is Isolated");
        List<Double> list3 = Graph.generateRandomP("Diameter");

        List<Integer> results = RunConnectivity();
        List<Integer> results2 = RunIsIsolated();
        List<Integer> results3 = RunDiameter();

        ExcelWriter.writePVals("results.xlsx","Connectivity",list);
        ExcelWriter.writeResults("results.xlsx","connectivity",results);
        ExcelWriter.writePVals("results.xlsx","Is Isolated",list2);
        ExcelWriter.writeResults("results.xlsx","Is Isolated",results2);
        ExcelWriter.writePVals("results.xlsx","Diameter",list3);
        ExcelWriter.writeResults("results.xlsx","Diameter",results3);
    }

    public List<Integer> RunConnectivity() {
        List<Double> list = Graph.generateRandomP("Connectivity");
        List<Integer> results = new ArrayList<Integer>();
        for (double p : list) {
            int numConnected = 0;
            for (int i = 0; i < 500; i++) {
                Graph graph = new Graph(1000, p);
                if (GraphUtils.IsConnected(graph)) {
                    numConnected++;
                }
            }
            results.add(numConnected);
        }
        return results;
    }

    public List<Integer> RunIsIsolated(){
        List<Double> list = Graph.generateRandomP("Is Isolated");
        List<Integer> results = new ArrayList<Integer>();
        for (double p : list) {
            int numIsolated = 0;
            for (int i = 0; i < 500; i++) {
                Graph graph = new Graph(1000, p);
                if (GraphUtils.hasIsolatedVertex(graph)==1) {
                    numIsolated++;
                }
            }
            results.add(numIsolated);
        }
        return results;
    }

    public List<Integer> RunDiameter(){
        List<Double> list = Graph.generateRandomP("Diameter");
        List<Integer> results = new ArrayList<Integer>();
        for (double p : list) {
            int diameterIs2=0;
            for (int i = 0; i < 500; i++) {
                Graph graph = new Graph(1000, p);
                if (GraphUtils.diameter(graph)==2) {
                    diameterIs2++;
                }
            }
            results.add(diameterIs2);
        }
        return results;
    }












}

