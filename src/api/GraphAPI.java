package api;

import impl.ListGraph;
import impl.MatrixGraph;

public class GraphAPI {

    public static int calculateLoops(MatrixGraph graph) {
        int loops = 0;
        for(int i = 0; i < graph.getN(); i++) {
            if (graph.getEdges()[i][i]) {
                loops++;
            }
        }
        return loops;
    }

}
