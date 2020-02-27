/**
 *
 * Visitor
 * 在结构不变的情况下动态改变对元素内部的动作
 *
 * 比如有一个 对象A,他能够对外提供固定的业务，但是对于不同的来访者（visitor），他不同的业务的具体操作不同
 * 对象A所在类的提供业务是固定的，不需要或者不经常改动，那么对于来访者的不同操作，就被封装在来访者自己本身中，
 * 这样对于每次操作，就不需要修改对象A的类
 *
 * 比如现在有一个电脑类，用于卖电脑，但是来买电脑的人有很多种，比如学生，白领，企业等
 * 对于这些不同的对象，买电脑的配件有不同的优惠，那如果将这个优惠写在Computer类中，
 * 对于传进来的对象进行判断来给予优惠，那么这个代码就同等与写死的了，想要增加不同的对象，
 * 或者修改一下优惠方案，就要修改原来的类
 *
 *
 * @author cky
 * @create 2020 02 27 9:47
 */
public class Main {
    public static void main(String[] args) {
        Computer c=new Computer();
        Visitor v=new Student();
        System.out.println(v.getPrice(c));
    }
}
class Computer{
    private ComputerPatr Cpu=new Cpu();
    private ComputerPatr Memory=new Memory();
    private ComputerPatr Display=new Display();
    public void accept(Visitor visitor){
        Cpu.accept(visitor);
        Memory.accept(visitor);
        Display.accept(visitor);
    }
}
abstract  class ComputerPatr{
    public  abstract void accept(Visitor visitor) ;
    public  abstract double getPrice() ;
}
interface Visitor{
    public abstract double visitCpu(ComputerPatr c);
    public abstract double visitMemory(ComputerPatr c);
    public abstract double visitDisplay(ComputerPatr c);
    public abstract  double getPrice(Computer c);
}

class Memory extends ComputerPatr{
    @Override
    public void accept(Visitor visitor) {
        visitor.visitMemory(this);
    }
    @Override
    public double getPrice() {
        return 1000;
    }
}class Display extends ComputerPatr{
    @Override
    public void accept(Visitor visitor) {
        visitor.visitDisplay(this);
    }
    @Override
    public double getPrice() {
        return 500;
    }
}class Cpu extends ComputerPatr{
    @Override
    public void accept(Visitor visitor) {
        visitor.visitCpu(this);
    }
    @Override
    public double getPrice() {
        return 2000;
    }
}

class Student implements Visitor{
    double SumPrice;
    @Override
    public double visitCpu(ComputerPatr c) {
        //System.out.println("calc cpu ");
        SumPrice+=c.getPrice()*0.75;
        return c.getPrice()*0.75;
    }

    @Override
    public double visitMemory(ComputerPatr c) {
        SumPrice+=c.getPrice()*1;
        return c.getPrice()*1;
    }

    @Override
    public double visitDisplay(ComputerPatr c) {
        SumPrice+=c.getPrice()*0.5;
        return c.getPrice()*0.5;
    }
    @Override
    public double  getPrice(Computer computer){
        SumPrice=0;
        computer.accept(this);
        return SumPrice;
    }
}