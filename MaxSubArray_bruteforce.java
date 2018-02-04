/*
 Author: Greg Lee
 Date: 5/19/17
 Class: Algorithms
 Lab 1 -- Maximum Subarray Problem
 
 Purpose: This is a brute force implementation of the MaxSubArray algorithm. My partner created the recursive version. We then compared the outputs of both to see which program returned the answer the quickest.
*/

import java.util.Random;
import java.util.Scanner;

public class MaxSubArray
{

    //Function that computes the max sub-array
    public static int findMaxSubArray(int maxArray[])
    {
        int max = 0;
        for(int i = 0; i < maxArray.length; i++)
        {
            int sum = 0;

            for(int j = i; j < maxArray.length; j++)
            {
                sum += maxArray[j];

                if(sum > max)
                {
                    max = sum;
                }
            }
        }

        return max;
    }


    public static void main(String[] args)
    {
        //variable that stores the array's size
        int arraySize;

        //Header
        System.out.println("Maximum Sub-Array\n");

        //prompt user for input
        System.out.print("Please enter the size of the array: ");
        Scanner input = new Scanner(System.in);
        arraySize = input.nextInt();

        //init array to the size that the user entered
        int array[] = new int[arraySize];

        //init Random to calculate a random number
        Random rand = new Random();
        
        //sets boundaries for the randomly generated number
        int max_number = 100;
        int min_number = -100;

        //Prints out the contents of the array
        System.out.println("The array: ");

        for(int i = 0; i < array.length; i++)
        {
            //generates a random number
            array[i] = rand.nextInt((max_number - min_number) + 1) + min_number;
            System.out.print(array[i] + " ");
        }

        System.out.println("\n");

        //start a clock to count how long it takes the function defined above to find the max sub array
        long startTime = System.nanoTime();

        //prints the maximum sub-array value
        int maximum_sub_array = findMaxSubArray(array);
        System.out.println("The maximum sub-array is: " + maximum_sub_array);

        //calculate how long the function took to find the max sub array
        double totalTime = System.nanoTime() - startTime;

        //prints out how long it took to calculate the max sub array
        System.out.println("Time to complete: " + totalTime / 1000000 + " milliseconds");
    }
}
