package lianxi.cloud.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author: WangYuanHang
 * @Description:
 * @date: 2019/2/21 13:44
 */
@SpringBootApplication
@EnableTurbine
public class Application {
    public static void main(String[] args) {
        System.out.println("dashboard start...");
        SpringApplication.run(Application.class, args);
        System.out.println("dashboard end...");
    }
}
