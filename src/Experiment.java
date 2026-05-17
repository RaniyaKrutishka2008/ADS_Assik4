class Experiment {

    private long[] bfsTimes;
    private long[] dfsTimes;
    private int[] sizes = {10, 30, 100};

    public void runTraversals(Graph g) {
        long startTime = System.nanoTime();
        g.bfs(0);
        long endTime = System.nanoTime();
        System.out.println("BFS time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        g.dfs(0);
        endTime = System.nanoTime();
        System.out.println("DFS time: " + (endTime - startTime) + " ns");
    }

    public void runMultipleTests(Graph[] graphs) {
        bfsTimes = new long[graphs.length];
        dfsTimes = new long[graphs.length];

        for (int i = 0; i < graphs.length; i++) {
            System.out.println("\n[*] Testing graph with " + sizes[i] + " vertices...");

            long startTime = System.nanoTime();
            graphs[i].bfs(0);
            bfsTimes[i] = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            graphs[i].dfs(0);
            dfsTimes[i] = System.nanoTime() - startTime;
        }
    }

    public void printResults() {
        System.out.println("\n********************************************");
        System.out.println("               RESULTS TABLE                ");
        System.out.println("********************************************");
        System.out.printf("%-15s %-20s %-20s%n", "Graph Size", "BFS Time (ns)", "DFS Time (ns)");
        System.out.println("--------------------------------------------");
        for (int i = 0; i < sizes.length; i++) {
            System.out.printf("%-15d %-20d %-20d%n", sizes[i], bfsTimes[i], dfsTimes[i]);
        }
        System.out.println("********************************************");
    }
}