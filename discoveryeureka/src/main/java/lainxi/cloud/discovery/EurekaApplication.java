package lainxi.cloud.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: WangYuanHang
 * @Description:
 * @date: 2019/2/18 13:36
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main(String[] args) {
        System.out.println("eureka server begin...");
        SpringApplication.run(EurekaApplication.class, args);
        System.out.println("eureka server end...");
    }
}
