package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Vertex {
    private int id;
    private List<Vertex> edges;

    public Vertex(int id) {
        this.id = id;
        this.edges = new ArrayList<Vertex>();
    }

    public int getId() {
        return id;
    }

    public List<Vertex> getEdges() {
        return edges;
    }

    public void addEdge(Vertex v) {
        edges.add(v);
    }

    public List<Vertex> getNeighbors() {
        return edges.stream()
                .filter(v -> v != null)
                .collect(Collectors.toList());
    }

    public int getDegree() {
        return edges.size();
    }
}

