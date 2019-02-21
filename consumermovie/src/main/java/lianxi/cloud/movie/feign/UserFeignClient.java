package lianxi.cloud.movie.feign;

import feign.hystrix.FallbackFactory;
import lianxi.cloud.movie.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: WangYuanHang
 * @Description:
 * @date: 2019/2/18 16:51
 */
@FeignClient(name = "user-service", configuration = FeignLogConfiguration.class, fallbackFactory = FeignClientFallbackFactory.class)
public interface UserFeignClient {
    /**
     * 通过用户ID查询用户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);
}

@Component
class FeignClientFallback implements UserFeignClient{
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-1L);
        return user;
    }
}

@Component
class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
    private static Logger logger = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable throwable) {
        return id -> {
            logger.info("fallback reason is", throwable);
            User user = new User();
            user.setId(-1L);
            return user;
        };
    }
}
