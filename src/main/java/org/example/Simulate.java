package org.example;

import java.util.List;

public class Simulate {

    public void runAll() {
        List<Double> pVals1 = Graph.generateRandomP("Connectivity");
        List<Double> pVals2 = Graph.generateRandomP("Is Isolated");
        List<Double> pVals3 = Graph.generateRandomP("Diameter");

        List<Integer> results1 = GraphRunner.runConnectivity(pVals1);
        List<Integer> results2 = GraphRunner.runIsIsolated(pVals2);
        List<Integer> results3 = GraphRunner.runDiameter(pVals3);

        ExcelWriter.writePVals("results.xlsx", "Connectivity", pVals1);
        ExcelWriter.writeResults("results.xlsx", "connectivity", results1);
        ExcelWriter.writePVals("results.xlsx", "Is Isolated", pVals2);
        ExcelWriter.writeResults("results.xlsx", "Is Isolated", results2);
        ExcelWriter.writePVals("results.xlsx", "Diameter", pVals3);
        ExcelWriter.writeResults("results.xlsx", "Diameter", results3);
    }
}
