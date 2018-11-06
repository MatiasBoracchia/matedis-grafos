package struct;

import java.util.List;

public interface Graph<T> {

    void addVertex(T vertex);

    void addEdge(int vertex, T value);

    void deleteVertex(int vertex);

    void deleteEdge(int vertex, T value);

    boolean hasEdge(int vertex, T value);

    int amoutOfEdges();

    int order();

    T vertexAt(int vertex);

    List<T> getAdyacencyList(int vertex);

}
