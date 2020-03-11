package SimpleFactory;

/**
 *
 * @author cky
 * @create 2020 2 25 14:15
 */
public class VehicalFactory {
    public Vehicle createVehical(String s){
        if(s.equals("Bike"))
            return new Bike();
        if(s.equals("Car"))
            return new Car();
        return null;
    }

}
