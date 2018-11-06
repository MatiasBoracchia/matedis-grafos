package impl;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import struct.Graph;

import java.util.*;

public class ListGraph<T> implements Graph<T> {

    private Map<T, LinkedList<T>> edges;

    private int n;
    private int a;

    public ListGraph() {
        edges = new HashMap<T, LinkedList<T>>();
    }

    @Override
    public void addVertex(T vertex) {
        Optional<T> optionalVertex = Optional.ofNullable(vertex);
        if(optionalVertex.isPresent()) {
            edges.put(optionalVertex.get(), new LinkedList<T>());
        }
    }

    @Override
    public void addEdge(int vertex, T value) {

    }

    @Override
    public void deleteVertex(int vertex) {

    }

    @Override
    public void deleteEdge(int vertex, T value) {

    }

    @Override
    public boolean hasEdge(int vertex, T value) {
        return false;
    }

    @Override
    public int amoutOfEdges() {
        return 0;
    }

    @Override
    public int order() {
        return 0;
    }

    @Override
    public T vertexAt(int vertex) {
        if(!edges.keySet().isEmpty() && vertex < edges.keySet().size()) {

        } else {
            return null;
        }
    }

    @Override
    public List<T> getAdyacencyList(int vertex) {
        Optional<T> optionalVertex = Optional.ofNullable(vertexAt(vertex));
        if (optionalVertex.isPresent()) {
            return edges.get(optionalVertex.get());
        } else {
            return Collections.emptyList();
        }
    }

}
