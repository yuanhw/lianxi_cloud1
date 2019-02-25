package lianxi.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wyh
 * @date 2019/2/24 1:53 PM
 */
public class Subject implements Observable {

	private List<Observer> list = new ArrayList<>();

	@Override
	public void addObserver(Observer observer) {
		list.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		list.remove(observer);
	}

	@Override
	public void notifyAllObserver() {
		list.forEach(observer -> {
			new Thread(() -> observer.update("update: " + observer)).start();
		});
	}

	public void doSomething1() {
		System.out.println("i am doing 1.");
		this.notifyAllObserver();
	}

	public void doSomething2() {
		System.out.println("i am doing 2.");
		this.notifyAllObserver();
	}
}
