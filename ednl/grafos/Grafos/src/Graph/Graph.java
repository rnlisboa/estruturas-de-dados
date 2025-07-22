package Graph;

import java.util.ArrayList;

import Edge.Edge;
import Interfaces.IGraph;
import Vertex.Vertex;

public class Graph implements IGraph {

    ArrayList<Vertex> vertexs = new ArrayList<>();
    Boolean isDirected;

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
    }


    @Override
    public void addVertex(Vertex v) {
        if (!vertexs.contains(v)) {
            this.vertexs.add(v);
        }
    }

    @Override
    public void addEdge(Vertex origin, Vertex destination, int weight) {
        Edge edge = new Edge(origin, destination, weight);
        origin.addIntoEdge(edge);
    
        if (!isDirected) {
            Edge reverse = new Edge(destination, origin, weight);
            destination.addIntoEdge(reverse);
        }

    }

    public void exibir() {
        // percorrer cada  vertice
        // percorrer a lista de arestas
       for (Vertex v : this.vertexs) {
            for (Edge edge : v.getEdges()) {
                System.out.println(edge.getV1().getLabel() + "-> " + edge.getWeight() + " ->" + edge.getV2().getLabel());
            }
        }
    }
    

}