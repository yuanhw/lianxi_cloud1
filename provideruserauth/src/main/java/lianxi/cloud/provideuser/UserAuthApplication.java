package lianxi.cloud.provideuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: WangYuanHang
 * @Description:
 * @date: 2019/2/18 10:36
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserAuthApplication {
    public static void main(String[] args) {
        System.out.println("user auth begin...");
        SpringApplication.run(UserAuthApplication.class, args);
        System.out.println("user auth end...");
    }
}
