/**
 * 原型模式；也叫克隆模式
 * 其实就是类似于C++的重写==操作运算符；
 * 克隆模式只会将原来的地址copy到一个新new出来的对象，如果一个对象中有一个对象，
 * 如果也想拷贝，就要从写那个对象的clone接口
 * 通过继承cloneable
 *
 * @author cky
 * @create 2020 02 28 14:36
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        person p=new person("cky",21, new location(10,10));
        person p1=(person) p.clone();
        System.out.println(p1);;
        System.out.println(p);
    }
}
class person implements  Cloneable{
    String name;
    int age;
    location loc;

    public person() {
    }

    public person(String name, int age, location loc) {
        this.name = name;
        this.age = age;
        this.loc = loc;
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        person res= (person) super.clone();
        res.loc=(location) this.loc.clone();
        return res;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", loc=" + loc +
                '}'
                +super.toString();
    }
}
class location implements Cloneable{
    int x;
    int y;

    public location() {
    }

    public location(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    @Override
    public String toString() {
        return "location{" +
                "x=" + x +
                ", y=" + y +
                '}'
                +super.toString();
    }
}
