import api.ListGraphAPI;
import impl.ListGraph;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ListGraph<Integer> listGraph;
        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.println("\n* * * * * * * * * * * * * * * * * * * * *");
            System.out.println("*                                       *");
            System.out.println("*             T.P. Grafos               *");
            System.out.println("*                                       *");
            System.out.println("* * * * * * * * * * * * * * * * * * * * *\n");
            System.out.println("* Ingrese 1 para generar un grafo aleatorio");
            System.out.println("* Ingrese 2 para generar un grafo vacío\n");
            System.out.println("* Ingrese 0 para terminar el programa\n");
            int loop = scan.nextInt();

            if (loop == 1) {

                System.out.println("\n* Ingrese la cantidad de vértices\n");
                int vertices = scan.nextInt();
                System.out.println("\n* Ingrese la cantidad de aristas\n");
                int edges = scan.nextInt();
                int maxAmountOfEdges = (int) Math.pow(vertices, 2) - vertices * (vertices - 1) / 2;
                while (edges > maxAmountOfEdges) {
                    System.out.println("\n* Ha superado la cantidad máxima de " + maxAmountOfEdges + " aristas. Ingrese un valor menor:\n");
                    edges = scan.nextInt();
                }
                System.out.println();
                listGraph = ListGraphAPI.generateIntegerGraph(vertices, edges);
                ListGraphAPI.printGraph(listGraph);

                manageGraph(listGraph, scan);

            } else if (loop == 2) {

                listGraph = new ListGraph<>();

                manageGraph(listGraph, scan);

            } else break;

        }

        scan.close();

    }

    private static void manageGraph(ListGraph<Integer> listGraph, Scanner scan) {

        while (true) {

            System.out.println("\n* * * * * * * * * * * * * * * * * * * * *\n");
            System.out.println("* Ingrese 1 para agregar un vértice");
            System.out.println("* Ingrese 2 para agregar una arista");
            System.out.println("* Ingrese 3 para imprimir el gráfo");
            System.out.println("* Ingrese 4 para ver si el grafo es bipartito\n");
            System.out.println("* Ingrese 0 para regresar al menú principal\n");
            int secondLoop = scan.nextInt();

            if (secondLoop == 1) {

                System.out.println("\n* Ingrese el valor del vértice\n");
                int vertex = scan.nextInt();
                while(listGraph.edges.containsKey(vertex)) {
                    System.out.println("\n* Ese valor ya existe. Ingrese otro:\n");
                    vertex = scan.nextInt();
                }
                listGraph.addVertex(vertex);
                System.out.println("\n* Vértice " + vertex + " agregado!\n");

            }

            if (secondLoop == 2) {

                System.out.println("\n* Ingrese el indice del primer vértice\n");
                int vertex1 = scan.nextInt();
                while((0 > vertex1) || (vertex1 >= listGraph.edges.keySet().size())) {
                    System.out.println("\n* Ese índice no existe. Ingrese otro:\n");
                    vertex1 = scan.nextInt();
                }
                System.out.println("\n* Ingrese el indice del segundo vértice\n");
                int vertex2 = scan.nextInt();
                while((0 > vertex2) || (vertex2 >= listGraph.edges.keySet().size())) {
                    System.out.println("\n* Ese índice no existe. Ingrese otro:\n");
                    vertex2 = scan.nextInt();
                }
                if(listGraph.hasEdge(vertex1, vertex2)) {
                    System.out.println("\n* Esa arista ya existe!\n");
                } else {
                    listGraph.addEdge(vertex1, vertex2);
                    System.out.println("\n* Arista entre " + vertex1 + " y " + vertex2 + " agregada!\n");
                }

            } else if (secondLoop == 3) {

                ListGraphAPI.printGraph(listGraph);

            } else if (secondLoop == 4) {

                if(ListGraphAPI.isBipartite(listGraph)) {
                    System.out.println("\n* El grafo es bipartito\n");
                } else {
                    System.out.println("\n* El grafo no es bipartito\n");
                }

            } else if (secondLoop == 0) break;

        }

    }

}
