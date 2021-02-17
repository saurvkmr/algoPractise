package practise.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class APIRateLimitSlidingWindow {
    private static Map<String, ReqCount> rateLimiterMap = new HashMap<>();
    private static int reqAllowed = 5;
    private static int timeWindow = 3; // in seconds

    public static void main(String[] args) throws InterruptedException {
        Random randomSleep = new Random();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(randomSleep.nextInt(2000));
            if (!rateLimiterFixedWindow("saurav")) {
                System.out.println("429 " + i);
                break;
            }
        }
    }

    private synchronized static boolean rateLimiterFixedWindow(String name) {
        ReqCount reqCount = rateLimiterMap.getOrDefault(name, null);
        if (reqCount == null)
            rateLimiterMap.put(name, new ReqCount(1));
        else {
            long lastAccessedTime = reqCount.getTimeStamp();
            if (System.currentTimeMillis() - lastAccessedTime > timeWindow * 1000) {
                reqCount.setReqCount(1);
            } else if (reqCount.getReqCount() < reqAllowed) {
                reqCount.setReqCount(reqCount.getReqCount() + 1);
            } else {
                return false;
            }
            rateLimiterMap.put(name, reqCount);
        }
        return true;
    }

    private static class ReqCount {
        private int reqCount;
        private long timeStamp;

        public ReqCount(int count) {
            this.reqCount = count;
            this.timeStamp = System.currentTimeMillis();
        }

        public ReqCount(int count, long timeStamp) {
            this.reqCount = count;
            this.timeStamp = timeStamp;
        }

        public int getReqCount() {
            return reqCount;
        }

        public void setReqCount(int reqCount) {
            this.reqCount = reqCount;
        }

        public long getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(long timeStamp) {
            this.timeStamp = timeStamp;
        }
    }
}
