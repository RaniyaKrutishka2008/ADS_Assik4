import java.util.*;

class Graph {
    private Map<Integer, List<Vertex>> adjList;
    private Map<Integer, Vertex> vertices;

    public Graph() {
        adjList = new HashMap<>();
        vertices = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        vertices.put(v.getId(), v);
        adjList.put(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        Vertex srcV = vertices.get(from);
        Vertex dstV = vertices.get(to);

        adjList.get(from).add(dstV);
        adjList.get(to).add(srcV);
    }

    public void printGraph() {
        System.out.println("--- Graph Structure ---");

        for (int id : adjList.keySet()) {
            System.out.print("Vertex(" + id + ") -> ");
            System.out.println(adjList.get(id));
        }
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        Vertex startV = vertices.get(start);

        visited.add(start);
        queue.add(startV);

        System.out.print("BFS starting from " + start + ": ");

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            System.out.print(current.getId() + " ");

            for (Vertex neighbour : adjList.get(current.getId())) {
                if (!visited.contains(neighbour.getId())) {
                    visited.add(neighbour.getId());
                    queue.add(neighbour);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS starting from " + start + ": "); // Немного изменен текст
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int currentId, Set<Integer> visited) {
        visited.add(currentId);
        System.out.print(currentId + " ");

        for (Vertex neighbour : adjList.get(currentId)) {
            if (!visited.contains(neighbour.getId())) {
                dfsHelper(neighbour.getId(), visited);
            }
        }
    }
}