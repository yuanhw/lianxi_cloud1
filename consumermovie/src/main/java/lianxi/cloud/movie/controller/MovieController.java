package lianxi.cloud.movie.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lianxi.cloud.movie.entity.User;
import lianxi.cloud.movie.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

/**
 * @author: WangYuanHang
 * @Description:
 * @date: 2019/2/18 13:11
 */
@Import(FeignClientsConfiguration.class)
@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.userFeignClient.findById(id);
    }

    public User findByIdFallback(Long id) {
        User user = new User();
        user.setId(0L);
        user.setName("---");
        user.setAge(0);
        user.setUserName("---");
        user.setBalance(BigDecimal.valueOf(0));
        return user;
    }
}
