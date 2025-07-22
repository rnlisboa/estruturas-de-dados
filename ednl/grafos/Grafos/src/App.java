import Graph.Graph;
import Vertex.Vertex;

public class App {
    public static void main(String[] args) throws Exception {
        // Criar grafo não direcionado
        Graph graph = new Graph(true);

        // Criar vértices
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");

        // Adicionar vértices ao grafo
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);

        // Adicionar arestas (origem, destino, peso)
        graph.addEdge(v1, v3, 5);
        graph.addEdge(v1, v2, 10);
        graph.addEdge(v2, v4, 15);
        graph.addEdge(v4, v2, 20);
        graph.addEdge(v4, v3, 30);

        // Exibir o grafo
        graph.exibir();
    }
}
