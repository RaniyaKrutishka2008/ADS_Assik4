import java.util.*;

public class Main {
    public static void main(String[] args) {
        Experiment exp = new Experiment();

        // Small graph (10 vertices)
        Graph small = new Graph();
        for (int i = 0; i < 10; i++) small.addVertex(new Vertex(i));
        for (int i = 0; i < 10; i++) {
            if (i * 2 + 1 < 10) small.addEdge(i, i * 2 + 1, (i * 3 + 1) % 9 + 1);
            if (i * 2 + 2 < 10) small.addEdge(i, i * 2 + 2, (i * 5 + 2) % 9 + 1);
        }

        //Medium graph (30 vertices) ---
        Graph medium = new Graph();
        for (int i = 0; i < 30; i++) medium.addVertex(new Vertex(i));
        for (int i = 0; i < 30; i++) {
            if (i * 2 + 1 < 30) medium.addEdge(i, i * 2 + 1, (i * 3 + 1) % 9 + 1);
            if (i * 2 + 2 < 30) medium.addEdge(i, i * 2 + 2, (i * 5 + 2) % 9 + 1);
        }

        //Large graph (100 vertices) ---
        Graph large = new Graph();
        for (int i = 0; i < 100; i++) large.addVertex(new Vertex(i));
        for (int i = 0; i < 100; i++) {
            if (i * 2 + 1 < 100) large.addEdge(i, i * 2 + 1, (i * 3 + 1) % 9 + 1);
            if (i * 2 + 2 < 100) large.addEdge(i, i * 2 + 2, (i * 5 + 2) % 9 + 1);
        }

        System.out.println("========================================");
        System.out.println("SMALL GRAPH");
        System.out.println("========================================");
        small.printGraph();
        System.out.println();
        exp.runTraversals(small);

        System.out.println();
        System.out.println("========================================");
        System.out.println("DIJKSTRA - SMALL GRAPH");
        System.out.println("========================================");
        small.dijkstra(0);

        System.out.println("\n========================================");
        System.out.println("EXPERIMENT");
        System.out.println("========================================");
        exp.runMultipleTests(new Graph[]{small, medium, large});
        exp.printResults();
    }
}