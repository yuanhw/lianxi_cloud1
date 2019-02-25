package lianxi.pattern.observer;

/**
 * @author wyh
 * @date 2019/2/24 1:52 PM
 */
public interface Observable {
	void addObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyAllObserver();
}
