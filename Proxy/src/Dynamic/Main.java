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

public class Main {
    public static void main(String[] args) {
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setTarget(new host());
        rent proxy=(rent) pih.getProxt();
        proxy.renthouse();
    }
}
