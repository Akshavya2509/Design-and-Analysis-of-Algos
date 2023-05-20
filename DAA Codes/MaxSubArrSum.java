package AdvancedDSA;
import java.util.*;
public class MaxSubArrSum {
    public static int CrossSum(int arr[], int si, int mid, int ei)
    {
        int sumLft = 0, sumRght = 0, sum = -999999;

        for(int i = mid; i >= si; i --)
        {
            sumLft += arr[i];
            if(sum < sumLft)
            {
                sum = sumLft;
            }
        }

        sumLft = sum;
        sum = -999999;

        for(int i = mid + 1; i <= ei; i ++)
        {
            sumRght += arr[i];
            if(sum < sumRght)
            {
                sum = sumRght;
            }
        }

        sumRght = sum;

        return sumLft + sumRght;
    }

    public static int maxSubArrSum(int arr[], int si, int ei)
    {
        if(si >= ei)
        {
            return arr[ei];
        }

        int mid = si + (ei - si) / 2;
        int RgtSdSum = maxSubArrSum(arr, mid + 1, ei);
        int LftSdSum = maxSubArrSum(arr, si, mid);
        int CrssSum = CrossSum(arr, si, mid, ei);

        double max = Math.max((double)RgtSdSum, (double)LftSdSum);

        return (int)Math.max(max, (double)CrssSum);
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);

        int n = sc.nextInt();

        int nums[] = new int[n];

        for(int i = 0; i < n ; i ++)
        {
            nums[i]  =sc.nextInt();
        }

        System.out.println(maxSubArrSum(nums, 0, nums.length - 1));
    }
}