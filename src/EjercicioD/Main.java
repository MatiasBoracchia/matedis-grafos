package EjercicioD;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        GraphAdjacencyList graph = new GraphAdjacencyList(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        System.out.println("\n--------BFS--------");
        BFS.BFSMethod(graph, 0);
        System.out.println("\n--------DFS--------");
        DFS.DFSMethod(graph, 0);
        System.out.println("\n--------Busqueda Plana--------");
        BusquedaPlana.BusquedaPlanaMethod(graph);



    }
}
