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
            String url = "http://localhost:10011/movie/user/3";
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(url);
            try {
                httpClient.execute(httpGet);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }, 30);
    }
}
