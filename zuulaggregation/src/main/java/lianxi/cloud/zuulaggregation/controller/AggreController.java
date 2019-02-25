package lianxi.cloud.zuulaggregation.controller;

import lianxi.cloud.zuulaggregation.entity.User;
import lianxi.cloud.zuulaggregation.service.AggreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;
import rx.Observer;

import java.util.HashMap;

/**
 * @author wyh
 * @date 2019/2/24 2:50 PM
 */
@RestController
public class AggreController {
	private Logger logger = LoggerFactory.getLogger(AggreService.class);

	@Autowired
	private AggreService aggreService;

	@GetMapping("aggregate/{id}")
	public DeferredResult<HashMap<String, User>> aggregate(@PathVariable Long id) {
		return this.toDeferredResult(this.aggregateById(id));
	}

	private DeferredResult<HashMap<String, User>> toDeferredResult(Observable<HashMap<String, User>> details) {
		DeferredResult<HashMap<String, User>> deferredResult = new DeferredResult<>();
		details.subscribe(new Observer<HashMap<String, User>>() {
			@Override
			public void onCompleted() {
				logger.info("完成 completed ...");
			}

			@Override
			public void onError(Throwable e) {
				logger.error("发生错误", e);
			}

			@Override
			public void onNext(HashMap<String, User> stringUserHashMap) {
				deferredResult.setResult(stringUserHashMap);
			}
		});
		return deferredResult;
	}

	private Observable<HashMap<String, User>> aggregateById(Long id) {
		return Observable.zip(this.aggreService.getMovieUserId(id), this.aggreService.getUserId(id), (movieUser, user) -> {
			HashMap<String, User> map = new HashMap<>(2);
			map.put("movie", movieUser);
			map.put("user", user);
			return map;
		});
	}
}
