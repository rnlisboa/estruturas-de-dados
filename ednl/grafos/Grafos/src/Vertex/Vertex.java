package Vertex;

import java.util.ArrayList;

import Edge.Edge;

public class Vertex {
    ArrayList<Edge> edges = new ArrayList<>();;
    String label;

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public ArrayList<Edge> getEdges() {
        return this.edges;
    }

    public void addIntoEdge(Edge e) {
        this.edges.add(e);
    }
}
