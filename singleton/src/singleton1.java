/**
 *单例模式需要生成一些唯一的对象
 * 例如 工厂模式 中的工厂，只要生成一次就够了
 *
 * 饿汉式
 * 线程安全，通过jvm加载
 * 在不使用的时候加载，浪费资源
 * @author cky
 * @create 2020 2 25 15:51
 */
public class singleton1 {
    private singleton1(){}
    private  static  final  singleton1 INSTANCE=new singleton1();
    public static singleton1 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println(singleton1.getInstance() == singleton1.getInstance());
    }

}
