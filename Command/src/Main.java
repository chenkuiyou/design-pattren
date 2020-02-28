/**
 * 命令模式
 * 命令模式    Command: 抽象命令类  ConcreteCommand: 具体命令类
 * Invoker: 调用者   Receiver: 接收者  Client:客户类  这几个类
 *  具体的关系是在  Invoker 中有很多个 Command 的对象
 *  Command将 Receiver 的对象作为自己的参数，并且实现了对 Receiver 的exce执行操作
 *  如果Client要执行A命令，则调用自己的A命令方法，可能这个命令需要很多个Command去执行；
 *  但是被封装在A命令方法中，剩下的交给command去执行，command中也有需要操作的 Receiver对象，
 *  Receiver对象可以再将本身的方法提供出来，给command去调用，
 *
 *  这样来说减少了 Client和Receiver 之间的紧密联系  降低了耦合
 *  对于正常的操作来说，一般都是谁（Client）对谁（Receiver）要做什么（command）
 *  现在变成了 Client 要实现什么（调用方法）；
 *
 * 例子 电视遥控作为 Client , 电视作为 Receiver ；Command 就是电视和电视遥控之间的媒介
 * 一般电视遥控在买来的时候就有指定是操作哪个电视的，相当于 在command中指定的receiver
 *
 * 使用场景
 * 1.系统需要将请求调用者和请求接收者解耦，使得调用者和接收者不直接交互。
 * 2.系统需要在不同的时间指定请求、将请求排队和执行请求。
 * 3.系统需要支持命令的撤销(Undo)操作和恢复(Redo)操作（可以搭配责任链来使用 记录下操作，支持修改和删除）。
 * 4.系统需要将一组操作组合在一起，即支持宏命令  （可以搭配组合模式来使用 树状结构，）。
 * 参考链接https://www.cnblogs.com/shoshana-kong/p/10803553.html
 * @author cky
 * @create 2020 02 28 10:57
 */
public class Main {
    public static void main(String[] args) {
        Command openCommand, closeCommand, changeCommand;
        //给指令规定接收对象
        openCommand = new OpenTvCommand();
        closeCommand = new CloseTvCommand();
        changeCommand = new ChangeChannelCommand();

        //给client添加指令
        Controller controller = new Controller(openCommand, closeCommand, changeCommand);

        controller.open();
        controller.change();
        controller.close();
    }
}
interface Command {
    public void execute();
}
class Television {
    //电视自己提供了方法给command使用
    public void open() {
        System.out.println("打开电视机......");
    }

    public void close() {
        System.out.println("关闭电视机......");
    }

    public void changeChannel() {

        System.out.println("切换电视频道......");
    }
}
class Controller {

    private Command openTVCommand;
    private Command closeTVCommand;
    private Command changeChannelCommand;

    public Controller(Command openTvCommand, Command closeTvCommand, Command changeChannelCommand) {
        this.openTVCommand = openTvCommand;
        this.closeTVCommand = closeTvCommand;
        this.changeChannelCommand = changeChannelCommand;
    }

    public void open() {
        openTVCommand.execute();
    }

    public void close() {
        closeTVCommand.execute();
    }

    public void change() {

        changeChannelCommand.execute();
    }
}
class OpenTvCommand implements Command {
    private Television tv;

    public OpenTvCommand() {
        this.tv = new Television();
    }

    @Override
    public void execute() {
        tv.open();
    }
}
class ChangeChannelCommand implements Command {
    private Television tv;

    public ChangeChannelCommand() {
        tv = new Television();
    }

    public void execute() {
        tv.changeChannel();
    }

}
class CloseTvCommand implements Command {
    private Television tv;

    public CloseTvCommand() {
        tv = new Television();
    }

    public void execute() {
        tv.close();
    }

}
