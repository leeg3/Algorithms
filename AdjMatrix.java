/*
Author: Greg Lee
Class: Algorithms
Date: 6/30/17
Lab 4 -- Graphs, Adjacency Matrix
 
Purpose: Parse an input graph to determine whether it contains a Eulerian path or a Eulerian circuit. This program stores the graph in an adjacency matrix. My partner implemnted this code but with an adjacency list.

*/

//Adjacency Matrix class
public class AdjMatrix {
    public static void main(String[] args) {

        //initialize sample graphs
        int adj_matrix1[][] = new int[][]{{0, 1, 1, 0},
                {1, 0, 0, 1},
                {1, 0, 0, 1},
                {0, 1, 1, 0}};

        int adj_matrix2[][] = new int[][]{{0, 1, 1, 1},
                {1, 0, 0, 1},
                {1, 0, 0, 1},
                {1, 1, 1, 0}};

        int adj_matrix3[][] = new int[][]{{0, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}};

        int adj_matrix4[][] = new int[][]{{0, 1, 1, 0, 1},
                {1, 0, 0, 1, 1},
                {1, 0, 0, 1, 1},
                {0, 1, 1, 0, 1},
                {1, 1, 1, 1, 0}};

        int adj_matrix5[][] = new int[][]{{0, 2, 1, 1},
                {2, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}};
        int adj_matrix6[][] = new int[][]{{0, 2, 1, 0, 1},
                {2, 0, 0, 1, 1},
                {1, 0, 0, 1, 1},
                {0, 1, 1, 0, 1},
                {1, 1, 1, 1, 0}};


        //Prints out whether the graph contains a path, circuit, or neither
        System.out.println("Do the graphs contain an Euler circuit or path?");

        System.out.println("Graph 1: ");
        isEulerian(adj_matrix1);

        System.out.println("Graph 2: ");
        isEulerian(adj_matrix2);

        System.out.println("Graph 3: ");
        isEulerian(adj_matrix3);

        System.out.println("Graph 4: ");
        isEulerian(adj_matrix4);

        System.out.println("Graph 5: ");
        isEulerian(adj_matrix5);

        System.out.println("Graph 6: ");
        isEulerian(adj_matrix6);


    }

    //Function to determine if the graph contains a path, circuit, or neither of them
    public static void isEulerian(int arr[][]) {

        //variables to keep track of the number of degrees on a vertex
        int count = 0;
        int temp = 0;
        int numOddDeg = 0;

        //counts the degree of each vertex
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
            {
                //if (arr[i][j] > 0) {
                    count+= arr[i][j];
                //}
            }
            temp = count % 2;
            if (temp == 1) {
                numOddDeg++;
                count = 0;
            } else {
                count = 0;
            }
        }


        //prints out if the graph has a path or circuit
        if (numOddDeg == 0) {
            System.out.println("Eulerian circuit!");
        } else if (numOddDeg == 2) {
            System.out.println("Eulerian path!");
        } else {
            System.out.println("No Eulerian path or circuit!");
        }

    }
}
