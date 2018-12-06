package impl;

import struct.Graph;

import java.util.*;

public class ListGraph<T> implements Graph<T> {

    public Map<T, Set<T>> edges;

    public int n;
    public int a;

    public ListGraph() {
        edges = new HashMap<>();
        n = 0;
        a = 0;
    }

    /**
     * Method of O(n) that adds a vertex to the graph key set if it isn't already in it.
     *
     * @param vertex new vertex value.
     */
    @Override
    public void addVertex(T vertex) {
        Optional<T> optionalVertex = Optional.ofNullable(vertex);
        if(optionalVertex.isPresent()) {
            if(!edges.containsKey(optionalVertex.get())) {
                edges.put(optionalVertex.get(), new HashSet<>());
                n++;
            }
        }
    }

    /**
     * Method of O(n) that adds an edge between two vertices determined by the given indexes of the key set.
     *
     * @param vertex1 index of the vertex.
     * @param vertex2 index of the vertex.
     */
    @Override
    public void addEdge(int vertex1, int vertex2) {
        Optional<T> optionalVertex1 = Optional.ofNullable(getVertex(vertex1));
        Optional<T> optionalVertex2 = Optional.ofNullable(getVertex(vertex2));
        if(!hasEdge(vertex1, vertex2)) {
            edges.get(optionalVertex1.get()).add(optionalVertex2.get());
            edges.get(optionalVertex2.get()).add(optionalVertex1.get());
            a++;
        }
    }

    /**
     * Method of O(n^2) that deletes a vertex determined by the given index of the key set.
     *
     * @param vertex index of the vertex to delete.
     */
    @Override
    public void deleteVertex(int vertex) {
        Optional<T> optionalVertex = Optional.ofNullable(getVertex(vertex));
        if(optionalVertex.isPresent() && edges.containsKey(optionalVertex.get())) {
            for (T key : edges.keySet()) {
                if(edges.get(key).contains(optionalVertex.get())) {
                    edges.remove(key, optionalVertex.get());
                    a--;
                }
            }
            edges.remove(optionalVertex.get());
            n--;
        }
    }

    /**
     * Method of O(n) that deletes the edge between two vertices determined by the given indexes of the key set.
     *
     * @param vertex1 index of vertex.
     * @param vertex2 index of vertex.
     */
    @Override
    public void deleteEdge(int vertex1, int vertex2) {
        Optional<T> optionalVertex1 = Optional.ofNullable(getVertex(vertex1));
        Optional<T> optionalVertex2 = Optional.ofNullable(getVertex(vertex2));
        if(hasEdge(vertex1, vertex2)) {
            edges.remove(optionalVertex1.get(), optionalVertex2.get());
            edges.remove(optionalVertex2.get(), optionalVertex1.get());
            a--;
        }
    }

    /**
     * Method of O(n) that checks if there is an edge between two vertices determined by the given indexes of the key set.
     *
     * @param vertex1 index of vertex.
     * @param vertex2 index of vertex.
     * @return true if the vertices are contained in the key set and there is an edge between them.
     */
    @Override
    public boolean hasEdge(int vertex1, int vertex2) {
        Optional<T> optionalVertex1 = Optional.ofNullable(getVertex(vertex1));
        Optional<T> optionalVertex2 = Optional.ofNullable(getVertex(vertex2));
        return optionalVertex1.isPresent()
                && optionalVertex2.isPresent()
                && edges.get(optionalVertex1.get()).contains(optionalVertex2.get())
                && edges.get(optionalVertex2.get()).contains(optionalVertex1.get());
    }

    /**
     * Method of O(1) that returns the total amount of edges that the graph has.
     *
     * @return amount of edges.
     */
    @Override
    public int amoutOfEdges() {
        return a;
    }

    /**
     * Method of O(1) that returns the total amount of vertices that the graph has.
     *
     * @return amount of vertices.
     */
    @Override
    public int order() {
        return n;
    }

    /**
     * Method of O(n) that returns the adyacency list of a vertex determined by the given index of the key set.
     *
     * @param vertex index of vertex.
     * @return adyacency list of @param vertex.
     */
    @Override
    public Set<T> getAdyacencyList(int vertex) {
        Optional<T> optionalVertex = Optional.ofNullable(getVertex(vertex));
        if (optionalVertex.isPresent()) {
            return edges.get(optionalVertex.get());
        } else {
            return Collections.emptySet();
        }
    }

    /**
     * Method of O(n) that returns the value of a vertex determined by the given index of the key set.
     *
     * @param vertex index of vertex.
     * @return value of vertex.
     */
    @Override
    public T getVertex(int vertex) {
        if(!edges.keySet().isEmpty() && vertex < n && vertex >= 0) {
            List<T> auxList = new ArrayList<>(edges.keySet());
            return auxList.get(vertex);
        } else {
            return null;
        }
    }

    /**
     * Method of O(n) that returns the index of a vertex determined by the given value of the vertex.
     *
     * @param vertex index of vertex.
     * @return value of vertex.
     */
    public int getVertex(T vertex) {
        Optional<T> optionalVertex = Optional.ofNullable(vertex);
        if(!edges.keySet().isEmpty() && optionalVertex.isPresent()) {
            List<T> auxList = new ArrayList<>(edges.keySet());
            return auxList.indexOf(vertex);
        } else {
            return -1;
        }
    }

}
