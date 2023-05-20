package AdvancedDSA;
import java.util.*;

public class OBST {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // No. of nodes
        int n = sc.nextInt();

        // BST Nodes array
        int nodes[] = new int[n];

        //User Input
        for(int i = 0; i < n; i ++)
        {
            nodes[i] = sc.nextInt();
        }

        //Probability array
        int p[] = new int[n];

        //User Input
        for(int i = 0 ; i < n; i ++)
        {
            p[i] = sc.nextInt();
        }

        //Weighted probabilities/Frequencies
        int wt[][] = new int[n + 2][n + 2];

        //Expected cost
        int e[][] = new int[n + 2][n + 2];

        //Root Nodes
        int root[][] = new int[n + 1][n + 1];

        for(int i = 1; i < n + 2; i ++)
        {
            for(int j = i; j < n + 2; j ++)
            {
                wt[i][j] = wt[i][j - 1] + p[j];

                int min = Integer.MAX_VALUE;
                int idx = 0;

                for(int r = i; r <= j; r ++)
                { 
                    if(min < ((e[i][r - 1] + e[r + 1][j]) + wt[i][j]))
                        idx = r - 1;
                    else
                        idx = r;

                    e[i][j] = Math.min(min,((e[i][r - 1] + e[r + 1][j]) + wt[i][j]));
                    min = e[i][j];
                }

                root[i - 1][j - 1] = idx;
            }
        }

        for(int i = 0; i < e.length; i ++)
        {
            for(int j = 0; j < e[0].length; j ++)
            {
                System.out.print(e[i][j] + " ");
            }

            System.out.println();
        }
        
    }
}
