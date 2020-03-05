package Graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<Vertex> vertices;

    Graph() {
        this.vertices = new ArrayList<>();
    }

    public Vertex getVertexByName(String vName) {
        Vertex rV = null;
        if (isVertexExistsByName(vName)) {
            for (Vertex v: vertices) {
                if(v.getName() == vName) {
                     rV = v;
                }
            }
        }
        return rV;
    }

    public Vertex createVertex(Vertex o) {
        Vertex v = new Vertex(o.getName());
        vertices.add(v);
        return v;
    }

    public void addDirectEdge(Vertex from, Vertex to) {
        from.addVertex(to);
    }

    public boolean isVertexExistsByName(String vName) {
        boolean isExists = false;
        for (Vertex v: vertices) {
            if (v.getName() == vName) {
                isExists = true;
            }
        }
        return isExists;
    }

    public int getVertexSize() {
        return vertices.size();
    }

    public List<Vertex> getVertices() {
        return vertices;
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
        Vertex vA = g.createVertex(new Vertex("A"));
        Vertex vB = g.createVertex(new Vertex("B"));
        Vertex vC = g.createVertex(new Vertex("C"));
        Vertex vD = g.createVertex(new Vertex("D"));
        g.addDirectEdge(vA, vB);
        g.addDirectEdge(vA, vC);
        g.addDirectEdge(vA, vD);
        g.printGraph();



    }

}
