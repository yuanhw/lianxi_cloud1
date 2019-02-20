package lianxi.cloud.test.comm;

import java.util.concurrent.*;

/**
 * @author: WangYuanHang
 * @Description:
 * @date: 2019/2/19 11:14
 */
public class BaseTest {
    private static ExecutorService singleThreadPool = Executors.newFixedThreadPool(1024);

    public static <T> void execTest(Runnable runnable, int count) {
        for (int i = 0; i < count; i++) {
            singleThreadPool.execute(runnable);
        }
        singleThreadPool.shutdown();
    }

}
