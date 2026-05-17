public class Main {

    public static void main(String[] args) {

        Experiment exp = new Experiment();

        Graph small = new Graph();
        for (int i = 0; i < 10; i++) {
            small.addVertex(new Vertex(i));
        }
        for (int i = 0; i < 10; i++) {
            if (i * 2 + 1 < 10) small.addEdge(i, i * 2 + 1);
            if (i * 2 + 2 < 10) small.addEdge(i, i * 2 + 2);
        }

        Graph medium = new Graph();
        for (int i = 0; i < 30; i++) {
            medium.addVertex(new Vertex(i));
        }
        for (int i = 0; i < 30; i++) {
            if (i * 2 + 1 < 30) medium.addEdge(i, i * 2 + 1);
            if (i * 2 + 2 < 30) medium.addEdge(i, i * 2 + 2);
        }

        Graph large = new Graph();
        for (int i = 0; i < 100; i++) {
            large.addVertex(new Vertex(i));
        }
        for (int i = 0; i < 100; i++) {
            if (i * 2 + 1 < 100) large.addEdge(i, i * 2 + 1);
            if (i * 2 + 2 < 100) large.addEdge(i, i * 2 + 2);
        }

        System.out.println("========================================");
        System.out.println("SMALL GRAPH");
        System.out.println("========================================");

        small.printGraph();
        System.out.println();
        exp.runTraversals(small);

        System.out.println("\n========================================");
        System.out.println("EXPERIMENT");
        System.out.println("========================================");

        exp.runMultipleTests(new Graph[]{small, medium, large});
        exp.printResults();
    }
}