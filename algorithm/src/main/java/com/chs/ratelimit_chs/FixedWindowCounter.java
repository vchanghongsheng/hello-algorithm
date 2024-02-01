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

    private static int qps = 2;

    //时间间隔,一分钟
    private static int interval = 60 * 1000 * 1000;

    //当前时间
    private static int startTime;

    /**
     * 如果当前时间与开始时间的时间差大于时间间隔,则重置开始时间和计数器
     * 如果计数器小于qps,则计数器加1,否则拒绝访问
     */
    public boolean rateLimit() {
        return true;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            FixedWindowCounter fixedWindowCounter = new FixedWindowCounter();
            if (fixedWindowCounter.rateLimit()) {
                System.out.println("正常访问");
            } else {
                System.out.println("访问受限");
            }
        }
    }




}
