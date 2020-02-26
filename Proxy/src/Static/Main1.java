package Static;

import java.util.Random;

/**
 * 静态代理模式
 * 比如现在有个需求  测试已经写好的一个方法所花的时间 ，打印日志，等
 * 而且要求不改变原来的代码， 应该怎么做。
 * 可以新定义一个方法中直接，在方法前面调用时间戳，然后相减，但是这样不适合进行拓展。
 * 如果再添加一个需求在 获取所花时间方法之上，就要再次添加一个方法， 或者将两个需求相反过来，
 * 这样就有很多排列组合，需要添加很多方法。
 * 这个时候就要使用静态代理模式。
 *
 * 类似于一层层的中介 ==》  客户-》代理1（添加需求A）-》代理2（添加需求B）....-》最原始的硬件
 *
 * 需求的顺序可以改变，但是需求也是固定的几种(写死的)
 *
 * @author cky
 * @create 2020 02 26 12:31
 */

interface  function{ public void action();}
class basicfunction implements function{
    @Override
    public void action() {
        try {
            System.out.println("basic func");
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public basicfunction() {
    }
}
class getTimeFunction implements function{
    function func=null;

    public getTimeFunction(function f) {
        this.func = f;
    }
    @Override
    public void action() {
        long start=System.currentTimeMillis();
        func.action();
        long end=System.currentTimeMillis();
        System.out.println(end - start);
    }
}

class printLogFunction implements function{
    function func=null;

    public printLogFunction(function f) {
        this.func = f;
    }
    @Override
    public void action() {
        System.out.println("func start");
        func.action();
        System.out.println("func end");
    }
}
public class Main1 {
    public static void main(String[] args) {
        //通过这样的方式，在面对多种定制条件的时候，不需要去改变原来的代码，就能够实现
        new getTimeFunction(new printLogFunction(new basicfunction())).action();
        System.out.println("-------------");
        new printLogFunction(new getTimeFunction(new basicfunction())).action();
    }
}
