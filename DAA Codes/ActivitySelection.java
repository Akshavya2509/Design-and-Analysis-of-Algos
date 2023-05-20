package AdvancedDSA;
import java.util.*;
public class ActivitySelection {

    public static void conquer(int six[], int arr[], int si, int mid, int ei)
    {
        int merged[] = new int[ei - si + 1];
        int six1[] = new int[ei - si + 1];
        int idx1 = si;
        int idx2 = mid + 1;
        int x = 0;

        while(idx1 <= mid && idx2 <= ei)
        {
            if(arr[idx1] <= arr[idx2])
            {
                merged[x] = arr[idx1];
                six1[x] = six[idx1];
                x ++;
                idx1 ++;
            }

            else
            {
                merged[x] = arr[idx2];
                six1[x] = six[idx2];
                x ++;
                idx2 ++;
            }
        }

        while(idx1 <= mid)
        {
            merged[x] = arr[idx1]; 
            six1[x] = six[idx1];
            x ++;
            idx1 ++; 
        }

        while(idx2 <= ei)
        {
            merged[x] = arr[idx2]; 
            six1[x] = six[idx2];
            x ++;
            idx2 ++; 
        }

        for(int i = 0, j = si; i < merged.length; i ++, j ++)
        {
            arr[j] = merged[i];
            six[j] = six1[i];
        }
    }
    public static void divide(int strtIdx[], int EndIdx[], int si, int ei)
    {
        if(si >= ei)
        {
            return;
        }

        int mid = si + (ei - si) / 2;

        divide(strtIdx, EndIdx, si, mid);
        divide(strtIdx, EndIdx, mid + 1, ei);
        conquer(strtIdx, EndIdx, si, mid, ei);
    }

    public static int ActSelec(int endidx[], int strtIdx[], int n)
    {
        int count = 1, endI = endidx[0];

        for(int i = 1; i < n; i ++)
        {
            if(strtIdx[i] >= endI)
            {
                endI = endidx[i];
                count ++;
            }
        }

        return count;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int strtIdx[] = new int[n];
        int EndIdx[] = new int[n];

        System.out.println("Enter the strIdx");
        for(int i = 0; i < n ; i ++)
        {
            strtIdx[i] = sc.nextInt();
        }

        System.out.println("Enter the endIdx");

        for(int i = 0; i < n ; i ++)
        {
            EndIdx[i] = sc.nextInt();
        }

        divide(strtIdx, EndIdx, 0, n - 1);
        
        System.out.println(ActSelec(EndIdx, strtIdx, n));
    }

}
