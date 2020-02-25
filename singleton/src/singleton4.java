/**
 * 内部静态类的实现方式
 * @author cky
 * @create 2020 02 25 16:06
 */
public class singleton4 {
    //jvm 保证一个类之加载 切是线程安全的， 并且不会加载这个类的内部类
    //内部类只有在被用到的时候才会被加载;  所以sgl 在singleton4 被加载时才会被加载；
    private  static class  sgl{
        private final  static singleton4 INSTANCE=new singleton4();
    }
    public static singleton4 getInstance(){
        return sgl.INSTANCE ;
    }
}
