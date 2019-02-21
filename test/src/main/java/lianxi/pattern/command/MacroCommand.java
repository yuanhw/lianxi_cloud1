package lianxi.pattern.command;

/**
 * @author: WangYuanHang
 * @Description:
 * @date: 2019/2/21 11:21
 */
public class MacroCommand implements Command {
    private Command[] commands;

    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (int i = 0; i < this.commands.length; i++) {
            this.commands[i].execute();
        }
    }
}
