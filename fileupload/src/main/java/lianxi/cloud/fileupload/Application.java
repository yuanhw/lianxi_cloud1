package lianxi.cloud.fileupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: WangYuanHang
 * @Description:
 * @date: 2019/2/22 9:12
 */
@SpringBootApplication
@EnableEurekaClient
public class Application {
    public static void main(String[] args) {
        System.out.println("file upload start...");
        SpringApplication.run(Application.class, args);
        System.out.println("file upload end...");
    }
}
