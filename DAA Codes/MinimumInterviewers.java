package AdvancedDSA;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class MinimumInterviewers {
    public static int Interviewers(ArrayList<Integer> a, ArrayList<Integer> d, int n)
    {
        int i = 1, Interviewers = 1, j = 0, chkStu = 1;
        while(i < n)
        {
            if(a.get(i) < d.get(j))
            {
                if(chkStu < 3)
                {
                    j ++;
                    continue;
                }
                Interviewers ++;
                chkStu = 0;
            }

            else
            {
                j ++;
                chkStu ++;
            }

            i ++;
        }

        return Interviewers;
    }
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

        System.out.println(Interviewers(a, d, n));
    }
}
