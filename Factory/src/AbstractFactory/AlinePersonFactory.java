package AbstractFactory;

/**
 * @author cky
 * @create 2020 2 25 13:46
 */
public class AlinePersonFactory implements AbstractPersonFactory{
    public Food createFood() {
        return new AlineFood();
    }

    public Clothes createClothes() {
        return new AlienClothes();
    }
}
