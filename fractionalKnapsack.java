/*
Author: Greg Lee
Class: Algorithms
Date: 5/26/17
Lab 2 -- Knapsack Problem

Purpose: Implement the Fractional Knapsack algorithm and then compare to the 0-1 Fractional Knapsack algorithm
*/

/*
Outputs

Fractional Knapsack
Sample 1: 160.0
Sample 2: 407.8
Sample 3: 5073.27

0-1 Knapsack
Sample 1: 146
Sample 2: 392
Sample 3: 4287

To get the 0-1 Knapsack and Fractional Knapsack to return the same value, the total weight of
all items must equal the knapsack's capacity.

If the 0-1 Knapsack problem would be optimal, the value would be higher and use more of the bag's total capacity instead of just putting items in.
*/


public class FractionalKnapsack {


  //Calculates the maximum value of items that can be put into the knapsack
  public static double fracKnapsack(int capacity, double weight[], double value[])
  {
    double sum = 0;
    double ratio[] = new double[weight.length];

    for (int i = 0; i < weight.length; i++)
    {
      ratio[i] = value[i] / weight[i];
    }

    //calls the descendSort function
    descendSort(ratio, weight, value);

    for(int i = 0; i< weight.length; i++)
    {
      if (weight[i] <= capacity)
      {
      sum += value[i];
      capacity -= weight[i];
      }

    else
      {
      double frac = capacity / weight[i];
      sum += frac * value[i];
      capacity -= frac * weight[i];
      }
    }

    return sum;
  }


  public static void main(String[] args)
  {
    //Sample 1 data
    int knapsackCap1 = 190;
    double knapsackWeight1[] = {56.0 ,59.0, 80.0, 64.0, 75.0, 17.0};
    double knapsackValues1[] = {50.0 ,50.0, 64.0, 46.0, 50.0, 5.0};

    //Sample 2 data
    int knapsackCap2 = 405;
    double knapsackWeight2[] = {450, 404, 411, 450, 365, 347, 382, 433 ,333,429};
    double knapsackValues2[] = {170, 392, 266, 190, 62, 264, 175, 436, 231, 262};

    //Sample 3 data
    int knapsackCap3 = 7500;
    double knapsackWeight3[] = {2042, 11375, 1374, 1654, 1544, 1206, 1334, 1506, 1310, 1332, 1482, 1278, 884, 686, 844, 2129, 1539, 1291,1545,1115};
    double knapsackValues3[] = {668, 6635, 633, 626, 666, 621, 614, 570, 684, 550, 781, 597, 647, 767, 590, 597, 521, 749, 561, 753};

    //Our data
    int knapsackCap4 = 200;
    double knapsackWeights4[] = {22, 68, 40, 60, 10};
    double knapsackValues4[] = {50, 25, 10, 60, 35};

    //Prints the maximum
    System.out.println("The maximum value for Sample 1: " + fracKnapsack(knapsackCap1, knapsackWeight1, knapsackValues1));
    System.out.println("The maximum value for Sample 2: " + fracKnapsack(knapsackCap2, knapsackWeight2, knapsackValues2));
    System.out.println("The maximum value for Sample 3: " + fracKnapsack(knapsackCap3, knapsackWeight3, knapsackValues3));

    System.out.println("The maximum value for Sample 4: " + fracKnapsack(knapsackCap4, knapsackWeights4, knapsackValues4));

  }


  //sort weights, values in descending order by ratio
  public static double[] descendSort(double ratio[], double weight[], double value[])
  {
    double temp1, temp2, temp3;

    for(int i = 0; i < ratio.length - 1; i++)
    {
      for(int j = 1; j < ratio.length - i; j++)
      {
        if(ratio[j - 1] < ratio[j])
        {
          temp1 = ratio[j - 1];
          ratio[j - 1] = ratio[j];
          ratio[j] = temp1;

          temp2 = weight[j - 1];
          weight[j - 1] =weight[j];
          weight[j] = temp2;

          temp3 = value[j - 1];
          value[j - 1] = value[j];
          value[j] = temp3;
        }
      }
    }

    return ratio;
  }

}
