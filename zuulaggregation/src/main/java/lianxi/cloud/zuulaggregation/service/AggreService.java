package lianxi.cloud.zuulaggregation.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lianxi.cloud.zuulaggregation.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

import java.math.BigDecimal;

/**
 * @author wyh
 * @date 2019/2/24 2:41 PM
 */
@Service
public class AggreService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallback")
	public Observable<User> getUserId(Long id) {
		return Observable.create(observer -> {
			User user = restTemplate.getForObject("http://user-service/user/{id}", User.class, id);
			observer.onNext(user);
			observer.onCompleted();
		});
	}

	@HystrixCommand(fallbackMethod = "fallback")
	public Observable<User> getMovieUserId(Long id) {
		return Observable.create(observer -> {
			User user = restTemplate.getForObject("http://movie-service/movie/user/{id}", User.class, id);
			observer.onNext(user);
			observer.onCompleted();
		});
	}

	public User fallback(Long id) {
		return new User(0L, "---", "---", 0, BigDecimal.valueOf(0));
	}
}
