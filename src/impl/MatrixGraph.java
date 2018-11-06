package impl;

import com.sun.istack.internal.NotNull;
import struct.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MatrixGraph<T> implements Graph<T> {

    private List<T> vertexes;
    private boolean[][] edges;
    private int n;

    public List<T> getVertexes() {
        return vertexes;
    }

    public boolean[][] getEdges() {
        return edges;
    }

    public int getN() {
        return n;
    }

    public int getA() {
        return a;
    }

    private int a;

    public MatrixGraph() {
        edges = new boolean[10][10];
        vertexes = new ArrayList<T>();

        initializeEdges();
    }

    public MatrixGraph(int n) {
        this.edges = new boolean[n][n];
        this.vertexes = new ArrayList<T>(n);
        this.n = n;

        initializeEdges();
    }

    private void initializeEdges() {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                edges[i][j] = false;
            }
        }
    }

    @Override
    public void addVertex(@NotNull Optional<T> x) {
        if(x.isPresent()) {
            vertexes.add(x.get();
            n++;
        }
    }

    @Override
    public void addEdge(int v, int w) {
        if (!edges[v][w]) {
            edges[v][w] = true;
            edges[w][v] = true;
            a++;
        }
    }

    @Override
    public void deleteVertex(int v) {
        if (vertexes.get(v) != null && v < n) {
            boolean[][] edgesAux = edges;
            edges = new boolean[n - 1][n - 1];
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    edges[i][j] = edgesAux[i][j];
                }
            }
            for (int i = v; i < n; i++) {
                for (int j = v; j < n; j++) {
                    edges[i][j] = edgesAux[i + 1][j + 1];
                }
            }
            vertexes.remove(v);
            n--;
        }
    }

    @Override
    public void deleteEdge(int v, int w) {
        if (edges[v][w]) {
            edges[v][w] = false;
            edges[w][v] = false;
            a--;
        }
    }

    @Override
    public boolean hasEdge(int v, int w) {
        return edges[v][w];
    }

    @Override
    public int amoutOfEdges() {
        return a;
    }

    @Override
    public int order() {
        return n;
    }

    @Override
    public T vertexAt(int v) {
        return vertexes.get(v);
    }

    @Override
    public List<Integer> getAdyacencyList(int v) {
        List<Integer> returnValue = new ArrayList<Integer>();
        for (int i = 0; i < edges[v].length; i++) {
            if (edges[v][i]) {
                returnValue.add(i);
            }
        }
        return returnValue;
    }

}
