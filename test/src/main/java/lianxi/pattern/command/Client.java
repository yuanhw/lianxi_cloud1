package lianxi.pattern.command;

/**
 * @author: WangYuanHang
 * @Description:
 * @date: 2019/2/21 10:24
 */
public class Client {

    public static void main(String[] args) {
        Receiver1 receiver1 = new Receiver1();
        Bz1Command bz1Command = new Bz1Command(receiver1);

        Receiver2 receiver2 = new Receiver2();
        Bz2Command bz2Command = new Bz2Command(receiver2);

        Invoker invoker = new Invoker();

//        invoker.setCommand(bz1Command);
//        invoker.execCommand();
//
//        invoker.setCommand(bz2Command);
//        invoker.execCommand();
        MacroCommand macroCommand = new MacroCommand(new Command[]{bz1Command, bz2Command});
        macroCommand.execute();
    }
}
