package com.chs.recursion;

/**
 * @program: hello-algorithm
 * @description:
 * @author: hons.chang
 * @since: 2024-03-15 14:24
 **/
public class MonkeyEatsPeach {


    /**
     * 猴子第二天要吃前一天的一倍加1个桃子
     * f(n) = f(n-1) * 2 + 1
     */
    public int eat(int n) {
        if (n == 1) {
            return 1;
        }
        return eat(n - 1) / 2 + 1;
    }

    public static void main(String[] args) {
        MonkeyEatsPeach monkeyEatsPeach = new MonkeyEatsPeach();
        System.out.println(monkeyEatsPeach.eat2(1));
    }

    /**
     * 准备了10天的桃子,猴子每天吃一半加一个,第10天剩下一个,问第一天准备了多少个桃子
     * f(n) - f(n)/2 - 1 = f(n+1)
     * f(n) -2 = 2 * f(n+1)
     * f(n) = 2 * f(n+1) + 2
     */
    public int eat2(int n) {
        if (n == 10) {
            return 1;
        }
        return 2 * eat2(n + 1) + 2;
    }
}
