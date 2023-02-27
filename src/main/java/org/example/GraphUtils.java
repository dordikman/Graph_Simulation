package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphUtils {
    public static int diameter(Graph graph) {
        List<Vertex> vertices = graph.getVertices();

        // Perform BFS from an arbitrary starting vertex to find farthest vertex
        Vertex start = vertices.get(0);
        Vertex farthest = bfs(start, vertices);

        // Perform BFS from farthest vertex to find diameter
        return getDistance(farthest, vertices);
    }

    private static Vertex bfs(Vertex start, List<Vertex> vertices) {
        Queue<Vertex> q = new LinkedList<Vertex>();
        boolean[] visited = new boolean[vertices.size()];
        int[] distance = new int[vertices.size()];

        visited[start.getId()] = true;
        q.add(start);

        Vertex farthest = start;
        int maxDist = 0;

        while (!q.isEmpty()) {
            Vertex v = q.poll();

            for (Vertex neighbor : v.getNeighbors()) {
                int neighborId = neighbor.getId();
                if (!visited[neighborId]) {
                    visited[neighborId] = true;
                    distance[neighborId] = distance[v.getId()] + 1;
                    q.add(neighbor);

                    if (distance[neighborId] > maxDist) {
                        maxDist = distance[neighborId];
                        farthest = neighbor;
                    }
                }
            }
        }

        return farthest;
    }

    private static int getDistance(Vertex start, List<Vertex> vertices) {
        Queue<Vertex> q = new LinkedList<Vertex>();
        boolean[] visited = new boolean[vertices.size()];
        int[] distance = new int[vertices.size()];

        visited[start.getId()] = true;
        q.add(start);

        int maxDist = 0;

        while (!q.isEmpty()) {
            Vertex v = q.poll();

            for (Vertex neighbor : v.getNeighbors()) {
                int neighborId = neighbor.getId();
                if (!visited[neighborId]) {
                    visited[neighborId] = true;
                    distance[neighborId] = distance[v.getId()] + 1;
                    q.add(neighbor);

                    if (distance[neighborId] > maxDist) {
                        maxDist = distance[neighborId];
                    }
                }
            }
        }

        return maxDist;
    }

    public static int hasIsolatedVertex(Graph graph) {
        for (Vertex vertex : graph.getVertices()) {
            if (vertex.getDegree() == 0) {
                return 1; // Return 1 if there is at least one isolated vertex
            }
        }
        return 0; // Return 0 if there are no isolated vertices
    }

    public static boolean IsConnected(Graph graph) {
        List<Vertex> vertices = graph.getVertices();
        int n = vertices.size();

        if (n == 0 || n == 1) {
            // A graph with 0 or 1 vertex is always connected
            return true;
        }

        // Generate a random starting vertex and perform BFS to find all reachable vertices
        Vertex start = vertices.get((int) (Math.random() * n));
        Queue<Vertex> q = new LinkedList<Vertex>();
        boolean[] visited = new boolean[n];

        visited[start.getId()] = true;
        q.add(start);

        while (!q.isEmpty()) {
            Vertex v = q.poll();

            for (Vertex neighbor : v.getNeighbors()) {
                int neighborId = neighbor.getId();
                if (!visited[neighborId]) {
                    visited[neighborId] = true;
                    q.add(neighbor);
                }
            }
        }

        // Check if all vertices are reachable from the starting vertex
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }



}
