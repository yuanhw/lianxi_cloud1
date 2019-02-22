package lianxi.cloud.test;

import lianxi.cloud.test.comm.BaseTest;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

/**
 * @author: WangYuanHang
 * @Description:
 * @date: 2019/2/19 11:12
 */
public class Main {
    public static void main(String[] args) {
        BaseTest.execTest(() -> {
            // 获取堆内存的初始值和最大值
            // 物理内存的1/64
            long l = Runtime.getRuntime().totalMemory();// 字节
            // 物理内存的1/4
            long m = Runtime.getRuntime().maxMemory();
            // totalMemory:121MB
            System.out.println("l=" + l / 1024 / 1024 + "MB");
            // maxMemory:1787MB
            System.out.println("Max=" + m / 1024 / 1024 + "MB");
        }, 1);
    }
}
