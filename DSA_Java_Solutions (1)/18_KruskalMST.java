import java.util.*;

class DisjointSet {
    int[] parent;
    DisjointSet(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}

class EdgeK {
    int src, dest, weight;
    EdgeK(int s, int d, int w) {
        src = s; dest = d; weight = w;
    }
}

public class KruskalMST {
    public int kruskal(int V, List<EdgeK> edges) {
        Collections.sort(edges, Comparator.comparingInt(e -> e.weight));
        DisjointSet ds = new DisjointSet(V);
        int mstWeight = 0;
        for (EdgeK edge : edges) {
            if (ds.find(edge.src) != ds.find(edge.dest)) {
                ds.union(edge.src, edge.dest);
                mstWeight += edge.weight;
            }
        }
        return mstWeight;
    }
}