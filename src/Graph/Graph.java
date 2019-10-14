package Graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<Vertex> vertices;

    Graph() {
        this.vertices = new ArrayList<>();
    }

    public Vertex createVertex(String vName) {
        Vertex v = new Vertex(vName);
        vertices.add(v);
        return v;
    }

    public void addDirectEdge(Vertex from, Vertex to) {
        from.addVertex(to);
    }

    public boolean isVertexExists(Vertex v) {
        return vertices.contains(v);
    }

    public int getVertexSize() {
        return vertices.size();
    }

    public void printGraph() {
        for(Vertex v: vertices) {
            List<Vertex> vAdjList = v.getAdjacentList();
            System.out.print(v.getName() + ": ");
            for(Vertex vAdj: vAdjList) {
                if(vAdjList.indexOf(vAdj) == vAdjList.size() - 1) {
                    System.out.print(vAdj.getName());
                } else {
                    System.out.print(vAdj.getName() + " -> ");
                }

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        Vertex vA = g.createVertex("A");
        Vertex vB = g.createVertex("B");
        Vertex vC = g.createVertex("C");
        Vertex vD = g.createVertex("D");
        g.addDirectEdge(vA, vB);
        g.addDirectEdge(vA, vC);
        g.addDirectEdge(vA, vD);
        g.printGraph();



    }

}
