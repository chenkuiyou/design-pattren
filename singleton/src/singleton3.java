/**
 * 多线程安全的 在锁前锁后都进行了检查
 * @author cky
 * @create 2020 2 25 16:02
 */
public class singleton3 {
    private singleton3(){}
    //阻止指令重排
    private  static  volatile singleton3 INSTANCE=null;
    public static singleton3 getInstance(){
        if(INSTANCE==null){
            synchronized (singleton3.class){
                if(INSTANCE==null){
                    try {
                        //用于测试 多线程
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE=new singleton3();
                }
            }
        }
        return INSTANCE;
    }
}
