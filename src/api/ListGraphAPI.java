package api;

import impl.ListGraph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

public class ListGraphAPI {

    public ListGraphAPI() {

    }

    /**
     * Method that returns a randomized Integer List Graph with a given amount of vertices and edges.
     *
     * @param degree        amount of vertices.
     * @param amountOfEdges amount of edges.
     * @return randomized Integer List Graph.
     */
    public static ListGraph<Integer> generateIntegerGraph(int degree, int amountOfEdges) {
        ListGraph<Integer> randomGraph = new ListGraph<>();
        Random random = new Random();
        while (randomGraph.n < degree) {
            randomGraph.addVertex(random.nextInt(100));
        }
        while (randomGraph.a < amountOfEdges) {
            randomGraph.addEdge(random.nextInt(randomGraph.order()), random.nextInt(randomGraph.order()));
        }
        return randomGraph;
    }

    /**
     * Method that prints a given graph in plane, BFS and DFS form.
     *
     * @param graph graph to print.
     */
    public static void printGraph(ListGraph<Integer> graph) {
        System.out.println("* * * * * * * * * * * * * * * * * * * * *");
        System.out.println("*                                       *");
        System.out.println("*   Grafo no dirigido y no ponderado    *");
        System.out.println("*                                       *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * *");
        System.out.println();
        System.out.println("[ orden   ] orden de grafo: " + graph.n);
        System.out.println("[ aristas ] aristas de grafo: " + graph.a);
        System.out.println("\n Búsqueda plana");
        BusquedaPlana(graph);
        System.out.println("\n\n Búsqueda BFS");
        BFS(graph, 0);
        System.out.println("\n\n Búsqueda DFS");
        DFS(graph);
        System.out.println();
        System.out.println();
    }

    /**
     * Method that iterates through a given graph in plane form, printing the value of each vertex and its edges.
     *
     * @param graph graph to iterate in plane form.
     */
    public static void BusquedaPlana(ListGraph<Integer> graph) {
        int counter = 0;
        for (Integer vertexValue : graph.edges.keySet()) {
            System.out.println();
            System.out.println("[ vértice ] índice: " + counter + " - valor: " + vertexValue);
            System.out.print("[ aristas ] ");
            for (Integer adyacentVertex : graph.getAdyacencyList(counter)) {
                System.out.print(adyacentVertex + ", ");
            }
            counter++;
        }
    }

    /**
     * Method that iterates through a given graph in BFS form, printing the index of each vertex.
     *
     * @param graph graph to iterate in BFS.
     * @param s     starting vertex value.
     */
    public static void BFS(ListGraph<Integer> graph, int s) {
        System.out.println();
        boolean[] visited = new boolean[graph.n];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (queue.size() > 0) {
            s = queue.poll();
            System.out.print(s + ", ");
            Iterator<Integer> i = graph.getAdyacencyList(s).iterator();
            while (i.hasNext()) {
                int n = graph.getVertex(i.next());
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    /**
     * Method that iterates through a given graph in DFS form, printing the index of each vertex.
     *
     * @param graph graph to iterate in DFS.
     */
    public static void DFS(ListGraph<Integer> graph) {
        System.out.println();
        boolean[] visited = new boolean[graph.n];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        DFSUtil(graph, 0, visited);
    }

    private static void DFSUtil(ListGraph<Integer> graph, int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + ", ");
        Iterator<Integer> i = graph.getAdyacencyList(vertex).iterator();
        while (i.hasNext()) {
            int n = graph.getVertex(i.next());
            if (!visited[n])
                DFSUtil(graph, n, visited);
        }
    }

    /**
     * Method that determines if a given graph is bipartite or not.
     *
     * @param graph graph to determine if is bipartite.
     * @return true if graph is bipartite, otherwise false.
     */
    public static boolean isBipartite(ListGraph<Integer> graph) {
        boolean[] visited = new boolean[graph.order()];
        boolean[] color = new boolean[graph.order()];
        for (int i = 0; i < graph.order(); i++) {
            color[i] = false;
            visited[i] = false;
        }
        return isBipartite(graph, 0, visited, color);
    }

    private static boolean isBipartite(ListGraph<Integer> graph, int v, boolean[] visited, boolean[] color) {
        for (Integer edge : graph.getAdyacencyList(v)) {
            int indexOfEdge = graph.getVertex(edge);
            if (!visited[indexOfEdge]) {
                visited[indexOfEdge] = true;
                color[indexOfEdge] = !color[v];
                if (!isBipartite(graph, indexOfEdge, visited, color)) {
                    return false;
                }
            } else if (color[indexOfEdge] == color[v]) {
                return false;
            }
        }
        return true;
    }

}
