package AbstractFactory;

/**
 * @author cky
 * @create 2020 2 25 13:13
 */
public class EarthPersonFactory implements AbstractPersonFactory{
    public Food createFood() {
        return new EatrhFood();
    }

    public Clothes createClothes() {
        return new EarthClothes();
    }
}
