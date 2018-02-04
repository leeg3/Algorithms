/*
Author: Greg Lee
Class: Algorithms
Date: 7/21/17
Lab 6 -- Quicksort

Purpose: My partner and I implemented the Original Quicksort and the Randomized Quicksort respectively given to us in the lab doc. We then compare the answers and determine if the randomized quicksort provides a better pivot point than the original quicksort algorithm.

Generated Array 1:
81 1 38 63 45 39 23 94 13 22 6 19 19 76 22 32 61 53 43 44

First pivot: 44
Elements on the Right: 7
Elements on the Left: 12

Generated Array 2: 44 92 40 71 48 54 70 17 93 18 43 68 67 1 70 1 22 51 74 46

First pivot: 46
Elements on the Right: 11
Elements on the Left: 8

Generated Array 3: 94 59 5 49 82 68 35 48 71 4 28 16 38 18 44 9 50 88 76 100

First pivot: 100
Elements on the Right: 0
Elements on the Left: 19
*
*/
import java.util.Random;
public class OrigQuickSort
{

    public static void main(String[] args)
    {
        Random random = new Random();
        int random_array[] = new int[20];
        int sorted_array[] = new int[20];

        //Generates random array
        System.out.println("Random Array");
        for (int i = 0; i < random_array.length; i++)
        {
            random_array[i] = random.nextInt(100) + 1;
            System.out.print(random_array[i] + " ");
        }

        System.out.println("");

        //Generates sorted array
        System.out.println("Sorted Array");
        for (int i = 0; i < sorted_array.length; i++)
        {
            sorted_array[i] = i + 1;
            System.out.print(sorted_array[i] + " ");
        }

        System.out.println("");
        System.out.println("");

        System.out.println("");
        System.out.println("");

        //System.out.println("Sorted Array");


        //calls QuickSort
        QuickSort(sorted_array, 0, sorted_array.length - 1);

        for(int i = 0; i < sorted_array.length; i++)
        {
            System.out.print(sorted_array[i] + " ");
        }




    }

    //Quicksort function
    public static void QuickSort(int Arr[], int p, int r)
    {
        int q; //pivot
        if(p < r)
        {
            //call Partition once and Quicksort twice
            q = Partition(Arr, p, r);
            QuickSort(Arr, p, q - 1);
            QuickSort(Arr, q + 1, r);
        }
    }

    public static int Partition(int A[], int p, int r)
    {
        int i, x, temp, temp2;

        x = A[r]; //pivot

        System.out.println("Pivot = " + x);

        i = p - 1;

        //iterates through the array and shifts the pivot
        for(int j = p; j <= r - 1; j++)
        {
            if(A[j] <= x)
            {
                i += 1;
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }

        }

        temp2 = A[i+1];
        A[i+1] = A[r];
        A[r] = temp2;

        //prints out array with modified pivot
        for(int k = 0; k < A.length; k++)
        {
            System.out.print(A[k] + " ");
        }

        //returns pivot
        return i+1;
    }



}
