package Graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String vName;
    private List<Vertex> adjacentList;

    Vertex() {
        this.adjacentList = new ArrayList<>();
    }

    Vertex(String vName) {
        this.vName = vName;
        this.adjacentList = new ArrayList<>();
    }

    Vertex(String vName, List<Vertex> adjacentList) {
        this.vName = vName;
        this.adjacentList = adjacentList;
    }

    public void addVertex(Vertex v) {
        adjacentList.add(v);
    }

    public List<Vertex> getAdjacentList() {
        return this.adjacentList;
    }

    public String getName() {
        return vName;
    }


}
