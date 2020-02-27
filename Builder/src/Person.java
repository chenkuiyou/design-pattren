import java.util.Set;

/**
 * @author cky
 * @create 2020 02 27 16:02
 */
public class Person {
    private String name;
    private int age;
    private int sex;
    private int height;
    private int weight;
    //  .... 等等好多属性；
    //在不同的时候会用到不同的属性，
    //所以不是全部属性都要进行初始化，
    //但是不可能一个一个调用set方法，
    //所以就有个建造者这个模式
    private Person(){};

    public static class  PersonBuilder{
        Person p=new Person();
        public Person build() {
            return p;
        }
        public PersonBuilder basicInfo(String s,int age,int sex){
            p.name=s;
            p.age=age;
            p.sex=sex;
            return this;
        }
        public PersonBuilder height(int height){
            p.height=height;
            return this;
        }
        public PersonBuilder weight(int weight){
            p.weight=weight;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
