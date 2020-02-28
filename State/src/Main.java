/**
 * 状态模式  大概就是一个Client有n种状态，也有m种行为；
 * 如果单纯去写这些东西的话，是在一个类中那个去写m中行为，去判断当前是什么状态
 * 再去做出什么行为，这样的话代码太耦合的，不利于添加新的状态
 * 要添加的话就要在m个行为的方法中逐个添加；
 * 状态模式就是 将状态抽象成一个类，放在Client中，然后将行为都卸载状态所在类中，
 * 那样的话如果是添加一种状态，就可以多写一个继承类，在这个类里面实现所有的行为方法；
 *
 * @author cky
 * @create 2020 02 28 18:48
 */
public class Main {
    public static void main(String[] args) {
        person p=new person(new happy());
        p.study();
        person p1=new person(new sad());
        p1.cry();
    }
}
class person{
    state s;
    person(state s){
        this.s=s;
    }
    public   void cry(){
        s.cry();
    }
    public   void say(){
        s.say();
    }
    public   void study(){
        s.study();
    }
}
abstract  class state{
    public abstract  void cry();
    public abstract  void say();
    public abstract  void study();
}
class happy extends  state{

    @Override
    public void cry() {
        System.out.println("高兴的哭");
    }

    @Override
    public void say() {
        System.out.println("高兴的说");
    }

    @Override
    public void study() {
        System.out.println("高兴的学习");
    }
}
class sad extends  state{

    @Override
    public void cry() {
        System.out.println("悲伤的哭");
    }

    @Override
    public void say() {
        System.out.println("悲伤的说");
    }

    @Override
    public void study() {
        System.out.println("悲伤的学习");
    }
}
