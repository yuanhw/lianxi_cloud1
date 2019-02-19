package lianxi.cloud.movie.feign;

import lianxi.cloud.movie.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: WangYuanHang
 * @Description:
 * @date: 2019/2/18 16:51
 */
@FeignClient(name = "user-service", configuration = FeignLogConfiguration.class)
public interface UserFeignClient {
    /**
     * 通过用户ID查询用户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);
}
