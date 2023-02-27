package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Graph {
    private List<Vertex> vertices;



    public Graph(int numVertices, double probability) {
        this.vertices = new ArrayList<Vertex>();
        Random rand = new Random();

        // Add vertices to graph
        for (int i = 0; i < numVertices; i++) {
            vertices.add(new Vertex(i));
        }

        // Add edges between vertices
        addEdges(numVertices, probability, rand);
    }

    private void addEdges(int numVertices, double probability, Random rand) {
        for (int i = 0; i < numVertices - 1; i++) {
            Vertex v1 = vertices.get(i);
            for (int j = i + 1; j < numVertices; j++) {
                if (rand.nextDouble() < probability) {
                    Vertex v2 = vertices.get(j);
                    v1.addEdge(v2);
                    v2.addEdge(v1);
                }
            }
        }
    }

    public  List<Vertex> getVertices() {
        return vertices;
    }

    public static List<Double> generateRandomP(String userChoise){

        List<Double> randomDoubles=new ArrayList<>();
        Random rand=new Random();
        double val=getValueFromInputString(userChoise);

        for (int i = 0; i < 5; i++) {
            randomDoubles.add(rand.nextDouble() * val);
        }

        for (int i = 0; i < 5; i++) {
            randomDoubles.add(val + rand.nextDouble() * (Double.MAX_VALUE - val));
        }
        return randomDoubles;
    }

    public static double getValueFromInputString(String input) {
        switch (input) {
            case "Connectivity":
                return 0.0069;
            case "Diameter":
                return 0.1175;
            case "Is Isolated":
                return 0.0069;
            default:
                throw new IllegalArgumentException("Invalid input string: " + input);
        }
    }

}

