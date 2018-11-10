package EjercicioD;

import java.util.LinkedList;

public class BusquedaPlana {

    //Using GraphAdjacencyList

    public static void BusquedaPlanaMethod(GraphAdjacencyList graph){
        for (int i=0; i<graph.getAdj().length; i++){
            System.out.print(i+ ": " + graph.getAdj()[i] + " ");
        }

    }
}
