package Dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author cky
 * @create 2020 03 05 12:19
 */
public class ProxyInvocationHandler  implements InvocationHandler {
    private  rent target;

    public Object getTarget() {
        return target;
    }

    public void setTarget(rent target) {
        this.target = target;
    }
    public Object getProxt(){
        //Proxy.newProxyInstance 需要三个参数 第一个是加载器，使用所代理的类的加载器就行
        //第二个需要实现的接口，
        //第三个是一个InvocationHandler 类型的对象，
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //  添加需要的操作
        logs(method.getName());
        //调用method.invoke(f,args);去执行被代理的方法，获得返回值并且返回；
        Object res=method.invoke(target,args);

        return res;
    }

    public void logs(String msg){
        System.out.println("执行了" + msg + "方法");
    }
}
