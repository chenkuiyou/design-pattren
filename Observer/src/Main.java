import java.util.ArrayList;
import java.util.Date;

/**
 *
 * 观察者模式，
 * 有三个元素： 事件，事件源， 和观察者（listener observer hook  callback 都指观察者）
 *
 * 应用场景
 * 比如现在有一个婴儿在哭 家里人看到了都要做出反应 比如 爸爸 妈妈 宠物狗等；
 * 他们看到baby在哭，都会做出一定的行为
 * 在这里 宝宝是事件源， 时间是宝宝哭， 观察者是 爸爸 妈妈 宠物狗等；
 *
 * 要清楚两点， 观察者不止能处理宝宝哭这件事情，还能处理很多事情， 所以要有事件
 * 事件就是用于记录发生的事情，必要情况下也可以记录事件源。
 * 在触发观察者的处理事件的函数应该放在事件源里面。
 * 观察者有不同的类型，但是要求能够处理一类事件，所以观察者要实现处理事件的接口。
 * 许多框架中就使用了这个模式 ，前端js中的event
 * @author cky
 * @create 2020 02 26 9:49
 */
public class Main {
    public static void main(String[] args) {
        Baby baby=new Baby();
        baby.wakeUp();
    }
}
//观察者有不同的类型，但是要求能够处理一类事件，所以观察者要实现处理事件的接口。
interface Observer{ public abstract void  actionOnWakeUP(cryEvent e); }
abstract class event<T>{ public abstract  T getResource();};
class cryEvent extends event<Baby>{
//    事件就是用于记录发生的事情，必要情况下也可以记录事件源。
    Baby baby=null;
    Date time=null;

    public cryEvent(Baby baby, Date time) {
        this.baby = baby;
        this.time = time;
    }

    @Override
    public Baby getResource() {
        return baby;
    }
}
class Baby{
    ArrayList<Observer> list=new ArrayList<>();
    boolean isCry=false;
    String loc=null; //
    {
        list.add(new father());
        list.add(new mother());
    }
    void wakeUp(){
        //在触发观察者的处理事件的函数应该放在事件里面。
        cryEvent e=new cryEvent(this,new Date() );
        isCry=true;
        for(Observer o:list){
            o.actionOnWakeUP(e);
        }
    }
}
//观察者有不同的类型，但是要求能够处理一类事件，所以观察者要实现处理事件的接口。
class father implements Observer {

    @Override
    public void actionOnWakeUP(cryEvent e) {
        System.out.println("father in");
    }
}
class mother implements Observer {

    @Override
    public void actionOnWakeUP(cryEvent e) {
        System.out.println(e.getResource());
        System.out.println("mother in");
    }
}
