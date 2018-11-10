package EjercicioE;

import java.util.LinkedList;

public class Bipartito {
    //final static int V = 5; // No. of Vertices

    // This function returns true if
    // graph G[V][V] is EjercicioE.Bipartito, else false
    boolean isBipartito(int[][] G,int src, int V)
    {
        // Create a color array to store
        // colors assigned to all veritces.
        // Vertex number is used as index
        // in this array. The value '-1'
        // of colorArr[i] is used to indicate
        // that no color is assigned
        // to vertex 'i'. The value 1 is
        // used to indicate first color
        // is assigned and value 0 indicates
        // second color is assigned.
        int colorArr[] = new int[V];
        for (int i=0; i<V; ++i)
            colorArr[i] = -1;

        // Assign first color to source
        colorArr[src] = 1;

        // Create a queue (FIFO) of vertex numbers
        // and enqueue source vertex for BFS traversal
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(src);

        // Run while there are vertices in queue (Similar to BFS)
        while (q.size() != 0)
        {
            // Dequeue a vertex from queue
            int u = q.poll();

            // Return false if there is a self-loop
            if (G[u][u] == 1)
                return false;

            // Find all non-colored adjacent vertices
            for (int v=0; v<V; ++v)
            {
                // An edge from u to v exists
                // and destination v is not colored
                if (G[u][v]==1 && colorArr[v]==-1)
                {
                    // Assign alternate color to this adjacent v of u
                    colorArr[v] = 1-colorArr[u];
                    q.add(v);
                }

                // An edge from u to v exists and destination
                //  v is colored with same color as u
                else if (G[u][v]==1 && colorArr[v]==colorArr[u])
                    return false;
            }
        }
        // If we reach here, then all adjacent vertices can
        // be colored with alternate color
        return true;
    }
    public static void print(boolean answr){
        System.out.print("Es bipartito? ");
        if (answr){
            System.out.println("Si");
        } else {
            System.out.println("No");
        }
    }

    // Driver program to test above function
    public static void main (String[] args)
    {
        int G[][] = {{0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };

        int E[][] = {
                {0,1,0,0,1},
                {1,0,1,0,0},
                {0,1,0,1,0},
                {0,0,1,0,1},
                {1,0,0,1,0}
        };

        Bipartito b = new Bipartito();
        print(b.isBipartito(G,0, 4));
        print(b.isBipartito(E, 0, 5));
        /*System.out.println();
        if (b.isBipartite(G, 0))
            System.out.println("Yes");
        else
            System.out.println("No");*/
    }

}
