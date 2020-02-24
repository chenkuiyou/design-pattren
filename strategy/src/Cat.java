/**
 * @author cky
 * @create 2020 2 24 20:18
 */
public class Cat {
    String name;
    int weight;
    int height;
    Cat(){}

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }

    public Cat(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Cat(String name, int weight, int height) {
        this.name = name;
        this.weight = weight;
        this.height = height;
    }
}
