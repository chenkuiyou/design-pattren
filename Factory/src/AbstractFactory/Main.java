package AbstractFactory;

/**
 * 抽象工厂模式主要针对  抽象工厂 抽象产品（类）  具体工厂 具体产品（类）展开。
 * 形容词用 接口和抽象类， 名词用类
 *
 * 拓展产品族的工厂模式    这类工厂能生产 对应的族 需要的产品
 * 例如 有产品为 人 共有两种人  分为地球人 外星人等；
 *      都有 衣服穿，吃的东西
 *然后  对于衣服和吃的东西而言，地球人和外星人的实现方式不同，但是都是  属于衣服类或者 食品类
 * 所以  EarthClothes 和AlineClithes 都继承与Clothes   food同理
 *      对于工厂而言， 不管是地球人的工厂还是外星人都要能够生产 衣服和食物
 *      所以有一个 AbstractPersonFactory 的接口 ，用来给  EarthPersonFactory  和AlinePersonFactory 继承
 *      规定这个工厂能够生产 出衣服和食物，只是针对的人不同；
 *
 * 抽象工厂能很好的解决 不同种类对象的需求问题， 但是如果需求增加了之后，就需要改很多的代码
 *
 *
 *
 * @author cky
 * @create 2020 2 25 13:05
 */
public class Main {
    public static void main(String[] args) {
        AbstractPersonFactory f=new EarthPersonFactory();
        Clothes clothes = f.createClothes();
        clothes.show();
        f.createFood().show();

        AbstractPersonFactory f1=new AlinePersonFactory();
        f1.createFood().show();

    }
}
