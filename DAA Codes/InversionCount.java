import java.util.*;

public class InversionCount {
    static int c = 0;

    public static void conquer(int arr[], int strtIdx, int mid, int EndIdx)
    {
        int merged[] = new int[EndIdx - strtIdx + 1];
        int idx1 = strtIdx;
        int idx2 = mid + 1;
        int x = 0, count = 0;

        while(idx1 <= mid && idx2 <= EndIdx)
        {
            if(arr[idx1] <= arr[idx2])
            {
                merged[x ++] = arr[idx1 ++];
            }

            else{
                /* 
                if(count == 0)
                c += idx2 - idx1;

                else*/

                c += idx2 - idx1 - count;

                merged[x ++] = arr[idx2++];

                // count will fix the array
                count ++;
            }
        }
        while(idx1 <= mid)
        {
            merged[x++] = arr[idx1++];  
        }

        while(idx2 <= EndIdx)
        {
            merged[x++] = arr[idx2++];
        } 

        for(int i = 0, j = strtIdx; i < merged.length; i ++, j ++)
        {
            arr[j] = merged[i];
        }
    }

    public static void divide(int arr[], int strtIdx, int EndIdx)
    {
        if(strtIdx >= EndIdx)
        {
            return;
        }

        int mid = strtIdx + (EndIdx - strtIdx) / 2;

        divide(arr, strtIdx, mid);
        divide(arr, mid+1, EndIdx);
        conquer(arr, strtIdx, mid, EndIdx);
    }
    public static void main(String[] args) {

        int arr[] = {2,1,3,1,2};

        int n = arr.length;

        divide(arr, 0, n - 1);

        System.out.println(c);
    }
}
