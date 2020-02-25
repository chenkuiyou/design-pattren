package SimpleFactory;

/**
 *
 * @author cky
 * @create 2020 2 25 14:15
 */
public class VehicalFactory {
    public Vehicle createCar(){
        System.out.println("create simple car");
        return new Car();
    }
    //这边只是表示成能够定制的过程
    public Vehicle createComplexCar(){
        System.out.println("create complex car");
        return new Car();
    }
    //
    public Vehicle createBike(){
        System.out.println("create simple Bike");
        return new Bike();
    }
    //这边只是表示成能够定制的过程
    public Vehicle createComplexBike(){
        System.out.println("create complex Bike");
        return new Bike();
    }
}
