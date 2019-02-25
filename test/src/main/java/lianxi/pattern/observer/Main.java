package lianxi.pattern.observer;

/**
 * @author wyh
 * @date 2019/2/24 1:17 PM
 */
public class Main {

	public static void main(String[] args) throws Exception {
		Thread thread = new Thread(() -> {
			try {
				Subject subject = new Subject();
				SubjectObserver observer1 = new SubjectObserver();
				SubjectObserver observer2 = new SubjectObserver();
				SubjectObserver observer3 = new SubjectObserver();
				subject.addObserver(observer1);
				subject.addObserver(observer2);
				subject.addObserver(observer3);

				long startTime = System.currentTimeMillis();

				Thread.sleep(1000);
				subject.doSomething1();

				Thread.sleep(1000);
				subject.doSomething2();

				long endTime = System.currentTimeMillis();
				System.out.println("exec time: " + (endTime - startTime) + "ms");
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		thread.start();
	}
}
