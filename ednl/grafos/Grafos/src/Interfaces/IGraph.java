package Interfaces;

import Vertex.Vertex;

public interface IGraph {

    void addVertex(Vertex v);
    void addEdge(Vertex origin, Vertex destination, int weight);

    void exibir();
}