import java.util.*;
import java.util.Queue;
public class RottenOranges {

    //Pair class to input the array indexes
    static class pair{
        int first;
        int second;
        pair(int a,int b){
            this.first=a;
            this.second=b;
        }

        // Checks validity of right
        public boolean RightisValid(int n, int m, pair e)
        {
            if(e.second + 1 >= m)
            {
                return false;
            }

            else{
                return true;
            }
        }

        // Checks validity of left
        public boolean leftIsvalid(int n, int m, pair e)
        {
            if(e.second - 1 < 0)
            {
                return false;
            }

            else{
                return true;
            }
        }

        //Checks validity of up
        public boolean UpisValid(int n, int m, pair e)
        {
            if(e.first - 1 < 0)
            {
                return false;
            }

            else{
                return true;
            }
        }

        //checks validity of down
        public boolean DownIsValid(int n, int m, pair e)
        {
            if(e.first + 1 >= n)
            {
                return false;
            }

            else{
                return true;
            }
        }
    }

    public static int IsValid(int arr[][], int n, int m, int count)
    {
        for(int i = 0; i < n ; i ++)
        {
            for(int j = 0 ; j < m; j ++)
            {
                if(arr[i][j] == 1)
                {
                    return -1;
                }
            }
        }

        return count;
    }

    // Driver Code + Algorithm Part
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[][] = new int[n][m];
        Queue <pair> q = new LinkedList<>();

        // Array Input
        for(int i = 0; i < n ; i ++)
        {
            for(int j = 0; j < m; j ++)
            {
                arr[i][j] = sc.nextInt();

                if(arr[i][j] == 2)
                {
                    pair k = new pair(i, j);
                    q.add(k);
                }
            }
        }

        int count = 0;

        // Computation of number of days
        while(!q.isEmpty())
        {
            int c = 0;
            int s = q.size();

            for(int i = 0; i < s ; i ++)
            {
                pair p = new pair(0, 0);

                if(p.RightisValid(n, m, q.peek()))
                {
                    pair e1 = q.peek();
                    int a = e1.first;
                    int b = e1.second + 1;
                    if(arr[a][b] == 1)
                    {
                        arr[a][b] = 2;
                        pair e = new pair(a, b);
                        q.add(e);
                        c ++;
                    }
                }

                if(p.leftIsvalid(n, m, q.peek()))
                {
                    pair e1 = q.peek();
                    int a = e1.first;
                    int b = e1.second - 1;
                    if(arr[a][b] == 1)
                    {
                        arr[a][b] = 2;
                        pair e = new pair(a, b);
                        q.add(e);
                        c ++;
                    }
                }

                if(p.UpisValid(n, m, q.peek()))
                {
                    pair e1 = q.peek();
                    int a = e1.first - 1;
                    int b = e1.second;
                    if(arr[a][b] == 1)
                    {
                        arr[a][b] = 2;
                        pair e = new pair(a, b);
                        q.add(e);
                        c ++;
                    }
                }

                if(p.DownIsValid(n, m, q.peek()))
                {
                    pair e1 = q.peek();
                    int a = e1.first + 1;
                    int b = e1.second;
                    if(arr[a][b] == 1)
                    {
                        arr[a][b] = 2;
                        pair e = new pair(a, b);
                        q.add(e);
                        c ++;
                    }
                }

                q.remove();
            }
            
            if(c > 0)
            {
                count ++;
            }
        }

        for(int i = 0; i < n ; i ++)
        {
            for(int j = 0; j < m; j ++)
            {
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println(IsValid(arr, n, m, count));
    }
}