package com.chs.ratelimit_chs;

/**
 * 固定窗口计数器
 *
 * @program: hello-algorithm
 * @description:
 * @author: hons.chang
 * @since: 2024-02-01 09:37
 **/
public class FixedWindowCounter {
    private static int count = 0;

    private static final int qps = 2;

    /**
     * 时间间隔,5秒
     */
    private static final int interval = 5 * 1000;

    /**
     * 前窗口的开始时间
     */
    private static long startTime;

    /**
     * 如果当前时间与开始时间的时间差大于时间间隔,则重置开始时间和计数器
     * 如果计数器小于qps,则计数器加1,否则拒绝访问
     */
    public static boolean rateLimit() {
        long now = System.currentTimeMillis();
        if (now - startTime > interval) {
            startTime = now;
            count = 1;
        } else {
            if (count < qps) {
                count++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            Thread.sleep(500);
            if (FixedWindowCounter.rateLimit()) {
                System.out.println("正常访问");
            } else {
                System.out.println("访问受限");
            }
        }
    }
}
