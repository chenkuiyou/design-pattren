/**
 *
 * 桥接模式其实为了解决 对象中属性维度的问，比如一个类A的  一种属性有n种，一种属性有m种，
 * 如果要完全表示出对象的两种属性，需要n*m个类去继承这个类的抽象类
 * 但是如果用了桥接模式， 只需要n+m个，就是可以认将类的一个维度抽象成另为外一个类B，
 * 并且在原本的类A中，将抽象出来的类B作为一个属性，在调用方法的时候，调用这个类B的方法，把类A传进去。
 *
 * 在下面举的例子中用了笔的例子， 笔有分成 大中小 三个尺寸， 还有 红绿蓝白黑5种颜色；
 * 可以将颜色抽出来， 将笔需要的颜色才能做的方法放在颜色类中，需要调用这些类的时候，
 * 就调用笔本身所带的颜色对象的方法，将笔自身传进去。
 * 参考博客https://www.cnblogs.com/WindSun/p/10260547.html
 * @author cky
 * @create 2020 02 27 19:09
 */
public class Main {
    public static void main(String[] args) {
        Pen p=new MiddlePen();
        p.setColor(new Red());
        p.draw("hello");
    }
}
abstract class Pen
{
    protected Color color;
    public void setColor(Color color)
    {
        this.color=color;
    }
    public abstract void draw(String name);
}

//扩充抽象类
class SmallPen extends Pen
{
    public void draw(String name)
    {
        String penType="小号毛笔绘制";
        this.color.bepaint(penType,name);
    }
}

//扩充抽象类
class MiddlePen extends Pen
{
    public void draw(String name)
    {
        String penType="中号毛笔绘制";
        this.color.bepaint(penType,name);
    }
}

//扩充抽象类
class BigPen extends Pen
{
    public void draw(String name)
    {
        String penType="大号毛笔绘制";
        this.color.bepaint(penType,name);
    }
}

//实现类接口
interface Color
{
    void bepaint(String penType,String name);
}

//扩充实现类
class Red implements Color
{
    public void bepaint(String penType,String name)
    {
        System.out.println(penType + "红色的"+ name + ".");
    }
}

//扩充实现类
class Green implements Color
{
    public void bepaint(String penType,String name)
    {
        System.out.println(penType + "绿色的"+ name + ".");
    }
}

//扩充实现类
class Blue implements Color
{
    public void bepaint(String penType,String name)
    {
        System.out.println(penType + "蓝色的"+ name + ".");
    }
}

//扩充实现类
class White implements Color
{
    public void bepaint(String penType,String name)
    {
        System.out.println(penType + "白色的"+ name + ".");
    }
}

//扩充实现类
class Black implements Color
{
    public void bepaint(String penType,String name)
    {
        System.out.println(penType + "黑色的"+ name + ".");
    }
}
