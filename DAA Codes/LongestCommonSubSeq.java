package AdvancedDSA;
import java.util.*;
public class LongestCommonSubSeq {
    public static int longestCommonSubsequence(String s1, String s2) {

        int arr[][] = new int[s1.length() + 1][s2.length() + 1];

        String arrow[][] = new String[s1.length() + 1][s2.length() + 1];

        for(int i = 1; i < arr.length; i ++){

            for(int j = 1; j < arr[0].length; j ++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                    arrow[i][j] = "diagonal";
                }

                else
                {
                    if(arr[i - 1][j] == arr[i][j - 1]){
                        arr[i][j] = arr[i - 1][j];
                        arrow[i][j] = "Up";
                    }
                    else{
                        arr[i][j] = (int)Math.max(arr[i - 1][j], arr[i][j - 1]);

                        if(arr[i][j] == arr[i - 1][j])
                        {
                            arrow[i][j] = "Up";
                        }

                        else
                            arrow[i][j] = "left";
                    }
                    
                }
            }
        }
        int i = arr.length - 1, j = arr[0].length - 1;

        Stack<Character> s = new Stack<>();
        boolean Check = true;

        while(Check){
            if(i == 0 || j == 0)
            {
                Check = false;
                continue;
            }
            if(arrow[i][j] == "Up")
            {
                i -= 1;
            }

            else if(arrow[i][j] == "diagonal")
            {
                i -= 1;
                j -= 1;
                s.add(s1.charAt(i));
            }

            else
            {
                j -= 1;
            }
        }

        for(int k = s.size() - 1; k >= 0; k --)
        {
            System.out.print(s.get(k));
        }

        System.out.println();

        return arr[arr.length - 1][arr[0].length - 1];

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        System.err.println(longestCommonSubsequence(s1, s2));
    }
}
