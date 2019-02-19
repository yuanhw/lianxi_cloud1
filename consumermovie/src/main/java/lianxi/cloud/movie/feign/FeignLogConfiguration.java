package lianxi.cloud.movie.feign;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: WangYuanHang
 * @Description:
 * @date: 2019/2/19 10:09
 */
@Configuration
public class FeignLogConfiguration {
    @Bean
    Logger.Level feignLogLevel() {
        return Logger.Level.FULL;
    }
}
