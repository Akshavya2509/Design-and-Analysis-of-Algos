package AdvancedDSA;
import java.util.*;
public class knapsack {
    public static void conquer(int cst[], int pt[], int arr[], int si, int mid, int ei)
    {
        int merged[] = new int[ei - si + 1];
        int pt1[] = new int[ei - si + 1];
        int cst1[] = new int[ei - si + 1];
        int idx1 = si;
        int idx2 = mid + 1;
        int x = 0;

        while(idx1 <= mid && idx2 <= ei)
        {
            if(arr[idx1] > arr[idx2])
            {
                merged[x] = arr[idx1];
                pt1[x] = pt[idx1];
                cst1[x] = cst[idx1];
                x ++;
                idx1 ++;
            }

            else
            {
                merged[x] = arr[idx2];
                pt1[x] = pt[idx2];
                cst1[x] = cst[idx2];
                x ++;
                idx2 ++;
            }
        }

        while(idx1 <= mid)
        {
            merged[x] = arr[idx1]; 
            pt1[x] = pt[idx1];
            cst1[x] = cst[idx1];
            x ++;
            idx1 ++; 
        }

        while(idx2 <= ei)
        {
            merged[x] = arr[idx2]; 
            pt1[x] = pt[idx2];
            cst1[x] = cst[idx2];
            x ++;
            idx2 ++; 
        }

        for(int i = 0, j = si; i < merged.length; i ++, j ++)
        {
            arr[j] = merged[i];
            pt[j] = pt1[i];
            cst[j] = cst1[i];
        }
    }
    public static void divide(int cst[], int prof[], int rat[], int si, int ei)
    {
        if(si >= ei)
        {
            return;
        }

        int mid = si + (ei - si) / 2;

        divide(cst, prof, rat, si, mid);
        divide(cst, prof, rat, mid + 1, ei);
        conquer(cst, prof, rat, si, mid, ei);
    }

    public static int knpsck(int ratio[], int profit[], int cost[], int n, int target)
    {
        int p = 0;

        for(int i = 0; i < n ; i ++)
        {
            if(target - cost[i] <= 0)
            {
                p += ((double)target / cost[i]) * profit[i];
                target = 0;
                break;
            }

            else
            {
                p += profit[i];
                target -= cost[i];
            }
        }

        return p;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cost[] = new int[n];
        int profit[] = new int[n];
        int ratio[] = new int[n];

        for(int i = 0; i < n ; i ++)
        {
            cost[i] = sc.nextInt();
        }

        for(int i = 0; i < n ; i ++)
        {
            profit[i] = sc.nextInt();
            ratio[i] = profit[i] / cost[i];
        }

        divide(cost, profit, ratio, 0, n  - 1);

        for(int i = 0; i < n ; i ++)
        {
            System.out.print(cost[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < n; i ++)
        {
            System.out.print(profit[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < n ; i ++)
        {
            System.out.print(ratio[i] + " ");
        }

        int target = sc.nextInt();

        System.out.println(knpsck(ratio, profit, cost, n, target));
    }
}
