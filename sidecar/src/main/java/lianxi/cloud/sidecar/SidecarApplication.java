package lianxi.cloud.sidecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author: WangYuanHang
 * @Description:
 * @date: 2019/2/21 17:10
 */
@SpringBootApplication
@EnableSidecar
public class SidecarApplication {
    public static void main(String[] args) {
        System.out.println("sidecar start...");
        SpringApplication.run(SidecarApplication.class, args);
        System.out.println("sidecar end...");
    }
}
