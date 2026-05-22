import java.util.*;

class Graph {
    private Map<Integer, List<Edge>> adjList;
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
        addEdge(from, to, 1);
    }


    public void addEdge(int from, int to, int weight) {
        Vertex srcV = vertices.get(from);
        Vertex dstV = vertices.get(to);
        adjList.get(from).add(new Edge(srcV, dstV, weight));
        adjList.get(to).add(new Edge(dstV, srcV, weight));
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
            for (Edge edge : adjList.get(current.getId())) {
                Vertex neighbour = edge.getDest();
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
        System.out.print("DFS starting from " + start + ": ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int currentId, Set<Integer> visited) {
        visited.add(currentId);
        System.out.print(currentId + " ");
        for (Edge edge : adjList.get(currentId)) {
            Vertex neighbour = edge.getDest();
            if (!visited.contains(neighbour.getId())) {
                dfsHelper(neighbour.getId(), visited);
            }
        }
    }

    public void dijkstra(int start) {
        int n = vertices.size();
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && (u == -1 || dist[v] < dist[u])) {
                    u = v;
                }
            }

            if (u == -1 || dist[u] == Integer.MAX_VALUE) break; // remaining vertices are unreachable
            visited[u] = true;
            for (Edge edge : adjList.get(u)) {
                int neighbor = edge.getDest().getId();
                int newDist = dist[u] + edge.getWeight();
                if (newDist < dist[neighbor]) {
                    dist[neighbor] = newDist;
                }
            }
        }
        System.out.println("Dijkstra shortest paths from vertex " + start + ":");
        for (int v = 0; v < n; v++) {
            if (dist[v] == Integer.MAX_VALUE) {
                System.out.println("  Vertex " + v + " -> UNREACHABLE");
            } else {
                System.out.println("  Vertex " + v + " -> distance = " + dist[v]);
            }
        }
    }
}