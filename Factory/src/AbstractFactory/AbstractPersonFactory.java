package AbstractFactory;

/**
 * @author cky
 * @create 2020 2 25 13:11
 */
public interface AbstractPersonFactory {
    public Food createFood();
    public Clothes createClothes();
}
