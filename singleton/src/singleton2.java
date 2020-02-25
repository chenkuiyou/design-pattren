import java.time.Instant;

/**
 * 线程不安全的懒汉式
 * @author cky
 * @create 2020 2 25 15:55
 */
public class singleton2 {
    private singleton2(){}
    private  static singleton2 INSTANCE=null;
    public static singleton2 getInstance(){
        if(INSTANCE==null){
            try {
                //用于测试 多线程
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE=new singleton2();
        }

        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->  System.out.println( singleton2.getInstance().hashCode())).start();
        }
    }
}
