package lianxi.cloud.zuul0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author: WangYuanHang
 * @Description:
 * @date: 2019/2/21 17:10
 */
@SpringBootApplication
@EnableZuulProxy
public class Zuul0Application {
    public static void main(String[] args) {
        System.out.println("zuul0 start...");
        SpringApplication.run(Zuul0Application.class, args);
        System.out.println("zuul0 end...");
    }
}
