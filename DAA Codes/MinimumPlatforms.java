package AdvancedDSA;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class MinimumPlatforms {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> d = new ArrayList<>();

        for(int i = 0; i < n; i ++)
        {
            a.add(sc.nextInt());
        }

        for(int i = 0; i < n; i ++)
        {
            d.add(sc.nextInt());
        }

        Collections.sort(a);
        Collections.sort(d);

        int i = 1, platform = 1, j = 0;
        while(i < n)
        {
            if(a.get(i) < d.get(j))
                platform ++;

            else
                j ++;

            i ++;
        }

        System.out.println(platform);
    }
}
