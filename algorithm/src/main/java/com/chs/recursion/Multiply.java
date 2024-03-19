package com.chs.recursion;

/**
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 *
 * @program: hello-algorithm
 * @description:
 * @author: hons.chang
 * @since: 2024-03-15 15:31
 **/
public class Multiply {


    /**
     * 先用遍历写一版
     */
    public static int multiply(int a, int b) {
        // 3 * 4 就是 4+4+4
        int min = Math.min(a, b);
        int temp = min == a ? b : a;
        int result = 0;
        for (int i = min; i > 0; i--) {
            result += temp;
        }
        return result;
    }

    /**
     * 终止条件 b==0 || a==0
     * 3*4
     * 3
     * 3+3
     * 6+3
     * 9+3
     * 公式: f(n) = a+ f(n-1)
     */
    public static int multiply2(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }

        if (a == 1) {
            return b;
        }

        if (b == 1) {
            return a;
        }
        return a + multiply2(a, b - 1);
    }

    /**
     * 进阶 俄罗斯农民乘法 减少递归次数
     * a/2 b*2
     *
     * 偶数:a/2 * b*2
     * 奇数:(a/2 * 2) * b + b     ((a/2 * 2) * b) 会丢掉一个b,需要加上
     *
     */
    public static int multiply3(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }

        if (a == 1) {
            return b;
        }

        if (b == 1) {
            return a;
        }

        if (a % 2 == 0) {
            return multiply3(a / 2, b * 2);
        }

        return b + multiply3(a / 2, b * 2);
    }



    public static void main(String[] args) {
        System.out.println(multiply3(7, 8));
    }


}
