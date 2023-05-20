// Include header file
#include <iostream>
#include <string>
#include <vector>
using namespace std;
/* This class are provide by kalkicode.com (java to c++) */
// Name of the class has to be "Main" only if the class is public.

int main()
    {
        // your code goes here
        
        int t;
        
        cin >> t;
        
        while (t != 0)
        {
            unsigned long n, h, w;
            
            cin >> n >> h >> w;
            
            unsigned long max = 0;
            unsigned long min = 0;
            
            if (h > w)
            {
                max = h * n;
            }
            
            else 
            {
                max = w * n;
            }
            
            while (min != max)
            {
                unsigned long half = min + (max - min) / 2;
                
                if (((half / h) * (half / w)) >=n)
                {
                    max = half;
                }
                else
                {
                    min = half + 1;
                }
            }
            
            cout << max << endl;
            
            t--;
        }
    }

