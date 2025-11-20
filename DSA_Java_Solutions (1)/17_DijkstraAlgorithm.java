import java.util.*;

class Edge {
    int to, weight;
    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class DijkstraAlgorithm {
    public int[] dijkstra(int V, List<List<Edge>> graph, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.offer(new Edge(src, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            for (Edge edge : graph.get(current.to)) {
                if (dist[current.to] + edge.weight < dist[edge.to]) {
                    dist[edge.to] = dist[current.to] + edge.weight;
                    pq.offer(new Edge(edge.to, dist[edge.to]));
                }
            }
        }
        return dist;
    }
}