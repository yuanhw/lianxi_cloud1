package lianxi.pattern.command;

/**
 * @author: WangYuanHang
 * @Description:
 * @date: 2019/2/21 11:15
 */
public class Bz1Command implements Command {
    private Receiver1 receiver1;

    public Bz1Command(Receiver1 receiver1) {
        this.receiver1 = receiver1;
    }

    @Override
    public void execute() {
        this.receiver1.doSomething();
    }
}
