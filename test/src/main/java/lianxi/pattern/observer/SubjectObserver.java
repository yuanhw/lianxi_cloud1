package lianxi.pattern.observer;

/**
 * @author wyh
 * @date 2019/2/24 1:58 PM
 */
public class SubjectObserver implements Observer{
	@Override
	public void update(String content) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("i see " + content);
	}
}
