package Dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * 动态代理
 * 动态代理的实现主要是依赖 asm 的一个包 直接去操作二进制文件，
 * 因为了asm java才能被称为动态语言，能够动态生成和删除方法。
 * 反射只能读出是否具有方法，并不能体现java动态语言的特性
 *
 * 还有一种方式 是使用cglib实现，比Proxy简单，但是底层都是asm
 * 需要使用maven
 *
 * spring 的aop特性就是通过动态代理实现的
 * 可以将原本有的逻辑代码 在不修改源码的情况下进行重整代码逻辑（组合）。
 * @author cky
 * @create 2020 02 26 13:34
 */

interface  function{ public void action();}
class basicfunction implements function {
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

public class Main {
    public static void main(String[] args) {
        basicfunction bf=new basicfunction();
        //使用java 提供的动态代理模式，来形成代理；
        //相比于静态代理模式，静态代理模式需要提供一些写好的代理方法，然后层层嵌套，
        //但是方法必须是提前写好的，不能动态生成，而动态代理模式就能改变这一点，能够提供定制的代理模式
        //
        //Proxy.newProxyInstance 需要三个参数 第一个是加载器，使用所代理的类的加载器就行
        //第二个需要实现的接口，是一个接口数组，传入需要实现的接口
        //第三个是一个InvocationHandler 类型的对象，实现多层代理
        //在InvocationHandler中的invoke中写需要添加的代理需求
        //调用method.invoke(f,args);去执行被代理的方法，获得返回值并且返回；
        function f=(function) Proxy.newProxyInstance(function.class.getClassLoader(),
                new Class[]{function.class},
                new printLogFunction(bf)
        );
        f.action();
    }
}
class printLogFunction implements InvocationHandler{
    basicfunction f=null;

    public printLogFunction(basicfunction f) {
        this.f = f;
    }
    //自己定义before 和after 在invoke 之前和之后调用,减少了依赖
    public  long before(){
        System.out.println("in");
        return System.currentTimeMillis();
    }
    public long after(){
        return System.currentTimeMillis();
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start=before();
        Object o=method.invoke(f,args);
        long end=after();
        System.out.println(end - start);
        return o;
    }
}