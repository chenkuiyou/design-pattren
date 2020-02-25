/**
 * 利用枚举类来写单例模式
 * 具体看单例的语法格式，只是省略了很多东西，单例的变量初始化时在定义时，不需要构造函数
 * @author cky
 * @create 2020 02 25 16:16
 */
public enum singleton5 {
    INSTANCE;
    ///结束了。。。

    public void m(){System.out.println("111");}

    public static void main(String[] args) {

        singleton5.INSTANCE.m();
        for (int i = 0; i < 100; i++) {
            new Thread(()->  System.out.println( singleton5.INSTANCE.hashCode()  )).start();
        }

    }
}
