package EjercicioD;

import java.util.Iterator;

public class DFS {
   private static void DFSUtil(GraphAdjacencyList graph,int v,boolean visited[]) {
       // Mark the current node as visited and print it
       visited[v] = true;
       System.out.print(v + " ");

       // Recur for all the vertices adjacent to this vertex
       Iterator<Integer> i = graph.getAdj()[v].listIterator();
       while (i.hasNext()) {
           int n = i.next();
           if (!visited[n])
               DFSUtil(graph, n, visited);
       }
   }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    public static void DFSMethod(GraphAdjacencyList graph, int s)
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[graph.getV()];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(graph, s, visited);
    }
}
