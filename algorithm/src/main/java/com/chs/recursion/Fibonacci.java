package com.chs.recursion;

/**
 * @program: hello-algorithm
 * @description:
 * @author: hons.chang
 * @since: 2024-01-25 18:56
 **/
public class Fibonacci {

    /**
     * {0,1,1,2,3,5,8,13,21,34,55,89,144,233,377}
     */
    public static void main(String[] args) {
        System.out.println(fibonacci(7));
    }


    /**
     * f(n) = f(n-1) + f(n-2)
     */
    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
