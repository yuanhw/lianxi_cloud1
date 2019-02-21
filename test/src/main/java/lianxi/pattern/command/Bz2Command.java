package lianxi.pattern.command;

/**
 * @author: WangYuanHang
 * @Description:
 * @date: 2019/2/21 11:16
 */
public class Bz2Command implements Command {
    private Receiver2 receiver2;

    public Bz2Command(Receiver2 receiver2) {
        this.receiver2 = receiver2;
    }

    @Override
    public void execute() {
        this.receiver2.doSomething();
    }
}
