package util;

import static java.lang.Math.sqrt;

public class MathFunctions {
    public static boolean PrimeCheck(int p) {


        if (p < 2){
            return false;
        }
        else if (p < 4) {
            return true;
        }
        else if (p%2==0 || p%3==0) {
            return false;
        }
        else {
            int i = 5;
            while(i*i <= p){
                if (p % i == 0 || p % (i + 2) == 0) {
                    return false;
                }
                i = i + 6;
            }
            return true;
        }
    }
    public static int[] Factorize(int i){
        int j[] = new int[2];
        j[0] = (int)sqrt(i);
        while (i % j[0] != 0){
            j[0]--;
        }
        j[1] = i / j[0];

        return j;
    }
}
