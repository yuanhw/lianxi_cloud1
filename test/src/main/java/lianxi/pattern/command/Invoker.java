package lianxi.pattern.command;

/**
 * @author: WangYuanHang
 * @Description:
 * @date: 2019/2/21 11:17
 */
public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void execCommand() {
        this.command.execute();
    }
}
