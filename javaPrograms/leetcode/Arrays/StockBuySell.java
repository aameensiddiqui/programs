class StockBuySell
{
    public static int solution(int[]prices)
    {
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i = 0; i < prices.length; ++i) {
            if(prices[i] < minPrice) minPrice = prices[i];
            else if((prices[i] - minPrice) > maxProfit) maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }
    public static void main(String[]args)
    {
        int[]prices = {7,1,5,3,6,4};
        System.out.println(solution(prices));
    }
}

/*
Stock Buy And Sell

Problem Statement: You are given an array of prices where prices[i]
is the price of a given stock on an ith day.

You want to maximize your profit by choosing a single day to buy one stock
and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction.
If you cannot achieve any profit, return 0.

Brute Force Approach
Algorithm / Intuition
Intuition: We can simply use 2 loops and track every transaction and maintain
a variable maxPro to contain the max value among all transactions.

Approach: 

Use a for loop of 'i' from 0 to n.
Use another for loop of j from 'i+1' to n.
If arr[j] > arr[i] , take the difference and compare  and store it in the maxPro variable.
Return maxPro.

import java.util.*;
public class Main {
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};
        int maxPro = maxProfit(arr);
        System.out.println("Max profit is: " + maxPro);
    }

    static int maxProfit(int[] arr) {
        int maxPro = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    maxPro = Math.max(arr[j] - arr[i], maxPro);
                }
            }
        }
        return maxPro;
    }
}
------------------------
Optimal Approach
Algorithm / Intuition
Intuition: We will linearly travel the array. We can maintain a minimum from
the start of the array and compare it with every element of the array,
if it is greater than the minimum then take the difference and maintain it in max,
otherwise update the minimum.

Approach:

Create a variable maxPro and store 0 initially.
Create a variable minPrice and store some larger value(ex: MAX_VALUE) value initially.
Run a for loop from 0 to n.
Update the minPrice if it is greater than the current element of the array
Take the difference of the minPrice with the current element of the array and
compare and maintain it in maxPro.
Return the maxPro.



import java.util.*;

public class Main {

    public static void main(String[] args) {
    int arr[] = {7,1,5,3,6,4};

    int maxPro = maxProfit(arr);
    System.out.println("Max profit is: " + maxPro);

    }
    static int maxProfit(int[] arr) {
    int maxPro = 0;
    int minPrice = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
        minPrice = Math.min(minPrice, arr[i]);
        maxPro = Math.max(maxPro, arr[i] - minPrice);
    }
    return maxPro;
    }
}
 */
