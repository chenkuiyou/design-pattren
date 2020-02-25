package SimpleFactory;

/**
 * 拓展产品维度的工厂模式
 * 工厂模式的本质就是用工厂方法代替new操作创建一种实例化对象的方式。
 * 一句话中总结就是方便创建 同种类型接口产品 的 复杂对象
 * @author cky
 * @create 2020 2 25 13:06
 */
public class Main {
    public static void main(String[] args) {
        VehicalFactory f=new VehicalFactory();
        Vehicle complexBike = f.createComplexBike();
        Vehicle car = f.createCar();
    }
}
