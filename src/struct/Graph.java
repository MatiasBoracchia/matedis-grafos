package struct;

import java.util.Set;

public interface Graph<T> {

    void addVertex(T vertex);

    void addEdge(int vertex1, int vertex2);

    void deleteVertex(int vertex);

    void deleteEdge(int vertex1, int vertex2);

    boolean hasEdge(int vertex1, int vertex2);

    int amoutOfEdges();

    int order();

    Set<T> getAdyacencyList(int vertex);

    T getVertex(int vertex);

}
