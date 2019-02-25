package lianxi.cloud.zuulaggregation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author wyh
 * @date 2019/2/24 2:38 PM
 */
@SpringBootApplication
@EnableZuulProxy
public class AggreApplication {
	public static void main(String[] args) {
		System.out.println("aggre start...");
		SpringApplication.run(AggreApplication.class, args);
		System.out.println("aggre end...");
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
