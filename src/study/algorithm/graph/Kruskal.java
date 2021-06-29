package study.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Kruskal {
    static class Edge implements Comparable<Edge> {
        int weight;
        String nodeV;
        String nodeU;

        public Edge(int weight, String nodeV, String nodeU) {
            this.weight = weight;
            this.nodeV = nodeV;
            this.nodeU = nodeU;
        }

        public String toString() {
            return "(" + this.weight + ", " + this.nodeV + ", " + this.nodeU + ")";
        }

        @Override
        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }
    }

    HashMap<String, String> parent = new HashMap<>();
    HashMap<String, Integer> rank = new HashMap<>();

    //union-find
    public String find(String node) {
        if (this.parent.get(node) != node) {
            parent.put(node, this.find(this.parent.get(node)));
        }
        return this.parent.get(node);
    }

    public void union(String nodeV, String nodeU) {
        String root1 = this.find(nodeV);
        String root2 = this.find(nodeU);

        if (this.rank.get(root1) > this.rank.get(root2)) {
            this.parent.put(root2, root1);
        } else {
            this.parent.put(root1, root2);
            if (this.rank.get(root1) == this.rank.get(root2)) {
                this.rank.put(root2, this.rank.get(root2) + 1);
            }
        }
    }

    //initialize set
    public void makeSet(String node) {
        this.parent.put(node, node);
        this.rank.put(node, 0);
    }

    public ArrayList<Edge> kruskalFunc(ArrayList<String> vertices, ArrayList<Edge> edges) {
        ArrayList<Edge> mst = new ArrayList<>();

        for (int i = 0; i < vertices.size(); i++) {
            this.makeSet(vertices.get(i));
        }
        Collections.sort(edges);

        for (int i = 0; i < edges.size(); i++) {
            Edge currentEdge = edges.get(i);
            if (this.find(currentEdge.nodeV) != this.find(currentEdge.nodeU)) {
                this.union(currentEdge.nodeV, currentEdge.nodeU);
                mst.add(currentEdge);
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        //create graph
        ArrayList<String> vertices = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(7, "B", "A"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(8, "C", "B"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(5, "D", "A"));
        edges.add(new Edge(9, "D", "B"));
        edges.add(new Edge(7, "D", "E"));
        edges.add(new Edge(6, "D", "F"));
        edges.add(new Edge(7, "E", "B"));
        edges.add(new Edge(5, "E", "C"));
        edges.add(new Edge(7, "E", "D"));
        edges.add(new Edge(8, "E", "F"));
        edges.add(new Edge(9, "E", "G"));
        edges.add(new Edge(6, "F", "D"));
        edges.add(new Edge(8, "F", "E"));
        edges.add(new Edge(11, "F", "G"));
        edges.add(new Edge(9, "G", "E"));
        edges.add(new Edge(11, "G", "F"));

        //kruskal
        Kruskal kruskal = new Kruskal();
        ArrayList<Edge> kruskalPath = kruskal.kruskalFunc(vertices, edges);

        //print
        System.out.println(kruskalPath);
    }
}
